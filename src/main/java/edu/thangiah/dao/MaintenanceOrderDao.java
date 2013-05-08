package edu.thangiah.dao;

import java.util.List;


import edu.thangiah.entity.Driver;
import edu.thangiah.entity.MaintenanceOrder;
import edu.thangiah.entity.ServiceTechnician;
import edu.thangiah.entity.Vehicle;

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
	
	@SuppressWarnings("unchecked")
	public List<MaintenanceOrder> findByRequester(Driver driver){
		return getHibernateTemplate().find("from MaintenanceOrder where service_technician_id=?", driver.getId());
	}
	
	@SuppressWarnings("unchecked")
	public List<MaintenanceOrder> findByServiceTechnician(ServiceTechnician serviceTechnician){
		return getHibernateTemplate().find("from MaintenanceOrder where service_technician_id=?", serviceTechnician.getId());
	}	

	@SuppressWarnings("unchecked")
	public List<MaintenanceOrder> findByVehicle(Vehicle vehicle){
		return getHibernateTemplate().find("from MaintenanceOrder where vehicle_id=?", vehicle.getId());
	}
	
}