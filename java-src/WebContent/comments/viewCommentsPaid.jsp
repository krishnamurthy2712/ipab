<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.ArrayList"%>
<%@page import="com.ipablive.vo.CityVO"%>
<%@page import="com.ipablive.vo.DepartmentVO"%>
<%@page import="com.ipablive.commons.CommonOperations"%>
<%@page import="com.ipablive.core.IPaidBribe"%>
<%@page import="com.ipablive.vo.PaidBribesVO"%>
<%@page import="java.text.SimpleDateFormat"%><html>
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
<script type="text/javascript">
function addComment(typeId,type)
{
	//var url = "/addComment.jsp?typeId="+typeId+"&type="+type+"&subject="+subject;
	var url = "${pageContext.request.contextPath}/comments/addComment.jsp?tId=1&t="+type;
	window.location.href = url;
	
}
</script>
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
           
<p><a href="${pageContext.request.contextPath}/readbribestory/ipaid.jsp" class="yellow_box">&lt;&lt; Back To Reports</a></p>
<br />
<%
	String strId = request.getParameter("id");

	if(strId != null)
	{
		int id = Integer.parseInt(strId);
		IPaidBribe ipab = IPaidBribe.getInstance();
		PaidBribesVO pbVO = ipab.viewDetailPaidBribes(id);
		SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy - hh:mm"); 
%>
<h3><%=pbVO.getCName() %></h3>
<div class="report_reg">
        Reported : <%=sdf.format(pbVO.getCreatedDate()) %> 
        | City : <%=pbVO.getCCity() %>
        | Paid On : <%=sdf.format(pbVO.getCPaidDate()) %> 
        | <%=pbVO.getDeptName() %>
</div>
<br>
<div class="clear"></div>
<div class="report_reg">
<table class="details_table" width="100%" summary="this table has the details for a certain report.">
    <tr>
        <th width="20%"><span class="desc_lebel">Department:</span></th>
        <td><%=pbVO.getDeptName() %></td>
    </tr>
    <tr>
        <th><span class="desc_lebel">Transaction:</span></th>
        <td><%=pbVO.getTransName() %></td>
    </tr>    
    <tr>
        <th><span class="desc_lebel">Bribe Type:</span></th>
        <td><%=pbVO.getCBribeType() %></td>
    </tr>
    <tr>
        <th><span class="desc_lebel">Details:</span></th>
        <td><%=pbVO.getCAdditionalInfo() %></td>
    </tr>
<tr><td>   </td></tr>
<tr><td><div class="report_reg"><a href="javaScript: addComment('','paid')" class="yellow_box">Add a comment</a></div></td></tr>
</table>
	<%}
	else
	{
		%>
		asdf
		<%
	}
	%>
<div class="clear"></div>
</div>

</div><!-- # eof blog -->
</div><!-- #eof blog_container -->
</div> <!-- #eof blog_container -->
<%@include file="../footer.jsp" %>
</body>
</html>