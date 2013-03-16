package edu.thangiah.user;

import java.util.List;

import edu.thangiah.user.entity.User;
 
public interface UserBo {
 
    void add(User user);
 
    void update(User user);
 
    void delete(User user);
 
    List<User> findAll();
 
    List<User> findById(int id);
 
    List<User> findByUsername(String username);
}