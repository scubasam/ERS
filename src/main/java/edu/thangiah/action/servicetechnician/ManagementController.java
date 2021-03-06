package edu.thangiah.action.servicetechnician;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.Action;

import edu.thangiah.action.BaseManagementController;
import edu.thangiah.dao.ContactDao;
import edu.thangiah.dao.MaintenanceOrderDao;
import edu.thangiah.dao.ServiceTechnicianDao;
import edu.thangiah.entity.Contact;
import edu.thangiah.entity.MaintenanceOrder;
import edu.thangiah.entity.ServiceTechnician;
import edu.thangiah.strutsutility.StrutsSelect;
import edu.thangiah.strutsutility.exception.StrutsElementException;

public class ManagementController extends BaseManagementController<ServiceTechnician>{
	
	/**
	 * 
	 * This class extends our base management controller class and handles
	 * the specific get and sets to the database for all actions pertaining to the 
	 * entity Service Technician
	 * 
	 * @author Alex McCracken, Kelly Smith
	 *
	 */
	private static final long serialVersionUID = -1194255798482840950L;

	protected static final Logger LOGGER = Logger.getLogger(ManagementController.class.getName());

	@Autowired
	protected ServiceTechnicianDao serviceTechnicianDao;
	@Autowired
	protected ContactDao contactDao;
	@Autowired
	protected MaintenanceOrderDao maintenanceOrderDao;
	
	protected Contact contact;
	protected MaintenanceOrder maintenanceOrder;
	
	
	protected StrutsSelect<Contact> contactSelect;
	protected StrutsSelect<MaintenanceOrder> maintenanceOrderSelect;
	
	/**
	 * Must be specified by all management controllers as it is used for generating the grid header and body code.
	 */
	protected static final Map<String, String> columnMap;
	static {
		Map<String, String> columns = new LinkedHashMap<String, String>();
		columns.put("contact", "Contact");
		columns.put("skillGrade", "Skill Grade");
		columns.put("maintenanceOrders", "Maintenance Orders");
		columnMap = Collections.unmodifiableMap(columns);
	}
	
	
	// Feeds the column map specific to this class into the auto field generator.
	/**
	 * Must be specified by all management controllers as it is used for generating the grid header and body code.
	 */
	@Override
	protected Map<String, String> getColumnMap(){
		return columnMap;
	}
	
	/**
	 * Must be specified by all management controllers as it is used for generating the grid header and body code.
	 */
	@Override
	protected String getActionId() {
		return "serviceTechnician";
	}
	
	@Override
	public void prepare() throws Exception {
		super.prepare();
		this.initializeEntityList(serviceTechnicianDao);
		gridBody = this.generateGridBody(this.getColumnVisibilitySet(), this.getEntityList(), ServiceTechnician.class, "serviceTechnicianManagement.action");
		
		if ( serviceTechnicianDao == null ) {
        	this.addActionError("Unable to connect to the database.  Please contact your system administrator.");
        }
		
		try{
			contactSelect = new StrutsSelect<Contact>(contactDao, "contact");
			maintenanceOrderSelect = new StrutsSelect<MaintenanceOrder>(maintenanceOrderDao, "mainteanceOrder");
		}
		catch(StrutsElementException e){
			this.addActionError("Unable to connect to the database.  Please contact your system administrator.");
		}
	}
	public String execute() {
	       if ( this.hasActionErrors() ) {
	            return Action.ERROR;
	        }
			
	        initialize();
	        
	        String result;
	        if( mode == Modes.EDIT ){
	        	result = this.initializeEntityById(serviceTechnicianDao, id);
	        	
	        	if( !result.equals(SUCCESS) ){
	    			return result;
	    		}
	        	
	        	if( getServiceTechnician() != null && getServiceTechnician().getContact() != null && getServiceTechnician().getMaintenanceOrders() != null){
		        	contactSelect.intializeFromEntity(getServiceTechnician().getContact());
		        	maintenanceOrderSelect.intializeFromEntity(getServiceTechnician().getMaintenanceOrder());
	        	}
	        }
	        
	        LOGGER.debug("Service Technicians number = " + getServiceTechnicians().size());
	        return SUCCESS;
	    }	
	
	
	protected void initializeSelectedElements() throws StrutsElementException {
		String result;
		result = contactSelect.initializeSelected();
		if( !result.equals(SUCCESS) )
			addFieldError("contactSelect.selected", result);
		
		result = maintenanceOrderSelect.initializeSelected();
		if( !result.equals(SUCCESS) )
			addFieldError("maintenanceOrderSelect.selected", result);
	}
	
	public List<ServiceTechnician> getServiceTechnicians() {
		return this.getEntityList();
	}
	
	public ServiceTechnician getServiceTechnician(){
		return this.getEntity();
	}
	
	public ServiceTechnicianDao getServiceTechnicianDao() {
		return serviceTechnicianDao;
	}

	public void setServiceTechnicianDao(ServiceTechnicianDao serviceTechnicianDao) {
		this.serviceTechnicianDao = serviceTechnicianDao;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public ContactDao getContactDao() {
		return contactDao;
	}

	public void setContactDao(ContactDao contactDao) {
		this.contactDao = contactDao;
	}

	public MaintenanceOrderDao getMaintenanceOrderDao() {
		return maintenanceOrderDao;
	}

	public void setMaintenanceOrderDao(MaintenanceOrderDao maintenanceOrderDao) {
		this.maintenanceOrderDao = maintenanceOrderDao;
	}

	public MaintenanceOrder getMaintenanceOrder() {
		return maintenanceOrder;
	}

	public void setMaintenanceOrder(MaintenanceOrder maintenanceOrder) {
		this.maintenanceOrder = maintenanceOrder;
	}

	public StrutsSelect<Contact> getContactSelect() {
		return contactSelect;
	}

	public void setContactSelect(StrutsSelect<Contact> contactSelect) {
		this.contactSelect = contactSelect;
	}

	public StrutsSelect<MaintenanceOrder> getMaintenanceOrderSelect() {
		return maintenanceOrderSelect;
	}

	public void setMaintenanceOrderSelect(
			StrutsSelect<MaintenanceOrder> maintenanceOrderSelect) {
		this.maintenanceOrderSelect = maintenanceOrderSelect;
	}

	
	

	
}
