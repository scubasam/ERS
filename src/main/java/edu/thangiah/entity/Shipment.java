package edu.thangiah.entity;


import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.NotNull;
import org.hibernate.validator.Valid;

/** 
 * Shipment model.
 * @author pbair
 */
@Entity
@Table(name="shipments")
public class Shipment extends AbstractEntity implements Serializable, EntityInterface {
    private static final long serialVersionUID = 1L;
    protected Long id;
    private Date timeEntered = null;
    private Integer orderId = null;
    private VehicleType vehicleType = null;
    private Location location = null;
    private Route route = null;
    private Date availableDate = null;
    private Time availableTime = null;
    private Date releaseDate = null;
    private Time releaseTime = null;
    private Date earliestDeliveryDate = null;
    private Time earliestDeliveryTime = null;
    private Date latestDeliveryDate = null;
    private Time latestDeliveryTime = null;
    private Integer serviceTime = null;
    private Integer weight = null;
    private Integer cubicWeight = null;
    private String customerName = null;
    private Location destination = null;
    private Boolean pooledShipment = null;
    private Location pooledDestination = null;

    public Shipment() {
        super();
    }

    public Shipment(Long id) {
        this.id = id;
    }

    public Shipment(Long id, Date timeEntered, Integer orderId, VehicleType vehicleType, Location location, Route route, Date availableDate,
                    Time availableTime, Date releaseDate, Time releaseTime, Date earliestDeliveryDate, Time earliestDeliveryTime,
                    Date latestDeliveryDate, Time latestDeliveryTime, Integer serviceTime, Integer weight, Integer cubicWeight, String customerName,
                    Location destination, Boolean pooledShipment, Location pooledDestination) {
        this.id = id;
        this.timeEntered = timeEntered;
        this.orderId = orderId;
        this.vehicleType = vehicleType;
        this.location = location;
        this.route = route;
        this.availableDate = availableDate;
        this.availableTime = availableTime;
        this.releaseDate = releaseDate;
        this.releaseTime = releaseTime;
        this.earliestDeliveryDate = earliestDeliveryDate;
        this.earliestDeliveryTime = earliestDeliveryTime;
        this.latestDeliveryDate = latestDeliveryDate;
        this.latestDeliveryTime = latestDeliveryTime;
        this.serviceTime = serviceTime;
        this.weight = weight;
        this.cubicWeight = cubicWeight;
        this.customerName = customerName;
        this.destination = destination;
        this.pooledShipment = pooledShipment;
        this.pooledDestination = pooledDestination;
    }

    @Column(name="time_entered")
    public Date getTimeEntered() {
        return timeEntered;
    }

    public void setTimeEntered(Date timeEntered) {
        this.timeEntered = timeEntered;
    }

    @Column(name="order_id")
    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    @ManyToOne
    @JoinColumn(name="vehicle_type_id")
    @Valid
    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
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

    @ManyToOne
    @JoinColumn(name="route_id")
    @Valid
    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    @Column(name="available_date")
    public Date getAvailableDate() {
        return availableDate;
    }

    public void setAvailableDate(Date availableDate) {
        this.availableDate = availableDate;
    }

    @Column(name="available_time")
    public Time getAvailableTime() {
        return availableTime;
    }

    public void setAvailableTime(Time availableTime) {
        this.availableTime = availableTime;
    }

    @Column(name="release_date")
    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Column(name="release_time")
    public Time getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Time releaseTime) {
        this.releaseTime = releaseTime;
    }

    @Column(name="earliest_delivery_date")
    public Date getEarliestDeliveryDate() {
        return earliestDeliveryDate;
    }

    public void setEarliestDeliveryDate(Date earliestDeliveryDate) {
        this.earliestDeliveryDate = earliestDeliveryDate;
    }

    @Column(name="earliest_delivery_time")
    public Time getEarliestDeliveryTime() {
        return earliestDeliveryTime;
    }

    public void setEarliestDeliveryTime(Time earliestDeliveryTime) {
        this.earliestDeliveryTime = earliestDeliveryTime;
    }

    @Column(name="latest_delivery_date")
    public Date getLatestDeliveryDate() {
        return latestDeliveryDate;
    }

    public void setLatestDeliveryDate(Date latestDeliveryDate) {
        this.latestDeliveryDate = latestDeliveryDate;
    }

    @Column(name="latest_delivery_time")
    public Time getLatestDeliveryTime() {
        return latestDeliveryTime;
    }

    public void setLatestDeliveryTime(Time latestDeliveryTime) {
        this.latestDeliveryTime = latestDeliveryTime;
    }

    @Column(name="service_time")
    public Integer getServiceTime() {
        return serviceTime;
    }

    public void setServiceTime(Integer serviceTime) {
        this.serviceTime = serviceTime;
    }

    @Column(name="weight")
    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Column(name="cubic_weight")
    public Integer getCubicWeight() {
        return cubicWeight;
    }

    public void setCubicWeight(Integer cubicWeight) {
        this.cubicWeight = cubicWeight;
    }

    @Column(name="customer_name")
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @ManyToOne
    @JoinColumn(name="destination_id")
    @Valid
    public Location getDestination() {
        return destination;
    }

    public void setDestination(Location destination) {
        this.destination = destination;
    }

    @Column(name="pooled_shipment")
    @NotNull
    public Boolean getPooledShipment()
    {
        return pooledShipment;
    }

    public void setPooledShipment(Boolean pooledShipment)
    {
        this.pooledShipment = pooledShipment;
    }

    @ManyToOne
    @JoinColumn(name="pooled_destination_id")
    @Valid
    public Location getPooledDestination() {
        return pooledDestination;
    }

    public void setPooledDestination(Location pooledDestination) {
        this.pooledDestination = pooledDestination;
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