package edu.thangiah.action.location;


import com.opensymphony.xwork2.Action;

import edu.thangiah.entity.Location;

public class ViewAction extends LocationAction{
	private static final long serialVersionUID = -6821373379137215233L;
	
	private Location location;
    private Long id;
	
	@Override
	public String execute(){
		if( id == null )
			return Action.ERROR;
		
		Location loc = getLocation(id);
		if( loc == null )
			return Action.ERROR;
		
		setLocation(loc);
		
		return Action.SUCCESS;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
