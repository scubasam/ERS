package edu.thangiah.dao;

import java.util.List;
import edu.thangiah.entity.Contact;
 
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