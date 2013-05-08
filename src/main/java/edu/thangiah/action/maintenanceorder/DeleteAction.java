package edu.thangiah.action.maintenanceorder;

import edu.thangiah.entity.MaintenanceOrder;

/**
 * This class extends the management controller. It's primary function is to handle everything
 * related to deleting a Maintenance Order entity
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
    	
    	MaintenanceOrder fromDb = this.retrieveEntityById(maintenanceOrderDao, id);
    	if( fromDb == null ){
    		this.addActionError("This maintenance order does not exist.  Please try again.");
    		return INPUT;
    	}
    	
    	try{
    		if(fromDb != null){
        		maintenanceOrderDao.delete(fromDb);
        		return SUCCESS;
    		}
    		else{
    			this.addActionError("A dependency exists");
    			return INPUT;
    		}
    	}
    	catch( Exception e ){
    		this.addActionError("And error has occurred, please refresh the page. If this persists contact your system admin!");
    		return INPUT;
    	}
    }
}
