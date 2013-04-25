package edu.thangiah.action.location;

import java.util.List;

import org.hibernate.validator.InvalidStateException;
import com.opensymphony.xwork2.Preparable;
import edu.thangiah.entity.Contractor;
import edu.thangiah.entity.Location;
import edu.thangiah.entity.Vehicle;

/**
 *This class extends the management controller and implements preparable. It's primary function
 *is to to handle everything related to adding and Location entity 
 * 
 * @author Alex McCracken, Kelly Smith
 */


public class AddAction extends ManagementController implements Preparable{

	private static final long serialVersionUID = -1708978099566079365L;
	private Contractor contractor;
	@SuppressWarnings("unused")
	private Vehicle vehicle;

	
	@Override
    public String execute()
    {
		if(this.getContractorId() == null || this.getContractorId().length() <= 0 )
		{
			addActionError("Contractor is a required field.");
		}
		
		String result = parseContractorId();
		if( !result.equals(SUCCESS) )
			return result;
		// at this point contractorId should be a valid long/int.
		
		List<Contractor> fromDbList = contractorDao.findById(newContractorId);
		if( fromDbList == null || fromDbList.size() != 1 ){
			this.addFieldError("contractorId", "No contractor found with that name.  Please refresh the page.");
			return INPUT;
		}
		
		// fromDbList contains exactly one valid contractor which the user has chosen.
		
		Contractor fromDb = fromDbList.get(0);
		
		this.getEntity().setContractor(fromDb);
		//this.getEntity().setVehicles(new HashSet<Vehicle>());
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
    	runLocationValidation();
    }

	public Location getLocation()
	{
		return this.getEntity();
	}

	public void setLocation(Location location)
	{
		this.setEntity(location);
	}
	

	public Contractor getContractor(Contractor contractor)
	{
		return this.contractor;
	}
	
	public void setContractor(Contractor contractor) {
		this.contractor = contractor;
	}
	
}
