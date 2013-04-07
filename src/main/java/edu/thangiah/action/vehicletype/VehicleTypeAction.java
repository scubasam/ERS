package edu.thangiah.action.vehicletype;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
 
import edu.thangiah.action.ValidationAction;
import edu.thangiah.dao.VehicleTypeDao;
import edu.thangiah.entity.VehicleType;

import com.opensymphony.xwork2.Preparable;
 
public class VehicleTypeAction extends ValidationAction implements Preparable {
 
    /**
	 * 
	 */
	private static final long serialVersionUID = 8497017522732143277L;

	protected static final Logger LOGGER = Logger.getLogger(VehicleTypeAction.class.getName());
 
    @Autowired
    protected VehicleTypeDao vehicleTypeDao;
  

	protected VehicleType getVehicleType(Long id) {
        if (id != null) {
            List<VehicleType> vehicleType = vehicleTypeDao.findById(id);
            if (vehicleType.size() == 1) {
                return vehicleType.get(0);
            }
        }
        return null;
    }

    
    
    
    
	public VehicleTypeDao getVehicleTypeDao() {
		return vehicleTypeDao;
	}

	public void setVehicleTypeDao(VehicleTypeDao vehicleTypeDao) {
		this.vehicleTypeDao = vehicleTypeDao;
	}
	
}