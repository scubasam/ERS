package edu.thangiah.action.contact;


import edu.thangiah.entity.Contact;

/**
 * This class extends the management controller. It's primary function is to handle everything
 * related to deleting a Contact entity
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
    		this.addActionError("Must specify which Contact you would like to delete.");
    		return INPUT;
    	}
    	
    	Contact fromDb = this.retrieveEntityById(contactDao, id);
    	if( fromDb == null ){
    		this.addActionError("This contact does not exist.  Please try again.");
    		return INPUT;
    	}
    	
    	try{
    		
    		if(fromDb !=null && contactDao.findByContractor(contractor) == null && contactDao.findByDriver(driver) == null && contactDao.findByServiceTechnician(serviceTechnician) == null)
    		{
    			contactDao.delete(fromDb);
    	    	return SUCCESS;
    		}
    		else{
        		this.addActionError("A dependency exists which is connected to this contact information.  Please delete the dependency first.");
        		return INPUT;
    		}
    	}	
    	catch( Exception e ){
    		this.addActionError("And error has occured please try refreshing the page. If this persists contact a system admin");
    		return INPUT;
    	}
    	

    }
}
