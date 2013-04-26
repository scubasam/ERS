package edu.thangiah.action.maintenanceorder;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.Action;

import edu.thangiah.action.BaseManagementController;
import edu.thangiah.dao.DriverDao;
import edu.thangiah.dao.MaintenanceOrderDao;
import edu.thangiah.dao.ServiceTechnicianDao;
import edu.thangiah.dao.VehicleDao;
import edu.thangiah.entity.Driver;
import edu.thangiah.entity.MaintenanceOrder;
import edu.thangiah.entity.ServiceTechnician;
import edu.thangiah.entity.Vehicle;
import edu.thangiah.strutsutility.StrutsSelect;
import edu.thangiah.strutsutility.exception.StrutsElementException;

public class ManagementController extends BaseManagementController<MaintenanceOrder>{
	
	/**
	 * 
	 * This class extends our base management controller class and handles
	 * the specific get and sets to the database for all actions pertaining to the 
	 * entity Maintenance Order
	 * 
	 * @author Alex McCracken, Kelly Smith
	 *
	 */
	private static final long serialVersionUID = -1194255798482840950L;

	protected static final Logger LOGGER = Logger.getLogger(ManagementController.class.getName());

	@Autowired
	protected MaintenanceOrderDao maintenanceOrderDao;
	@Autowired
	protected VehicleDao vehicleDao;
	@Autowired
	protected ServiceTechnicianDao serviceTechnicianDao;
	@Autowired 
	protected DriverDao driverDao;

	protected ServiceTechnician serviceTechnician;
	protected Driver driver;
	protected Vehicle vehicle;
	
	protected StrutsSelect<Vehicle> vehicleSelect;
	protected StrutsSelect<Driver> driverSelect;
	protected StrutsSelect<ServiceTechnician> serviceTechnicianSelect;
	
	protected static final Map<String, String> columnMap;
	static {
		Map<String, String> columns = new LinkedHashMap<String, String>();
		columns.put("requester", "Requester");
		columns.put("serviceTechnician", "Service Technician");	
		columns.put("cost", "MaintenanceOrder");
		columns.put("scheduledDate", "Schedule Date");
		columns.put("details", "Details");
		columns.put("serviceTypeKey", "Service Type Key");
		columns.put("cost", "Cost");
		columns.put("statusKey", "Status Key");
		columns.put("vehicle", "Vehicle");
		columns.put("maintenanceType", "Maintenance Type");
		columnMap = Collections.unmodifiableMap(columns);
	}
	
	
	// Feeds the column map specific to this class into the auto field generator.
	@Override
	protected Map<String, String> getColumnMap(){
		return columnMap;
	}
	
	@Override
	protected String getActionId() {
		return "maintenanceOrder";
	}
	
	@Override
	public void prepare() throws Exception {
		super.prepare();
		this.initializeEntityList(maintenanceOrderDao);
		gridBody = this.generateGridBody(this.getColumnVisibilitySet(), this.getEntityList(), MaintenanceOrder.class, "maintenanceOrderManagement.action");
		
		if(maintenanceOrderDao == null){
			
			this.addActionError("unable to connect to the database contact a sys admin");
		}
		
		try{
			vehicleSelect = new StrutsSelect<Vehicle>(vehicleDao, "vehicle");
			driverSelect = new StrutsSelect<Driver>(driverDao, "requester");
			serviceTechnicianSelect = new StrutsSelect<ServiceTechnician>(serviceTechnicianDao, "serviceTechnician");
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
        	result = this.initializeEntityById(maintenanceOrderDao, id);
        	
        	if( !result.equals(SUCCESS) ){
    			return result;
    		}
        	
        	if(getMaintenanceOrder() != null && getMaintenanceOrder().getDriver() != null && getMaintenanceOrder().getServiceTechnician() != null && getMaintenanceOrder().getVehicle() != null ){
	        	vehicleSelect.intializeFromEntity(getMaintenanceOrder().getVehicle());
	        	driverSelect.intializeFromEntity(getMaintenanceOrder().getDriver());
	        	serviceTechnicianSelect.intializeFromEntity(getMaintenanceOrder().getServiceTechnician());
        	}
        }
        
        LOGGER.debug("Maintenance Order number " + getMaintenanceOrders().toString());
        return SUCCESS;

    }
	
	protected void initializeSelectedElements() throws StrutsElementException {
		String result;
		result = vehicleSelect.initializeSelected();
		if( !result.equals(SUCCESS) )
			addFieldError("vehicleSelect.selected", result);
		
		result = driverSelect.initializeSelected();
		if( !result.equals(SUCCESS) )
			addFieldError("driverSelect.selected", result);
		
		result = serviceTechnicianSelect.initializeSelected();
		if( !result.equals(SUCCESS) )
			addFieldError("serviceTechnicianSelect.selected", result);
	}
	
	// ALWAYS REMEMBER THE SET AND GET FOR LIST AND ENTITY!!!!!
	public void setMaintenanceOrder(MaintenanceOrder maintenanceOrder){
		this.setEntity(maintenanceOrder);
		
	}
	public MaintenanceOrder getMaintenanceOrder()
	{
		return this.getEntity();
	}
	
	public void setMaintenanceOrders(List<MaintenanceOrder> list) {
		this.setEntityList(list);
	}
	
	public List<MaintenanceOrder> getMaintenanceOrders() {
		return this.getEntityList();
	}
	//////////////////////////////////////////////

	
	public MaintenanceOrderDao getMaintenanceOrderDao() {
		return maintenanceOrderDao;
	}

	public void setMaintenanceOrderDao(MaintenanceOrderDao maintenanceOrderDao) {
		this.maintenanceOrderDao = maintenanceOrderDao;
	}

	public ServiceTechnician getServiceTechnician() {
		return serviceTechnician;
	}

	public void setServiceTechnician(ServiceTechnician serviceTechnician) {
		this.serviceTechnician = serviceTechnician;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	public StrutsSelect<Vehicle> getVehicleSelect() {
		return vehicleSelect;
	}

	public void setVehicleSelect(StrutsSelect<Vehicle> vehicleSelect) {
		this.vehicleSelect = vehicleSelect;
	}

	public StrutsSelect<Driver> getDriverSelect() {
		return driverSelect;
	}

	public void setDriverSelect(StrutsSelect<Driver> driverSelect) {
		this.driverSelect = driverSelect;
	}

	public StrutsSelect<ServiceTechnician> getServiceTechnicianSelect() {
		return serviceTechnicianSelect;
	}

	public void setServiceTechnicianSelect(
			StrutsSelect<ServiceTechnician> serviceTechnicianSelect) {
		this.serviceTechnicianSelect = serviceTechnicianSelect;
	}

	public VehicleDao getVehicleDao() {
		return vehicleDao;
	}

	public void setVehicleDao(VehicleDao vehicleDao) {
		this.vehicleDao = vehicleDao;
	}

	public ServiceTechnicianDao getServiceTechnicianDao() {
		return serviceTechnicianDao;
	}

	public void setServiceTechnicianDao(ServiceTechnicianDao serviceTechnicianDao) {
		this.serviceTechnicianDao = serviceTechnicianDao;
	}

	public DriverDao getDriverDao() {
		return driverDao;
	}

	public void setDriverDao(DriverDao driverDao) {
		this.driverDao = driverDao;
	}
	

	
}
