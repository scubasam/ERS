package edu.thangiah.action.contractor;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.Preparable;

import edu.thangiah.dao.ContactDao;
import edu.thangiah.entity.Contractor;

public class AddAction extends ManagementController implements Preparable{
	
	private static final long serialVersionUID = -5800683108151609064L;
	
	@Autowired
	protected ContactDao contactDao;
	
	@Override
    public String execute(){
		if (contactDao == null || contractorDao == null || this.getEntity() == null) {
            this.addActionError(DB_ERROR_MESSAGE);
        }
		
		LOGGER.debug("Adding new contact: " + this.getEntity().toString());
		//contactDao.add(this.getEntity());
		
    	return SUCCESS;
    }
    
    // called automatically
    public void validate(){
    	if( this.getEntity() != null ){
    		requiredString(getEntity().getContractorName(), "contractor.contractorName");
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
		return this.getEntity();
	}

	/**
	 * @param contractor the contractor to set
	 */
	public void setContractor(Contractor contractor) {
		this.setEntity(contractor);
	}


	public ContactDao getContactDao() {
		return contactDao;
	}

	public void setContactDao(ContactDao contactDao) {
		this.contactDao = contactDao;
	}

	
}
