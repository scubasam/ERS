package edu.thangiah.action.vehicle;

import org.springframework.beans.factory.annotation.Autowired;
import com.opensymphony.xwork2.Preparable;

import edu.thangiah.dao.VehicleDao;
import edu.thangiah.dao.VehicleTypeDao;
import edu.thangiah.entity.MaintenanceOrder;

import edu.thangiah.entity.Vehicle;
import edu.thangiah.entity.VehicleType;

public class AddAction extends MaintenanceOrder implements Preparable{

	private static final long serialVersionUID = -1708978099566079365L;
	private Vehicle vehicle;
	private VehicleType vehicleType;
	
	@Autowired
	protected VehicleDao vehicleDao;
	
	@Autowired
	protected VehicleTypeDao vehicleTypeDao;
	
	@Override
    public String execute() throws Exception
    {
		/*
		if (vehicleDao == null || vehicle == null) 
		{
            this.addActionError(DB_ERROR_MESSAGE);
        }
		
		vehicleDao.add(vehicle);
		vehicleTypeDao.add(vehicleType);
		vehicle.setVehicleType(vehicleType);
		*/
    	return SUCCESS;
    }
    
    // called automatically
    public void validate(){
    	if(vehicle != null && vehicleType != null )
    	{
    		requiredLong(vehicle.getId(), "vehicle.id");
    		requiredString(vehicle.getPlateNumber(), "vehicle.plateNumber");
    		requiredString(vehicle.getVinNumber(), "vehicle.vinNumber");
    		requiredString(vehicle.getManufacturedYear(), "vehicle.manufacturedYear");
    		requiredString(vehicle.getStatus(), "vehicle.getStatus");
    		requiredString(vehicle.getVehicleType().toString(), "vehicle.vehicleType");
    		requiredString(vehicle.getDrivers().toString(), "vehicle.drivers");
    		requiredString(vehicle.getLocation().toString(), "vehicle.location");
    	}		
    	else{
    		addActionError("Unknown error.  Please try again.");
    	}

    }

	/**
	 * @return the contact
	 */
	public Vehicle getVehicle()
	{
		return vehicle;
	}

	/**
	 * @param contact the contact to set
	 */
	public void setVehicle(Vehicle vehicle)
	{
		this.vehicle = vehicle;
	}
	
	public VehicleTypeDao getVehicleTypeDao()
	{
		return vehicleTypeDao;
	}

	public void setVehicleTypeDao(VehicleTypeDao vehicleTypeDao)
	{
		this.vehicleTypeDao = vehicleTypeDao;
	}

	public VehicleDao getVehicleDao()
	{
		return vehicleDao;
	}

	public void setVehicleDao(VehicleDao vehicleDao)
	{
		this.vehicleDao = vehicleDao;
	}	
}
