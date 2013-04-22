package edu.thangiah.action.vehicletype;

import com.opensymphony.xwork2.Preparable;

import edu.thangiah.entity.VehicleType;

public class AddAction extends ManagementController implements Preparable{

	private static final long serialVersionUID = -1708978099566079365L;
	
	@Override
    public String execute(){
		if (vehicleTypeDao == null || this.getEntity() == null) {
            this.addActionError(DB_ERROR_MESSAGE);
        }
		
		LOGGER.debug("Adding new Vehicle Type: " + this.getEntity().toString());
		vehicleTypeDao.add(this.getEntity());
		
    	return SUCCESS;
    }
    
    // called automatically
    public void validate(){
    	if(getEntity() != null)
    	{
    		requiredString(getEntity().getType(), "vehicleType.type");
    		requiredString(getEntity().getSubType(), "vehicleType.subType");
    		requiredString(getEntity().getMake(), "vehicleType.make");
    		requiredString(getEntity().getModel(), "vehicleType.model");
    		requiredInt(getEntity().getMaximumWeight(), "vehicleType.maximumWeight");
    		requiredInt(getEntity().getMinimumWeight(), "vehicleType.minimumWeight");
    		requiredInt(getEntity().getMaximumRange(), "vehicleType.maximumRange");
    		requiredString(getEntity().getCapacity(), "vehicleType.capacity");
    		requiredInt(getEntity().getHeight(), "vehicleType.height");
    		requiredInt(getEntity().getEmptyWeight(), "vehicleType.emptyWeight");
    		requiredInt(getEntity().getLength(), "vehicleType.length");
    	}		
    	else{
    		addActionError("Unknown error.  Please try again.");
    	}

    }
}
