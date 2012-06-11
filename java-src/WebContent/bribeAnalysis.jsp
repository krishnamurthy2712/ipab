<%
	Home objHome = Home.getInstance();
	ArrayList<BribeAnalysisVO> analysis = objHome.getBribeAnalysis();
	ArrayList<TopCitiesVO> topCities = objHome.getTopCities();
%>

<%@page import="com.ipablive.core.Home"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ipablive.vo.BribeAnalysisVO"%>
<%@page import="com.ipablive.vo.TopCitiesVO"%><div class="bribe_box analytics">
<h6>Bribe Analytics</h6>
<div class="analytics_div">
<div>
<div class="analytics_div_report line">
<div><span class="ana_color">Bribe Reports</span> <%=analysis.get(0).getBribeReportsCount() %> <span
	class="ana_color">Value</span> KES. <%=analysis.get(0).getTotalAmount() %></div>
</div>
<div class="analytics_div_report"><span class="ana_color">Top
5</span> Counties(Bribe amount in '00 KES)</div>
</div>

<div class="graph">
	<ul id="graph_reports">
		<%
		if(topCities.size()>0){
			
		
		 for(int i=0; i<topCities.size();i++)
		 {
			 TopCitiesVO tvo = topCities.get(i);
			 out.println("<li><span>"+tvo.getAmountPaid()+"</span>");
			 out.println("<div style='width: "+(tvo.getAmountPaid()/100)*2+"px;'>"+ tvo.getCityName()+" </div>");
			 out.println("</li>");
		 }
		}else
		{
			%>
				<li><span><font color="red"><b>Unable to display data.</b></font></span>
			<%
		}
		%>
	</ul>
<div class="clear"></div>
</div>
<p><b><a
	href="#">Detailed
analysis of the bribes reported so far</a></b></p>
</div>
</div>