package edu.thangiah.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

import edu.thangiah.user.UserBo;
import edu.thangiah.user.entity.User;
import edu.thangiah.utility.RandomString;

public abstract class AbstractAction extends ActionSupport implements Preparable{

	private static final long serialVersionUID = 1L;
	
	protected User currentUser;
	private boolean loggedIn = true;
	private boolean loginRedirectInitialized = false;
	private Map<String, Object> currentSession;
	
	private String loginUrl = "/"; // defaults to homepage.
	
	private static final Logger LOGGER = Logger.getLogger(AbstractAction.class.getName());
	
	public static final String DB_ERROR_MESSAGE = "Problem connecting with database.  Please try again.";
	public static final String NO_SESSION_MESSAGE = "Session has not been initialized.";
	public static final String SESSION_ID_KEY = "sessionId";
	
	
	@Autowired
	protected UserBo userBo;
 
    public UserBo getUserBo() {
        return userBo;
    }
 
    public void setUserBo(UserBo userBo) {
        this.userBo = userBo;
    }

	@Override
	public void prepare() throws Exception {
		this.clearErrors(); // Prevents errors from persisting accross multiple submits.
		
		currentSession = ActionContext.getContext().getSession();
		String sessionId = (String) currentSession.get(SESSION_ID_KEY);
		
		this.setLoggedIn(checkLogin(sessionId));
		
	}
	
	// Sets up session information to redirect back to the previous page after a successful login.
	protected void initializeLoginRedirect(){
		if( currentSession != null ){
			HttpServletRequest request = ServletActionContext.getRequest();
			String url = request.getServletPath();
			currentSession.put("loginRedirect", url);
		} else{
			LOGGER.error(NO_SESSION_MESSAGE + " Unable to initialize login redirection.");
		}
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
		User user;
		if( userBo != null ){
			List<User> users = userBo.findBySessionId(sessionId);
			if( users == null || users.size() != 1 ){
				return false;
			}
			
			RandomString rand = new RandomString(64);
			user = users.get(0);
			String newSessionId = rand.nextString();
        	user.setSessionId(newSessionId);
        	userBo.update(user);
        	
        	Map<String, Object> session = ActionContext.getContext().getSession();
            session.put("sessionId", newSessionId);
            
            this.currentUser = user;
            return true;
		}
		
		// Action did not set up userBo bean to do authentication
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

	public boolean isLoginRedirectInitialized() {
		return loginRedirectInitialized;
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
	
}
