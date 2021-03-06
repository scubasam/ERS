package edu.thangiah.action.driver;

import com.opensymphony.xwork2.Preparable;

import edu.thangiah.entity.Driver;
import edu.thangiah.strutsutility.exception.StrutsElementException;

/**
 *This class extends the management controller and implements preparable. It's primary function
 *is to to handle everything related to adding and Drivers entity 
 * 
 * @author Alex McCracken, Kelly Smith
 */


public class AddAction extends ManagementController implements Preparable{
	
	private static final long serialVersionUID = -5800683108151609064L;
	
	
	@Override
    public String execute(){
		try{
			initializeSelectedElements();
		}
		catch( StrutsElementException e ){
			addActionError("An unknown error occured.  Plase try reloading the page.");
			return ERROR;
		}
		
		if( this.hasActionErrors() || this.hasFieldErrors() )
			return INPUT;

		
		Driver newDriver = new Driver();
		newDriver.setVehicle(vehicleSelect.getSelectedEntity());
		newDriver.setContact(contactSelect.getSelectedEntity());
		newDriver.setContractor(contractorSelect.getSelectedEntity());
		
		try{
			driverDao.add(newDriver);
		}
		catch(Exception e){
			return ERROR;
		}
    	return SUCCESS;
    }
    
    // called automatically
    public void validate(){
    	if( getEntity() != null)
    	{
    		requiredString(this.getEntity().getLicenseNumber(), "driver.licenseNumber");
    		requiredString(this.getEntity().getLicenseExpiration().toString(), "driver.licenseExpiration");
    		requiredString(this.getEntity().getLicenseClass(),"driver.licenseClass");
    	}		
    	else{
    		addActionError("Unknown error.  Please try again.");
    	}

    }
    
    public Driver getDriver() {
    	return this.getEntity();
    }
    
    public void setDriver(Driver driver) {
    	this.setEntity(driver);
    }
    
}
