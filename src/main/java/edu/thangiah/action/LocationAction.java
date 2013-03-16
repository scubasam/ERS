package edu.thangiah.action;

import java.util.List;



import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
 
import edu.thangiah.dao.LocationDao;
import edu.thangiah.entity.Contractor;
import edu.thangiah.entity.Location;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.Preparable;
 
public class LocationAction implements Preparable {
 
    private static final Logger LOGGER = Logger.getLogger(ContactAction.class.getName());
 
    private List<Location> locations;
    
    private String name = null;
    private String streetAddress1 = null;
    private String streetAddress2 = null;
    private String city = null;
    private String state = null;
    private String zip = null;
    private String roadName = null;
    private Integer roadNumber = null;
    private String latitude = null;
    private String longitude = null;
    private String locationType = null;
    private Contractor contractor = null;
    
    @Autowired
    private LocationDao locationDao;
    
	@Override
	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	// ACTION METHODS
	public String listAll() {
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStreetAddress1() {
		return streetAddress1;
	}

	public void setStreetAddress1(String streetAddress1) {
		this.streetAddress1 = streetAddress1;
	}

	public String getStreetAddress2() {
		return streetAddress2;
	}

	public void setStreetAddress2(String streetAddress2) {
		this.streetAddress2 = streetAddress2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getRoadName() {
		return roadName;
	}

	public void setRoadName(String roadName) {
		this.roadName = roadName;
	}

	public Integer getRoadNumber() {
		return roadNumber;
	}

	public void setRoadNumber(Integer roadNumber) {
		this.roadNumber = roadNumber;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLocationType() {
		return locationType;
	}

	public void setLocationType(String locationType) {
		this.locationType = locationType;
	}

	public Contractor getContractor() {
		return contractor;
	}

	public void setContractor(Contractor contractor) {
		this.contractor = contractor;
	}

	public LocationDao getLocationDao() {
		return locationDao;
	}

	public void setLocationDao(LocationDao locationDao) {
		this.locationDao = locationDao;
	}

 
    
}