package edu.thangiah.action;

import edu.thangiah.entity.Contact;
import edu.thangiah.utility.UtilityFunctions;

/**
 * This class is meant to be extended by Action classes wishing to utilize Struts2 validation on form input.
 * 
 * This is primarily extended by ManagementController classes.  See edu.thangiah.action.BaseManagementController for reference.
 * 
 * @author Kelly Smith
 * @version 1.0
 */
public abstract class ValidationAction extends AbstractAction {
	private static final long serialVersionUID = -6766865678238928057L;
	
	
	
	public void runContactValidation(Contact contact){
		if( contact != null ){
    		requiredString(contact.getFirstName(), "contact.firstName");
    		requiredString(contact.getLastName(), "contact.lastName");
    		
    		requiredString(contact.getEmailAddress(), "contact.emailAddress");
    		validateEmail(contact.getEmailAddress(), "contact.emailAddress");
    		
    		requiredString(contact.getStreetAddress1(), "contact.streetAddress1");
    		requiredString(contact.getCity(), "contact.city");
    		requiredString(contact.getState(), "contact.state");
    		
    		if( contact.getState() != null ){
    			if( contact.getState().length() > 2 ){
    				this.addFieldError("contact.state", "Please use the two letter abbreviation for the State.");
    			}
    		}
    		
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
	
	
	public void requiredString(String value, String field_name){
		requiredString(value, field_name, "This is required.");
	}

	public void requiredLong(Long value, String field_name){
		requiredLong(value, field_name, "IThis is required.");
	}	
	
	public void requiredString(String value, String field_name, String message){
		if( value == null || value.length() == 0 )
    		this.addFieldError(field_name, message);
	}
	
	
	
	public void validateEmail(String email, String field_name){
		validateEmail(email, field_name, "Invalid email address.  Please enter a valid email address.");
	}
	
	public void validateEmail(String email, String field_name, String message){
		if( email != null ){
			if( !UtilityFunctions.validateEmail(email) ){
				this.addFieldError(field_name, message);
			}
		}
	}
	
	
	public void validatePhone(String phone, String field_name, String message){
		if( phone != null ){
			if( !UtilityFunctions.validatePhone(phone) ){
				this.addFieldError(field_name, message);
			}
		}
	}
	
	
	public void requiredInt(Integer value, String field_name){
		if( value == null )
    		this.addFieldError(field_name, "This is required.");
	}
	
	public void requiredLong(Long value, String field_name, String message){
		if( value == null )
    		this.addFieldError(field_name, message);
	}
	
	public void validateIntegerRange(Integer value, int min, int max, String field_name){
		requiredInt(value, field_name);
		if( value != null ){
			int intValue = value.intValue();
			if( intValue < min || intValue > max ){
				this.addFieldError(field_name, "This is required.");
			}
		}
	}
}
