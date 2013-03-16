package edu.thangiah.user.action;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
 
import edu.thangiah.action.AbstractAction;
import edu.thangiah.user.UserBo;
import edu.thangiah.user.entity.User;
import edu.thangiah.utility.RandomString;
import edu.thangiah.utility.UtilityFunctions;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.Preparable;
 
public class UserAction extends AbstractAction implements Preparable {
 
    private static final Logger LOGGER = Logger.getLogger(UserAction.class.getName());
 
    private List<User> users;
 
    private Integer id;
    private String username;
    private String password;
    private String sessionId;
	private String salt;
	
    private boolean admin;
 
    @Autowired
    private UserBo userBo;
 
    public UserBo getUserBo() {
        return userBo;
    }
 
    public void setUserBo(UserBo userBo) {
        this.userBo = userBo;
    }
 
    public List<User> getUsers() {
        return users;
    }
 
    public void setUsers(List<User> users) {
        this.users = users;
    }
 
    public Integer getId() {
        return id;
    }
 
    public void setId(Integer id) {
        this.id = id;
    }
 
    public String getUsername() {
        return username;
    }
 
    public void setUsername(String username) {
        this.username = username;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
 
    public String listAll() {
        if (userBo == null) {
            return Action.ERROR;
        }
        LOGGER.debug("Get all users");
        users = userBo.findAll();
        LOGGER.debug("Users number = " + users.size());
        return Action.SUCCESS;
    }
 
    public String delete() {
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
    }
 
    public String add() {
        if (userBo == null) {
            return Action.ERROR;
        }
        
        List<User> users = userBo.findByUsername(username);
        if( users.size() == 0 ){
        	User user = new User();
	        user.setUsername(username);
	        
	        RandomString rand = new RandomString(16);
	        String salt = rand.nextString();
	        user.setSalt(salt);
	        
	        // salt and encrypt the password for the database.
	        salt = salt + password;
	        password = UtilityFunctions.sha1(salt);
	        
	        user.setPassword(password);
	        user.setAdmin(admin);
	        user.setSessionId("");
	        
	        LOGGER.debug("Add user: " + user.toString());
	        userBo.add(user);
        } else {
        	setError(true);
        	setErrorMessage("Username already taken.");
        }
        return Action.SUCCESS;
    }
 
    public String execute() {
        return Action.SUCCESS;
    }
 
    public void prepare() throws Exception {
 
    }
 
    private User getUser(Integer id) {
        LOGGER.debug("Get user with id = " + id);
        if (id != null) {
            List<User> users = userBo.findById(id);
            LOGGER.debug("Number of users with id = " + id + ": " + users.size());
            if (users.size() == 1) {
                return (User) users.get(0);
            }
        }
        return null;
    }

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}
}