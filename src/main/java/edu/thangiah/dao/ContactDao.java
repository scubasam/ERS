package edu.thangiah.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
 
import edu.thangiah.entity.Contact;
 
public class ContactDao extends AbstractDao<Contact> {
	
	@Override
    public List<Contact> findAll() {
        return getHibernateTemplate().find("from Contact");
    }
	
	@Override
    public List<Contact> findById(Long id) {
        return getHibernateTemplate().find("from Contact where id=?", id);
    }

}