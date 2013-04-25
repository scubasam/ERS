package edu.thangiah.action.vehicletype;

import com.opensymphony.xwork2.Preparable;

/**
 *This class extends the management controller and implements preparable. It's primary function
 *is to to handle everything related to adding and Vehicle Type entity 
 * 
 * @author Alex McCracken, Kelly Smith
 */

public class AddAction extends ManagementController implements Preparable{

	private static final long serialVersionUID = -1708978099566079365L;
	
	@Override
    public String execute(){
		if (vehicleTypeDao == null || this.getEntity() == null) {
            this.addActionError(DB_ERROR_MESSAGE);
        }
		
		LOGGER.debug("Adding new Vehicle Type: " + this.getEntity().toString());
		vehicleTypeDao.add(this.getEntity());
		
    	return SUCCESS;
    }
    
    // called automatically
    public void validate(){
    	validateInput();
    }
}
