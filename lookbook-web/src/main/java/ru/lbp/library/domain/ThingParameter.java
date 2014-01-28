/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.lbp.library.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 *
 * @author NGorelov
 */
@Entity
@Table(name = "thing_parameter")
public class ThingParameter extends BaseDomain implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Basic(optional = false)
    @Column(name = "param_value")
    private String paramValue;

    @Column(name = "info")
    private String info;

    @JoinColumn(name = "thing_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Thing thingId;

    @JoinColumn(name = "parameter", referencedColumnName = "data_key")
    @ManyToOne(optional = false)
    private DictionaryData parameter;

    public ThingParameter() {
    }

    public ThingParameter(Integer id) {
        this.id = id;
    }

    public ThingParameter(Integer id, String paramValue) {
        this.id = id;
        this.paramValue = paramValue;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getParamValue() {
        return paramValue;
    }

    public void setParamValue(String paramValue) {
        this.paramValue = paramValue;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Thing getThingId() {
        return thingId;
    }

    public void setThingId(Thing thingId) {
        this.thingId = thingId;
    }

    public DictionaryData getParameter() {
        return parameter;
    }

    public void setParameter(DictionaryData parameter) {
        this.parameter = parameter;
    }

    @Override
    public String toString() {
        return "ThingParameter[ id=" + id + " ]";
    }
    
}
