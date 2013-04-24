package edu.thangiah.action.vehicletype;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.Action;

import edu.thangiah.action.BaseManagementController;
import edu.thangiah.dao.VehicleDao;
import edu.thangiah.dao.VehicleTypeDao;
import edu.thangiah.entity.VehicleType;
import edu.thangiah.entity.Vehicle;


public class ManagementController extends BaseManagementController<VehicleType>{
	private static final long serialVersionUID = -1194255798482840950L;

	protected static final Logger LOGGER = Logger.getLogger(ManagementController.class.getName());
	
	@Autowired
	protected VehicleTypeDao vehicleTypeDao;
	
	protected long newVehicleId;
	protected VehicleDao vehicleDao;
	protected Vehicle vehicle;
	
	protected static final Map<String, String> columnMap;
	static {
		Map<String, String> columns = new LinkedHashMap<String, String>();
		columns.put("type", "Type");
		columns.put("subType", "Sub Type");
		columns.put("description", "Description");
		columns.put("make", "Make");
		columns.put("model", "Model");
		columns.put("minimumWeight", "Minimum Weight");
		columns.put("maximumWeight", "Maximum Weight");
		columns.put("minimumCubicWeight", "Minimum Cubic Weight");
		columns.put("maximumCubicWeight", "Maximum Cubic Weight");
		columns.put("capacity", "Capacity");
		columns.put("maximumRange", "Maximum Range");
		columns.put("restrictions", "Restrictions");
		columns.put("height", "Height");
		columns.put("emptyWeight", "Empty Weight");
		columns.put("length", "Length");
		columns.put("vehicles", "Vehicles");
		columnMap = Collections.unmodifiableMap(columns);
	}
	
	// Feeds the column map specific to this class into the auto field generator.
	@Override
	protected Map<String, String> getColumnMap(){
		return columnMap;
	}
	
	@Override
	protected String getActionId() {
		return "vehicleType";
	}
	
	@Override
	public void prepare() throws Exception {
		super.prepare();
		this.initializeEntityList(vehicleTypeDao);
		gridBody = this.generateGridBody(this.getColumnVisibilitySet(), this.getEntityList(), VehicleType.class, "vehicleTypeManagement.action");
	}
	
	public String execute() {
        if (vehicleTypeDao == null) {
            return Action.ERROR;
        }
        
        String result = initialize();
		if( !result.equals(SUCCESS) ){
			return result;
		}
        
        if( mode == Modes.EDIT ){
        	result = this.initializeEntityById(vehicleTypeDao, id);
        }
        
        LOGGER.debug("Vehicle Types number = " + getVehicleTypes().size());
        return Action.SUCCESS;
    }
	
	protected void validateInput() {
		if(getEntity() != null)
    	{
    		requiredString(getEntity().getType(), "vehicleType.type");
    		requiredString(getEntity().getSubType(), "vehicleType.subType");
    		requiredString(getEntity().getMake(), "vehicleType.make");
    		requiredString(getEntity().getModel(), "vehicleType.model");
    		requiredInt(getEntity().getMaximumWeight(), "vehicleType.maximumWeight");
    		requiredInt(getEntity().getMinimumWeight(), "vehicleType.minimumWeight");
    		requiredInt(getEntity().getMaximumCubicWeight(), "vehicleType.maximumCubicWeight");
    		requiredInt(getEntity().getMinimumCubicWeight(), "vehicleType.minimumCubicWeight");
    		requiredInt(getEntity().getMaximumRange(), "vehicleType.maximumRange");
    		requiredString(getEntity().getCapacity(), "vehicleType.capacity");
    		requiredInt(getEntity().getHeight(), "vehicleType.height");
    		requiredInt(getEntity().getEmptyWeight(), "vehicleType.emptyWeight");
    		requiredInt(getEntity().getLength(), "vehicleType.length");
    	}		
    	else{
    		addActionError("Unknown error.  Please try again.");
    	}
	}
	
	public List<VehicleType> getVehicleTypes() {
		return this.getEntityList();
	}

	public void setVehicleTypes(List<VehicleType> entities) {
		this.setEntityList(entities);
	}
	
	public VehicleType getVehicleType(){
		return this.getEntity();
	}
	
	public void setVehicleType(VehicleType entity){
		this.setEntity(entity);
	}

	public VehicleTypeDao getVehicleTypeDao() {
		return vehicleTypeDao;
	}

	public void setVehicleTypeDao(VehicleTypeDao vehicleTypeDao) {
		this.vehicleTypeDao = vehicleTypeDao;
	}

	public VehicleDao getVehicleDao() {
		return vehicleDao;
	}

	public void setVehicleDao(VehicleDao vehicleDao) {
		this.vehicleDao = vehicleDao;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
}
