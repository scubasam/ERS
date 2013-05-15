package edu.thangiah.strutsutility;

import java.util.List;

import com.opensymphony.xwork2.Action;

import edu.thangiah.dao.AbstractDao;
import edu.thangiah.entity.EntityInterface;
import edu.thangiah.strutsutility.exception.StrutsElementDaoException;
import edu.thangiah.strutsutility.exception.StrutsElementDataException;
import edu.thangiah.strutsutility.exception.StrutsElementException;

/**
 * Utility class for parsing and generating struts2 jsp select elements from a given datasource.
 * @author Kelly Smith
 */
public class StrutsSelect<Entity extends EntityInterface> implements StrutsElementValidator {
	
	private AbstractDao<Entity> dao;
	
	private List<Entity> entityList;
	private String elementId;
	private boolean required;
	
	private Long selected;
	private Entity selectedEntity;
	
	public StrutsSelect(AbstractDao<Entity> daoObject, String elementId) throws StrutsElementException{
		this(daoObject, elementId, true);
	}
	
	/**
	 * Initializes the select element with all the information necessary for displaying a JSP form element.
	 * @param daoObject A data access object for interfacing the database.
	 * @param elementId A unique string identifier for the given form element.
	 * @param required Whether or not the select element is required for form submission.
	 * @throws StrutsElementException Thrown when either the daoObject is null or no entity list was able to be retrieved from the database.
	 */
	public StrutsSelect(AbstractDao<Entity> daoObject, String elementId, boolean required) throws StrutsElementException{
		dao = daoObject;
		if( dao == null ){
			throw new StrutsElementDaoException(elementId, "Entity Dao was never instantiated.");
		}
		
		this.elementId = elementId;
		entityList = dao.findAll();
		
		this.required = required;
		
		if( entityList == null ){
			throw new StrutsElementDataException(elementId, "An unknown data error occured.  Could not get the list of entities from the database.");
		}
	}

	public List<Entity> getList() {
		return entityList;
	}

	public void setList(List<Entity> entityList) {
		this.entityList = entityList;
	}

	public Long getSelected() {
		return selected;
	}

	public void setSelected(Long selected) {
		this.selected = selected;
	}

	/**
	 * Initializes the select element with whichever element was specified in the form with this select.
	 * @return SUCCESS or an error message.
	 * @throws StrutsElementException Throws exception if no DAO has been defined.
	 */
	public String initializeSelected() throws StrutsElementException {
		
		if( dao == null ){
			throw new StrutsElementDaoException(elementId, "Entity Dao was never instantiated.");
		}
		
		if( selected != null && selected != 0 ){
			List<Entity> fromDb = dao.findById(selected);
			if( fromDb == null || fromDb.size() != 1 ){
				return "No element exists with that id.";
			}
			
			setSelectedEntity(fromDb.get(0));
		}
		else{
			if( isRequired() ){
				return "This field is required.";
			}
		}
		return Action.SUCCESS;
	}
	
	/**
	 * Initializes the select to default to whatever is currently set in the given entity.
	 * @param entity
	 */
	public void intializeFromEntity(Entity entity) {
		if( entity != null ){
			selected = entity.getId();
			selectedEntity = entity;
		}
	}

	public Entity getSelectedEntity() {
		return selectedEntity;
	}

	public void setSelectedEntity(Entity selectedEntity) {
		this.selectedEntity = selectedEntity;
	}

	@Override
	public boolean hasSelectedValue() {
		if( selected == 0 && selectedEntity == null )
			return false;
		return true;
	}
	
	public boolean isRequired() {
		return required;
	}

}