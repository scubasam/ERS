package edu.thangiah.action;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
 
import edu.thangiah.dao.ContactDao;
import edu.thangiah.entity.Contact;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.Preparable;
 
public class ContractorAction implements Preparable {
 
    private static final Logger LOGGER = Logger.getLogger(ContactAction.class.getName());
 
    private List contractors;
 
    
    //@Autowired
    //private ContactDao contractorDao;
    
	@Override
	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	// ACTION METHODS
	public String listAll() {
        /*if (contactDao == null) {
            return Action.ERROR;
        }
        LOGGER.debug("Get all contacts");
        contacts = contactDao.findAll();
        LOGGER.debug("Contacts number = " + contacts.size());*/
        return Action.SUCCESS;
    }
 
    
}