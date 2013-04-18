package edu.thangiah.action.route;

import com.opensymphony.xwork2.Preparable;

import edu.thangiah.entity.Route;
import edu.thangiah.strutsutility.exception.StrutsElementException;


public class AddAction extends ManagementController implements Preparable {

	private static final long serialVersionUID = -5659010171250880237L;

	@Override
    public String execute()
    {
		try{
			String result;
			result = vehicleSelect.initializeSelected();
			if( !result.equals(SUCCESS) )
				addFieldError("startLocation.selected", result);
			
			result = startLocationSelect.initializeSelected();
			if( !result.equals(SUCCESS) )
				addFieldError("startLocation.selected", result);
			
			result = endLocationSelect.initializeSelected();
			if( !result.equals(SUCCESS) )
				addFieldError("startLocation.selected", result);
		}
		catch( StrutsElementException e ){
			addActionError("An unknown error occured.  Plase try reloading the page.");
			return ERROR;
		}
		
		if( this.hasActionErrors() || this.hasFieldErrors() )
			return INPUT;
		
		
		Route newRoute = new Route();
		newRoute.setVehicle(vehicleSelect.getSelectedEntity());
		newRoute.setStartLocation(startLocationSelect.getSelectedEntity());
		newRoute.setEndLocation(endLocationSelect.getSelectedEntity());
		
		try{
			routeDao.add(newRoute);
		}
		catch( Exception e ){
			return ERROR;
		}
		
    	return SUCCESS;
    }
	
}
