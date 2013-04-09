package edu.thangiah.action;

import java.util.ArrayList;

import edu.thangiah.action.BaseManagementController.ErrorCode;


public class BaseManagementController extends ValidationAction{

	private static final long serialVersionUID = -2362751985753499059L;
	
	protected long id; // used for editing specific records.
	
	protected Modes mode;
	protected enum Modes {LIST, EDIT, ADD};
	
	public enum ErrorCode {FATAL, ERROR};
	
	private ArrayList<Error> errors;
	
	@Override
	public void prepare() throws Exception {
		super.prepare();
		
		errors = null; // reset errors on each page load.
		
	}
	
	protected String initialize(){
		if( this.id != 0 ){
			mode = Modes.EDIT;
		}
		
		if( mode == null ){
			mode = Modes.LIST; // default to list
		}
		
		return SUCCESS;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	protected void entityNotFoundError(){
		this.addActionError("The entity with id(" + id + ") could not be found in the database. Please try again.");
	}
	
	public String getMode(){
		switch(this.mode){
			case LIST:
				return "list";
			case EDIT:
				return "edit";
			default:
				return "list";
		}
	}
	
	protected void addControllerError(ErrorCode code, String errorMessage){
		errors.add(new Error(code, errorMessage));
	}
	
	public boolean hasControllerErrors(){
		if( errors != null && errors.size() > 0 )
			return true;
		else
			return false;
	}
}

class Error{
	ErrorCode code;
	String message;
	
	public Error(ErrorCode code, String message){
		this.code = code;
		this.message = message;
	}
	
	public String toString(){
		return code.name() + ": " + message;
	}
}
