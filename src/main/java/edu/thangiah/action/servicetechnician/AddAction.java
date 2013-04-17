package edu.thangiah.action.servicetechnician;

import org.springframework.beans.factory.annotation.Autowired;
import com.opensymphony.xwork2.Preparable;

import edu.thangiah.dao.ContactDao;
import edu.thangiah.dao.ServiceTechnicianDao;
import edu.thangiah.entity.Contact;
import edu.thangiah.entity.MaintenanceOrder;
import edu.thangiah.dao.MaintenanceOrderDao;
import edu.thangiah.entity.ServiceTechnician;

public class AddAction extends MaintenanceOrder implements Preparable{

	private static final long serialVersionUID = -1708978099566079365L;
	private ServiceTechnician serviceTechnician;
	private Contact contact;
	//private MaintenanceOrder maintenanceOrder;
	
	@Autowired
	protected ServiceTechnicianDao serviceTechnicianDao;
	
	@Autowired
	protected ContactDao contactDao;
	
	@Autowired
	protected MaintenanceOrderDao maintenanceOrderDao;
	
	@Override
    public String execute() throws Exception
    {
		/*
		if (serviceTechnicianDao == null || serviceTechnician == null) 
		{
            this.addActionError(DB_ERROR_MESSAGE);
        }
		
		serviceTechnicianDao.add(serviceTechnician);
		contactDao.add(contact);
		maintenanceOrderDao.add(maintenanceOrder);
		//serviceTechnician.setMaintenanceOrders(maintenanceOrders)
		serviceTechnician.setContact(contact);
		serviceTechnicianDao.add(serviceTechnician);
		*/
    	return SUCCESS;
    }
    
    // called automatically
    public void validate(){
    	if(serviceTechnician != null && contact != null )
    	{
    		requiredLong(serviceTechnician.getId(), "serviceTechnician.id");
    		requiredString(serviceTechnician.getContact().toString(), "serviceTechnician.contact");
    		requiredString(serviceTechnician.getSkillGrade(), "serviceTechnician.skillGrade");
    		this.runContactValidation(contact);
    	}		
    	else{
    		addActionError("Unknown error.  Please try again.");
    	}

    }

	/**
	 * @return the contact
	 */
	public ServiceTechnician getServiceTechnician()
	{
		return serviceTechnician;
	}

	/**
	 * @param contact the contact to set
	 */
	public void setServiceTechnician(ServiceTechnician serviceTechnician)
	{
		this.serviceTechnician = serviceTechnician;
	}
	
	/**
	 * @return the contact
	 */
	public Contact getContact()
	{
		return contact;
	}

	public ContactDao getContactDao() {
		return contactDao;
	}

	public void setContactDao(ContactDao contactDao) {
		this.contactDao = contactDao;
	}

	public ServiceTechnicianDao getServiceTechnicianDao()
	{
		return serviceTechnicianDao;
	}

	public void setServiceTechnicianDao(ServiceTechnicianDao serviceTechnicianDao)
	{
		this.serviceTechnicianDao = serviceTechnicianDao;
	}

	public MaintenanceOrderDao getMaintenanceOrderDao()
	{
		return maintenanceOrderDao;
	}

	public void setMaintenanceOrderDao(MaintenanceOrderDao maintenanceOrderDao)
	{
		this.maintenanceOrderDao = maintenanceOrderDao;
	}	
	
	@Override
	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		
	}
	
}
