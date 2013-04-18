package edu.thangiah.dao;
import java.util.List;

import edu.thangiah.entity.Route;

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
