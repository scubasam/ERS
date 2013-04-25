package edu.thangiah.user.entity;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import edu.thangiah.entity.EntityInterface;
import edu.thangiah.permission.Role;
import edu.thangiah.permission.RoleDao;
 
/**
 * The persistent class for the users database table.
 * 
 */
public class User implements Serializable, EntityInterface {
 
	private static final long serialVersionUID = 1L;

    private long id;
    private String password;
    private String sessionId;
	private String salt;
	private String username;
	private String email;
    private boolean admin;
    
    private String serializedVisibilityMap;
    
    private Set<Role> roles;
    
    private Map<String, Set<String>> columnVisibilityMap; // maps action names to a set of visible columns
    
    public static final int minPasswordLength = 6;
    
 
    public User() {
    	
    }
 
    public Long getId() {
        return this.id;
    }
 
    public void setId(Long id) {
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
	
	public void removeRole(Role role, RoleDao dao) {
		if( this.roles == null )
			this.roles = new HashSet<Role>();
		
		this.roles.remove(role);
		role.removeUser(this);
		dao.update(role);
	}

	public boolean hasRole(Role parsedRole) {
		if( this.roles != null ){
			return this.roles.contains(parsedRole);
		}
		return false;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Set<String>> getColumnVisibilityMap() {
		if( columnVisibilityMap == null ){
			if( this.serializedVisibilityMap != null && this.serializedVisibilityMap.length() > 0 ){
				XMLDecoder xmlDecoder = new XMLDecoder(new ByteArrayInputStream(this.serializedVisibilityMap.getBytes()));
				this.columnVisibilityMap = (Map<String, Set<String>>) xmlDecoder.readObject();
				xmlDecoder.close();
			}
			else{
				columnVisibilityMap = new HashMap<String, Set<String>>();
			}
		}
		
		return columnVisibilityMap;
	}

	public void setColumnVisibilityMap(Map<String, Set<String>> columnVisibilityMap) {
		this.columnVisibilityMap = columnVisibilityMap;
	}

	public void serializeVisibilityMap() {
		if( columnVisibilityMap != null && columnVisibilityMap.size() > 0 ){
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			XMLEncoder xmlEncoder = new XMLEncoder(bos);
			xmlEncoder.writeObject(columnVisibilityMap);
			xmlEncoder.close();
			
			this.serializedVisibilityMap = bos.toString();
			
		}
	}

	public String getSerializedVisibilityMap() {
		return serializedVisibilityMap;
	}

	public void setSerializedVisibilityMap(String serializedVisibilityMap) {
		this.serializedVisibilityMap = serializedVisibilityMap;
	}
}