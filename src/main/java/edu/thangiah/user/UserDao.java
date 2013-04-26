package edu.thangiah.user;

import java.util.List;

import edu.thangiah.user.entity.User;
 
public interface UserDao {
 
    void add(User user);
 
    void update(User user);
 
    void delete(User user);
 
    List<User> findAll();
 
    List<User> findById(Long id);
 
    List<User> findByUsername(String username);

	List<User> findBySessionId(String sessionId);
}