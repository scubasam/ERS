package edu.thangiah.permission;

import java.util.List;

import edu.thangiah.dao.AbstractDao;

/**
 * 
 * this codes primary function is to pull a users role from the database via hibernate
 * @author Alex McCracken, Kelly Smith
 *
 */

public class RoleDao extends AbstractDao<Role> {
	
	@SuppressWarnings("unchecked")
	@Override
    public List<Role> findAll() {
        return getHibernateTemplate().find("from Role");
    }
	
	@SuppressWarnings("unchecked")
	@Override
    public List<Role> findById(Long id) {
        return getHibernateTemplate().find("from Role where id=?", id);
    }

}