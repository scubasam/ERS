package edu.thangiah.action.location;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import com.opensymphony.xwork2.Preparable;
import edu.thangiah.action.ValidationAction;
import edu.thangiah.dao.ContractorDao;
import edu.thangiah.dao.LocationDao;
import edu.thangiah.entity.Contractor;
import edu.thangiah.entity.Location;
 
public class LocationAction extends ValidationAction implements Preparable {
 
    /**
	 * 
	 */
	private static final long serialVersionUID = -3748330746652776264L;

	protected static final Logger LOGGER = Logger.getLogger(LocationAction.class.getName());
    
    @Autowired
	protected LocationDao locationDao;
    
    @Autowired
    protected ContractorDao contractorDao;
    
	protected Location getLocation(Long id) {
        if (id != null) {
            List<Location> locations = locationDao.findById(id);
            if (locations.size() == 1) {
                return locations.get(0);
            }
        }
        return null;
    }
	
	protected List<Contractor> getContractors(Location location) {
		return contractorDao.findByLocation(location);
	}
	
    
    
	public LocationDao getLocationDao()
	{
		return locationDao;
	}
	
	public void setLocationDao(LocationDao locationDao)
	{
		this.locationDao = locationDao;
	}
	
	public void setContractorDao(ContractorDao contractorDao)
	{
		this.contractorDao = contractorDao;
	}
	
	public ContractorDao getContractorDao()
	{
		return contractorDao;
	}

 
    
}