package edu.thangiah.action.contact;

import com.opensymphony.xwork2.Preparable;

import edu.thangiah.entity.Contact;

public class AddAction extends ContactAction implements Preparable{

	private static final long serialVersionUID = -1708978099566079365L;
	
	private Contact contact;
	
	@Override
    public String execute() throws Exception{
    	return SUCCESS;
    }
    
    // called automatically
    public void validate(){
    	if( contact != null ){
    		requiredString(contact.getFirstName(), "contact.firstName");
    		requiredString(contact.getLastName(), "contact.lastName");
    		
    		requiredString(contact.getEmailAddress(), "contact.emailAddress");
    		validateEmail(contact.getEmailAddress(), "contact.emailAddress");
    		
    		requiredString(contact.getStreetAddress1(), "contact.streetAddress1");
    		requiredString(contact.getCity(), "contact.city");
    		requiredString(contact.getState(), "contact.state");
    		requiredString(contact.getZip(), "contact.zip");
    		
    		requiredString(contact.getPrimaryPhone(), "contact.primaryPhone");
    		validatePhone(contact.getPrimaryPhone(), "contact.primaryPhone", "Invalid phone number.  Please use the form (xxx) xxx-xxxx.");
    		if( contact.getWorkPhone() != null )
    			validatePhone(contact.getWorkPhone(), "contact.workPhone", "Invalid phone number.  Please use the form (xxx) xxx-xxxx.");
    	}
    	else{
    		addActionError("Unknown error.  Please try again.");
    	}
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
