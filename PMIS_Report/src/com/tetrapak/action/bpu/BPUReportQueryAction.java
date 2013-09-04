package com.tetrapak.action.bpu;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;

import com.lowagie.text.Cell;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfWriter;
import com.opensymphony.xwork2.ActionSupport;
import com.tetrapak.action.file.ReportSaveAction;
import com.tetrapak.domain.bpu.BPUReportResult;
import com.tetrapak.domain.bpu.BPUReportStepResult;
import com.tetrapak.metaclass.BPUReportPhaseSummary;
import com.tetrapak.metaclass.Number;
import com.tetrapak.metaclass.SaveFileType;
import com.tetrapak.model.bpu.BPUReportQueryActionModel;
import com.tetrapak.model.bpu.BPUReportStepQueryActionModel;
import com.tetrapak.util.common.Tools;

public class BPUReportQueryAction extends ActionSupport implements ReportSaveAction {
    private static final long serialVersionUID = 1L;
    private String bpuMachineName;
    private String queryStartDate;
    private String queryEndDate;
    private String orderType;
    private int page;
    private long bpuReportPageCount;
    private List<BPUReportResult> bpuReportResultList;

    /**
     * BPU Steps
     * */
    private String uid;
    private BPUReportResult bpuReportResult;
    private List<BPUReportPhaseSummary> bpuReportPhaseSummaryList;
    private List<BPUReportStepResult> bpuReportStepResultList;

    private String saveFileType;
    private String saveFileName;

    public String getBpuMachineName() {
	return bpuMachineName;
    }

    public void setBpuMachineName(String bpuMachineName) {
	this.bpuMachineName = bpuMachineName;
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

    public List<BPUReportResult> getBpuReportResultList() {
	return bpuReportResultList;
    }

    public void setBpuReportResultList(List<BPUReportResult> bpuReportResultList) {
	this.bpuReportResultList = bpuReportResultList;
    }

    public String getOrderType() {
	return orderType;
    }

    public void setOrderType(String orderType) {
	this.orderType = orderType;
    }

    public int getPage() {
	return page;
    }

    public void setPage(int page) {
	this.page = page;
    }

    public long getBpuReportPageCount() {
	return bpuReportPageCount;
    }

    public void setBpuReportPageCount(long bpuReportPageCount) {
	this.bpuReportPageCount = bpuReportPageCount;
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

    public String getUid() {
	return uid;
    }

    public void setUid(String uid) {
	this.uid = uid;
    }

    public BPUReportResult getBpuReportResult() {
	return bpuReportResult;
    }

    public void setBpuReportResult(BPUReportResult bpuReportResult) {
	this.bpuReportResult = bpuReportResult;
    }

    public List<BPUReportPhaseSummary> getBpuReportPhaseSummaryList() {
	return bpuReportPhaseSummaryList;
    }

    public void setBpuReportPhaseSummaryList(List<BPUReportPhaseSummary> bpuReportPhaseSummaryList) {
	this.bpuReportPhaseSummaryList = bpuReportPhaseSummaryList;
    }

    public List<BPUReportStepResult> getBpuReportStepResultList() {
	return bpuReportStepResultList;
    }

    public void setBpuReportStepResultList(List<BPUReportStepResult> bpuReportStepResultList) {
	this.bpuReportStepResultList = bpuReportStepResultList;
    }

    public String queryBPUReportResult() throws Exception {
	String result = INPUT;
	this.setBpuReportPageCount(BPUReportQueryActionModel.queryBPUReportResultCount(bpuMachineName, queryStartDate,
		queryEndDate));
	this.setBpuReportResultList(BPUReportQueryActionModel.queryBPUReportResult(bpuMachineName, queryStartDate,
		queryEndDate, orderType, page));
	return result;
    }

    public String bpuReportResultSave() throws Exception {
	String result = INPUT;
	if (getSaveFileType().equals(SaveFileType.F_EXCEL)) {
	    return EXCEL;
	} else if (getSaveFileType().equals(SaveFileType.F_PDF)) {
	    return PDF;
	}
	return result;
    }

    public InputStream getExcelStream() throws Exception {
	this.setBpuReportResultList(BPUReportQueryActionModel.queryBPUReportResult(bpuMachineName, queryStartDate,
		queryEndDate, orderType));
	HSSFWorkbook workbook = new HSSFWorkbook();
	HSSFSheet sheet = workbook.createSheet(Tools.getUTF8Text(getText("i18n.bpu.report")));

	CellRangeAddress titleRegion = new CellRangeAddress(Number.NUMBER_0, Number.NUMBER_0, Number.NUMBER_0,
		Number.NUMBER_6);

	sheet.addMergedRegion(titleRegion);
	HSSFRow titleRow = sheet.createRow(Number.NUMBER_0);
	HSSFCell titleCell = titleRow.createCell(Number.NUMBER_0);

	HSSFCellStyle titleCellStyle = workbook.createCellStyle();
	titleCellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);

	titleCell.setCellStyle(titleCellStyle);
	titleCell.setCellValue(Tools.getUTF8Text(getText("i18n.bpu.report")));

	int rowNum = Number.NUMBER_1;
	int count = 1;
	for (BPUReportResult bpuReportResult : bpuReportResultList) {
	    // create table header
	    HSSFRow headerRow = sheet.createRow(rowNum);
	    HSSFCell headerCell = null;
	    headerCell = headerRow.createCell(Number.NUMBER_0, HSSFCell.CELL_TYPE_STRING);
	    headerCell.setCellValue(Tools.getUTF8Text(getText("i18n.no")));

	    headerCell = headerRow.createCell(Number.NUMBER_1, HSSFCell.CELL_TYPE_STRING);
	    headerCell.setCellValue(Tools.getUTF8Text(getText("i18n.bpu.machine.name")));

	    headerCell = headerRow.createCell(Number.NUMBER_2, HSSFCell.CELL_TYPE_STRING);
	    headerCell.setCellValue(Tools.getUTF8Text(getText("i18n.bpu.machine.desc")));

	    headerCell = headerRow.createCell(Number.NUMBER_3, HSSFCell.CELL_TYPE_STRING);
	    headerCell.setCellValue(Tools.getUTF8Text(getText("i18n.bpu.machine.serial.number")));

	    headerCell = headerRow.createCell(Number.NUMBER_4, HSSFCell.CELL_TYPE_STRING);
	    headerCell.setCellValue(Tools.getUTF8Text(getText("i18n.bpu.start.time")));

	    headerCell = headerRow.createCell(Number.NUMBER_5, HSSFCell.CELL_TYPE_STRING);
	    headerCell.setCellValue(Tools.getUTF8Text(getText("i18n.bpu.end.time")));

	    headerCell = headerRow.createCell(Number.NUMBER_6, HSSFCell.CELL_TYPE_STRING);
	    headerCell.setCellValue(Tools.getUTF8Text(getText("i18n.bpu.last.time")));

	    rowNum++;

	    HSSFRow dataRow = sheet.createRow(rowNum);
	    HSSFCell dataCell = dataRow.createCell(Number.NUMBER_0, HSSFCell.CELL_TYPE_NUMERIC);
	    dataCell.setCellValue(count);

	    dataCell = dataRow.createCell(Number.NUMBER_1, HSSFCell.CELL_TYPE_STRING);
	    dataCell.setCellValue(Tools.getValue(bpuReportResult.getBpuMachineName()));

	    dataCell = dataRow.createCell(Number.NUMBER_2, HSSFCell.CELL_TYPE_STRING);
	    dataCell.setCellValue(Tools.getValue(bpuReportResult.getBpuMachineDesc()));

	    dataCell = dataRow.createCell(Number.NUMBER_3, HSSFCell.CELL_TYPE_STRING);
	    dataCell.setCellValue(Tools.getValue(bpuReportResult.getBpuMachineSerialNumber()));

	    dataCell = dataRow.createCell(Number.NUMBER_4, HSSFCell.CELL_TYPE_STRING);
	    dataCell.setCellValue(Tools.getValue(Tools.toDateStr(bpuReportResult.getBpuProdStartDateTime())));

	    dataCell = dataRow.createCell(Number.NUMBER_5, HSSFCell.CELL_TYPE_STRING);
	    dataCell.setCellValue(Tools.getValue(Tools.toDateStr(bpuReportResult.getBpuProdEndDateTime())));

	    dataCell = dataRow.createCell(Number.NUMBER_6, HSSFCell.CELL_TYPE_STRING);
	    dataCell.setCellValue(Tools.getValue(bpuReportResult.getBpuProdLastTime()));

	    rowNum++;
	    count++;

	    List<BPUReportStepResult> bpuReportStepResultList = BPUReportStepQueryActionModel
		    .getBPUReportStepResult(bpuReportResult.getBpuReportResultUniqueId());
	    // step result table header
	    headerRow = sheet.createRow(rowNum);
	    headerCell = headerRow.createCell(Number.NUMBER_0, HSSFCell.CELL_TYPE_STRING);
	    headerCell.setCellValue(Tools.getUTF8Text(getText("i18n.no")));

	    headerCell = headerRow.createCell(Number.NUMBER_1, HSSFCell.CELL_TYPE_NUMERIC);
	    headerCell.setCellValue(Tools.getUTF8Text(getText("i18n.bpu.step.no")));

	    headerCell = headerRow.createCell(Number.NUMBER_2, HSSFCell.CELL_TYPE_STRING);
	    headerCell.setCellValue(Tools.getUTF8Text(getText("i18n.bpu.step.desc")));

	    headerCell = headerRow.createCell(Number.NUMBER_3, HSSFCell.CELL_TYPE_STRING);
	    headerCell.setCellValue(Tools.getUTF8Text(getText("i18n.bpu.step.start.date.time")));

	    headerCell = headerRow.createCell(Number.NUMBER_4, HSSFCell.CELL_TYPE_STRING);
	    headerCell.setCellValue(Tools.getUTF8Text(getText("i18n.bpu.step.end.date.time")));

	    headerCell = headerRow.createCell(Number.NUMBER_5, HSSFCell.CELL_TYPE_STRING);
	    headerCell.setCellValue(Tools.getUTF8Text(getText("i18n.bpu.step.last.time")));

	    headerCell = headerRow.createCell(Number.NUMBER_6, HSSFCell.CELL_TYPE_STRING);
	    headerCell.setCellValue(Tools.getUTF8Text(getText("i18n.bpu.step.phase.desc")));

	    rowNum++;

	    int reportStepCount = 1;
	    for (BPUReportStepResult bpuReportStepResult : bpuReportStepResultList) {
		dataRow = sheet.createRow(rowNum);
		dataCell = dataRow.createCell(Number.NUMBER_0, HSSFCell.CELL_TYPE_NUMERIC);
		dataCell.setCellValue(reportStepCount);

		dataCell = dataRow.createCell(Number.NUMBER_1, HSSFCell.CELL_TYPE_NUMERIC);
		dataCell.setCellValue(Tools.getValue(bpuReportStepResult.getStepN()));

		dataCell = dataRow.createCell(Number.NUMBER_2, HSSFCell.CELL_TYPE_STRING);
		dataCell.setCellValue(Tools.getValue(bpuReportStepResult.getStepNDesc()));

		dataCell = dataRow.createCell(Number.NUMBER_3, HSSFCell.CELL_TYPE_STRING);
		dataCell.setCellValue(Tools.getValue(Tools.toDateStr(bpuReportStepResult.getStepStartDateTime())));

		dataCell = dataRow.createCell(Number.NUMBER_4, HSSFCell.CELL_TYPE_STRING);
		dataCell.setCellValue(Tools.getValue(Tools.toDateStr(bpuReportStepResult.getStepEndDateTime())));

		dataCell = dataRow.createCell(Number.NUMBER_5, HSSFCell.CELL_TYPE_STRING);
		dataCell.setCellValue(Tools.getValue(bpuReportStepResult.getStepLastTime()));

		dataCell = dataRow.createCell(Number.NUMBER_6, HSSFCell.CELL_TYPE_STRING);
		dataCell.setCellValue(Tools.getValue(bpuReportStepResult.getStepPhaseStatDesc()));

		reportStepCount++;
		rowNum++;
	    }
	    rowNum++;
	}
	ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
	workbook.write(byteArrayOutputStream);
	ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
	byteArrayOutputStream.close();
	return byteArrayInputStream;
    }

    public InputStream getPdfStream() throws Exception {
	this.setBpuReportResultList(BPUReportQueryActionModel.queryBPUReportResult(bpuMachineName, queryStartDate,
		queryEndDate, orderType));
	Document document = new Document(PageSize.A4, 10, 10, 10, 10);

	BaseFont bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
	Font fc = new Font(bfChinese, 8, Font.NORMAL);
	Font fcTitle = new Font(bfChinese, 20, Font.BOLD);
	ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
	PdfWriter.getInstance(document, byteArrayOutputStream);
	document.open();
	Image customerImage = Image.getInstance(getClass().getClassLoader().getResource("customer.jpg"));
	customerImage.setAbsolutePosition(10, 780);
	document.add(customerImage);
	Image logoImage = Image.getInstance(getClass().getClassLoader().getResource("tetrapak.png"));
	logoImage.setAbsolutePosition(530, 780);
	document.add(logoImage);
	Paragraph titleParagraph = new Paragraph(Tools.getUTF8Text(getText("i18n.customer.name")), fcTitle);
	titleParagraph.setAlignment(Paragraph.ALIGN_CENTER);
	Paragraph reportTitleParagraph = new Paragraph(Tools.getUTF8Text(getText("i18n.bpu.report")), fcTitle);
	reportTitleParagraph.setAlignment(Paragraph.ALIGN_CENTER);
	document.add(titleParagraph);
	document.add(reportTitleParagraph);

	// report data table
	int reportCount = 1;
	for (BPUReportResult bpuReportResult : this.getBpuReportResultList()) {
	    // write header
	    Table reportDataTable = new Table(Number.NUMBER_7);
	    reportDataTable.setWidth(100);
	    reportDataTable.setAlignment(Element.ALIGN_CENTER);
	    reportDataTable.setAutoFillEmptyCells(true);
	    reportDataTable.setPadding(1);
	    reportDataTable.setSpacing(0);
	    reportDataTable.setBorder(1);
	    reportDataTable.setCellsFitPage(true);
	    Cell cell = null;
	    cell = new Cell(new Phrase(Tools.getUTF8Text(getText("i18n.no")), fc));
	    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	    reportDataTable.addCell(cell);
	    cell = new Cell(new Phrase(Tools.getUTF8Text(getText("i18n.bpu.machine.name")), fc));
	    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	    reportDataTable.addCell(cell);
	    cell = new Cell(new Phrase(Tools.getUTF8Text(getText("i18n.bpu.machine.desc")), fc));
	    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	    reportDataTable.addCell(cell);
	    cell = new Cell(new Phrase(Tools.getUTF8Text(getText("i18n.bpu.machine.serial.number")), fc));
	    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	    reportDataTable.addCell(cell);
	    cell = new Cell(new Phrase(Tools.getUTF8Text(getText("i18n.bpu.start.time")), fc));
	    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	    reportDataTable.addCell(cell);
	    cell = new Cell(new Phrase(Tools.getUTF8Text(getText("i18n.bpu.end.time")), fc));
	    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	    reportDataTable.addCell(cell);
	    cell = new Cell(new Phrase(Tools.getUTF8Text(getText("i18n.bpu.last.time")), fc));
	    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	    reportDataTable.addCell(cell);
	    // write report data
	    cell = new Cell(new Phrase(reportCount + "", fc));
	    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	    reportDataTable.addCell(cell);
	    cell = new Cell(new Phrase(Tools.getValue(bpuReportResult.getBpuMachineName()), fc));
	    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	    reportDataTable.addCell(cell);
	    cell = new Cell(new Phrase(Tools.getValue(bpuReportResult.getBpuMachineDesc()), fc));
	    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	    reportDataTable.addCell(cell);
	    cell = new Cell(new Phrase(Tools.getValue(bpuReportResult.getBpuMachineSerialNumber()), fc));
	    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	    reportDataTable.addCell(cell);
	    cell = new Cell(new Phrase(Tools.getValue(Tools.toDateStr(bpuReportResult.getBpuProdStartDateTime())), fc));
	    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	    reportDataTable.addCell(cell);
	    cell = new Cell(new Phrase(Tools.getValue(Tools.toDateStr(bpuReportResult.getBpuProdEndDateTime())), fc));
	    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	    reportDataTable.addCell(cell);
	    cell = new Cell(new Phrase(Tools.getValue(bpuReportResult.getBpuProdLastTime()), fc));
	    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	    reportDataTable.addCell(cell);
	    reportCount += 1;

	    document.add(reportDataTable);
	    // query report step result
	    int reportStepCount = 1;
	    List<BPUReportStepResult> bpuReportStepResultList = BPUReportStepQueryActionModel
		    .getBPUReportStepResult(bpuReportResult.getBpuReportResultUniqueId());
	    // write report step result data here
	    Table reportStepDataTable = new Table(Number.NUMBER_7);
	    reportStepDataTable.setWidth(100);
	    reportStepDataTable.setAlignment(Element.ALIGN_CENTER);
	    reportStepDataTable.setAutoFillEmptyCells(true);
	    reportStepDataTable.setPadding(1);
	    reportStepDataTable.setSpacing(0);
	    reportStepDataTable.setBorder(1);
	    reportStepDataTable.setCellsFitPage(true);
	    cell = new Cell(new Phrase(Tools.getUTF8Text(getText("i18n.no")), fc));
	    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	    reportStepDataTable.addCell(cell);
	    cell = new Cell(new Phrase(Tools.getUTF8Text(getText("i18n.bpu.step.no")), fc));
	    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	    reportStepDataTable.addCell(cell);
	    cell = new Cell(new Phrase(Tools.getUTF8Text(getText("i18n.bpu.step.desc")), fc));
	    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	    reportStepDataTable.addCell(cell);
	    cell = new Cell(new Phrase(Tools.getUTF8Text(getText("i18n.bpu.step.start.date.time")), fc));
	    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	    reportStepDataTable.addCell(cell);
	    cell = new Cell(new Phrase(Tools.getUTF8Text(getText("i18n.bpu.step.end.date.time")), fc));
	    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	    reportStepDataTable.addCell(cell);
	    cell = new Cell(new Phrase(Tools.getUTF8Text(getText("i18n.bpu.step.last.time")), fc));
	    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	    reportStepDataTable.addCell(cell);
	    cell = new Cell(new Phrase(Tools.getUTF8Text(getText("i18n.bpu.step.phase.desc")), fc));
	    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	    reportStepDataTable.addCell(cell);
	    for (BPUReportStepResult bpuReportStepResult : bpuReportStepResultList) {
		cell = new Cell(new Phrase(reportStepCount + "", fc));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		reportStepDataTable.addCell(cell);
		cell = new Cell(new Phrase(Tools.getValue(bpuReportStepResult.getStepN()), fc));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		reportStepDataTable.addCell(cell);
		cell = new Cell(new Phrase(Tools.getValue(bpuReportStepResult.getStepNDesc()), fc));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		reportStepDataTable.addCell(cell);
		cell = new Cell(new Phrase(Tools.getValue(Tools.toDateStr(bpuReportStepResult.getStepStartDateTime())),
			fc));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		reportStepDataTable.addCell(cell);
		cell = new Cell(new Phrase(Tools.getValue(Tools.toDateStr(bpuReportStepResult.getStepEndDateTime())),
			fc));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		reportStepDataTable.addCell(cell);
		cell = new Cell(new Phrase(Tools.getValue(bpuReportStepResult.getStepLastTime()), fc));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		reportStepDataTable.addCell(cell);
		cell = new Cell(new Phrase(Tools.getValue(bpuReportStepResult.getStepPhaseStatDesc()), fc));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		reportStepDataTable.addCell(cell);

		reportStepCount += 1;
	    }
	    document.add(reportStepDataTable);
	}
	document.close();
	ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
	byteArrayOutputStream.close();
	return byteArrayInputStream;
    }

    public String queryBPUReportStepResult() throws Exception {
	this.setBpuReportResult(BPUReportQueryActionModel.getBPUReportResult(uid));
	this.setBpuReportStepResultList(BPUReportStepQueryActionModel.getBPUReportStepResult(uid));
	this.setBpuReportPhaseSummaryList(BPUReportQueryActionModel.createBPUReportPhaseSummary(this
		.getBpuReportStepResultList()));
	return SUCCESS;
    }

}
