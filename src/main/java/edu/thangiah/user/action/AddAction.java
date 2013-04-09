package edu.thangiah.user.action;

import java.util.List;

import com.opensymphony.xwork2.Preparable;

import edu.thangiah.permission.Role;
import edu.thangiah.user.entity.User;
import edu.thangiah.utility.RandomString;
import edu.thangiah.utility.UtilityFunctions;

public class AddAction extends ManagementController implements Preparable{
	
	private static final long serialVersionUID = 1L;
	
	
	@Override
	public void prepare() throws Exception {
		this.mode =  Modes.ADD;
		super.prepare();
	}
	
    @Override
    public String execute(){
    	
    	if( this.hasControllerErrors() ){
    		return ERROR;
    	}
    	
        user = processUser(user);
        userBo.add(user);
        
        if( !parseRoles() ){
    		this.addFieldError("userRoles", "Unknown error has occured.  Please try reloading the page.");
    		userBo.delete(user);
    		return INPUT;
    	}
        
        if( parsedRoles.size() > 0 ){
	        List<User> fromDb = userBo.findByUsername(user.getUsername());
	        if( fromDb.size() == 1 ){
	        	User fromDbUser = fromDb.get(0);
	        	for( Role parsedRole : parsedRoles ){
	        		fromDbUser.addRole(parsedRole, roleDao);
	        	}
	        	userBo.update(fromDbUser);
	        }
	        else{
	        	this.addActionError("Unable to add the user to the database.  Please try again.");
	        	userBo.delete(user);
	        	return INPUT;
	        }
        }
        
        return SUCCESS;
    }
    
    // called automatically
    public void validate(){
    	
    	if( user.getUsername() == null || user.getUsername().length() == 0 )
    		this.addFieldError("user.username", "Username is a required field.");
    	
    	if( user.getPassword() == null || user.getPassword().length() < User.minPasswordLength ){
    		this.addFieldError("user.password", "Password must be at least " + User.minPasswordLength + " characters in length.");
    	}
    	   	
    	List<User> users = userBo.findByUsername(user.getUsername());
    	if( users.size() > 0 ){
    		this.addFieldError("user.username", "Username must be unique.");
    	}
    }
    
    
    protected boolean parseRoles(){
    	if( user == null ){
    		return false;
    	}
    	return parseRolesList(userRoles, roles, parsedRoles);
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
	
}
