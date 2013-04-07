package edu.thangiah.action.servicetechnician;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.Preparable;

import edu.thangiah.action.ValidationAction;
import edu.thangiah.dao.ContactDao;
import edu.thangiah.dao.ServiceTechnicianDao;
import edu.thangiah.entity.ServiceTechnician;

public class ServiceTechnicianAction extends ValidationAction implements Preparable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4008513602409497443L;
	
	protected static final Logger LOGGER = Logger.getLogger(ServiceTechnicianAction.class.getName());
	
	@Autowired
	protected ServiceTechnicianDao serviceTechnicianDao;
	
	@Autowired
	protected ContactDao contactDao;
	
	protected ServiceTechnician getServiceTechnician(Long id) {
        if (id != null) {
            List<ServiceTechnician> serviceTechnician = serviceTechnicianDao.findById(id);
            if (serviceTechnician.size() == 1) {
                return serviceTechnician.get(0);
            }
        }
        return null;
    }
	
	public void setContactDao(ContactDao contactDao)
	{
		this.contactDao = contactDao;
	}
	
	public ContactDao getContactDao()
	{
		return contactDao;
	}

	public ServiceTechnicianDao getServiceTechnicianDao() {
		return serviceTechnicianDao;
	}

	public void setServiceTechnicianDao(ServiceTechnicianDao serviceTechnicianDao) {
		this.serviceTechnicianDao = serviceTechnicianDao;
	}
	
}
