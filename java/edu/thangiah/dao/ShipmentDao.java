package edu.thangiah.dao;

import java.util.List;

import edu.thangiah.entity.Shipment;

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