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
@Table(name = "design")
public class Design extends BaseDomain implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Basic(optional = false)
    @Column(name = "priority")
    private int priority;

    @Column(name = "info")
    private String info;

    @Column(name = "texture_size")
    private Integer textureSize;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "designId")
    private List<Coloration> colorationList;

    @JoinColumn(name = "full_design_id", referencedColumnName = "id")
    @ManyToOne
    private FullDesign fullDesignId;

    @JoinColumn(name = "thing_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Thing thingId;

    @JoinColumn(name = "texture_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Texture textureId;

    public Design() {
    }

    public Design(Integer id) {
        this.id = id;
    }

    public Design(Integer id, int priority) {
        this.id = id;
        this.priority = priority;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Integer getTextureSize() {
        return textureSize;
    }

    public void setTextureSize(Integer textureSize) {
        this.textureSize = textureSize;
    }

    public List<Coloration> getColorationList() {
        return colorationList;
    }

    public void setColorationList(List<Coloration> colorationList) {
        this.colorationList = colorationList;
    }

    public FullDesign getFullDesignId() {
        return fullDesignId;
    }

    public void setFullDesignId(FullDesign fullDesignId) {
        this.fullDesignId = fullDesignId;
    }

    public Thing getThingId() {
        return thingId;
    }

    public void setThingId(Thing thingId) {
        this.thingId = thingId;
    }

    public Texture getTextureId() {
        return textureId;
    }

    public void setTextureId(Texture textureId) {
        this.textureId = textureId;
    }

    @Override
    public String toString() {
        return "Design[ id=" + id + " ]";
    }
    
}
