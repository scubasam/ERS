package edu.thangiah.action.contact;


import edu.thangiah.entity.Contact;

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
    		this.addActionError("Must specify which Contact you would like to delete.");
    		return INPUT;
    	}
    	
    	Contact fromDb = this.retrieveEntityById(contactDao, id);
    	if( fromDb == null ){
    		this.addActionError("This contact does not exist.  Please try again.");
    		return INPUT;
    	}
    	
    	try{
    		contactDao.delete(fromDb);
    		if(fromDb !=null)
    		{
    			this.addActionError("A contractor exists which is connected to this contact information. Please delete the contractor first");
    		}
    	}
    	catch( Exception e ){
    		this.addActionError("A contractor exists which is connected to this contact information.  Please delete the contractor first.");
    		return INPUT;
    	}
    	
    	return SUCCESS;
    }
}
