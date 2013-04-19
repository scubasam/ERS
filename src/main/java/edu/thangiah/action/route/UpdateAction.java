package edu.thangiah.action.route;

import edu.thangiah.entity.Route;
import edu.thangiah.strutsutility.exception.StrutsElementException;

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
    	
    	Route fromDb = this.retrieveEntityById(routeDao, id);
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
		
		if( this.hasActionErrors() || this.hasFieldErrors() )
			return INPUT;
    	
		
		fromDb.setVehicle(vehicleSelect.getSelectedEntity());
		fromDb.setStartLocation(startLocationSelect.getSelectedEntity());
		fromDb.setEndLocation(endLocationSelect.getSelectedEntity());
		
		try{
			routeDao.update(fromDb);
		}
		catch( Exception e ){
			return ERROR;
		}
    	
    	
    	return SUCCESS;
	}
}