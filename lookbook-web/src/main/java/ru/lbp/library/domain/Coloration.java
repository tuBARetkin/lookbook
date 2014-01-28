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
@Table(name = "coloration")
public class Coloration extends BaseDomain implements Serializable {

    private static final long serialVersionUID = 1L;

    @Basic(optional = false)
    @Column(name = "priority")
    private int priority;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @JoinColumn(name = "color_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Color colorId;

    @JoinColumn(name = "design_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Design designId;

    public Coloration() {
    }

    public Coloration(Integer id) {
        this.id = id;
    }

    public Coloration(Integer id, int priority) {
        this.id = id;
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Color getColorId() {
        return colorId;
    }

    public void setColorId(Color colorId) {
        this.colorId = colorId;
    }

    public Design getDesignId() {
        return designId;
    }

    public void setDesignId(Design designId) {
        this.designId = designId;
    }

    @Override
    public String toString() {
        return "Coloration[ id=" + id + " ]";
    }
    
}
