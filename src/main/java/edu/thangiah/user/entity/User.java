package edu.thangiah.user.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import edu.thangiah.permission.Role;
import edu.thangiah.permission.RoleDao;
 
/**
 * The persistent class for the users database table.
 * 
 */

public class User implements Serializable {
 
	private static final long serialVersionUID = 1L;

    private int id;
    private String password;
    private String sessionId;
	private String salt;
	private String username;
    private boolean admin;
    
    Set<Role> roles;
    
    public static final int minPasswordLength = 6;
    
 
    public User() {
    }
 
    public int getId() {
        return this.id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
 
    public String getPassword() {
        return this.password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
 
    public String getUsername() {
        return this.username;
    }
 
    public void setUsername(String username) {
        this.username = username;
    }

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	
	public String toString(){
		return this.username;
	}
	
    public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	
	
    public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	public void addRole(Role role, RoleDao dao){
		if( this.roles == null )
			this.roles = new HashSet<Role>();
			this.roles.add(role);
			
			role.addUser(this);
			dao.update(role);
	}
 
}