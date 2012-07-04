
<%@page import="com.ipablive.utils.LabelGenerator"%><%@page import="com.ipablive.utils.CustomToolTipGenerator"%>
<%@page import="org.jfree.chart.labels.CategoryToolTipGenerator"%>
<%@page import="org.jfree.ui.VerticalAlignment"%>
<%@page import="org.jfree.ui.RectangleEdge"%>
<%@page import="org.jfree.chart.title.LegendTitle"%>
<%@page import="java.awt.Font"%>
<%@page import="org.jfree.chart.labels.ItemLabelPosition"%>
<%@page import="org.jfree.chart.labels.ItemLabelAnchor"%>
<%@page import="org.jfree.ui.TextAnchor"%>
<%@page import="org.jfree.chart.labels.StandardCategoryItemLabelGenerator"%>
<%@page import="org.jfree.ui.RectangleInsets"%>
<%@page import="java.awt.Insets"%>
<%@page import="org.jfree.chart.ChartColor"%>
<%@page import="org.jfree.chart.entity.StandardEntityCollection"%>
<%@page import="org.jfree.chart.ChartRenderingInfo"%>
<%@page import="org.jfree.chart.renderer.category.BarRenderer"%>
<%@page import="java.awt.Color"%>
<%@page import="java.awt.GradientPaint"%><%@page import="com.ipablive.vo.TopCitiesVO"%>
<%@page import="com.ipablive.core.Home"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.jfree.chart.axis.CategoryLabelPositions"%>
<%@page import="org.jfree.chart.axis.CategoryAxis"%>
<%@page import="org.jfree.chart.plot.CategoryPlot"%>
<%@page import="org.jfree.chart.plot.PlotOrientation"%>
<%@page import="org.jfree.data.category.DefaultCategoryDataset"%>
<%@page import="org.jfree.chart.ChartFactory"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*"%>
<%@ page import="org.jfree.chart.JFreeChart"%>
<%@ page import="org.jfree.chart.ChartUtilities"%>

<%
	try 
	{
		Home objHome = Home.getInstance();
		ArrayList<TopCitiesVO> topCities = objHome.getTopCities();
		
		DefaultCategoryDataset dataset;
		ArrayList<String> seriesMembers = new ArrayList<String>();
		ArrayList<String> categoryMembers = new ArrayList<String>();
		ArrayList<Integer> data = new ArrayList<Integer>();

		if(topCities.size()>0)
		{
			for(int i=0; i<topCities.size();i++)
			{
				 TopCitiesVO tvo = topCities.get(i);
				 seriesMembers.add(tvo.getCityName());
				 data.add(tvo.getAmountPaid());
			}
		}

		categoryMembers.add("");

		int count = 0;
		dataset = new DefaultCategoryDataset();
		for (int i = 0; i < seriesMembers.size(); i++) 
		{
			dataset.addValue(Double.valueOf(
					(Integer) data.get(count)).doubleValue(),
					(String) seriesMembers.get(i),
					(String) categoryMembers.get(0));
			count++;
		}

		JFreeChart chart = ChartFactory.createBarChart("", // chart title
				"", // domain axis label
				"", // range axis label
				dataset, // data
				PlotOrientation.HORIZONTAL, // orientation
				false, // include legend
				false, // tooltips?
				true // URLs?
				);
		
		chart.setBackgroundPaint(new Color(237, 194, 90));
		chart.setPadding(new RectangleInsets(-28, -22,0, -8));
		
		/*LegendTitle legend  = chart.getLegend();
        legend.setPosition(RectangleEdge.RIGHT);
        legend.setVerticalAlignment(VerticalAlignment.BOTTOM);
        legend.setBackgroundPaint(new Color(237, 194, 90));*/
        
		CategoryPlot plot = chart.getCategoryPlot();
		plot.setBackgroundPaint(new Color(237, 194, 90));
		plot.setBackgroundAlpha(0);
		
		plot.setDomainGridlinesVisible(false);
		plot.setRangeGridlinesVisible(false);
		//plot.setInsets(new RectangleInsets(25, 0, 0, 25));
		//plot.setWeight(10);
		
		CategoryAxis domainAxis = plot.getDomainAxis();
		
		//GradientPaint gradientpaint0 = new GradientPaint(0.0F, 0.0F,new Color(209, 228, 246), 0.0F, 0.0F, new Color(82, 141, 201));
		BarRenderer r = (BarRenderer)chart.getCategoryPlot().getRenderer();
		//r.setSeriesPaint(0, gradientpaint0);
		r.setBaseItemLabelGenerator(new LabelGenerator());
		r.setBaseItemLabelsVisible(true);
		r.setBaseItemLabelFont(new Font("SanSerif", Font.PLAIN, 9)); 
	    //r.setPositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.INSIDE12, TextAnchor.CENTER_RIGHT));
	    r.setItemLabelAnchorOffset(2);
	    r.setItemLabelPaint(Color.BLACK);
	    r.setSeriesToolTipGenerator(0,new CustomToolTipGenerator());

		ChartRenderingInfo info = null;
		info = new ChartRenderingInfo(new StandardEntityCollection());
		
		domainAxis.setCategoryLabelPositions(CategoryLabelPositions.createUpRotationLabelPositions(Math.PI / 6.0));
		File image = File.createTempFile("image", "tmp");
		domainAxis.setTickMarksVisible(true);  
		// Assume that we have the chart
		ChartUtilities.saveChartAsPNG(image, chart,310, 145,info,true,0);

		FileInputStream fileInStream = new FileInputStream(image);
		OutputStream outStream = response.getOutputStream();

		long fileLength;
		byte[] byteStream;

		fileLength = image.length();
		byteStream = new byte[(int) fileLength];
		fileInStream.read(byteStream, 0, (int) fileLength);

		response.setContentType("image/png");
		response.setContentLength((int) fileLength);
		response.setHeader("Cache-Control",
						"no-store,no-cache, must-revalidate, post-check=0, pre-check=0");
		response.setHeader("Pragma", "no-cache");

		fileInStream.close();
		outStream.write(byteStream);
		outStream.flush();
		//outStream.close();

	} catch (IOException e) {
		System.err.println("Problem occurred creating chart.");
	}
%>