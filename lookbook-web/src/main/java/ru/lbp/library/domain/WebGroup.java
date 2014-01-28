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
@Table(name = "web_group")
public class WebGroup extends BaseDomain implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    private Integer id;

    @Basic(optional = false)
    @Column(name = "title")
    private String title;

    @ManyToMany(mappedBy = "webGroupList")
    private List<WebRole> webRoleList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "webGroupId")
    private List<WebUser> webUserList;

    public WebGroup() {
    }

    public WebGroup(Integer id) {
        this.id = id;
    }

    public WebGroup(Integer id, String title) {
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

    public List<WebRole> getWebRoleList() {
        return webRoleList;
    }

    public void setWebRoleList(List<WebRole> webRoleList) {
        this.webRoleList = webRoleList;
    }

    public List<WebUser> getWebUserList() {
        return webUserList;
    }

    public void setWebUserList(List<WebUser> webUserList) {
        this.webUserList = webUserList;
    }

    @Override
    public String toString() {
        return "WebGroup[ id=" + id + " ]";
    }
    
}
