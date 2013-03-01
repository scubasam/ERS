package edu.thangiah.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Abstract Model.
 * @author pbair
 */
@MappedSuperclass
public abstract class AbstractModel {
    protected Long id = null;

    public AbstractModel() {
        
    }

    public AbstractModel(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}