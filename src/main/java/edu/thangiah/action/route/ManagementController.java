package edu.thangiah.action.route;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.Action;

import edu.thangiah.action.BaseManagementController;
import edu.thangiah.dao.RouteDao;
import edu.thangiah.entity.Route;


public class ManagementController extends BaseManagementController<Route>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1194255798482840950L;

	protected static final Logger LOGGER = Logger.getLogger(ManagementController.class.getName());
	
	@Autowired
	protected RouteDao routeDao;
	
	
	@Override
	public void prepare() throws Exception {
		super.prepare();
		this.initializeEntityList(routeDao);
	}
	
	public String execute() {
        if (routeDao == null) {
            return Action.ERROR;
        }
        
        String result = initialize();
		if( !result.equals(SUCCESS) ){
			return result;
		}
        
        if( mode == Modes.EDIT ){
        	result = this.initializeEntityById(routeDao, id);
        	if( !result.equals(SUCCESS) ){
    			return result;
    		}
        }
        
        LOGGER.debug("Routes number = " + getRoutes().size());
        return SUCCESS;
    }
	
	public List<Route> getRoutes() {
		return this.getEntityList();
	}

	public void setRoutes(List<Route> routes) {
		this.setEntityList(routes);
	}
	
	public RouteDao getRouteDao() {
		return routeDao;
	}
	public void setContractorDao(RouteDao routeDao) {
		this.routeDao = routeDao;
	}
	
	public Route getRoute(){
		return this.getEntity();
	}
	
	public void setRoute(Route route){
		this.setEntity(route);
	}

	public void setRouteDao(RouteDao routeDao) {
		this.routeDao = routeDao;
	}
}
