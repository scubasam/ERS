package edu.thangiah.action.location;

import edu.thangiah.entity.Location;

public class UpdateAction extends ManagementController{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4231364254512679579L;


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
    	
    	Location fromDb = this.retrieveEntityById(locationDao, id);
    	if( fromDb == null ){
    		this.addActionError("This contact does not exist.  Please try again.");
    		return INPUT;
    	}
    	
    	Location fromForm = this.getEntity();
    	if( fromForm == null ){
    		this.addActionError("The form data could not be retrieved from the form.  Please try again.");
    		return INPUT;
    	}
    	
    	fromDb.merge(fromForm);
    	locationDao.update(fromDb);
    	
    	return SUCCESS;
    }


	@Override
	public void validate(){
		//this.runContactValidation(this.getEntity());
    }
	
}