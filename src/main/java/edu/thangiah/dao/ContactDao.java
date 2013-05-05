package edu.thangiah.dao;

import java.util.List;

 
import edu.thangiah.entity.Contact;
 
/**
 * This codes primary function is to pull the database references for a contact to be manipulated by the entity classes
 * 
 * @author Alex McCracken, Kelly Smith
 *
 */

public class ContactDao extends AbstractDao<Contact> {
	
	@SuppressWarnings("unchecked")
	@Override
    public List<Contact> findAll() {
        return getHibernateTemplate().find("from Contact");
    }
	
	@SuppressWarnings("unchecked")
	@Override
    public List<Contact> findById(Long id) {
        return getHibernateTemplate().find("from Contact where id=?", id);
    }

}