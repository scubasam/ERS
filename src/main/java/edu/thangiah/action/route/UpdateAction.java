package edu.thangiah.action.route;

import java.util.TreeSet;

import edu.thangiah.entity.Route;
import edu.thangiah.entity.Shipment;
import edu.thangiah.strutsutility.exception.StrutsElementException;

/**
 * This class extends the management controller. Its primary function
 * is to handle everything related to updating and Route entity.
 * 
 * @author Alex McCracken, Kelly Smith
 *
 */


public class UpdateAction extends ManagementController{

	private static final long serialVersionUID = 4634172821230672694L;

	@Override
	public void prepare() throws Exception {
		this.mode =  Modes.EDIT;
		super.prepare();
	}
	
	
	@Override
    public String execute(){
		// Errors could be thrown by the ManagementController prepare methods.
    	if( this.hasControllerErrors() ){
    		return ERROR;
    	}
    	
    	Route fromDb = this.retrieveEntityById(routeDao, id);
    	if( fromDb == null){
    		this.addActionError("This route does not exist.  Please try again.");
    		return INPUT;
    	}
    	
    	// Get the selected values from the form.
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
		
		fromDb.setVehicle(vehicleSelect.getSelectedEntity());
		
		try{
			
			// Use new TreeSet to avoid concurrent modification exception.
			for( Shipment ship : new TreeSet<Shipment>(fromDb.getOrderedShipments()) ){
				if( getParsedShipments() == null || !getParsedShipments().contains(ship) ){
					fromDb.removeShipment(ship, shipmentDao);
				}
			}
			
			if( this.getParsedShipments() != null ){
				
				for( Shipment ship : getParsedShipments() ){
					if( !fromDb.getOrderedShipments().contains(ship) )
						fromDb.addShipment(ship, shipmentDao);
					else
						shipmentDao.update(ship); // maintain new order even if already exists.
				}
			}
			
			
			result = calculateRouteFields(fromDb);
			if( !result.equals(SUCCESS) )
				return result;
			
			routeDao.update(fromDb);
		}
		catch( Exception e ){
			return ERROR;
		}
    	
    	
    	return SUCCESS;
	}
}