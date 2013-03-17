package edu.thangiah.contact;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
 
import edu.thangiah.contact.entity.Contact;
 
@Transactional
public class ContactBoImpl implements ContactBo {
 
    private static final Logger LOGGER = Logger.getLogger(ContactBoImpl.class.getName());
 
    @Autowired
    private ContactDao contactDao;
 
    public ContactDao getContactDao() {
        return contactDao;
    }
 
    public void setContactDao(ContactDao contactDao) {
        this.contactDao = contactDao;
    }
 
    public void add(Contact contact) {
        if (contact == null) {
            return;
        }
        LOGGER.debug("Adding the following contact: " + contact.getFirstName() + " " + contact.getLastName());
        contactDao.add(contact);
    }
 
    public void delete(Contact contact) {
        if (contact == null) {
            return;
        }
        LOGGER.debug("Deleteting the following contact: " + contact.getId() + ", " + contact.getFirstName() + " " + contact.getLastName());
        contactDao.delete(contact);
    }
 
    public List<Contact> findAll() {
        LOGGER.debug("Getting all contacts");
        return contactDao.findAll();
    }
 
    public List<Contact> findById(int id) {
        return contactDao.findById(id);
    }
 
    public List<Contact> findByUsername(String contactName) {
        return contactDao.findByUsername(contactName);
    }
 
    public void update(Contact contact) {
        if (contact == null) {
            return;
        }
        contactDao.update(contact);
    }
}