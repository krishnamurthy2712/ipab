<%
	Home objHome = Home.getInstance();
	ArrayList<BribeAnalysisVO> analysis = objHome.getBribeAnalysis();
	ArrayList<TopCitiesVO> topCities = objHome.getTopCities();
%>

<%@page import="com.ipablive.core.Home"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ipablive.vo.BribeAnalysisVO"%>
<%@page import="com.ipablive.vo.TopCitiesVO"%>
<%@page import="java.util.Date"%><div class="bribe_box analytics">
<center><font color="#003322" size="7"><b>Bribe Analytics</b></font></center><br>
<div class="analytics_div">
<div>
<div class="analytics_div_report line">
<div><span class="ana_color">Bribe Reports</span> <%=analysis.get(0).getBribeReportsCount() %> <span
	class="ana_color">Value</span> GHS. <%=analysis.get(0).getTotalAmount() %></div>
</div>
<div class="analytics_div_report"><span class="ana_color">Top
5</span> Counties(Bribe amount in '00 GHS)</div>
</div>

<div class="graph">
	<%
	String chartPath = "displayTopCities.jsp?timeStamp="+new Date().getTime();
	%>
<img src="<%=chartPath %>" alt="topCities" style="width: 300; height: 180;">
<div class="clear"></div>
</div>
<p><b><a
	href="#">Detailed
analysis of the bribes reported so far</a></b></p>
</div>
</div>