package edu.thangiah.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.thangiah.entity.Contractor;
import edu.thangiah.entity.VehicleType;

public class VehicleTypeDao extends AbstractDao<VehicleType> {
	
	@Override
    public List<VehicleType> findAll() {
		List<VehicleType> list = getHibernateTemplate().find("from VehicleType");
		return list;
    }
	
	@Override
    public List<VehicleType> findById(Long id) {
        return getHibernateTemplate().find("from VehicleType where id=?", id);
    }

}
