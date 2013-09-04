package com.tetrapak.domain.cip;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cip_result", schema = "dbo")
public class CIPResult implements Serializable {

    private static final long serialVersionUID = -5712849027518473577L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "cip_result_plc_id")
    private Long cipResultPLCId;
    @Column(name = "cip_result_desc")
    private String cipResultDesc;
    @Column(name = "plc_structure_type")
    private String plcStructureType;

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public Long getCipResultPLCId() {
	return cipResultPLCId;
    }

    public void setCipResultPLCId(Long cipResultPLCId) {
	this.cipResultPLCId = cipResultPLCId;
    }

    public String getCipResultDesc() {
	return cipResultDesc;
    }

    public void setCipResultDesc(String cipResultDesc) {
	this.cipResultDesc = cipResultDesc;
    }

    public String getPlcStructureType() {
	return plcStructureType;
    }

    public void setPlcStructureType(String plcStructureType) {
	this.plcStructureType = plcStructureType;
    }

}
