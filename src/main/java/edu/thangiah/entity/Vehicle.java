package edu.thangiah.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.validator.NotEmpty;
import org.hibernate.validator.NotNull;
import org.hibernate.validator.Valid;
/**
 * 
 * vehicle model
 * @author Alex McCracken, Kelly Smith
 *
 */

public class Vehicle extends AbstractEntity implements Serializable, EntityInterface {
	private static final long serialVersionUID = 1L;
	
	protected Long id = null;
    private String plateNumber = null;
    private String vinNumber = null;
    private String manufacturedYear = null;
    private VehicleType vehicleType = null;
    private Contractor contractor = null;
    private Set<Driver> drivers = null;
    private Location location = null;
    private Driver driver = null;
    

    public static final String[] statuses = {"available", "unavailable"};

    public Vehicle() {
        super();
    }

    public Vehicle(Long id) {
    	super();
        this.id = id;
    }

    public Vehicle(Long id, String plateNumber, String vinNumber, String manufacturedYear, /*String status,*/ VehicleType vehicleType,
            Contractor contractor, Set<Driver> drivers, Location location) {
        super();
        this.id = id;
        this.plateNumber = plateNumber;
        this.vinNumber = vinNumber;
        this.manufacturedYear = manufacturedYear;
        this.vehicleType = vehicleType;
        this.contractor = contractor;
        this.drivers = drivers;
        this.location = location;
    }

    @Column(name="plate_number")
    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    @Column(name="vin_number")
    @NotEmpty
    public String getVinNumber() {
        return vinNumber;
    }

    public void setVinNumber(String vinNumber) {
        this.vinNumber = vinNumber;
    }

    @Column(name="manufactured_year")
    @NotEmpty
    public String getManufacturedYear() {
        return manufacturedYear;
    }

    public void setManufacturedYear(String manufacturedYear) {
        this.manufacturedYear = manufacturedYear;
    }

    @ManyToOne
    @JoinColumn(name="vehicle_type_id")
    @NotNull
    @Valid
    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    @ManyToOne
    @JoinColumn(name="contractor_id")
    @Valid
    public Contractor getContractor() {
        return contractor;
    }

    public void setContractor(Contractor contractor) {
        this.contractor = contractor;
    }

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(name="vehicle_driver", joinColumns=@JoinColumn(name="vehicle_id"), inverseJoinColumns=@JoinColumn(name="driver_id"))
    @Valid
    public Set<Driver> getDrivers() {
        return drivers;
    }
    public void setDriver(Driver driver) {
    	this.driver = driver;
    }
    
    public Driver getDriver() {
    	return driver;
    }

    public void setDrivers(Set<Driver> drivers) {
        this.drivers = drivers;
    }

    @ManyToOne
    @JoinColumn(name="location_id")
    @Valid
    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String toString(){
		return this.vehicleType.toString() + " (" + this.vinNumber + ")";
	}
	
	@Override
	public String getViewLink() {
		return null;
	}
	

}
