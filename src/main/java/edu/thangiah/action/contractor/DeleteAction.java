package edu.thangiah.action.contractor;

import org.springframework.dao.DataIntegrityViolationException;

import edu.thangiah.entity.Contractor;

public class DeleteAction extends ManagementController
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


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
    		this.addActionError("Must specify which Contact you would like to delete.");
    		return INPUT;
    	}
    	
    	Contractor fromDb = this.retrieveEntityById(contractorDao, id);
    	if( fromDb == null ){
    		this.addActionError("This contact does not exist.  Please try again.");
    		return INPUT;
    	}
    	
    	try{
    		contractorDao.delete(fromDb);
    	}
    	catch( Exception e ){
    		this.addActionError("Contractor delete failed. This should never happen");
    		return INPUT;
    	}
    	
    	return SUCCESS;
    }
}
