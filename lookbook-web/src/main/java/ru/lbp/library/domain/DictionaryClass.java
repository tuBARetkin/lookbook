/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.lbp.library.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 *
 * @author NGorelov
 */
@Entity
@Table(name = "dictionary_class")
public class DictionaryClass extends BaseDomain implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "name")
    private String name;

    @Column(name = "title")
    private String title;

    public DictionaryClass() {
    }

    public DictionaryClass(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "DictionaryClass[ name=" + name + " ]";
    }
    
}
