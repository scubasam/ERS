package edu.thangiah.dao;

import java.util.List;

import edu.thangiah.entity.MaintenanceOrder;

/**
 * This codes primary function is to pull the database references for a maintenance order to be manipulated by the entity classes
 * 
 * @author Alex McCracken, Kelly Smith
 *
 */


public class MaintenanceOrderDao extends AbstractDao<MaintenanceOrder> {
	
	@SuppressWarnings("unchecked")
	@Override
    public List<MaintenanceOrder> findAll() {
		List<MaintenanceOrder> list = getHibernateTemplate().find("from MaintenanceOrder");
		return list;
    }
	
	@SuppressWarnings("unchecked")
	@Override
    public List<MaintenanceOrder> findById(Long id) {
        return getHibernateTemplate().find("from MaintenanceOrder where id=?", id);
    }
}