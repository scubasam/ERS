package edu.thangiah.entity;

import java.io.Serializable;


/**
 * Contact model.
 * @author pbair,ksmith
 */
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleInitial() {
        return middleInitial;
    }

    public void setMiddleInitial(String middleInitial) {
        this.middleInitial = middleInitial;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getStreetAddress1() {
        return streetAddress1;
    }

    public void setStreetAddress1(String streetAddress1) {
        this.streetAddress1 = streetAddress1;
    }

    public String getStreetAddress2() {
        return streetAddress2;
    }

    public void setStreetAddress2(String streetAddress2) {
        this.streetAddress2 = streetAddress2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getPrimaryPhone() {
        return primaryPhone;
    }

    public void setPrimaryPhone(String primaryPhone) {
        this.primaryPhone = primaryPhone;
    }


    public String getWorkPhone() {
        return workPhone;
    }

    public void setWorkPhone(String workPhone) {
        this.workPhone = workPhone;
    }
    
    public String toString(){
    	return this.firstName + " " + this.lastName;
    }

	public void merge(Contact with) {
		if( with != null ){
	        this.firstName = with.firstName;
	        this.lastName = with.lastName;
	        this.middleInitial = with.middleInitial;
	        this.emailAddress = with.emailAddress;
	        this.streetAddress1 = with.streetAddress1;
	        this.streetAddress2 = with.streetAddress2;
	        this.city = with.city;
	        this.state = with.state;
	        this.zip = with.zip;
	        this.primaryPhone = with.primaryPhone;
	        this.workPhone = with.workPhone;
		}
	}
}