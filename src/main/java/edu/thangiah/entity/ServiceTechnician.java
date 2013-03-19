package edu.thangiah.entity;


import java.io.Serializable;
//import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
//import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//import org.hibernate.annotations.IndexColumn;
import org.hibernate.validator.NotEmpty;
import org.hibernate.validator.NotNull;
import org.hibernate.validator.Valid;

/**
 * ServiceTechnician model.
 * @author pbair, Kelly Smith
 */
@Entity
@Table(name="service_technicians")
public class ServiceTechnician extends AbstractEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    
    protected Long id = null;
    private Contact contact = null;
    private String skillGrade = null;
    //private List<MaintenanceOrder> maintenanceOrders = null;

    public ServiceTechnician() {
        super();
    }

    public ServiceTechnician(Long id) {
        this.id = id;
    }

    public ServiceTechnician(Long id, Contact contact, String skillGrade/*, List<MaintenanceOrder> maintenanceOrders*/) {
        this.id = id;
        this.contact = contact;
        this.skillGrade = skillGrade;
        //this.maintenanceOrders = maintenanceOrders;
    }

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinColumn(name="contact_id")
    @Valid
    @NotNull
    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    @Column(name="skill_grade")
    @NotEmpty
    public String getSkillGrade() {
        return skillGrade;
    }

    public void setSkillGrade(String skillGrade) {
        this.skillGrade = skillGrade;
    }

    /*@OneToMany(mappedBy="serviceTechnician")
    @IndexColumn(name="id")
    @Valid
    public List<MaintenanceOrder> getMaintenanceOrders() {
        return maintenanceOrders;
    }

    public void setMaintenanceOrders(List<MaintenanceOrder> maintenanceOrders) {
        this.maintenanceOrders = maintenanceOrders;
    }*/

	@Override
	public String getViewLink() {
		// TODO Auto-generated method stub
		return null;
	}
}