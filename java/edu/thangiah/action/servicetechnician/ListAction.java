package edu.thangiah.action.servicetechnician;

import java.util.List;

import com.opensymphony.xwork2.Action;

import edu.thangiah.entity.ServiceTechnician;

public class ListAction extends ServiceTechnicianAction {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5848991107313099237L;
	private List<ServiceTechnician> technicians;
	
	@Override
	public String execute() {
        if (serviceTechnicianDao == null) {
            return Action.ERROR;
        }
        LOGGER.debug("Get all technicians");
        technicians = serviceTechnicianDao.findAll();
        LOGGER.debug("Technicians number = " +technicians.size());
        return Action.SUCCESS;
    }

	public List<ServiceTechnician> getTechnicians() {
		return technicians;
	}

	public void setTechnicians(List<ServiceTechnician> technicians) {
		this.technicians = technicians;
	}
	
}
