package edu.thangiah.action.contact;

public class DeleteAction extends ManagementController {

		private static final long serialVersionUID = 4634172821230672694L;

		@Override
		public void prepare() throws Exception {
			this.mode =  Modes.EDIT;
			super.prepare();
		}
		/*
		
		@Override
	    public String execute(){
			// Errors could be thrown by the ManagementController prepare methods.
	    	if( this.hasControllerErrors() ){
	    		return ERROR;
	    	}
	    	
	    	Contact fromDb = this.retrieveEntityById(contactDao, id);
	    	if( fromDb == null ){
	    		this.addActionError("This contact does not exist.  Please try again.");
	    		return INPUT;
	    	}
	    	
	    	Contact fromForm = this.getEntity();
	    	if( fromForm == null ){
	    		this.addActionError("The form data could not be retrieved from the form.  Please try again.");
	    		return INPUT;
	    	}
	    	
	    	fromDb.merge(fromForm);
	    	contactDao.update(fromDb);
	    	
	    	return SUCCESS;
	    }


		@Override
		public void validate(){
			this.runContactValidation(this.getEntity());
	    }
		
	} */
}
