package com.tetrapak.action.cip;

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
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.tetrapak.action.file.ReportSaveAction;
import com.tetrapak.domain.cip.CIPTrendTag;
import com.tetrapak.metaclass.Number;
import com.tetrapak.metaclass.SaveFileType;
import com.tetrapak.metaclass.TagQueryResult;
import com.tetrapak.model.cip.CIPTrendQueryActionModel;
import com.tetrapak.util.cip.CIPTrendReportUtil;
import com.tetrapak.util.cip.CIPTrendTagUtil;
import com.tetrapak.util.common.Tools;

public class CIPTrendQueryAction extends ActionSupport implements Action, ReportSaveAction {
    /**
	 * 
	 */
    private static final long serialVersionUID = -6646415078499855124L;
    private Integer cipTrendTagMasterLineId;
    private List<String> cipTrendTagNameList;
    private String queryStartDate;
    private String queryEndDate;
    private Integer queryInterval;
    private Integer queryIntervalUnit;
    private String queryFileType;
    private String queryFileName;

    private List<CIPTrendTag> cipTrendTagList;
    private List<TagQueryResult> tagQueryResultList;
    private Map<String, List<String>> tagQueryResultGeneral;

    private String saveFileType;
    private String saveFileName;

    public Integer getCipTrendTagMasterLineId() {
	return cipTrendTagMasterLineId;
    }

    public void setCipTrendTagMasterLineId(Integer cipTrendTagMasterLineId) {
	this.cipTrendTagMasterLineId = cipTrendTagMasterLineId;
    }

    public List<String> getCipTrendTagNameList() {
	return cipTrendTagNameList;
    }

    public void setCipTrendTagNameList(List<String> cipTrendTagNameList) {
	this.cipTrendTagNameList = cipTrendTagNameList;
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

    public String getQueryFileType() {
	return queryFileType;
    }

    public void setQueryFileType(String queryFileType) {
	this.queryFileType = queryFileType;
    }

    public String getQueryFileName() {
	return queryFileName;
    }

    public void setQueryFileName(String queryFileName) {
	this.queryFileName = queryFileName;
    }

    public List<CIPTrendTag> getCipTrendTagList() {
	return cipTrendTagList;
    }

    public void setCipTrendTagList(List<CIPTrendTag> cipTrendTagList) {
	this.cipTrendTagList = cipTrendTagList;
    }

    public List<TagQueryResult> getTagQueryResultList() {
	return tagQueryResultList;
    }

    public void setTagQueryResultList(List<TagQueryResult> tagQueryResultList) {
	this.tagQueryResultList = tagQueryResultList;
    }

    public Map<String, List<String>> getTagQueryResultGeneral() {
	return tagQueryResultGeneral;
    }

    public void setTagQueryResultGeneral(Map<String, List<String>> tagQueryResultGeneral) {
	this.tagQueryResultGeneral = tagQueryResultGeneral;
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

    @Override
    public InputStream getExcelStream() throws Exception {
	cipTrendQuery();
	HSSFWorkbook workbook = new HSSFWorkbook();
	HSSFSheet sheet = workbook.createSheet(Tools.getUTF8Text(getText("i18n.cip.trend.report")));

	CellRangeAddress titleRegion = new CellRangeAddress(Number.NUMBER_0, Number.NUMBER_0, Number.NUMBER_0,
		getCipTrendTagList().size() + 1);

	sheet.addMergedRegion(titleRegion);
	HSSFRow titleRow = sheet.createRow(Number.NUMBER_0);
	HSSFCell titleCell = titleRow.createCell(Number.NUMBER_0);

	HSSFCellStyle titleCellStyle = workbook.createCellStyle();
	titleCellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);

	titleCell.setCellStyle(titleCellStyle);
	titleCell.setCellValue(Tools.getUTF8Text(getText("i18n.cip.trend.report")));
	HSSFRow headerRow = sheet.createRow(Number.NUMBER_1);
	HSSFCell headerCell = null;
	headerCell = headerRow.createCell(Number.NUMBER_0, HSSFCell.CELL_TYPE_STRING);
	headerCell.setCellValue(Tools.getUTF8Text(getText("i18n.no")));

	headerCell = headerRow.createCell(Number.NUMBER_1, HSSFCell.CELL_TYPE_STRING);
	headerCell.setCellValue(Tools.getUTF8Text(getText("i18n.timestamp")));

	int col = 2;
	List<CIPTrendTag> cipTrendTagList = getCipTrendTagList();
	for (CIPTrendTag tag : cipTrendTagList) {
	    headerCell = headerRow.createCell(col, HSSFCell.CELL_TYPE_STRING);
	    headerCell.setCellValue(tag.getCipTrendTagDesc() + "(" + tag.getCipTrendTagUnit() + ")");
	    col += 1;
	}

	Set<Entry<String, List<String>>> entrySet = this.getTagQueryResultGeneral().entrySet();
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
		dataCell.setCellValue(tagQueryResult);
		colNum += 1;
	    }
	    count += 1;
	    rowNum += 1;
	}

	HSSFSheet sheet2 = workbook.createSheet(Tools.getUTF8Text(getText("i18n.data.graph")));
	HSSFPatriarch patriarch = sheet2.createDrawingPatriarch();
	HSSFClientAnchor anchor = new HSSFClientAnchor(0, 0, 1000, 255, (short) 0, 0, (short) 24, 48);

	patriarch.createPicture(anchor, workbook.addPicture(CIPTrendReportUtil.getCIPTrendAnalogGraphData(
		Tools.getUTF8Text(getText("i18n.cip.trend")) + Tools.getUTF8Text(getText("i18n.data.graph")),
		tagQueryResultList), HSSFWorkbook.PICTURE_TYPE_PNG));
	ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
	workbook.write(byteArrayOutputStream);
	ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
	byteArrayOutputStream.close();
	return byteArrayInputStream;
    }

    @Override
    public InputStream getPdfStream() throws Exception {
	cipTrendQuery();

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
	Paragraph reportTitleParagraph = new Paragraph(Tools.getUTF8Text(getText("i18n.cip.trend.report")), fcTitle);
	reportTitleParagraph.setAlignment(Paragraph.ALIGN_CENTER);
	document.add(titleParagraph);
	document.add(reportTitleParagraph);

	Table dataTable = new Table(getCipTrendTagList().size() + 2);
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
	List<CIPTrendTag> cipTrendTagList = getCipTrendTagList();
	for (CIPTrendTag tag : cipTrendTagList) {
	    cell = new Cell(new Phrase(tag.getCipTrendTagDesc() + "(" + tag.getCipTrendTagUnit() + ")", fc));
	    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	    dataTable.addCell(cell);
	}

	Set<Entry<String, List<String>>> entrySet = this.getTagQueryResultGeneral().entrySet();
	int count = 1;
	for (Entry<String, List<String>> entry : entrySet) {
	    String timestamp = entry.getKey();
	    List<String> tagQueryResultList = entry.getValue();
	    cell = new Cell(new Phrase(count + ""));
	    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	    dataTable.addCell(cell);
	    cell = new Cell(new Phrase(timestamp));
	    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	    dataTable.addCell(cell);
	    for (String tagQueryResult : tagQueryResultList) {
		cell = new Cell(new Phrase(tagQueryResult));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		dataTable.addCell(cell);
	    }
	    count += 1;
	}

	document.add(dataTable);

	Paragraph pImage = new Paragraph();
	byte[] imgBytes = CIPTrendReportUtil.getCIPTrendAnalogGraphData(Tools.getUTF8Text(getText("i18n.cip.trend"))
		+ Tools.getUTF8Text(getText("i18n.data.graph")), getTagQueryResultList());
	pImage.add(Image.getInstance(imgBytes));
	document.add(pImage);
	document.close();
	ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
	byteArrayOutputStream.close();
	return byteArrayInputStream;
    }

    public String cipTrendPage() throws Exception {
	return SUCCESS;
    }

    public String cipTrendQuery() throws Exception {
	String result = INPUT;
	List<CIPTrendTag> tagList = new ArrayList<CIPTrendTag>();
	for (String tagName : cipTrendTagNameList) {
	    CIPTrendTag tag = CIPTrendTagUtil.getCIPTrendTagByTagName(tagName);
	    if (tag != null) {
		tagList.add(tag);
	    }
	}

	setCipTrendTagList(tagList);

	if (tagList.size() > 0) {
	    List<TagQueryResult> tagQueryResultList = CIPTrendQueryActionModel.queryTagData(tagList, queryStartDate,
		    queryEndDate, queryInterval, queryIntervalUnit);
	    setTagQueryResultList(tagQueryResultList);
	    setTagQueryResultGeneral(CIPTrendQueryActionModel.getQueryGeneral(tagQueryResultList));
	    result = SUCCESS;
	}
	return result;
    }

    public String cipTrendSave() {
	String result = INPUT;
	if (getSaveFileType().equals(SaveFileType.F_EXCEL)) {
	    return EXCEL;
	} else if (getSaveFileType().equals(SaveFileType.F_PDF)) {
	    return PDF;
	}
	return result;
    }

}
