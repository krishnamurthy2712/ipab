<%@page import="com.ipablive.core.Home"%>
<%@page import="com.ipablive.vo.BribeReportsVO"%>
<%@page import="java.util.ArrayList"%>

<%@page import="com.ipablive.vo.TopCitiesVO"%>
<%@page import="com.ipablive.vo.BribeCategoriesVO"%>
<%@page import="com.ipablive.vo.MostPopularReportsVO"%><div class="grid">
<h2 class="home_h2">Bribe <span>Reports</span></h2>
<div style="float: left">
<div class="tabcontent">
<ul class="tabs">
	<li class="active"><a href="#tab1"
		title="Latest Reports">Latest</a></li>
	<li class="last"><a href="#tab2"
		title="Popular Reports">Most Popular</a></li>
</ul>

<div class="tab_container">
<div style="display: block;" id="tab1" class="tab_content">
<div class="bribeReports">
<% ArrayList<BribeReportsVO> bribeReports = new ArrayList<BribeReportsVO>();
Home homeObj = Home.getInstance();

bribeReports = homeObj.getBribeReports();
if(bribeReports.size()>0)
{
	for(int i=0; i<bribeReports.size();i++)
	{
		BribeReportsVO bribeReport = bribeReports.get(i);
		%>

		<div class="bribeItems">
			<div class="popularCity">
				From <%=bribeReport.getCCity() %> | About <a
					href="http://www.ipaidabribe.or.ke/sforms/view_reports_paid?c_dept=27&amp;CSRF_TOKEN="><%=bribeReport.getCDeptName() %></a>
			</div>
			<div class="popularDate">
				<span><%=bribeReport.getFriendlyTime() %> | <%=bribeReport.getTotalViews() %> Views | <%=bribeReport.getCommentsCount() %> Comments</span>
			</div>
			<%
				String complaintName = "";
			
				if(bribeReport.getCAdditionalInfo().equals(""))
				{
					if(bribeReport.getCName().length()>120)
					{
						complaintName = bribeReport.getCName().substring(0, 116) + " ...";
					}
					else
					{
						complaintName = bribeReport.getCName();
					}
				}
				else
				{
					if(bribeReport.getCAdditionalInfo().length()>120)
					{
						complaintName = bribeReport.getCAdditionalInfo().substring(0, 116)+" ...";
					}
					else
					{
						complaintName = bribeReport.getCAdditionalInfo();
					}
				}
			%>
			<div class="popularTitle">
				<a href="${pageContext.request.contextPath}/comments/viewCommentsPaid.jsp?id=<%=bribeReport.getId() %>"><%=complaintName %> </a>
			</div>
		</div>

		<%
	}
}
else
{
	%>
	<span><font color="red"><b>Unable to display data.</b></font></span>
	<%
}
		
		%>
</div>


<div class="seeAllList">
<ul>
	<li><a title="View more"
		href="http://www.ipaidabribe.or.ke/sforms/view_reports_paid?c_city=28&amp;CSRF_TOKEN=">County-wise</a></li>
	<li><a title="View more"
		href="http://www.ipaidabribe.or.ke/sforms/view_reports_paid?c_dept=2&amp;CSRF_TOKEN=">Department-wise</a></li>
</ul>
</div>
<div class="clear"></div>

<!-- All -->

<div class="all_categories">
<div class="categoryHead">Top Bribe Categories:</div>
<div class="categoryList">
<%
ArrayList<BribeCategoriesVO> topCategories = homeObj.getTopBribeCategories();
if(topCategories.size()>0)
{
	for(int i=0; i<topCategories.size(); i++)
	{
		BribeCategoriesVO topCategory = topCategories.get(i);
	%>
	<a href="#/view_reports_paid?c_dept=<%=topCategory.getCDept() %>"><%=topCategory.getDeptName() %></a>
	<%
		if(i>0) 
		{
			%>|<%
		}
	}
}

%>
</div>
</div>

</div>
<div style="display: none;" id="tab2" class="tab_content">
<div class="bribeReports">

<%
ArrayList<MostPopularReportsVO> popular = homeObj.getMostPopularReports();

if(popular.size()>0)
	for(int j=0;j<popular.size();j++)
	{
		MostPopularReportsVO pvo = popular.get(j);
		%>
		<div class="bribeItems">
			<div class="popularCity">From <% %> | About <a
				href="http://www.ipaidabribe.or.ke/sforms/view_reports_paid?c_dept=27&amp;CSRF_TOKEN="><%=pvo.getDeptName() %></a></div>
			<div class="popularDate"><span><%=pvo.getFriendlyTime() %> | <%=pvo.getTotalViews() %> Views | <%=pvo.getCommentsCount() %> Comments</span></div>
			<div class="popularTitle"><a
				href="http://www.ipaidabribe.or.ke/sforms/view_comments_paid?id=807&amp;CSRF_TOKEN=">
			<%=pvo.getAddInfo() %> </a></div>
			</div>
		<div class="clear"></div>
		<%

	}
	
 
%>

</div>
<div class="seeAllList">
<ul>
	<li><a title="View more"
		href="http://www.ipaidabribe.or.ke/sforms/view_reports_paid?CSRF_TOKEN=">See
	all</a></li>
	<li><a title="View more"
		href="http://www.ipaidabribe.or.ke/sforms/view_reports_paid?c_dept=2&amp;CSRF_TOKEN=">Department-wise</a></li>
</ul>
</div>
<div class="clear"></div>

<div class="all_categories">
<div class="categoryHead">Top Bribe Categories:</div>
<div class="categoryList">
<%

if(topCategories.size()>0)
{
	for(int i=0; i<topCategories.size(); i++)
	{
		BribeCategoriesVO topCategory = topCategories.get(i);
	%>
	<a href="#/view_reports_paid?c_dept=<%=topCategory.getCDept() %>"><%=topCategory.getDeptName() %></a>
	<%
		if(i>0) 
		{
			%>|<%
		}
	}
}

%>

</div>
</div>
</div>
</div>
</div>

</div>

<div class="clear"></div>
<!----- Break -----> <!--<div class="ask_box">
        <h2 class="home_h2"></h2>
     
    </div>-->
<div class="clear"></div>

</div>
<!--#End Gird 1-->
