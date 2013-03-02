package edu.thangiah.action;

import java.util.List;

import javax.tools.JavaFileManager.Location;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
 
import edu.thangiah.dao.ContractorDao;
import edu.thangiah.entity.Contact;
import edu.thangiah.entity.Contractor;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.Preparable;
 
public class ContractorAction implements Preparable {
 
    private static final Logger LOGGER = Logger.getLogger(ContactAction.class.getName());
 
    private List<Contractor> contractors;
    
    private String contractorName = null;
    private Contact contact = null;
    
    @Autowired
    private ContractorDao contractorDao;
    
	@Override
	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	// ACTION METHODS
	public String listAll() {
        if (contractorDao == null) {
            return Action.ERROR;
        }
        LOGGER.debug("Get all contractors");
        contractors = contractorDao.findAll();
        LOGGER.debug("Contractors number = " + contractors.size());
        for( Contractor contractor : contractors ){
        	String log = "Contractor(" + contractor.getContractorName() + ") Locations: ";
        	for( edu.thangiah.entity.Location loc : contractor.getLocations() ){
        		log += loc.getName();
        	}
        	LOGGER.debug(log);
        }
        return Action.SUCCESS;
    }

	public List<Contractor> getContractors() {
		return contractors;
	}

	public void setContractors(List<Contractor> contractors) {
		this.contractors = contractors;
	}

	public String getContractorName() {
		return contractorName;
	}

	public void setContractorName(String contractorName) {
		this.contractorName = contractorName;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public ContractorDao getContractorDao() {
		return contractorDao;
	}

	public void setContractorDao(ContractorDao contractorDao) {
		this.contractorDao = contractorDao;
	}
 
    
}