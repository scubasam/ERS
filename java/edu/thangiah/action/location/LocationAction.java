package edu.thangiah.action.location;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
 
import edu.thangiah.action.AbstractAction;
import edu.thangiah.dao.LocationDao;

import com.opensymphony.xwork2.Preparable;
 
public class LocationAction extends AbstractAction implements Preparable {
 
    /**
	 * 
	 */
	private static final long serialVersionUID = -3748330746652776264L;

	protected static final Logger LOGGER = Logger.getLogger(LocationAction.class.getName());
    
    @Autowired
	protected LocationDao locationDao;
	

	public LocationDao getLocationDao() {
		return locationDao;
	}

	public void setLocationDao(LocationDao locationDao) {
		this.locationDao = locationDao;
	}

 
    
}