package edu.thangiah.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.validator.NotEmpty;
import org.hibernate.validator.NotNull;
import org.hibernate.validator.Valid;

public class Vehicle extends AbstractEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	protected Long id = null;
    private String plateNumber = null;
    private String vinNumber = null;
    private String manufacturedYear = null;
    private String status = null;
    private VehicleType vehicleType = null;
    private Contractor contractor = null;
    //private Set<Driver> drivers = null;
    private Location location = null;

    public static final String[] statuses = {"available", "unavailable"};

    public Vehicle() {
        super();
    }

    public Vehicle(Long id) {
    	super();
        this.id = id;
    }

    public Vehicle(Long id, String plateNumber, String vinNumber, String manufacturedYear, String status, VehicleType vehicleType,
            Contractor contractor, /*Set<Driver> drivers,*/ Location location) {
        super();
        this.id = id;
        this.plateNumber = plateNumber;
        this.vinNumber = vinNumber;
        this.manufacturedYear = manufacturedYear;
        this.status = status;
        this.vehicleType = vehicleType;
        this.contractor = contractor;
        //this.drivers = drivers;
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

    @Column(name="status")
    @NotEmpty
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    /*@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(name="vehicle_driver", joinColumns=@JoinColumn(name="vehicle_id"), inverseJoinColumns=@JoinColumn(name="driver_id"))
    @Valid
    public Set<Driver> getDrivers() {
        return drivers;
    }

    public void setDrivers(Set<Driver> drivers) {
        this.drivers = drivers;
    }*/

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

	@Override
	public String getViewLink() {
		// TODO Auto-generated method stub
		return null;
	}
}
