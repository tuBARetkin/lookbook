/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.lbp.library.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author NGorelov
 */
@Entity
@Table(name = "full_design")
public class FullDesign extends BaseDomain implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Basic(optional = false)
    @Column(name = "info")
    private String info;

    @JoinTable(name = "part_option", joinColumns = {
            @JoinColumn(name = "full_design_id", referencedColumnName = "id")}, inverseJoinColumns = {
            @JoinColumn(name = "option_key", referencedColumnName = "data_key")})
    @ManyToMany
    private List<DictionaryData> optionList;

    @JoinColumn(name = "thing_part", referencedColumnName = "data_key")
    @ManyToOne(optional = false)
    private DictionaryData thingPart;

    @OneToMany(mappedBy = "fullDesignId")
    private List<Design> designList;

    public FullDesign() {
    }

    public FullDesign(Integer id) {
        this.id = id;
    }

    public FullDesign(Integer id, String info) {
        this.id = id;
        this.info = info;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public List<DictionaryData> getOptionList() {
        return optionList;
    }

    public void setOptionList(List<DictionaryData> optionList) {
        this.optionList = optionList;
    }

    public DictionaryData getThingPart() {
        return thingPart;
    }

    public void setThingPart(DictionaryData thingPart) {
        this.thingPart = thingPart;
    }

    public List<Design> getDesignList() {
        return designList;
    }

    public void setDesignList(List<Design> designList) {
        this.designList = designList;
    }

    @Override
    public String toString() {
        return "FullDesign[ id=" + id + " ]";
    }
    
}
