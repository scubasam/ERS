package edu.thangiah.dao;

import java.util.List;

import edu.thangiah.entity.Contact;
import edu.thangiah.entity.Driver;
import edu.thangiah.entity.MaintenanceOrder;

/**
 * This codes primary function is to pull the database references for a driver to be manipulated by the entity classes
 * 
 * @author Alex McCracken, Kelly Smith
 *
 */

public class DriverDao extends AbstractDao<Driver> {
	
	@SuppressWarnings("unchecked")
	@Override
    public List<Driver> findAll() {
		List<Driver> list = getHibernateTemplate().find("from Driver");
		return list;
    }
	
	@SuppressWarnings("unchecked")
	@Override
    public List<Driver> findById(Long id) {
        return getHibernateTemplate().find("from Driver where id=?", id);
    }
	
	@SuppressWarnings("unchecked")
	public List<MaintenanceOrder> findByMaintenanceOrder(MaintenanceOrder maintenanceOrders){
		return getHibernateTemplate().find("from Driver where maintenanceOrder_id=?", maintenanceOrders.getId());
	}
	
	@SuppressWarnings("unchecked")
	public List<Driver> findByContact(Contact contact){
		return getHibernateTemplate().find("from Driver where contact_id=?", contact.getId());
	}
	
	
	
}
