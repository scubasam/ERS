package edu.thangiah.action;

/**
 * This class is used by content files to allow for login checking.
 * @author Kelly
 *
 */
public class RequireLoginAction extends AbstractAction {

	private static final long serialVersionUID = 1214573833807439355L;
	
	@Override
	public String execute() {
		if(this.isLoggedIn())
			return SUCCESS;
		else
			return LOGIN;
    }
}
