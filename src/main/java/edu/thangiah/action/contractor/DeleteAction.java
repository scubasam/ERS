package edu.thangiah.action.contractor;

import edu.thangiah.entity.Contractor;

/**
 * This class extends the management controller. It's primary function is to handle everything
 * related to deleting a Contractor entity
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
    		this.addActionError("Must specify which contractor you would like to delete.");
    		return INPUT;
    	}
    	
    	Contractor fromDb = this.retrieveEntityById(contractorDao, id);
    	if( fromDb == null ){
    		this.addActionError("This contractor does not exist.  Please try again.");
    		return INPUT;
    	}
    	
    	try{
    		if(fromDb != null && fromDb.getLocations() == null && fromDb.getVehicles() == null && fromDb.getContact() == null){
    			contractorDao.delete(fromDb);
    			return SUCCESS;
    		}
    		else{
    			this.addActionError("Dependencies exist delete these first");
    			return INPUT;
    		}
    		
    	}
    	catch( Exception e ){
    		this.addActionError("Drivers, Locations, or Vehicles exist that are connected to this contractor.  It cannot be deleted.");
    		
    		return INPUT;
    	}
    }
}
