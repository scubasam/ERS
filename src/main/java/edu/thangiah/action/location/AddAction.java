package edu.thangiah.action.location;

import org.springframework.beans.factory.annotation.Autowired;
import com.opensymphony.xwork2.Preparable;
import edu.thangiah.dao.ContractorDao;
import edu.thangiah.dao.LocationDao;
import edu.thangiah.dao.VehicleDao;
import edu.thangiah.entity.Contractor;
import edu.thangiah.entity.Location;
import edu.thangiah.entity.Vehicle;

public class AddAction extends ManagementController implements Preparable{

	private static final long serialVersionUID = -1708978099566079365L;
	private Location location;
	private Contractor contractor;
	@SuppressWarnings("unused")
	private Vehicle vehicle;
	
	@Autowired
	protected ContractorDao contractDao;
	
	@Autowired
	protected VehicleDao vehicleDao;

	
	@Override
    public String execute()
    {
		if(this.getEntity().getContractor() == null)
		{
			addActionError("Contractor cannot be null");
		}
		this.getEntity().setContractor(contractor);
		locationDao.add(this.getEntity());
    	return SUCCESS;
    }
    
    // called automatically
    public void validate()
    {	
    	if( location != null && contractor != null )
    	{
    		requiredString(location.getLocationType(), "location.locationType");
    		requiredString(location.getName(), "location.name");
    		requiredString(location.getStreetAddress1(), "location.streetAddress1");
    		requiredString(location.getStreetAddress2(), "location.streetAddress2");
    		requiredString(location.getCity(), "location.city");
    		requiredString(location.getZip(), "location.zip");
    		requiredString(location.getRoadName(), "location.roadName");
    		requiredString(location.getLatitude(), "location.latitude");
    		requiredString(location.getLongitude(), "location.longitude");
    		requiredString(location.getLocationType(), "location.locationType");
    		requiredString(contractor.getContractorName(), "contractor.name");
    	}		
    	else{
    		addActionError("Unknown error.  Please try again.");
    	}

    }

	/**
	 * @return the contact
	 */
	public Location getLocation()
	{
		return location;
	}

	/**
	 * @param contact the contact to set
	 */
	public void setLocation(Location location)
	{
		this.location = location;
	}
	
	/**
	 * @return the contact
	 */
	public Contractor getContractor() {
		return contractor;
	}

	/**
	 * @param contact the contact to set
	 */
	public void setContractor(Contractor contractor) {
		this.contractor = contractor;
	}

	public ContractorDao getContractorDao() {
		return contractorDao;
	}

	public void setContractorDao(ContractorDao contractorDao) {
		this.contractorDao = contractorDao;
	}

	public VehicleDao getVehicleDao() {
		return vehicleDao;
	}

	public void setVehicleDao(VehicleDao vehicleDao) {
		this.vehicleDao = vehicleDao;
	}
	
}
