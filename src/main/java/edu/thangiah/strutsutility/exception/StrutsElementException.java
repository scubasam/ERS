package edu.thangiah.strutsutility.exception;

/**
 * Used as a base exception class for ERS struts2 element generator classes. See {@link edu.thangiah.strutsutility.StrutsSelect}.
 * @author Kelly Smith
 *
 */
public class StrutsElementException extends Exception{
	private static final long serialVersionUID = 5674912554650496378L;
	protected String elementId;
	
	public StrutsElementException(String element, String message){
		super(message);
		this.setElementId(element);
	}

	public String getElementId() {
		return elementId;
	}

	public void setElementId(String elementId) {
		this.elementId = elementId;
	}
}
