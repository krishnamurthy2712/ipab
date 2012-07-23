<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.ArrayList"%>
<%@page import="com.ipablive.vo.CityVO"%>
<%@page import="com.ipablive.vo.DepartmentVO"%>
<%@page import="com.ipablive.commons.CommonOperations"%>
<%@page import="com.ipablive.core.Blogs"%>
<%@page import="com.ipablive.vo.BlogPostVO"%><html>
<head>
    <meta http-equiv="content-type" content="text/html;charset=utf-8" />
    <title>Blog</title>
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
function deletePostConfirm(postId)
{
	var altTxt = "You are trying to delete "+postId+" post.\n Click 'OK' to continue to delete. \n Click 'Cancel' to cancel the submission. '";
	if (confirm(altTxt))
	{
		window.location.href = 'DeletePost.jsp?p='+postId; 
	}
	else
	{
	}
}
</script>
</head>
<body>
<%@include file="../../header.jsp" %>
<div class="clear"></div>
<div id="bg-wrapper">
	<div class="breadcrumb">
		<div class="clear"></div>
			<a href="${pageContext.request.contextPath}" style="text-decoration: none;">Home</a> > Blogs
	<center><br>
	<h2 class="pageHeaderH2">Blogs - Admin</h2>
	</center>
	</div>
<%
Blogs blogs = Blogs.getInstance();
ArrayList<BlogPostVO> blogPosts = blogs.getBlogPosts();

if(blogPosts.size()>0)
{
	for(int i=0; i<blogPosts.size();i++)
	{
		BlogPostVO post = blogPosts.get(i);
%>
	<div class="blog-block-box">
	<h2><%=post.getPostTitle() %></h2>
<div class="clear"></div>
	<div class="divContent">
        Submitted by <strong><%=post.getPostedBy() %></strong> on <%=post.getPostCreatedDate() %>
    </div>
<div class="clear"></div><div class="clear"></div>
	<div class="divContent">
	    <%
	    	String postContent = post.getPostContent();
	    	if(postContent.length()>200)
	    	{
	    		postContent = postContent.substring(0,197) +"...";
	    	}
	    	
	    	out.println(postContent);
	    %>
	  </div>
		<div class="clear"></div><div class="clear"></div>
	<div class="divContent" align="right">
	<input type="button" value="Delete This Post" onclick="deletePostConfirm(<%=post.getPostId() %>)">
	</div>
	</div>

<%
	}
}
else
{
%>
<div class="blog-block-box">
	<center><font color="red"><b>Oops.. There are no posts available</b></font></center>
</div>
<%
}
%>

<%@include file="../../footer.jsp" %>
</div>
</body>
</html>