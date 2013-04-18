package edu.thangiah.strutsutility.exception;

public class StrutsElementDaoException extends StrutsElementException {
	private static final long serialVersionUID = -417781081426076047L;
	
	public StrutsElementDaoException(String element, String message){
		super(element, message);
	}
}
