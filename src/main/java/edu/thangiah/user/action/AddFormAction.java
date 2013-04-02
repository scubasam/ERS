package edu.thangiah.user.action;

import java.util.List;
import java.util.Random;

import edu.thangiah.permission.Role;
import edu.thangiah.user.entity.User;

public class AddFormAction extends UserAction {

	private static final String ROLE_NULL_MESSAGE = "Unable to get the list of user roles from the database. Please try again.";
	private static final long serialVersionUID = 3437065226885830031L;
	
	private List<Role> roles;
	
	@Override
	public String execute(){
		if (roleDao == null) {
            this.addActionError(DB_ERROR_MESSAGE);
        }
		
		roles = roleDao.findAll();
		if( roles == null || roles.size() == 0 ){
			this.addActionError(ROLE_NULL_MESSAGE);
		}
		
		testUserRoleCreation();
		
		return SUCCESS;
	}
	
	
	private void testUserRoleCreation(){
		User user = new User();
		Random rand = new Random();
		int randInt = rand.nextInt();
		user.setUsername("TESTING - " + randInt);
		user.setPassword("Testing");
		user.setSalt("testing");
		user.setSessionId("tseting");
		userBo.add(user);
		
		user= userBo.findByUsername(user.getUsername()).get(0);
		
		user.addRole(roles.get(0), roleDao);
		user.addRole(roles.get(2), roleDao);
		
		userBo.update(user);
		
		
		
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	

}
