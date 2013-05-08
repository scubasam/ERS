package edu.thangiah.action.vehicle;

import edu.thangiah.entity.Vehicle;

/**
 * This class extends the management controller. It's primary function is to handle everything
 * related to deleting a vehicle entity
 * 
 * @author Alex McCracken, Kelly Smith
 *
 */

public class DeleteAction extends ManagementController
{

	private static final long serialVersionUID = 8689202186518590230L;

	@Override
	public void prepare() throws Exception {
		this.mode = Modes.DELETE;
		super.prepare();
	}
	
	
	@Override
    public String execute(){
		// Errors could be thrown by the ManagementController prepare methods.
    	if( this.hasControllerErrors() ){
    		return ERROR;
    	}
    	
    	if( id <= 0 ){
    		this.addActionError("Must specify which maintenance order you would like to delete.");
    		return INPUT;
    	}
    	
    	Vehicle fromDb = this.retrieveEntityById(vehicleDao, id);
    	if( fromDb == null ){
    		this.addActionError("This maintenance order does not exist.  Please try again.");
    		return INPUT;
    	}
    	
    	try{
    		if(fromDb != null && maintenanceOrderDao.findByVehicle(fromDb) == null) {
        		vehicleDao.delete(fromDb);	
        	  	return SUCCESS;
    		}
    		else{
        		this.addActionError("Maintenance orders are conencted to this vehicle it cannot be deleted.");
        		return INPUT;
    		}

    	}
    	catch( Exception e ){
    		this.addActionError("And error has occured please try refreshing the page. If this persists contact system admin");
    		return INPUT;
    	}
    }
}
