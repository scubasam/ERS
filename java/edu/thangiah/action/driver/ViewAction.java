package edu.thangiah.action.driver;

import com.opensymphony.xwork2.Action;
import edu.thangiah.entity.Driver;

public class ViewAction extends DriverAction{
	private static final long serialVersionUID = -6821373379137215233L;
	
	private Driver driver;
    private Long id;
    
	@Override
	public String execute(){
		if( id == null )
			return Action.ERROR;
		
		Driver driver = getDriver(id);
		if( driver == null )
			return Action.ERROR;
		
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
