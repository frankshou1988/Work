package com.tetrapak.model.cip;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

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
import com.tetrapak.config.Constants;
import com.tetrapak.config.PMISConfig;
import com.tetrapak.domain.cip.CIPReportResult;
import com.tetrapak.domain.cip.CIPSlaveLine;
import com.tetrapak.domain.cip.CIPTarget;
import com.tetrapak.domain.cip.CIPTrendTag;
import com.tetrapak.hibernate.HU;
import com.tetrapak.metaclass.Number;
import com.tetrapak.util.cip.CIPLineUtil;
import com.tetrapak.util.cip.CIPTargetUtil;
import com.tetrapak.util.cip.CIPTrendTagUtil;
import com.tetrapak.util.common.Tools;

public class CIPReportQueryActionModel {
    public static List<CIPSlaveLine> getCIPSlaveLineListOfMasterLine(Integer masterLineId) throws Exception {
	return CIPLineUtil.getCIPSlaveLineListByMasterLineId(masterLineId);
    }

    public static List<CIPTarget> getCIPTargetListOfTargetGroup(Integer cipTargetGroupId) throws Exception {
	return CIPTargetUtil.getTargetListByGroupId(cipTargetGroupId);
    }

    public static List<CIPTrendTag> getCIPTrendTagListOfMasterLine(Integer masterLineId) throws Exception {
	return CIPTrendTagUtil.getCIPTrendTagsOfMasterLine(masterLineId);
    }

    @SuppressWarnings("unchecked")
    public static List<CIPReportResult> queryCIPReport(Integer cipMasterLineId, Integer cipSlaveLineId,
	    Long cipTypePLCId, Long cipResultPLCId, String cipTargetName, Date queryStartDate, Date queryEndDate,
	    String cipReportOrder, String workshopType) throws Exception {
	List<CIPReportResult> cipReportResultList = new ArrayList<CIPReportResult>();
	SessionFactory sf = HU.getSessionFactory();
	Session s = sf.openSession();
	Transaction t = null;
	try {
	    t = s.beginTransaction();
	    List<Object> objList = null;
	    Criteria c = s.createCriteria(CIPReportResult.class);
	    createCIPReportCriteria(c, cipMasterLineId, cipSlaveLineId, cipTypePLCId, cipResultPLCId, cipTargetName,
		    queryStartDate, queryEndDate, cipReportOrder, workshopType);
	    objList = c.list();
	    t.commit();
	    for (Object obj : objList) {
		CIPReportResult cipReportResult = (CIPReportResult) obj;
		cipReportResultList.add(cipReportResult);
	    }
	} catch (Exception e) {
	    t.rollback();
	    throw e;
	} finally {
	    s.close();
	}
	return cipReportResultList;
    }

    @SuppressWarnings("unchecked")
    public static List<CIPReportResult> queryCIPReportPage(Integer cipMasterLineId, Integer cipSlaveLineId,
	    Long cipTypePLCId, Long cipResultPLCId, String cipTargetName, Date queryStartDate, Date queryEndDate,
	    String cipReportOrder, int page, String workshopType) throws Exception {
	List<CIPReportResult> cipReportResultList = new ArrayList<CIPReportResult>();
	SessionFactory sf = HU.getSessionFactory();
	Session s = sf.openSession();
	Transaction t = null;
	try {
	    t = s.beginTransaction();
	    List<Object> objList = null;
	    Criteria c = s.createCriteria(CIPReportResult.class);
	    createCIPReportCriteria(c, cipMasterLineId, cipSlaveLineId, cipTypePLCId, cipResultPLCId, cipTargetName,
		    queryStartDate, queryEndDate, cipReportOrder, workshopType);
	    c.setFirstResult((page - 1) * PMISConfig.getCipReportPageCount());
	    c.setMaxResults(PMISConfig.getCipReportPageCount());
	    objList = c.list();
	    t.commit();
	    for (Object obj : objList) {
		CIPReportResult cipReportResult = (CIPReportResult) obj;
		cipReportResultList.add(cipReportResult);
	    }
	} catch (Exception e) {
	    t.rollback();
	    throw e;
	} finally {
	    s.close();
	}
	return cipReportResultList;
    }

    public static long queryCIPReportPageCount(Integer cipMasterLineId, Integer cipSlaveLineId, Long cipTypePLCId,
	    Long cipResultPLCId, String cipTargetName, Date queryStartDate, Date queryEndDate, String workshopType)
	    throws Exception {
	Long rowCount = 0L;
	SessionFactory sf = HU.getSessionFactory();
	Session s = sf.openSession();
	Transaction t = null;
	try {
	    t = s.beginTransaction();
	    Criteria c = s.createCriteria(CIPReportResult.class);
	    if (cipMasterLineId != Constants.CIP_REPORT_QUERY_ALL) {
		c.add(Restrictions.eq("cipMasterLineId", cipMasterLineId));
	    }
	    if (cipSlaveLineId != Constants.CIP_REPORT_QUERY_ALL) {
		c.add(Restrictions.eq("cipSlaveLineId", cipSlaveLineId));
	    }
	    if (cipTypePLCId != Constants.CIP_REPORT_QUERY_ALL) {
		c.add(Restrictions.eq("cipTypePLCId", cipTypePLCId));
	    }
	    if (cipResultPLCId != Constants.CIP_REPORT_QUERY_ALL) {
		c.add(Restrictions.eq("cipResultPLCId", cipResultPLCId));
	    }
	    if (!cipTargetName.isEmpty()) {
		c.add(Restrictions.like("cipTargetName", Tools.like(cipTargetName)));
	    }
	    c.add(Restrictions.eq("workshopType", workshopType));
	    c.add(Restrictions.between("cipStartDateTime", queryStartDate, queryEndDate));
	    @SuppressWarnings("rawtypes")
	    List result = c.setProjection(Projections.rowCount()).list();
	    if (result.size() > 0) {
		rowCount = (Long) result.get(0);
	    }
	    t.commit();

	} catch (Exception e) {
	    t.rollback();
	    throw e;
	} finally {
	    s.close();
	}
	int pageCount = (int) (rowCount / PMISConfig.getCipReportPageCount());
	if (rowCount % PMISConfig.getCipReportPageCount() != 0) {
	    pageCount += 1;
	}
	return pageCount;
    }

    public static void createCIPReportCriteria(Criteria c, Integer cipMasterLineId, Integer cipSlaveLineId,
	    Long cipTypePLCId, Long cipResultPLCId, String cipTargetName, Date queryStartDate, Date queryEndDate,
	    String cipReportOrder, String workshopType) {
	if (cipMasterLineId != Constants.CIP_REPORT_QUERY_ALL) {
	    c.add(Restrictions.eq("cipMasterLineId", cipMasterLineId));
	}
	if (cipSlaveLineId != Constants.CIP_REPORT_QUERY_ALL) {
	    c.add(Restrictions.eq("cipSlaveLineId", cipSlaveLineId));
	}
	if (cipTypePLCId != Constants.CIP_REPORT_QUERY_ALL) {
	    c.add(Restrictions.eq("cipTypePLCId", cipTypePLCId));
	}
	if (cipResultPLCId != Constants.CIP_REPORT_QUERY_ALL) {
	    c.add(Restrictions.eq("cipResultPLCId", cipResultPLCId));
	}
	if (!cipTargetName.isEmpty()) {
	    c.add(Restrictions.like("cipTargetName", Tools.like(cipTargetName)));
	}
	c.add(Restrictions.eq("workshopType", workshopType));
	c.add(Restrictions.between("cipStartDateTime", queryStartDate, queryEndDate));
	if (cipReportOrder.equals(Constants.ORDER_BY_DATE_TIME_ASC)) {
	    c.addOrder(Order.asc("cipStartDateTime"));
	} else if (cipReportOrder.equals(Constants.ORDER_BY_DATE_TIME_DESC)) {
	    c.addOrder(Order.desc("cipStartDateTime"));
	}
    }

    public static InputStream createPdfStream(List<CIPReportResult> cipReportResultList, boolean includeCIPDetails,
	    Image customerImage, Image logoImage, String customerNameText, String reportTitleText,
	    String reportGeneralInfoText, String reportPreRinseText, String reportLyeCycleText,
	    String reportInterRinseText, String reportAcidCycleText, String reportFinalRinseText,
	    String reportSterText, String reportNoText, String reportTargetNameText, String reportTargetDescText,
	    String reportSlaveLineText, String reportCipTypeText, String reportStartTimeText, String reportEndTimeText,
	    String reportLastTimeText, String reportResultText, String reportOperatorText,
	    String reportSinceLastTimeText, String preRinseFlushTimeText, String preRinseFlowOutText,
	    String preRinseTTOutText, String preRinseTTBackText, String lyeCycleStartTimeText,
	    String lyeCycleEndTimeText, String lyeCycleLastTimeText, String lyeCycleFlowOutText,
	    String lyeCycleTTOutText, String lyeCycleTTBackText, String lyeCycleCTBackText,
	    String interRinseFlushTimeText, String interRinseFlowOutText, String interRinseTTOutText,
	    String interRinseTTBackText, String acidCycleStartTimeText, String acidCycleEndTimeText,
	    String acidCycleLastTimeText, String acidCycleFlowOutText, String acidCycleTTOutText,
	    String acidCycleTTBackText, String acidCycleCTBackText, String finalRinseFlushTimeText,
	    String finalRinseFlowOutText, String finalRinseTTOutText, String finalRinseTTBackText,
	    String sterLastTimeText, String sterFlowOutText, String sterTTOutText, String sterTTBackText

    ) throws Exception {
	Document document = null;
	if (includeCIPDetails) {
	    document = new Document(PageSize.A2.rotate(), 10, 10, 10, 10);
	} else {
	    document = new Document(PageSize.A4, 10, 10, 10, 10);
	}

	BaseFont bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
	Font fc = new Font(bfChinese, 8, Font.NORMAL);
	Font fcTitle = new Font(bfChinese, 20, Font.BOLD);
	ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
	PdfWriter.getInstance(document, byteArrayOutputStream);
	document.open();
	if (includeCIPDetails) {
	    customerImage.setAbsolutePosition(10, 1130);
	} else {
	    customerImage.setAbsolutePosition(10, 780);
	}
	document.add(customerImage);
	if (includeCIPDetails) {
	    logoImage.setAbsolutePosition(1620, 1130);
	} else {
	    logoImage.setAbsolutePosition(530, 780);
	}
	document.add(logoImage);
	Paragraph titleParagraph = new Paragraph(customerNameText, fcTitle);
	titleParagraph.setAlignment(Paragraph.ALIGN_CENTER);

	Paragraph reportTitleParagraph = null;
	reportTitleParagraph = new Paragraph(reportTitleText, fcTitle);

	reportTitleParagraph.setAlignment(Paragraph.ALIGN_CENTER);
	document.add(titleParagraph);
	document.add(reportTitleParagraph);

	Table dataTable = null;
	if (includeCIPDetails) {
	    dataTable = new Table(Number.NUMBER_41);
	} else {
	    dataTable = new Table(Number.NUMBER_11);
	}

	dataTable.setWidth(100);
	dataTable.setAlignment(Element.ALIGN_CENTER);
	dataTable.setAutoFillEmptyCells(true);
	dataTable.setPadding(1);
	dataTable.setSpacing(0);
	dataTable.setBorder(1);
	dataTable.setCellsFitPage(true);
	if (includeCIPDetails) {

	    Cell gCell = new Cell(new Phrase(reportGeneralInfoText, fc));
	    gCell.setColspan(11);
	    gCell.setHorizontalAlignment(Element.ALIGN_CENTER);
	    gCell.setHeader(true);
	    dataTable.addCell(gCell);

	    Cell pCell = new Cell(new Phrase(reportPreRinseText, fc));
	    pCell.setColspan(4);
	    pCell.setHorizontalAlignment(Element.ALIGN_CENTER);
	    pCell.setHeader(true);
	    dataTable.addCell(pCell);

	    Cell lCell = new Cell(new Phrase(reportLyeCycleText, fc));
	    lCell.setColspan(7);
	    lCell.setHorizontalAlignment(Element.ALIGN_CENTER);
	    lCell.setHeader(true);
	    dataTable.addCell(lCell);

	    Cell iCell = new Cell(new Phrase(reportInterRinseText, fc));
	    iCell.setColspan(4);
	    iCell.setHorizontalAlignment(Element.ALIGN_CENTER);
	    iCell.setHeader(true);
	    dataTable.addCell(iCell);

	    Cell aCell = new Cell(new Phrase(reportAcidCycleText, fc));
	    aCell.setColspan(7);
	    aCell.setHorizontalAlignment(Element.ALIGN_CENTER);
	    aCell.setHeader(true);
	    dataTable.addCell(aCell);

	    Cell fCell = new Cell(new Phrase(reportFinalRinseText, fc));
	    fCell.setColspan(4);
	    fCell.setHorizontalAlignment(Element.ALIGN_CENTER);
	    fCell.setHeader(true);
	    dataTable.addCell(fCell);

	    Cell sCell = new Cell(new Phrase(reportSterText, fc));
	    sCell.setColspan(4);
	    sCell.setHorizontalAlignment(Element.ALIGN_CENTER);
	    sCell.setHeader(true);
	    dataTable.addCell(sCell);
	}

	Cell cell = null;
	cell = new Cell(new Phrase(reportNoText, fc));
	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	dataTable.addCell(cell);
	cell = new Cell(new Phrase(reportTargetNameText, fc));

	dataTable.addCell(cell);
	cell = new Cell(new Phrase(reportTargetDescText, fc));
	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	dataTable.addCell(cell);
	cell = new Cell(new Phrase(reportSlaveLineText, fc));
	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	dataTable.addCell(cell);
	cell = new Cell(new Phrase(reportCipTypeText, fc));
	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	dataTable.addCell(cell);
	cell = new Cell(new Phrase(reportStartTimeText, fc));
	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	dataTable.addCell(cell);
	cell = new Cell(new Phrase(reportEndTimeText, fc));
	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	dataTable.addCell(cell);
	cell = new Cell(new Phrase(reportLastTimeText, fc));
	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	dataTable.addCell(cell);
	cell = new Cell(new Phrase(reportResultText, fc));
	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	dataTable.addCell(cell);
	cell = new Cell(new Phrase(reportOperatorText, fc));
	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	dataTable.addCell(cell);
	cell = new Cell(new Phrase(reportSinceLastTimeText, fc));
	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	dataTable.addCell(cell);

	if (includeCIPDetails) {
	    cell = new Cell(new Phrase(preRinseFlushTimeText, fc));
	    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	    dataTable.addCell(cell);
	    cell = new Cell(new Phrase(preRinseFlowOutText, fc));
	    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	    dataTable.addCell(cell);
	    cell = new Cell(new Phrase(preRinseTTOutText, fc));
	    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	    dataTable.addCell(cell);
	    cell = new Cell(new Phrase(preRinseTTBackText, fc));
	    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	    dataTable.addCell(cell);

	    cell = new Cell(new Phrase(lyeCycleStartTimeText, fc));
	    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	    dataTable.addCell(cell);
	    cell = new Cell(new Phrase(lyeCycleEndTimeText, fc));
	    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	    dataTable.addCell(cell);
	    cell = new Cell(new Phrase(lyeCycleLastTimeText, fc));
	    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	    dataTable.addCell(cell);
	    cell = new Cell(new Phrase(lyeCycleFlowOutText, fc));
	    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	    dataTable.addCell(cell);
	    cell = new Cell(new Phrase(lyeCycleTTOutText, fc));
	    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	    dataTable.addCell(cell);
	    cell = new Cell(new Phrase(lyeCycleTTBackText, fc));
	    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	    dataTable.addCell(cell);
	    cell = new Cell(new Phrase(lyeCycleCTBackText, fc));
	    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	    dataTable.addCell(cell);

	    cell = new Cell(new Phrase(interRinseFlushTimeText, fc));
	    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	    dataTable.addCell(cell);
	    cell = new Cell(new Phrase(interRinseFlowOutText, fc));
	    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	    dataTable.addCell(cell);
	    cell = new Cell(new Phrase(interRinseTTOutText, fc));
	    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	    dataTable.addCell(cell);
	    cell = new Cell(new Phrase(interRinseTTBackText, fc));
	    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	    dataTable.addCell(cell);

	    cell = new Cell(new Phrase(acidCycleStartTimeText, fc));
	    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	    dataTable.addCell(cell);
	    cell = new Cell(new Phrase(acidCycleEndTimeText, fc));
	    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	    dataTable.addCell(cell);
	    cell = new Cell(new Phrase(acidCycleLastTimeText, fc));
	    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	    dataTable.addCell(cell);
	    cell = new Cell(new Phrase(acidCycleFlowOutText, fc));
	    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	    dataTable.addCell(cell);
	    cell = new Cell(new Phrase(acidCycleTTOutText, fc));
	    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	    dataTable.addCell(cell);
	    cell = new Cell(new Phrase(acidCycleTTBackText, fc));
	    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	    dataTable.addCell(cell);
	    cell = new Cell(new Phrase(acidCycleCTBackText, fc));
	    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	    dataTable.addCell(cell);

	    cell = new Cell(new Phrase(finalRinseFlushTimeText, fc));
	    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	    dataTable.addCell(cell);
	    cell = new Cell(new Phrase(finalRinseFlowOutText, fc));
	    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	    dataTable.addCell(cell);
	    cell = new Cell(new Phrase(finalRinseTTOutText, fc));
	    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	    dataTable.addCell(cell);
	    cell = new Cell(new Phrase(finalRinseTTBackText, fc));
	    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	    dataTable.addCell(cell);

	    cell = new Cell(new Phrase(sterLastTimeText, fc));
	    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	    dataTable.addCell(cell);
	    cell = new Cell(new Phrase(sterFlowOutText, fc));
	    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	    dataTable.addCell(cell);
	    cell = new Cell(new Phrase(sterTTOutText, fc));
	    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	    dataTable.addCell(cell);
	    cell = new Cell(new Phrase(sterTTBackText, fc));
	    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	    dataTable.addCell(cell);
	}
	int count = 1;
	for (CIPReportResult data : cipReportResultList) {
	    cell = new Cell(new Phrase(count + "", fc));
	    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	    dataTable.addCell(cell);
	    cell = new Cell(new Phrase(data.getCipTargetName(), fc));
	    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	    dataTable.addCell(cell);
	    cell = new Cell(new Phrase(data.getCipTargetDesc(), fc));
	    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	    dataTable.addCell(cell);
	    cell = new Cell(new Phrase(data.getCipSlaveLineName(), fc));
	    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	    dataTable.addCell(cell);
	    cell = new Cell(new Phrase(data.getCipType(), fc));
	    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	    dataTable.addCell(cell);
	    cell = new Cell(new Phrase(Tools.toDateStr(data.getCipStartDateTime()), fc));
	    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	    dataTable.addCell(cell);
	    cell = new Cell(new Phrase(Tools.toDateStr(data.getCipEndDateTime()), fc));
	    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	    dataTable.addCell(cell);
	    cell = new Cell(new Phrase(data.getCipLastTime().toString(), fc));
	    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	    dataTable.addCell(cell);
	    cell = new Cell(new Phrase(data.getCipResult(), fc));
	    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	    dataTable.addCell(cell);
	    cell = new Cell(new Phrase(data.getCipOperatedByName(), fc));
	    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	    dataTable.addCell(cell);
	    cell = new Cell(new Phrase(data.getTimeSinceLastOperation(), fc));
	    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	    dataTable.addCell(cell);

	    if (includeCIPDetails) {
		cell = new Cell(new Phrase(Tools.getValue(data.getCipPreRinseLastTime()), fc));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		dataTable.addCell(cell);
		cell = new Cell(new Phrase(Tools.getValue(data.getCipPreRinseFlowOut()), fc));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		dataTable.addCell(cell);
		cell = new Cell(new Phrase(Tools.getValue(data.getCipPreRinseTemperatureOut()), fc));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		dataTable.addCell(cell);
		cell = new Cell(new Phrase(Tools.getValue(data.getCipPreRinseTemperatureBack()), fc));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		dataTable.addCell(cell);

		cell = new Cell(new Phrase(Tools.toDateStr(data.getCipLyeCycleStartDateTime()), fc));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		dataTable.addCell(cell);
		cell = new Cell(new Phrase(Tools.toDateStr(data.getCipLyeCycleEndDateTime()), fc));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		dataTable.addCell(cell);
		cell = new Cell(new Phrase(Tools.getValue(data.getCipLyeCycleLastTime()), fc));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		dataTable.addCell(cell);
		cell = new Cell(new Phrase(Tools.getValue(data.getCipLyeCycleFlowOut()), fc));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		dataTable.addCell(cell);
		cell = new Cell(new Phrase(Tools.getValue(data.getCipLyeCycleTemperatureOut()), fc));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		dataTable.addCell(cell);
		cell = new Cell(new Phrase(Tools.getValue(data.getCipLyeCycleTemperatureBack()), fc));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		dataTable.addCell(cell);
		cell = new Cell(new Phrase(Tools.getValue(data.getCipLyeCycleConductivityBack()), fc));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		dataTable.addCell(cell);

		cell = new Cell(new Phrase(Tools.getValue(data.getCipInterRinseLastTime()), fc));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		dataTable.addCell(cell);
		cell = new Cell(new Phrase(Tools.getValue(data.getCipInterRinseFlowOut()), fc));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		dataTable.addCell(cell);
		cell = new Cell(new Phrase(Tools.getValue(data.getCipInterRinseTemperatureOut()), fc));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		dataTable.addCell(cell);
		cell = new Cell(new Phrase(Tools.getValue(data.getCipInterRinseTemperatureBack()), fc));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		dataTable.addCell(cell);

		cell = new Cell(new Phrase(Tools.toDateStr(data.getCipAcidCycleStartDateTime()), fc));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		dataTable.addCell(cell);
		cell = new Cell(new Phrase(Tools.toDateStr(data.getCipAcidCycleEndDateTime()), fc));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		dataTable.addCell(cell);
		cell = new Cell(new Phrase(Tools.getValue(data.getCipAcidCycleLastTime()), fc));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		dataTable.addCell(cell);
		cell = new Cell(new Phrase(Tools.getValue(data.getCipAcidCycleFlowOut()), fc));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		dataTable.addCell(cell);
		cell = new Cell(new Phrase(Tools.getValue(data.getCipAcidCycleTemperatureOut()), fc));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		dataTable.addCell(cell);
		cell = new Cell(new Phrase(Tools.getValue(data.getCipAcidCycleTemperatureBack()), fc));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		dataTable.addCell(cell);
		cell = new Cell(new Phrase(Tools.getValue(data.getCipAcidCycleConductivityBack()), fc));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		dataTable.addCell(cell);

		cell = new Cell(new Phrase(Tools.getValue(data.getCipFinalRinseLastTime()), fc));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		dataTable.addCell(cell);
		cell = new Cell(new Phrase(Tools.getValue(data.getCipFinalRinseFlowOut()), fc));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		dataTable.addCell(cell);
		cell = new Cell(new Phrase(Tools.getValue(data.getCipFinalRinseTemperatureOut()), fc));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		dataTable.addCell(cell);
		cell = new Cell(new Phrase(Tools.getValue(data.getCipFinalRinseTemperatureBack()), fc));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		dataTable.addCell(cell);

		cell = new Cell(new Phrase(Tools.getValue(data.getCipSterilizeLastTime()), fc));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		dataTable.addCell(cell);
		cell = new Cell(new Phrase(Tools.getValue(data.getCipSterilizeFlowOut()), fc));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		dataTable.addCell(cell);
		cell = new Cell(new Phrase(Tools.getValue(data.getCipSterilizeTemperatureOut()), fc));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		dataTable.addCell(cell);
		cell = new Cell(new Phrase(Tools.getValue(data.getCipSterilizeTemperatureBack()), fc));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		dataTable.addCell(cell);
	    }

	    count += 1;
	}

	document.add(dataTable);

	document.close();
	ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
	byteArrayOutputStream.close();
	return byteArrayInputStream;
    }

    public static InputStream createExcelStream(List<CIPReportResult> cipReportResultList, boolean includeCIPDetails,
	    String customerNameText, String reportTitleText, String reportGeneralInfoText, String reportPreRinseText,
	    String reportLyeCycleText, String reportInterRinseText, String reportAcidCycleText,
	    String reportFinalRinseText, String reportSterText, String reportNoText, String reportTargetNameText,
	    String reportTargetDescText, String reportSlaveLineText, String reportCipTypeText,
	    String reportStartTimeText, String reportEndTimeText, String reportLastTimeText, String reportResultText,
	    String reportOperatorText, String reportSinceLastTimeText, String preRinseFlushTimeText,
	    String preRinseFlowOutText, String preRinseTTOutText, String preRinseTTBackText,
	    String lyeCycleStartTimeText, String lyeCycleEndTimeText, String lyeCycleLastTimeText,
	    String lyeCycleFlowOutText, String lyeCycleTTOutText, String lyeCycleTTBackText, String lyeCycleCTBackText,
	    String interRinseFlushTimeText, String interRinseFlowOutText, String interRinseTTOutText,
	    String interRinseTTBackText, String acidCycleStartTimeText, String acidCycleEndTimeText,
	    String acidCycleLastTimeText, String acidCycleFlowOutText, String acidCycleTTOutText,
	    String acidCycleTTBackText, String acidCycleCTBackText, String finalRinseFlushTimeText,
	    String finalRinseFlowOutText, String finalRinseTTOutText, String finalRinseTTBackText,
	    String sterLastTimeText, String sterFlowOutText, String sterTTOutText, String sterTTBackText

    ) throws Exception {
	HSSFWorkbook workbook = new HSSFWorkbook();
	HSSFSheet sheet = workbook.createSheet(reportTitleText);

	CellRangeAddress titleRegion = new CellRangeAddress(Number.NUMBER_0, Number.NUMBER_0, Number.NUMBER_0,
		Number.NUMBER_40);

	CellRangeAddress generalInfoHeaderRegion = new CellRangeAddress(Number.NUMBER_1, Number.NUMBER_1,
		Number.NUMBER_0, Number.NUMBER_10);
	CellRangeAddress preRinseInfoHeaderRegion = new CellRangeAddress(Number.NUMBER_1, Number.NUMBER_1,
		Number.NUMBER_11, Number.NUMBER_14);
	CellRangeAddress lyeInfoHeaderRegion = new CellRangeAddress(Number.NUMBER_1, Number.NUMBER_1, Number.NUMBER_15,
		Number.NUMBER_21);
	CellRangeAddress interRinseInfoHeaderRegion = new CellRangeAddress(Number.NUMBER_1, Number.NUMBER_1,
		Number.NUMBER_22, Number.NUMBER_25);
	CellRangeAddress acidInfoHeaderRegion = new CellRangeAddress(Number.NUMBER_1, Number.NUMBER_1,
		Number.NUMBER_26, Number.NUMBER_32);
	CellRangeAddress finalRinseInfoHeaderRegion = new CellRangeAddress(Number.NUMBER_1, Number.NUMBER_1,
		Number.NUMBER_33, Number.NUMBER_36);
	CellRangeAddress sterInfoHeaderRegion = new CellRangeAddress(Number.NUMBER_1, Number.NUMBER_1,
		Number.NUMBER_37, Number.NUMBER_40);

	sheet.addMergedRegion(titleRegion);
	sheet.addMergedRegion(generalInfoHeaderRegion);
	sheet.addMergedRegion(preRinseInfoHeaderRegion);
	sheet.addMergedRegion(lyeInfoHeaderRegion);
	sheet.addMergedRegion(interRinseInfoHeaderRegion);
	sheet.addMergedRegion(acidInfoHeaderRegion);
	sheet.addMergedRegion(finalRinseInfoHeaderRegion);
	sheet.addMergedRegion(sterInfoHeaderRegion);

	HSSFCellStyle alignCenterCellStyle = workbook.createCellStyle();
	alignCenterCellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);

	HSSFRow titleRow = sheet.createRow(Number.NUMBER_0);
	HSSFCell titleCell = titleRow.createCell(Number.NUMBER_0);
	titleCell.setCellStyle(alignCenterCellStyle);
	titleCell.setCellValue(reportTitleText);

	HSSFRow bigHeaderRow = sheet.createRow(Number.NUMBER_1);

	HSSFCell bigHeaderCell = null;
	bigHeaderCell = bigHeaderRow.createCell(Number.NUMBER_0, HSSFCell.CELL_TYPE_STRING);
	bigHeaderCell.setCellStyle(alignCenterCellStyle);
	bigHeaderCell.setCellValue(reportGeneralInfoText);

	bigHeaderCell = bigHeaderRow.createCell(Number.NUMBER_11, HSSFCell.CELL_TYPE_STRING);
	bigHeaderCell.setCellStyle(alignCenterCellStyle);
	bigHeaderCell.setCellValue(reportPreRinseText);

	bigHeaderCell = bigHeaderRow.createCell(Number.NUMBER_15, HSSFCell.CELL_TYPE_STRING);
	bigHeaderCell.setCellStyle(alignCenterCellStyle);
	bigHeaderCell.setCellValue(reportLyeCycleText);

	bigHeaderCell = bigHeaderRow.createCell(Number.NUMBER_22, HSSFCell.CELL_TYPE_STRING);
	bigHeaderCell.setCellStyle(alignCenterCellStyle);
	bigHeaderCell.setCellValue(reportInterRinseText);

	bigHeaderCell = bigHeaderRow.createCell(Number.NUMBER_26, HSSFCell.CELL_TYPE_STRING);
	bigHeaderCell.setCellStyle(alignCenterCellStyle);
	bigHeaderCell.setCellValue(reportAcidCycleText);

	bigHeaderCell = bigHeaderRow.createCell(Number.NUMBER_33, HSSFCell.CELL_TYPE_STRING);
	bigHeaderCell.setCellStyle(alignCenterCellStyle);
	bigHeaderCell.setCellValue(reportFinalRinseText);

	bigHeaderCell = bigHeaderRow.createCell(Number.NUMBER_37, HSSFCell.CELL_TYPE_STRING);
	bigHeaderCell.setCellStyle(alignCenterCellStyle);
	bigHeaderCell.setCellValue(reportSterText);

	HSSFRow smallHeaderRow = sheet.createRow(Number.NUMBER_2);
	HSSFCell smallHeaderCell = null;
	smallHeaderCell = smallHeaderRow.createCell(Number.NUMBER_0, HSSFCell.CELL_TYPE_STRING);
	smallHeaderCell.setCellValue(reportNoText);

	smallHeaderCell = smallHeaderRow.createCell(Number.NUMBER_1, HSSFCell.CELL_TYPE_STRING);
	smallHeaderCell.setCellValue(reportTargetNameText);

	smallHeaderCell = smallHeaderRow.createCell(Number.NUMBER_2, HSSFCell.CELL_TYPE_STRING);
	smallHeaderCell.setCellValue(reportTargetDescText);

	smallHeaderCell = smallHeaderRow.createCell(Number.NUMBER_3, HSSFCell.CELL_TYPE_STRING);
	smallHeaderCell.setCellValue(reportSlaveLineText);

	smallHeaderCell = smallHeaderRow.createCell(Number.NUMBER_4, HSSFCell.CELL_TYPE_STRING);
	smallHeaderCell.setCellValue(reportCipTypeText);

	smallHeaderCell = smallHeaderRow.createCell(Number.NUMBER_5, HSSFCell.CELL_TYPE_STRING);
	smallHeaderCell.setCellValue(reportStartTimeText);

	smallHeaderCell = smallHeaderRow.createCell(Number.NUMBER_6, HSSFCell.CELL_TYPE_STRING);
	smallHeaderCell.setCellValue(reportEndTimeText);

	smallHeaderCell = smallHeaderRow.createCell(Number.NUMBER_7, HSSFCell.CELL_TYPE_STRING);
	smallHeaderCell.setCellValue(reportLastTimeText);

	smallHeaderCell = smallHeaderRow.createCell(Number.NUMBER_8, HSSFCell.CELL_TYPE_STRING);
	smallHeaderCell.setCellValue(reportResultText);

	smallHeaderCell = smallHeaderRow.createCell(Number.NUMBER_9, HSSFCell.CELL_TYPE_STRING);
	smallHeaderCell.setCellValue(reportOperatorText);

	smallHeaderCell = smallHeaderRow.createCell(Number.NUMBER_10, HSSFCell.CELL_TYPE_STRING);
	smallHeaderCell.setCellValue(reportSinceLastTimeText);

	smallHeaderCell = smallHeaderRow.createCell(Number.NUMBER_11, HSSFCell.CELL_TYPE_STRING);
	smallHeaderCell.setCellValue(preRinseFlushTimeText);
	smallHeaderCell = smallHeaderRow.createCell(Number.NUMBER_12, HSSFCell.CELL_TYPE_STRING);
	smallHeaderCell.setCellValue(preRinseFlowOutText);
	smallHeaderCell = smallHeaderRow.createCell(Number.NUMBER_13, HSSFCell.CELL_TYPE_STRING);
	smallHeaderCell.setCellValue(preRinseTTOutText);
	smallHeaderCell = smallHeaderRow.createCell(Number.NUMBER_14, HSSFCell.CELL_TYPE_STRING);
	smallHeaderCell.setCellValue(preRinseTTBackText);

	smallHeaderCell = smallHeaderRow.createCell(Number.NUMBER_15, HSSFCell.CELL_TYPE_STRING);
	smallHeaderCell.setCellValue(lyeCycleStartTimeText);
	smallHeaderCell = smallHeaderRow.createCell(Number.NUMBER_16, HSSFCell.CELL_TYPE_STRING);
	smallHeaderCell.setCellValue(lyeCycleEndTimeText);
	smallHeaderCell = smallHeaderRow.createCell(Number.NUMBER_17, HSSFCell.CELL_TYPE_STRING);
	smallHeaderCell.setCellValue(lyeCycleLastTimeText);
	smallHeaderCell = smallHeaderRow.createCell(Number.NUMBER_18, HSSFCell.CELL_TYPE_STRING);
	smallHeaderCell.setCellValue(lyeCycleFlowOutText);
	smallHeaderCell = smallHeaderRow.createCell(Number.NUMBER_19, HSSFCell.CELL_TYPE_STRING);
	smallHeaderCell.setCellValue(lyeCycleTTOutText);
	smallHeaderCell = smallHeaderRow.createCell(Number.NUMBER_20, HSSFCell.CELL_TYPE_STRING);
	smallHeaderCell.setCellValue(lyeCycleTTBackText);
	smallHeaderCell = smallHeaderRow.createCell(Number.NUMBER_21, HSSFCell.CELL_TYPE_STRING);
	smallHeaderCell.setCellValue(lyeCycleCTBackText);

	smallHeaderCell = smallHeaderRow.createCell(Number.NUMBER_22, HSSFCell.CELL_TYPE_STRING);
	smallHeaderCell.setCellValue(interRinseFlushTimeText);
	smallHeaderCell = smallHeaderRow.createCell(Number.NUMBER_23, HSSFCell.CELL_TYPE_STRING);
	smallHeaderCell.setCellValue(interRinseFlowOutText);
	smallHeaderCell = smallHeaderRow.createCell(Number.NUMBER_24, HSSFCell.CELL_TYPE_STRING);
	smallHeaderCell.setCellValue(interRinseTTOutText);
	smallHeaderCell = smallHeaderRow.createCell(Number.NUMBER_25, HSSFCell.CELL_TYPE_STRING);
	smallHeaderCell.setCellValue(interRinseTTBackText);

	smallHeaderCell = smallHeaderRow.createCell(Number.NUMBER_26, HSSFCell.CELL_TYPE_STRING);
	smallHeaderCell.setCellValue(acidCycleStartTimeText);
	smallHeaderCell = smallHeaderRow.createCell(Number.NUMBER_27, HSSFCell.CELL_TYPE_STRING);
	smallHeaderCell.setCellValue(acidCycleEndTimeText);
	smallHeaderCell = smallHeaderRow.createCell(Number.NUMBER_28, HSSFCell.CELL_TYPE_STRING);
	smallHeaderCell.setCellValue(acidCycleLastTimeText);
	smallHeaderCell = smallHeaderRow.createCell(Number.NUMBER_29, HSSFCell.CELL_TYPE_STRING);
	smallHeaderCell.setCellValue(acidCycleFlowOutText);
	smallHeaderCell = smallHeaderRow.createCell(Number.NUMBER_30, HSSFCell.CELL_TYPE_STRING);
	smallHeaderCell.setCellValue(acidCycleTTOutText);
	smallHeaderCell = smallHeaderRow.createCell(Number.NUMBER_31, HSSFCell.CELL_TYPE_STRING);
	smallHeaderCell.setCellValue(acidCycleTTBackText);
	smallHeaderCell = smallHeaderRow.createCell(Number.NUMBER_32, HSSFCell.CELL_TYPE_STRING);
	smallHeaderCell.setCellValue(acidCycleCTBackText);
	smallHeaderCell = smallHeaderRow.createCell(Number.NUMBER_33, HSSFCell.CELL_TYPE_STRING);

	smallHeaderCell.setCellValue(finalRinseFlushTimeText);
	smallHeaderCell = smallHeaderRow.createCell(Number.NUMBER_34, HSSFCell.CELL_TYPE_STRING);
	smallHeaderCell.setCellValue(finalRinseFlowOutText);
	smallHeaderCell = smallHeaderRow.createCell(Number.NUMBER_35, HSSFCell.CELL_TYPE_STRING);
	smallHeaderCell.setCellValue(finalRinseTTOutText);
	smallHeaderCell = smallHeaderRow.createCell(Number.NUMBER_36, HSSFCell.CELL_TYPE_STRING);
	smallHeaderCell.setCellValue(finalRinseTTBackText);

	smallHeaderCell = smallHeaderRow.createCell(Number.NUMBER_37, HSSFCell.CELL_TYPE_STRING);
	smallHeaderCell.setCellValue(sterLastTimeText);
	smallHeaderCell = smallHeaderRow.createCell(Number.NUMBER_38, HSSFCell.CELL_TYPE_STRING);
	smallHeaderCell.setCellValue(sterFlowOutText);
	smallHeaderCell = smallHeaderRow.createCell(Number.NUMBER_39, HSSFCell.CELL_TYPE_STRING);
	smallHeaderCell.setCellValue(sterTTOutText);
	smallHeaderCell = smallHeaderRow.createCell(Number.NUMBER_40, HSSFCell.CELL_TYPE_STRING);
	smallHeaderCell.setCellValue(sterTTBackText);

	int count = 1;
	int rowIndex = Number.NUMBER_3;
	for (CIPReportResult data : cipReportResultList) {
	    HSSFRow dataRow = sheet.createRow(rowIndex);
	    HSSFCell dataCell = null;
	    dataCell = dataRow.createCell(Number.NUMBER_0, HSSFCell.CELL_TYPE_NUMERIC);
	    dataCell.setCellValue(count);

	    dataCell = dataRow.createCell(Number.NUMBER_1, HSSFCell.CELL_TYPE_STRING);
	    dataCell.setCellValue(data.getCipTargetName());
	    dataCell = dataRow.createCell(Number.NUMBER_2, HSSFCell.CELL_TYPE_STRING);
	    dataCell.setCellValue(data.getCipTargetDesc());
	    dataCell = dataRow.createCell(Number.NUMBER_3, HSSFCell.CELL_TYPE_STRING);
	    dataCell.setCellValue(data.getCipSlaveLineName());
	    dataCell = dataRow.createCell(Number.NUMBER_4, HSSFCell.CELL_TYPE_STRING);
	    dataCell.setCellValue(data.getCipType());
	    dataCell = dataRow.createCell(Number.NUMBER_5, HSSFCell.CELL_TYPE_STRING);
	    dataCell.setCellValue(Tools.toDateStr(data.getCipStartDateTime()));
	    dataCell = dataRow.createCell(Number.NUMBER_6, HSSFCell.CELL_TYPE_STRING);
	    dataCell.setCellValue(Tools.toDateStr(data.getCipEndDateTime()));
	    dataCell = dataRow.createCell(Number.NUMBER_7, HSSFCell.CELL_TYPE_STRING);
	    dataCell.setCellValue(data.getCipLastTime().toString());
	    dataCell = dataRow.createCell(Number.NUMBER_8, HSSFCell.CELL_TYPE_STRING);
	    dataCell.setCellValue(data.getCipResult());
	    dataCell = dataRow.createCell(Number.NUMBER_9, HSSFCell.CELL_TYPE_NUMERIC);
	    dataCell.setCellValue(data.getCipOperatedByName());
	    dataCell = dataRow.createCell(Number.NUMBER_10, HSSFCell.CELL_TYPE_NUMERIC);
	    dataCell.setCellValue(data.getTimeSinceLastOperation());

	    dataCell = dataRow.createCell(Number.NUMBER_11, HSSFCell.CELL_TYPE_STRING);
	    dataCell.setCellValue(Tools.getValue(data.getCipPreRinseLastTime()));
	    dataCell = dataRow.createCell(Number.NUMBER_12, HSSFCell.CELL_TYPE_NUMERIC);
	    dataCell.setCellValue(Tools.getValue(data.getCipPreRinseFlowOut()));
	    dataCell = dataRow.createCell(Number.NUMBER_13, HSSFCell.CELL_TYPE_NUMERIC);
	    dataCell.setCellValue(Tools.getValue(data.getCipPreRinseTemperatureOut()));
	    dataCell = dataRow.createCell(Number.NUMBER_14, HSSFCell.CELL_TYPE_NUMERIC);
	    dataCell.setCellValue(Tools.getValue(data.getCipPreRinseTemperatureBack()));

	    dataCell = dataRow.createCell(Number.NUMBER_15, HSSFCell.CELL_TYPE_STRING);
	    dataCell.setCellValue(Tools.toDateStr(data.getCipLyeCycleStartDateTime()));
	    dataCell = dataRow.createCell(Number.NUMBER_16, HSSFCell.CELL_TYPE_STRING);
	    dataCell.setCellValue(Tools.toDateStr(data.getCipLyeCycleEndDateTime()));
	    dataCell = dataRow.createCell(Number.NUMBER_17, HSSFCell.CELL_TYPE_STRING);
	    dataCell.setCellValue(Tools.getValue(data.getCipLyeCycleLastTime()));
	    dataCell = dataRow.createCell(Number.NUMBER_18, HSSFCell.CELL_TYPE_NUMERIC);
	    dataCell.setCellValue(Tools.getValue(data.getCipLyeCycleFlowOut()));
	    dataCell = dataRow.createCell(Number.NUMBER_19, HSSFCell.CELL_TYPE_NUMERIC);
	    dataCell.setCellValue(Tools.getValue(data.getCipLyeCycleTemperatureOut()));
	    dataCell = dataRow.createCell(Number.NUMBER_20, HSSFCell.CELL_TYPE_NUMERIC);
	    dataCell.setCellValue(Tools.getValue(data.getCipLyeCycleTemperatureBack()));
	    dataCell = dataRow.createCell(Number.NUMBER_21, HSSFCell.CELL_TYPE_NUMERIC);
	    dataCell.setCellValue(Tools.getValue(data.getCipLyeCycleConductivityBack()));

	    dataCell = dataRow.createCell(Number.NUMBER_22, HSSFCell.CELL_TYPE_STRING);
	    dataCell.setCellValue(Tools.getValue(data.getCipInterRinseLastTime()));
	    dataCell = dataRow.createCell(Number.NUMBER_23, HSSFCell.CELL_TYPE_NUMERIC);
	    dataCell.setCellValue(Tools.getValue(data.getCipInterRinseFlowOut()));
	    dataCell = dataRow.createCell(Number.NUMBER_24, HSSFCell.CELL_TYPE_NUMERIC);
	    dataCell.setCellValue(Tools.getValue(data.getCipInterRinseTemperatureOut()));
	    dataCell = dataRow.createCell(Number.NUMBER_25, HSSFCell.CELL_TYPE_NUMERIC);
	    dataCell.setCellValue(Tools.getValue(data.getCipInterRinseTemperatureBack()));

	    dataCell = dataRow.createCell(Number.NUMBER_26, HSSFCell.CELL_TYPE_STRING);
	    dataCell.setCellValue(Tools.toDateStr(data.getCipAcidCycleStartDateTime()));
	    dataCell = dataRow.createCell(Number.NUMBER_27, HSSFCell.CELL_TYPE_STRING);
	    dataCell.setCellValue(Tools.toDateStr(data.getCipAcidCycleEndDateTime()));
	    dataCell = dataRow.createCell(Number.NUMBER_28, HSSFCell.CELL_TYPE_STRING);
	    dataCell.setCellValue(Tools.getValue(data.getCipAcidCycleLastTime()));
	    dataCell = dataRow.createCell(Number.NUMBER_29, HSSFCell.CELL_TYPE_NUMERIC);
	    dataCell.setCellValue(Tools.getValue(data.getCipAcidCycleFlowOut()));
	    dataCell = dataRow.createCell(Number.NUMBER_30, HSSFCell.CELL_TYPE_NUMERIC);
	    dataCell.setCellValue(Tools.getValue(data.getCipAcidCycleTemperatureOut()));
	    dataCell = dataRow.createCell(Number.NUMBER_31, HSSFCell.CELL_TYPE_NUMERIC);
	    dataCell.setCellValue(Tools.getValue(data.getCipAcidCycleTemperatureBack()));
	    dataCell = dataRow.createCell(Number.NUMBER_32, HSSFCell.CELL_TYPE_NUMERIC);
	    dataCell.setCellValue(Tools.getValue(data.getCipAcidCycleConductivityBack()));

	    dataCell = dataRow.createCell(Number.NUMBER_33, HSSFCell.CELL_TYPE_STRING);
	    dataCell.setCellValue(Tools.getValue(data.getCipFinalRinseLastTime()));
	    dataCell = dataRow.createCell(Number.NUMBER_34, HSSFCell.CELL_TYPE_NUMERIC);
	    dataCell.setCellValue(Tools.getValue(data.getCipFinalRinseFlowOut()));
	    dataCell = dataRow.createCell(Number.NUMBER_35, HSSFCell.CELL_TYPE_NUMERIC);
	    dataCell.setCellValue(Tools.getValue(data.getCipFinalRinseTemperatureOut()));
	    dataCell = dataRow.createCell(Number.NUMBER_36, HSSFCell.CELL_TYPE_NUMERIC);
	    dataCell.setCellValue(Tools.getValue(data.getCipFinalRinseTemperatureBack()));

	    dataCell = dataRow.createCell(Number.NUMBER_37, HSSFCell.CELL_TYPE_STRING);
	    dataCell.setCellValue(Tools.getValue(data.getCipSterilizeLastTime()));
	    dataCell = dataRow.createCell(Number.NUMBER_38, HSSFCell.CELL_TYPE_NUMERIC);
	    dataCell.setCellValue(Tools.getValue(data.getCipSterilizeFlowOut()));
	    dataCell = dataRow.createCell(Number.NUMBER_39, HSSFCell.CELL_TYPE_NUMERIC);
	    dataCell.setCellValue(Tools.getValue(data.getCipSterilizeTemperatureOut()));
	    dataCell = dataRow.createCell(Number.NUMBER_40, HSSFCell.CELL_TYPE_NUMERIC);
	    dataCell.setCellValue(Tools.getValue(data.getCipSterilizeTemperatureBack()));

	    count += 1;
	    rowIndex += 1;
	}

	ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
	workbook.write(byteArrayOutputStream);
	ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
	byteArrayOutputStream.close();
	return byteArrayInputStream;
    }
}
