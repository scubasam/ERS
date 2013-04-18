
package edu.thangiah.action.contact;

import java.util.List;

import com.opensymphony.xwork2.Action;

import edu.thangiah.entity.Contact;


public class ListAction extends ContactAction {
	private static final long serialVersionUID = 1L;
	
	private List<Contact> contacts;

	public String execute() {
        if (contactDao == null) {
            return Action.ERROR;
        }
        LOGGER.debug("Get all contacts");
        contacts = contactDao.findAll();
        LOGGER.debug("Contacts number = " + contacts.size());
        return Action.SUCCESS;
    }

	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}
}
