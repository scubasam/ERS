package edu.thangiah.action.contact;

/**
 *This class extends the management controller and implements preparable. It's primary function
 *is to to handle everything related to adding and Contact entity 
 * 
 * @author Alex McCracken, Kelly Smith
 */


import com.opensymphony.xwork2.Preparable;

import edu.thangiah.entity.Contact;

public class AddAction extends ManagementController implements Preparable{

	private static final long serialVersionUID = -1708978099566079365L;
	
	@Override
    public String execute(){
		if (contactDao == null || this.getEntity() == null) {
            this.addActionError(DB_ERROR_MESSAGE);
        }
		
		LOGGER.debug("Adding new contact: " + this.getEntity().toString());
		contactDao.add(this.getEntity());
		
    	return SUCCESS;
    }
    
    // called automatically
    public void validate(){
    	this.runContactValidation(this.getEntity());
    }

	/**
	 * @return the contact
	 */
	public Contact getContact() {
		return this.getEntity();
	}

	/**
	 * @param contact the contact to set
	 */
	public void setContact(Contact contact) {
		this.setEntity(contact);
	}
	
}
