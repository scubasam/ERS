package edu.thangiah.dao;

import java.util.List;


import edu.thangiah.entity.VehicleType;

/**
 * This codes primary function is to pull the database references for a vehicle type to be manipulated by the entity classes
 * 
 * @author Alex McCracken, Kelly Smith
 *
 */


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
