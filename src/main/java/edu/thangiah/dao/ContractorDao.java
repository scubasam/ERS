package edu.thangiah.dao;

import java.util.List;


import edu.thangiah.entity.Contractor;
import edu.thangiah.entity.Location;

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
	public List<Contractor> findByLocation(Location location){
		return getHibernateTemplate().find("from Contractor where location_id=?", location.getId());
	}

}
