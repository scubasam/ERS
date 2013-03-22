package edu.thangiah.entity;


import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.Valid;

/**
 * MaintenanceOrder model.
 * @author pbair
 */
@Entity
@Table(name="maintenance_orders")
public class MaintenanceOrder extends AbstractEntity implements Serializable {
	protected Long id;
    private final static long serialVersionUID = 1L;
    private Driver requester = null;
    private ServiceTechnician serviceTechnician = null;
    private Date scheduledDate = null;
    private String details = null;
    private String serviceTypeKey = null;
    private String cost = null;
    private String statusKey = null;
    private Vehicle vehicle = null;
    private String maintenanceType = null;

    public MaintenanceOrder() {
        super();
    }

    public MaintenanceOrder(Long id) {
        this.id = id;
    }

    public MaintenanceOrder(Long id, Driver requester, ServiceTechnician serviceTechnician, Date scheduledDate, String details,
                            String serviceTypeKey, String cost, String statusKey, Vehicle vehicle, String maintenanceType) {
        this.id = id;
        this.requester = requester;
        this.serviceTechnician = serviceTechnician;
        this.scheduledDate = scheduledDate;
        this.details = details;
        this.serviceTypeKey = serviceTypeKey;
        this.cost = cost;
        this.statusKey = statusKey;
        this.vehicle = vehicle;
        this.maintenanceType = maintenanceType;
    }

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="requester_id")
    @Valid
    public Driver getRequester() {
        return requester;
    }

    public void setRequester(Driver requester) {
        this.requester = requester;
    }

    @ManyToOne
    @JoinColumn(name="service_technician_id")
    @Valid
    public ServiceTechnician getServiceTechnician() {
        return serviceTechnician;
    }

    public void setServiceTechnician(ServiceTechnician serviceTechnician) {
        this.serviceTechnician = serviceTechnician;
    }

    @Column(name="scheduled_date")
    public Date getScheduledDate() {
        return scheduledDate;
    }

    public void setScheduledDate(Date scheduledDate) {
        this.scheduledDate = scheduledDate;
    }

    @Column(name="details")
    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Column(name="service_type_key")
    public String getServiceTypeKey() {
        return serviceTypeKey;
    }

    public void setServiceTypeKey(String serviceTypeKey) {
        this.serviceTypeKey = serviceTypeKey;
    }

    @Column(name="cost")
    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    @Column(name="status_key")
    public String getStatusKey() {
        return statusKey;
    }

    public void setStatusKey(String statusKey) {
        this.statusKey = statusKey;
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

    @Column(name="maintenance_type")
    public String getMaintenanceType() {
        return maintenanceType;
    }

    public void setMaintenanceType(String maintenanceType) {
        this.maintenanceType = maintenanceType;
    }

	@Override
	public String getViewLink() {
		// TODO Auto-generated method stub
		return null;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String toString(){
		return "Order: " + this.getMaintenanceType() + " " + this.getScheduledDate();
	}
}