<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="com.ipablive.core.IPaidBribe"%>
<%@page import="java.util.ArrayList"%>

<%@page import="com.ipablive.core.CaptchaServlet"%><html>
<head>
<meta http-equiv="content-type" content="text/html;charset=utf-8" />
<title>I Didn't Pay A Bribe</title>

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
	$(document).ready(
			function()
			{
				// binds form submission and fields to the validation engine
				$( "#c_date_paid" ).datepicker();
				//$("#fm").validationEngine();
			}
	);

	function getTransactions()
	{
         // get the form values
         var dept = $('#cDept').val();
		 $.ajax({
			  type: 'GET',
			  url: 'getTransactions.jsp',
			  data: "dept=" + dept,
			  beforeSend:function(){
			    // this is where we append a loading image
			    $('#transactionsDisplay').html('<div class="loading"><img src="${pageContext.request.contextPath}/theme/images/loading.gif" alt="Loading..." /></div>');
			  },
			  success:function(response){
			    // successful request; do something with the data
			    //$('#transactionsDisplay').empty();
			    $('#transactionsDisplay').html(response);
			  },
			  error:function(){
			    // failed request; give feedback to user
			    $('#transactionsDisplay').html('<p><font color="red"><strong>Oops!</strong> Unable to load transactions.</font></p>');
			  }
		 });
	}


	function validateSubmission()
	{
		$('#validationErrors').empty();
		var _errorColor="#FF3300"; //red
		var _noErrorColor=""; //nocolor
				
		var county,dept,transaction,bribeType,bribeResisted,securityCode;
		county = $('#cCity').val();
		dept = $('#cDept').val();
		bribeType = $('#c_bribe_type').val();
		bribeResisted = $('#c_bribe_resisted_by').val();
		securityCode = $('#security_code').val();

		if($('#cTransactions').length>0)
		{
			transaction = $('#cTransactions').val();

			if(myTrim(transaction)==0)
			{
				$('#validationErrors').html("<center>Please select Transaction</center>");
				$('#cTransactions').css('background',_errorColor);
				return false;
			}else
			{
				$('#cTransactions').css('background',_noErrorColor);
			}
		}
		
		if(myTrim(county).length<=0)
		{
			$('#validationErrors').html("<center>Please select county</center>");
			$('#cCity').css('background',_errorColor);
			return false;
		}else
		{
			$('#cCity').css('background',_noErrorColor);
		}
		
		if(myTrim(dept).length<=0)
		{
			$('#validationErrors').html("<center>Please select department</center>");
			$('#cDept').css('background',_errorColor);
			return false;
		}else
		{
			$('#cDept').css('background',_noErrorColor);
		}

		if(myTrim(bribeType).length<=0)
		{
			$('#validationErrors').html("<center>Please enter office location</center>");
			$('#c_bribe_type').css('background',_errorColor);
			return false;
		}else
		{
			$('#c_bribe_type').css('background',_noErrorColor);
		}

		if(myTrim(bribeResisted).length<=0)
		{
			$('#validationErrors').html("<center>Please enter office location</center>");
			$('#c_bribe_resisted_by').css('background',_errorColor);
			return false;
		}else
		{
			$('#c_bribe_resisted_by').css('background',_noErrorColor);
		}

		if(myTrim(securityCode).length<=0)
		{
			$('#validationErrors').html("<center>Please enter valid security code</center>");
			$('#security_code').css('background',_errorColor);
			return false;
		}else
		{
			$('#security_code').css('background',_noErrorColor);
		}

		return true;
	}

	function myTrim (str) 
	{
		return str.replace(/^\s\s*/, '').replace(/\s\s*$/, '');
	}

	function privacyChecked()
	{
		var cbs = document.forms['fm'].elements['t_and_c'];
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
		
		var code = $('#security_code').val();
		$.ajax({
			  type: 'GET',
			  url: 'validateCode.jsp',
			  data: "code=" + code,
			  beforeSend:function(){
			    // this is where we append a loading image
			    $('#secCodeError').html('<div class="loading"><img src="${pageContext.request.contextPath}/theme/images/loading.gif" alt="Validating code..." /></div>');
			  },
			  success:function(response){
			    // successful request; do something with the data
			    //$('#transactionsDisplay').empty();
			    $('#secCodeError').html(response);
			  },
			  error:function(){
			    // failed request; give feedback to user
			    $('#secCodeError').html('<p><font color="red"><strong>Oops!</strong> Unable to validate code.</font></p>');
			  }
		 });
	}
	
	
	</script>
</head>
<body>
<%@include file="../header.jsp"%>
<div class="pageHeader">
<center><br>
<h2 class="pageHeaderH2">I Didn't Pay A Bribe</h2>
</center>
</div>
<div id="mainContent" class="mainContent">
<% IPaidBribe ipb = IPaidBribe.getInstance(); 
	%>
<div class="error">
<div id="validationErrors"></div>
</div>
<form id="fm" method="post" action="IPaid.do"
	onsubmit="return validateSubmission();">
<div><label for="cCity">County </label> <select name="cCity"
	class="sleft" id="cCity">
	<option value="">Select County</option>
	<%

 ArrayList<String> counties = ipb.getCounties();
 for(int i=0 ;i<counties.size();i++)
 {	 
	 String s = (i+1) + "";
%>
	<option value="<%=s %>"><%=counties.get(i)%></option>
	<%
 }
%>
</select></div>
<div><label for="cDept">Department </label> <select
	onchange="getTransactions()" id="cDept" class="sleft">
	<option value="">Select Department</option>
	<%
 ArrayList<String> depts = ipb.getDepartments();
 for(int i=0 ;i<depts.size();i++)
 {	 
	 String s = (i+1) + "";
%>
	<option value="<%=s %>"><%=depts.get(i)%></option>
	<%
 }
%>
</select></div>
<div><label for="cTransaction">Transactions </label>
<div id="transactionsDisplay"></div>
</div>

<div><label for="c_bribe_type">Bribe Type</label> <select
	class="sleft" name="c_bribe_type" id="c_bribe_type">
	<option value="personal">Personal</option>
	<option value="corporate">Corporate</option>
</select></div>

<div><label for="c_bribe_resisted_by">Resisted a bribe</label> <select
	class="sleft" name="c_bribe_resisted_by" id="c_bribe_resisted_by">
	<option value="">Select</option>
	<option value="me">Me</option>
    <option value="friend">Friend</option>
    <option value="relative">Relative</option>
</select></div>

<div><label for="security_code">Please enter the security
code</label> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <img
	src="${pageContext.request.contextPath}/getCaptcha.do" id="captcha">
<input type="text" name="security_code" id="security_code" value=""
	class="securityCode" onblur="validateSecurityCode()"/>
<span id="secCodeError"></span>
</div>

<div><input name="t_and_c" id="t_and_c" type="checkbox"
	onchange="privacyChecked()" />&nbsp;&nbsp;&nbsp;&nbsp;I agree to the <a
	href="${pageContext.request.contextPath}/privacyPolicy.jsp"
	target="_blank"> terms and conditions</a></div>

<div><input type="submit" value="Submit" disabled="disabled"
	name="submit" id="submit" onclick="return validateSubmission();">
</div>
</form>

</div>

<%@include file="../footer.jsp"%>
</body>
</html>