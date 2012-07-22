<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.ArrayList"%>
<%@page import="com.ipablive.vo.CityVO"%>
<%@page import="com.ipablive.vo.DepartmentVO"%>
<%@page import="com.ipablive.commons.CommonOperations"%>
<%@page import="com.ipablive.core.Blogs"%>
<%@page import="com.ipablive.vo.BlogPostVO"%><html>
<head>
    <meta http-equiv="content-type" content="text/html;charset=utf-8" />
    <title>Blog</title>
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
</script>
</head>
<body>
<%@include file="../../header.jsp" %>
<div class="clear"></div>
<div id="bg-wrapper">
	<div class="breadcrumb">
		<div class="clear"></div>
			<a href="${pageContext.request.contextPath}" style="text-decoration: none;">Home</a> > Delete Post
	<center><br>
	<h2 class="pageHeaderH2">Blogs - Admin</h2>
	</center>
	</div>
<%
String p = request.getParameter("p");
int postId = Integer.parseInt(p);
Boolean isDeleted = false;
if(isDeleted)
{
	response.sendRedirect("./admin?cmd=blogs");
}else
{
	out.println("<center><font color='red'><b>Unable to delete.</b></font></center>");
}

%>
<%@include file="../../footer.jsp" %>
</div>
</body>
</html>
