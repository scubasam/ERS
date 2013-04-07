package edu.thangiah.action.maintenanceorder;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.Preparable;

import edu.thangiah.action.ValidationAction;
import edu.thangiah.dao.MaintenanceOrderDao;
import edu.thangiah.dao.VehicleDao;
import edu.thangiah.entity.MaintenanceOrder;
import edu.thangiah.entity.Vehicle;

public class MaintenanceOrderAction extends ValidationAction implements Preparable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7209552074663168122L;

	protected static final Logger LOGGER = Logger.getLogger(MaintenanceOrderAction.class.getName());
	
	@Autowired
	protected MaintenanceOrderDao maintenanceOrderDao;
	
	@Autowired
	protected VehicleDao vehicleDao;
	

	protected MaintenanceOrder getMaintenanceOrder(Long id) {
        if (id != null) {
            List<MaintenanceOrder> maintO = maintenanceOrderDao.findById(id);
            if (maintO.size() == 1) {
                return maintO.get(0);
            }
        }
        return null;
    }
	
	
	protected List<Vehicle> getVehicles(MaintenanceOrder maintenanceOrder) {
		return vehicleDao.findByMaintenanceOrder(maintenanceOrder);
	}
	
	public void setVehicleDao(VehicleDao vehicleDao)
	{
		this.vehicleDao = vehicleDao;
	}
	
	public VehicleDao getVehicleDao()
	{
		return vehicleDao;
	}
	
	public MaintenanceOrderDao getMaintenanceOrderDao() {
		return maintenanceOrderDao;
	}

	public void setMaintenanceOrderDao(MaintenanceOrderDao maintenanceOrderDao) {
		this.maintenanceOrderDao = maintenanceOrderDao;
	}

	
}
