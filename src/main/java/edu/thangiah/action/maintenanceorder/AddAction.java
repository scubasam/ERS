package edu.thangiah.action.maintenanceorder;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.Preparable;

import edu.thangiah.dao.DriverDao;
import edu.thangiah.dao.ServiceTechnicianDao;
import edu.thangiah.dao.VehicleDao;
import edu.thangiah.entity.MaintenanceOrder;

/**
 *This class extends the management controller and implements preparable. It's primary function
 *is to to handle everything related to adding and Maintenance Orders entity 
 * 
 * @author Alex McCracken, Kelly Smith
 */


public class AddAction extends ManagementController implements Preparable{
	
	private static final long serialVersionUID = -5800683108151609064L;
	
	@Autowired
	protected VehicleDao vehicleDao;
	
	@Autowired
	protected DriverDao driverDao;
	
	@Autowired
	protected ServiceTechnicianDao serviceTechnicianDao;
	
	@Override
    public String execute(){
		if (vehicleDao == null || driverDao == null || serviceTechnicianDao == null || this.getEntity() == null) {
            this.addActionError(DB_ERROR_MESSAGE);
        }
		vehicleDao.add(vehicle);
		this.getEntity().setVehicle(vehicle);
		driverDao.add(driver);
		this.getEntity().setDriver(driver);
		serviceTechnicianDao.add(serviceTechnician);
		this.getEntity().setServiceTechnician(serviceTechnician);
		maintenanceOrderDao.add(this.getEntity());
		
    	return SUCCESS;
    }
    
    // called automatically
    public void validate(){
    	if( this.getEntity() != null ){
    		
    	}
    	else{
    		addActionError("Unknown error.  Please try again.");
    	}
    }

    
    public MaintenanceOrder getMaintenanceOrder()
    {
    	return this.getEntity();
    }
    
    public void setMaintenanceOrder(MaintenanceOrder maintenanceOrder)
    {
    	this.setEntity(maintenanceOrder);
    }
    
	public VehicleDao getVehicleDao() {
		return vehicleDao;
	}

	public void setVehicleDao(VehicleDao vehicleDao) {
		this.vehicleDao = vehicleDao;
	}

	public DriverDao getDriverDao() {
		return driverDao;
	}

	public void setDriverDao(DriverDao driverDao) {
		this.driverDao = driverDao;
	}

	public ServiceTechnicianDao getServiceTechnicianDao() {
		return serviceTechnicianDao;
	}

	public void setServiceTechnicianDao(ServiceTechnicianDao serviceTechnicianDao) {
		this.serviceTechnicianDao = serviceTechnicianDao;
	}


	
}
