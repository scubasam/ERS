package edu.thangiah.action.vehicletype;

import org.springframework.beans.factory.annotation.Autowired;
import com.opensymphony.xwork2.Preparable;

import edu.thangiah.dao.VehicleTypeDao;
import edu.thangiah.entity.MaintenanceOrder;
import edu.thangiah.entity.VehicleType;

public class AddAction extends MaintenanceOrder implements Preparable{

	private static final long serialVersionUID = -1708978099566079365L;
	private VehicleType vehicleType;
	
	@Autowired
	protected VehicleTypeDao vehicleTypeDao;
	
	@Override
    public String execute() throws Exception
    {
		if (vehicleTypeDao == null || vehicleType == null) 
		{
            this.addActionError(DB_ERROR_MESSAGE);
        }
		
		vehicleTypeDao.add(vehicleType);
    	return SUCCESS;
    }
    
    // called automatically
    public void validate(){
    	if(vehicleType != null)
    	{
    		//placeholder
    	}		
    	else{
    		addActionError("Unknown error.  Please try again.");
    	}

    }
    
	public VehicleTypeDao getVehicleTypeDao()
	{
		return vehicleTypeDao;
	}

	public void setVehicleTypeDao(VehicleTypeDao vehicleTypeDao)
	{
		this.vehicleTypeDao = vehicleTypeDao;
	}

	@Override
	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		
	}
	
}
