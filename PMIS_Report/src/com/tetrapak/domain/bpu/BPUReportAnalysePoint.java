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
@Table(name = "bpu_report_analyse_point", schema = "dbo")
public class BPUReportAnalysePoint implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne
    @JoinColumn(name = "bpu_machine", referencedColumnName = "id")
    private BPUMachine bpuMachine;
    @Column(name = "bpu_report_latest_analyse_date_time")
    private String bpuReportLatestAnalyseDateTime;

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public BPUMachine getBpuMachine() {
	return bpuMachine;
    }

    public void setBpuMachine(BPUMachine bpuMachine) {
	this.bpuMachine = bpuMachine;
    }

    public String getBpuReportLatestAnalyseDateTime() {
	return bpuReportLatestAnalyseDateTime;
    }

    public void setBpuReportLatestAnalyseDateTime(String bpuReportLatestAnalyseDateTime) {
	this.bpuReportLatestAnalyseDateTime = bpuReportLatestAnalyseDateTime;
    }

}
