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
@Table(name = "thing_photo")
public class ThingPhoto extends BaseDomain implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Basic(optional = false)
    @Lob
    @Column(name = "photo")
    private byte[] photo;

    @Column(name = "info")
    private String info;

    @JoinColumn(name = "thing_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Thing thingId;

    public ThingPhoto() {
    }

    public ThingPhoto(Integer id) {
        this.id = id;
    }

    public ThingPhoto(Integer id, byte[] photo) {
        this.id = id;
        this.photo = photo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
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

    @Override
    public String toString() {
        return "ThingPhoto[ id=" + id + " ]";
    }
    
}
