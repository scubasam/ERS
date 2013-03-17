package edu.thangiah.contact;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
 
import edu.thangiah.contact.entity.Contact;
 
public class ContactDaoImpl extends HibernateDaoSupport implements ContactDao {
 
    public void add(Contact contact) {
        getHibernateTemplate().save(contact);
    }
 
    public void delete(Contact contact) {
        getHibernateTemplate().delete(contact);
    }
 
    @SuppressWarnings("unchecked")
	public List<Contact> findAll() {
        return getHibernateTemplate().find("from Contact");
    }
 
    @SuppressWarnings("unchecked")
	public List<Contact> findById(int id) {
        return getHibernateTemplate().find("from Contact where id=?", id);
    }
 
    @SuppressWarnings("unchecked")
	public List<Contact> findByUsername(String contactName) {
        return getHibernateTemplate().find("from Contact where Contact Name=?", contactName);
    }
 
    public void update(Contact contact) {
        getHibernateTemplate().update(contact);
    }
}