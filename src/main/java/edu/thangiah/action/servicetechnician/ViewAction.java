package edu.thangiah.action.servicetechnician;


import com.opensymphony.xwork2.Action;

import edu.thangiah.entity.ServiceTechnician;

public class ViewAction extends ServiceTechnicianAction{
	private static final long serialVersionUID = -6821373379137215233L;
	
	private ServiceTechnician serviceTechnician;
    private Long id;
	
	@Override
	public String execute(){
		if( id == null )
			return Action.ERROR;
		
		ServiceTechnician serviceTechnician = getServiceTechnician(id);
		if( serviceTechnician == null )
			return Action.ERROR;
		
		setServiceTechnician(serviceTechnician);
		
		return Action.SUCCESS;
	}

	public ServiceTechnician getServiceTechnician() {
		return serviceTechnician;
	}

	public void setServiceTechnician(ServiceTechnician serviceTechnician) {
		this.serviceTechnician = serviceTechnician;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
