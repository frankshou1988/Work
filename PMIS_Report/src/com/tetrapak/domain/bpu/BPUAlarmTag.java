package com.tetrapak.domain.bpu;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "bpu_alarm_tag", schema = "dbo")
public class BPUAlarmTag implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "alarm_tag_name")
    private String alarmTagName;
    @Column(name = "alarm_insql_tag_name")
    private String alarmInsqlTagName;
    @Column(name = "alarm_tag_desc")
    private String alarmTagDesc;
    @ManyToOne
    @JoinColumn(name = "bpu_machine", referencedColumnName = "id")
    private BPUMachine bpuMachine;

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public String getAlarmTagName() {
	return alarmTagName;
    }

    public void setAlarmTagName(String alarmTagName) {
	this.alarmTagName = alarmTagName;
    }

    public String getAlarmInsqlTagName() {
	return alarmInsqlTagName;
    }

    public void setAlarmInsqlTagName(String alarmInsqlTagName) {
	this.alarmInsqlTagName = alarmInsqlTagName;
    }

    public String getAlarmTagDesc() {
	return alarmTagDesc;
    }

    public void setAlarmTagDesc(String alarmTagDesc) {
	this.alarmTagDesc = alarmTagDesc;
    }

    public BPUMachine getBpuMachine() {
	return bpuMachine;
    }

    public void setBpuMachine(BPUMachine bpuMachine) {
	this.bpuMachine = bpuMachine;
    }

}
