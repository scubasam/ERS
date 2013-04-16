package edu.thangiah.dao;

import java.util.List;

import edu.thangiah.entity.Contractor;
import edu.thangiah.entity.Location;

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
