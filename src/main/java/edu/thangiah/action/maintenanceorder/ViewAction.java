package edu.thangiah.action.maintenanceorder;


import com.opensymphony.xwork2.Action;

import edu.thangiah.entity.MaintenanceOrder;

public class ViewAction extends MaintenanceOrderAction{
	private static final long serialVersionUID = -6821373379137215233L;
	
	private MaintenanceOrder maintenanceOrder;
    private Long id;
	
	@Override
	public String execute(){
		if( id == null )
			return Action.ERROR;
		
		MaintenanceOrder maintO = getMaintenanceOrder(id);
		if( maintO == null )
			return Action.ERROR;
		
		setMainteanceOrder(maintO);
		
		return Action.SUCCESS;
	}

	public MaintenanceOrder getMaintenanceOrder() {
		return maintenanceOrder;
	}

	public void setMainteanceOrder(MaintenanceOrder mainteanceOrder) {
		this.maintenanceOrder = mainteanceOrder;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
