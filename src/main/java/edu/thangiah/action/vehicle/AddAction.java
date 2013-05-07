package edu.thangiah.action.vehicle;

import com.opensymphony.xwork2.Preparable;

import edu.thangiah.entity.Vehicle;
import edu.thangiah.strutsutility.exception.StrutsElementException;

/**
 *This class extends the management controller and implements preparable. It's primary function
 *is to to handle everything related to adding and Vehicle entity 
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
		catch(StrutsElementException e){
			this.addActionError("An unknown error occured.  Plase try reloading the page.");
			return ERROR;
		}
		
		if( this.hasActionErrors() || this.hasFieldErrors() )
			return INPUT;
		
		
		Vehicle newVehicle = new Vehicle();
		
		newVehicle.setVehicleType(vehicleTypeSelect.getSelectedEntity());
		newVehicle.setContractor(contractorSelect.getSelectedEntity());
		newVehicle.setDriver(driverSelect.getSelectedEntity());
		newVehicle.setLocation(locationSelect.getSelectedEntity());
		
		try{
			vehicleDao.add(newVehicle);
		}
		catch( Exception e ){
			this.addActionError("And error has occurred in adding this vehicle please try again!");
			return INPUT;
		}
		
    	return SUCCESS;
    }
	
}
