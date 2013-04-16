package edu.thangiah.action.contractor;

import edu.thangiah.entity.Contractor;

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
    		contractorDao.delete(fromDb);
    	}
    	catch( Exception e ){
    		this.addActionError("Drivers, Locations, or Vehicles exist that are connected to this contractor.  It cannot be deleted.");
    		
    		return INPUT;
    	}
    	
    	return SUCCESS;
    }
}
