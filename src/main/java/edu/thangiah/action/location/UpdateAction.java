package edu.thangiah.action.location;

import java.util.List;

import edu.thangiah.entity.Contractor;
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
    	
    	String result = parseContractorId();
		if( !result.equals(SUCCESS) )
			return result;
		
		fromDb.merge(fromForm);
		
		if( newContractorId != fromDb.getContractor().getId() ){
			List<Contractor> fromDbList = contractorDao.findById(newContractorId);
			if( fromDbList == null || fromDbList.size() != 1 ){
				this.addFieldError("contractorId", "No contractor found with that name.  Please refresh the page.");
				return INPUT;
			}
			fromDb.setContractor(fromDbList.get(0));
		}
    	
    	locationDao.update(fromDb);
    	
    	return SUCCESS;
    }


	@Override
	public void validate(){
		runLocationValidation();
    }
	
}