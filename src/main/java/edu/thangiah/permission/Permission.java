package edu.thangiah.permission;

import java.io.Serializable;

public class Permission implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1759769035285717499L;
	
	private String id;
	private Role role;
	
	
	public Permission(){
		
	}
	
	public Permission(String id){
		this.id = id;
	}
	
	public Permission(String id, Role role) {
		super();
		this.id = id;
		this.role = role;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	
}
