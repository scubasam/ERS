package edu.thangiah.action.shipment;


import com.opensymphony.xwork2.Action;

import edu.thangiah.entity.Shipment;

public class ViewAction extends ShipmentAction{
	private static final long serialVersionUID = -6821373379137215233L;
	
	private Shipment shipment;
    private Long id;
	
	@Override
	public String execute(){
		if( id == null )
			return Action.ERROR;
		
		Shipment shipment = getShipment(id);
		if(shipment == null )
			return Action.ERROR;
		
		setShipment(shipment);
		
		return Action.SUCCESS;
	}

	public Shipment getShipment() {
		return shipment;
	}

	public void setShipment(Shipment shipment) {
		this.shipment = shipment;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
