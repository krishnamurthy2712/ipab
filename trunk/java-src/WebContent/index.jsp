<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
<html:html>
<head>
<meta http-equiv="content-type" content="text/html;charset=utf-8" />
<title>I Paid a Bribe</title>
<link type="text/css"
	href="${pageContext.request.contextPath}/theme/css/menu.css"
	rel="stylesheet" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/theme/js/jquery.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/theme/js/menu.js"></script>
<link type="text/css"
	href="${pageContext.request.contextPath}/theme/css/style.css"
	rel="stylesheet" />
</head>
<body>
<%@include file="header.jsp"%>
<div class="wraperTop">
    <div class="grid">
        <div class="bribe_box report">
            <div class="report_bribe">
                <p>
                    <br><strong>Bribed? Didn't Bribe?<br>Victimised? Angry?</strong>
                    <a href="http://www.ipaidabribe.or.ke/sforms/register/complaints?CSRF_TOKEN=" onclick="aptesting('aG9tZXBhZ2Uy','MQ==')"><img src="I%20PAID%20A%20BRIBE_files/report_your_bribe_btn2.png" alt="REPORT YOUR BRIBE" border="0"></a>
                <span>Tell us your story. Using your stories<br>we'll advocate with the government<br>for an improved system.</span><br><br>
                    <b><a href="http://www.ipaidabribe.or.ke/node/77?CSRF_TOKEN=">What is I Paid A Bribe?</a></b>
                </p>
            </div>
        </div>
    </div>
   
    <div class="longGrid">
        <%@include file="bribeAnalysis.jsp" %>
        <!----- Break ----->
        <%@include file="highlights.jsp" %>
        <div class="clear"></div>
</div>

<!-- bottom -->
<div class="wraperBottom">
    <!--Gird 1--> 
	<%@include file="bribeReports.jsp" %>
<!--Gird 2--> 
	
<%@include file="bribeFighters.jsp" %>
<%@include file="bribeNews.jsp" %>


            
</div>
<%@include file="footer.jsp"%>
</body>
</html:html>