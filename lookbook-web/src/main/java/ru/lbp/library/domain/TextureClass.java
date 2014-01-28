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
@Table(name = "texture_class")
public class TextureClass extends BaseDomain implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Basic(optional = false)
    @Column(name = "title")
    private String title;

    @Column(name = "min_colors")
    private Integer minColors;

    @Column(name = "info")
    private String info;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "textureClassId")
    private List<Texture> textureList;

    public TextureClass() {
    }

    public TextureClass(Integer id) {
        this.id = id;
    }

    public TextureClass(Integer id, String title) {
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

    public Integer getMinColors() {
        return minColors;
    }

    public void setMinColors(Integer minColors) {
        this.minColors = minColors;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public List<Texture> getTextureList() {
        return textureList;
    }

    public void setTextureList(List<Texture> textureList) {
        this.textureList = textureList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "TextureClass[ id=" + id + " ]";
    }
    
}
