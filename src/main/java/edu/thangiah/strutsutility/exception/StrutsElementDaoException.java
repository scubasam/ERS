package edu.thangiah.strutsutility.exception;

/**
 * Allows for a specific exception based on improper DAO state.
 * @author Kelly Smith
 *
 */
public class StrutsElementDaoException extends StrutsElementException {
	private static final long serialVersionUID = -417781081426076047L;
	
	public StrutsElementDaoException(String element, String message){
		super(element, message);
	}
}
