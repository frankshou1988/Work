package com.tetrapak.util.cip;

import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import javax.imageio.ImageIO;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.time.Second;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;

import com.tetrapak.domain.cip.CIPTrendTag;
import com.tetrapak.metaclass.TagQueryResult;
import com.tetrapak.metaclass.TagQueryUtil;
import com.tetrapak.util.common.Tools;

public class CIPTrendReportUtil {
    public static byte[] getCIPTrendAnalogGraphData(String title, List<TagQueryResult> tagQueryResultList)
	    throws ParseException, IOException {
	TimeSeriesCollection analogDataSet = new TimeSeriesCollection();
	for (TagQueryResult tagQueryResult : tagQueryResultList) {
	    CIPTrendTag tag = tagQueryResult.getTag();
	    Set<Entry<String, String>> entrySet = tagQueryResult.getTagValue().entrySet();
	    @SuppressWarnings("deprecation")
	    TimeSeries spring = new TimeSeries(tag.getCipTrendTagDesc() + "(" + tag.getCipTrendTagUnit() + ")",
		    Second.class);
	    for (Entry<String, String> entry : entrySet) {
		String timestamp = entry.getKey();
		String value = TagQueryUtil.formatNumber(Double.parseDouble(entry.getValue())
			/ tagQueryResult.getTag().getCipTrendTagValueDividedBy());
		Calendar c = Tools.toDate(timestamp);
		spring.add(new Second(c.getTime()), Double.parseDouble(value));
	    }
	    analogDataSet.addSeries(spring);
	}
	JFreeChart chart = ChartFactory.createTimeSeriesChart(title, "", "", analogDataSet, true, false, false);

	LegendTitle legend = chart.getLegend(0);
	Font titleFont = new Font("宋体", Font.BOLD, 14);
	legend.setItemFont(titleFont);
	chart.setTitle(new TextTitle(title, titleFont));
	XYPlot plot = (XYPlot) chart.getPlot();
	Font dataFont = new Font("宋体", Font.BOLD, 12);

	ValueAxis categoryAxis = plot.getDomainAxis();
	categoryAxis.setLabelFont(dataFont);
	categoryAxis.setTickLabelFont(dataFont);

	XYPlot xyplot = (XYPlot) chart.getPlot();

	DateAxis dateaxiss = (DateAxis) xyplot.getDomainAxis();
	SimpleDateFormat frm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	dateaxiss.setDateFormatOverride(frm);

	BufferedImage objBufferedImage = chart.createBufferedImage(820, 550);
	ByteArrayOutputStream bas = new ByteArrayOutputStream();
	ImageIO.write(objBufferedImage, "png", bas);

	byte[] byteArray = bas.toByteArray();
	return byteArray;

    }
}
