package edu.thangiah.user.entity;

import java.io.Serializable;
 
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
		return "User: " + this.username + " (" + this.password + ") - Admin? " + this.admin;
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
 
}