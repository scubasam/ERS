package edu.thangiah.action.servicetechnician;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.Preparable;

import edu.thangiah.action.AbstractAction;
import edu.thangiah.action.location.LocationAction;
import edu.thangiah.dao.ServiceTechnicianDao;

public class ServiceTechnicianAction extends AbstractAction implements Preparable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4008513602409497443L;
	
	protected static final Logger LOGGER = Logger.getLogger(LocationAction.class.getName());
	
	@Autowired
	protected ServiceTechnicianDao serviceTechnicianDao;

	public ServiceTechnicianDao getServiceTechnicianDao() {
		return serviceTechnicianDao;
	}

	public void setServiceTechnicianDao(ServiceTechnicianDao serviceTechnicianDao) {
		this.serviceTechnicianDao = serviceTechnicianDao;
	}
	
}
