package edu.thangiah.permission;

import java.io.Serializable;
import java.util.Set;

import edu.thangiah.user.entity.User;

public class Role implements Serializable {
	private static final long serialVersionUID = 8495265479602255906L;
	
	private Long id;
	private String role;
	
	private Set<User> users;
	
	public Role(){
		
	}
	
	public Role(Long id){
		this.id = id;
	}
	
	public Role(Long id, String role){
		this.id = id;
		this.role = role;
	}
	
	public boolean equals(Role otherRole){
		if( this.getRole().equals(otherRole.getRole()) )
			return true;
		else
			return false;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public String toString(){
		return this.role;
	}
	
	public void addUser(User user){
		this.users.add(user);
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

}
