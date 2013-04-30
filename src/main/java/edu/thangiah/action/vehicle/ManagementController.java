package edu.thangiah.action.vehicle;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.Action;

import edu.thangiah.action.BaseManagementController;
import edu.thangiah.dao.ContractorDao;
import edu.thangiah.dao.DriverDao;
import edu.thangiah.dao.LocationDao;
import edu.thangiah.dao.VehicleDao;
import edu.thangiah.strutsutility.exception.StrutsElementException;
import edu.thangiah.dao.VehicleTypeDao;
import edu.thangiah.entity.Contractor;
import edu.thangiah.entity.Driver;
import edu.thangiah.entity.Location;
import edu.thangiah.entity.Vehicle;
import edu.thangiah.entity.VehicleType;
import edu.thangiah.strutsutility.StrutsSelect;

/**
 * 
 * This class extends our base management controller class and handles
 * the specific get and sets to the database for all actions pertaining to the 
 * entity Routes
 * 
 * 
 * @author Alex McCracken, Kelly Smith
 *
 */

public class ManagementController extends BaseManagementController<Vehicle>{
	

	private static final long serialVersionUID = -1194255798482840950L;

	protected static final Logger LOGGER = Logger.getLogger(ManagementController.class.getName());
	
	@Autowired
	protected VehicleTypeDao vehicleTypeDao;
	@Autowired
	protected ContractorDao contractorDao;
	@Autowired
	protected LocationDao locationDao;
	@Autowired
	protected DriverDao driverDao;
	@Autowired
	protected VehicleDao vehicleDao;
	
	protected StrutsSelect<VehicleType> vehicleTypeSelect;
	protected StrutsSelect<Contractor> contractorSelect;
	protected StrutsSelect<Location> locationSelect;
	protected StrutsSelect<Driver> driverSelect;
	
	
	protected static final Map<String, String> columnMap;
	static {
		Map<String, String> columns = new LinkedHashMap<String, String>();
		columns.put("plateNumber", "Plate Number");
		columns.put("vinNumber", "Vin");
		columns.put("manufacturedYear", "Manufactured Year");
		columns.put("vehicleType", "Vehicle Type");
		columns.put("contractor", "Contractor");
		columns.put("drivers", "Drivers");
		columns.put("location", "Location");
		columnMap = Collections.unmodifiableMap(columns);
	}
	
	// Feeds the column map specific to this class into the auto field generator.
	@Override
	protected Map<String, String> getColumnMap(){
		return columnMap;
	}
	
	@Override
	protected String getActionId() {
		return "vehicle";
	}
	
	@Override
	public void prepare() throws Exception {
		super.prepare();
		this.initializeEntityList(vehicleDao);
		gridBody = this.generateGridBody(this.getColumnVisibilitySet(), this.getEntityList(), Vehicle.class, "vehicleManagement.action");
		
		if ( vehicleDao == null ) {
        	this.addActionError("Unable to connect to the database.  Please contact your system administrator.");
        }
		
		try{
			vehicleTypeSelect = new StrutsSelect<VehicleType>(vehicleTypeDao, "vehicleType");
			contractorSelect = new StrutsSelect<Contractor>(contractorDao, "contractor");
			locationSelect = new StrutsSelect<Location>(locationDao, "location");
			driverSelect = new StrutsSelect<Driver>(driverDao, "driver");
		}
		catch(StrutsElementException e){
			this.addActionError("Unable to connect to the database.  Please contact your system administrator.");
		}
	}
	
	public String execute() {
        if ( this.hasActionErrors() ) {
            return Action.ERROR;
        }
		
        initialize();
        
        String result;
        if( mode == Modes.EDIT ){
        	result = this.initializeEntityById(vehicleDao, id);
        	
        	if( !result.equals(SUCCESS) ){
    			return result;
    		}
        	
        	if( getVehicle() != null && getVehicle().getContractor() != null && getVehicle().getLocation() != null && getVehicle().getDrivers() != null && getVehicle().getVehicleType() != null ){
	        	contractorSelect.intializeFromEntity(getVehicle().getContractor());
	        	vehicleTypeSelect.intializeFromEntity(getVehicle().getVehicleType());
	        	locationSelect.intializeFromEntity(getVehicle().getLocation());
	        	driverSelect.intializeFromEntity(getVehicle().getDriver());
        	}
        }
        
        LOGGER.debug("Vehicles number = " + getVehicles().size());
        return SUCCESS;
    }
	
	


	protected void initializeSelectedElements() throws StrutsElementException {
		String result;
		result = vehicleTypeSelect.initializeSelected();
		if( !result.equals(SUCCESS) )
			addFieldError("vehicleTypeSelect.selected", result);
		
		result = contractorSelect.initializeSelected();
		if( !result.equals(SUCCESS) )
			addFieldError("contractorSelect.selected", result);
		
		result = locationSelect.initializeSelected();
		if( !result.equals(SUCCESS) )
			addFieldError("locationSelect.selected", result);
		
		result = driverSelect.initializeSelected();
		if( !result.equals(SUCCESS) )
			addFieldError("driverSelect.selected", result);
	} 

	
	public List<Vehicle> getVehicles() {
		return this.getEntityList();
	}
	
	public Vehicle getVehicle(){
		return this.getEntity();
	}
	
	public VehicleTypeDao getVehicleTypeDao() {
		return vehicleTypeDao;
	}

	public void setVehicleTypeDao(VehicleTypeDao vehicleTypeDao) {
		this.vehicleTypeDao = vehicleTypeDao;
	}

	public ContractorDao getContractorDao() {
		return contractorDao;
	}

	public void setContractorDao(ContractorDao contractorDao) {
		this.contractorDao = contractorDao;
	}

	public LocationDao getLocationDao() {
		return locationDao;
	}

	public void setLocationDao(LocationDao locationDao) {
		this.locationDao = locationDao;
	}

	public DriverDao getDriverDao() {
		return driverDao;
	}

	public void setDriverDao(DriverDao driverDao) {
		this.driverDao = driverDao;
	}

	public VehicleDao getVehicleDao() {
		return vehicleDao;
	}

	public void setVehicleDao(VehicleDao vehicleDao) {
		this.vehicleDao = vehicleDao;
	}

	public StrutsSelect<VehicleType> getVehicleTypeSelect() {
		return vehicleTypeSelect;
	}

	public void setVehicleTypeSelect(StrutsSelect<VehicleType> vehicleTypeSelect) {
		this.vehicleTypeSelect = vehicleTypeSelect;
	}

	public StrutsSelect<Contractor> getContractorSelect() {
		return contractorSelect;
	}

	public void setContractorSelect(StrutsSelect<Contractor> contractorSelect) {
		this.contractorSelect = contractorSelect;
	}

	public StrutsSelect<Location> getLocationSelect() {
		return locationSelect;
	}

	public void setLocationSelect(StrutsSelect<Location> locationSelect) {
		this.locationSelect = locationSelect;
	}

	public StrutsSelect<Driver> getDriverSelect() {
		return driverSelect;
	}

	public void setDriverSelect(StrutsSelect<Driver> driverSelect) {
		this.driverSelect = driverSelect;
	}
	
}
