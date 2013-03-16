package edu.thangiah.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

public abstract class AbstractAction extends ActionSupport implements Preparable{

	private static final long serialVersionUID = 1L;

	@Override
	public void prepare() throws Exception {
		this.clearErrors(); // Prevents errors from persisting accross multiple submits.
	}
	
	
}
