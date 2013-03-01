package edu.thangiah.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.validator.Length;


/**
 * Contact model.
 * @author pbair,ksmith
 */
@Entity
@Table(name="contacts")
public class Contact implements Serializable {
    private static final long serialVersionUID = 1L;
    protected Long id = null;
    private String firstName = null;
    private String lastName = null;
    private String middleInitial = null;
    private String emailAddress = null;
    private String streetAddress1 = null;
    private String streetAddress2 = null;
    private String city = null;
    private String state = null;
    private String zip = null;
    private String primaryPhone = null;
    private String workPhone = null;

    public Contact() {
    	
    }

    public Contact(Long id) {
        this.id = id;
    }

    public Contact(Long id, String firstName, String lastName, String middleInitial, String emailAddress, String streetAddress1,
                    String streetAddress2, String city, String state, String zip, String primaryPhone, String workPhone) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleInitial = middleInitial;
        this.emailAddress = emailAddress;
        this.streetAddress1 = streetAddress1;
        this.streetAddress2 = streetAddress2;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.primaryPhone = primaryPhone;
        this.workPhone = workPhone;
    }

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name="first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name="last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name="middle_initial")
    public String getMiddleInitial() {
        return middleInitial;
    }

    public void setMiddleInitial(String middleInitial) {
        this.middleInitial = middleInitial;
    }

    @Column(name="email_address")
    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Column(name="street_address_1")
    public String getStreetAddress1() {
        return streetAddress1;
    }

    public void setStreetAddress1(String streetAddress1) {
        this.streetAddress1 = streetAddress1;
    }

    @Column(name="street_address_2")
    public String getStreetAddress2() {
        return streetAddress2;
    }

    public void setStreetAddress2(String streetAddress2) {
        this.streetAddress2 = streetAddress2;
    }

    @Column(name="city")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Column(name="state")
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Column(name="zip")
    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    @Column(name="primary_phone")
    @Length(min=10, max=10)
    public String getPrimaryPhone() {
        return primaryPhone;
    }

    public void setPrimaryPhone(String primaryPhone) {
        this.primaryPhone = primaryPhone;
    }

    @Column(name="work_phone")
    @Length(min=10, max=10)
    public String getWorkPhone() {
        return workPhone;
    }

    public void setWorkPhone(String workPhone) {
        this.workPhone = workPhone;
    }
}