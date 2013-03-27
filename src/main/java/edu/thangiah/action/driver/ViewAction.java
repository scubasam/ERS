package edu.thangiah.action.driver;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.opensymphony.xwork2.Action;

import edu.thangiah.entity.Contractor;
import edu.thangiah.entity.Driver;
import edu.thangiah.entity.Location;
import edu.thangiah.entity.Vehicle;

public class ViewAction extends DriverAction{
	private static final long serialVersionUID = -6821373379137215233L;
	
	private Driver driver;
    private Long id;
    
	
	@Override
	public String execute(){
		if( id == null )
			return Action.ERROR;
		
		Driver driver = getDriver();
		if( driver == null )
			return Action.ERROR;
		
		
		Set<Vehicle> driverVehicles = driver.getVehicles();
		setDriver(driver);	
		
		
		return Action.SUCCESS;
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
