package edu.thangiah.strutsutility.exception;

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
