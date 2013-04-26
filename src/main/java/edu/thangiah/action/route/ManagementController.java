package edu.thangiah.action.route;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.Action;

import edu.thangiah.action.BaseManagementController;
import edu.thangiah.dao.LocationDao;
import edu.thangiah.dao.RouteDao;
import edu.thangiah.dao.VehicleDao;
import edu.thangiah.entity.Location;
import edu.thangiah.entity.Route;
import edu.thangiah.entity.Vehicle;
import edu.thangiah.strutsutility.StrutsSelect;
import edu.thangiah.strutsutility.exception.StrutsElementException;

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

public class ManagementController extends BaseManagementController<Route>{
	

	private static final long serialVersionUID = -1194255798482840950L;

	protected static final Logger LOGGER = Logger.getLogger(ManagementController.class.getName());
	
	@Autowired
	protected RouteDao routeDao;
	
	@Autowired
	protected VehicleDao vehicleDao;
	
	@Autowired
	protected LocationDao locationDao;
	
	protected StrutsSelect<Vehicle> vehicleSelect;
	protected StrutsSelect<Location> startLocationSelect;
	protected StrutsSelect<Location> endLocationSelect;
	
	
	protected static final Map<String, String> columnMap;
	static {
		Map<String, String> columns = new LinkedHashMap<String, String>();
		columns.put("vehicle", "Vehicle");
		columns.put("shipments", "Shipments");
		columns.put("startLocation", "Start Location");
		columns.put("endLocation", "End Location");
		columnMap = Collections.unmodifiableMap(columns);
	}
	
	
	@Override
	protected String getActionId() {
		return "route";
	}
	
	@Override
	public void prepare() throws Exception {
		super.prepare();
		this.initializeEntityList(routeDao);
		gridBody = this.generateGridBody(this.getColumnVisibilitySet(), this.getEntityList(), Route.class, "routeManagement.action");
		
		if ( routeDao == null ) {
        	this.addActionError("Unable to connect to the database.  Please contact your system administrator.");
        }
		
		try{
			vehicleSelect = new StrutsSelect<Vehicle>(vehicleDao, "vehicle");
			startLocationSelect = new StrutsSelect<Location>(locationDao, "startLocation");
			endLocationSelect = new StrutsSelect<Location>(locationDao, "endLocation");
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
        	result = this.initializeEntityById(routeDao, id);
        	
        	if( !result.equals(SUCCESS) ){
    			return result;
    		}
        	
        	if( getRoute() != null && getRoute().getVehicle() != null && getRoute().getStartLocation() != null && getRoute().getEndLocation() != null ){
	        	vehicleSelect.intializeFromEntity(getRoute().getVehicle());
	        	startLocationSelect.intializeFromEntity(getRoute().getStartLocation());
	        	endLocationSelect.intializeFromEntity(getRoute().getEndLocation());
        	}
        }
        
        LOGGER.debug("Routes number = " + getRoutes().size());
        return SUCCESS;
    }
	
	
	protected void initializeSelectedElements() throws StrutsElementException {
		String result;
		result = vehicleSelect.initializeSelected();
		if( !result.equals(SUCCESS) )
			addFieldError("startLocationSelect.selected", result);
		
		result = startLocationSelect.initializeSelected();
		if( !result.equals(SUCCESS) )
			addFieldError("startLocationSelect.selected", result);
		
		result = endLocationSelect.initializeSelected();
		if( !result.equals(SUCCESS) )
			addFieldError("startLocationSelect.selected", result);
	}
	
	public List<Route> getRoutes() {
		return this.getEntityList();
	}

	public void setRoutes(List<Route> routes) {
		this.setEntityList(routes);
	}
	
	public RouteDao getRouteDao() {
		return routeDao;
	}
	public void setContractorDao(RouteDao routeDao) {
		this.routeDao = routeDao;
	}
	
	public Route getRoute(){
		return this.getEntity();
	}
	
	public void setRoute(Route route){
		this.setEntity(route);
	}

	public void setRouteDao(RouteDao routeDao) {
		this.routeDao = routeDao;
	}

	public VehicleDao getVehicleDao() {
		return vehicleDao;
	}

	public void setVehicleDao(VehicleDao vehicleDao) {
		this.vehicleDao = vehicleDao;
	}

	public LocationDao getLocationDao() {
		return locationDao;
	}

	public void setLocationDao(LocationDao locationDao) {
		this.locationDao = locationDao;
	}

	public StrutsSelect<Vehicle> getVehicleSelect() {
		return vehicleSelect;
	}

	public void setVehicleSelect(StrutsSelect<Vehicle> vehicleSelect) {
		this.vehicleSelect = vehicleSelect;
	}

	public StrutsSelect<Location> getStartLocationSelect() {
		return startLocationSelect;
	}

	public void setStartLocationSelect(StrutsSelect<Location> startLocationSelect) {
		this.startLocationSelect = startLocationSelect;
	}

	public StrutsSelect<Location> getEndLocationSelect() {
		return endLocationSelect;
	}

	public void setEndLocationSelect(StrutsSelect<Location> endLocationSelect) {
		this.endLocationSelect = endLocationSelect;
	}
}
