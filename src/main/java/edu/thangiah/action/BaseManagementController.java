package edu.thangiah.action;

import java.util.List;


import edu.thangiah.action.BaseManagementController.ErrorCode;
import edu.thangiah.dao.AbstractDao;


public class BaseManagementController<Entity> extends ValidationAction{

	private static final long serialVersionUID = -2362751985753499059L;
	
	protected long id; // used for editing specific records.
	protected String deleted;
	
	protected Modes mode;
	protected enum Modes {LIST, EDIT, ADD, DELETE};
	
	public enum ErrorCode {FATAL, ERROR};
	
	private List<Error> errors;
	
	private List<Entity> entityList;
	private Entity entity;
	
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
	
	
	protected Entity retrieveEntityById(AbstractDao<Entity> dao, long id){
		if( id <= 0 ){
			this.addActionError("Unable to initialize record");
		}
		
		List<Entity> fromDb = dao.findById(id);
		if( fromDb == null || fromDb.size() == 0 ){
			entityNotFoundError();
			return null;
		}
		
		return fromDb.get(0);
	}
	
	protected String initializeEntityById(AbstractDao<Entity> dao, long id){
		this.setEntity(this.retrieveEntityById(dao, id));
		if( this.entity != null )
			return SUCCESS;
		else
			return ERROR;
	}
	
	protected String initializeEntityList(AbstractDao<Entity> dao){
		if (dao == null) {
            return ERROR;
        }
		entityList = dao.findAll();
		return SUCCESS;
	}
	
	protected List<Entity> getEntityList(){
		return entityList;
	}
	
	protected void setEntityList(List<Entity> list){
		entityList = list;
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

	public String getDeleted() {
		return deleted;
	}

	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}
	
	public boolean deleteSuccessful(){
		if( deleted != null && deleted.equals("true") )
			return true;
		
		return false;
	}
	
	public String deleteSuccessfulMessage(){
		return "User was successfully deleted.";
	}

	public Entity getEntity() {
		return entity;
	}

	public void setEntity(Entity entity) {
		this.entity = entity;
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
