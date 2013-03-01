package edu.thangiah.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
 
import edu.thangiah.entity.Contact;
 
public class ContactDao extends HibernateDaoSupport {
 
    public void add(Contact contact) {
        getHibernateTemplate().save(contact);
    }
 
    public void delete(Contact contact) {
        getHibernateTemplate().delete(contact);
    }
 
    public List findAll() {
        return getHibernateTemplate().find("from Contact");
    }
 
    public List findById(int id) {
        return getHibernateTemplate().find("from Contact where id=?", id);
    }
 
    public void update(Contact contact) {
        getHibernateTemplate().update(contact);
    }
}