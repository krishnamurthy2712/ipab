<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.ArrayList"%>
<%@page import="com.ipablive.vo.CityVO"%>
<%@page import="com.ipablive.vo.DepartmentVO"%>
<%@page import="com.ipablive.commons.CommonOperations"%><html>
<head>
    <meta http-equiv="content-type" content="text/html;charset=utf-8" />
    <title>Register for Updates on IPAB</title>
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
		$('#validationErrors').hide();
		var email,secCode;
		email = $('#email').val();
		secCode = $('#security_code').val();

		if(secCode.length==0)
		{
			 $('#validationErrors').show();
			$('#validationErrors').html("<p class='display_info'>Please enter security code.</p>");
			return false;
		}
		
		if(email.length==0)
		{
			 $('#validationErrors').show();
			$('#validationErrors').html("<p class='display_info'>Please enter email</p>");
			return false;
		}else
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
		   var address = document.forms["fm"].elements["email"].value;
		   if(reg.test(address) == false) 
		   {
			   $('#validationErrors').show();
			   $('#validationErrors').html('<p class="display_info">Please enter valid Email Address</p>');
		      return false;
		   }
		   return true;
		}
	</script>

</head>
<body>
<%@include file="../header.jsp" %>
<div class="clear"></div>
<div id="bg-wrapper" class="bg-wrapper">
	<div class="breadcrumb">
			<div class="clear"></div>
				<a href="${pageContext.request.contextPath}" style="text-decoration: none;">Home</a> > Register for updates
		<center><br>
		<h2 class="pageHeaderH2">Register for updates</h2>
		</center>
		</div>
<div class="updates-block-box">
<div align="center" id="validationErrors" ></div>
&nbsp;

<div class="report_form">
<form action="registerUpdates.do" onsubmit="return validateSubmission()" method="post" name="fm">

        	<div>  
			<p><label for="EMail">EMail</label></p>
        	<div id="sub_transaction_con" class="inline_div">
            <input type="text" name="email" id="email" style="width:250px"  value="" onblur="return mailValidation();"/>         
            </div>
            </div>  
            

            <div>  
			<p><label for="security_code">Please enter the security code</label></p>
            <p>
            	<img src="${pageContext.request.contextPath}/getCaptcha.do" alt="" />
            </p>
        	<input type="text" name="security_code" style="width:250px" id="security_code" value="" />
			</div>
            <div class="report_form_button">  
			<input type="submit" name="submit" id="submit" class="submit_btn" value="Submit" style="margin-left:2px;margin-top:5px;">
			</div>      
                 
</form>

</div><!-- eeof report form -->      
</div>

<%@include file="../footer.jsp" %>
</div>
</body>
</html>