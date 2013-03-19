package edu.thangiah.dao;

import java.util.List;

import edu.thangiah.entity.Driver;


public class DriverDao extends AbstractDao<Driver> {
	
	@SuppressWarnings("unchecked")
	@Override
    public List<Driver> findAll() {
		List<Driver> list = getHibernateTemplate().find("from Driver");
		return list;
    }
	
	@SuppressWarnings("unchecked")
	@Override
    public List<Driver> findById(Long id) {
        return getHibernateTemplate().find("from Driver where id=?", id);
    }
	

}
