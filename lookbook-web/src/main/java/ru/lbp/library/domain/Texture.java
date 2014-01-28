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
@Table(name = "texture")
public class Texture extends BaseDomain implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Basic(optional = false)
    @Column(name = "title")
    private String title;

    @Column(name = "info")
    private String info;

    @JoinColumn(name = "texture_class_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TextureClass textureClassId;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "textureId")
    private List<Design> designList;

    public Texture() {
    }

    public Texture(Integer id) {
        this.id = id;
    }

    public Texture(Integer id, String title) {
        this.id = id;
        this.title = title;
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

    public TextureClass getTextureClassId() {
        return textureClassId;
    }

    public void setTextureClassId(TextureClass textureClassId) {
        this.textureClassId = textureClassId;
    }

    public List<Design> getDesignList() {
        return designList;
    }

    public void setDesignList(List<Design> designList) {
        this.designList = designList;
    }

    @Override
    public String toString() {
        return "Texture[ id=" + id + " ]";
    }
    
}
