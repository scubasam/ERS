package edu.thangiah.action.maintenanceorder;

import org.springframework.beans.factory.annotation.Autowired;
import com.opensymphony.xwork2.Preparable;
import edu.thangiah.dao.MaintenanceOrderDao;
import edu.thangiah.dao.VehicleDao;
import edu.thangiah.entity.MaintenanceOrder;
import edu.thangiah.entity.Vehicle;

public class AddAction extends MaintenanceOrder implements Preparable{

	private static final long serialVersionUID = -1708978099566079365L;
	private MaintenanceOrder maintenanceOrder;
	private Vehicle vehicle;
	
	@Autowired
	protected MaintenanceOrderDao maintenanceOrderDao;
	
	@Autowired
	protected VehicleDao vehicleDao;
	
	@Override
    public String execute() throws Exception
    {
		if (maintenanceOrderDao == null || maintenanceOrder == null) 
		{
            this.addActionError(DB_ERROR_MESSAGE);
        }
		
		maintenanceOrderDao.add(maintenanceOrder);
		vehicleDao.add(vehicle);
		maintenanceOrder.setVehicle(vehicle);
		//LOGGER.debug("Adding new maintenance order: " + maintenanceOrder.toString());
		maintenanceOrderDao.add(maintenanceOrder);
		
    	return SUCCESS;
    }
    
    // called automatically
    public void validate(){
    	if( maintenanceOrder != null && vehicle != null )
    	{
    		//placeholder
    	}		
    	else{
    		addActionError("Unknown error.  Please try again.");
    	}

    }

	/**
	 * @return the contact
	 */
	public MaintenanceOrder getMaintenanceOrder()
	{
		return maintenanceOrder;
	}

	/**
	 * @param contact the contact to set
	 */
	public void setMaintenanceOrder(MaintenanceOrder maintenanceOrder)
	{
		this.maintenanceOrder = maintenanceOrder;
	}
	
	/**
	 * @return the contact
	 */
	public Vehicle getVehicle() {
		return vehicle;
	}

	public VehicleDao getVehicleDao() {
		return vehicleDao;
	}

	public void setVehicleDao(VehicleDao vehicleDao) {
		this.vehicleDao = vehicleDao;
	}

	public MaintenanceOrderDao getMaintenanceOrderDao() {
		return maintenanceOrderDao;
	}

	public void setMaintenanceOrderDao(MaintenanceOrderDao maintenanceOrderDao) {
		this.maintenanceOrderDao = maintenanceOrderDao;
	}

	
	
	
	@Override
	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		
	}
	
}
