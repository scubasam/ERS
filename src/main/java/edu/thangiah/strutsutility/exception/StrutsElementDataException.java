package edu.thangiah.strutsutility.exception;

public class StrutsElementDataException extends StrutsElementDaoException {
	private static final long serialVersionUID = -417781081426076047L;
	
	
	public StrutsElementDataException(String element, String message){
		super(element, message);
	}
}
