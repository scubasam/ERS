package edu.thangiah.action.vehicle;


import com.opensymphony.xwork2.Action;

import edu.thangiah.entity.Vehicle;

public class ViewAction extends VehicleAction{
	private static final long serialVersionUID = -6821373379137215233L;
	
	private Vehicle vehicle;
    private Long id;
	
	@Override
	public String execute(){
		if( id == null )
			return Action.ERROR;
		
		Vehicle vehicle = getVehicle(id);
		if(vehicle == null )
			return Action.ERROR;
		
		setVehicle(vehicle);
		
		return Action.SUCCESS;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
