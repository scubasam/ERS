package edu.thangiah.action.route;


import com.opensymphony.xwork2.Preparable;

import edu.thangiah.entity.Route;
import edu.thangiah.entity.Shipment;
import edu.thangiah.strutsutility.exception.StrutsElementException;

/**
 *This class extends the management controller and implements preparable. It's primary function
 *is to to handle everything related to adding and Route entity 
 * 
 * @author Alex McCracken, Kelly Smith
 */

public class AddAction extends ManagementController implements Preparable {

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
}
