package com.tetrapak.domain.bpu;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "bpu_alarm_report_analyse_point", schema = "dbo")
public class BPUAlarmReportAnalysePoint implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne
    @JoinColumn(name = "bpu_alarm_tag", referencedColumnName = "id")
    private BPUAlarmTag bpuAlarmTag;
    @Column(name = "bpu_alarm_latest_analyse_date_time")
    private String bpuAlarmLatestAnalyseDateTime;

    public BPUAlarmTag getBpuAlarmTag() {
	return bpuAlarmTag;
    }

    public void setBpuAlarmTag(BPUAlarmTag bpuAlarmTag) {
	this.bpuAlarmTag = bpuAlarmTag;
    }

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public String getBpuAlarmLatestAnalyseDateTime() {
	return bpuAlarmLatestAnalyseDateTime;
    }

    public void setBpuAlarmLatestAnalyseDateTime(String bpuAlarmLatestAnalyseDateTime) {
	this.bpuAlarmLatestAnalyseDateTime = bpuAlarmLatestAnalyseDateTime;
    }

}
