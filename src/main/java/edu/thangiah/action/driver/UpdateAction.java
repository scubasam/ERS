package edu.thangiah.action.driver;

import edu.thangiah.entity.Driver;
import edu.thangiah.strutsutility.exception.StrutsElementException;

/**
 * This class extends the management controller. Its primary function
 * is to handle everything related to updating and Driver entity.
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
    	
    	Driver fromDb = this.retrieveEntityById(driverDao, id);
    	if( fromDb == null){
    		this.addActionError("This driver does not exist.  Please try again.");
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
		fromDb.setVehicle(vehicleSelect.getSelectedEntity());
		fromDb.setContact(contactSelect.getSelectedEntity());
		fromDb.setContractor(contractorSelect.getSelectedEntity());

		try{
			driverDao.update(fromDb);
		}
		catch(Exception e){
			return ERROR;
		}
		return SUCCESS;
	}
}