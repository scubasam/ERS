package edu.thangiah.user.action;

import java.util.List;


import com.opensymphony.xwork2.Preparable;

import edu.thangiah.user.entity.User;
import edu.thangiah.utility.RandomString;
import edu.thangiah.utility.UtilityFunctions;

public class AddAction extends UserAction implements Preparable{
	
	private static final long serialVersionUID = 1L;
	private User userBean;
	
    @Override
    public String execute() throws Exception{
    	
    	if (userBo == null) {
            this.addActionError("Problem connecting with database.");
        }
        
        List<User> users = userBo.findByUsername(userBean.getUsername());
        if( users.size() == 0 ){
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
        } else {
        	this.addFieldError("userBean.username", "Username must be unique.");
        }
        
        if( this.hasErrors() )
        	return INPUT;
        
        return SUCCESS;
    }
    
	public User getUserBean() {
		return userBean;
	}
	public void setUserBean(User userBean) {
		this.userBean = userBean;
	}
	
}
