package edu.thangiah.action;

import java.util.List;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
 
import edu.thangiah.dao.VehicleDao;
import edu.thangiah.entity.Contractor;
import edu.thangiah.entity.Location;
import edu.thangiah.entity.Vehicle;
import edu.thangiah.entity.VehicleType;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.Preparable;
 
public class VehicleAction implements Preparable {
 
    private static final Logger LOGGER = Logger.getLogger(ContactAction.class.getName());
 
    private List<Vehicle> vehicles;
    private Vehicle vehicle;
    
    protected Long id = null;
    private String plateNumber = null;
    private String vinNumber = null;
    private String manufacturedYear = null;
    private String status = null;
    private VehicleType vehicleType = null;
    private Contractor contractor = null;
    //private Set<Driver> drivers = null;
    private Location location = null;
    
    @Autowired
    private VehicleDao vehicleDao;
    
	@Override
	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	// ACTION METHODS
	public String listAll() {
        if (vehicleDao == null) {
            return Action.ERROR;
        }
        LOGGER.debug("Get all vehicle types");
        vehicles = vehicleDao.findAll();
        LOGGER.debug("Contractors number = " + vehicles.size());
        return Action.SUCCESS;
    }
	
	// END ACTION METHOD
	
	// UTILITY METHODS
	
	// END UTILITY METHODS
	
	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPlateNumber() {
		return plateNumber;
	}

	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}

	public String getVinNumber() {
		return vinNumber;
	}

	public void setVinNumber(String vinNumber) {
		this.vinNumber = vinNumber;
	}

	public String getManufacturedYear() {
		return manufacturedYear;
	}

	public void setManufacturedYear(String manufacturedYear) {
		this.manufacturedYear = manufacturedYear;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public VehicleType getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}

	public Contractor getContractor() {
		return contractor;
	}

	public void setContractor(Contractor contractor) {
		this.contractor = contractor;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public VehicleDao getVehicleDao() {
		return vehicleDao;
	}

	public void setVehicleDao(VehicleDao vehicleDao) {
		this.vehicleDao = vehicleDao;
	}


	
}