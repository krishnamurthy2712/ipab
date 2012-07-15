package com.ipablive.services;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.entity.StandardEntityCollection;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.RectangleInsets;

import com.ipablive.core.Home;
import com.ipablive.utils.CustomToolTipGenerator;
import com.ipablive.utils.LabelGenerator;
import com.ipablive.vo.TopCitiesVO;

/**
 * Servlet implementation class DisplayTopCitiesService
 */
public class DisplayTopCitiesService extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayTopCitiesService() 
    {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
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
			
			chart.setBackgroundPaint(new Color(255, 255, 255));
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
			ChartUtilities.saveChartAsPNG(image, chart,380, 165,info,true,0);

			OutputStream outStream = null;
			FileInputStream fileInStream = new FileInputStream(image);
			try{
				outStream= response.getOutputStream();
			}
			catch(Exception e)
			{
				
			}

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
			outStream.close();

		} catch (IOException e) {
			System.err.println("Problem occurred creating chart.");
		}
	}

}
