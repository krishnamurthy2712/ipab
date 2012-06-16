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
		href="${pageContext.request.contextPath}/theme/css/style.css"
		rel="stylesheet" />

	<script type="text/javascript">
	function validateSubmission()
	{
		return true;
	}
	</script>

</head>
<body>
<%@include file="../header.jsp" %>
<div class="pageHeader">
<center><br>
<h2 class="pageHeaderH2">Register for Updates on IPAB</h2>
</center>
</div>
<div id="mainContent" class="mainContent">

<div id="validation_errors" style="display:none;">
</div>

&nbsp;

<div class="report_form">
<form action="" onsubmit="return validateSubmission()" method="post">

        	<div>  
			<p><label for="EMail">EMail</label></p>
        	<div id="sub_transaction_con" class="inline_div">
            <input type="text" name="email" id="email" style="width:150px"  value="" />         
            </div>
            </div>  
            

            <div>  
			<p><label for="security_code">Please enter the security code</label></p>
            <p>
            	<img src="${pageContext.request.contextPath}/getCaptcha.do" alt="" />
            </p>
        	<input type="text" name="security_code" style="width:150px" id="security_code" value="" />
			</div>
            <div class="report_form_button">  
			<input type="submit" name="submit" id="submit" class="submit_btn" value="Submit" style="margin-left:2px;margin-top:5px;">
			</div>      
                 
</form>

</div><!-- eeof report form -->      

</div>
</div>
<%@include file="../footer.jsp" %>
</body>
</html>