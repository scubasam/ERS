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

    	return SUCCESS;
    }

	// called automatically
    public void validate(){
    	shipmentValidation();

    }
	
}
