package edu.thangiah.action.shipment;

import java.util.Date;

import edu.thangiah.entity.Shipment;
import edu.thangiah.strutsutility.exception.StrutsElementException;

/**
 * This class extends the management controller. Its primary function
 * is to handle everything related to updating and Route entity.
 * 
 * @author Alex McCracken, Kelly Smith
 *
 */


public class UpdateAction extends ManagementController{
	private static final long serialVersionUID = 4210630685584117901L;

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
    	
    	Shipment fromDb = this.retrieveEntityById(shipmentDao, id);
    	if( fromDb == null){
    		this.addActionError("This shipment does not exist.  Please try again.");
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
    	
		
		fromDb.merge(this.getEntity());
		
		fromDb.setTimeEntered(new Date()); // set the entered time to right now.
		
		fromDb.setVehicleType(vehicleTypeSelect.getSelectedEntity());
		fromDb.setLocation(locationSelect.getSelectedEntity());
		fromDb.setRoute(routeSelect.getSelectedEntity());
		fromDb.setDestination(destinationSelect.getSelectedEntity());
		fromDb.setPooledDestination(pooledDestinationSelect.getSelectedEntity());
		
		try{
			shipmentDao.update(fromDb);
		}
		catch( Exception e ){
			return ERROR;
		}
    	
    	
    	return SUCCESS;
	}
	
	// called automatically
    public void validate(){
    	shipmentValidation();

    }
}