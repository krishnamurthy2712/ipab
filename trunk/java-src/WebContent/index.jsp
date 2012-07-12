<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
	href="${pageContext.request.contextPath}/theme/css/newstyles.css"
	rel="stylesheet" />
<script src="${pageContext.request.contextPath}/theme/js/jquery.flipCounter.js" type="text/javascript"></script>
<%
CommonOperations comm = CommonOperations.getInstance();
int pageHits = comm.getHits();
%>
<script type="text/javascript">
	$(document).ready(
		function()
		{
	    $("#counter").flipCounter("setNumber",<%=pageHits%>);       
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
</script>
</head>
<body>
<%@include file="header.jsp"%>
<div class="clear"></div>

<div id="bg-wrapper">
	<div class="home-block-box bgbox rounded-corners">
        <div class="bribe_box">
            <div class="report_bribe" align="center">
                <p> 
                    <br><strong>Bribed? Didn't Bribe?<br>Victimised? Angry?</strong>
					<div class="clear"></div>
                    <a href="${pageContext.request.contextPath}/complaint?t=paid">
					<img src="${pageContext.request.contextPath}/theme/images/report_your_bribe_btn.png" alt="Report Your Bribe" border="0"></a>
					<div class="clear" style="height: 50px;"></div><br><br>
               		<span>Tell us your story. Using your stories we'll advocate with the government for an improved system.</span><br><br>
					<div class="clear"></div>                 
   					<b><a href="${pageContext.request.contextPath}/aboutus.jsp">What is I Paid A Bribe?</a></b>
                </p>
            </div>
        </div>
	</div>
	
	<div class="home-block-box bgbox right-box rounded-corners">
		<%@include file="bribeAnalysis.jsp" %>
	</div>
	<div class="clear"></div>
	<div class="home-block-box2 bgbox rounded-corners" >
		<%@include file="bribeReports.jsp" %>
	</div>
	<div class="home-block-box2 bgbox right-box rounded-corners">
		<%@include file="bribeFighters.jsp" %>
	</div>

	<div class="videos-block-box bgbox rounded-corners">
		<%@include file="latestVideos.jsp" %>
	</div>
	
	<div class="news-block-box right-box rounded-corners">
		<%@include file="bribeNews.jsp" %>
	</div>

</div>
<div class="clear"></div>
<%@include file="footer.jsp"%>
</body>
</html>