package edu.thangiah.action;

import java.util.HashMap;

public class AbstractAction {
	private boolean error;
	private String errorMessage;
	private HashMap<String, String> fieldErrors;
	
	
	
	public boolean isError() {
		return error;
	}
	public void setError(boolean error) {
		this.error = error;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public HashMap<String, String> getFieldErrors() {
		return fieldErrors;
	}
	public void setFieldErrors(HashMap<String, String> fieldErrors) {
		this.fieldErrors = fieldErrors;
	}
	
	
}
