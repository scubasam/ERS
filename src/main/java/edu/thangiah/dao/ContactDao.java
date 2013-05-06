package edu.thangiah.dao;

import java.util.List;

 
import edu.thangiah.entity.Contact;
import edu.thangiah.entity.Contractor;
import edu.thangiah.entity.Driver;
import edu.thangiah.entity.ServiceTechnician;

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
	
	@SuppressWarnings("unchecked")
	public List<Contact> findByContractor(Contractor contractor){
		return getHibernateTemplate().find("from contact where contractor_id=?", contractor.getId());
	}

	@SuppressWarnings("unchecked")
	public List<Contact> findByDriver(Driver driver){
		return getHibernateTemplate().find("from contact where contractor_id=?", driver.getId());
	}

	@SuppressWarnings("unchecked")
	public List<Contact> findByServiceTechnician(ServiceTechnician serviceTechnician){
		return getHibernateTemplate().find("from contact where serviceTechnician_id=?", serviceTechnician.getId());
	}
}