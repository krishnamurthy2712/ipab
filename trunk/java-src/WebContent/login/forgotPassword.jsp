<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.ArrayList"%>
<%@page import="com.ipablive.vo.CityVO"%>
<%@page import="com.ipablive.vo.DepartmentVO"%>
<%@page import="com.ipablive.commons.CommonOperations"%><html>
<head>
    <meta http-equiv="content-type" content="text/html;charset=utf-8" />
    <title>Forgot Password</title>
	<script src="${pageContext.request.contextPath}/theme/js/jquery.js"	type="text/javascript">	</script>
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
				
		var userName,password;
		userName = $('#userName').val();
		password = $('#securityAns').val();
		securityCode = $('#security_code').val();
		var secVal = $('#secErr').val(); 

		if(myTrim(securityAns).length<=0)
		{
			$('#validationErrors').html("<center>Please enter user name.</center>");
			$('#userName').css('background',_errorColor);
			$('#errors').fadeIn();
			return false;
		}else
		{
			$('#userName').css('background',_noErrorColor);
			$('#errors').fadeOut();
		}

		if(myTrim(securityAns).length<=0)
		{
			$('#validationErrors').html("<center>Please enter security Ans.</center>");
			$('#securityAns').css('background',_errorColor);
			$('#errors').fadeIn();
			return false;
		}else
		{
			$('#securityAns').css('background',_noErrorColor);
			$('#errors').fadeOut();
		}

		return true;
	}

	function myTrim (str) 
	{
		return str.replace(/^\s\s*/, '').replace(/\s\s*$/, '');
	}

	function getSecurityQuestion()
	{
		var userId = $('#userName').val();

        $.ajax({
			  type: 'GET',
			  url: "${pageContext.request.contextPath}/login/getSecurityQuestion.jsp",
			  data: "user=" + userId,
			  beforeSend:function(){
			    // this is where we append a loading image
			    $('#secQuesDisplay').html('<div class="loading"><img src="${pageContext.request.contextPath}/theme/images/loading.gif" alt="Loading..." /></div>');
			  },
			  success:function(response){
			    // successful request; do something with the data
			    $('#secQuesDisplay').empty();
			    $('#secQuesDisplay').html(response);
			  },
			  error:function(jqXHR, textStatus, errorThrown){
			    // failed request; give feedback to user
			    alert(errorThrown);
			    $('#secQuesDisplay').html('<p><font color="red"><strong>Oops!</strong> Unable to load transactions.</font></p>');
			  }
		 });
	}
	
	</script>


</head>
<body>
<%@include file="../header.jsp" %>
<div class="clear"></div>
<div id="bg-wrapper">

<div class="breadcrumb">
	<div class="clear"></div>
		<a href="${pageContext.request.contextPath}" style="text-decoration: none;">Home</a> > Forgot Password
<center><br>
<h2 class="pageHeaderH2">Forgot Password</h2>
</center>
</div>


<div class="login-block-box">
<div class="clear" style="height: 10px;"></div>
<div class="empty-space"></div>
<div class="login-form" align="right">
<div class="clear" style="height: 30px;"></div>
<div id="errors">
<div id="validationErrors"></div>
</div>
<div class="clear"></div>
<form action="forgotPwd" method="post" onsubmit="return validateSubmission()">
<div class="divContent">
	<label for="userName">User Name</label>
	<input type="text" name="userName" id="userName" style="width: 250px;" onblur="getSecurityQuestion()">
</div>
<div class="divContent">
	<div style="float: left;"><label for="securityQues">Security Question</label>
	<input type="hidden" name="securityQues" id="securityQues"></div>
	<div id="secQuesDisplay" style="float: right;"></div>
</div>
<div class="clear"></div>
<div class="divContent">
	<label for="securityAns">Security Answer</label>
	<input type="password" name="securityAns" id="securityAns" style="width: 250px;">
</div>
<div class="divContent">
	<input type="submit" value="Get Password">
</div>

</form>
</div>
</div>

<%@include file="../footer.jsp" %>
</div>
</body>
</html>