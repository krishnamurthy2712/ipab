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
		href="${pageContext.request.contextPath}/theme/css/style.css"
		rel="stylesheet" />
</head>
<body>
<%@include file="../../header.jsp" %>
<div class="pageHeader">
<center><br>
<h2 class="pageHeaderH2">Blog</h2>
</center>
</div>
<div id="mainContent" class="mainContent">
<%
Blogs blogs = Blogs.getInstance();
ArrayList<BlogPostVO> blogPosts = blogs.getBlogPosts();

if(blogPosts.size()>0)
{
	for(int i=0; i<blogPosts.size();i++)
	{
		BlogPostVO post = blogPosts.get(i);
%>
	<div class="node">
	<h2><%=post.getPostTitle() %></h2>

	</div>

<%
	}
}
else
{
%>
	<center><font color="red"><b>Oops.. There are no posts available</b></font></center>
<%
}
%>


</div>
<%@include file="../../footer.jsp" %>
</body>
</html>