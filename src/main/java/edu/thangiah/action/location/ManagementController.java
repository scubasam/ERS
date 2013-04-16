package edu.thangiah.action.location;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.Action;

import edu.thangiah.action.BaseManagementController;
import edu.thangiah.dao.ContractorDao;
import edu.thangiah.dao.LocationDao;
import edu.thangiah.entity.Contact;
import edu.thangiah.entity.Contractor;
import edu.thangiah.entity.Location;


public class ManagementController extends BaseManagementController<Location>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1194255798482840950L;

	protected static final Logger LOGGER = Logger.getLogger(ManagementController.class.getName());
	
	@Autowired
	protected LocationDao locationDao;
	
	@Override
	public void prepare() throws Exception {
		super.prepare();
		this.initializeEntityList(locationDao);
	}
	
	public String execute() {
        if (locationDao == null) {
            return Action.ERROR;
        }
        
        String result = initialize();
		if( !result.equals(SUCCESS) ){
			return result;
		}
        
        if( mode == Modes.EDIT ){
        	result = this.initializeEntityById(locationDao, id);
        	if( !result.equals(SUCCESS) ){
    			return result;
    		}
        }
        
        LOGGER.debug("Contractors number = " + getLocations().size());
        return Action.SUCCESS;
    }
	
	public List<Location> getLocations() {
		return this.getEntityList();
	}

	public void setContractors(List<Location> locations) {
		this.setEntityList(locations);
	}
	
	
	public Location getLocation(){
		return this.getEntity();
	}
	
	public void setLocation(Location location){
		this.setEntity(location);
	}

	public LocationDao getLocationDao() {
		return locationDao;
	}

	public void setLocationDao(LocationDao locationDao) {
		this.locationDao = locationDao;
	}
}
