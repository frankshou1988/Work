package com.tetrapak.domain.authz;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 * User class stands for a user
 * */
@Entity
@Table(name = "user_account", schema = "dbo")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "user_pass")
    private String userPass;
    @OneToMany(cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(name = "user_role_map", joinColumns = { @JoinColumn(name = "user_id") },
	    inverseJoinColumns = { @JoinColumn(name = "role_id") })
    private Set<UserRole> userRoles;

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public String getUserName() {
	return userName;
    }

    public void setUserName(String userName) {
	this.userName = userName;
    }

    public String getUserPass() {
	return userPass;
    }

    public void setUserPass(String userPass) {
	this.userPass = userPass;
    }

    public Set<UserRole> getUserRoles() {
	return userRoles;
    }

    public void setUserRoles(Set<UserRole> userRoles) {
	this.userRoles = userRoles;
    }

}
