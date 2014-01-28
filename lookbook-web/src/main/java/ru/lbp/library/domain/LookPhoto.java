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
@Table(name = "look_photo")
public class LookPhoto extends BaseDomain implements Serializable {

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

    @JoinColumn(name = "look_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Look lookId;

    public LookPhoto() {
    }

    public LookPhoto(Integer id) {
        this.id = id;
    }

    public LookPhoto(Integer id, byte[] photo) {
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

    public Look getLookId() {
        return lookId;
    }

    public void setLookId(Look lookId) {
        this.lookId = lookId;
    }

    @Override
    public String toString() {
        return "LookPhoto[ id=" + id + " ]";
    }
    
}
