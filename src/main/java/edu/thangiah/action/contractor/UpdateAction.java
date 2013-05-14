package edu.thangiah.action.contractor;

import edu.thangiah.entity.Contractor;

/**
 * This class extends the management controller. Its primary function
 * is to handle everything related to updating and Contractor entity.
 * 
 * 
 * 
 * @author Alex McCracken, Kelly Smith
 *
 */


public class UpdateAction extends ManagementController{

	private static final long serialVersionUID = 4634172821230672694L;
	
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
    	
    	Contractor fromDb = this.retrieveEntityById(contractorDao, id);
    	if( fromDb == null){
    		this.addActionError("This contractor does not exist.  Please try again.");
    		return INPUT;
    	}
    	
    	Contractor fromForm = this.getEntity();
    	if(fromForm.getContractorName() == null){
    		this.addActionError("Contractor name is null. Please try again");
    		return INPUT;
    	}
    	fromForm.setContact(this.getContact());
    	if( this.getContact() == null)
    	{
    		this.addActionError("Contact not found or null. Please try again.");
    		return INPUT;
    	}
    	
    	fromDb.merge(fromForm);
    	contractorDao.update(fromDb);
    	return SUCCESS;
	}
	
	@Override
    // called automatically
    public void validate(){
    	if( this.getEntity() != null ){
    		requiredString(getEntity().getContractorName(), "contractor.contractorName");
    	}
    	else{
    		addActionError("Unknown error.  Please try again.");
    	}
    	
    	this.runContactValidation(contact);
    	
    }
}