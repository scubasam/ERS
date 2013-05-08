package edu.thangiah.dao;

import java.util.List;


import edu.thangiah.entity.Contact;
import edu.thangiah.entity.Contractor;


/**
 * This codes primary function is to pull the database references for a contractor to be manipulated by the entity classes
 * 
 * @author Alex McCracken, Kelly Smith
 *
 */

public class ContractorDao extends AbstractDao<Contractor> {
	
	@SuppressWarnings("unchecked")
	@Override
    public List<Contractor> findAll() {
		List<Contractor> list = getHibernateTemplate().find("from Contractor");
		return list;
    }
	
	@SuppressWarnings("unchecked")
	@Override
    public List<Contractor> findById(Long id) {
        return getHibernateTemplate().find("from Contractor where id=?", id);
    }

	@SuppressWarnings("unchecked")
	public List<Contractor> findByContact(Contact contact){
		return getHibernateTemplate().find("from Contractor where contact_id=?", contact.getId());
	}
}
