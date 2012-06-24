<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.ArrayList"%>
<%@page import="com.ipablive.vo.CityVO"%>
<%@page import="com.ipablive.vo.DepartmentVO"%>
<%@page import="com.ipablive.commons.CommonOperations"%>
<%@page import="com.ipablive.core.IPaidBribe"%>
<%@page import="com.ipablive.vo.PaidBribesVO"%>
<%@page import="java.text.SimpleDateFormat"%><html>
<head>
    <meta http-equiv="content-type" content="text/html;charset=utf-8" />
    <title>Bribes Registered</title>
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
<%
String postId = "";
String type = "";

if(type.equals("paid"))
{
    //$redurl = 'sforms/view_reports_paid';
  //  $head_img = 'reg.png';
}
else if(type.equals("notpaid"))
{
    //$redurl = 'sforms/view_reports_didnt_pay';
    //$head_img = 'reg.png';
}
else if(type.equals("dinthvtopay"))
{
   // $redurl = 'sforms/view_reports_didnt_have_to_pay';
   // $head_img = 'reg.png';
}
else if(type.equals("govt_promises"))
{
    //$redurl = 'sforms/govt_promises';
   // $head_img = 'govt_promises.png';
}

%>
  

<script type="text/javascript">
function validateCommentForm()
{
	var comment,securityCode,secCode;
	$('#validationErrors').empty();
	var _errorColor="#FF3300"; //red
	var _noErrorColor=""; //nocolor

	comment = $('#comment').val();
	securityCode = $('#security_code').val();
	secCode = $('#secErr').val(); 

	if(myTrim(comment).length==0)
	{
		$('#validationErrors').html("<center>Please enter comment</center>");
		$('#comment').css('background',_errorColor);
		return false;
	}else
	{
		validateSecurityCode();
		$('#comment').css('background',_noErrorColor);
	}
	
	if(myTrim(securityCode).length==0)
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

function validateSecurityCode()
{
	var enteredCode = $('#security_code').val();
	var generatedCode = $('#secErr').val();

	if(enteredCode == generatedCode)
	{
		$('#security_code').css('background',_noErrorColor);
	  return true;
  	}else
  	{
  		$('#validationErrors').html("<center>Please enter valid security code</center>");
  		$('#security_code').css('background',_errorColor);
  	}
  	return false;
}

</script>

		
</head>
<body>
<%@include file="../header.jsp" %>
<div class="pageHeader">
<center><br>
<h2 class="pageHeaderH2">Bribes Registered</h2>
</center>
</div>
<div id="mainContent" class="mainContent">
<div class="blog_container divtab">
<p><a href="#" class="yellow_box">&lt;&lt; Back To </a></p>
<br />
<%
if(type.equals("paid"))
{
	%>
    <h3>CName</h3>
    <div class="report_reg">
            Reported : created 
            | City : ccity
            | Paid On : cdatepaid
            | dept
    </div>
    <div class="report_reg">
    <table class="details_table" width="100%" summary="this table has the details for a certain report.">
        <tr>
            <th width="20%"><span class="desc_lebel">Department:</span></th>
            <td>dept</td>
        </tr>
        <tr>
            <th><span class="desc_lebel">Transaction:</span></th>
            <td>trans</td>
        </tr>    
        <tr>
            <th><span class="desc_lebel">Bribe Type:</span></th>
            <td>bribeType</td>
        </tr>
        <tr>
            <th><span class="desc_lebel">Details:</span></th>
            <td>additional info</td>
        </tr>
    </table>
    </div>
    <%
}
else if(type.equals("notpaid"))
{
	 %>
	<h3>cname</h3>
    
    <div class="report_reg">
Reported : date | City : ccity | dept

		<table class="details_table">
			<tr>
		    	<th width="20%"><span class="desc_lebel">Department:</span></th>
		        <td>dept</td>
		    </tr>
			<tr>
		    	<th><span class="desc_lebel">Transaction:</span></th>
		        <td>transaction</td>
		    </tr>    
			<tr>
		    	<th><span class="desc_lebel">Reason:</span></th>
		        <td>
<!--                <?php -->
<!--                    if($row_det->c_bribe_resisted_by=='govt')-->
<!--                    {-->
<!--                        echo 'Came accross an honest govt official';-->
<!--                    }-->
<!--                    else-->
<!--                    {-->
<!--                        echo 'Resisted by '.$row_det->c_bribe_resisted_by;-->
<!--                    }-->
<!--                ?>-->
                </td>
		    </tr>
			<tr>
		    	<th><span class="desc_lebel">Details:</span></th>
		        <td>add info
		</td>
		    </tr>
		</table>
    </div>     
    <%
}
else if(type.equals("dinthvtopay"))
{
	 %>
	<h3>cname</h3>
    
    <div class="report_reg">
City : ccity | dept

    
    <table class="details_table">
			<tr>
		    	<th width="20%"><span class="desc_lebel">Department:</span></th>
		        <td>dept</td>
		    </tr>
			<tr>
		    	<th><span class="desc_lebel">Transaction:</span></th>
		        <td>transaction</td>
		    </tr>    
			<tr>
		    	<th><span class="desc_lebel">Reason:</span></th>
		        <td>
<!--                <?php -->
<!--                    if($row_det->c_bribe_resisted_by=='govt')-->
<!--                    {-->
<!--                        echo 'Came accross an honest govt official';-->
<!--                    }-->
<!--                    else-->
<!--                    {-->
<!--                        echo 'Resisted by '.$row_det->c_bribe_resisted_by;-->
<!--                    }-->
<!--                ?>-->
                </td>
		    </tr>
			<tr>
		    	<th><span class="desc_lebel">Details:</span></th>
		        <td>add info
		</td>
		    </tr>
		</table>
        </div>    
    <%
}
else if(type.equals("govt_promises"))
{
	 %>
    <div class="report_reg">
        <p class="question"><h2> title</h2></a></p>
        <div id="ans_1" style="display:block; margin:15px 0px 0px 0px;">
           description
        </div>
        <br />
        <div><strong>Department: </strong><span style="padding-left: 10px;">deptname</span></div>
        <div><strong>City: </strong><span style="padding-left: 68px;">cityname</span></div>
    </div>     
    <%
}
 %>

<div style="clear:both;"></div>
<div id="validation_errors" style="display:<?php echo (empty($msg))?'none':'block';?>;">
</div>

<h1 class="c_head">Add comment</h1>
<div class="error">
<div id="validationErrors"></div>
</div>
<form method="post" action="" onsubmit="return validateCommentForm();">
<table>
	<tr>
    	<td colspan="2">
        <label for="subject">Subject</label><br />
        <input type="hidden" name="subject" size="84" value="" id="subject" />subject</td>
    </tr>
	<tr>
    	<td colspan="2">
        <br />
        <label for="comment">Comment</label><br />
        <textarea rows="5" cols="40" name="comment" id="comment"></textarea>
        </td>
    </tr>    
	<tr>
    <td colspan="2">
    <label for="security_code">Please enter the security code</label>
    <p><img src="${pageContext.request.contextPath}/getCaptcha.do?type=num" alt="captcha" /></p>
    <input type="text" name="security_code" id="security_code" value="" onblur="validateSecurityCode()"/>   
	<input type="hidden" id="secErr" value="<%= (String) session.getAttribute("Code")%>"/> 
    </td>
    </tr>
	<tr>    	
        <td colspan="2">
	        <input type="hidden" name="type" value="<%=type %>" />
	        <input type="hidden" name="type_id" value="<%=postId %>" />
	        <input type="submit" name="submit" id="submit" value="Post"  />
        </td>
    </tr>  	  
</table>
</form>
</div>
</div>
<%@include file="../footer.jsp" %>
</body>
</html>