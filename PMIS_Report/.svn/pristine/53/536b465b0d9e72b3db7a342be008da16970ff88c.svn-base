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

@Entity
@Table(name = "cip_trend_tag", schema = "dbo")
public class CIPTrendTag implements Serializable {

    private static final long serialVersionUID = -9014202912058031569L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "cip_trend_tag_name")
    private String cipTrendTagName;
    @Column(name = "cip_trend_tag_desc")
    private String cipTrendTagDesc;
    @Column(name = "cip_trend_tag_unit")
    private String cipTrendTagUnit;
    @Column(name = "cip_trend_tag_analog")
    private Boolean cipTrendTagAnalog;
    @Column(name = "cip_trend_tag_value_divided_by")
    private Integer cipTrendTagValueDividedBy;
    @ManyToOne
    @JoinColumn(name = "cip_master_line", referencedColumnName = "id")
    private CIPMasterLine cipMasterLine;

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public String getCipTrendTagName() {
	return cipTrendTagName;
    }

    public void setCipTrendTagName(String cipTrendTagName) {
	this.cipTrendTagName = cipTrendTagName;
    }

    public String getCipTrendTagDesc() {
	return cipTrendTagDesc;
    }

    public void setCipTrendTagDesc(String cipTrendTagDesc) {
	this.cipTrendTagDesc = cipTrendTagDesc;
    }

    public String getCipTrendTagUnit() {
	return cipTrendTagUnit;
    }

    public void setCipTrendTagUnit(String cipTrendTagUnit) {
	this.cipTrendTagUnit = cipTrendTagUnit;
    }

    public Boolean getCipTrendTagAnalog() {
	return cipTrendTagAnalog;
    }

    public void setCipTrendTagAnalog(Boolean cipTrendTagAnalog) {
	this.cipTrendTagAnalog = cipTrendTagAnalog;
    }

    public CIPMasterLine getCipMasterLine() {
	return cipMasterLine;
    }

    public void setCipMasterLine(CIPMasterLine cipMasterLine) {
	this.cipMasterLine = cipMasterLine;
    }

    public Integer getCipTrendTagValueDividedBy() {
	return cipTrendTagValueDividedBy;
    }

    public void setCipTrendTagValueDividedBy(Integer cipTrendTagValueDividedBy) {
	this.cipTrendTagValueDividedBy = cipTrendTagValueDividedBy;
    }

}
