package edu.thangiah.strutsutility;

import java.util.List;

import com.opensymphony.xwork2.Action;

import edu.thangiah.dao.AbstractDao;
import edu.thangiah.entity.EntityInterface;
import edu.thangiah.entity.Route;
import edu.thangiah.strutsutility.exception.StrutsElementDaoException;
import edu.thangiah.strutsutility.exception.StrutsElementDataException;
import edu.thangiah.strutsutility.exception.StrutsElementException;

/**
 * Utility class for parsing and generating struts2 jsp select elements from a given datasource.
 * @author Kelly Smith
 */
public class StrutsSelect<Entity extends EntityInterface> {
	
	private AbstractDao<Entity> dao;
	
	private List<Entity> entityList;
	private String elementId;
	
	private Long selected;
	private Entity selectedEntity;
	
	public StrutsSelect(AbstractDao<Entity> daoObject, String elementId) throws StrutsElementException{
		dao = daoObject;
		if( dao == null ){
			throw new StrutsElementDaoException(elementId, "Entity Dao was never instantiated.");
		}
		
		this.elementId = elementId;
		entityList = dao.findAll();
		
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

	public String initializeSelected() throws StrutsElementException {
		
		if( dao == null ){
			throw new StrutsElementDaoException(elementId, "Entity Dao was never instantiated.");
		}
		
		if( selected != 0 ){
			List<Entity> fromDb = dao.findById(selected);
			if( fromDb == null || fromDb.size() != 1 ){
				return "No element exists with that id.";
			}
			
			setSelectedEntity(fromDb.get(0));
		}
		
		return Action.SUCCESS;
	}
	
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

}