package edu.thangiah.action.servicetechnician;

import java.util.List;

import edu.thangiah.entity.MaintenanceOrder;
import edu.thangiah.entity.ServiceTechnician;

/**
 * This class extends the management controller. It's primary function is to handle everything
 * related to deleting a Service Technician entity
 * 
 * @author Alex McCracken, Kelly Smith
 *
 */


public class DeleteAction extends ManagementController{
	private static final long serialVersionUID = -8519029040295534966L;


	@Override
	public void prepare() throws Exception {
		this.mode = Modes.DELETE;
		super.prepare();
	}
	
	
	@Override
	public String execute(){
		// Errors could be thrown by the ManagementController prepare methods.
		if( this.hasControllerErrors() ){
			return ERROR;
		}
		
		if( id <= 0 ){
			this.addActionError("Must specify which Service Technician you would like to delete.");
			return INPUT;
		}
		
		ServiceTechnician fromDb = this.retrieveEntityById(serviceTechnicianDao, id);
		if( fromDb == null ){
			this.addActionError("This service technician does not exist.  Please try again.");
			return INPUT;
		}
		
		try{
			List<MaintenanceOrder> maintenanceOrders = maintenanceOrderDao.findByServiceTechnician(fromDb);
			if(maintenanceOrders == null || maintenanceOrders.size() == 0){
				serviceTechnicianDao.delete(fromDb);
				return SUCCESS;
			}
			else {
				this.addActionError("Dependencies Exist. You cannot delete it.");
				return INPUT;
			}
		}
		catch( Exception e ){
			this.addActionError("And exception has occured please refresh the page. If this error continues contact system administrator.");
			return INPUT;
		}
	}
}
