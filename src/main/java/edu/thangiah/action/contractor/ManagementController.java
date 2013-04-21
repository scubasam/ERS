package edu.thangiah.action.contractor;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.Action;

import edu.thangiah.action.BaseManagementController;
import edu.thangiah.dao.ContractorDao;
import edu.thangiah.entity.Contact;
import edu.thangiah.entity.Contractor;


public class ManagementController extends BaseManagementController<Contractor>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1194255798482840950L;

	protected static final Logger LOGGER = Logger.getLogger(ManagementController.class.getName());
	
	@Autowired
	protected ContractorDao contractorDao;
	
	protected Contact contact;
	
	protected static final Map<String, String> columnMap;
	static {
		Map<String, String> columns = new LinkedHashMap<String, String>();
		columns.put("contractorName", "Contractor");
		columns.put("contact", "Contact");
		columns.put("locations", "Locations");
		columnMap = Collections.unmodifiableMap(columns);
	}
	
	// Feeds the column map specific to this class into the auto field generator.
	@Override
	protected Map<String, String> getColumnMap(){
		return columnMap;
	}
	
	@Override
	protected String getActionId() {
		return "contractor";
	}
	
	@Override
	public void prepare() throws Exception {
		super.prepare();
		this.initializeEntityList(contractorDao);
		gridBody = this.generateGridBody(this.getColumnVisibilitySet(), this.getEntityList(), Contractor.class, "contractorManagement.action");
	}
	
	public String execute() {
        if (contractorDao == null) {
            return Action.ERROR;
        }
        
        String result = initialize();
		if( !result.equals(SUCCESS) ){
			return result;
		}
        
        if( mode == Modes.EDIT ){
        	result = this.initializeEntityById(contractorDao, id);
        	if( this.getEntity() != null ){
    			contact = this.getEntity().getContact();
    		}
        	if( !result.equals(SUCCESS) ){
    			return result;
    		}
        }
        
        LOGGER.debug("Contractors number = " + getContractors().size());
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
	
	/**
	 * @return the contact
	 */
	public Contact getContact() {
		return contact;
	}

	/**
	 * @param contact the contact to set
	 */
	public void setContact(Contact contact) {
		this.contact = contact;
	}
	
	public Contractor getContractor(){
		return this.getEntity();
	}
	
	public void setContractor(Contractor contractor){
		this.setEntity(contractor);
	}
}
