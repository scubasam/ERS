package edu.thangiah.permission;

import java.util.HashMap;

import edu.thangiah.user.entity.User;

public class PermissionController {
	private User currentUser;
	@SuppressWarnings("unused")
	private String actionName;
	@SuppressWarnings("unused")
	private Permission permission;
	
	private HashMap<String, Boolean> currentRoles;
	
	private final static String GLOBAL_ADMIN = "globalAdmin";
	
	public PermissionController(User user, String actionName, Permission permission){
		this.currentUser = user;
		this.actionName = actionName;
		this.permission = permission;
		
		if( currentUser != null ){
			currentRoles = new HashMap<String, Boolean>();
			for( Role role : currentUser.getRoles() ){
				currentRoles.put(role.getRole(), true);
			}
		}
	}
	
	public boolean calculatePermission(){
		if( hasRole(GLOBAL_ADMIN) ){
			return true;
		}
		
		return false;
	}
	
	private boolean hasRole(String role){
		if( currentRoles == null )
			return false;
		
		if( currentRoles.containsKey(role) ){
			return true;
		}
		
		return false;
	}
	
}
