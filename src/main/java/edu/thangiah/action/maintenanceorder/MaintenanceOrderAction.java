package edu.thangiah.action.maintenanceorder;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.Preparable;

import edu.thangiah.action.AbstractAction;
import edu.thangiah.dao.MaintenanceOrderDao;

public class MaintenanceOrderAction extends AbstractAction implements Preparable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7209552074663168122L;

	protected static final Logger LOGGER = Logger.getLogger(MaintenanceOrderAction.class.getName());
	
	@Autowired
	protected MaintenanceOrderDao maintenanceOrderDao;

	public MaintenanceOrderDao getMaintenanceOrderDao() {
		return maintenanceOrderDao;
	}

	public void setMaintenanceOrderDao(MaintenanceOrderDao maintenanceOrderDao) {
		this.maintenanceOrderDao = maintenanceOrderDao;
	}

	
}
