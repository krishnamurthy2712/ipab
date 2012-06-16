<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.ArrayList"%>
<%@page import="com.ipablive.vo.CityVO"%>
<%@page import="com.ipablive.vo.DepartmentVO"%>
<%@page import="com.ipablive.commons.CommonOperations"%>
<%@page import="com.ipablive.core.IPaidBribe"%>
<%@page import="com.ipablive.vo.ReportsCountVO"%>
<%@page import="com.ipablive.vo.PaidBribesVO"%><html>
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
		href="${pageContext.request.contextPath}/theme/css/style.css"
		rel="stylesheet" />

<script type="text/javascript">

function getTransactions()
{
     // get the form values
     var dept = $('#cDept').val();
	 $.ajax({
		  type: 'GET',
		  url: 'getTransactions.jsp',
		  data: "dept=" + dept,
		  beforeSend:function(){
		    // this is where we append a loading image
		    $('#transactionsDisplay').html('<div class="loading"><img src="${pageContext.request.contextPath}/theme/images/loading.gif" alt="Loading..." /></div>');
		  },
		  success:function(response){
		    // successful request; do something with the data
		    //$('#transactionsDisplay').empty();
		    $('#transactionsDisplay').html(response);
		  },
		  error:function(){
		    // failed request; give feedback to user
		    $('#transactionsDisplay').html('<p><font color="red"><strong>Oops!</strong> Unable to load transactions.</font></p>');
		  }
	 });
}

function show_less(num)
{
	$('#more_link'+num).css('display','block');
	$('#less_link'+num).css('display','none');		
	$('#more_d_'+num).css('display','none');
	$('#less_d_'+num).fadeIn();
}

function show_more(num)
{
	$('#less_link'+num).css('display','block');
	$('#more_link'+num).css('display','none');			
	$('#less_d_'+num).css('display','none');
	$('#more_d_'+num).fadeIn();
}	
</script>

</head>
<body>
<% CommonOperations ipb = CommonOperations.getInstance(); 
	%>
<%@include file="../header.jsp" %>
<div class="pageHeader">
<center><br>
<h2 class="pageHeaderH2">I Paid a Bribe</h2>
</center>
</div>
<div id="mainContent" class="reportContent">
<% IPaidBribe ipab = IPaidBribe.getInstance();
   ReportsCountVO rptVo = ipab.getReportsCount();

%>
	<h1>Total reports: <%=rptVo.getBribeReportsCount() %> and counting...</h1>
<br>
			<form action="" method="post" name="myform">
			<fieldset>
			<legend>FILTER RESULTS</legend>
           <div><label for="cCity">County </label> <select name="cCity"
	class="sleft" id="cCity">
	<option value="">All</option>
	<%

	ArrayList<CityVO> counties = ipb.getCounties();
	 for(int i=0 ;i<counties.size();i++)
	 {	 
		 String s = (i+1) + "";
		 CityVO cvo = counties.get(i);
	%>
		<option value="<%=cvo.getId() %>"><%=cvo.getCityName()%></option>
		<%
	 }
%>
</select></div>
<div><label for="cDept">Department </label> <select
	onchange="getTransactions()" id="cDept" class="sleft">
	<option value="">All</option>
	<%
	ArrayList<DepartmentVO> depts = ipb.getDepartments();
	 for(int i=0 ;i<depts.size();i++)
	 {	 
		 DepartmentVO dVo = depts.get(i);
	%>
		<option value="<%=dVo.getDeptID() %>"><%=dVo.getDeptName()%></option>
		<%
	 }
%>
</select></div>
<div><label for="cTransaction">Transactions </label>
<div id="transactionsDisplay"></div>
</div>

	<div class="go_report">
		<input src="${pageContext.request.contextPath}/theme/images/go.png" name="go" value="Go" type="image">            
	</div>

</fieldset>
</form>
<br><br>
<% ArrayList<PaidBribesVO> pbVOs = ipab.viewPaidBribes("ALL");
  if(pbVOs.size()>0)
  {
	for(int i=0;i<pbVOs.size();i++)
	{
		PaidBribesVO pbVo = pbVOs.get(i);
%>

<div class="report_reg">
	<h2><%= pbVo.getCName() %></h2>
	<div class="report_reg_det">
		<strong>Reported :</strong> <%=pbVo.getCPaidDate() %> 
		| <strong>City :</strong> <%=pbVo.getCCity() %>
           <br /><strong>Paid On :</strong> <%=pbVo.getCCity() %> 
		| <strong><%=pbVo.getDeptName() %></strong>
	</div>

	<div class="report_reg_paid">PAID<span><%=pbVo.getCAmountPaid() %></span></div>

    <div class="clear"></div>
		<div id="more_link">
			<div class="report_reg_more">
            <a href="#" class="rad" onclick="show_more(''); return false;">Read More</a> 
            <a href="#">Add Comment</a> 
            <a href="#"><?php echo $num_comment;?> Comments</a>
            <a href="http://www.facebook.com/share.php?u=" target="_blank" class="facebook_share_view"></a>
            <a href="http://twitter.com/share?url=" target="_blank" class="tweet_share_view"></a>
            <!--<span id="count<?php echo $row->id;?>_1"><?php echo $row->count;?></span> views-->
            </div>
		</div>
	</div>
<div class="clear"></div>
<br>
<% }
}else
{
%>
<br><br><br>
<div align="center"><span><font color="red"><b>Unable to display data.</b></font></span></div>
<br><br><br>
<%} %>
</div>
<div><%@include file="sideContents.jsp"%></div>


<%@include file="../footer.jsp" %>
</body>
</html>