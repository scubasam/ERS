package edu.thangiah.dao;

import java.util.List;

import edu.thangiah.entity.Contractor;
import edu.thangiah.entity.Location;

/**
 * This codes primary function is to pull the database references for a location to be manipulated by the entity classes
 * 
 * @author Alex McCracken, Kelly Smith
 *
 */

public class LocationDao extends AbstractDao<Location> {
	
	@SuppressWarnings("unchecked")
	@Override
    public List<Location> findAll() {
		List<Location> list = getHibernateTemplate().find("from Location");
		return list;
    }
	
	@SuppressWarnings("unchecked")
	@Override
    public List<Location> findById(Long id) {
        return getHibernateTemplate().find("from Location where id=?", id);
    }
	
	@SuppressWarnings("unchecked")
	public List<Location> findByContractor(Contractor contractor){
		return getHibernateTemplate().find("from Location where contractor_id=?", contractor.getId());
	}

}
