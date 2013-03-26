package edu.thangiah.user;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
 
import edu.thangiah.user.entity.User;
 
@Transactional
public class UserBoImpl implements UserBo {
 
    private static final Logger LOGGER = Logger.getLogger(UserBoImpl.class.getName());
 
    @Autowired
    private UserDao userDao;
 
    public UserDao getUserDao() {
        return userDao;
    }
 
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
 
    public void add(User user) {
        if (user == null) {
            return;
        }
        LOGGER.debug("Adding the following user: " + user.getUsername() + ", " + user.getPassword());
        userDao.add(user);
    }
 
    public void delete(User user) {
        if (user == null) {
            return;
        }
        LOGGER.debug("Deleteting the following user: " + user.getId() + ", " + user.getUsername() + ", " + user.getPassword());
        userDao.delete(user);
    }
 
    public List<User> findAll() {
        LOGGER.debug("Getting all users");
        return userDao.findAll();
    }
 
    public List<User> findById(int id) {
        return userDao.findById(id);
    }
 
    public List<User> findByUsername(String username) {
        return userDao.findByUsername(username);
    }
 
    public void update(User user) {
        if (user == null) {
            return;
        }
        userDao.update(user);
    }

	@Override
	public List<User> findBySessionId(String sessionId) {
		if( sessionId == null )
			return null;
		
		return userDao.findBySessionId(sessionId);
	}
}