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
public class Route extends AbstractEntity implements Serializable {
    private final static long serialVersionUID = 1L;
    protected Long id;
    private Vehicle vehicle = null;
    private Set<Shipment> shipments = null;

    public Route() {
        super();
    }

    public Route(Long id) {
        this.id = id;
    }

    public Route(Long id, Vehicle vehicle, Set<Shipment> shipments) {
        this.id = id;
        this.vehicle = vehicle;
        this.shipments = shipments;
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
}