/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.lbp.library.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author NGorelov
 */
@Entity
@Table(name = "thing")
public class Thing extends BaseDomain implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "info")
    private String info;

    @Basic(optional = false)
    @Column(name = "add_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date addDate;

    @Column(name = "creat_date")
    @Temporal(TemporalType.DATE)
    private Date creatDate;

    @Basic(optional = false)
    @Column(name = "complete")
    private int complete;

    @Column(name = "thing_class")
    private String thingClass;

    @Column(name = "brand")
    private String brand;

    @JoinTable(name = "thing_option", joinColumns = {
        @JoinColumn(name = "thing_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "option_key", referencedColumnName = "data_key")})
    @ManyToMany
    private List<DictionaryData> optionList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "thingId")
    private List<ThingParameter> thingParameterList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "thingId")
    private List<ThingPhoto> thingPhotoList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "thingId")
    private List<Design> designList;

    @JoinColumn(name = "look_id", referencedColumnName = "id")
    @ManyToOne
    private Look lookId;

    @JoinColumn(name = "thing_class_key", referencedColumnName = "data_key")
    @ManyToOne(optional = false)
    private DictionaryData thingClassKey;

    @JoinColumn(name = "brand_key", referencedColumnName = "data_key")
    @ManyToOne(optional = false)
    private DictionaryData brandKey;

    public Thing() {
    }

    public Thing(Integer id) {
        this.id = id;
    }

    public Thing(Integer id, Date addDate, int complete) {
        this.id = id;
        this.addDate = addDate;
        this.complete = complete;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Date getAddDate() {
        return addDate;
    }

    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }

    public Date getCreatDate() {
        return creatDate;
    }

    public void setCreatDate(Date creatDate) {
        this.creatDate = creatDate;
    }

    public int getComplete() {
        return complete;
    }

    public void setComplete(int complete) {
        this.complete = complete;
    }

    public String getThingClass() {
        return thingClass;
    }

    public void setThingClass(String thingClass) {
        this.thingClass = thingClass;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public List<DictionaryData> getOptionList() {
        return optionList;
    }

    public void setOptionList(List<DictionaryData> optionList) {
        this.optionList = optionList;
    }

    public List<ThingParameter> getThingParameterList() {
        return thingParameterList;
    }

    public void setThingParameterList(List<ThingParameter> thingParameterList) {
        this.thingParameterList = thingParameterList;
    }

    public List<ThingPhoto> getThingPhotoList() {
        return thingPhotoList;
    }

    public void setThingPhotoList(List<ThingPhoto> thingPhotoList) {
        this.thingPhotoList = thingPhotoList;
    }

    public List<Design> getDesignList() {
        return designList;
    }

    public void setDesignList(List<Design> designList) {
        this.designList = designList;
    }

    public Look getLookId() {
        return lookId;
    }

    public void setLookId(Look lookId) {
        this.lookId = lookId;
    }

    public DictionaryData getThingClassKey() {
        return thingClassKey;
    }

    public void setThingClassKey(DictionaryData thingClassKey) {
        this.thingClassKey = thingClassKey;
    }

    public DictionaryData getBrandKey() {
        return brandKey;
    }

    public void setBrandKey(DictionaryData brandKey) {
        this.brandKey = brandKey;
    }

    @Override
    public String toString() {
        return "Thing[ id=" + id + " ]";
    }
    
}
