package edu.thangiah.action.shipment;

import java.util.List;

import com.opensymphony.xwork2.Action;

import edu.thangiah.entity.Shipment;

public class ListAction extends ShipmentAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2459531115611803441L;
	
	private List<Shipment> shipments;
	
	@Override
	public String execute() {
        if (shipmentDao == null) {
            return Action.ERROR;
        }
        LOGGER.debug("Get all technicians");
        shipments = shipmentDao.findAll();
        LOGGER.debug("Shipments number = " + shipments.size());
        return Action.SUCCESS;
    }

	public List<Shipment> getShipments() {
		return shipments;
	}

	public void setShipments(List<Shipment> shipments) {
		this.shipments = shipments;
	}
	
	

}
