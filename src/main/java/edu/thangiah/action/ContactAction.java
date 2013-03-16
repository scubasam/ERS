package edu.thangiah.action;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
 
import edu.thangiah.dao.ContactDao;
import edu.thangiah.entity.Contact;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.Preparable;
 
public class ContactAction implements Preparable {
 
    private static final Logger LOGGER = Logger.getLogger(ContactAction.class.getName());
 
    private List<Contact> contacts;
 
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
    
    @Autowired
    private ContactDao contactDao;
    
	@Override
	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	// ACTION METHODS
	public String listAll() {
        if (contactDao == null) {
            return Action.ERROR;
        }
        LOGGER.debug("Get all contacts");
        contacts = contactDao.findAll();
        LOGGER.debug("Contacts number = " + contacts.size());
        return Action.SUCCESS;
    }
	

	public ContactDao getContactDao() {
		return contactDao;
	}

	public void setContactDao(ContactDao contactDao) {
		this.contactDao = contactDao;
	}

	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
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
 
    
}