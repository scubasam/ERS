package edu.thangiah.action.driver;

import java.util.List;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.Action;

import edu.thangiah.entity.Driver;


public class ListAction extends DriverAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2410135838068146097L;
	protected static final Logger LOGGER = Logger.getLogger(DriverAction.class.getName());
	
	private List<Driver> drivers;
	
	public String execute() {
        if (driverDao == null) {
            return Action.ERROR;
        }
        LOGGER.debug("Get all vehicle types");
        drivers = driverDao.findAll();
        LOGGER.debug("Vehicles number = " + drivers.size());
        return Action.SUCCESS;
    }

	public List<Driver> getDrivers() {
		return drivers;
	}

	public void setDrivers(List<Driver> drivers) {
		this.drivers = drivers;
	}

}
