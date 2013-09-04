package com.tetrapak.domain.comm;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hmi_operator", schema = "dbo")
public class HMIOperator implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "plc_id")
    private Long plcId;
    @Column(name = "operator_name")
    private String operatorName;
    @Column(name = "plc_structure_type")
    private String plcStructureType;

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public Long getPlcId() {
	return plcId;
    }

    public void setPlcId(Long plcId) {
	this.plcId = plcId;
    }

    public String getOperatorName() {
	return operatorName;
    }

    public void setOperatorName(String operatorName) {
	this.operatorName = operatorName;
    }

    public String getPlcStructureType() {
	return plcStructureType;
    }

    public void setPlcStructureType(String plcStructureType) {
	this.plcStructureType = plcStructureType;
    }

}
