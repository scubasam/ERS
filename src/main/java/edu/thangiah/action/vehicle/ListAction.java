package edu.thangiah.action.vehicle;

import java.util.List;

import com.opensymphony.xwork2.Action;

import edu.thangiah.entity.Vehicle;

public class ListAction extends VehicleAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4593520145231869817L;
	
	
	private List<Vehicle> vehicles;
	
	public String execute() {
        if (vehicleDao == null) {
            return Action.ERROR;
        }
        LOGGER.debug("Get all vehicle types");
        vehicles = vehicleDao.findAll();
        LOGGER.debug("Vehicles number = " + vehicles.size());
        return Action.SUCCESS;
    }

	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}
}
