package edu.thangiah.contact.action;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.Preparable;

import edu.thangiah.action.AbstractAction;
import edu.thangiah.dao.ContactDao;

public class ContactAction extends AbstractAction implements Preparable {

	private static final long serialVersionUID = 1L;
	protected static final Logger LOGGER = Logger.getLogger(ContactAction.class.getName());
	
	@Autowired
	protected ContactDao contactDao;
	
	public ContactDao getContactDao() {
		return contactDao;
	}
	public void setContactDao(ContactDao contactDao) {
		this.contactDao = contactDao;
	}
    
}
