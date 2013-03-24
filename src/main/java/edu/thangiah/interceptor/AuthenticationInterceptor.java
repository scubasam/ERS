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
	private String loginUrl = "/"; // defaults to homepage.

	@Override
	public void destroy() {
		LOGGER.debug("Destroying Authentication Interceptor.");
	}

	@Override
	public void init() {
		LOGGER.debug("Initializing Authentication Interceptor.");
	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		currentSession = invocation.getInvocationContext().getSession();
		String sessionId = (String) currentSession.get(AbstractAction.SESSION_ID_KEY);
		User user;
		if( userBo != null ){
			List<User> users = userBo.findBySessionId(sessionId);
			if( users == null || users.size() != 1 ){
				currentSession.put(AbstractAction.SESSION_ID_KEY, null);
	        	currentSession.put(AbstractAction.USER_SESSION_KEY, null);
	        	return invocation.invoke();
			}
			
			RandomString rand = new RandomString(64);
			user = users.get(0);
			String newSessionId = rand.nextString();
        	user.setSessionId(newSessionId);
        	userBo.update(user);
        	
        	currentSession.put(AbstractAction.SESSION_ID_KEY, newSessionId);
        	currentSession.put(AbstractAction.USER_SESSION_KEY, user);
            
            return invocation.invoke();
		}
		
		// Action did not set up userBo bean to do authentication
		return Action.ERROR;
	}

	public UserBo getUserBo() {
		return userBo;
	}

	public void setUserBo(UserBo userBo) {
		this.userBo = userBo;
	}

	/**
	 * @return the loginUrl
	 */
	public String getLoginUrl() {
		return loginUrl;
	}

	/**
	 * @param loginUrl the loginUrl to set
	 */
	public void setLoginUrl(String loginUrl) {
		this.loginUrl = loginUrl;
	}
}
