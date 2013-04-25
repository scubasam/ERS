package edu.thangiah.action;

/**
 * BaseAction is a simple class, the function of which is serving up static or simple pages that require user authentication information.
 * @author Kelly Smith
 *
 */
public class BaseAction extends AbstractAction {

	private static final long serialVersionUID = 1969923980363822767L;

	@Override
    public String execute(){
    	return SUCCESS;
    }

}
