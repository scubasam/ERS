package edu.thangiah.entity;

import edu.thangiah.decorator.HtmlDecorator;
import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.NotEmpty;
import org.hibernate.validator.NotNull;
import org.hibernate.validator.Valid;


@Entity
@Table(name="vehicle_types")
public class VehicleType extends AbstractEntity implements Serializable, EntityInterface {
    private static final long serialVersionUID = 1L;
    protected Long id = null;
    private String type = null;
    private String subType = null;
    private String description = null;
    private String make = null;
    private String model = null;
    private Integer minimumWeight = null;
    private Integer maximumWeight = null;
    private Integer minimumCubicWeight = null;
    private Integer maximumCubicWeight = null;
    private Integer maximumRange = null;
    private String capacity = null;
    private String restrictions = null;
    private Integer height = null;
    private Integer emptyWeight = null;
    private Integer length = null;
    private Set<Vehicle> vehicles = null;

    public VehicleType() {
        super();
    }

    public VehicleType(Long id) {
        this.id = id;
    }

    /*
    public VehicleType(Long id, String type, String subType, String description, String make, String model, Integer minimumWeight,
            Integer maximumWeight, Integer maximumRange, String capacity, String restrictions, Integer height, Integer emptyWeight, Integer length,
            Set<Vehicle> vehicles) {
    	this.id = id;
        this.type = type;
        this.subType = subType;
        this.description = description;
        this.make = make;
        this.model = model;
        this.minimumWeight = minimumWeight;
        this.maximumWeight = maximumWeight;
        this.maximumRange = maximumRange;
        this.capacity = capacity;
        this.restrictions = restrictions;
        this.height = height;
        this.emptyWeight = emptyWeight;
        this.length = length;
        this.vehicles = vehicles;
    }*/

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name="type")
    @NotEmpty
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Column(name="sub_type")
    @NotEmpty
    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }

    @Column(name="description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name="make")
    @NotEmpty
    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    @Column(name="model")
    @NotEmpty
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Column(name="minimum_weight")
    @NotNull
    public Integer getMinimumWeight() {
        return minimumWeight;
    }

    public void setMinimumWeight(Integer minimumWeight) {
        this.minimumWeight = minimumWeight;
    }

    @Column(name="maximum_weight")
    @NotNull
    public Integer getMaximumWeight() {
        return maximumWeight;
    }

    public void setMaximumWeight(Integer maximumWeight) {
        this.maximumWeight = maximumWeight;
    }

    @Column(name="maximum_range")
    @NotNull
    public Integer getMaximumRange() {
        return maximumRange;
    }

    public void setMaximumRange(Integer maximumRange) {
        this.maximumRange = maximumRange;
    }

    @Column(name="capacity")
    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    @Column(name="restrictions")
    public String getRestrictions() {
        return restrictions;
    }

    public void setRestrictions(String restrictions) {
        this.restrictions = restrictions;
    }

    @Column(name="height")
    @NotNull
    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    @Column(name="empty_weight")
    @NotNull
    public Integer getEmptyWeight() {
        return emptyWeight;
    }

    public void setEmptyWeight(Integer emptyWeight) {
        this.emptyWeight = emptyWeight;
    }

    @Column(name="length")
    @NotNull
    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    @OneToMany(mappedBy="vehicleType")
    @Valid
    public Set<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(Set<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }
    
	public String getViewLink() {
		return HtmlDecorator.generateEntityLink("viewVehicleType", this.id, this.make + this.model);
	}
	
	public String toString(){
		return this.make + " " + this.model;
	}

	public void merge(VehicleType with) {
		if( with != null ){
	        this.type = with.type;
	        this.subType = with.subType;
	        this.description = with.description;
	        this.make = with.make;
	        this.model = with.model;
	        this.minimumWeight = with.minimumWeight;
	        this.maximumWeight = with.maximumWeight;
	        this.minimumCubicWeight = with.minimumCubicWeight;
	        this.maximumCubicWeight = with.maximumCubicWeight;
	        this.maximumRange = with.maximumRange;
	        this.capacity = with.capacity;
	        this.restrictions = with.restrictions;
	        this.height = with.height;
	        this.emptyWeight = with.emptyWeight;
	        this.length = with.length;
	        this.vehicles = with.vehicles;
	        
		}
	}

	public Integer getMinimumCubicWeight() {
		return minimumCubicWeight;
	}

	public void setMinimumCubicWeight(Integer minimumCubicWeight) {
		this.minimumCubicWeight = minimumCubicWeight;
	}

	public Integer getMaximumCubicWeight() {
		return maximumCubicWeight;
	}

	public void setMaximumCubicWeight(Integer maximumCubicWeight) {
		this.maximumCubicWeight = maximumCubicWeight;
	}


}
