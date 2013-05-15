package edu.thangiah.strutsutility.exception;

/**
 * Allows for a specific exception about invalid data being initialized for a struts element.
 * @author Kelly Smith
 * 
 */
public class StrutsElementDataException extends StrutsElementDaoException {
	private static final long serialVersionUID = -417781081426076047L;
	
	
	public StrutsElementDataException(String element, String message){
		super(element, message);
	}
}
