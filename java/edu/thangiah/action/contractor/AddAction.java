package edu.thangiah.action.contractor;

import org.springframework.beans.factory.annotation.Autowired;
import com.opensymphony.xwork2.Preparable;
import edu.thangiah.dao.ContactDao;
import edu.thangiah.entity.Contact;
import edu.thangiah.entity.Contractor;

public class AddAction extends ContractorAction implements Preparable{
	
	private static final long serialVersionUID = -5800683108151609064L;
	private Contractor contractor;
	private Contact contact;
	
	@Autowired
	protected ContactDao contactDao;
	
	@Override
    public String execute() throws Exception
    {
		if (contractorDao == null || contractor == null) 
		{
            this.addActionError(DB_ERROR_MESSAGE);
        }
		
		contactDao.add(contact);
		contractor.setContact(contact);
		
		LOGGER.debug("Adding new contact: " + contractor.toString());
		contractorDao.add(contractor);
		
    	return SUCCESS;
    }
    
    // called automatically
    public void validate(){
    	if( contractor != null ){
    		requiredString(contractor.getContractorName(), "contractor.contractorName");
    	}
    	else{
    		addActionError("Unknown error.  Please try again.");
    	}
    	
    	this.runContactValidation(contact);
    	
    }

	/**
	 * @return the contractor
	 */
	public Contractor getContractor() {
		return contractor;
	}

	/**
	 * @param contractor the contractor to set
	 */
	public void setContractor(Contractor contractor) {
		this.contractor = contractor;
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
