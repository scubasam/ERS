package edu.thangiah.action;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


import edu.thangiah.action.BaseManagementController.ErrorCode;
import edu.thangiah.dao.AbstractDao;
import edu.thangiah.entity.EntityInterface;
import edu.thangiah.user.entity.User;

/**
 * This class servers as the parent class for all ManagementController classes.  It provides all the core functionality for loading up the
 * entity list grid on each management page.  Additionally, it provides functionality for changing which columns are visible on each
 * management page.
 * @author Kelly Smith
 *
 * @param <Entity> 
 */
public abstract class BaseManagementController<Entity extends EntityInterface> extends ValidationAction{

	protected static final String MISSING_COLUMNS_ERROR = "Child management classes must initialize the columnMap attribute.";

	private static final long serialVersionUID = -2362751985753499059L;
	
	protected long id; // used for editing specific records.
	protected String deleted;
	
	protected Modes mode;
	protected enum Modes {LIST, EDIT, ADD, DELETE};
	
	public enum ErrorCode {FATAL, ERROR};
	
	private List<Error> errors;
	
	private List<Entity> entityList;
	private Entity entity;
	
	private String gridHeaders;
	protected String gridBody;
	protected Map<String, String> columnLabels;
	protected String[] visibleColumns;
	
	
	// Consists of Label => EntityFieldName
	protected static final Map<String, String> columnMap;
	static {
		Map<String, String> columns = new HashMap<String, String>();
		columnMap = Collections.unmodifiableMap(columns);
	}

	/**
	 * Must be overridden by all management controllers as it is used for generating the grid header and body code.
	 * @return A map of column ids mapped to their visual names.
	 */
	protected Map<String, String> getColumnMap(){
		return columnMap;
	}
	
	/**
	 * 
	 * @return A unique identifier for this controller. Must be overridden by all management controllers as it is used for generating the grid header and body code.
	 */
	protected abstract String getActionId();
	
	/**
	 * 
	 * @return A Set of column names that should be visible for this controller.
	 */
	protected Set<String> getColumnVisibilitySet(){
		if( currentUser != null && this.isLoggedIn() ){
			Map<String, Set<String>> visibilityMap = currentUser.getColumnVisibilityMap();
			if( visibilityMap == null || visibilityMap.size() == 0 ){
				return null;
			}
			
			if( !visibilityMap.containsKey(this.getActionId()) ){
				return null;
			}
			
			return visibilityMap.get(this.getActionId());
		}
		else{
			return null;
		}
	}
	
	/**
	 * Generates <th></th> elements for each column for a given entity.  Takes into account which ones are supposed to be visible.
	 * @param visibilitySet A Set of String elements which correspond to the keys of the columnMap for this management controller.
	 * @return An HTML formatted String containing a list of table header elements.
	 */
    private String generateGridHeaders(Set<String> visibilitySet){
    	if( getColumnMap() == null || getColumnMap().size() <= 0 ){
    		throw new UnsupportedOperationException(MISSING_COLUMNS_ERROR);
    	}
    	
    	String headerOutput = "";
    	for( Map.Entry<String, String> entry : getColumnMap().entrySet() ){
    		String fieldName = entry.getKey();
    		String fieldLabel = entry.getValue();
    		
    		// Default to globalVisibility
    		if( visibilitySet == null || visibilitySet.contains(fieldName) ){
    			headerOutput += "<th>" + fieldLabel + "</th>\n";
    		}
    		else{
    			continue;
    		}
    	}
    	return headerOutput;
    }
    
    /**
     * This method generates HTML elements for each row of a management controller grid.  It uses java reflections to dynamically pull
     * data from a List of entities given the visibility set which is provided.
     * @param visibilitySet A set which determines which columns should be displayed in the grid.
     * @param entityList A list of entities that will be displayed in the grid.
     * @param classInstance The class of the particular entities being displayed, which is used for java reflection.
     * @param editLink A url which is inserted as the destination for the edit button.
     * @return An HTML formatted String containing table row entries for a list of entities.
     */
    protected String generateGridBody(Set<String> visibilitySet, List<Entity> entityList, Class<Entity> classInstance, String editLink){
    	if( getColumnMap() == null || getColumnMap().size() <= 0 ){
    		throw new UnsupportedOperationException(MISSING_COLUMNS_ERROR);
    	}
    	
    	String bodyOutput = "";
    	if( entityList == null ){
    		return "An unknown error occured while generating this grid.  Please contact your system administrator.";
    	}
    	
    	@SuppressWarnings("unchecked")
    	Class<User>[] noParameters = (Class<User>[]) new Class[0];
    	
    	for( Entity entity : entityList ){
    		bodyOutput += "<tr id=\"row" + entity.getId() +"\">\n";
    		bodyOutput += "<td><a href=\"" + editLink + "?id=" + entity.getId() + "\">Edit</a></td>\n";
    		for( String fieldName : getColumnMap().keySet() ){
    			if( visibilitySet == null || visibilitySet.contains(fieldName) ){
	    			try {
	    				String getFieldName = "get" + fieldName.substring(0,1).toUpperCase() + fieldName.substring(1, fieldName.length());
	    				Method getMethod = classInstance.getDeclaredMethod(getFieldName, noParameters);
						//Field thisField = classInstance.getDeclaredField(fieldName);
						//thisField.setAccessible(true);
						String fieldValue = "";
						if( getMethod != null && entity != null ){
							Object returnObj = getMethod.invoke(entity, (Object [])null);
							if( returnObj != null ){
								fieldValue = returnObj.toString();
							}
						}
						bodyOutput += "<td>" + fieldValue + "</td>\n";
	    			}
	    			catch (NoSuchMethodException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}catch (SecurityException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	    			catch (ClassCastException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
    			}
    		}
    		bodyOutput += "</tr>\n";
    	}
    	
    	return bodyOutput;
    }
	
	@Override
	public void prepare() throws Exception {
		super.prepare();
		errors = null; // reset errors on each page load.
		
		// Generates the HTML code for the data grid head.
		setGridHeaders(generateGridHeaders(this.getColumnVisibilitySet()));
		
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
	
	/**
	 * Provides a generic interfaces for making database calls to retrieve an entity by their id.
	 * @param dao A DAO instance for accessing the database.
	 * @param id
	 * @return An entity from the database with the given type (specified by the dao being used) and id.
	 */
	protected Entity retrieveEntityById(AbstractDao<Entity> dao, long id){
		if( id <= 0 ){
			this.addActionError("Unable to initialize record");
		}
		
		if( dao != null ){
			List<Entity> fromDb = dao.findById(id);
			if( fromDb == null || fromDb.size() == 0 ){
				entityNotFoundError();
				return null;
			}
			
			return fromDb.get(0);
		}
		else
			return null;
	}
	
	/**
	 * Initializes management controllers with an entity based on the id that was submitted for the purposes of editing.
	 * @param dao A DAO instance for accessing the database.
	 * @param id
	 * @return SUCCESS or ERROR
	 */
	protected String initializeEntityById(AbstractDao<Entity> dao, long id){
		this.setEntity(this.retrieveEntityById(dao, id));
		if( this.entity != null )
			return SUCCESS;
		else
			return ERROR;
	}
	
	/**
	 * Automatically initializes a list of entities for a given management controller for the purposes of displaying in the management grid.
	 * @param dao A DAO instance for accessing the database.
	 * @return SUCCESS or ERROR
	 */
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
			case ADD:
				return "add";
			case DELETE:
				return "delete";
			default:
				return "list";
		}
	}
	
	/**
	 * Adds error to the controller which will eventually be displayed to the user.
	 * @param code Specifies the type of the error.
	 * @param errorMessage Adds specific error information.
	 */
	protected void addControllerError(ErrorCode code, String errorMessage){
		if( errors == null ){
			errors = new ArrayList<Error>();
		}
		errors.add(new Error(code, errorMessage));
	}
	
	/**
	 * 
	 * @return true if the controller has errors, false otherwise.
	 */
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
	
	/**
	 * Used to determine if a delete was successful for the purposes of displaying a message to the user.  Utilized in manage.jsp files.
	 * @return true if the entity was deleted, false otherwise.
	 */
	public boolean deleteSuccessful(){
		if( deleted != null && deleted.equals("true") )
			return true;
		
		return false;
	}
	
	public String deleteSuccessfulMessage(){
		return "Entity was deleted";
	}

	public Entity getEntity() {
		return entity;
	}

	public void setEntity(Entity entity) {
		this.entity = entity;
	}

	public String getGridHeaders() {
		return gridHeaders;
	}

	public void setGridHeaders(String columnHeaders) {
		this.gridHeaders = columnHeaders;
	}

	public String getGridBody() {
		return gridBody;
	}

	public void setGridBody(String columnBody) {
		this.gridBody = columnBody;
	}

	public Map<String, String> getColumnLabels() {
		columnLabels = this.getColumnMap();
		return columnLabels;
	}

	public void setColumnLabels(Map<String, String> columnLabels) {
		this.columnLabels = columnLabels;
	}
	
	/**
	 * Generates an array of String column names based on a Set which was retrieved from the user session information.
	 * @return An array of String column names.
	 */
	public String[] getVisibleColumns() {
		if( visibleColumns == null ){
			Set<String> visibleSet = this.getColumnVisibilitySet();
			if( visibleSet == null || visibleSet.size() <= 0 ){
				visibleSet = this.getColumnMap().keySet();
			}
			if( visibleSet != null ){
				visibleColumns = visibleSet.toArray(new String[visibleSet.size()]);
			}
		}
		
		return visibleColumns;
	}

	public void setVisibleColumns(String[] visibleColumns) {
		this.visibleColumns = visibleColumns;
	}
}

/**
 * A generic class for holding error information.  Used to store controller errors.
 * @author Kelly Smith
 *
 */
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
