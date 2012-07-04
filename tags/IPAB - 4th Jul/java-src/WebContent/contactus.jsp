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

<script type="text/javascript">
function validateSubmission()
{
	var name,email,subject,msgBody;
	name = $('#nameEntered').val();
	email = $('#emailAddr').val();
	subject = $('#mailSubject').val();
	msgBody = $('#mailBody').val();

	if(name.length==0)
	{
		$('#validationErrors').show();
		$('#validationErrors').html("<p class='display_info'>Please enter Name.</p>");
		return false;
	}
	else if(email.length==0)
	{
		$('#validationErrors').show();
		$('#validationErrors').html("<p class='display_info'>Please enter email.</p>");
		return false;
	}
	else if(subject.length==0)
	{
		$('#validationErrors').show();
		$('#validationErrors').html("<p class='display_info'>Please enter subject.</p>");
		return false;
	}
	else if(msgBody.length==0)
	{
		$('#validationErrors').show();
		$('#validationErrors').html("<p class='display_info'>Please enter your message to share with us.</p>");
		return false;
	}

	if(email.length>0)
	{
		var asd = mailValidation();
		if(asd)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	return true;
}

function mailValidation() 
{
	$('#validationErrors').hide();
	   var reg = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
	   var address = $('#emailAddr').val();
	   if(reg.test(address) == false) 
	   {
		   $('#validationErrors').show();
		   $('#validationErrors').html('<p class="display_info">Please enter valid Email Address</p>');
	      return false;
	   }
	   return true;
}

function hideErrorMessage()
{
	$('#validationErrors').hide();
}

</script>

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
<h1>
	You can leave a message using the contact form below.</h1>
<br>
<form action="contact.do"  accept-charset="UTF-8" method="post" id="contact-mail-page">
<div align="center" id="validationErrors" ></div>
<br>
<div class="form-item" id="edit-name-wrapper">
 <label for="nameEntered">Your name: <span class="form-required" title="This field is required.">*</span></label>
 <input type="text" maxlength="255" name="name" id="nameEntered" size="60" value="" class="form-text required" onkeydown="hideErrorMessage()" />
</div>
<div class="form-item" id="edit-mail-wrapper">
 <label for="emailAddr">Your e-mail address: <span class="form-required" title="This field is required.">*</span></label>
 <input type="text" maxlength="255" name="mail" id="emailAddr" size="60" value="" class="form-text required" onkeydown="hideErrorMessage()"/>
</div>
<div class="form-item" id="edit-subject">
 <label for="mailSubject">Subject: <span class="form-required" title="This field is required.">*</span></label>
 <input type="text" maxlength="255" name="subject" id="mailSubject" size="60" value="" class="form-text required" onkeydown="hideErrorMessage()"/>
</div>
<div class="form-item" id="edit-message">
 <label for="mailBody">Message: <span class="form-required" title="This field is required.">*</span></label>
 <textarea cols="60" rows="5" name="message" id="mailBody"  class="form-textarea resizable required" onkeydown="hideErrorMessage()"></textarea>
</div>
<input type="submit" value="Submit"	name="submit" id="submit" onclick="return validateSubmission();">
<br>
</div></form>
</div>   
	</div>
</div>
<%@include file="../footer.jsp" %>
</body>
</html>