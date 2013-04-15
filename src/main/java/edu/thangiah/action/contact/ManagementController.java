package edu.thangiah.action.contact;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.Action;

import edu.thangiah.action.BaseManagementController;

import edu.thangiah.dao.ContactDao;
import edu.thangiah.dao.ContractorDao;
import edu.thangiah.entity.Contact;


public class ManagementController extends BaseManagementController<Contact>{
	private static final long serialVersionUID = -8958648148807210458L;
	
	protected static final Logger LOGGER = Logger.getLogger(ManagementController.class.getName());
	
	@Autowired
	protected ContactDao contactDao;
	
	@Autowired
	protected ContractorDao contractorDao;
	
	@Override
	public void prepare() throws Exception {
		super.prepare();
		this.initializeEntityList(contactDao);
	}
	
	public String execute() {
        if (contactDao == null) {
            return Action.ERROR;
        }
        
        String result = initialize();
		if( !result.equals(SUCCESS) ){
			return result;
		}
        
        if( mode == Modes.EDIT ){
        	result = this.initializeEntityById(contactDao, id);
        	if( !result.equals(SUCCESS) ){
    			return result;
    		}
        }
        
        LOGGER.debug("Contacts number = " + getContacts().size());
        return Action.SUCCESS;
    }
	
	public Contact getContact(){
		return this.getEntity();
	}
	
	public void setContact(Contact contact){
		this.setEntity(contact);
	}
	
	public List<Contact> getContacts() {
		return this.getEntityList();
	}

	public void setContacts(List<Contact> contacts) {
		this.setEntityList(contacts);
	}
	
	public ContactDao getContactDao() {
		return contactDao;
	}
	public void setContactDao(ContactDao contactDao) {
		this.contactDao = contactDao;
	}
	
	public void setContractorDao(ContractorDao contractorDao)
	{
		this.contractorDao = contractorDao;
	}
	
	public ContractorDao getContractorDao()
	{
		return contractorDao;
	}
}
