package edu.thangiah.action.contractor;

import java.util.List;

import com.opensymphony.xwork2.Action;

import edu.thangiah.entity.Contractor;

public class ListAction extends ContractorAction{
	private static final long serialVersionUID = -1588835351024220686L;
	private List<Contractor> contractors;
	
	@Override
	public String execute() {
        if (contractorDao == null) {
            return Action.ERROR;
        }
        LOGGER.debug("Get all contractors");
        contractors = contractorDao.findAll();
        LOGGER.debug("Contractors number = " + contractors.size());
        return Action.SUCCESS;
    }

	public List<Contractor> getContractors() {
		return contractors;
	}

	public void setContractors(List<Contractor> contractors) {
		this.contractors = contractors;
	}
}
