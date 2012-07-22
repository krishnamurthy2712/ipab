<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.ArrayList"%>
<%@page import="com.ipablive.vo.CityVO"%>
<%@page import="com.ipablive.vo.DepartmentVO"%>
<%@page import="com.ipablive.commons.CommonOperations"%>
<%@page import="com.ipablive.core.Blogs"%>
<%@page import="com.ipablive.vo.BlogPostVO"%>
<%@page import="com.ipablive.vo.BlogPostDetailsVO"%>
<%@page import="com.ipablive.vo.BlogCommentVO"%>
<%@page import="com.ipablive.utils.BribeUtils"%><html>
<head>
    <meta http-equiv="content-type" content="text/html;charset=utf-8" />
    <title>Blog - New post</title>
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

	function validatePostsForm()
	{
		var postCon,name,title,securityCode,secCode;
		$('#validationErrors').empty();
		var _errorColor="#FF3300"; //red
		var _noErrorColor=""; //nocolor

		postCon = $('#postContent').val();
		name = $('#name').val();
		title = $('#subject').val();
		securityCode = $('#security_code').val();
		secCode = $('#secErr').val(); 

		if(myTrim(name).length==0)
		{
			$('#validationErrors').html("<center>Please enter your Name</center>");
			$('#name').css('background',_errorColor);
			$('#errors').fadeIn();
			return false;
		}else
		{
			$('#errors').fadeOut();
			$('#name').css('background',_noErrorColor);
		}
		
		if(myTrim(title).length==0)
		{
			$('#validationErrors').html("<center>Please enter title</center>");
			$('#subject').css('background',_errorColor);
			$('#errors').fadeIn();
			return false;
		}else
		{
			$('#errors').fadeOut();
			$('#subject').css('background',_noErrorColor);
		}

		if(myTrim(postCon).length==0)
		{
			$('#validationErrors').html("<center>Please enter your message</center>");
			$('#postContent').css('background',_errorColor);
			$('#errors').fadeIn();
			return false;
		}else
		{
			$('#errors').fadeOut();
			$('#postContent').css('background',_noErrorColor);
		}
		
		if(myTrim(securityCode).length==0)
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
			$('#errors').fadeOut();
		  return true;
	  	}else
	  	{
	  		$('#validationErrors').html("<center>Please enter valid security code</center>");
	  		$('#security_code').css('background',_errorColor);
	  		$('#errors').fadeIn();
	  	}
	  	return false;
	}
		
	</script>

</head>
<body>
<%@include file="../../header.jsp" %>
<div class="clear"></div>
<div id="bg-wrapper">
	<div class="breadcrumb">
		<div class="clear"></div>
			<a href="${pageContext.request.contextPath}" style="text-decoration: none;">Home</a> > New Post
	<center><br>
	<h2 class="pageHeaderH2">New Post</h2>
	</center>
	</div>
	<div class="new-blog-post">
	<h2 class="c_head">Add a Post</h2>
	<div class="clear"></div>
	<div id="errors">
	<div id="validationErrors"></div>
	</div>
	<form method="post" action="storePost.do" onsubmit="return validatePostsForm();">

	<table>
		<tr>
	    	<td colspan="2">
	        <label for="subject">Name</label><br />
	        <input type="text" name="name" size="84" value="" id="name" /></td>
	    </tr>
		<tr>
	    	<td colspan="2">
	        <label for="subject">Title</label><br />
	        <input type="text" name="subject" size="84" value="" id="subject" /></td>
	    </tr>
		<tr>
	    	<td colspan="2">
	        <br />
	        <label for="postContent">Details</label><br />
	        <textarea rows="5" cols="40" name="postContent" id="postContent"></textarea>
	        </td>
	    </tr>    
		<tr>
	    	<td colspan="2">
	        <label for="supportURL">Support(you can specify the support url for this post)</label><br />
	        <input type="text" name="supportURL" size="84" value="" id="supportURL" />
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
		        <input type="submit" name="submit" id="submit" value="Post"  />
	        </td>
	    </tr>  	  
	</table>
	</form>
</div>
</div>
<%@include file="../../footer.jsp" %>
</div>
</body>
</html>