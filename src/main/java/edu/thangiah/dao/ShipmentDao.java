package edu.thangiah.dao;

import java.util.List;

import edu.thangiah.entity.Shipment;

/**
 * This codes primary function is to pull the database references for a shipment to be manipulated by the entity classes
 * 
 * @author Alex McCracken, Kelly Smith
 *
 */

public class ShipmentDao extends AbstractDao<Shipment> {
	
	@SuppressWarnings("unchecked")
	@Override
    public List<Shipment> findAll() {
		List<Shipment> list = getHibernateTemplate().find("from Shipment");
		return list;
    }
	
	@SuppressWarnings("unchecked")
	@Override
    public List<Shipment> findById(Long id) {
        return getHibernateTemplate().find("from Shipment where id=?", id);
    }
}