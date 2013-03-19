package edu.thangiah.action.driver;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.Preparable;

import edu.thangiah.action.AbstractAction;
import edu.thangiah.dao.DriverDao;

public class DriverAction extends AbstractAction implements Preparable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1152096171071390380L;

	@Autowired
	protected DriverDao driverDao;

	public DriverDao getDriverDao() {
		return driverDao;
	}

	public void setDriverDao(DriverDao driverDao) {
		this.driverDao = driverDao;
	}
}
