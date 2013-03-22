package edu.thangiah.action;

import edu.thangiah.utility.UtilityFunctions;

/**
 * This class is meant to be extended by Action classes wishing to utilize Struts2 validation on form input.
 * 
 * This class should be extended by base action classes.  See edu.thangiah.action.contact.ContactAction for reference.
 * 
 * @author Kelly
 * @version 1.0
 */
public class ValidationAction extends AbstractAction {
	private static final long serialVersionUID = -6766865678238928057L;
	
	public void requiredString(String value, String field_name){
		requiredString(value, field_name, "This field is required.");
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
	
	
	public void requiredInt(Integer value, String field_name, String message){
		if( value == null )
    		this.addFieldError(field_name, message);
	}
	
	public void validateIntegerRange(Integer value, int min, int max, String field_name, String message){
		requiredInt(value, field_name, message);
		if( value != null ){
			int intValue = value.intValue();
			if( intValue < min || intValue > max ){
				this.addFieldError(field_name, message);
			}
		}
	}
}
