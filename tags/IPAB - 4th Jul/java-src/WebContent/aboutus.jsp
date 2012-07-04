<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.ArrayList"%>
<%@page import="com.ipablive.vo.CityVO"%>
<%@page import="com.ipablive.vo.DepartmentVO"%>
<%@page import="com.ipablive.commons.CommonOperations"%><html>
<head>
    <meta http-equiv="content-type" content="text/html;charset=utf-8" />
    <title>About Us</title>
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
<h2 class="pageHeaderH2">About I Paid a Bribe</h2>
</center>
</div>
<div id="mainContent" class="mainContent">
<p >
	<a href="http://www.ipaidabribe.or.ke/" style="text-decoration: none; font-size: 12px; color: rgb(155, 27, 27);" title="www.ipaidabribe.or.ke"><strong>www.ipaidabribe.or.ke</strong><span class="Apple-converted-space"> </span></a>is
 Wamani Trust's unique initiative to tackle corruption by harnessing the
 collective energy of citizens. You can report on the nature, number, 
pattern, types, location, frequency and values of actual corrupt acts on
 this website. Your reports will, perhaps for the first time, provide a 
snapshot of bribes occurring across your city. We will use them to argue
 for improving governance systems and procedures, tightening law 
enforcement and regulation and thereby reduce the scope for corruption 
in obtaining services from the government.</p>
<p >
	&nbsp;</p>
<p >
	We invite you to register any recent or old bribes you have paid. 
Please tell us if you resisted a demand for a bribe, or did not have to 
pay a bribe, because of a new procedure or an honest official who helped
 you. We do not ask for your name or phone details, so feel free to 
report on the formats provided.</p>
<p>
	<img src="${pageContext.request.contextPath}/theme/images/ipabProcess.png" title="ipab"></p>
      

</div> <!-- #eof blog_container -->
</div>
<%@include file="../footer.jsp" %>
</body>
</html>