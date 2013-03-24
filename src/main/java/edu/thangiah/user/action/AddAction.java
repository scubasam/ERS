package edu.thangiah.user.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import com.opensymphony.xwork2.Preparable;

import edu.thangiah.user.UserBo;
import edu.thangiah.user.entity.User;
import edu.thangiah.utility.RandomString;
import edu.thangiah.utility.UtilityFunctions;

public class AddAction extends UserAction implements Preparable{
	
	private static final long serialVersionUID = 1L;
	private User userBean;
	
	@Autowired
	private UserBo userBo;
	
    @Override
    public String execute() throws Exception{
    	
    	if (userBo == null) {
            this.addActionError(DB_ERROR_MESSAGE);
        }
        User user = userBean;
	        
        RandomString rand = new RandomString(16);
        String salt = rand.nextString();
        user.setSalt(salt);
        
        // salt and encrypt the password for the database.
        salt = salt + user.getPassword();
        user.setPassword(UtilityFunctions.sha1(salt));

        user.setSessionId("");
        
        LOGGER.debug("Add user: " + user.toString());
        userBo.add(user);
        
        return SUCCESS;
    }
    
    // called automatically
    public void validate(){
    	if( userBean.getUsername() == null || userBean.getUsername().length() == 0 )
    		this.addFieldError("userBean.username", "Username is a required field.");
    	
    	if( userBean.getPassword() == null || userBean.getPassword().length() < User.minPasswordLength ){
    		this.addFieldError("userBean.password", "Password must be at least " + User.minPasswordLength + " characters in length.");
    	}
    	
    	List<User> users = userBo.findByUsername(userBean.getUsername());
    	if( users.size() > 0 ){
    		this.addFieldError("userBean.username", "Username must be unique.");
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
