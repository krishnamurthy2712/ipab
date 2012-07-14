package com.ipablive.services;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.StringTokenizer;

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
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.ui.RectangleInsets;

import com.ipablive.core.Home;
import com.ipablive.core.Polls;
import com.ipablive.utils.CustomToolTipGenerator;
import com.ipablive.utils.LabelGenerator;
import com.ipablive.vo.PollResultVO;
import com.ipablive.vo.TopCitiesVO;

/**
 * Servlet implementation class PollResultsChartService
 */
public class PollResultsChartService extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PollResultsChartService() 
    {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String options = request.getParameter("o");
		String poll = request.getParameter("p");
		int pollId = Integer.parseInt(poll);
		//pie chart display
		try 
		{
			DefaultPieDataset pieDataset = new DefaultPieDataset();
			StringTokenizer st = new StringTokenizer(options, "|");
			
			Polls polls = Polls.getInstance();
			//ArrayList<PollResultVO> topCities = polls.get;
			ArrayList<String> chartMembers = new ArrayList<String>();
			ArrayList<String> percentages = new ArrayList<String>();
			
			while(st.hasMoreTokens()) 
			{
				String option = st.nextToken() ;
				chartMembers.add(option);
				int totalPoll = polls.getCount(pollId,option);
				percentages.add(totalPoll+"");
			}
			
			for (int i = 0; i < chartMembers.size(); i++) 
			{
				String key = (String)chartMembers.get(i);
				double value = Double.valueOf((String)percentages.get(i)).doubleValue();
				DecimalFormat myFormat = new DecimalFormat("##.##");
				key = key + "( " + myFormat.format(value) + "% )";
				if(value != 0) 
				{
					pieDataset.setValue(key, value);
				}
			}

			JFreeChart chart = ChartFactory.createPieChart("", pieDataset, true, true, true);
			
			chart.setBackgroundPaint(new Color(255, 255, 255));
			chart.setPadding(new RectangleInsets(-28, -22,0, -8));
			
			
			
			File image = File.createTempFile("image", "tmp");
			// Assume that we have the chart
			ChartUtilities.saveChartAsPNG(image, chart,380, 195);

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
