package com.tetrapak.domain.cip;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * CIP Target for example a tank or a production line
 * */
@Entity
@Table(name = "cip_target", schema = "dbo")
public class CIPTarget implements Serializable {
    private static final long serialVersionUID = 2987855506914605793L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "cip_target_name")
    private String cipTargetName;
    @Column(name = "cip_target_desc")
    private String cipTargetDesc;

    @ManyToOne
    @JoinColumn(name = "cip_target_group", referencedColumnName = "id")
    private CIPTargetGroup cipTargetGroup;

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public String getCipTargetName() {
	return cipTargetName;
    }

    public void setCipTargetName(String cipTargetName) {
	this.cipTargetName = cipTargetName;
    }

    public String getCipTargetDesc() {
	return cipTargetDesc;
    }

    public void setCipTargetDesc(String cipTargetDesc) {
	this.cipTargetDesc = cipTargetDesc;
    }

    public CIPTargetGroup getCipTargetGroup() {
	return cipTargetGroup;
    }

    public void setCipTargetGroup(CIPTargetGroup cipTargetGroup) {
	this.cipTargetGroup = cipTargetGroup;
    }

}
