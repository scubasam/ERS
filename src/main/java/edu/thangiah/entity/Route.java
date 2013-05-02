package edu.thangiah.entity;


import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.IndexColumn;
import org.hibernate.validator.Valid;

import edu.thangiah.dao.ShipmentDao;

/**
 * Route model.
 * @author pbair, Kelly Smith
 */
@Entity
@Table(name="routes")
public class Route extends AbstractEntity implements Serializable, EntityInterface {
    private final static long serialVersionUID = 1L;
    protected Long id;
    private Vehicle vehicle = null;
    private Set<Shipment> shipments = null;
    
    private TreeSet<Shipment> orderedShipments;
    
    // Start Calculated Shipment Values
    private Location startLocation = null;
    private Location endLocation = null;
    
    private Date startDate = null;
    private Date endDate = null;
    
    private Integer totalWeight = null;
    private Integer totalCubicWeight = null;
    
    private Double totalMiles = null;
    private Integer totalTime = null;
    private Integer totalDays = null;

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
    	this.setOrderedShipments(new TreeSet<Shipment>(shipments));
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
	
	public String toString(){
		if( startLocation != null && endLocation != null )
			return "Route from " + startLocation.toString() + " to " + endLocation.toString();
		else
			return "Route(" + id + ")";
	}

	public TreeSet<Shipment> getOrderedShipments() {
		return orderedShipments;
	}

	public void setOrderedShipments(TreeSet<Shipment> orderedShipments) {
		this.orderedShipments = orderedShipments;
	}


	public void addShipment(Shipment ship, ShipmentDao shipmentDao) {
		if( shipments == null )
			shipments = new HashSet<Shipment>();
		
		if( orderedShipments == null )
			orderedShipments = new TreeSet<Shipment>();
		
		shipments.add(ship);
		orderedShipments.add(ship);
		
		ship.setRoute(this);
		shipmentDao.update(ship);
		
	}
	
	public void removeShipment(Shipment ship, ShipmentDao shipmentDao) {
		// TODO Auto-generated method stub
		if( shipments == null || orderedShipments == null )
			return;
		
		shipments.remove(ship);
		orderedShipments.remove(ship);
		
		ship.setRoute(null);
		shipmentDao.update(ship);
	}

	public Date getStartDate() {
		return startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public Integer getTotalWeight() {
		return totalWeight;
	}

	public Integer getTotalCubicWeight() {
		return totalCubicWeight;
	}

	public Double getTotalMiles() {
		return totalMiles;
	}

	public Integer getTotalTime() {
		return totalTime;
	}

	public Integer getTotalDays() {
		return totalDays;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public void setTotalWeight(Integer totalWeight) {
		this.totalWeight = totalWeight;
	}

	public void setTotalCubicWeight(Integer totalCubicWeight) {
		this.totalCubicWeight = totalCubicWeight;
	}

	public void setTotalMiles(Double totalMiles) {
		this.totalMiles = totalMiles;
	}

	public void setTotalTime(Integer totalTime) {
		this.totalTime = totalTime;
	}

	public void setTotalDays(Integer totalDays) {
		this.totalDays = totalDays;
	}

	
}