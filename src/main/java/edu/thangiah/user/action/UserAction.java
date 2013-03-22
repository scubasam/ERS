package edu.thangiah.user.action;


import org.apache.log4j.Logger;
 
import edu.thangiah.action.AbstractAction;

import com.opensymphony.xwork2.Preparable;
 
public class UserAction extends AbstractAction implements Preparable {
 
	private static final long serialVersionUID = 1L;

	protected static final Logger LOGGER = Logger.getLogger(UserAction.class.getName());
 
    /*public String delete() {
        if (userBo == null) {
            return Action.ERROR;
        }
 
        User user = getUser(id);
        if (user == null) {
            return Action.ERROR;
        }
 
        LOGGER.debug("Delete user " + user.getUsername() + " with id " + user.getId());
        userBo.delete(user);
        return Action.SUCCESS;
    }*/
 
    /*private User getUser(Integer id) {
        LOGGER.debug("Get user with id = " + id);
        if (id != null) {
            List<User> users = userBo.findById(id);
            LOGGER.debug("Number of users with id = " + id + ": " + users.size());
            if (users.size() == 1) {
                return (User) users.get(0);
            }
        }
        return null;
    }*/

}