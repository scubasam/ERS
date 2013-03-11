package edu.thangiah.dao;

import java.util.List;


import edu.thangiah.entity.Vehicle;

public class VehicleDao extends AbstractDao<Vehicle> {
	
	@SuppressWarnings("unchecked")
	@Override
    public List<Vehicle> findAll() {
		List<Vehicle> list = getHibernateTemplate().find("from Vehicle");
		return list;
    }
	
	@SuppressWarnings("unchecked")
	@Override
    public List<Vehicle> findById(Long id) {
        return getHibernateTemplate().find("from Vehicle where id=?", id);
    }

}
