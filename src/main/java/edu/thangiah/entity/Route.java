package edu.thangiah.entity;


import java.io.Serializable;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.IndexColumn;
import org.hibernate.validator.Valid;

/**
 * Route model.
 * @author pbair
 */
@Entity
@Table(name="routes")
public class Route extends AbstractEntity implements Serializable, EntityInterface {
    private final static long serialVersionUID = 1L;
    protected Long id;
    private Vehicle vehicle = null;
    private Set<Shipment> shipments = null;
    
    private Location startLocation = null;
    private Location endLocation = null;

    public Route() {
        super();
    }

    public Route(Long id) {
        this.id = id;
    }

    public Route(Long id, Vehicle vehicle, Set<Shipment> shipments, Location startLocation, Location endLocation) {
        this.id = id;
        this.vehicle = vehicle;
        this.shipments = shipments;
        this.startLocation = startLocation;
        this.endLocation = endLocation;
    }

    @ManyToOne
    @JoinColumn(name="vehicle_id")
    @Valid
    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @OneToMany(mappedBy="route")
    @IndexColumn(name="route_order_value")
    @Valid
    public Set<Shipment> getShipments() {
        return shipments;
    }

    public void setShipments(Set<Shipment> shipments) {
        this.shipments = shipments;
    }

	@Override
	public String getViewLink() {
		return null;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Location getStartLocation() {
		return startLocation;
	}

	public void setStartLocation(Location startLocation) {
		this.startLocation = startLocation;
	}

	public Location getEndLocation() {
		return endLocation;
	}

	public void setEndLocation(Location endLocation) {
		this.endLocation = endLocation;
	}
	
	public Integer getMinimumCubicWeight() {
		if( this.getVehicle() != null && this.getVehicle().getVehicleType() != null )
			return this.getVehicle().getVehicleType().getMinimumCubicWeight();
		else
			return null;
	}

	public Integer getMaximumCubicWeight() {
		if( this.getVehicle() != null && this.getVehicle().getVehicleType() != null )
			return this.getVehicle().getVehicleType().getMaximumCubicWeight();
		else
			return null;
	}
	
	public Integer getMinimumWeight() {
		if( this.getVehicle() != null && this.getVehicle().getVehicleType() != null )
			return this.getVehicle().getVehicleType().getMinimumWeight();
		else
			return null;
	}

	public Integer getMaximumWeight() {
		if( this.getVehicle() != null && this.getVehicle().getVehicleType() != null )
			return this.getVehicle().getVehicleType().getMaximumWeight();
		else
			return null;
	}
	
	public String getCapacity() {
		if( this.getVehicle() != null && this.getVehicle().getVehicleType() != null )
			return this.getVehicle().getVehicleType().getCapacity();
		else
			return null;
	}

	
}