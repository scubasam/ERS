package edu.thangiah.action.driver;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.Action;

import edu.thangiah.action.BaseManagementController;
import edu.thangiah.dao.ContactDao;
import edu.thangiah.dao.ContractorDao;
import edu.thangiah.dao.DriverDao;
import edu.thangiah.dao.MaintenanceOrderDao;
import edu.thangiah.dao.VehicleDao;
import edu.thangiah.entity.Contact;
import edu.thangiah.entity.Contractor;
import edu.thangiah.entity.Driver;
import edu.thangiah.entity.MaintenanceOrder;
import edu.thangiah.entity.Vehicle;
import edu.thangiah.strutsutility.StrutsSelect;
import edu.thangiah.strutsutility.exception.StrutsElementException;

public class ManagementController extends BaseManagementController<Driver>{
	
	/**
	 * 
	 * This class extends our base management controller class and handles
	 * the specific get and sets to the database for all actions pertaining to the 
	 * entity Driver
	 * 
	 * @author Alex McCracken, Kelly Smith
	 *
	 */
	private static final long serialVersionUID = -1194255798482840950L;

	protected static final Logger LOGGER = Logger.getLogger(ManagementController.class.getName());

	@Autowired
	protected VehicleDao vehicleDao;
	@Autowired
	protected DriverDao driverDao;
	@Autowired
	protected ContractorDao contractorDao;
	@Autowired
	protected ContactDao contactDao;
	@Autowired
	protected MaintenanceOrderDao maintenanceOrderDao;

	protected Contact contact;
	protected Driver driver;
	protected Vehicle vehicle;
	protected Contractor contractor;
	protected MaintenanceOrder maintenanceOrder;


	protected StrutsSelect<Vehicle> vehicleSelect;
	protected StrutsSelect<Contact> contactSelect;
	protected StrutsSelect<Contractor> contractorSelect;
	
	protected static final Map<String, String> columnMap;
	static {
		Map<String, String> columns = new LinkedHashMap<String, String>();
		columns.put("contact", "Contact");
		columns.put("vehicles", "Vehicles");
		columns.put("licenseNumber", "License Number");
		columns.put("licenseExpiration", "License Expiration");
		columns.put("licenseClass", "License Class");
		columns.put("contractor", "Contractor");
		columnMap = Collections.unmodifiableMap(columns);
	}
	
	
	// Feeds the column map specific to this class into the auto field generator.
	@Override
	protected Map<String, String> getColumnMap(){
		return columnMap;
	}
	
	@Override
	protected String getActionId() {
		return "driver";
	}
	
	@Override
	public void prepare() throws Exception {
		super.prepare();
		this.initializeEntityList(driverDao);
		gridBody = this.generateGridBody(this.getColumnVisibilitySet(), this.getEntityList(), Driver.class, "driverManagement.action");
		
		if(driverDao == null){
			
			this.addActionError("unable to connect to the database contact a sys admin");
		}
		
		try{
			vehicleSelect = new StrutsSelect<Vehicle>(vehicleDao, "vehicles");
			contactSelect = new StrutsSelect<Contact>(contactDao, "contact");
			contractorSelect = new StrutsSelect<Contractor>(contractorDao, "contractor");
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
        	result = this.initializeEntityById(driverDao, id);
        	
        	if( !result.equals(SUCCESS) ){
    			return result;
    		}
        	
        	if(getDriver() != null && getDriver().getContact() != null && getDriver().getContractor() != null){
	        	vehicleSelect.intializeFromEntity(getDriver().getVehicle());
	        	contactSelect.intializeFromEntity(getDriver().getContact());
	        	contractorSelect.intializeFromEntity(getDriver().getContractor());
        	}
        }
        
        LOGGER.debug("Driver number " + getDrivers().toString());
        return SUCCESS;

    }
	
	protected void initializeSelectedElements() throws StrutsElementException {
		String result;
		result = vehicleSelect.initializeSelected();
		if( !result.equals(SUCCESS) )
			addFieldError("vehicleSelect.selected", result);
		
		result = contactSelect.initializeSelected();
		if( !result.equals(SUCCESS) )
			addFieldError("contactSelect.selected", result);
		
		result = contractorSelect.initializeSelected();
		if( !result.equals(SUCCESS) )
			addFieldError("contractorSelect.selected", result);
	}
	
	public void setDrivers(List<Driver> list) {
		this.setEntityList(list);
	}
	
	public List<Driver> getDrivers() {
		return this.getEntityList();
	}
	
	public Driver getDriver() {
		return this.getEntity();
	}

	public VehicleDao getVehicleDao() {
		return vehicleDao;
	}

	public void setVehicleDao(VehicleDao vehicleDao) {
		this.vehicleDao = vehicleDao;
	}

	public DriverDao getDriverDao() {
		return driverDao;
	}

	public void setDriverDao(DriverDao driverDao) {
		this.driverDao = driverDao;
	}

	public ContractorDao getContractorDao() {
		return contractorDao;
	}

	public void setContractorDao(ContractorDao contractorDao) {
		this.contractorDao = contractorDao;
	}

	public ContactDao getContactDao() {
		return contactDao;
	}

	public void setContactDao(ContactDao contactDao) {
		this.contactDao = contactDao;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Contractor getContractor() {
		return contractor;
	}

	public void setContractor(Contractor contractor) {
		this.contractor = contractor;
	}

	public StrutsSelect<Vehicle> getVehicleSelect() {
		return vehicleSelect;
	}

	public void setVehicleSelect(StrutsSelect<Vehicle> vehicleSelect) {
		this.vehicleSelect = vehicleSelect;
	}

	public StrutsSelect<Contact> getContactSelect() {
		return contactSelect;
	}

	public void setContactSelect(StrutsSelect<Contact> contactSelect) {
		this.contactSelect = contactSelect;
	}

	public StrutsSelect<Contractor> getContractorSelect() {
		return contractorSelect;
	}

	public void setContractorSelect(StrutsSelect<Contractor> contractorSelect) {
		this.contractorSelect = contractorSelect;
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

}
