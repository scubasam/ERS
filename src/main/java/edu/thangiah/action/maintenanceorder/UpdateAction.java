package edu.thangiah.action.maintenanceorder;

import edu.thangiah.entity.MaintenanceOrder;
import edu.thangiah.strutsutility.exception.StrutsElementException;

/**
 * This class extends the management controller. Its primary function
 * is to handle everything related to updating and maintenance order entity.
 * 
 * 
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
    	
    	MaintenanceOrder fromDb = this.retrieveEntityById(maintenanceOrderDao, id);
    	if( fromDb == null){
    		this.addActionError("This maintenance order does not exist.  Please try again.");
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
		
		if( this.hasActionErrors() || this.hasFieldErrors() ){
			return INPUT;
		}
		fromDb.setVehicle(vehicleSelect.getSelectedEntity());
		fromDb.setDriver(driverSelect.getSelectedEntity());
		fromDb.setServiceTechnician(serviceTechnicianSelect.getSelectedEntity());
		fromDb.setScheduledDate(this.getEntity().getScheduledDate());
		fromDb.setDetails(this.getEntity().getDetails());
		fromDb.setServiceTypeKey(this.getEntity().getServiceTypeKey());
		fromDb.setCost(this.getEntity().getCost());
		fromDb.setStatusKey(this.getEntity().getStatusKey());
		fromDb.setMaintenanceType(this.getEntity().getMaintenanceType());

		try{
			maintenanceOrderDao.update(fromDb);
		}
		catch(Exception e){
			return ERROR;
		}
		return SUCCESS;
	}
	
	@Override
    // called automatically
    public void validate(){
    	if( getEntity() != null && getEntity().getVehicle() != null )
    	{
    		requiredString(getEntity().getRequester().toString(), "maintenanceOrder.requester");
    		requiredString(getEntity().getServiceTechnician().toString(), "maintenanceOrder.serviceTechnician");
    		requiredString(getEntity().getScheduledDate().toString(), "maintenanceOrder.scheduleDate");
    		requiredString(getEntity().getDetails(), "maintenanceOrder.details");
    		requiredString(getEntity().getServiceTypeKey(), "maintenanceOrder.serviceTypeKey");
    		requiredString(getEntity().getCost(), "maintenanceOrder.cost");    	
    		requiredString(getEntity().getStatusKey(), "maintenanceOrder.statusKey");
    		requiredString(getEntity().getVehicle().toString(), "maintenanceOrder.vehicle");
    		requiredString(getEntity().getMaintenanceType(), "maintenanceOrder.maintenanceType");
    	}		
    	else{
    		addActionError("Unknown error.  Please try again.");
    	}

    }
	public MaintenanceOrder getMaintenanceOrder()
	{
		return getEntity();
	}
    
    public void setMaintenanceOrder(MaintenanceOrder maintenanceOrder)
    {
    	this.setEntity(maintenanceOrder);
    }
	
}