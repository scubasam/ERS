package edu.thangiah.user.action;


import org.apache.log4j.Logger;
 
import edu.thangiah.action.AbstractAction;

import com.opensymphony.xwork2.Preparable;
 
public abstract class UserAction extends AbstractAction implements Preparable {
 
	private static final long serialVersionUID = 1L;

	protected static final Logger LOGGER = Logger.getLogger(UserAction.class.getName());

}