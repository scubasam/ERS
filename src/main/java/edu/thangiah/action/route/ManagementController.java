package edu.thangiah.action.route;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.Action;

import edu.thangiah.action.BaseManagementController;
import edu.thangiah.dao.LocationDao;
import edu.thangiah.dao.RouteDao;
import edu.thangiah.dao.ShipmentDao;
import edu.thangiah.dao.VehicleDao;
import edu.thangiah.entity.Location;
import edu.thangiah.entity.Route;
import edu.thangiah.entity.Shipment;
import edu.thangiah.entity.Vehicle;
import edu.thangiah.service.GoogleMapsDirectionsRequest;
import edu.thangiah.service.GoogleMapsDirectionsResponse;
import edu.thangiah.service.ServiceException;
import edu.thangiah.service.GoogleMapsDirectionsRequest.Output;
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
	
	@Autowired
	protected ShipmentDao shipmentDao;
	
	
	protected List<Shipment> allShipments;
	protected List<Shipment> unselectedShipments;

	protected StrutsSelect<Vehicle> vehicleSelect;
	
	protected String shipmentList;
	
	/**
	 * Parsed, ordered list of shipments from an Add or Update action form.
	 */
	protected LinkedList<Shipment> parsedShipments;
	
	
	private GoogleMapsDirectionsRequest request;
	
	
	protected static final Map<String, String> columnMap;
	static {
		Map<String, String> columns = new LinkedHashMap<String, String>();
		columns.put("vehicle", "Vehicle");
		columns.put("orderedShipments", "Shipments");
		columns.put("startLocation", "Start Location");
		columns.put("endLocation", "End Location");
		columns.put("minimumCubicWeight", "Minimum Cubic Weight");
		columns.put("maximumCubicWeight", "Maximum Cubic Weight");
		columns.put("minimumWeight", "Minimum Weight");
		columns.put("maximumWeight", "Maximum Weight");
		columns.put("capacity", "Capacity");
		columns.put("totalWeight", "Total Weight");
		columns.put("totalCubicWeight", "Total Cubic Weight");
		columns.put("totalMiles", "Total Miles");
		columns.put("totalTime", "Total Time (sec)");
		columns.put("totalDays", "Total Days");
		columnMap = Collections.unmodifiableMap(columns);
	}
	
	// Feeds the column map specific to this class into the auto field generator.
	@Override
	protected Map<String, String> getColumnMap(){
		return columnMap;
	}
	
	@Override
	protected String getActionId() {
		return "route";
	}
	
	@Override
	public void prepare() throws Exception {
		super.prepare();
		
		if( shipmentDao != null ){
			allShipments = shipmentDao.findAll();
		}
		
		this.initializeEntityList(routeDao);
		gridBody = this.generateGridBody(this.getColumnVisibilitySet(), this.getEntityList(), Route.class, "routeManagement.action");
		
		if ( routeDao == null ) {
        	this.addActionError("Unable to connect to the database.  Please contact your system administrator.");
        }
		
		try{
			vehicleSelect = new StrutsSelect<Vehicle>(vehicleDao, "vehicle");
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
        	
        	if( getEntity() != null && getEntity().getOrderedShipments() != null && getEntity().getOrderedShipments().size() > 0 ){
	        	StringBuilder currentShipmentList = new StringBuilder();
	        	for( Shipment ship : getEntity().getOrderedShipments() ){
	        		currentShipmentList.append(ship.getId());
	        		currentShipmentList.append(",");
	        	}
	        	shipmentList = currentShipmentList.substring(0,currentShipmentList.length()-1).toString();
	        	
	        	if( allShipments != null ){
	        		unselectedShipments = new ArrayList<Shipment>();
		        	for( Shipment ship : allShipments ){
		        		boolean unselected = true;
		        		for( Shipment selectedShip : getEntity().getOrderedShipments() ){
		        			if( selectedShip.getId().equals(ship.getId()) ){
		        				unselected = false;
		        				break;
		        			}
		        		}
		        		if(unselected)
		        			unselectedShipments.add(ship);
		        	}
	        	}
        	}
        	else{
        		if( allShipments != null ){
	        		unselectedShipments = new ArrayList<Shipment>(allShipments);
	        	}
        	}
        	
        	
        	if( getRoute() != null && getRoute().getVehicle() != null ){
	        	vehicleSelect.intializeFromEntity(getRoute().getVehicle());
        	}
        }
        
        LOGGER.debug("Routes number = " + getRoutes().size());
        return SUCCESS;
    }
	
	/**
	 * Takes the shipmentList that should be supplied to the Add or Update action and parses it for individual shipments.
	 * It then passes them along to {@link #parseShipmentListArray(String[])} for processing.
	 * @return SUCCESS or ERROR constant
	 */
	protected String parseShipmentList() {
		if( this.shipmentList == null || this.shipmentList.length() == 0 ){
			return SUCCESS; // Not every route has to have shipments at all times.
		}
		
		String[] shipments = shipmentList.split(",");
		if( shipments == null || shipments.length == 0 ){
			return ERROR; // If the string wasn't empty but the array is, an error occured.
		}
		
		String result = parseShipmentListArray(shipments);
		if( !result.equals(SUCCESS) )
			return result;
		
		return SUCCESS;
	}
	
	/**
	 * Processes an array of shipment ids and inserts them into the route in a specific order.
	 * @param shipments An array of shipment ids for parsing.
	 * @return SUCCESS or ERROR constant
	 */
	private String parseShipmentListArray(String[] shipments){
		// TODO This method needs to be optimized.
		this.parsedShipments = new LinkedList<Shipment>();
		int i = 0;
		for( String shipment : shipments ){
			try{
				Long shipmentId = Long.parseLong(shipment);
				List<Shipment> fromDbList = shipmentDao.findById(shipmentId);
				if( fromDbList == null || fromDbList.size() != 1 ){
					this.addActionError("One or more of the shipments specified does not exist in the database.  Please try refreshing the page.");
					return INPUT;
				}
				
				Shipment fromDb = fromDbList.get(0);
				fromDb.setRouteOrder(i);
				i++;
				parsedShipments.add(fromDb);
					
			}
			catch(NumberFormatException e){
				LOGGER.fatal("Invalid shipment list.  One or more of the shipment ids could not be parsed to a number.");
				return ERROR;
			}
		}

		return SUCCESS;
	}
	
	protected String calculateRouteFields(Route newRoute) {
		String result = calcGoogleDirectionsValues(newRoute);
		if( !result.equals(SUCCESS) )
			return result;
		
		if( request == null )
			return ERROR;
		
		int totalWeight = 0;
		int totalCubicWeight = 0;
		for( Shipment ship : newRoute.getOrderedShipments() ){
			totalWeight += ship.getWeight();
			totalCubicWeight += ship.getCubicWeight();
		}
		
		newRoute.setTotalWeight(new Integer(totalWeight));
		newRoute.setTotalCubicWeight(new Integer(totalCubicWeight));
		
		
		return SUCCESS;
	}
	
	private String calcGoogleDirectionsValues(Route newRoute){
		
		Location origin;
		Location destination;
		
		TreeSet<Shipment> shipments = newRoute.getOrderedShipments();
		if( shipments == null || shipments.size() <= 0 ){
			return ERROR;
		}
		else{
			newRoute.setStartLocation(shipments.first().getLocation());
			newRoute.setEndLocation(shipments.last().getDestination());
		}
		
		origin = newRoute.getStartLocation();
		destination = newRoute.getEndLocation();
		
		try{
			if( shipments.size() >= 1 ){
				Location[] waypoints = new Location[shipments.size()-1];
				// Step through the shipments in order
				int i = 0;
				for( Shipment ship : shipments ){
					if( i < shipments.size()- 1 ){
						waypoints[i] = ship.getDestination();
					}
					i++;
				}
				
				request = new GoogleMapsDirectionsRequest(origin, destination, Output.xml, waypoints);
			}
			else{
				request = new GoogleMapsDirectionsRequest(origin, destination, Output.xml, null);
			}
			
			GoogleMapsDirectionsResponse response = request.makeRequest();
			if( response != null && !response.hasErrors() ){
				newRoute.setTotalTime(response.getDuration());
				newRoute.setTotalMiles(response.getDistance()/GoogleMapsDirectionsResponse.FEET_PER_MILE);
				newRoute.setTotalDays(response.getDuration()/GoogleMapsDirectionsResponse.SECONDS_PER_DAY);
			}
			
			return SUCCESS;
		}
		catch(ServiceException e){
			e.printStackTrace();
		}
		
		
		return ERROR;
	}
	
	
	protected void initializeSelectedElements() throws StrutsElementException {
		String result;
		result = vehicleSelect.initializeSelected();
		if( !result.equals(SUCCESS) )
			addFieldError("vehicleSelect.selected", result);
		
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

	public ShipmentDao getShipmentDao() {
		return shipmentDao;
	}

	public void setShipmentDao(ShipmentDao shipmentDao) {
		this.shipmentDao = shipmentDao;
	}

	public LinkedList<Shipment> getParsedShipments() {
		return parsedShipments;
	}

	public List<Shipment> getAllShipments() {
		return allShipments;
	}

	public void setAllShipments(List<Shipment> allShipments) {
		this.allShipments = allShipments;
	}

	public String getShipmentList() {
		return shipmentList;
	}

	public void setShipmentList(String shipmentList) {
		this.shipmentList = shipmentList;
	}

	public List<Shipment> getUnselectedShipments() {
		return unselectedShipments;
	}

	public void setUnselectedShipments(List<Shipment> unselectedShipments) {
		this.unselectedShipments = unselectedShipments;
	}
}
