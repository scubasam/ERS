package edu.thangiah.user.action;

import java.util.ArrayList;
import java.util.List;





import com.opensymphony.xwork2.Preparable;

import edu.thangiah.permission.Role;
import edu.thangiah.user.entity.User;
import edu.thangiah.utility.RandomString;
import edu.thangiah.utility.UtilityFunctions;

public class AddAction extends AddFormAction implements Preparable{
	
	private static final long serialVersionUID = 1L;
	private User userBean;
	private String userRoles;
	private ArrayList<Role> parsedRoles = new ArrayList<Role>();
	
    @Override
    public String execute(){
    	String result = super.execute();
    	if( !result.equals(SUCCESS) )
    		return result;
    	
    	if (userBo == null) {
            this.addActionError(DB_ERROR_MESSAGE);
        }
        userBean = processUser(userBean);
        userBo.add(userBean);
        
        if( !parseRoles() ){
    		this.addFieldError("userRoles", "Unknown error has occured.  Please try reloading the page.");
    		return INPUT;
    	}
        
        if( parsedRoles.size() > 0 ){
	        List<User> fromDb = userBo.findByUsername(userBean.getUsername());
	        if( fromDb.size() == 1 ){
	        	User fromDbUser = fromDb.get(0);
	        	for( Role parsedRole : parsedRoles ){
	        		fromDbUser.addRole(parsedRole, roleDao);
	        	}
	        	userBo.update(fromDbUser);
	        }
	        else{
	        	this.addActionError("Unable to add the user to the database.  Please try again.");
	        	return INPUT;
	        }
        }
        
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
    
    
    private boolean parseRoles(){
    	if( this.userRoles != null ){
    		if( this.userRoles.length() > 0 ){
    			if( userBean != null ){
    				String[] parsedRoles = userRoles.split(", ");
    				for( String roleStr : parsedRoles ){
    					for( Role role : roles ){
    						if( roleStr.equals(role.getRole()) ){
    							this.parsedRoles.add(role);
    						}
    					}
    				}
    			}
    			else{
    				return false;
    			}
    		}
    	}
    	
    	return true; // not a required field.
    }
    
    private User processUser(User user){
    	RandomString rand = new RandomString(16);
        String salt = rand.nextString();
        user.setSalt(salt);
        
        // salt and encrypt the password for the database.
        salt = salt + user.getPassword();
        user.setPassword(UtilityFunctions.sha1(salt));

        user.setSessionId("");
        
        LOGGER.debug("Add user: " + user.toString());
        
        return user;
    }
    
	public User getUserBean() {
		return userBean;
	}
	public void setUserBean(User userBean) {
		this.userBean = userBean;
	}

	public String getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(String userRoles) {
		this.userRoles = userRoles;
	}
	
}
