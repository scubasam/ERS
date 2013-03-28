package edu.thangiah.action.driver;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import com.opensymphony.xwork2.Preparable;
import edu.thangiah.action.ValidationAction;
import edu.thangiah.action.contractor.ContractorAction;
import edu.thangiah.dao.DriverDao;
import edu.thangiah.dao.VehicleDao;
import edu.thangiah.entity.Driver;
import edu.thangiah.entity.Vehicle;

public class DriverAction extends ValidationAction implements Preparable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1152096171071390380L;
	protected static final Logger LOGGER = Logger.getLogger(ContractorAction.class.getName());


	@Autowired
	protected DriverDao driverDao;
	
    @Autowired
    protected VehicleDao vehicleDao;

	protected Driver getDriver(Long id) {
        if (id != null) {
            List<Driver> drivers = driverDao.findById(id);
            if (drivers.size() == 1) {
                return drivers.get(0);
            }
        }
        return null;
    }
	
	protected List<Vehicle> getVehicles(Driver driver) {
		return vehicleDao.findByDriver(driver);
	}
	
	public DriverDao getDriverDao() {
		return driverDao;
	}

	public void setDriverDao(DriverDao driverDao) {
		this.driverDao = driverDao;
	}
	
	public VehicleDao getVehicleDao() {
		return vehicleDao;
	}

	public void setVehicleDao(VehicleDao vehicleDao) {
		this.vehicleDao = vehicleDao;
	}
}
