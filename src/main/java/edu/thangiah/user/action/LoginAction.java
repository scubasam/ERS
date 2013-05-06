package edu.thangiah.user.action;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.Preparable;

import edu.thangiah.user.UserBo;
import edu.thangiah.user.entity.User;
import edu.thangiah.utility.RandomString;
import edu.thangiah.utility.UtilityFunctions;

public class LoginAction extends UserAction implements Preparable{
	
	private static final long serialVersionUID = 1L;
	private User userBean;
	
	private static final String invalidLoginMessage = "Invalid username/password combination.";
	
	@Autowired
	private UserBo userBo;
	
    @Override
    public String execute() throws Exception{
    	
    	if (userBo == null) {
            this.addActionError("Problem connecting with database.");
        }
        List<User> users = userBo.findByUsername(userBean.getUsername());
        
    // No user exists with that username
        if( users == null || users.size() == 0 ){
        	this.addActionError(invalidLoginMessage);
        	return INPUT;
        }
        
        if( users.size() != 1 ){
        	this.addFieldError("userBean.username", "An error occured.  More than one user matches that username.");
        	return INPUT;
        }
        
        User user = users.get(0);
        String salt = user.getSalt();
        salt = salt + userBean.getPassword(); // Salt the password
        String hashed = UtilityFunctions.sha1(salt);
        
        if( hashed.equals(user.getPassword()) ){
        	// User has successfully logged in.
        	RandomString rand = new RandomString(64);
        	String sessionId = rand.nextString();
        	user.setSessionId(sessionId);
        	userBo.update(user);
        	
        	Map<String, Object> session = ActionContext.getContext().getSession();
            session.put(SESSION_ID_KEY, sessionId);
            session.put(USER_SESSION_KEY, user);
            
            this.currentUser = user;
            this.setLoggedIn(true);
        	
            this.invokeLoginRedirect(); // initilizes this.loginUrl with the correct redirection url to be used by the struts action.
        	return SUCCESS;
        }
        else{
        	// Invalid login.
        	this.addActionError(invalidLoginMessage);
        	return INPUT;
        }
    }
    
    // called automatically
    public void validate(){
    	if( userBean.getUsername() == null || userBean.getUsername().length() == 0 )
    		this.addFieldError("userBean.username", "Username is a required field.");
    	
    	if( userBean.getPassword() == null || userBean.getPassword().length() == 0 ){
    		this.addFieldError("userBean.password", "Password is a required field.");
    	}
    }
    
	public User getUserBean() {
		return userBean;
	}
	public void setUserBean(User userBean) {
		this.userBean = userBean;
	}

	public UserBo getUserBo() {
		return userBo;
	}

	public void setUserBo(UserBo userBo) {
		this.userBo = userBo;
	}
	
}