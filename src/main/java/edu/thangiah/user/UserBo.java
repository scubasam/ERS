package edu.thangiah.user;

import java.util.List;

import edu.thangiah.user.entity.User;
 
public interface UserBo {
 
    void add(User user);
 
    void update(User user);
 
    void delete(User user);
 
    List findAll();
 
    List findById(int id);
 
    List findByUsername(String username);
}