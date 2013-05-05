package edu.thangiah.action.driver;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.Preparable;

import edu.thangiah.dao.ContactDao;
import edu.thangiah.dao.ContractorDao;
import edu.thangiah.dao.VehicleDao;
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
	
	@Autowired
	protected ContactDao contactDao;
	@Autowired
	protected VehicleDao vehicleDao;
	@Autowired
	protected ContractorDao contractorDao;
	
	
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
    	
    	}		
    	else{
    		addActionError("Unknown error.  Please try again.");
    	}

    }

	public ContactDao getContactDao() {
		return contactDao;
	}

	public void setContactDao(ContactDao contactDao) {
		this.contactDao = contactDao;
	}

	public VehicleDao getVehicleDao() {
		return vehicleDao;
	}

	public void setVehicleDao(VehicleDao vehicleDao) {
		this.vehicleDao = vehicleDao;
	}

	public ContractorDao getContractorDao() {
		return contractorDao;
	}

	public void setContractorDao(ContractorDao contractorDao) {
		this.contractorDao = contractorDao;
	}
    
}
