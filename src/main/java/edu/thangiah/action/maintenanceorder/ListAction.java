package edu.thangiah.action.maintenanceorder;

import java.util.List;

import com.opensymphony.xwork2.Action;

import edu.thangiah.entity.MaintenanceOrder;

public class ListAction extends MaintenanceOrderAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3708117330343201021L;
	private List<MaintenanceOrder> orders;
	
	@Override
	public String execute() {
        if (maintenanceOrderDao == null) {
            return Action.ERROR;
        }
        LOGGER.debug("Get all technicians");
        orders = maintenanceOrderDao.findAll();
        LOGGER.debug("Orders number = " +orders.size());
        return Action.SUCCESS;
    }

	public List<MaintenanceOrder> getOrders() {
		return orders;
	}

	public void setOrders(List<MaintenanceOrder> orders) {
		this.orders = orders;
	}

}
