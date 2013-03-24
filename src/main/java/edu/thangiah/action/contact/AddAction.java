package edu.thangiah.action.contact;

import com.opensymphony.xwork2.Preparable;

import edu.thangiah.entity.Contact;

public class AddAction extends ContactAction implements Preparable{

	private static final long serialVersionUID = -1708978099566079365L;
	
	private Contact contact;
	
	@Override
    public String execute() throws Exception{
		if (contactDao == null || contact == null) {
            this.addActionError(DB_ERROR_MESSAGE);
        }
		
		LOGGER.debug("Adding new contact: " + contact.toString());
		contactDao.add(contact);
		
    	return SUCCESS;
    }
    
    // called automatically
    public void validate(){
    	this.runContactValidation(contact);
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
	
}
