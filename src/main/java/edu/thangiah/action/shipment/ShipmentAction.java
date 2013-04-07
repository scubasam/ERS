package edu.thangiah.action.shipment;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.Preparable;

import edu.thangiah.action.ValidationAction;

import edu.thangiah.dao.ShipmentDao;
import edu.thangiah.dao.VehicleTypeDao;
import edu.thangiah.entity.Shipment;


public class ShipmentAction extends ValidationAction  implements Preparable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5299736822443221305L;
	
	protected static final Logger LOGGER = Logger.getLogger(ShipmentAction.class.getName());
	
	@Autowired
	protected ShipmentDao shipmentDao;
	
	@Autowired
	protected VehicleTypeDao vehicleTypeDao;
	
	protected Shipment getShipment(Long id) {
        if (id != null) {
            List<Shipment> shipment = shipmentDao.findById(id);
            if (shipment.size() == 1) {
                return shipment.get(0);
            }
        }
        return null;
    }
	
	public ShipmentDao getShipmentDao() {
		return shipmentDao;
	}

	public void setShipmentDao(ShipmentDao shipmentDao) {
		this.shipmentDao = shipmentDao;
	}

	public VehicleTypeDao getVehicleTypetDao() {
		return vehicleTypeDao;
	}

	public void setVehicleTypetDao(VehicleTypeDao vehicleTypeDao) {
		this.vehicleTypeDao = vehicleTypeDao;
	}



}
