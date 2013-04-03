package edu.thangiah.interceptor;

import java.util.List;
import java.util.Map;



import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

import edu.thangiah.user.UserBo;
import edu.thangiah.user.entity.User;
import edu.thangiah.utility.RandomString;
import edu.thangiah.action.AbstractAction;

public class AuthenticationInterceptor implements Interceptor {
	private static final long serialVersionUID = -5372938707215213072L;
	
	private static final Logger LOGGER = Logger.getLogger(AuthenticationInterceptor.class.getName());
	
	@Autowired
	protected UserBo userBo;
	
	private Map<String, Object> currentSession;

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
				return invocation.invoke();
        	
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
		return Action.SUCCESS;
	}
	
	public String calculatePermissions(String actionName){
		
		
		return Action.SUCCESS;
	}

	public UserBo getUserBo() {
		return userBo;
	}

	public void setUserBo(UserBo userBo) {
		this.userBo = userBo;
	}
}
