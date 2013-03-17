package edu.thangiah.user.action;

import java.util.List;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.Preparable;

import edu.thangiah.user.entity.User;

public class ListAction extends UserAction implements Preparable{
	private static final long serialVersionUID = 1L;
	
	private List<User> users;
	
	@Override
	public String execute() {
        if (userBo == null) {
            return Action.ERROR;
        }
        
        LOGGER.debug("Get all users");
        users = userBo.findAll();
        LOGGER.debug("Users number = " + users.size());
        return SUCCESS;
    }

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
}
