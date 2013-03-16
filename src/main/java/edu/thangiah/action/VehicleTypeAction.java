package edu.thangiah.action;

import java.util.List;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
 
import edu.thangiah.dao.VehicleTypeDao;
import edu.thangiah.entity.VehicleType;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.Preparable;
 
public class VehicleTypeAction implements Preparable {
 
    private static final Logger LOGGER = Logger.getLogger(VehicleTypeAction.class.getName());
 
    private List<VehicleType> types;
    private VehicleType vehicleType;
    
    protected Long id = null;
    private String type = null;
    private String subType = null;
    private String description = null;
    private String make = null;
    private String model = null;
    private Integer minimumWeight = null;
    private Integer maximumWeight = null;
    private Integer maximumRange = null;
    private String capacity = null;
    private String restrictions = null;
    private Integer height = null;
    private Integer emptyWeight = null;
    private Integer length = null;
    
    @Autowired
    private VehicleTypeDao vehicleTypeDao;
    
	@Override
	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	// ACTION METHODS
	public String listAll() {
        if (vehicleTypeDao == null) {
            return Action.ERROR;
        }
        LOGGER.debug("Get all vehicle types");
        types = vehicleTypeDao.findAll();
        LOGGER.debug("Contractors number = " + types.size());
        return Action.SUCCESS;
    }
	
	
	// END ACTION METHOD
	
	// UTILITY METHODS
	
	// END UTILITY METHODS

	public List<VehicleType> getTypes() {
		return types;
	}

	public void setTypes(List<VehicleType> types) {
		this.types = types;
	}

	public VehicleType getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSubType() {
		return subType;
	}

	public void setSubType(String subType) {
		this.subType = subType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Integer getMinimumWeight() {
		return minimumWeight;
	}

	public void setMinimumWeight(Integer minimumWeight) {
		this.minimumWeight = minimumWeight;
	}

	public Integer getMaximumWeight() {
		return maximumWeight;
	}

	public void setMaximumWeight(Integer maximumWeight) {
		this.maximumWeight = maximumWeight;
	}

	public Integer getMaximumRange() {
		return maximumRange;
	}

	public void setMaximumRange(Integer maximumRange) {
		this.maximumRange = maximumRange;
	}

	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	public String getRestrictions() {
		return restrictions;
	}

	public void setRestrictions(String restrictions) {
		this.restrictions = restrictions;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public Integer getEmptyWeight() {
		return emptyWeight;
	}

	public void setEmptyWeight(Integer emptyWeight) {
		this.emptyWeight = emptyWeight;
	}

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public VehicleTypeDao getVehicleTypeDao() {
		return vehicleTypeDao;
	}

	public void setVehicleTypeDao(VehicleTypeDao vehicleTypeDao) {
		this.vehicleTypeDao = vehicleTypeDao;
	}
	
}