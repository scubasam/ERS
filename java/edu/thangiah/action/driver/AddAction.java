package edu.thangiah.action.driver;

import org.springframework.beans.factory.annotation.Autowired;
import com.opensymphony.xwork2.Preparable;
import edu.thangiah.dao.ContactDao;
import edu.thangiah.entity.Contact;
import edu.thangiah.entity.Driver;

public class AddAction extends DriverAction implements Preparable{

	private static final long serialVersionUID = -1708978099566079365L;
	private Driver driver;
	private Contact contact;
	
	@Autowired
	protected ContactDao contactDao;
	
	@Override
    public String execute() throws Exception
    {
		if (driverDao == null || driver == null) 
		{
            this.addActionError(DB_ERROR_MESSAGE);
        }
		
		contactDao.add(contact);
		driver.setContact(contact);
		
		driverDao.add(driver);
		
    	return SUCCESS;
    }
    
    // called automatically
    public void validate(){
    	if( driver != null )
    	{
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
	
	/**
	 * @return the contact
	 */
	public Contact getContact() {
		return contact;
	}

	/**
	 * @param contact the contact to set
	 */
	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public ContactDao getContactDao() {
		return contactDao;
	}

	public void setContactDao(ContactDao contactDao) {
		this.contactDao = contactDao;
	}
	
}
