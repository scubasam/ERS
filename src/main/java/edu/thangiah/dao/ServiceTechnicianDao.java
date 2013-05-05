package edu.thangiah.dao;

import java.util.List;

import edu.thangiah.entity.ServiceTechnician;

/**
 * This codes primary function is to pull the database references for a service technician to be manipulated by the entity classes
 * 
 * @author Alex McCracken, Kelly Smith
 *
 */


public class ServiceTechnicianDao extends AbstractDao<ServiceTechnician> {
	
	@SuppressWarnings("unchecked")
	@Override
    public List<ServiceTechnician> findAll() {
		List<ServiceTechnician> list = getHibernateTemplate().find("from ServiceTechnician");
		return list;
    }
	
	@SuppressWarnings("unchecked")
	@Override
    public List<ServiceTechnician> findById(Long id) {
        return getHibernateTemplate().find("from ServiceTechnician where id=?", id);
    }
}