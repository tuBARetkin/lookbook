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
@Table(name = "web_user")
public class WebUser extends BaseDomain implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "login")
    private String login;

    @Basic(optional = false)
    @Column(name = "password")
    private String password;

    @Basic(optional = false)
    @Column(name = "salt")
    private String salt;

    @Basic(optional = false)
    @Column(name = "username")
    private String username;

    @JoinColumn(name = "web_group_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private WebGroup webGroupId;

    public WebUser() {
    }

    public WebUser(String login) {
        this.login = login;
    }

    public WebUser(String login, String password, String salt, String username) {
        this.login = login;
        this.password = password;
        this.salt = salt;
        this.username = username;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public WebGroup getWebGroupId() {
        return webGroupId;
    }

    public void setWebGroupId(WebGroup webGroupId) {
        this.webGroupId = webGroupId;
    }

    @Override
    public String toString() {
        return "WebUser[ login=" + login + " ]";
    }
    
}
