package edu.thangiah.action.servicetechnician;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.Preparable;

import edu.thangiah.dao.ContactDao;
import edu.thangiah.dao.DriverDao;
import edu.thangiah.dao.MaintenanceOrderDao;
import edu.thangiah.dao.ServiceTechnicianDao;
import edu.thangiah.dao.VehicleDao;
import edu.thangiah.entity.MaintenanceOrder;
import edu.thangiah.entity.ServiceTechnician;

/**
 *This class extends the management controller and implements preparable. It's primary function
 *is to to handle everything related to adding and Service Technician entity 
 * 
 * @author Alex McCracken, Kelly Smith
 */


public class AddAction extends ManagementController implements Preparable{
	
	private static final long serialVersionUID = -5800683108151609064L;
	
	@Autowired
	protected MaintenanceOrderDao maintenanceOrderDao;
	
	@Autowired
	protected ContactDao contactDao;
	
	@Override
    public String execute(){
		if (contactDao == null  || maintenanceOrderDao == null || this.getEntity() == null) {
            this.addActionError(DB_ERROR_MESSAGE);
        }
		maintenanceOrderDao.add(this.maintenanceOrder);
		this.getEntity().setMaintenanceOrders(maintenanceOrder);
		contactDao.add(contact);
		this.getEntity().setContact(contact);
		serviceTechnicianDao.add(this.getEntity());
		
    	return SUCCESS;
    }
    
    // called automatically
    public void validate(){
    	if( this.getEntity() != null ){
    		
    	}
    	else{
    		addActionError("Unknown error.  Please try again.");
    	}
    }

    
    public ServiceTechnician getServiceTechnician()
    {
    	return this.getEntity();
    }
    
    public void setServiceTechnician(ServiceTechnician serviceTechnician)
    {
    	this.setEntity(serviceTechnician);
    }

	public MaintenanceOrderDao getMaintenanceOrderDao() {
		return maintenanceOrderDao;
	}

	public void setMaintenanceOrderDao(MaintenanceOrderDao maintenanceOrderDao) {
		this.maintenanceOrderDao = maintenanceOrderDao;
	}

	public ContactDao getContactDao() {
		return contactDao;
	}

	public void setContactDao(ContactDao contactDao) {
		this.contactDao = contactDao;
	}
    
}
