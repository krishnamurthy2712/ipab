<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.ArrayList"%>
<%@page import="com.ipablive.vo.CityVO"%>
<%@page import="com.ipablive.vo.DepartmentVO"%>
<%@page import="com.ipablive.commons.CommonOperations"%>
<%@page import="com.ipablive.core.Home"%>
<%@page import="com.ipablive.vo.NewsVO"%><html>
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
		href="${pageContext.request.contextPath}/theme/css/newstyles.css"
		rel="stylesheet" />

<script type="text/javascript">
function validateSubmission()
{
	$('#validationErrors').empty();
	var _errorColor="#FF3300"; //red
	var _noErrorColor=""; //nocolor
			
	var newsTitle,newsContent;
	newsTitle = $('#newsTitle').val();
	newsContent = $('#newsBody').val();

	if(myTrim(newsTitle).length<=0)
	{
		$('#validationErrors').html("<center>Please enter news title</center>");
		$('#newsTitle').css('background',_errorColor);
		$('#errors').fadeIn();
		return false;
	}else
	{
		$('#newsTitle').css('background',_noErrorColor);
		$('#errors').fadeOut();
	}

	if(myTrim(newsContent).length<=0)
	{
		$('#validationErrors').html("<center>Please enter news to share</center>");
		$('#newsBody').css('background',_errorColor);
		$('#errors').fadeIn();
		return false;
	}else
	{
		$('#newsBody').css('background',_noErrorColor);
		$('#errors').fadeOut();
	}

	return true;
}

function myTrim (str) 
{
	return str.replace(/^\s\s*/, '').replace(/\s\s*$/, '');

function onKeyDown()
{
	$('#errors').fadeOut();
}
</script>

</head>
<body>
<%@include file="../../header.jsp" %>
<div class="clear"></div>
<div id="bg-wrapper" class="bg-wrapper">
	<div class="breadcrumb">
			<div class="clear"></div>
				<a href="${pageContext.request.contextPath}" style="text-decoration: none;">Home</a> > Add News
		<center><br>
		<h2 class="pageHeaderH2">Add News</h2>
		</center>
		</div>
<div class="news-block-box1">

<div class="clear"></div>
<div id="errors">
<div id="validationErrors"></div>
</div>

<form id="fm" method="post" action="news"
	 class="ipabforms" onsubmit="return validateSubmission">
<div class="divContent"><label for="newsTitle">Title</label><br>
<input type="text" name="newsTitle" id="newsTitle">
</div>

<div class="divContent"><label for="newsBody">Body</label><br>
<textarea class="big" name="newsBody" id="newsBody" rows="10" onkeydown="onKeyDown()"
	cols="4"></textarea>
</div>

<div class="divContent"><label for="newsURL">URL</label><br>
<input type="text" id="newsURL" name="newsURL">
</div>

<div class="divContent">
<input type="submit" value="Submit" >
</div>
</form>

</div>
<%@include file="../../footer.jsp" %>
</div>
</body>
</html>