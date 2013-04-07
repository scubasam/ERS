package edu.thangiah.action.vehicle;



import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
 
import edu.thangiah.action.AbstractAction;
import edu.thangiah.dao.VehicleDao;
import edu.thangiah.entity.Vehicle;

import com.opensymphony.xwork2.Preparable;
 
public class VehicleAction extends AbstractAction implements Preparable {
 
    /**
	 * 
	 */
	private static final long serialVersionUID = 7870770123435452804L;

	protected static final Logger LOGGER = Logger.getLogger(VehicleAction.class.getName());
 
    @Autowired
	protected VehicleDao vehicleDao;
    
    
    
	protected Vehicle getVehicle(Long id) {
        if (id != null) {
            List<Vehicle> vehicles = vehicleDao.findById(id);
            if (vehicles.size() == 1) {
                return vehicles.get(0);
            }
        }
        return null;
    }
    
    
    
    
    
	public VehicleDao getVehicleDao() {
		return vehicleDao;
	}

	public void setVehicleDao(VehicleDao vehicleDao) {
		this.vehicleDao = vehicleDao;
	}


	
}