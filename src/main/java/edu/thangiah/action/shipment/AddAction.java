package edu.thangiah.action.shipment;

import java.util.Date;

import com.opensymphony.xwork2.Preparable;

import edu.thangiah.entity.Shipment;
import edu.thangiah.strutsutility.exception.StrutsElementException;

/**
 *This class extends the management controller and implements preparable. It's primary function
 *is to to handle everything related to adding and Shipment entity 
 * 
 * @author Alex McCracken, Kelly Smith
 */


public class AddAction extends ManagementController implements Preparable{

	private static final long serialVersionUID = -1708978099566079365L;
	
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
		
		Shipment shipment = this.getEntity();
		
		shipment.setTimeEntered(new Date()); // set the entered time to right now.
		
		shipment.setVehicleType(vehicleTypeSelect.getSelectedEntity());
		shipment.setLocation(locationSelect.getSelectedEntity());
		shipment.setRoute(routeSelect.getSelectedEntity());
		shipment.setDestination(destinationSelect.getSelectedEntity());
		shipment.setPooledDestination(pooledDestinationSelect.getSelectedEntity());
		
		shipmentDao.add(shipment);
		/*
		if (shipmentDao == null || shipment == null) 
		{
            this.addActionError(DB_ERROR_MESSAGE);
        }
		
		shipmentDao.add(shipment);
		vehicleTypeDao.add(vehicleType);
		//serviceTechnician.setMaintenanceOrders(maintenanceOrders)
		 */
    	return SUCCESS;
    }

	// called automatically
    public void validate(){
    	
    	if(getEntity() != null )
    	{
    		//requiredString(getEntity().getTimeEntered().toString(), "shipment.timeEntered");
    		requiredInt(getEntity().getOrderId(), "shipment.orderId");
    		//requiredString(getEntity().getVehicleType().toString(), "shipment.vehicleType");
    		//requiredString(getEntity().getLocation().toString(), "shipment.location");
    		//requiredString(getEntity().getRoute().toString(), "shipment.route");
    		//requiredString(getEntity().getAvailableDate().toString(), "shipment.availableDate");
    		//requiredString(getEntity().getReleaseDate().toString(), "shipment.releaseDate");
    		//requiredString(getEntity().getEarliestDeliveryDate().toString(), "shipment.earliestDeliveryDate");
    		//requiredString(getEntity().getLatestDeliveryDate().toString(), "shipment.latestDeliveryDate");
    		requiredInt(getEntity().getServiceTime(), "shipment.serviceTime");
    		requiredInt(getEntity().getCubicWeight(), "shipment.cubicWeight");
    		requiredString(getEntity().getCustomerName(), "shipment.customerName");
    		//requiredString(getEntity().getDestination().toString(), "shipment.destination");
    		//requiredString(getEntity().getPooledShipment().toString(), "shipment.pooledDestination");
    	}		
    	else{
    		addActionError("Unknown error.  Please try again.");
    	}

    }
	
}
