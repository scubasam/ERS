package edu.thangiah.action.location;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.Action;

import edu.thangiah.action.BaseManagementController;
import edu.thangiah.dao.ContractorDao;
import edu.thangiah.dao.LocationDao;
import edu.thangiah.dao.VehicleDao;
import edu.thangiah.entity.Contractor;
import edu.thangiah.entity.Location;


/**
 * 
 * This class extends our base management controller class and handles
 * the specific get and sets to the database for all actions pertaining to the 
 * entity Location
 * 
 * 
 * @author Alex McCracken, Kelly Smith
 *
 */

public class ManagementController extends BaseManagementController<Location>{
	
	private static final long serialVersionUID = -1194255798482840950L;

	protected static final Logger LOGGER = Logger.getLogger(ManagementController.class.getName());
	
	@Autowired
	protected LocationDao locationDao;
	
	@Autowired
	protected ContractorDao contractorDao;
	
	@Autowired
	protected VehicleDao vehicleDao;
	
	protected List<Contractor> contractorList;
	
	protected String contractorId;
	protected long selectedContractorId; // Holds the contractor id of the current entities contractor for the form.
	protected long newContractorId;
	
	/**
	 * Must be specified by all management controllers as it is used for generating the grid header and body code.
	 */
	protected static final Map<String, String> columnMap;
	static {
		Map<String, String> columns = new LinkedHashMap<String, String>();
		columns.put("name", "Name");
		columns.put("streetAddress1", "Street Address 1");
		columns.put("streetAddress2", "Street Address 2");
		columns.put("city", "City");
		columns.put("state", "State");
		columns.put("zip", "Zip");
		columns.put("roadName", "Road Name");
		columns.put("roadNumber", "Road Number");
		columns.put("latitude", "Latitude");
		columns.put("longitude", "Longitude");
		columns.put("contractor", "Contractor");
		columns.put("locationType", "Location Type");
		columns.put("vehicles", "Vehicles");
		columnMap = Collections.unmodifiableMap(columns);
	}
	
	// Feeds the column map specific to this class into the auto field generator.
	/**
	 * Must be specified by all management controllers as it is used for generating the grid header and body code.
	 */
	@Override
	protected Map<String, String> getColumnMap(){
		return columnMap;
	}
	
	/**
	 * Must be specified by all management controllers as it is used for generating the grid header and body code.
	 */
	@Override
	protected String getActionId() {
		return "location";
	}
	
	@Override
	public void prepare() throws Exception {
		super.prepare();
		String result = this.initializeEntityList(locationDao);
		gridBody = this.generateGridBody(this.getColumnVisibilitySet(), this.getEntityList(), Location.class, "locationManagement.action");
		if( !result.equals(SUCCESS) ){
			this.addControllerError(ErrorCode.FATAL, "Unable to access the database.  Please try reloading the page.");
			return;
		}
		
		if( contractorDao == null ){
			this.addControllerError(ErrorCode.FATAL, "Unable to access the database.  Please try reloading the page.");
			return;
		}
		
		contractorList = contractorDao.findAll();
		
	}
	
	public String execute() {
		if( this.hasControllerErrors() ){
    		return ERROR;
    	}
		
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
        	
        	// this is used to correctly populate the contractor select element.
        	selectedContractorId = this.getEntity().getContractor().getId();
        }
        
        LOGGER.debug("Locations number = " + getLocations().size());
        return Action.SUCCESS;
    }
	
	protected String parseContractorId() {
		try{
			newContractorId = Integer.parseInt(this.getContractorId());
		}
		catch(NumberFormatException e){
			this.addFieldError("contractorId", "Invalid contractor - please try again.");
			return INPUT;
		}
		catch( Exception e ){
			this.addFieldError("contractorId", "An unknown error has occured. Please try again.");
			return INPUT;
		}
		return SUCCESS;
	}
	
	protected void runLocationValidation() {
		if( this.getEntity() != null && contractorId != null )
    	{
    		requiredString(this.getEntity().getLocationType(), "location.locationType");
    		requiredString(this.getEntity().getName(), "location.name");
    		requiredString(this.getEntity().getStreetAddress1(), "location.streetAddress1");
    		requiredString(this.getEntity().getCity(), "location.city");
    		requiredString(this.getEntity().getZip(), "location.zip");
    		requiredString(this.getEntity().getRoadName(), "location.roadName");
    		requiredString(this.getEntity().getLatitude(), "location.latitude");
    		requiredString(this.getEntity().getLongitude(), "location.longitude");
    		requiredString(this.getEntity().getLocationType(), "location.locationType");
    		requiredString(this.getContractorId(), "contractorId");
    		
    		
    		requiredString(this.getEntity().getState(), "location.state");
    		
    		if( this.getEntity().getState() != null ){
    			if( this.getEntity().getState().length() > 2 ){
    				this.addFieldError("location.state", "Please use the two letter abbreviation for the State.");
    			}
    		}
    	}		
    	else{
    		addActionError("Unknown error.  Please try again.");
    	}
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
	
	public void setContractor(ContractorDao contractorDao)
	{
		this.contractorDao = contractorDao;
	}
	
	public ContractorDao getContractor()
	{
		return this.contractorDao;
	}

	public List<Contractor> getContractorList() {
		return contractorList;
	}

	public void setContractorList(List<Contractor> contractorList) {
		this.contractorList = contractorList;
	}

	public String getContractorId() {
		return contractorId;
	}

	public void setContractorId(String contractorId) {
		this.contractorId = contractorId;
	}

	public ContractorDao getContractorDao() {
		return contractorDao;
	}

	public void setContractorDao(ContractorDao contractorDao) {
		this.contractorDao = contractorDao;
	}

	public long getSelectedContractorId() {
		return selectedContractorId;
	}

	public void setSelectedContractorId(long selectedContractorId) {
		this.selectedContractorId = selectedContractorId;
	}

	public VehicleDao getVehicleDao() {
		return vehicleDao;
	}

	public void setVehicleDao(VehicleDao vehicleDao) {
		this.vehicleDao = vehicleDao;
	}
}
