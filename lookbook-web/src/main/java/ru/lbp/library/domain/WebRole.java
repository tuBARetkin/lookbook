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
@Table(name = "web_role")
public class WebRole extends BaseDomain implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    private Integer id;

    @Basic(optional = false)
    @Column(name = "title")
    private String title;

    @JoinTable(name = "web_group_roles", joinColumns = {
        @JoinColumn(name = "web_role_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "web_group_id", referencedColumnName = "id")})
    @ManyToMany
    private List<WebGroup> webGroupList;

    public WebRole() {
    }

    public WebRole(Integer id) {
        this.id = id;
    }

    public WebRole(Integer id, String title) {
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

    public List<WebGroup> getWebGroupList() {
        return webGroupList;
    }

    public void setWebGroupList(List<WebGroup> webGroupList) {
        this.webGroupList = webGroupList;
    }

    @Override
    public String toString() {
        return "WebRole[ id=" + id + " ]";
    }
    
}
