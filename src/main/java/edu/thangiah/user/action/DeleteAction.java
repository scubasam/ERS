package edu.thangiah.user.action;

import java.util.HashSet;
import java.util.List;

import com.opensymphony.xwork2.Preparable;

import edu.thangiah.permission.Role;
import edu.thangiah.user.action.ManagementController;
import edu.thangiah.user.entity.User;

public class DeleteAction extends ManagementController implements Preparable{

	private static final long serialVersionUID = -4709437539267378030L;

	@Override
	public void prepare() throws Exception {
		this.mode =  Modes.DELETE;
		super.prepare();
	}
	
    @Override
    public String execute(){
    	if( id <= 0 ){
    		this.addActionError("Invalid user. Unable to delete.");
    		return INPUT;
    	}
    	if( this.hasControllerErrors() ){
    		return ERROR;
    	}
    	
    	List<User> userList = userBo.findById((int) id);
    	if( userList == null || userList.size() == 0 ){
    		this.addActionError("This user does not exist.  Please try again.");
    		return INPUT;
    	}
    	
    	User fromDbUser = userList.get(0);
    	deleteUserRoles(fromDbUser);
    	
    	userBo.delete(fromDbUser);
    	
    	
    	userList = userBo.findById((int) id);
    	if( userList == null || userList.size() == 0 ){
    		return SUCCESS;
    	}
    	else{
    		this.addActionError("There was a problem deleting the user from the database.  Please try again.");
    		return INPUT;
    	}
    }
    
    private void deleteUserRoles(User user){
    	
    	for( Role role : new HashSet<Role>(user.getRoles()) ){
			user.removeRole(role, roleDao);
		}
    }
    
    // called automatically
    public void validate(){
    	
    }
}
