package edu.thangiah.permission;

import java.util.List;

import edu.thangiah.dao.AbstractDao;

/**
 * 
 * this codes primary function is to work as a database object to pull permissions for each user from the databse
 * @author Alex McCracken, Kelly Smith
 *
 */

public class PermissionDao extends AbstractDao<Permission> {
	
	@SuppressWarnings("unchecked")
	@Override
    public List<Permission> findAll() {
        return getHibernateTemplate().find("from Permission");
    }
	
	@SuppressWarnings("unchecked")
	public List<Permission> findById(String id) {
        return getHibernateTemplate().find("from Permission where id=?", id);
    }

	@Override
	public List<Permission> findById(Long id) {
		return null;
	}

}