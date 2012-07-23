<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.util.ArrayList"%>
<%@page import="com.ipablive.commons.CommonOperations"%>
<%@page import="com.ipablive.vo.CityVO"%>
<%@page import="com.ipablive.vo.DepartmentVO"%><html>
<head>
<meta http-equiv="content-type" content="text/html;charset=utf-8" />
<title>Success</title>

<script src="${pageContext.request.contextPath}/theme/js/jquery.js"	type="text/javascript">
	</script>
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

</head>
<body>
<%@include file="../header.jsp"%>
<div class="clear"></div>
<div id="bg-wrapper">
<div class="breadcrumb">
	<div class="clear"></div>
		<a href="${pageContext.request.contextPath}" style="text-decoration: none;">Home</a> > Post a Report Success
<center><br>
<h2 class="pageHeaderH2">Success</h2>
</center>
</div>
<div class="complaint-block-box" id="complaint-block-box">
<br><br><br>
<center><strong>Thank you for sharing your experience.</strong></center>
<br><br><br>
</div>
<%@include file="../footer.jsp"%>
</div>
</body>
</html>