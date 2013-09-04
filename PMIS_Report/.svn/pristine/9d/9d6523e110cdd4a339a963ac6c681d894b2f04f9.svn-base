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
 * CIP Slave line which related to a phase
 * */
@Entity
@Table(name = "cip_slave_line", schema = "dbo")
public class CIPSlaveLine implements Serializable {
    private static final long serialVersionUID = 4143859513099270392L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "cip_slave_line_name")
    private String cipSlaveLineName;
    @Column(name = "cip_slave_line_desc")
    private String cipSlaveLineDesc;

    @ManyToOne
    @JoinColumn(name = "cip_master_line", referencedColumnName = "id")
    private CIPMasterLine cipMasterLine;

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public String getCipSlaveLineName() {
	return cipSlaveLineName;
    }

    public void setCipSlaveLineName(String cipSlaveLineName) {
	this.cipSlaveLineName = cipSlaveLineName;
    }

    public String getCipSlaveLineDesc() {
	return cipSlaveLineDesc;
    }

    public void setCipSlaveLineDesc(String cipSlaveLineDesc) {
	this.cipSlaveLineDesc = cipSlaveLineDesc;
    }

    public CIPMasterLine getCipMasterLine() {
	return cipMasterLine;
    }

    public void setCipMasterLine(CIPMasterLine cipMasterLine) {
	this.cipMasterLine = cipMasterLine;
    }

}
