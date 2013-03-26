package edu.thangiah.action.vehicletype;

import java.util.List;

import com.opensymphony.xwork2.Action;

import edu.thangiah.entity.VehicleType;

public class ListAction extends VehicleTypeAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5228253922113948196L;
	
	private List<VehicleType> types;
	
	@Override
	public String execute() {
        if (vehicleTypeDao == null) {
            return Action.ERROR;
        }
        LOGGER.debug("Get all vehicle types");
        types = vehicleTypeDao.findAll();
        LOGGER.debug("Vehicle Types number = " + types.size());
        return Action.SUCCESS;
    }

	public List<VehicleType> getTypes() {
		return types;
	}

	public void setTypes(List<VehicleType> types) {
		this.types = types;
	}

}
