package com.tetrapak.domain.comm;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "workshop_type", schema = "dbo")
public class WorkshopType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "workshop_type_name")
    private String workshopTypeName;
    @Column(name = "workshop_type_desc")
    private String workshopTypeDesc;

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public String getWorkshopTypeName() {
	return workshopTypeName;
    }

    public void setWorkshopTypeName(String workshopTypeName) {
	this.workshopTypeName = workshopTypeName;
    }

    public String getWorkshopTypeDesc() {
	return workshopTypeDesc;
    }

    public void setWorkshopTypeDesc(String workshopTypeDesc) {
	this.workshopTypeDesc = workshopTypeDesc;
    }

}
