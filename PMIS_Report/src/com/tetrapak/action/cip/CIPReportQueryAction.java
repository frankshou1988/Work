package com.tetrapak.action.cip;

import java.io.InputStream;
import java.util.List;

import com.lowagie.text.Image;
import com.opensymphony.xwork2.ActionSupport;
import com.tetrapak.action.file.ReportSaveAction;
import com.tetrapak.config.Constants;
import com.tetrapak.domain.cip.CIPReportResult;
import com.tetrapak.metaclass.SaveFileType;
import com.tetrapak.model.cip.CIPReportQueryActionModel;
import com.tetrapak.util.common.Tools;

/**
 * CIP Report Action 1.Save as PDF File 2.Save as Excel File 3.CIP Report Page
 * 4.CIP Report Query
 * */
public class CIPReportQueryAction extends ActionSupport implements ReportSaveAction {
    private static final long serialVersionUID = -7873004867897577873L;
    private Integer cipMasterLineId;
    private Integer cipSlaveLineId;
    private Long cipTypePLCId;
    private Long cipResultPLCId;
    private String cipTargetName;
    private String queryStartDate;
    private String queryEndDate;
    private String orderType;
    private String workshopType;
    private List<CIPReportResult> cipReportResultList;
    private int page;
    private long cipReportPageCount;

    private String saveFileType;
    private String saveFileName;
    private String includeCIPDetails;

    public Integer getCipMasterLineId() {
	return cipMasterLineId;
    }

    public void setCipMasterLineId(Integer cipMasterLineId) {
	this.cipMasterLineId = cipMasterLineId;
    }

    public Integer getCipSlaveLineId() {
	return cipSlaveLineId;
    }

    public void setCipSlaveLineId(Integer cipSlaveLineId) {
	this.cipSlaveLineId = cipSlaveLineId;
    }

    public Long getCipTypePLCId() {
	return cipTypePLCId;
    }

    public void setCipTypePLCId(Long cipTypePLCId) {
	this.cipTypePLCId = cipTypePLCId;
    }

    public Long getCipResultPLCId() {
	return cipResultPLCId;
    }

    public void setCipResultPLCId(Long cipResultPLCId) {
	this.cipResultPLCId = cipResultPLCId;
    }

    public String getCipTargetName() {
	return cipTargetName;
    }

    public void setCipTargetName(String cipTargetName) {
	this.cipTargetName = cipTargetName;
    }

    public String getQueryStartDate() {
	return queryStartDate;
    }

    public void setQueryStartDate(String queryStartDate) {
	this.queryStartDate = queryStartDate;
    }

    public String getQueryEndDate() {
	return queryEndDate;
    }

    public void setQueryEndDate(String queryEndDate) {
	this.queryEndDate = queryEndDate;
    }

    public String getOrderType() {
	return orderType;
    }

    public void setOrderType(String orderType) {
	this.orderType = orderType;
    }

    public List<CIPReportResult> getCipReportResultList() {
	return cipReportResultList;
    }

    public void setCipReportResultList(List<CIPReportResult> cipReportResultList) {
	this.cipReportResultList = cipReportResultList;
    }

    public int getPage() {
	return page;
    }

    public void setPage(int page) {
	this.page = page;
    }

    public long getCipReportPageCount() {
	return cipReportPageCount;
    }

    public void setCipReportPageCount(long cipReportPageCount) {
	this.cipReportPageCount = cipReportPageCount;
    }

    public String getSaveFileType() {
	return saveFileType;
    }

    public void setSaveFileType(String saveFileType) {
	this.saveFileType = saveFileType;
    }

    public String getSaveFileName() {
	return saveFileName;
    }

    public void setSaveFileName(String saveFileName) {
	this.saveFileName = saveFileName;
    }

    public String getIncludeCIPDetails() {
	return includeCIPDetails;
    }

    public void setIncludeCIPDetails(String includeCIPDetails) {
	this.includeCIPDetails = includeCIPDetails;
    }

    public String getWorkshopType() {
	return workshopType;
    }

    public void setWorkshopType(String workshopType) {
	this.workshopType = workshopType;
    }

    private boolean includeCIPDetails() {
	boolean result = false;
	if (this.getIncludeCIPDetails() != null && this.getIncludeCIPDetails().equals(Constants.INCLUDE_CIP_DETAILS)) {
	    result = true;
	}
	return result;
    }

    @Override
    public InputStream getExcelStream() throws Exception {
	List<CIPReportResult> cipReportResultList = CIPReportQueryActionModel.queryCIPReport(cipMasterLineId,
		cipSlaveLineId, cipTypePLCId, cipResultPLCId, cipTargetName, Tools.toDate(queryStartDate).getTime(),
		Tools.toDate(queryEndDate).getTime(), orderType, workshopType);
	return CIPReportQueryActionModel.createExcelStream(cipReportResultList, includeCIPDetails(),
		Tools.getUTF8Text(getText("i18n.customer.name")), Tools.getUTF8Text(getText("i18n.cip.report")),
		Tools.getUTF8Text(getText("i18n.cip.general.info")), Tools.getUTF8Text(getText("i18n.cip.pre.rinse")),
		Tools.getUTF8Text(getText("i18n.cip.lye")), Tools.getUTF8Text(getText("i18n.cip.inter.rinse")),
		Tools.getUTF8Text(getText("i18n.cip.acid")), Tools.getUTF8Text(getText("i18n.cip.final.rinse")),
		Tools.getUTF8Text(getText("i18n.cip.ster")), Tools.getUTF8Text(getText("i18n.no")),
		Tools.getUTF8Text(getText("i18n.cip.target.name")), Tools.getUTF8Text(getText("i18n.cip.target.desc")),
		Tools.getUTF8Text(getText("i18n.cip.slave.line")), Tools.getUTF8Text(getText("i18n.cip.type")),
		Tools.getUTF8Text(getText("i18n.cip.start.time")), Tools.getUTF8Text(getText("i18n.cip.end.time")),
		Tools.getUTF8Text(getText("i18n.cip.last.time")), Tools.getUTF8Text(getText("i18n.cip.result")),
		Tools.getUTF8Text(getText("i18n.cip.operator")),
		Tools.getUTF8Text(getText("i18n.time.since.last.operation")),

		Tools.getUTF8Text(getText("i18n.cip.flush.time")), Tools.getUTF8Text(getText("i18n.cip.flow.out")),
		Tools.getUTF8Text(getText("i18n.cip.tt.out")), Tools.getUTF8Text(getText("i18n.cip.tt.back")),

		Tools.getUTF8Text(getText("i18n.cip.cycle.start.time")),
		Tools.getUTF8Text(getText("i18n.cip.cycle.end.time")),
		Tools.getUTF8Text(getText("i18n.cip.last.time")), Tools.getUTF8Text(getText("i18n.cip.flow.out")),
		Tools.getUTF8Text(getText("i18n.cip.tt.out")), Tools.getUTF8Text(getText("i18n.cip.tt.back")),
		Tools.getUTF8Text(getText("i18n.cip.ct.back")),

		Tools.getUTF8Text(getText("i18n.cip.flush.time")), Tools.getUTF8Text(getText("i18n.cip.flow.out")),
		Tools.getUTF8Text(getText("i18n.cip.tt.out")), Tools.getUTF8Text(getText("i18n.cip.tt.back")),

		Tools.getUTF8Text(getText("i18n.cip.cycle.start.time")),
		Tools.getUTF8Text(getText("i18n.cip.cycle.end.time")),
		Tools.getUTF8Text(getText("i18n.cip.last.time")), Tools.getUTF8Text(getText("i18n.cip.flow.out")),
		Tools.getUTF8Text(getText("i18n.cip.tt.out")), Tools.getUTF8Text(getText("i18n.cip.tt.back")),
		Tools.getUTF8Text(getText("i18n.cip.ct.back")),

		Tools.getUTF8Text(getText("i18n.cip.flush.time")), Tools.getUTF8Text(getText("i18n.cip.flow.out")),
		Tools.getUTF8Text(getText("i18n.cip.tt.out")), Tools.getUTF8Text(getText("i18n.cip.tt.back")),

		Tools.getUTF8Text(getText("i18n.cip.last.time")), Tools.getUTF8Text(getText("i18n.cip.flow.out")),
		Tools.getUTF8Text(getText("i18n.cip.tt.out")), Tools.getUTF8Text(getText("i18n.cip.tt.back")));
    }

    @Override
    public InputStream getPdfStream() throws Exception {
	List<CIPReportResult> cipReportResultList = CIPReportQueryActionModel.queryCIPReport(cipMasterLineId,
		cipSlaveLineId, cipTypePLCId, cipResultPLCId, cipTargetName, Tools.toDate(queryStartDate).getTime(),
		Tools.toDate(queryEndDate).getTime(), orderType, workshopType);
	return CIPReportQueryActionModel.createPdfStream(cipReportResultList, includeCIPDetails(),
		Image.getInstance(this.getClass().getClassLoader().getResource("customer.jpg")),
		Image.getInstance(this.getClass().getClassLoader().getResource("tetrapak.png")),
		Tools.getUTF8Text(getText("i18n.customer.name")), Tools.getUTF8Text(getText("i18n.cip.report")),
		Tools.getUTF8Text(getText("i18n.cip.general.info")), Tools.getUTF8Text(getText("i18n.cip.pre.rinse")),
		Tools.getUTF8Text(getText("i18n.cip.lye")), Tools.getUTF8Text(getText("i18n.cip.inter.rinse")),
		Tools.getUTF8Text(getText("i18n.cip.acid")), Tools.getUTF8Text(getText("i18n.cip.final.rinse")),
		Tools.getUTF8Text(getText("i18n.cip.ster")), Tools.getUTF8Text(getText("i18n.no")),
		Tools.getUTF8Text(getText("i18n.cip.target.name")), Tools.getUTF8Text(getText("i18n.cip.target.desc")),
		Tools.getUTF8Text(getText("i18n.cip.slave.line")), Tools.getUTF8Text(getText("i18n.cip.type")),
		Tools.getUTF8Text(getText("i18n.cip.start.time")), Tools.getUTF8Text(getText("i18n.cip.end.time")),
		Tools.getUTF8Text(getText("i18n.cip.last.time")), Tools.getUTF8Text(getText("i18n.cip.result")),
		Tools.getUTF8Text(getText("i18n.cip.operator")),
		Tools.getUTF8Text(getText("i18n.time.since.last.operation")),
		Tools.getUTF8Text(getText("i18n.cip.flush.time")), Tools.getUTF8Text(getText("i18n.cip.flow.out")),
		Tools.getUTF8Text(getText("i18n.cip.tt.out")), Tools.getUTF8Text(getText("i18n.cip.tt.back")),

		Tools.getUTF8Text(getText("i18n.cip.cycle.start.time")),
		Tools.getUTF8Text(getText("i18n.cip.cycle.end.time")),
		Tools.getUTF8Text(getText("i18n.cip.last.time")), Tools.getUTF8Text(getText("i18n.cip.flow.out")),
		Tools.getUTF8Text(getText("i18n.cip.tt.out")), Tools.getUTF8Text(getText("i18n.cip.tt.back")),
		Tools.getUTF8Text(getText("i18n.cip.ct.back")),

		Tools.getUTF8Text(getText("i18n.cip.flush.time")), Tools.getUTF8Text(getText("i18n.cip.flow.out")),
		Tools.getUTF8Text(getText("i18n.cip.tt.out")), Tools.getUTF8Text(getText("i18n.cip.tt.back")),

		Tools.getUTF8Text(getText("i18n.cip.cycle.start.time")),
		Tools.getUTF8Text(getText("i18n.cip.cycle.end.time")),
		Tools.getUTF8Text(getText("i18n.cip.last.time")), Tools.getUTF8Text(getText("i18n.cip.flow.out")),
		Tools.getUTF8Text(getText("i18n.cip.tt.out")), Tools.getUTF8Text(getText("i18n.cip.tt.back")),
		Tools.getUTF8Text(getText("i18n.cip.ct.back")),

		Tools.getUTF8Text(getText("i18n.cip.flush.time")), Tools.getUTF8Text(getText("i18n.cip.flow.out")),
		Tools.getUTF8Text(getText("i18n.cip.tt.out")), Tools.getUTF8Text(getText("i18n.cip.tt.back")),

		Tools.getUTF8Text(getText("i18n.cip.last.time")), Tools.getUTF8Text(getText("i18n.cip.flow.out")),
		Tools.getUTF8Text(getText("i18n.cip.tt.out")), Tools.getUTF8Text(getText("i18n.cip.tt.back")));
    }

    public String cipReportQuery() throws Exception {
	String result = INPUT;
	setCipReportPageCount(CIPReportQueryActionModel.queryCIPReportPageCount(cipMasterLineId, cipSlaveLineId,
		cipTypePLCId, cipResultPLCId, cipTargetName, Tools.toDate(queryStartDate).getTime(),
		Tools.toDate(queryEndDate).getTime(), workshopType));
	setCipReportResultList(CIPReportQueryActionModel.queryCIPReportPage(cipMasterLineId, cipSlaveLineId,
		cipTypePLCId, cipResultPLCId, cipTargetName, Tools.toDate(queryStartDate).getTime(),
		Tools.toDate(queryEndDate).getTime(), orderType, page, workshopType));
	result = SUCCESS;
	return result;
    }

    public String cipReportSave() {
	String result = INPUT;
	if (getSaveFileType().equals(SaveFileType.F_EXCEL)) {
	    return EXCEL;
	} else if (getSaveFileType().equals(SaveFileType.F_PDF)) {
	    return PDF;
	}
	return result;
    }

}
