/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mockupcode.hibernatelazy.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author San
 */
@Entity
public class Child implements Serializable {
    @Id
    private long id;
    @ManyToOne
    private Parent parent;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }
    
    
}
