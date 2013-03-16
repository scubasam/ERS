package edu.thangiah.dao;

import java.util.List;


import edu.thangiah.entity.VehicleType;

public class VehicleTypeDao extends AbstractDao<VehicleType> {
	
	@SuppressWarnings("unchecked")
	@Override
    public List<VehicleType> findAll() {
		List<VehicleType> list = getHibernateTemplate().find("from VehicleType");
		return list;
    }
	
	@SuppressWarnings("unchecked")
	@Override
    public List<VehicleType> findById(Long id) {
        return getHibernateTemplate().find("from VehicleType where id=?", id);
    }

}
