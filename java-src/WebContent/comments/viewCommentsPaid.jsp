<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.ArrayList"%>
<%@page import="com.ipablive.vo.CityVO"%>
<%@page import="com.ipablive.vo.DepartmentVO"%>
<%@page import="com.ipablive.commons.CommonOperations"%><html>
<head>
    <meta http-equiv="content-type" content="text/html;charset=utf-8" />
    <title>Bribes Registered</title>
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
</head>
<body>
<%@include file="../header.jsp" %>
<div class="pageHeader">
<center><br>
<h2 class="pageHeaderH2">Bribes Registered</h2>
</center>
</div>
<div id="mainContent" class="mainContent">

<div id="blog">
<div class="blog_container">
           
<p><a href="#" class="yellow_box">&lt;&lt; Back To Reports</a></p>
<br />
<h3>c_name;</h3>
<div class="report_reg">
        Reported : date 
        | City : city
        | Paid On : paid 
        | dept
</div>
<div class="clear"></div>
<div class="report_reg">
<table class="details_table" width="100%" summary="this table has the details for a certain report.">
    <tr>
        <th width="20%"><span class="desc_lebel">Department:</span></th>
        <td>dept name</td>
    </tr>
    <tr>
        <th><span class="desc_lebel">Transaction:</span></th>
        <td>transaction</td>
    </tr>    
    <tr>
        <th><span class="desc_lebel">Bribe Type:</span></th>
        <td>c_bribe_type</td>
    </tr>
    <tr>
        <th><span class="desc_lebel">Details:</span></th>
        <td>c_addi_info</td>
    </tr>
</table>
<div class="clear"></div>
</div>

<div class="report_reg">
<a href="addComment" class="yellow_box">Add a comment</a>
<br /><br />
</div>

</div><!-- # eof blog -->
</div><!-- #eof blog_container -->


</div> <!-- #eof blog_container -->
<%@include file="../footer.jsp" %>
</body>
</html>