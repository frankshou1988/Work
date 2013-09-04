package com.tetrapak.domain.authz;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The role class which defines levels of role
 * */
@Entity
@Table(name = "user_role", schema = "dbo")
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * role type which can have value R_ADMIN,R_OPER,R_ROOT
     * */
    @Column(name = "role_type")
    private String roleType;

    @Column(name = "role_desc")
    private String roleDesc;

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public String getRoleType() {
	return roleType;
    }

    public void setRoleType(String roleType) {
	this.roleType = roleType;
    }

    public String getRoleDesc() {
	return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
	this.roleDesc = roleDesc;
    }

}
