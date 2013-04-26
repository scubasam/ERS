package edu.thangiah.action.shipment;

import org.springframework.beans.factory.annotation.Autowired;
import com.opensymphony.xwork2.Preparable;

import edu.thangiah.dao.ShipmentDao;
import edu.thangiah.dao.VehicleTypeDao;
import edu.thangiah.entity.MaintenanceOrder;
import edu.thangiah.entity.Shipment;
import edu.thangiah.entity.VehicleType;

/**
 *This class extends the management controller and implements preparable. It's primary function
 *is to to handle everything related to adding and Shipment entity 
 * 
 * @author Alex McCracken, Kelly Smith
 */


public class AddAction extends ManagementController implements Preparable{

	private static final long serialVersionUID = -1708978099566079365L;
	private Shipment shipment;
	private VehicleType vehicleType;
	
	@Override
    public String execute()
    {
		/*
		if (shipmentDao == null || shipment == null) 
		{
            this.addActionError(DB_ERROR_MESSAGE);
        }
		
		shipmentDao.add(shipment);
		vehicleTypeDao.add(vehicleType);
		//serviceTechnician.setMaintenanceOrders(maintenanceOrders)
		 */
    	return SUCCESS;
    }
    
    // called automatically
    public void validate(){
    	if(shipment != null && vehicleType != null )
    	{
    		requiredString(shipment.getTimeEntered().toString(), "shipment.timeEntered");
    		requiredInt(shipment.getOrderId(), "shipment.orderID");
    		requiredString(shipment.getVehicleType().toString(), "shipment.vehicleType");
    		requiredString(shipment.getLocation().toString(), "shipment.location");
    		requiredString(shipment.getRoute().toString(), "shipment.route");
    		requiredString(shipment.getAvailableDate().toString(), "shipment.availableDate");
    		requiredString(shipment.getReleaseDate().toString(), "shipment.releaseDate");
    		requiredString(shipment.getEarliestDeliveryDate().toString(), "shipment.earliestDeliveryDate");
    		requiredString(shipment.getLatestDeliveryDate().toString(), "shipment.latestDeliveryDate");
    		requiredInt(shipment.getServiceTime(), "shipment.serviceTime");
    		requiredInt(shipment.getCubicWeight(), "shipment.cubicWeight");
    		requiredString(shipment.getCustomerName(), "shipment.customerName");
    		requiredString(shipment.getDestination().toString(), "shipment.destination");
    		requiredString(shipment.getPooledShipment().toString(), "shipment.pooledDestination");
    		requiredString(shipment.getPooledDestination().toString(), "shipment.pooledDestination");
    	}		
    	else{
    		addActionError("Unknown error.  Please try again.");
    	}

    }
	
}
