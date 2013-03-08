package edu.thangiah.action;
import java.util.HashSet;
import java.util.List;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
 
import edu.thangiah.dao.ContractorDao;
import edu.thangiah.dao.LocationDao;
import edu.thangiah.entity.Contact;
import edu.thangiah.entity.Contractor;
import edu.thangiah.entity.Location;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.Preparable;
 
public class ContractorAction implements Preparable {
 
    private static final Logger LOGGER = Logger.getLogger(ContactAction.class.getName());
 
    private List<Contractor> contractors;
    private Contractor contractor;
    
    private String contractorName = null;
    private Contact contact = null;
    
    private Long id;
    
    @Autowired
    private ContractorDao contractorDao;
    
    @Autowired
    private LocationDao locationDao;
    
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
	
	public String view(){
		if( id == null )
			return Action.ERROR;
		
		Contractor cont = getContractor(id);
		if( cont == null )
			return Action.ERROR;
		
		List<Location> locs = getLocations(cont);
		cont.setLocations(new HashSet<Location>(locs));
		
		contractor = cont;
		
		return Action.SUCCESS;
	}
	
	// END ACTION METHOD
	
	// UTILITY METHODS
	private Contractor getContractor(Long id) {
        LOGGER.debug("Get contractor with id = " + id);
        if (id != null) {
            List<Contractor> contractors = contractorDao.findById(id);
            LOGGER.debug("Number of contractors with id = " + id + ": " + contractors.size());
            if (contractors.size() == 1) {
                return contractors.get(0);
            }
        }
        return null;
    }
	
	private List<Location> getLocations(Contractor contractor){	
		return locationDao.findByContractor(contractor);
	}
	// END UTILITY METHODS
	
	
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

	public LocationDao getLocationDao() {
		return locationDao;
	}

	public void setLocationDao(LocationDao locationDao) {
		this.locationDao = locationDao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Contractor getContractor() {
		return contractor;
	}

	public void setContractor(Contractor contractor) {
		this.contractor = contractor;
	}
 
    
}