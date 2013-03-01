package edu.thangiah.user;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
 
import edu.thangiah.user.entity.User;
 
public class UserDaoImpl extends HibernateDaoSupport implements UserDao {
 
    public void add(User user) {
        getHibernateTemplate().save(user);
    }
 
    public void delete(User user) {
        getHibernateTemplate().delete(user);
    }
 
    public List findAll() {
        return getHibernateTemplate().find("from User");
    }
 
    public List findById(int id) {
        return getHibernateTemplate().find("from User where id=?", id);
    }
 
    public List findByUsername(String username) {
        return getHibernateTemplate().find("from User where username=?", username);
    }
 
    public void update(User user) {
        getHibernateTemplate().update(user);
    }
}