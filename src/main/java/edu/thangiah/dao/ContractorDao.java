package edu.thangiah.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.thangiah.entity.Contractor;

public class ContractorDao extends AbstractDao<Contractor> {
	
	@Override
    public List<Contractor> findAll() {
		List<Contractor> list = getHibernateTemplate().find("from Contractor");
		return list;
    }
	
	@Override
    public List<Contractor> findById(int id) {
        return getHibernateTemplate().find("from Contractor where id=?", id);
    }

}
