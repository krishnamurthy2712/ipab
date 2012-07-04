<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.ArrayList"%>
<%@page import="com.ipablive.vo.CityVO"%>
<%@page import="com.ipablive.vo.DepartmentVO"%>
<%@page import="com.ipablive.commons.CommonOperations"%>
<%@page import="com.ipablive.core.IDidnotPaid"%>
<%@page import="com.ipablive.vo.ReportsCountVO"%>
<%@page import="com.ipablive.vo.DidNotPaidBribesVO"%><html>
<head>
    <meta http-equiv="content-type" content="text/html;charset=utf-8" />
    <title>Bribe Reports: 'I Din't Pay a Bribe' Reports | I PAID A BRIBE</title>
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

$(document).ready(function() {
	
    //Default Action
    $(".tab_content").hide(); //Hide all content
    $("ul.tabs li:first").addClass("active").show(); //Activate first tab
    $(".tab_content:first").show(); //Show first tab content
    
    //On Click Event
    $("ul.tabs li").click(function() {
        $("ul.tabs li").removeClass("active"); //Remove any "active" class
        $(this).addClass("active"); //Add "active" class to selected tab
        $(".tab_content").hide(); //Hide all tab content
        var activeTab = $(this).find("a").attr("href"); //Find the rel attribute value to identify the active tab + content
        $(activeTab).fadeIn(); //Fade in the active content
        return false;
    });

});

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
	<div class="pageHeader">
		<center><br>
		<h2 class="pageHeaderH2">I Din't Pay a Bribe</h2>
		</center>
	</div>

	<div id="mainContent" class="reportContent">
		<% IDidnotPaid  iDidntPay = IDidnotPaid.getInstance();
		   ReportsCountVO rptVo = iDidntPay.getReportsCount();
		
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
		
		<% 
			String display = "";
		  	String readMore = "";
		  
			ArrayList<DidNotPaidBribesVO> bribes = iDidntPay.viewDintPay("ALL");
			if(bribes.size()>0)
			{
				for(int i=0;i<bribes.size();i++)
				{
					DidNotPaidBribesVO bribe = bribes.get(i);
					if(i==0)	
					{
						display = "style='display:block;'";
						readMore = "style='display:none;'";
					}
					else
					{
						display = "style='display:none;'";
						readMore = "style='display:block;'";
					}
		%>
		 <div class="report_reg">
			<h2><%=bribe.getCName() %></h2>
			<div class="report_reg_det">
					<strong>Reported :</strong> <%=bribe.getCreatedDate() %>  
					| <strong>City :</strong> <%=bribe.getCCity() %> 
					| <strong><%=bribe.getCDept() %></strong>
			</div>
			<div id="more_link<%=bribe.getId() %>" <%=readMore %>>
			<div class="report_reg_more">
	            <a href="#" class="rad" onclick="show_more('<%=bribe.getId() %>'); return false;">Read More</a> 
	            <a href="javaScript: addComment('<%=bribe.getId() %>','notpaid')">Add Comment</a> 
	            <a href="${pageContext.request.contextPath}/comments/viewCommentsDidntPaid.jsp?id=<%=bribe.getId() %>"><%=bribe.getNumComments() %> Comments</a>
	            <a href="http://www.facebook.com/share.php?u=" target="_blank" class="facebook_share_view"></a>
	            <a href="http://twitter.com/share?url=" target="_blank" class="tweet_share_view"></a>
	            <!--<span id="count<?php echo $row->id;?>_1"><?php echo $row->count;?></span> views-->
            </div>
		</div>

		<div id="more_d_<%=bribe.getId() %>" <%=display %> >
				<table class="details_table" width="100%" summary="this table has the details for a certain report.">
					<tr>
				    	<th width="20%"><span class="desc_lebel">Department:</span></th>
				        <td><%=bribe.getDeptName() %></td>
				    </tr>
					<tr>
				    	<th><span class="desc_lebel">Office Location:</span></th>
				        <td><%=bribe.getOtherLocation()%></td>
				    </tr>
					<tr>
				    	<th><span class="desc_lebel">Transaction:</span></th>
				        <td><%=bribe.getTransName() %></td>
				    </tr>    
					<tr>
				    	<th><span class="desc_lebel">Bribe Type:</span></th>
				        <td><%=bribe.getCBribeResistedBy() %></td>
				    </tr>
					<tr>
				    	<th><span class="desc_lebel">Details:</span></th>
				        <td><%=bribe.getCAdditionalInfo() %></td>
				    </tr>
				</table>
                <div class="clear"></div>

				<div class="share_tool_d">
				<div id="less_link<%=bribe.getId() %>">
				<div class="report_reg_more">
					<a href="#" class="rad" onclick="show_less('<%=bribe.getId() %>'); return false;">Read less...</a> 
					<a href="javaScript: addComment('<%=bribe.getId() %>','notpaid')">Add Comment</a> 
		            <a href="${pageContext.request.contextPath}/comments/viewCommentsDidntPaid.jsp?id=<%=bribe.getId() %>"><%=bribe.getNumComments() %> Comments</a>
		            <a href="http://www.facebook.com/share.php?u=" target="_blank" class="facebook_share_view"></a>
		            <a href="http://twitter.com/share?url=" target="_blank" class="tweet_share_view"></a>
		            <!--<span id="count<?php echo $row->id;?>_1"><?php echo $row->count;?></span> views-->
				</div>
				</div>
			</div>
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
		
	
</div>
<div><%@include file="sideContents.jsp"%></div>


<%@include file="../footer.jsp" %>
</body>
</html>