package edu.thangiah.action.vehicletype;


import edu.thangiah.entity.VehicleType;

/**
 * This class extends the management controller. It's primary function is to handle everything
 * related to deleting a Vehicle Type entity
 * 
 * @author Alex McCracken, Kelly Smith
 *
 */



public class DeleteAction extends ManagementController
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5049171011473675910L;


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
    		this.addActionError("Must specify a target for deletion");
    		return INPUT;
    	}
    	
    	VehicleType fromDb = this.retrieveEntityById(vehicleTypeDao, id);
    	if( fromDb == null ){
    		this.addActionError("This vehicle type does not exist.");
    		return INPUT;
    	}
    	
    	try{
    		if(fromDb !=null && vehicleDao.findByVehicleType(fromDb) == null){
    			vehicleTypeDao.delete(fromDb);
    		   	return SUCCESS;
    		}
    		else {
        		this.addActionError("A dependency exists that is prohibiting this deleteion");
        		return INPUT;
        	}
    	}
    	catch( Exception e ){
    		this.addActionError("And error has occurred please refresh the page. If this persists contact your system admin");
    		return INPUT;
    	}
    }
}
