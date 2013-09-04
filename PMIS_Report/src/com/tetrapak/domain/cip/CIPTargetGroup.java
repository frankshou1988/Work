package com.tetrapak.domain.cip;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cip_target_group", schema = "dbo")
public class CIPTargetGroup implements Serializable {
    private static final long serialVersionUID = 896105432066520213L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "cip_target_group_name")
    private String cipTargetGroupName;
    @Column(name = "cip_target_group_desc")
    private String cipTargetGroupDesc;
    @Column(name = "workshop_type")
    private String workshopType;

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public String getCipTargetGroupName() {
	return cipTargetGroupName;
    }

    public void setCipTargetGroupName(String cipTargetGroupName) {
	this.cipTargetGroupName = cipTargetGroupName;
    }

    public String getCipTargetGroupDesc() {
	return cipTargetGroupDesc;
    }

    public void setCipTargetGroupDesc(String cipTargetGroupDesc) {
	this.cipTargetGroupDesc = cipTargetGroupDesc;
    }

    public String getWorkshopType() {
	return workshopType;
    }

    public void setWorkshopType(String workshopType) {
	this.workshopType = workshopType;
    }

}
