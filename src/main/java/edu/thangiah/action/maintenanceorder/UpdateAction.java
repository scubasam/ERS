package edu.thangiah.action.maintenanceorder;

import edu.thangiah.entity.MaintenanceOrder;

/**
 * This class extends the management controller. Its primary function
 * is to handle everything related to updating and Contractor entity.
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
    	
    	MaintenanceOrder fromDb = this.retrieveEntityById(maintenanceOrderDao, id);
    	if( fromDb == null){
    		this.addActionError("This maintenance order does not exist.  Please try again.");
    		return INPUT;
    	}
    	
    	MaintenanceOrder fromForm = this.getEntity();
    	if( fromForm == null ){
    		this.addActionError("The form data could not be retrieved from the form.  Please try again.");
    		return INPUT;
    	}
    	
    	if( fromForm.getDriver() == null)
    	{
    		this.addActionError("Driver not found or null. Please try again.");
    		return INPUT;
    	}
    	
    	if( fromForm.getVehicle() == null)
    	{
    		this.addActionError("Vehicle not found or null. Please try again.");
    		return INPUT;
    	}
    	
    	if( fromForm.getServiceTechnician() == null)
    	{
    		this.addActionError("Service Technician not found or null. Please try again.");
    		return INPUT;
    	}
    	
    	fromDb.merge(fromForm);
    	maintenanceOrderDao.update(fromDb);
    	return SUCCESS;
	}
}