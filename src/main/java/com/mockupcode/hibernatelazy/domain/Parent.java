/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mockupcode.hibernatelazy.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author San
 */
@Entity
public class Parent implements Serializable {
    @Id
    private long id;
    @OneToMany(fetch = FetchType.LAZY)
    private List<Child> childs;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Child> getChilds() {
        return childs;
    }

    public void setChilds(List<Child> childs) {
        this.childs = childs;
    }
    
    
}
