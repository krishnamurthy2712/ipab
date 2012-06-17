<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.ArrayList"%>
<%@page import="com.ipablive.vo.CityVO"%>
<%@page import="com.ipablive.vo.DepartmentVO"%>
<%@page import="com.ipablive.commons.CommonOperations"%><html>
<head>
    <meta http-equiv="content-type" content="text/html;charset=utf-8" />
    <title>Contact Us</title>
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
<h2 class="pageHeaderH2">Contact Us</h2>
</center>
</div>
<div id="mainContent" class="mainContent">
<div id="blog">
    <div class="blog_container contact_ipab">
<div><div class="contact">
	<p>
		<span>I Paid A Bribe</span><br />
		<span> xxxxxx</span></p>
	<p>
		xxxx,</p>
	<p>
		xxxx,</p>
	<p>
		xxxxxxxx.</p>
	<p>
		Phone:&nbsp;&nbsp;&nbsp; +123 1234567890<br />
		Website: <a href="http://www.ipaidabribe.or.ke" title="Website">www.ipaidabribe.or.ke</a><br />
		Email:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href="mailto:info@ipaidabribe.or.ke" title="E-mail">info@ipaidabribe.or.ke</a></p>
</div>
</div>
<br>
<br>
<div align="center" style="width: 100%;">
<font color="#0099FF">Thank you for showing interest to contact us.</font>
<br>
We received your message and we will get back to you soon
<br>
<br>
--------<br>
IPAB team.
</div>
</div>
</div>
</div>
<%@include file="../footer.jsp" %>
</body>
</html>