package edu.thangiah.action.vehicle;

import edu.thangiah.entity.Vehicle;
import edu.thangiah.strutsutility.exception.StrutsElementException;

/**
 * This class extends the management controller. Its primary function
 * is to handle everything related to updating and vehicle entity.
 * 
 * 
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
    	
    	Vehicle fromDb = this.retrieveEntityById(vehicleDao, id);
    	if( fromDb == null){
    		this.addActionError("This contractor does not exist.  Please try again.");
    		return INPUT;
    	}
    	
    	// Get the selected values from the form.
    	try{
			initializeSelectedElements();
		}
		catch( StrutsElementException e ){
			addActionError("An unknown error occured.  Plase try reloading the page.");
			return ERROR;
		}
		
		if( this.hasActionErrors() || this.hasFieldErrors() ){
			return INPUT;
		}
		fromDb.setVehicleType(vehicleTypeSelect.getSelectedEntity());
		fromDb.setContractor(contractorSelect.getSelectedEntity());
		fromDb.setLocation(locationSelect.getSelectedEntity());
		fromDb.setDriver(driverSelect.getSelectedEntity());

		try{
			vehicleDao.update(fromDb);
		}
		catch(Exception e){
			return ERROR;
		}
		return SUCCESS;
	}
	
    // called automatically 
    public void validate(){
    	if( this.getEntity() != null ){
    		requiredString(this.getEntity().getPlateNumber(), "vehicle.plateNumber");
    		requiredString(this.getEntity().getManufacturedYear(), "vehicle.manufacturedYear");
    		requiredString(this.getEntity().getVinNumber(), "vehicle.vinNumber");
    	}
    	else{
    		addActionError("Unknown error.  Please try again.");
    	}	
    }
    
	public Vehicle getVehicle(){
		return this.getEntity();
	}
	
	public void setVehicle(Vehicle vehicle) {
		this.setEntity(vehicle);
	}
}