package edu.thangiah.action;

import java.util.List;
import java.util.Map;

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
	private boolean loggedIn = false;
	
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
		
		Map<String, Object> session = ActionContext.getContext().getSession();
		String sessionId = (String) session.get("sessionId");
		
		this.setLoggedIn(checkLogin(sessionId));
		this.isLoggedIn();
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
	
}
