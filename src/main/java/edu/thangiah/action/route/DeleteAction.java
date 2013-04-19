package edu.thangiah.action.route;

import edu.thangiah.entity.Route;

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
			this.addActionError("Must specify which Route you would like to delete.");
			return INPUT;
		}
		
		Route fromDb = this.retrieveEntityById(routeDao, id);
		if( fromDb == null ){
			this.addActionError("This route does not exist.  Please try again.");
			return INPUT;
		}
		
		if( fromDb.getShipments() != null && fromDb.getShipments().size() > 0 ){
			this.addActionError("Shipments depend on this Route. You cannot delete it.");
			return INPUT;
		}
		
		try{
			routeDao.delete(fromDb);
			if(fromDb !=null)
			{
				this.addActionError("Shipments depend on this Route. You cannot delete it.");
			}
		}
		catch( Exception e ){
			this.addActionError("Shipments depend on this Route. You cannot delete it.");
			return INPUT;
		}
		
		return SUCCESS;
	}
}
