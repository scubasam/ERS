package edu.thangiah.dao;
import java.util.List;

import edu.thangiah.entity.Route;

/**
 * This codes primary function is to pull the database references for a route to be manipulated by the entity classes
 * 
 * @author Alex McCracken, Kelly Smith
 *
 */

public class RouteDao extends AbstractDao<Route> {
	
	@SuppressWarnings("unchecked")
	@Override
    public List<Route> findAll() {
		List<Route> list = getHibernateTemplate().find("from Route");
		return list;
    }
	
	@SuppressWarnings("unchecked")
	@Override
    public List<Route> findById(Long id) {
        return getHibernateTemplate().find("from Route where id=?", id);
    }
}
