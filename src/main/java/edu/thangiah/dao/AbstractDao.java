package edu.thangiah.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


public abstract class AbstractDao<Entity> extends HibernateDaoSupport {

	public void add(Entity entity) {
        getHibernateTemplate().save(entity);
    }
 
    public void delete(Entity entity) {
        getHibernateTemplate().delete(entity);
    }
 
    public abstract List<Entity> findAll();
 
    public abstract List<Entity> findById(int id);
 
    public void update(Entity entity) {
        getHibernateTemplate().update(entity);
    }
	
}
