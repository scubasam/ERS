package edu.thangiah.action.location;

import org.springframework.beans.factory.annotation.Autowired;
import com.opensymphony.xwork2.Preparable;
import edu.thangiah.dao.ContractorDao;
import edu.thangiah.dao.VehicleDao;
import edu.thangiah.entity.Contractor;
import edu.thangiah.entity.Location;
import edu.thangiah.entity.Vehicle;

public class AddAction extends ManagementController implements Preparable{

	private static final long serialVersionUID = -1708978099566079365L;
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
			addActionError("Contractor cannot be null.");
		}
		this.getEntity().setContractor(contractor);
		locationDao.add(this.getEntity());
    	return SUCCESS;
    }
    
    // called automatically
    public void validate()
    {	
    	if( this.getEntity() != null && contractorId != null )
    	{
    		requiredString(this.getEntity().getLocationType(), "location.locationType");
    		requiredString(this.getEntity().getName(), "location.name");
    		requiredString(this.getEntity().getStreetAddress1(), "location.streetAddress1");
    		requiredString(this.getEntity().getStreetAddress2(), "location.streetAddress2");
    		requiredString(this.getEntity().getCity(), "location.city");
    		requiredString(this.getEntity().getZip(), "location.zip");
    		requiredString(this.getEntity().getRoadName(), "location.roadName");
    		requiredString(this.getEntity().getLatitude(), "location.latitude");
    		requiredString(this.getEntity().getLongitude(), "location.longitude");
    		requiredString(this.getEntity().getLocationType(), "location.locationType");
    		requiredString(this.getContractorId(), "contractorId");
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
		return this.getEntity();
	}

	/**
	 * @param contact the contact to set
	 */
	public void setLocation(Location location)
	{
		this.setEntity(location);
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
