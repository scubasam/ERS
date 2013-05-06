package edu.thangiah.action.servicetechnician;

import com.opensymphony.xwork2.Preparable;

import edu.thangiah.entity.ServiceTechnician;
import edu.thangiah.strutsutility.exception.StrutsElementException;

/**
 *This class extends the management controller and implements preparable. It's primary function
 *is to to handle everything related to adding and Service Technician entity 
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
		
		
		ServiceTechnician newServiceTechnician = new ServiceTechnician();
		newServiceTechnician.setContact(contactSelect.getSelectedEntity());
		newServiceTechnician.setMaintenanceOrder(maintenanceOrderSelect.getSelectedEntity());
		
		try{
			if(this.getEntity() != null){
				serviceTechnicianDao.add(newServiceTechnician);				
			}
		}
		catch( Exception e ){
			return ERROR;
		}
		
    	return SUCCESS;
    }
	
}
