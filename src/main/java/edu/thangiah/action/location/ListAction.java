package edu.thangiah.action.location;

import java.util.List;

import com.opensymphony.xwork2.Action;

import edu.thangiah.entity.Location;

public class ListAction extends LocationAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7977594147174314821L;
	private List<Location> locations;
	
	@Override
	public String execute() {
        if (locationDao == null) {
            return Action.ERROR;
        }
        LOGGER.debug("Get all locations");
        locations = locationDao.findAll();
        LOGGER.debug("Locations number = " + locations.size());
        return Action.SUCCESS;
    }
	
	public List<Location> getLocations() {
		return locations;
	}

	public void setLocations(List<Location> locations) {
		this.locations = locations;
	}
}
