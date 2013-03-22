package edu.thangiah.action.shipment;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.Preparable;

import edu.thangiah.action.AbstractAction;

import edu.thangiah.dao.ShipmentDao;


public class ShipmentAction extends AbstractAction implements Preparable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5299736822443221305L;
	
	protected static final Logger LOGGER = Logger.getLogger(ShipmentAction.class.getName());
	
	@Autowired
	protected ShipmentDao shipmentDao;

	public ShipmentDao getShipmentDao() {
		return shipmentDao;
	}

	public void setShipmentDao(ShipmentDao shipmentDao) {
		this.shipmentDao = shipmentDao;
	}

}
