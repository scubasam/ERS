package edu.thangiah.action.shipment;

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
import edu.thangiah.dao.ShipmentDao;
import edu.thangiah.dao.VehicleTypeDao;
import edu.thangiah.entity.Location;
import edu.thangiah.entity.Route;
import edu.thangiah.entity.Shipment;
import edu.thangiah.entity.VehicleType;
import edu.thangiah.strutsutility.StrutsSelect;
import edu.thangiah.strutsutility.exception.StrutsElementException;

public class ManagementController extends BaseManagementController<Shipment>{
	private static final long serialVersionUID = -8525924910192043951L;

	protected static final Logger LOGGER = Logger.getLogger(ManagementController.class.getName());
	
	@Autowired
	protected ShipmentDao shipmentDao;
	
	@Autowired
	protected VehicleTypeDao vehicleTypeDao;
	
	@Autowired
	protected LocationDao locationDao;
	
	@Autowired
	protected RouteDao routeDao;
	
	protected StrutsSelect<VehicleType> vehicleTypeSelect;
	protected StrutsSelect<Location> locationSelect;
	protected StrutsSelect<Location> destinationSelect;
	protected StrutsSelect<Location> pooledDestinationSelect;
	protected StrutsSelect<Route> routeSelect;
	
	protected static final Map<String, String> columnMap;
	static {
		Map<String, String> columns = new LinkedHashMap<String, String>();
		columns.put("timeEntered", "Time Entered");
		columns.put("orderId", "Order Id");
		columns.put("vehicleType", "Vehicle Type");
		columns.put("location", "Location");
		columns.put("route", "Route");
		columns.put("availableDate", "Available Date");
		columns.put("availableTime", "Available Time");
		columns.put("releaseDate", "Release Date");
		columns.put("releaseTime", "Release Time");
		columns.put("earliestDeliveryDate", "Earliest Delivery Date");
		columns.put("earliestDeliveryTime", "Earliest Delivery Time");
		columns.put("latestDeliveryDate", "Latest Delivery Date");
		columns.put("latestDeliveryTime", "Latest Delivery Time");
		columns.put("serviceTime", "Service Time");
		columns.put("weight", "Weight");
		columns.put("cubicWeight", "Cubic Weight");
		columns.put("customerName", "Customer Name");
		columns.put("destination", "Destination");
		columns.put("pooledShipment", "Pooled Shipment");
		columns.put("pooledDestination", "Pooled Destination");
		columnMap = Collections.unmodifiableMap(columns);
	}
	
	// Feeds the column map specific to this class into the auto field generator.
	@Override
	protected Map<String, String> getColumnMap(){
		return columnMap;
	}
	
	@Override
	protected String getActionId() {
		return "shipment";
	}
	
	@Override
	public void prepare() throws Exception {
		super.prepare();
		this.initializeEntityList(shipmentDao);
		gridBody = this.generateGridBody(this.getColumnVisibilitySet(), this.getEntityList(), Shipment.class, "shipmentManagement.action");
		
		if ( shipmentDao == null ) {
        	this.addActionError("Unable to connect to the database.  Please contact your system administrator.");
        }
		
		try{
			vehicleTypeSelect = new StrutsSelect<VehicleType>(vehicleTypeDao, "vehicleType");
			locationSelect = new StrutsSelect<Location>(locationDao, "location");
			destinationSelect = new StrutsSelect<Location>(locationDao, "destination");
			pooledDestinationSelect = new StrutsSelect<Location>(locationDao, "pooledDestination", false);
			routeSelect = new StrutsSelect<Route>(routeDao, "route");
		}
		catch(StrutsElementException e){
			this.addActionError("Unable to connect to the database.  Please contact your system administrator.");
		}
	}
	
	@Override
	public String execute() {
        if ( this.hasActionErrors() ) {
            return Action.ERROR;
        }
        initialize();
        
        String result;
        if( mode == Modes.EDIT ){
        	result = this.initializeEntityById(shipmentDao, id);
        	
        	if( !result.equals(SUCCESS) ){
    			return result;
    		}
        	
        	if( getShipment() != null ){
        		initializeDropDownLists();
        		
        	}
        }
        
        LOGGER.debug("Routes number = " + getShipments().size());
        return SUCCESS;
    }

	protected void initializeDropDownLists() {
		if( getShipment().getRoute() != null )
			routeSelect.intializeFromEntity(getShipment().getRoute());
		
		if( getShipment().getLocation() != null )
			locationSelect.intializeFromEntity(getShipment().getLocation());
		
		if( getShipment().getDestination() != null )
			destinationSelect.intializeFromEntity(getShipment().getDestination());
		
		if( getShipment().getPooledDestination() != null )
			pooledDestinationSelect.intializeFromEntity(getShipment().getPooledDestination());
		
		if( getShipment().getVehicleType() != null )
			vehicleTypeSelect.intializeFromEntity(getShipment().getVehicleType());
	}
	
	 protected void initializeSelectedElements() throws StrutsElementException {
		String result;
		result = routeSelect.initializeSelected();
		if( !result.equals(SUCCESS) )
			addFieldError("routeSelect.selected", result);
		
		result = locationSelect.initializeSelected();
		if( !result.equals(SUCCESS) )
			addFieldError("locationSelect.selected", result);
		
		result = destinationSelect.initializeSelected();
		if( !result.equals(SUCCESS) )
			addFieldError("destinationSelect.selected", result);
		
		result = pooledDestinationSelect.initializeSelected();
		if( !result.equals(SUCCESS) )
			addFieldError("pooledDestinationSelect.selected", result);
		
		result = vehicleTypeSelect.initializeSelected();
		if( !result.equals(SUCCESS) )
			addFieldError("vehicleTypeSelect.selected", result);
	}
	
	public List<Shipment> getShipments() {
		return this.getEntityList();
	}

	public void setShipments(List<Shipment> entities) {
		this.setEntityList(entities);
	}
	
	public Shipment getShipment(){
		return this.getEntity();
	}
	
	public void setShipment(Shipment entity){
		this.setEntity(entity);
	}
	

	public ShipmentDao getShipmentDao() {
		return shipmentDao;
	}

	public void setShipmentDao(ShipmentDao shipmentDao) {
		this.shipmentDao = shipmentDao;
	}

	public VehicleTypeDao getVehicleTypeDao() {
		return vehicleTypeDao;
	}

	public void setVehicleTypeDao(VehicleTypeDao vehicleTypeDao) {
		this.vehicleTypeDao = vehicleTypeDao;
	}

	public LocationDao getLocationDao() {
		return locationDao;
	}

	public void setLocationDao(LocationDao locationDao) {
		this.locationDao = locationDao;
	}

	public RouteDao getRouteDao() {
		return routeDao;
	}

	public void setRouteDao(RouteDao routeDao) {
		this.routeDao = routeDao;
	}

	public StrutsSelect<VehicleType> getVehicleTypeSelect() {
		return vehicleTypeSelect;
	}

	public void setVehicleTypeSelect(StrutsSelect<VehicleType> vehicleTypeSelect) {
		this.vehicleTypeSelect = vehicleTypeSelect;
	}

	public StrutsSelect<Location> getLocationSelect() {
		return locationSelect;
	}

	public void setLocationSelect(StrutsSelect<Location> locationSelect) {
		this.locationSelect = locationSelect;
	}

	public StrutsSelect<Location> getDestinationSelect() {
		return destinationSelect;
	}

	public void setDestinationSelect(StrutsSelect<Location> destinationSelect) {
		this.destinationSelect = destinationSelect;
	}

	public StrutsSelect<Location> getPooledDestinationSelect() {
		return pooledDestinationSelect;
	}

	public void setPooledDestinationSelect(
			StrutsSelect<Location> pooledDestinationSelect) {
		this.pooledDestinationSelect = pooledDestinationSelect;
	}

	public StrutsSelect<Route> getRouteSelect() {
		return routeSelect;
	}

	public void setRouteSelect(StrutsSelect<Route> routeSelect) {
		this.routeSelect = routeSelect;
	}

}
