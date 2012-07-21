<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="content-type" content="text/html;charset=utf-8" />
    <title>Login</title>
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
				
		var userName,password;
		userName = $('#userName').val();
		password = $('#password').val();
		securityCode = $('#security_code').val();
		var secVal = $('#secErr').val(); 

		if(myTrim(userName).length<=0)
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

		if(myTrim(password).length<=0)
		{
			$('#validationErrors').html("<center>Please enter password.</center>");
			$('#password').css('background',_errorColor);
			$('#errors').fadeIn();
			return false;
		}else
		{
			$('#password').css('background',_noErrorColor);
			$('#errors').fadeOut();
		}

		return true;
	}

	function myTrim (str) 
	{
		return str.replace(/^\s\s*/, '').replace(/\s\s*$/, '');
	}
	
	</script>

</head>
<body>
<%@include file="../header.jsp" %>
<div class="clear"></div>
<div id="bg-wrapper">
<div class="breadcrumb">
	<div class="clear"></div>
		<a href="${pageContext.request.contextPath}" style="text-decoration: none;">Home</a> > Login
<center><br>
<h2 class="pageHeaderH2">Login</h2>
</center>
</div>
<div id="bg-wrapper" class="bg-wrapper">
<div style="width: 100%">
<div class="login-block-box" align="center">
<div class="clear" style="height: 10px;"></div>
<div class="login-form" align="right">
<div class="clear" style="height: 30px;"></div>
<div id="errors">
<div id="validationErrors"></div>
</div>
<div class="clear"></div>
<form action="VerifyLogin" method="post" onsubmit="return validateSubmission()">
<div class="divContent">
	<label for="userName">User Name</label>
	<input type="text" name="userName" id="userName" style="width: 250px;">
</div>
<div class="divContent">
	<label for="userName">Password</label>
	<input type="password" name="password" id="password" style="width: 250px;">
</div>
<div class="divContent">
	<input type="submit" value="Login">&nbsp;&nbsp;|&nbsp;&nbsp;
	<a href="${pageContext.request.contextPath}/entry?cmd=forgot">Forgot Password</a>
	<div class="clear" style="height: 20px;"></div>
	New User? Click <a href="#">here</a> to Signup.
</div>

</form>
</div>
</div>

</div> 
<%@include file="../footer.jsp" %>
</div>
</body>
</html>