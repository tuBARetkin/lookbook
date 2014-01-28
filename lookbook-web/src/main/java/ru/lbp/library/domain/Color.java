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
@Table(name = "color")
public class Color extends BaseDomain implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "title")
    private String title;

    @Basic(optional = false)
    @Column(name = "color_value")
    private int colorValue;

    @Column(name = "info")
    private String info;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "colorId")
    private List<Coloration> colorationList;

    public Color() {
    }

    public Color(Integer id) {
        this.id = id;
    }

    public Color(Integer id, int colorValue) {
        this.id = id;
        this.colorValue = colorValue;
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

    public int getColorValue() {
        return colorValue;
    }

    public void setColorValue(int colorValue) {
        this.colorValue = colorValue;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public List<Coloration> getColorationList() {
        return colorationList;
    }

    public void setColorationList(List<Coloration> colorationList) {
        this.colorationList = colorationList;
    }

    @Override
    public String toString() {
        return "Color[ id=" + id + " ]";
    }
    
}
