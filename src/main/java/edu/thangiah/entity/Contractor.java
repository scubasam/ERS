package edu.thangiah.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.NotEmpty;
import org.hibernate.validator.NotNull;
import org.hibernate.validator.Valid;

import edu.thangiah.decorator.HtmlDecorator;

/**
 * Contractor Model.
 * @author pbair, ksmith
 */
@Entity
@Table(name="contractors")
public class Contractor extends AbstractEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    protected Long id = null;
    private String contractorName = null;
    private Contact contact = null;
    private Set<Location> locations = null;
    private Set<Vehicle> vehicles = null;

    public Contractor() {
        super();
    }

    public Contractor(Long id) {
        this.id = id;
    }

    public Contractor(Long id, String contractorName, Contact contact, Set<Location> locations, Set<Vehicle> vehicles) {
        this.id = id;
        this.contractorName = contractorName;
        this.contact = contact;
        this.locations = locations;
        this.vehicles = vehicles;
    }

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name="contractor_name")
    @NotEmpty
    public String getContractorName() {
        return contractorName;
    }

    public void setContractorName(String contractorName) {
        this.contractorName = contractorName;
    }

    @OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinColumn(name="contact_id")
    @NotNull
    @Valid
    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy="contractor")
    @Valid
    public Set<Location> getLocations() {
        return locations;
    }

    public void setLocations(Set<Location> locations) {
        this.locations = locations;
    }

	public Set<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(Set<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	@Override
	public String getViewLink() {
		return HtmlDecorator.generateEntityLink("viewContractor", this.id, this.contractorName);
	}
	
	public String toString(){
		return contractorName;
	}

	public void merge(Contractor with) {
			this.contractorName = with.contractorName;
			this.contact = with.contact;
	}
}