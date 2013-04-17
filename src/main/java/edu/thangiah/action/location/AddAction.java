package edu.thangiah.action.location;
import java.util.List;

import org.hibernate.validator.InvalidStateException;
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
		if(this.getContractorId() == null || this.getContractorId().length() <= 0 )
		{
			addActionError("Contractor is a required field.");
		}
		
		long contId;
		try{
			contId = Integer.parseInt(this.getContractorId());
		}
		catch(NumberFormatException e){
			this.addFieldError("contractorId", "Invalid contractor - please try again.");
			return INPUT;
		}
		catch( Exception e ){
			this.addFieldError("contractorId", "An unknown error has occured. Please try again.");
			return INPUT;
		}
		// at this point contractorId should be a valid long/int.
		
		List<Contractor> fromDbList = contractorDao.findById(contId);
		if( fromDbList == null || fromDbList.size() != 1 ){
			this.addFieldError("contractorId", "No contractor found with that name.  Please refresh the page.");
			return INPUT;
		}
		
		// fromDbList contains exactly one valid contractor which the user has chosen.
		
		Contractor fromDb = fromDbList.get(0);
		
		this.getEntity().setContractor(fromDb);
		try{
			locationDao.add(this.getEntity());
		}
		catch( InvalidStateException e ){
			System.out.println("In unknown error occured.  Please contract your system administrator.");
			return INPUT;
		}
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
    		requiredString(this.getEntity().getCity(), "location.city");
    		requiredString(this.getEntity().getZip(), "location.zip");
    		requiredString(this.getEntity().getRoadName(), "location.roadName");
    		requiredString(this.getEntity().getLatitude(), "location.latitude");
    		requiredString(this.getEntity().getLongitude(), "location.longitude");
    		requiredString(this.getEntity().getLocationType(), "location.locationType");
    		requiredString(this.getContractorId(), "contractorId");
    		
    		
    		requiredString(this.getEntity().getState(), "location.state");
    		
    		if( this.getEntity().getState() != null ){
    			if( this.getEntity().getState().length() > 2 ){
    				this.addFieldError("location.state", "Please use the two letter abbreviation for the State.");
    			}
    		}
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
