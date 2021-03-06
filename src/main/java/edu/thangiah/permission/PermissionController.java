package edu.thangiah.permission;

import java.util.HashSet;

import edu.thangiah.user.entity.User;

/**
 * Used to calculate permissions for a given resource.  More complicated permission control code will be implemented here.
 * @author Kelly Smith
 *
 */
public class PermissionController {
	private User currentUser;
	@SuppressWarnings("unused")
	private String actionName;
	private Permission permission;
	
	private HashSet<String> currentRoles;
	
	private final static String GLOBAL_ADMIN = "globalAdmin";
	
	public PermissionController(User user, String actionName, Permission permission){
		this.currentUser = user;
		this.actionName = actionName;
		this.permission = permission;
		
		if( currentUser != null ){
			currentRoles = new HashSet<String>();
			for( Role role : currentUser.getRoles() ){
				currentRoles.add(role.getRole());
			}
		}
	}
	
	/**
	 * Performs a calculation on a given resource to determine if a user should be allowed access.
	 * @return true if permission should be given, false otherwise.
	 */
	public boolean calculatePermission(){
		if( hasRole(GLOBAL_ADMIN) ){
			return true;
		}
		
		if( this.currentUser != null ){
			// User is logged in.
			
			if( this.permission != null ){
				// A permission exists for this action.
				if( hasRole(this.permission.getId()) ){
					return true;
				}
			}
		}
		
		return false;
	}
	
	private boolean hasRole(String role){
		if( currentRoles == null )
			return false;
		
		if( currentRoles.contains(role) ){
			return true;
		}
		
		return false;
	}
	
}
