package edu.thangiah.action.shipment;

import org.springframework.beans.factory.annotation.Autowired;
import com.opensymphony.xwork2.Preparable;

import edu.thangiah.dao.ShipmentDao;
import edu.thangiah.dao.VehicleTypeDao;
import edu.thangiah.entity.MaintenanceOrder;
import edu.thangiah.entity.Shipment;
import edu.thangiah.entity.VehicleType;

public class AddAction extends MaintenanceOrder implements Preparable{

	private static final long serialVersionUID = -1708978099566079365L;
	private Shipment shipment;
	private VehicleType vehicleType;
	
	@Autowired
	protected ShipmentDao shipmentDao;
	
	@Autowired
	protected VehicleTypeDao vehicleTypeDao;
	
	@Override
    public String execute() throws Exception
    {
		if (shipmentDao == null || shipment == null) 
		{
            this.addActionError(DB_ERROR_MESSAGE);
        }
		
		shipmentDao.add(shipment);
		vehicleTypeDao.add(vehicleType);
		//serviceTechnician.setMaintenanceOrders(maintenanceOrders)
    	return SUCCESS;
    }
    
    // called automatically
    public void validate(){
    	if(shipment != null && vehicleType != null )
    	{
    		//placeholder
    	}		
    	else{
    		addActionError("Unknown error.  Please try again.");
    	}

    }

	/**
	 * @return the contact
	 */
	public Shipment getShipment()
	{
		return shipment;
	}

	/**
	 * @param contact the contact to set
	 */
	public void setShipment(Shipment shipment)
	{
		this.shipment = shipment;
	}
	
	public VehicleTypeDao getVehicleTypeDao()
	{
		return vehicleTypeDao;
	}

	public void setVehicleTypeDao(VehicleTypeDao vehicleTypeDao)
	{
		this.vehicleTypeDao = vehicleTypeDao;
	}

	public ShipmentDao getShipmentDao()
	{
		return shipmentDao;
	}

	public void setShipmentDao(ShipmentDao shipmentDao)
	{
		this.shipmentDao = shipmentDao;
	}	
	
	@Override
	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		
	}
	
}