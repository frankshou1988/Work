package com.tetrapak.domain.cip;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cip_phase", schema = "dbo")
public class CIPPhase implements Serializable {

    private static final long serialVersionUID = -6685588542499717498L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "cip_slave_line", referencedColumnName = "id")
    private CIPSlaveLine cipSlaveLine;
    @OneToOne
    @JoinColumn(name = "cip_target", referencedColumnName = "id")
    private CIPTarget cipTarget;
    @Column(name = "phase_id")
    private Long phaseID;
    @Column(name = "phase_name")
    private String phaseName;

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public CIPSlaveLine getCipSlaveLine() {
	return cipSlaveLine;
    }

    public void setCipSlaveLine(CIPSlaveLine cipSlaveLine) {
	this.cipSlaveLine = cipSlaveLine;
    }

    public CIPTarget getCipTarget() {
	return cipTarget;
    }

    public void setCipTarget(CIPTarget cipTarget) {
	this.cipTarget = cipTarget;
    }

    public Long getPhaseID() {
	return phaseID;
    }

    public void setPhaseID(Long phaseID) {
	this.phaseID = phaseID;
    }

    public String getPhaseName() {
	return phaseName;
    }

    public void setPhaseName(String phaseName) {
	this.phaseName = phaseName;
    }

}
