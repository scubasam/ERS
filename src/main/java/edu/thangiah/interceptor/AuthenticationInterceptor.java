package edu.thangiah.interceptor;

import java.util.List;
import java.util.Map;







import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

import edu.thangiah.permission.Permission;
import edu.thangiah.permission.PermissionController;
import edu.thangiah.permission.PermissionDao;
import edu.thangiah.user.UserBo;
import edu.thangiah.user.entity.User;
import edu.thangiah.utility.RandomString;
import edu.thangiah.action.AbstractAction;

/**
 * AuthenticationInterceptor implements all authentication functionality for the user authentication system.  It determines whether a
 * user is currently logged in, and manages session information.
 * @author Kelly Smith
 *
 */
public class AuthenticationInterceptor implements Interceptor {
	private static final long serialVersionUID = -5372938707215213072L;
	
	private static final Logger LOGGER = Logger.getLogger(AuthenticationInterceptor.class.getName());
	
	@Autowired
	protected UserBo userBo;
	
	@Autowired
	protected PermissionDao permissionDao;
	
	private Map<String, Object> currentSession;
	private User currentUser;
	
	private boolean hasError = false;
	private String errorMessage = "";
	
	private static final String PERMISSION_DENIED = "permission";

	@Override
	public void destroy() {
		LOGGER.debug("Destroying Authentication Interceptor.");
	}

	@Override
	public void init() {
		LOGGER.debug("Initializing Authentication Interceptor.");
	}

	/**
	 * This method is called by any action that invokes the authIntercept stack.  It validates the current logged in user and maintains
	 * session information.  Additionally it also performs permission validation on each page and redirects to a permission denied page
	 * on failure.
	 */
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		
		currentSession = invocation.getInvocationContext().getSession();
		String sessionId = (String) currentSession.get(AbstractAction.SESSION_ID_KEY);
		String result;
		if( userBo != null ){
			result = validateLogin(sessionId);
			if( !result.equals(Action.SUCCESS) )
				currentUser = null;
        	
        	// Perform permission calculation
        	result = Action.ERROR; // Default to permission denied if no calculation is performed.
        	if( invocation != null ){
    			String actionName = invocation.getAction().getClass().getName();
    			result = calculatePermissions(actionName);
    		}
        	
            if( result.equals(Action.SUCCESS) )
            	return invocation.invoke();
            else
            	return result;
		}
		
		// Action did not set up userBo bean to do authentication
		return Action.ERROR;
	}
	
	/**
	 * Finds the user that has the specified sesionId, and verifies whether or not they exist.  If they do,
	 * it generates a new session id and stores it back in the database.  Additionally, this method updates
	 * the current session information to reflect this change.
	 * @param sessionId The current logged in users' session id for database lookup.
	 * @return SUCCESS or ERROR
	 * @throws Exception 
	 */
	private String validateLogin(String sessionId)
			throws Exception {
		User user;
		
		List<User> users = userBo.findBySessionId(sessionId);
		if( users == null || users.size() != 1 ){
			currentSession.put(AbstractAction.SESSION_ID_KEY, null);
			currentSession.put(AbstractAction.USER_SESSION_KEY, null);
			return Action.ERROR;
		}
		
		RandomString rand = new RandomString(64);
		user = users.get(0);
		String newSessionId = rand.nextString();
		user.setSessionId(newSessionId);
		userBo.update(user);
		
		currentSession.put(AbstractAction.SESSION_ID_KEY, newSessionId);
		currentSession.put(AbstractAction.USER_SESSION_KEY, user);
		
		this.currentUser = user;
		
		return Action.SUCCESS;
	}
	
	/**
	 * Determines whether the current logged in user has permission to view the specified action using the permissions framework.
	 * @param actionName A unique identifier for the action being accessed.  These action names are stored in the database in the permissions table.
	 * @return SUCCESS or PERMISSION_DENIED
	 */
	public String calculatePermissions(String actionName){
		List<Permission> permissions = permissionDao.findById(actionName);
		if( permissions != null && permissions.size() == 1 ){
			Permission permission = permissions.get(0);
			PermissionController controller = new PermissionController(currentUser, actionName, permission);
			boolean result = controller.calculatePermission();
			if( result || currentUser == null ){
				return Action.SUCCESS;
			}
			else{
				return PERMISSION_DENIED;
			}
		}
		else{
			addErrorMessage("Unabled to get permission information from database for this action.");
			LOGGER.error(this.errorMessage);
			return Action.SUCCESS;
		}
	}
	
	private void addErrorMessage(String message){
		this.errorMessage += " " + message;
		if( !this.hasError ){
			this.hasError = true;
		}
	}

	public UserBo getUserBo() {
		return userBo;
	}

	public void setUserBo(UserBo userBo) {
		this.userBo = userBo;
	}

	public PermissionDao getPermissionDao() {
		return permissionDao;
	}

	public void setPermissionDao(PermissionDao permissionDao) {
		this.permissionDao = permissionDao;
	}
}
