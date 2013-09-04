package com.tetrapak.action.bpu;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
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
import com.tetrapak.config.Constants;
import com.tetrapak.dao.CommonDao;
import com.tetrapak.domain.bpu.BPUAnalogTag;
import com.tetrapak.domain.bpu.BPUMachine;
import com.tetrapak.metaclass.BPUTagQueryResult;
import com.tetrapak.metaclass.Number;
import com.tetrapak.metaclass.SaveFileType;
import com.tetrapak.model.bpu.BPUTagQueryActionModel;
import com.tetrapak.util.bpu.BPUTrendReportUtil;
import com.tetrapak.util.common.Tools;

public class BPUTrendQueryAction extends ActionSupport implements ReportSaveAction {
    private static final long serialVersionUID = 1L;
    private Integer bpuMachineId;
    private List<Integer> analogTagIdList;
    private String queryStartDate;
    private String queryEndDate;
    private Integer queryInterval;
    private Integer queryIntervalUnit;
    private List<BPUAnalogTag> bpuAnalogTagList;
    private List<BPUTagQueryResult> bpuTagQueryResultList;
    private Map<String, List<String>> bpuTagQueryResultGeneral;
    private Map<BPUAnalogTag, List<String>> bpuTagQueryResultCustomized;
    private BPUMachine bpuMachine;

    private String saveFileName;
    private String saveFileType;

    public Integer getBpuMachineId() {
	return bpuMachineId;
    }

    public void setBpuMachineId(Integer bpuMachineId) {
	this.bpuMachineId = bpuMachineId;
    }

    public List<Integer> getAnalogTagIdList() {
	return analogTagIdList;
    }

    public void setAnalogTagIdList(List<Integer> analogTagIdList) {
	this.analogTagIdList = analogTagIdList;
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

    public Integer getQueryInterval() {
	return queryInterval;
    }

    public void setQueryInterval(Integer queryInterval) {
	this.queryInterval = queryInterval;
    }

    public Integer getQueryIntervalUnit() {
	return queryIntervalUnit;
    }

    public void setQueryIntervalUnit(Integer queryIntervalUnit) {
	this.queryIntervalUnit = queryIntervalUnit;
    }

    public List<BPUAnalogTag> getBpuAnalogTagList() {
	return bpuAnalogTagList;
    }

    public void setBpuAnalogTagList(List<BPUAnalogTag> bpuAnalogTagList) {
	this.bpuAnalogTagList = bpuAnalogTagList;
    }

    public List<BPUTagQueryResult> getBpuTagQueryResultList() {
	return bpuTagQueryResultList;
    }

    public void setBpuTagQueryResultList(List<BPUTagQueryResult> bpuTagQueryResultList) {
	this.bpuTagQueryResultList = bpuTagQueryResultList;
    }

    public Map<String, List<String>> getBpuTagQueryResultGeneral() {
	return bpuTagQueryResultGeneral;
    }

    public void setBpuTagQueryResultGeneral(Map<String, List<String>> bpuTagQueryResultGeneral) {
	this.bpuTagQueryResultGeneral = bpuTagQueryResultGeneral;
    }

    public Map<BPUAnalogTag, List<String>> getBpuTagQueryResultCustomized() {
	return bpuTagQueryResultCustomized;
    }

    public void setBpuTagQueryResultCustomized(Map<BPUAnalogTag, List<String>> bpuTagQueryResultCustomized) {
	this.bpuTagQueryResultCustomized = bpuTagQueryResultCustomized;
    }

    public BPUMachine getBpuMachine() {
	return bpuMachine;
    }

    public void setBpuMachine(BPUMachine bpuMachine) {
	this.bpuMachine = bpuMachine;
    }

    public String getSaveFileName() {
	return saveFileName;
    }

    public void setSaveFileName(String saveFileName) {
	this.saveFileName = saveFileName;
    }

    public String getSaveFileType() {
	return saveFileType;
    }

    public void setSaveFileType(String saveFileType) {
	this.saveFileType = saveFileType;
    }

    public String queryBPUTrend() throws Exception {
	String result = INPUT;
	List<BPUAnalogTag> tagList = new ArrayList<BPUAnalogTag>();
	for (Integer analogTagId : analogTagIdList) {
	    BPUAnalogTag tag = (BPUAnalogTag) CommonDao.getObjById(BPUAnalogTag.class, analogTagId);
	    if (tag != null) {
		tagList.add(tag);
	    }
	}

	this.setBpuAnalogTagList(tagList);

	if (tagList.size() > 0) {
	    List<BPUTagQueryResult> tagQueryResultList = BPUTagQueryActionModel.queryTagData(tagList, queryStartDate,
		    queryEndDate, queryInterval, queryIntervalUnit);
	    setBpuTagQueryResultList(tagQueryResultList);
	    setBpuTagQueryResultGeneral(BPUTagQueryActionModel.getQueryGeneral(tagQueryResultList));
	    setBpuTagQueryResultCustomized(BPUTagQueryActionModel.getQueryCustomized(tagQueryResultList));
	    result = SUCCESS;
	}
	this.setBpuMachine((BPUMachine) CommonDao.getObjById(BPUMachine.class, bpuMachineId));
	return result;
    }

    public String queryTrendSave() throws Exception {
	String result = INPUT;
	if (getSaveFileType().equals(SaveFileType.F_EXCEL)) {
	    return EXCEL;
	} else if (getSaveFileType().equals(SaveFileType.F_PDF)) {
	    return PDF;
	}
	return result;
    }

    public InputStream getExcelStream() throws Exception {
	queryBPUTrend();
	List<BPUAnalogTag> bpuAnalogTagList = this.getBpuAnalogTagList();
	HSSFWorkbook workbook = new HSSFWorkbook();
	HSSFSheet sheet = workbook.createSheet(Tools.getUTF8Text(getText("i18n.bpu.trend.report")));

	CellRangeAddress titleRegion = new CellRangeAddress(Number.NUMBER_0, Number.NUMBER_0, Number.NUMBER_0,
		bpuAnalogTagList.size() + 1);

	sheet.addMergedRegion(titleRegion);
	HSSFRow titleRow = sheet.createRow(Number.NUMBER_0);
	HSSFCell titleCell = titleRow.createCell(Number.NUMBER_0);

	HSSFCellStyle titleCellStyle = workbook.createCellStyle();
	titleCellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);

	titleCell.setCellStyle(titleCellStyle);
	titleCell.setCellValue(Tools.getUTF8Text(getText("i18n.bpu.trend.report")));
	HSSFRow headerRow = sheet.createRow(Number.NUMBER_1);
	HSSFCell headerCell = null;
	headerCell = headerRow.createCell(Number.NUMBER_0, HSSFCell.CELL_TYPE_STRING);
	headerCell.setCellValue(Tools.getUTF8Text(getText("i18n.no")));

	headerCell = headerRow.createCell(Number.NUMBER_1, HSSFCell.CELL_TYPE_STRING);
	headerCell.setCellValue(Tools.getUTF8Text(getText("i18n.timestamp")));

	int col = 2;

	for (BPUAnalogTag tag : bpuAnalogTagList) {
	    headerCell = headerRow.createCell(col, HSSFCell.CELL_TYPE_STRING);
	    headerCell.setCellValue(tag.getAnalogTagName() + "(" + tag.getAnalogTagUnit() + ")");
	    col += 1;
	}

	Set<Entry<String, List<String>>> entrySet = this.getBpuTagQueryResultGeneral().entrySet();
	int count = 1;
	int rowNum = 2;
	for (Entry<String, List<String>> entry : entrySet) {
	    HSSFRow dataRow = sheet.createRow(rowNum);
	    String timestamp = entry.getKey();
	    List<String> tagQueryResultList = entry.getValue();
	    HSSFCell dataCell = dataRow.createCell(Number.NUMBER_0, HSSFCell.CELL_TYPE_NUMERIC);
	    dataCell.setCellValue(count);
	    dataCell = dataRow.createCell(Number.NUMBER_1, HSSFCell.CELL_TYPE_STRING);
	    dataCell.setCellValue(timestamp);
	    int colNum = 2;
	    for (String tagQueryResult : tagQueryResultList) {
		dataCell = dataRow.createCell(colNum, HSSFCell.CELL_TYPE_NUMERIC);
		dataCell.setCellValue(Tools.parseDouble(tagQueryResult));
		colNum += 1;
	    }
	    count += 1;
	    rowNum += 1;
	}

	HSSFSheet sheet2 = workbook.createSheet(Tools.getUTF8Text(getText("i18n.data.graph")));
	HSSFPatriarch patriarch = sheet2.createDrawingPatriarch();
	HSSFClientAnchor anchor = new HSSFClientAnchor(0, 0, 1000, 255, (short) 0, 0, (short) 24, 48);

	patriarch.createPicture(anchor, workbook.addPicture(
		BPUTrendReportUtil.getBPUAnalogParamGraphData(
			Tools.getUTF8Text(getText("i18n.bpu.trend.graph")), getBpuTagQueryResultList()),
		HSSFWorkbook.PICTURE_TYPE_PNG));
	ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
	workbook.write(byteArrayOutputStream);
	ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
	byteArrayOutputStream.close();
	return byteArrayInputStream;
    }

    public InputStream getPdfStream() throws Exception {
	queryBPUTrend();
	Document document = new Document(PageSize.A4.rotate(), 10, 10, 10, 10);
	BaseFont bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
	Font fc = new Font(bfChinese, 10, Font.NORMAL);
	Font fcTitle = new Font(bfChinese, 20, Font.BOLD);
	ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
	PdfWriter.getInstance(document, byteArrayOutputStream);
	document.open();
	Image customerImage = Image.getInstance(getClass().getClassLoader().getResource("customer.jpg"));
	customerImage.setAbsolutePosition(10, 520);
	document.add(customerImage);
	Image logoImage = Image.getInstance(getClass().getClassLoader().getResource("tetrapak.png"));
	logoImage.setAbsolutePosition(780, 520);
	document.add(logoImage);
	Paragraph titleParagraph = new Paragraph(Tools.getUTF8Text(getText("i18n.customer.name")), fcTitle);
	titleParagraph.setAlignment(Paragraph.ALIGN_CENTER);
	Paragraph reportTitleParagraph = new Paragraph(Tools.getUTF8Text(getText("i18n.bpu.trend.report")), fcTitle);
	reportTitleParagraph.setAlignment(Paragraph.ALIGN_CENTER);
	document.add(titleParagraph);
	document.add(reportTitleParagraph);
	int analogTagCount = getBpuAnalogTagList().size();
	int tableCount = Tools.getBPUParamTableCount(analogTagCount);
	List<BPUAnalogTag> bpuAnalogTagList = getBpuAnalogTagList();
	Set<Entry<String, List<String>>> entrySet = this.getBpuTagQueryResultGeneral().entrySet();
	for (int i = 0; i < tableCount; i++) {
	    int startIndex = i * Constants.BPU_PARAM_REPORT_COLS;
	    int tagCount = Constants.BPU_PARAM_REPORT_COLS;
	    if (i == tableCount - 1) {
		int remainTagCount = analogTagCount - Constants.BPU_PARAM_REPORT_COLS * i;
		tagCount = remainTagCount;
	    }
	    int endIndex = startIndex + tagCount;
	    Table dataTable = new Table(tagCount + 2);
	    dataTable.setWidth(100);
	    dataTable.setAlignment(Element.ALIGN_CENTER);
	    dataTable.setAutoFillEmptyCells(true);
	    dataTable.setPadding(1);
	    dataTable.setSpacing(0);
	    dataTable.setBorder(1);
	    Cell cell = null;
	    cell = new Cell(new Phrase(Tools.getUTF8Text(getText("i18n.no")), fc));
	    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	    dataTable.addCell(cell);
	    cell = new Cell(new Phrase(Tools.getUTF8Text(getText("i18n.timestamp")), fc));
	    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	    dataTable.addCell(cell);

	    // write data here
	    for (int j = startIndex; j < endIndex; j++) {
		BPUAnalogTag tag = bpuAnalogTagList.get(j);
		cell = new Cell(new Phrase(tag.getAnalogTagName() + "(" + tag.getAnalogTagUnit() + ")", fc));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		dataTable.addCell(cell);
	    }

	    int count = 1;
	    for (Entry<String, List<String>> entry : entrySet) {
		String timestamp = entry.getKey();
		List<String> valueList = entry.getValue();
		cell = new Cell(new Phrase(count + ""));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		dataTable.addCell(cell);
		cell = new Cell(new Phrase(timestamp));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		dataTable.addCell(cell);
		for (int k = startIndex; k < endIndex; k++) {
		    cell = new Cell(new Phrase(valueList.get(k)));
		    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		    dataTable.addCell(cell);
		}
		count += 1;
	    }
	    document.add(dataTable);
	}

	Paragraph pImage = new Paragraph();
	byte[] imgBytes = BPUTrendReportUtil.getBPUAnalogParamGraphData(
		Tools.getUTF8Text(getText("i18n.bpu.trend.graph")), getBpuTagQueryResultList());
	pImage.add(Image.getInstance(imgBytes));
	document.add(pImage);
	document.close();
	ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
	byteArrayOutputStream.close();
	return byteArrayInputStream;
    }

}
