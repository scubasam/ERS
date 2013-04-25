package edu.thangiah.action.maintenanceorder;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.Action;

import edu.thangiah.action.BaseManagementController;
import edu.thangiah.dao.MaintenanceOrderDao;
import edu.thangiah.entity.Driver;
import edu.thangiah.entity.MaintenanceOrder;
import edu.thangiah.entity.ServiceTechnician;
import edu.thangiah.entity.Vehicle;

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

	protected ServiceTechnician serviceTechnician;
	
	protected Driver driver;
	
	protected Vehicle vehicle;
	
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
	}
	
	public String execute() {
        if (maintenanceOrderDao == null) {
            return Action.ERROR;
        }
        
        String result = initialize();
		if( !result.equals(SUCCESS) ){
			return result;
		}
        
        if( mode == Modes.EDIT ){
        	result = this.initializeEntityById(maintenanceOrderDao, id);
        	if( this.getEntity() != null ){
    			vehicle = this.getEntity().getVehicle();
    			serviceTechnician = this.getEntity().getServiceTechnician();
    		}
        	if( !result.equals(SUCCESS) ){
    			return result;
    		}
        }
        
        LOGGER.debug("Maintenance Order = " + getMaintenanceOrders().size());
        return Action.SUCCESS;
    }
	
	public List<MaintenanceOrder> getMaintenanceOrders() {
		return this.getEntityList();
	}
	
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
	

	
}
