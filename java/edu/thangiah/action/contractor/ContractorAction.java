package edu.thangiah.action.contractor;
import java.util.List;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
 
import edu.thangiah.action.ValidationAction;
import edu.thangiah.dao.ContractorDao;
import edu.thangiah.dao.LocationDao;
import edu.thangiah.dao.VehicleDao;
import edu.thangiah.entity.Contractor;
import edu.thangiah.entity.Location;

import com.opensymphony.xwork2.Preparable;
 
public class ContractorAction extends ValidationAction implements Preparable {
	private static final long serialVersionUID = -8291864018797596756L;

	protected static final Logger LOGGER = Logger.getLogger(ContractorAction.class.getName());
    
    @Autowired
	protected ContractorDao contractorDao;
    
    @Autowired
    protected LocationDao locationDao;
    
    @Autowired
    protected VehicleDao vehicleDao;
	
	// UTILITY METHODS
	protected Contractor getContractor(Long id) {
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
	
	protected List<Location> getLocations(Contractor contractor){	
		return locationDao.findByContractor(contractor);
	}
	// END UTILITY METHODS
	

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

	public VehicleDao getVehicleDao() {
		return vehicleDao;
	}

	public void setVehicleDao(VehicleDao vehicleDao) {
		this.vehicleDao = vehicleDao;
	}
}