package com.tetrapak.domain.cip;

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
@Table(name = "cip_report_analyse_point", schema = "dbo")
public class CIPReportAnalysePoint implements Serializable {
    private static final long serialVersionUID = 1281916411800860287L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne
    @JoinColumn(name = "cip_master_line", referencedColumnName = "cip_master_line_name")
    private CIPMasterLine cipMasterLine;
    @Column(name = "cip_latest_analyse_date_time")
    private String cipLatestAnalyseDateTime;

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public CIPMasterLine getCipMasterLine() {
	return cipMasterLine;
    }

    public void setCipMasterLine(CIPMasterLine cipMasterLine) {
	this.cipMasterLine = cipMasterLine;
    }

    public String getCipLatestAnalyseDateTime() {
	return cipLatestAnalyseDateTime;
    }

    public void setCipLatestAnalyseDateTime(String cipLatestAnalyseDateTime) {
	this.cipLatestAnalyseDateTime = cipLatestAnalyseDateTime;
    }

}
