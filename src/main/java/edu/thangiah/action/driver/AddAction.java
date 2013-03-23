package edu.thangiah.action.driver;

import com.opensymphony.xwork2.Preparable;
import edu.thangiah.entity.Driver;
import org.apache.log4j.Logger;

public class AddAction extends DriverAction implements Preparable{

	private static final long serialVersionUID = -1708978099566079365L;
	
	private Driver driver;
	
	@Override
    public String execute() throws Exception{
		if (driverDao == null || driver == null) {
            this.addActionError(DB_ERROR_MESSAGE);
        }
		
//		LOGGER.debug("Adding new driver: " + driver.toString());
		driverDao.add(driver);
		
    	return SUCCESS;
    }
    
    // called automatically
    public void validate(){
    	if( driver != null ){
    		requiredString(driver.getContact().toString(), "driver.Contact");
    		requiredString(driver.getLicenseClass(), "driver.Id");
    		requiredString(driver.getLicenseNumber(), "driver.licenseNumber");
    		requiredString(driver.getLicenseExpiration().toString(), "driver.licenseExpiration");
    	}		
    	else{
    		addActionError("Unknown error.  Please try again.");
    	}
    }

	/**
	 * @return the contact
	 */
	public Driver getDriver()
	{
		return driver;
	}

	/**
	 * @param contact the contact to set
	 */
	public void setDriver(Driver driver) {
		this.driver = driver;
	}
	
}
