package com.tetrapak.domain.cip;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cip_type", schema = "dbo")
public class CIPType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "cip_type_plc_id")
    private Long cipTypePLCId;
    @Column(name = "cip_type_desc")
    private String cipTypeDesc;
    @Column(name = "plc_structure_type")
    private String plcStructureType;

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public Long getCipTypePLCId() {
	return cipTypePLCId;
    }

    public void setCipTypePLCId(Long cipTypePLCId) {
	this.cipTypePLCId = cipTypePLCId;
    }

    public String getCipTypeDesc() {
	return cipTypeDesc;
    }

    public void setCipTypeDesc(String cipTypeDesc) {
	this.cipTypeDesc = cipTypeDesc;
    }

    public String getPlcStructureType() {
	return plcStructureType;
    }

    public void setPlcStructureType(String plcStructureType) {
	this.plcStructureType = plcStructureType;
    }

}
