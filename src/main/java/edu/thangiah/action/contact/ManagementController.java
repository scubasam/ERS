package edu.thangiah.action.contact;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.Action;

import edu.thangiah.action.BaseManagementController;

import edu.thangiah.dao.ContactDao;
import edu.thangiah.dao.ContractorDao;
import edu.thangiah.entity.Contact;

/**
 * 
 * This class extends our base management controller class and handles
 * the specific get and sets to the database for all actions pertaining to the 
 * entity Contact
 * 
 * 
 * @author Alex McCracken, Kelly Smith
 *
 */
public class ManagementController extends BaseManagementController<Contact>{
	private static final long serialVersionUID = -8958648148807210458L;
	
	protected static final Logger LOGGER = Logger.getLogger(ManagementController.class.getName());
	
	@Autowired
	protected ContactDao contactDao;
	
	@Autowired
	protected ContractorDao contractorDao;
	
	protected static final Map<String, String> columnMap;
	static {
		Map<String, String> columns = new LinkedHashMap<String, String>();
		columns.put("firstName", "First Name");
		columns.put("lastName", "Last Name");
		columns.put("middleInitial", "Middle Initial");
		columns.put("emailAddress", "Email Address");
		columns.put("streetAddress1", "Street Address 1");
		columns.put("streetAddress2", "Street Address 2");
		columns.put("city", "City");
		columns.put("state", "State");
		columns.put("zip", "Zip");
		columns.put("primaryPhone", "Primary Phone");
		columns.put("workPhone", "Work Phone");
		columnMap = Collections.unmodifiableMap(columns);
	}
	
	@Override
	protected String getActionId() {
		return "contact";
	}
	
	// Feeds the column map specific to this class into the auto field generator.
	@Override
	protected Map<String, String> getColumnMap(){
		return columnMap;
	}
	
	@Override
	public void prepare() throws Exception {
		super.prepare();
		this.initializeEntityList(contactDao);
		gridBody = this.generateGridBody(this.getColumnVisibilitySet(), this.getEntityList(), Contact.class, "contactManagement.action");
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
