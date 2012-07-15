<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.ArrayList"%>
<%@page import="com.ipablive.vo.CityVO"%>
<%@page import="com.ipablive.vo.DepartmentVO"%>
<%@page import="com.ipablive.commons.CommonOperations"%>
<%@page import="com.ipablive.core.IPaidBribe"%>
<%@page import="com.ipablive.vo.ReportsCountVO"%>
<%@page import="com.ipablive.vo.PaidBribesVO"%>
<%@page import="com.ipablive.vo.DidNotPaidBribesVO"%>
<%@page import="com.ipablive.vo.DontHavetoPayVO"%>
<%@page import="com.ipablive.core.IDidnotPaid"%>
<%@page import="com.ipablive.core.IDontHavetoPay"%><html>
<head>
    <meta http-equiv="content-type" content="text/html;charset=utf-8" />
    <title>Bribe Reports: 'I Paid a Bribe' Reports | I PAID A BRIBE</title>
	<script src="${pageContext.request.contextPath}/theme/js/jquery.js"
		type="text/javascript">
		</script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/theme/js/menu.js"></script>
	
	<script
		src="${pageContext.request.contextPath}/theme/js/jquery.ui.core.js"></script>
	<script
		src="${pageContext.request.contextPath}/theme/js/jquery.ui.widget.js"></script>
	<script
		src="${pageContext.request.contextPath}/theme/js/jquery.ui.datepicker.js"></script>
	
	<link type="text/css"
		href="${pageContext.request.contextPath}/theme/css/menu.css"
		rel="stylesheet" />
	<link type="text/css"
		href="${pageContext.request.contextPath}/theme/css/newstyles.css"
		rel="stylesheet" />

<script type="text/javascript">

	function addComment(typeId,type)
	{
		//var url = "/addComment.jsp?typeId="+typeId+"&type="+type+"&subject="+subject;
		var url = "${pageContext.request.contextPath}/comments/addComment.jsp?p="+typeId+"&t="+type;
		window.location.href = url;
		
	}
	
</script>
</head>
<body>
<% CommonOperations ipb = CommonOperations.getInstance(); 
	%>
<%@include file="../header.jsp" %>
<div class="clear"></div>
<div id="bg-wrapper">
	<div class="breadcrumb">
		<div class="clear"></div>
			<a href="${pageContext.request.contextPath}" style="text-decoration: none;">Home</a> > Bribe Reports
	<center><br>
	<h2 class="pageHeaderH2">Bribe Reports</h2>
	</center>
	</div>
	<% IPaidBribe ipab = IPaidBribe.getInstance();
	   IDidnotPaid ipab2 = IDidnotPaid.getInstance();
	   IDontHavetoPay ipab3 = IDontHavetoPay.getInstance();
	   
	   ReportsCountVO rptVo = ipab.getReportsCount();
	
	%>

<!--side contents first	-->
<div class="clear"></div>
<div class="reports_sidebar">
	<%@include file="../toolkit.jsp" %>
	<%@include file="../tweets.jsp" %>
<div class="clear"></div>
<div class="clear"></div>
	<div id="toolkit_bg_reports">
<%@include file="../polls/todayPoll.jsp" %>
	</div>
</div>

	<!--report main content - IPAID -->
<div class="allReportDisplay">
<h2>I Paid a Bribe</h2>
		<% ArrayList<PaidBribesVO> pbVOs = ipab.viewPaidBribes(3);
		  if(pbVOs.size()>0)
		  {
			for(int i=0;i<pbVOs.size();i++)
			{
				PaidBribesVO pbVo = pbVOs.get(i);
				
		%>
		
		
		<div class="all-report-block-box">
			<h2><%= pbVo.getCName() %></h2>
			<table class="details_table" width="100%" summary="this table has the details for a certain report.">
				<tr>
			    	<th align="left" style="width: 100px;"><span >Department:</span></th>
			        <td align="left"><%=pbVo.getDeptName() %></td>
			    </tr>
				<tr>
			    	<th align="left" style="width: 100px;"><span >Office Location:</span></th>
			        <td align="left"><%=pbVo.getOtherLocation()%></td>
			    </tr>
				<tr>
			    	<th align="left" style="width: 100px;"><span >Transaction:</span></th>
			        <td align="left"><%=pbVo.getTransName() %></td>
			    </tr>    
				<tr>
			    	<th align="left" style="width: 100px;"><span >Bribe Type:</span></th>
			        <td align="left"><%=pbVo.getCBribeType() %></td>
			    </tr>
				<tr>
			    	<th align="left" style="width: 100px;"><span >Details:</span></th>
			        <td align="left"><%=pbVo.getCAdditionalInfo() %></td>
			    </tr>
			</table>
			<div class="report_reg_more" align="right">
		           <a href="${pageContext.request.contextPath}/comments?t=paid&id=<%=pbVo.getId() %>"><%=pbVo.getNumComments() %> Comments</a>
		           <a href="http://www.facebook.com/share.php?u=" target="_blank" class="facebook_share_view"></a>
		           <a href="http://twitter.com/share?url=" target="_blank" class="tweet_share_view"></a>
			</div>
			<div class="clear"></div><div class="clear"></div>

</div>
<% }
}else
{
%>
<div class="clear"></div>
<div align="center"><span><font color="red"><b>No reports to be displayed for selected criteria.</b></font></span></div>
<div class="clear"></div>
<%} %>
<div class="divContent" align="right"><a href="${pageContext.request.contextPath}/reports?t=paid">Read More	Reports</a></div>
</div>

<!--report content - IDIDNT PAID-->
<div class="allReportDisplay">	
<h2>I Didn't pay a Bribe</h2>
		<% 
		  
			ArrayList<DidNotPaidBribesVO> bribes = ipab2.viewDintPay(3);
			if(bribes.size()>0)
			{
				for(int i=0;i<bribes.size();i++)
				{
					DidNotPaidBribesVO didntbribe = bribes.get(i);
		%>
		 <div class="all-report-block-box">
			<h2><%=didntbribe.getCName() %></h2>
			<table class="details_table" width="100%" summary="this table has the details for a certain report.">
		<tr>
	    	<th align="left" style="width: 100px;"><span >Department:</span></th>
	        <td align="left"><%=didntbribe.getDeptName() %></td>
	    </tr>
		<tr>
	    	<th align="left" style="width: 100px;"><span >Office Location:</span></th>
	        <td align="left"><%=didntbribe.getOtherLocation()%></td>
	    </tr>
		<tr>
	    	<th align="left" style="width: 100px;"><span >Transaction:</span></th>
	        <td align="left"><%=didntbribe.getTransName() %></td>
	    </tr>    
		<tr>
	    	<th align="left" style="width: 100px;"><span >Bribe Type:</span></th>
	        <td align="left"><%=didntbribe.getCBribeResistedBy() %></td>
	    </tr>
		<tr>
	    	<th align="left" style="width: 100px;"><span >Details:</span></th>
	        <td align="left"><%=didntbribe.getCAdditionalInfo() %></td>
	    </tr>
	</table>
	<div class="report_reg_more" align="right">
           <a href="${pageContext.request.contextPath}/comments?t=notpaid&id=<%=didntbribe.getId() %>"><%=didntbribe.getNumComments() %> Comments</a>
           <a href="http://www.facebook.com/share.php?u=" target="_blank" class="facebook_share_view"></a>
           <a href="http://twitter.com/share?url=" target="_blank" class="tweet_share_view"></a>
	</div>

	<div class="clear"></div>

	</div>
<div class="clear"></div>

		<% 
				}
			}
			else
			{
			%>
			<br><br><br>
			<div align="center"><span><font color="red"><b>Unable to display data.</b></font></span></div>
			<br><br><br>
			<%} %>
		
<div class="divContent" align="right"><a href="${pageContext.request.contextPath}/reports?t=notpaid">Read More	Reports</a></div>	
</div>

<!--report content - I DONT HAVE TO PAY-->
	<!--report main content-->
<div class="allReportDisplay">
<h2>I Didn't Have to be pay a Bribe</h2>
<%

	ArrayList<DontHavetoPayVO> bribes1 = ipab3.viewDintHaveToPay(3);
	if(bribes1.size()>0)
	{
	  	
		for(int i=0;i<bribes1.size();i++)
		{
			DontHavetoPayVO didntHavetoBribe = bribes1.get(i);
			
%>
 <div class="all-report-block-box">
	<h2><%=didntHavetoBribe.getCName() %></h2>
	<table class="details_table" width="100%" summary="this table has the details for a certain report.">
		<tr>
	    	<th align="left" style="width: 100px;"><span >Department:</span></th>
	        <td align="left"><%=didntHavetoBribe.getDeptName() %></td>
	    </tr>
		<tr>
	    	<th align="left" style="width: 100px;"><span >Office Location:</span></th>
	        <td align="left"><%=didntHavetoBribe.getOtherLocation()%></td>
	    </tr>
		<tr>
	    	<th align="left" style="width: 100px;"><span >Transaction:</span></th>
	        <td align="left"><%=didntHavetoBribe.getTransName() %></td>
	    </tr>    
		<tr>
	    	<th align="left" style="width: 100px;"><span >Bribe Type:</span></th>
	        <td align="left"><%=didntHavetoBribe.getCBribeResistedBy() %></td>
	    </tr>
		<tr>
	    	<th align="left" style="width: 100px;"><span >Details:</span></th>
	        <td align="left"><%=didntHavetoBribe.getCAdditionalInfo() %></td>
	    </tr>
	</table>
	<div class="report_reg_more" align="right">
           <a href="${pageContext.request.contextPath}/comments?t=notasked&id=<%=didntHavetoBribe.getId() %>"><%=didntHavetoBribe.getNumComments() %> Comments</a>
           <a href="http://www.facebook.com/share.php?u=" target="_blank" class="facebook_share_view"></a>
           <a href="http://twitter.com/share?url=" target="_blank" class="tweet_share_view"></a>
	</div>

<div class="clear"></div>

	</div>
<div class="clear"></div>
<% 
	
	}
	}
	else
	{
	%>
		<br><br><br>
		<div align="center"><span><font color="red"><b>Unable to display data.</b></font></span></div>
		<br><br><br>
	<%} %>
<div class="divContent" align="right"><a href="${pageContext.request.contextPath}/reports?t=notasked">Read More	Reports</a></div>
</div>


<%@include file="../footer.jsp" %>
</div>
</body>
</html>