package edu.thangiah.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

import edu.thangiah.action.AbstractAction;

/**
 * RequireLoginInterceptor is invoked within struts.xml on any action that requires a user to be logged in to access.  If the current
 * user is not logged in, they will be redirected to a login page.
 * @author Kelly Smith
 *
 */
public class RequireLoginInterceptor implements Interceptor {
	private static final long serialVersionUID = -5372938707215213072L;
	
	private static final Logger LOGGER = Logger.getLogger(RequireLoginInterceptor.class.getName());
	private Map<String, Object> currentSession;
	
	private static final boolean DEBUG = false;
	
	@Override
	public void destroy() {
		LOGGER.debug("Destroying RequireLogin Interceptor.");
	}

	@Override
	public void init() {
		LOGGER.debug("Initializing RequireLogin Interceptor.");
	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		currentSession = invocation.getInvocationContext().getSession();
		if( DEBUG || (currentSession.containsKey(AbstractAction.SESSION_ID_KEY) && currentSession.containsKey(AbstractAction.USER_SESSION_KEY)) ){
			return invocation.invoke();
		}
		else{
			this.initializeLoginRedirect();
			return Action.LOGIN;
		}
	}
	
	private void initializeLoginRedirect(){
		if( currentSession != null ){
			HttpServletRequest request = ServletActionContext.getRequest();
			String url = request.getServletPath();
			currentSession.put("loginRedirect", url);
		} else{
			LOGGER.error(AbstractAction.NO_SESSION_MESSAGE + " Unable to initialize login redirection.");
		}
	}
}
