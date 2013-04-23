package edu.thangiah.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * This serves as an abstract parent class for each Entity Dao class.  Creates an interface and base functionality for all database access
 * using hibernate.
 * @author Kelly Smith
 *
 * @param <Entity> Generic type that should be set to one of the Entity classes.
 */
public abstract class AbstractDao<Entity> extends HibernateDaoSupport {
	
	public void add(Entity entity) {
        getHibernateTemplate().save(entity);
    }
 
    public void delete(Entity entity) {
        getHibernateTemplate().delete(entity);
    }
 
    public abstract List<Entity> findAll();
 
    public abstract List<Entity> findById(Long id);
 
    public void update(Entity entity) {
        getHibernateTemplate().update(entity);
    }
	
}
