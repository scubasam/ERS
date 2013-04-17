package edu.thangiah.action.vehicletype;

import org.springframework.beans.factory.annotation.Autowired;
import com.opensymphony.xwork2.Preparable;

import edu.thangiah.dao.VehicleTypeDao;
import edu.thangiah.entity.MaintenanceOrder;
import edu.thangiah.entity.VehicleType;

public class AddAction extends MaintenanceOrder implements Preparable{

	private static final long serialVersionUID = -1708978099566079365L;
	private VehicleType vehicleType;
	
	@Autowired
	protected VehicleTypeDao vehicleTypeDao;
	
	@Override
    public String execute() throws Exception
    {
		/*
		if (vehicleTypeDao == null || vehicleType == null) 
		{
            this.addActionError(DB_ERROR_MESSAGE);
        }
		
		vehicleTypeDao.add(vehicleType);
		*/
    	return SUCCESS;
    }
    
    // called automatically
    public void validate(){
    	if(vehicleType != null)
    	{
    		requiredLong(vehicleType.getId(), "vehicleType.id");
    		requiredString(vehicleType.getType(), "vehicleType.type");
    		requiredString(vehicleType.getSubType(), "vehicleType.subType");
    		requiredString(vehicleType.getDescription(), "vehicleType.description");
    		requiredString(vehicleType.getMake(), "vehicleType.make");
    		requiredString(vehicleType.getModel(), "vehicleType.model");
    		requiredInt(vehicleType.getMaximumWeight(), "vehicleType.maximumWeight");
    		requiredInt(vehicleType.getMinimumWeight(), "vehicleType.minimumWeight");
    		requiredInt(vehicleType.getMaximumRange(), "vehicleType.maximumRange");
    		requiredString(vehicleType.getCapacity(), "vehicleType.capacity");
    		requiredString(vehicleType.getRestrictions(), "vehicleType.restrictions");
    		requiredInt(vehicleType.getHeight(), "vehicleType.height");
    		requiredInt(vehicleType.getEmptyWeight(), "vehicleType.emptyWeight");
    		requiredInt(vehicleType.getLength(), "vehicleType.length");
    	}		
    	else{
    		addActionError("Unknown error.  Please try again.");
    	}

    }
    
	public VehicleTypeDao getVehicleTypeDao()
	{
		return vehicleTypeDao;
	}

	public void setVehicleTypeDao(VehicleTypeDao vehicleTypeDao)
	{
		this.vehicleTypeDao = vehicleTypeDao;
	}
}
