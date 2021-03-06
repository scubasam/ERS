package edu.thangiah.user.action;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import edu.thangiah.action.AbstractAction;

/**
 * This Action is used for updating the logged in user's visible columns for data grids.
 * @author Kelly Smith
 *
 */
public class ManageColumnsAction extends AbstractAction{
	
	private static final long serialVersionUID = -2416006180783391855L;
	private String[] columnLabels;
	private String action;

	/**
	 * Parses the columns that the user has selected to be visible and updates the current user's database entry so that subsequent
	 * page loads will display proper columns.
	 */
	public String execute(){
		// TODO implement validation on these columns
		if( currentUser != null && columnLabels != null && columnLabels.length > 0 ){
			Set<String> visibleColumns = new HashSet<String>(Arrays.asList(columnLabels));
			currentUser.getColumnVisibilityMap().put(action, visibleColumns);
			currentUser.serializeVisibilityMap();
			userBo.update(currentUser);
			
		}
		
		return SUCCESS;
	}

	public String[] getColumnLabels() {
		return columnLabels;
	}

	public void setColumnLabels(String[] columnLabels) {
		this.columnLabels = columnLabels;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}
}
