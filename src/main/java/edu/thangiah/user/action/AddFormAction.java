package edu.thangiah.user.action;

import java.util.List;

import edu.thangiah.permission.Role;

public class AddFormAction extends UserAction {

	private static final String ROLE_NULL_MESSAGE = "Unable to get the list of user roles from the database. Please try again.";
	private static final long serialVersionUID = 3437065226885830031L;
	
	protected List<Role> roles;
	
	@Override
	public String execute(){
		if (roleDao == null) {
            this.addActionError(DB_ERROR_MESSAGE);
            return ERROR;
        }
		
		roles = roleDao.findAll();
		if( roles == null || roles.size() == 0 ){
			this.addActionError(ROLE_NULL_MESSAGE);
		}
		
		//testUserRoleCreation();
		
		return SUCCESS;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	

}
