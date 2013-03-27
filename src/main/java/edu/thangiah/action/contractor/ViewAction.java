package edu.thangiah.action.contractor;


import com.opensymphony.xwork2.Action;

import edu.thangiah.entity.Contractor;

public class ViewAction extends ContractorAction{
	private static final long serialVersionUID = -6821373379137215233L;
	
	private Contractor contractor;
    private Long id;
	
	@Override
	public String execute(){
		if( id == null )
			return Action.ERROR;
		
		Contractor cont = getContractor(id);
		if( cont == null )
			return Action.ERROR;
		
		setContractor(cont);
		
		return Action.SUCCESS;
	}

	public Contractor getContractor() {
		return contractor;
	}

	public void setContractor(Contractor contractor) {
		this.contractor = contractor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
