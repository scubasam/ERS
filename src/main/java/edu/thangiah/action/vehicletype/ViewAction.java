package edu.thangiah.action.vehicletype;


import com.opensymphony.xwork2.Action;

import edu.thangiah.entity.VehicleType;

public class ViewAction extends VehicleTypeAction{
	private static final long serialVersionUID = -6821373379137215233L;
	
	private VehicleType vehicleType;
    private Long id;
	
	@Override
	public String execute(){
		if( id == null )
			return Action.ERROR;
		
		VehicleType vehicleType = getVehicleType(id);
		if(vehicleType == null )
			return Action.ERROR;
		
		setVehicleType(vehicleType);
		
		return Action.SUCCESS;
	}

	public VehicleType getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
