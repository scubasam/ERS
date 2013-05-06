package edu.thangiah.action.location;


import edu.thangiah.entity.Location;

/**
 * This class extends the management controller. It's primary function is to handle everything
 * related to deleting a Location entity
 * 
 * @author Alex McCracken, Kelly Smith
 *
 */



public class DeleteAction extends ManagementController
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3085733381513456454L;


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
    		this.addActionError("Must specify which Location you would like to delete.");
    		return INPUT;
    	}
    	
    	Location fromDb = this.retrieveEntityById(locationDao, id);
    	if( fromDb == null ){
    		this.addActionError("This location does not exist.  Please try again.");
    		return INPUT;
    	}
    	
    	try{
    		if(fromDb !=null && fromDb.getVehicles() == null){
    	  		locationDao.delete(fromDb);
    	  		return SUCCESS;
    		}
    		else{
    			this.addActionError("Dependencies exist and must be deleted before you can delete this entity");
    			return INPUT;
    		}
    	}
    	catch( Exception e ){
    		this.addActionError("A dependency exists and is prohibiting this deletion.");
    		return INPUT;
    	}
    }
}
