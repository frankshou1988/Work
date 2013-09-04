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
@Table(name = "bpu_alarm_msg", schema = "dbo")
public class BPUAlarmMsg implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "alarm_msg_bit")
    private Integer alarmMsgBit;
    @Column(name = "alarm_msg_info")
    private String alarmMsgInfo;
    @ManyToOne
    @JoinColumn(name = "bpu_alarm_tag", referencedColumnName = "id")
    private BPUAlarmTag bpuAlarmTag;

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public Integer getAlarmMsgBit() {
	return alarmMsgBit;
    }

    public void setAlarmMsgBit(Integer alarmMsgBit) {
	this.alarmMsgBit = alarmMsgBit;
    }

    public String getAlarmMsgInfo() {
	return alarmMsgInfo;
    }

    public void setAlarmMsgInfo(String alarmMsgInfo) {
	this.alarmMsgInfo = alarmMsgInfo;
    }

    public BPUAlarmTag getBpuAlarmTag() {
	return bpuAlarmTag;
    }

    public void setBpuAlarmTag(BPUAlarmTag bpuAlarmTag) {
	this.bpuAlarmTag = bpuAlarmTag;
    }

}
