package edu.thangiah.action;

import java.util.Map;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

import edu.thangiah.permission.RoleDao;
import edu.thangiah.user.UserBo;
import edu.thangiah.user.entity.User;

/**
 * AbstractAction serves as the foundation for all Action classes within the ERS framework.  Any classes wishing to utilize session
 * and user authentication functionality must extend either this class, or one of its children.
 * @author Kelly
 *
 */
public abstract class AbstractAction extends ActionSupport implements Preparable{

	private static final long serialVersionUID = 1L;
	
	protected User currentUser;
	private boolean loggedIn = true;
	private Map<String, Object> currentSession;
	
	private String loginUrl = "/"; // defaults to homepage.
	
	private static final Logger LOGGER = Logger.getLogger(AbstractAction.class.getName());
	
	public static final String DB_ERROR_MESSAGE = "Problem connecting with database.  Please try again.";
	public static final String NO_SESSION_MESSAGE = "Session has not been initialized.";
	public static final String SESSION_ID_KEY = "sessionId";
	public static final String USER_SESSION_KEY = "sessionUser";
	
	
	@Autowired
	protected RoleDao roleDao;
	
	
	@Autowired
	protected UserBo userBo;
	
	/**
	 * This method runs before execute() and is used for setting up the class for a given request.  This is where
	 * user session/authentication information is initialized from the data 
	 */
	@Override
	public void prepare() throws Exception {
		this.clearErrors(); // Prevents errors from persisting across multiple submits.
		
		currentSession = ActionContext.getContext().getSession();
		String sessionId = (String) currentSession.get(SESSION_ID_KEY);
		
		this.setLoggedIn(checkLogin(sessionId));
		
	}
	
	// Retrieves login redirect information for proper redirection after login.
	protected void invokeLoginRedirect(){
		if( currentSession != null ){
			this.setLoginUrl((String) currentSession.get("loginRedirect"));
			currentSession.put("loginRedirect", null); // clear the redirect information
		} else{
			LOGGER.error(NO_SESSION_MESSAGE + " Unable to initialize login redirection.");
		}
	}
	
	protected boolean logoutUser(){
		setLoggedIn(false);
		currentUser = null;
		currentSession.put(SESSION_ID_KEY, null);
		
		return true;
	}
	
	private boolean checkLogin(String sessionId){
		if( currentSession.containsKey(SESSION_ID_KEY) && currentSession.containsKey(USER_SESSION_KEY) ){
			currentUser = (User) currentSession.get(USER_SESSION_KEY);
			return true;
		}
		
		return false;
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
	
	public User getCurrentUser(){
		return currentUser;
	}


	public Map<String, Object> getCurrentSession() {
		return currentSession;
	}

	public String getLoginUrl() {
		return loginUrl;
	}

	private void setLoginUrl(String loginUrl) {
		this.loginUrl = loginUrl;
	}
	

	public UserBo getUserBo() {
		return userBo;
	}

	public void setUserBo(UserBo userBo) {
		this.userBo = userBo;
	}
	
	public RoleDao getRoleDao() {
		return roleDao;
	}

	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}
	
}
