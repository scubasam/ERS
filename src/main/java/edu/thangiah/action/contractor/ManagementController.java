package edu.thangiah.action.contractor;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.Action;

import edu.thangiah.action.BaseManagementController;
import edu.thangiah.dao.ContractorDao;
import edu.thangiah.entity.Contractor;


public class ManagementController extends BaseManagementController<Contractor>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1194255798482840950L;

	protected static final Logger LOGGER = Logger.getLogger(ManagementController.class.getName());
	
	@Autowired
	protected ContractorDao contractorDao;
	
	public String execute() {
        if (contractorDao == null) {
            return Action.ERROR;
        }
        
        String result = initialize();
		if( !result.equals(SUCCESS) ){
			return result;
		}
        
        LOGGER.debug("Get all contacts");
        result = initializeEntityList(contractorDao);
        if( !result.equals(SUCCESS) ){
			return result;
		}
        LOGGER.debug("Contacts number = " + getContractors().size());
        return Action.SUCCESS;
    }
	
	public List<Contractor> getContractors() {
		return this.getEntityList();
	}

	public void setContractors(List<Contractor> contacts) {
		this.setEntityList(contacts);
	}
	
	public ContractorDao getContractorDao() {
		return contractorDao;
	}
	public void setContractorDao(ContractorDao contractorDao) {
		this.contractorDao = contractorDao;
	}
}
