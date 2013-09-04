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
import com.tetrapak.domain.bpu.BPUAlarmReportResult;
import com.tetrapak.metaclass.Number;
import com.tetrapak.metaclass.SaveFileType;
import com.tetrapak.model.bpu.BPUAlarmQueryActionModel;
import com.tetrapak.util.common.Tools;

public class BPUAlarmReportQueryAction extends ActionSupport implements ReportSaveAction {
    private static final long serialVersionUID = 1L;
    private Integer bpuMachineId;
    private String queryStartDate;
    private String queryEndDate;
    private String orderType;
    private int page;
    private long bpuAlarmReportPageCount;
    private List<BPUAlarmReportResult> bpuAlarmReportResultList;

    private String saveFileType;
    private String saveFileName;

    public Integer getBpuMachineId() {
	return bpuMachineId;
    }

    public void setBpuMachineId(Integer bpuMachineId) {
	this.bpuMachineId = bpuMachineId;
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

    public List<BPUAlarmReportResult> getBpuAlarmReportResultList() {
	return bpuAlarmReportResultList;
    }

    public void setBpuAlarmReportResultList(List<BPUAlarmReportResult> bpuAlarmReportResultList) {
	this.bpuAlarmReportResultList = bpuAlarmReportResultList;
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

    public long getBpuAlarmReportPageCount() {
	return bpuAlarmReportPageCount;
    }

    public void setBpuAlarmReportPageCount(long bpuAlarmReportPageCount) {
	this.bpuAlarmReportPageCount = bpuAlarmReportPageCount;
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

    public String queryBPUAlarmReportResult() throws Exception {
	String result = INPUT;
	this.setBpuAlarmReportPageCount(BPUAlarmQueryActionModel.queryBPUAlarmReportResultCount(bpuMachineId,
		queryStartDate, queryEndDate));
	this.setBpuAlarmReportResultList(BPUAlarmQueryActionModel.queryBPUAlarmReportResult(bpuMachineId,
		queryStartDate, queryEndDate, orderType, page));
	return result;
    }

    public String bpuAlarmReportResultSave() throws Exception {
	String result = INPUT;
	if (getSaveFileType().equals(SaveFileType.F_EXCEL)) {
	    return EXCEL;
	} else if (getSaveFileType().equals(SaveFileType.F_PDF)) {
	    return PDF;
	}
	return result;
    }

    public InputStream getExcelStream() throws Exception {
	List<BPUAlarmReportResult> bpuAlarmReportResultList = BPUAlarmQueryActionModel.queryBPUAlarmReportResult(
		bpuMachineId, queryStartDate, queryEndDate, orderType);
	HSSFWorkbook workbook = new HSSFWorkbook();
	HSSFSheet sheet = workbook.createSheet(Tools.getUTF8Text(getText("i18n.bpu.alarm.report")));

	CellRangeAddress titleRegion = new CellRangeAddress(Number.NUMBER_0, Number.NUMBER_0, Number.NUMBER_0,
		Number.NUMBER_7);

	sheet.addMergedRegion(titleRegion);
	HSSFRow titleRow = sheet.createRow(Number.NUMBER_0);
	HSSFCell titleCell = titleRow.createCell(Number.NUMBER_0);

	HSSFCellStyle titleCellStyle = workbook.createCellStyle();
	titleCellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);

	titleCell.setCellStyle(titleCellStyle);
	titleCell.setCellValue(Tools.getUTF8Text(getText("i18n.bpu.alarm.report")));
	// create table header
	HSSFRow headerRow = sheet.createRow(Number.NUMBER_1);
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
	headerCell.setCellValue(Tools.getUTF8Text(getText("i18n.bpu.alarm.info")));

	headerCell = headerRow.createCell(Number.NUMBER_5, HSSFCell.CELL_TYPE_STRING);
	headerCell.setCellValue(Tools.getUTF8Text(getText("i18n.bpu.alarm.start.time")));

	headerCell = headerRow.createCell(Number.NUMBER_6, HSSFCell.CELL_TYPE_STRING);
	headerCell.setCellValue(Tools.getUTF8Text(getText("i18n.bpu.alarm.end.time")));

	headerCell = headerRow.createCell(Number.NUMBER_7, HSSFCell.CELL_TYPE_STRING);
	headerCell.setCellValue(Tools.getUTF8Text(getText("i18n.bpu.alarm.last.time")));
	int rowNum = Number.NUMBER_2;
	int count = 1;
	for (BPUAlarmReportResult data : bpuAlarmReportResultList) {
	    HSSFRow dataRow = sheet.createRow(rowNum);
	    HSSFCell dataCell = dataRow.createCell(Number.NUMBER_0, HSSFCell.CELL_TYPE_NUMERIC);
	    dataCell.setCellValue(count);

	    dataCell = dataRow.createCell(Number.NUMBER_1, HSSFCell.CELL_TYPE_STRING);
	    dataCell.setCellValue(Tools.getValue(data.getBpuMachineName()));

	    dataCell = dataRow.createCell(Number.NUMBER_2, HSSFCell.CELL_TYPE_STRING);
	    dataCell.setCellValue(Tools.getValue(data.getBpuMachineDesc()));

	    dataCell = dataRow.createCell(Number.NUMBER_3, HSSFCell.CELL_TYPE_STRING);
	    dataCell.setCellValue(Tools.getValue(data.getBpuMachineSerialNumber()));

	    dataCell = dataRow.createCell(Number.NUMBER_4, HSSFCell.CELL_TYPE_STRING);
	    dataCell.setCellValue(Tools.getValue(data.getAlarmMsg()));

	    dataCell = dataRow.createCell(Number.NUMBER_5, HSSFCell.CELL_TYPE_STRING);
	    dataCell.setCellValue(Tools.toDateStr(data.getAlarmStartDateTime()));

	    dataCell = dataRow.createCell(Number.NUMBER_6, HSSFCell.CELL_TYPE_STRING);
	    dataCell.setCellValue(Tools.toDateStr(data.getAlarmEndDateTime()));

	    dataCell = dataRow.createCell(Number.NUMBER_7, HSSFCell.CELL_TYPE_STRING);
	    dataCell.setCellValue(Tools.getValue(data.getAlarmLastTime()));
	    count++;
	    rowNum++;
	}
	ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
	workbook.write(byteArrayOutputStream);
	ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
	byteArrayOutputStream.close();
	return byteArrayInputStream;
    }

    public InputStream getPdfStream() throws Exception {
	List<BPUAlarmReportResult> bpuAlarmReportResultList = BPUAlarmQueryActionModel.queryBPUAlarmReportResult(
		bpuMachineId, queryStartDate, queryEndDate, orderType);
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
	Paragraph reportTitleParagraph = new Paragraph(Tools.getUTF8Text(getText("i18n.bpu.alarm.report")), fcTitle);
	reportTitleParagraph.setAlignment(Paragraph.ALIGN_CENTER);
	document.add(titleParagraph);
	document.add(reportTitleParagraph);
	int count = 1;
	Table dataTable = new Table(Number.NUMBER_8);
	dataTable.setWidth(100);
	dataTable.setAlignment(Element.ALIGN_CENTER);
	dataTable.setAutoFillEmptyCells(true);
	dataTable.setPadding(1);
	dataTable.setSpacing(0);
	dataTable.setBorder(1);
	dataTable.setCellsFitPage(true);
	Cell cell = null;
	cell = new Cell(new Phrase(Tools.getUTF8Text(getText("i18n.no")), fc));
	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	dataTable.addCell(cell);
	cell = new Cell(new Phrase(Tools.getUTF8Text(getText("i18n.bpu.machine.name")), fc));
	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	dataTable.addCell(cell);
	cell = new Cell(new Phrase(Tools.getUTF8Text(getText("i18n.bpu.machine.desc")), fc));
	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	dataTable.addCell(cell);
	cell = new Cell(new Phrase(Tools.getUTF8Text(getText("i18n.bpu.machine.serial.number")), fc));
	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	dataTable.addCell(cell);
	cell = new Cell(new Phrase(Tools.getUTF8Text(getText("i18n.bpu.alarm.info")), fc));
	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	dataTable.addCell(cell);
	cell = new Cell(new Phrase(Tools.getUTF8Text(getText("i18n.bpu.alarm.start.time")), fc));
	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	dataTable.addCell(cell);
	cell = new Cell(new Phrase(Tools.getUTF8Text(getText("i18n.bpu.alarm.end.time")), fc));
	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	dataTable.addCell(cell);
	cell = new Cell(new Phrase(Tools.getUTF8Text(getText("i18n.bpu.alarm.last.time")), fc));
	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	dataTable.addCell(cell);
	for (BPUAlarmReportResult data : bpuAlarmReportResultList) {
	    cell = new Cell(new Phrase(count + "", fc));
	    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	    dataTable.addCell(cell);
	    cell = new Cell(new Phrase(Tools.getValue(data.getBpuMachineName()), fc));
	    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	    dataTable.addCell(cell);
	    cell = new Cell(new Phrase(Tools.getValue(data.getBpuMachineDesc()), fc));
	    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	    dataTable.addCell(cell);
	    cell = new Cell(new Phrase(Tools.getValue(data.getBpuMachineSerialNumber()), fc));
	    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	    dataTable.addCell(cell);
	    cell = new Cell(new Phrase(Tools.getValue(data.getAlarmMsg()), fc));
	    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	    dataTable.addCell(cell);
	    cell = new Cell(new Phrase(Tools.toDateStr(data.getAlarmStartDateTime()), fc));
	    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	    dataTable.addCell(cell);
	    cell = new Cell(new Phrase(Tools.toDateStr(data.getAlarmEndDateTime()), fc));
	    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	    dataTable.addCell(cell);
	    cell = new Cell(new Phrase(Tools.getValue(data.getAlarmLastTime()), fc));
	    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	    dataTable.addCell(cell);
	    count += 1;
	}
	document.add(dataTable);
	document.close();
	ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
	byteArrayOutputStream.close();
	return byteArrayInputStream;
    }
}
