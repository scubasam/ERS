package edu.thangiah.user.action;


import java.util.HashSet;
import java.util.List;

import edu.thangiah.permission.Role;
import edu.thangiah.user.entity.User;


public class UpdateAction extends ManagementController{
	private static final long serialVersionUID = -7617695163260844069L;
	
	@Override
	public void prepare() throws Exception {
		this.mode =  Modes.EDIT;
		super.prepare();
	}
	
	
	@Override
    public String execute(){
		// Errors could be thrown by the ManagementController prepare methods.
    	if( this.hasControllerErrors() ){
    		return ERROR;
    	}
    	
    	List<User> userList = userBo.findById((int) id);
    	if( userList == null || userList.size() == 0 ){
    		this.addFieldError("user.username", "This user does not exist.  Please try again.");
    		return INPUT;
    	}
    	User fromDbUser = userList.get(0);
    	
    	userList = userBo.findByUsername(user.getUsername());
    	if( userList == null || userList.size() == 0 ){
    		// Could be changing the user
    	}
    	else{
    		// Could be changing the user, or could be the same username.
    		if( userList.get(0).getUsername().equals(fromDbUser.getUsername()) ){
    			// Did not change the username.
    		}
    		else{
    			this.addFieldError("user.username", "This username already exists.  Please choose another one.");
    			return INPUT;
    		}
    	}
    	
    	if( !parseRolesList(userRoles, roles, parsedRoles) ){
    		this.addFieldError("userRoles", "Unknown error has occured.  Please try reloading the page.");
    		return INPUT;
    	}
        
    	mergeUser(fromDbUser, user);
    	userBo.update(fromDbUser);
    	
    	return SUCCESS;
    }
	
	@Override
	public void validate(){
    	
    	if( user.getUsername() == null || user.getUsername().length() == 0 )
    		this.addFieldError("user.username", "Username is a required field.");
    	   	
    	if( user.getEmail() != null && user.getEmail().length() > 0 ){
    		// Email was entered.  validate it.
    		this.validateEmail(user.getEmail(), "user.email");
    	}
    	
    	/*List<User> users = userBo.findByUsername(user.getUsername());
    	if( users.size() != 0 ){
    		this.addFieldError("user.username", "Invalid username.  Username doesn't exist.");
    	}*/
    }
	
	private void mergeUser(User fromDb, User updated){
		fromDb.setUsername(updated.getUsername());
		fromDb.setAdmin(updated.isAdmin());
		fromDb.setEmail(updated.getEmail());
		processChangedRoles(fromDb, user);
		
	}
	
	private void processChangedRoles(User fromDb, User user){
		if( parsedRoles.size() > 0 ){
			for( Role parsedRole : parsedRoles ){
				if( !fromDb.hasRole(parsedRole) ){
					fromDb.addRole(parsedRole, roleDao);
				}
	    	}
		}
		
		for( Role role : new HashSet<Role>(fromDb.getRoles()) ){
			if( !parsedRoles.contains(role) ){
				fromDb.removeRole(role, roleDao);
			}
		}
	}
}