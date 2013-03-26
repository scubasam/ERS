package edu.thangiah.action.vehicletype;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
 
import edu.thangiah.action.AbstractAction;
import edu.thangiah.dao.VehicleTypeDao;

import com.opensymphony.xwork2.Preparable;
 
public class VehicleTypeAction extends AbstractAction implements Preparable {
 
    /**
	 * 
	 */
	private static final long serialVersionUID = 8497017522732143277L;

	protected static final Logger LOGGER = Logger.getLogger(VehicleTypeAction.class.getName());
 
    @Autowired
    protected VehicleTypeDao vehicleTypeDao;
  

	public VehicleTypeDao getVehicleTypeDao() {
		return vehicleTypeDao;
	}

	public void setVehicleTypeDao(VehicleTypeDao vehicleTypeDao) {
		this.vehicleTypeDao = vehicleTypeDao;
	}
	
}