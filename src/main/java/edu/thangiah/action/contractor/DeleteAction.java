package edu.thangiah.action.contractor;

import java.util.List;

import edu.thangiah.entity.Contact;
import edu.thangiah.entity.Contractor;
import edu.thangiah.entity.Location;
import edu.thangiah.entity.Vehicle;

/**
 * This class extends the management controller. It's primary function is to handle everything
 * related to deleting a Contractor entity
 * 
 * @author Alex McCracken, Kelly Smith
 *
 */

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
    		List<Location> locations = locationDao.findByContractor(fromDb);
    		List<Vehicle> vehicles = vehicleDao.findByContractor(fromDb);
    		List<Contact> contacts = contactDao.findByContractor(fromDb);  		
    		
    		if((locations == null || locations.size() == 0)
    				&& (vehicles == null || vehicles.size() == 0)
    				&& (contacts == null || contacts.size() == 0) ){
    					contractorDao.delete(fromDb);
    					return SUCCESS;
    				}
    		else{
    			this.addActionError("Dependencies exist delete these first");
    			return INPUT;
    		}
    		
    	}
    	catch( Exception e ){
    		this.addActionError("And error has occurred please refresh the page. If this continues contact your system admin!");
    		return INPUT;
    	}
    }
}
