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
@Table(name = "look")
public class Look extends BaseDomain implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Basic(optional = false)
    @Column(name = "sex")
    private String sex;

    @Basic(optional = false)
    @Column(name = "add_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date addDate;

    @Column(name = "create_date")
    @Temporal(TemporalType.DATE)
    private Date createDate;

    @Column(name = "info")
    private String info;

    @Basic(optional = false)
    @Column(name = "complete")
    private int complete;

    @Column(name = "link")
    private String link;

    @Column(name = "title")
    private String title;

    @Column(name = "appearance")
    private String appearance;

    @JoinColumn(name = "place", referencedColumnName = "data_key")
    @ManyToOne(optional = false)
    private DictionaryData place;

    @JoinColumn(name = "hear_style", referencedColumnName = "data_key")
    @ManyToOne
    private DictionaryData hearStyle;

    @JoinColumn(name = "hear_color", referencedColumnName = "data_key")
    @ManyToOne
    private DictionaryData hearColor;

    @JoinColumn(name = "country", referencedColumnName = "data_key")
    @ManyToOne
    private DictionaryData country;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lookId")
    private List<LookPhoto> lookPhotoList;

    @OneToMany(mappedBy = "lookId")
    private List<Thing> thingList;

    public Look() {
    }

    public Look(Integer id) {
        this.id = id;
    }

    public Look(Integer id, String sex, Date addDate, int complete) {
        this.id = id;
        this.sex = sex;
        this.addDate = addDate;
        this.complete = complete;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getAddDate() {
        return addDate;
    }

    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getComplete() {
        return complete;
    }

    public void setComplete(int complete) {
        this.complete = complete;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAppearance() {
        return appearance;
    }

    public void setAppearance(String appearance) {
        this.appearance = appearance;
    }

    public DictionaryData getPlace() {
        return place;
    }

    public void setPlace(DictionaryData place) {
        this.place = place;
    }

    public DictionaryData getHearStyle() {
        return hearStyle;
    }

    public void setHearStyle(DictionaryData hearStyle) {
        this.hearStyle = hearStyle;
    }

    public DictionaryData getHearColor() {
        return hearColor;
    }

    public void setHearColor(DictionaryData hearColor) {
        this.hearColor = hearColor;
    }

    public DictionaryData getCountry() {
        return country;
    }

    public void setCountry(DictionaryData country) {
        this.country = country;
    }

    public List<LookPhoto> getLookPhotoList() {
        return lookPhotoList;
    }

    public void setLookPhotoList(List<LookPhoto> lookPhotoList) {
        this.lookPhotoList = lookPhotoList;
    }

    public List<Thing> getThingList() {
        return thingList;
    }

    public void setThingList(List<Thing> thingList) {
        this.thingList = thingList;
    }

    @Override
    public String toString() {
        return "Look[ id=" + id + " ]";
    }
    
}
