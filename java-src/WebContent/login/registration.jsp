<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.ArrayList"%>
<%@page import="com.ipablive.vo.CityVO"%>
<%@page import="com.ipablive.vo.DepartmentVO"%>
<%@page import="com.ipablive.commons.CommonOperations"%><html>
<head>
    <meta http-equiv="content-type" content="text/html;charset=utf-8" />
    <title>Registration</title>
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
				
		var userName,password,confPassword,securityCode,firstName, lastName,emailId,secQuestion,secAnswer;
		
		userName = $('#userName').val();
		password = $('#password').val();
		confPassword = $('#confPassword').val();
		firstName = $('#firstName').val();
		lastName = $('#lastName').val();
		emailId = $('#emailId').val();
		secQuestion = $('#secQuestion').val();
		secAnswer = $('#secAnswer').val();
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

		if(myTrim(confPassword).length<=0)
		{
			$('#validationErrors').html("<center>Please enter Confirm password.</center>");
			$('#confPassword').css('background',_errorColor);
			$('#errors').fadeIn();
			return false;
		}else
		{
			$('#confPassword').css('background',_noErrorColor);
			$('#errors').fadeOut();
		}

		if(myTrim(confPassword)!= myTrim(password))
		{
			$('#validationErrors').html("<center>Password doesn't match.</center>");
			$('#confPassword').css('background',_errorColor);
			$('#errors').fadeIn();
			return false;
		}else
		{
			$('#confPassword').css('background',_noErrorColor);
			$('#errors').fadeOut();
		}

		if(myTrim(firstName).length<=0)
		{
			$('#validationErrors').html("<center>Please enter first name.</center>");
			$('#firstName').css('background',_errorColor);
			$('#errors').fadeIn();
			return false;
		}else
		{
			$('#firstName').css('background',_noErrorColor);
			$('#errors').fadeOut();
		}

		if(myTrim(lastName).length<=0)
		{
			$('#validationErrors').html("<center>Please enter Last Name.</center>");
			$('#lastName').css('background',_errorColor);
			$('#errors').fadeIn();
			return false;
		}else
		{
			$('#lastName').css('background',_noErrorColor);
			$('#errors').fadeOut();
		}

		if(myTrim(emailId).length<=0)
		{
			$('#validationErrors').html("<center>Please enter email.</center>");
			$('#emailId').css('background',_errorColor);
			$('#errors').fadeIn();
			return false;
		}else
		{
			$('#emailId').css('background',_noErrorColor);
			$('#errors').fadeOut();
		}

		if(myTrim(secQuestion).length<=0)
		{
			$('#validationErrors').html("<center>Please select security question.</center>");
			$('#secQuestion').css('background',_errorColor);
			$('#errors').fadeIn();
			return false;
		}else
		{
			$('#secQuestion').css('background',_noErrorColor);
			$('#errors').fadeOut();
		}

		if(myTrim(secAnswer).length<=0)
		{
			$('#validationErrors').html("<center>Please select security answer.</center>");
			$('#secAnswer').css('background',_errorColor);
			$('#errors').fadeIn();
			return false;
		}else
		{
			$('#secAnswer').css('background',_noErrorColor);
			$('#errors').fadeOut();
		}

		if(myTrim(securityCode).length<=0)
		{
			$('#validationErrors').html("<center>Please enter valid security code</center>");
			$('#security_code').css('background',_errorColor);
			$('#errors').fadeIn();
			return false;
		}else
		{
			validateSecurityCode();
			$('#errors').fadeOut();
			$('#security_code').css('background',_noErrorColor);
		}

		emailValidation();
		
		return true;
	}

	function myTrim (str) 
	{
		return str.replace(/^\s\s*/, '').replace(/\s\s*$/, '');
	}

	function privacyChecked()
	{
		var cbs = document.forms['fm'].elements['t_and_c'];;
		
		  if(cbs.checked)
		  {
			  document.forms['fm'].elements['submit'].disabled = false;
		  }
		  else
		  {
		      document.forms['fm'].elements['submit'].disabled = true;
		  }
	}

	function validateSecurityCode()
	{
		var enteredCode = $('#security_code').val();
		var generatedCode = $('#secErr').val();

		if(enteredCode == generatedCode)
		{
		  return true;
	  	}else
	  	{
	  		$('#validationErrors').html("<center>Please enter valid security code</center>");
	  		$('#security_code').css('background',_errorColor);
	  	}
	  	return false;
	}
	
	function emailValidation()
	{
		var emailValue = document.getElementByName("emailId").value;
		alert(emailValue);
		var emailExp = /^[\w\-\.\+]+\@[a-zA-Z0-9\.\-]+\.[a-zA-z0-9]{2,4}$/;
		if(!emailValue.match(emailExp) || emailValue=="" )
		{
			$('#validationErrors').html("<center>Please enter valid email.</center>");
			document.getElementByName("emailId").focus();
			return false;
		}
		else
		{
			return true;
		}
	}

	function onKeyDown()
	{
		$('#errors').fadeOut();
	}

	
	</script>

</head>
<body>
<%@include file="../header.jsp" %>
<div class="clear"></div>
<div id="bg-wrapper">
<div class="breadcrumb">
	<div class="clear"></div>
		<a href="${pageContext.request.contextPath}" style="text-decoration: none;">Home</a> > Registration
<center><br>
<h2 class="pageHeaderH2">Registration</h2>
</center>
</div>
<div style="width: 100%">
<div class="login-block-box" align="center">
<div class="clear" style="height: 10px;"></div>
<div class="registration-form" align="right">
<div class="clear" style="height: 30px;"></div>
<div id="errors">
<div id="validationErrors"></div>
</div>
<div class="clear"></div>
<form action="VerifyLogin" method="post" onsubmit="return validateSubmission()" id="fm">
<div class="divContent">
	<label for="userName">User Name</label>
	<input type="text" name="userName" id="userName" style="width: 250px;">
</div>
<div class="divContent">
	<label for="password">Password</label>
	<input type="password" name="password" id="password" style="width: 250px;">
</div>
<div class="divContent">
	<label for="confPassword">Confirm Password</label>
	<input type="password" name="confPassword" id="confPassword" style="width: 250px;">
</div>
<div class="divContent">
	<label for="firstName">First Name</label>
	<input type="text" name="firstName" id="firstName" style="width: 250px;">
</div>
<div class="divContent">
	<label for="lastName">Last Name</label>
	<input type="text" name="lastName" id="lastName" style="width: 250px;">
</div>
<div class="divContent">
	<label for="emailId">Email</label>
	<input type="text" name="emailId" id="emailId" style="width: 250px;" onblur="return emailValidation()">
</div>
<div class="divContent">
	<label for="secQuestion">Security Question</label>
	<select name="secQuestion" id="secQuestion" style="width: 250px;">
		<option>Who is your Childhood hero?</option>
		<option>Where did you born?</option>
		<option>In what city or town was your first job?</option>
		<option>What is your first phone number?</option>
		<option>What is your favorite car?</option>
		<option>What is your mother's middle name?</option>
		<option>What is your childhood nickname?</option>
		<option>What is your first school you studied?</option>
	</select>
</div>
<div class="divContent">
	<label for="secAnswer">Security Answer</label>
	<input type="password" name="secAnswer" id="secAnswer" style="width: 250px;">
</div>

<div class="divContent"><label for="security_code">Please enter the security
code</label> &nbsp;&nbsp;&nbsp;<img
	src="${pageContext.request.contextPath}/getCaptcha.do?num" id="captcha">&nbsp;&nbsp;&nbsp;
<input type="text" name="security_code" id="security_code" value="" onkeydown="onKeyDown()"
	class="securityCode" onblur="validateSecurityCode()"/>
<span id="secCodeError"></span><input type="hidden" id="secErr" value="<%= (String) session.getAttribute("Code")%>"/>
</div>

<div class="divContent"><input name="t_and_c" id="t_and_c" type="checkbox"
	onchange="privacyChecked()" />&nbsp;&nbsp;&nbsp;&nbsp;I agree to the <a
	href="${pageContext.request.contextPath}/content/privacyPolicy.jsp"
	target="_blank"> terms and conditions</a></div>

<div class="divContent">
	<input type="submit" value="Register" id="submit" disabled="disabled">
	<input type="reset" value="Reset">
</div>

</form>
</div>
</div>
</div>
<%@include file="../footer.jsp" %>
</div>
</body>
</html>