<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.util.ArrayList"%>

<%@page import="com.ipablive.commons.CommonOperations"%>
<%@page import="com.ipablive.vo.DepartmentVO"%>
<%@page import="com.ipablive.vo.CityVO"%><html>
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
			    checkDeptOthers();
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

		if(myTrim(county).length<=0)
		{
			$('#validationErrors').html("<center>Please select county</center>");
			$('#cCity').css('background',_errorColor);
			return false;
		}else
		{
			$('#cCity').css('background',_noErrorColor);
		}
		
		if($('#cDept').length>0) 
		{
			if(myTrim(dept) == 0)
			{
				var otherDept = $('#otherDept').val();
				if(myTrim(otherDept).length == 0)
				{
					$('#validationErrors').html("<center>Please enter Department</center>");
					$('#otherDept').css('background',_errorColor);
					return false;
				}else
				{
					$('#otherDept').css('background',_noErrorColor);
				}
			}else
			{
				if(myTrim(dept).length<=0)
				{
					$('#validationErrors').html("<center>Please select department</center>");
					$('#cDept').css('background',_errorColor);
					return false;
				}else
				{
					$('#cDept').css('background',_noErrorColor);
				}
			}
		}

		if($('#cTransactions').length>0)
		{
			transaction = $('#cTransactions').val();

			if(myTrim(transaction) == 0)
			{
				var otherTransaction = $('#othersTransaction').val();
				if(myTrim(otherTransaction).length == 0)
				{
					$('#validationErrors').html("<center>Please enter Transaction</center>");
					$('#cTransactions').css('background',_errorColor);
					return false;
				}
			}
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
			validateSecurityCode();
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

	function checkDeptOthers()
	{
		if($('#cDept').val()==0)
		{
			$('#otherDept').fadeIn();
			$('#othersTransaction').fadeIn();
			$('#cTransactions').html("<option value='0'>Others</option>");
		}
		else
		{
			$('#otherDept').fadeOut();
			$('#othersTransaction').fadeOut();
		}
	}

	function checkOthers()
	{
		if($('#cTransactions').val()==0)
		{
			$('#othersTransaction').fadeIn();
		}
		else
		{
			$('#othersTransaction').fadeOut();
		}
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
<% CommonOperations ipb = CommonOperations.getInstance(); 
	%>
<div class="error">
<div id="validationErrors"></div>
</div>
<form id="fm" method="post" action="RegisterIDintPaidComplaint.do"
	onsubmit="return validateSubmission();">
<div class="divContent"><label for="cCity">County </label> <select name="cCity"
	class="sleft" id="cCity">
	<option value="">Select County</option>
	<%

	ArrayList<CityVO> counties = ipb.getCounties();
	 for(int i=0 ;i<counties.size();i++)
	 {	 
		 String s = (i+1) + "";
		 CityVO cvo = counties.get(i);
	%>
		<option value="<%=cvo.getId() %>"><%=cvo.getCityName()%></option>
		<%
	 }
%>
</select></div>
<div class="divContent"><label for="cDept">Department </label> <select
	onchange="getTransactions()" id="cDept" name="cDept" class="sleft">
	<option value="">Select Department</option>
	<%
	ArrayList<DepartmentVO> depts = ipb.getDepartments();
	 for(int i=0 ;i<depts.size();i++)
	 {	 
		 DepartmentVO dVo = depts.get(i);
	%>
		<option value="<%=dVo.getDeptID() %>"><%=dVo.getDeptName()%></option>
		<%
	 }
%>
</select>
<input type="text" name="otherDept" id="otherDept" style="display:none;"  value="" />
</div>
<div class="divContent"><label for="cTransaction">Transactions </label>
<div id="transactionsDisplay"></div>
</div>

<div class="divContent"><label for="c_bribe_type">Bribe Type</label> <select
	class="sleft" name="c_bribe_type" id="c_bribe_type">
	<option value="personal">Personal</option>
	<option value="corporate">Corporate</option>
</select></div>

<div class="divContent"><label for="c_bribe_resisted_by">Resisted a bribe</label> <select
	class="sleft" name="c_bribe_resisted_by" id="c_bribe_resisted_by">
	<option value="">Select</option>
	<option value="me">Me</option>
    <option value="friend">Friend</option>
    <option value="relative">Relative</option>
</select></div>

<div class="divContent"><label for="c_name">Title your story</label><br>
<textarea class="big" name="c_name" id="c_name" rows="2"
	style="height: 20px;" cols="4"></textarea></div>
<div class="divContent"><label for="c_addi_info">Tell us your story</label><br>
Please do NOT report names." We aim to change processes not target
individuals<br>
<textarea class="big" name="c_addi_info" id="c_addi_info" rows="10"
	cols="4"></textarea></div>

<div class="divContent"><label for="security_code">Please enter the security
code</label> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <img
	src="${pageContext.request.contextPath}/getCaptcha.do" id="captcha">
<input type="text" name="security_code" id="security_code" value=""
	class="securityCode" onblur="validateSecurityCode()"/>
<span id="secCodeError"></span><input type="hidden" id="secErr" value="<%= (String) session.getAttribute("Code")%>"/>
</div>

<div class="divContent"><input name="t_and_c" id="t_and_c" type="checkbox"
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