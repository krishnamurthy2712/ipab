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
    <title>Blog - Add Comment</title>
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
<h2 class="pageHeaderH2">Blog</h2>
</center>
</div>
<div id="mainContent" class="mainContent">
<%
String pid = request.getParameter("p");
int postId = Integer.parseInt(pid);
Blogs blogs = Blogs.getInstance();
Boolean isPageVisitUpdated = blogs.updateTotalViews(postId);
BlogPostDetailsVO post = blogs.getBlogPostDetails(postId);


%>
	<div class="node">
		<h2><%=post.getPostTitle() %></h2>
		<div class="submitted">
	        Submitted by <span class="user_text"><%=post.getPostedBy() %></span> on <%=post.getPostCreatedDate() %>
	    </div>
		<div class="blog_content">
			<%=post.getPostContent() %>
		</div>
		<br><br>
		<div>
			<% ArrayList<BlogCommentVO> comments = post.getPostComments();
			
				if(comments.size()>0)
				{
					for(int i=0 ;i<comments.size();i++)
					{
						BlogCommentVO comment = comments.get(i);
						%>
						<div>
							<%=comment.getCommentTitle() %>
						</div>
						<div>
							<%=comment.getCommentContent() %>
						</div>
						<table>
							<tr>
								<td><%=comment.getCreatedBy() %>|</td>
								<td><%= BribeUtils.getFriendlyTime(comment.getCreationDate()) %></td>
							</tr>
						</table>
						<%
					}
				}else
				{
					%>
						<center><b>No Comments Found.</b></center>
					<%
				}
			
			%>
		</div>

	</div>
	
	<h2 class="c_head">Add a Comment</h2>
	<div id="validation_errors" style="display:block;">
	<form method="post" action="storeComment.do" onsubmit="return validateCommentForm();">
	<table>
		<tr>
	    	<td colspan="2">
	        <label for="subject">Name</label><br />
	        <input type="text" name="name" size="84" value="" id="name" /></td>
	    </tr>
		<tr>
	    	<td colspan="2">
	        <label for="subject">Subject</label><br />
	        <input type="hidden" name="subject" size="84" value="<%=post.getPostTitle() %>" id="subject" /><%=post.getPostTitle() %></td>
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
	        <br />
	        <label for="supportURL">URL</label><br />
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
		        <input type="hidden" name="p" value="<%=postId%>" />
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