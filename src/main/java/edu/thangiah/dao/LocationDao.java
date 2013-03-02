package edu.thangiah.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.thangiah.entity.Contractor;
import edu.thangiah.entity.Location;

public class LocationDao extends AbstractDao<Location> {
	
	@Override
    public List<Location> findAll() {
		List<Location> list = getHibernateTemplate().find("from Location");
		return list;
    }
	
	@Override
    public List<Location> findById(Long id) {
        return getHibernateTemplate().find("from Location where id=?", id);
    }
	
	public List<Location> findByContractor(Contractor contractor){
		return getHibernateTemplate().find("from Location where contractor_id=?", contractor.getId());
	}

}
