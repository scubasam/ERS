package edu.thangiah.dao;

import java.util.List;
import edu.thangiah.entity.Contractor;

public class ContractorDao extends AbstractDao<Contractor> {
	
	@SuppressWarnings("unchecked")
	@Override
    public List<Contractor> findAll() {
		List<Contractor> list = getHibernateTemplate().find("from Contractor");
		return list;
    }
	
	@SuppressWarnings("unchecked")
	@Override
    public List<Contractor> findById(Long id) {
        return getHibernateTemplate().find("from Contractor where id=?", id);
    }

}
