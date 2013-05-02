package edu.thangiah.action.route;

import java.util.Set;
import java.util.TreeSet;

import com.opensymphony.xwork2.Preparable;

import edu.thangiah.entity.Location;
import edu.thangiah.entity.Route;
import edu.thangiah.entity.Shipment;
import edu.thangiah.service.GoogleMapsDirectionsRequest;
import edu.thangiah.service.GoogleMapsDirectionsRequest.Output;
import edu.thangiah.service.GoogleMapsDirectionsResponse;
import edu.thangiah.service.ServiceException;
import edu.thangiah.strutsutility.exception.StrutsElementException;

/**
 *This class extends the management controller and implements preparable. It's primary function
 *is to to handle everything related to adding and Route entity 
 * 
 * @author Alex McCracken, Kelly Smith
 */

public class AddAction extends ManagementController implements Preparable {

	private GoogleMapsDirectionsRequest request;
	private static final long serialVersionUID = -5659010171250880237L;

	@Override
    public String execute()
    {	
		try{
			initializeSelectedElements();
		}
		catch( StrutsElementException e ){
			addActionError("An unknown error occured.  Plase try reloading the page.");
			return ERROR;
		}
		
		if( this.hasActionErrors() || this.hasFieldErrors() )
			return INPUT;
		
		
		String result = this.parseShipmentList();
		if( !result.equals(SUCCESS) )
			return result;
		
		
		Route newRoute = new Route();
		newRoute.setVehicle(vehicleSelect.getSelectedEntity());
		
		
		try{
			routeDao.add(newRoute);
			
			if( this.getParsedShipments() != null ){
				for( Shipment ship : getParsedShipments() ){
					newRoute.addShipment(ship, shipmentDao);
				}
				
				result = calculateRouteFields(newRoute);
				if( !result.equals(SUCCESS) )
					return result;
				
				routeDao.update(newRoute);
			}
		}
		catch( Exception e ){
			e.printStackTrace();
			return ERROR;
		}
		
    	return SUCCESS;
    }

	private String calculateRouteFields(Route newRoute) {
		String result = getGoogleDirectionsRequest(newRoute);
		if( !result.equals(SUCCESS) )
			return result;
		
		if( request == null )
			return ERROR;
		
		
		
		return SUCCESS;
	}
	
	private String getGoogleDirectionsRequest(Route newRoute){
		
		Location origin;
		Location destination;
		
		TreeSet<Shipment> shipments = newRoute.getOrderedShipments();
		if( shipments == null || shipments.size() <= 0 ){
			return ERROR;
		}
		else{
			newRoute.setStartLocation(shipments.first().getDestination());
			newRoute.setEndLocation(shipments.last().getDestination());
		}
		
		origin = newRoute.getStartLocation();
		destination = newRoute.getEndLocation();
		
		try{
			if( shipments.size() > 1 ){
				Location[] waypoints = new Location[shipments.size()-2];
				// Step through the shipments in order
				int i = 0;
				for( Shipment ship : shipments ){
					if( i > 0 && i < shipments.size()- 1 ){
						waypoints[i-1] = ship.getDestination();
					}
					i++;
				}
				
				request = new GoogleMapsDirectionsRequest(origin, destination, Output.xml, waypoints);
			}
			else{
				request = new GoogleMapsDirectionsRequest(origin, destination, Output.xml, null);
			}
			
			GoogleMapsDirectionsResponse response = request.makeRequest();
			
			return SUCCESS;
		}
		catch(ServiceException e){
			e.printStackTrace();
		}
		
		
		return ERROR;
	}
}
