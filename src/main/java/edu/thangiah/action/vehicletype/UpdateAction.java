package edu.thangiah.action.vehicletype;

import java.util.List;

import edu.thangiah.entity.Vehicle;
import edu.thangiah.entity.VehicleType;

/**
 * This class extends the management controller. Its primary function
 * is to handle everything realted to updating and Vehicle Type entity.
 * 
 * @author Alex McCracken, Kelly Smith
 *
 */


public class UpdateAction extends ManagementController{

	private static final long serialVersionUID = 4634172821230672694L;

	@Override
	public void prepare() throws Exception {
		this.mode =  Modes.EDIT;
		super.prepare();
	}
	
	
	@Override
    public String execute(){
		// Errors could be thrown by the ManagementController prepare methods.
    	if( this.hasControllerErrors() ){
    		return ERROR;
    	}
    	
    	VehicleType fromDb = this.retrieveEntityById(vehicleTypeDao, id);
    	if( fromDb == null ){
    		this.addActionError("A vehicle type must be specified");
    		return INPUT;
    	}
    	
    	VehicleType fromForm = this.getEntity();
    	if( fromForm == null ){
    		this.addActionError("The form data could not be retrieved from the form.  Please try again.");
    		return INPUT;
    	}
    	
		List<Vehicle> fromDbList = vehicleDao.findByVehicleType(this.getVehicleType());
		if( fromDbList.size() != 0){
					this.addFieldError("vehicles", "There are vehicles connected to this type preventing deletion");
					return INPUT;
			}
    	fromDb.merge(fromForm);
    	vehicleTypeDao.update(fromDb);
    	return SUCCESS;
	    }


	@Override
	public void validate(){
		//validate up in here
    }
	
}