package edu.thangiah.action.shipment;


import edu.thangiah.entity.Shipment;

/**
 * This class extends the management controller. It's primary function is to handle everything
 * related to deleting a Shipment entity
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
    		this.addActionError("Must specify which Shipment you would like to delete.");
    		return INPUT;
    	}
    	
    	Shipment fromDb = this.retrieveEntityById(shipmentDao, id);
    	if( fromDb == null ){
    		this.addActionError("This Shipment does not exist.  Please try again.");
    		return INPUT;
    	}
    	
    	try{
    		if(fromDb != null && fromDb.getRoute() == null) {
    			this.addActionError("A dependency exists. Please delete the dependent entity first.");
    			shipmentDao.delete(fromDb);	
    		}
    	}
    	catch( Exception e ){
    		this.addActionError("A dependency exists. Please delete the dependent entity first.");
    		return INPUT;
    	}
    	
    	return SUCCESS;
    }
}
