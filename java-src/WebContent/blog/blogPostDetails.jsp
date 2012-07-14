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
</head>
<body>
<%@include file="../header.jsp" %>
<%
String pid = request.getParameter("p");
int postId = Integer.parseInt(pid);
Blogs blogs = Blogs.getInstance();
Boolean isPageVisitUpdated = blogs.updateTotalViews(postId);
BlogPostDetailsVO post = blogs.getBlogPostDetails(postId);

%>
<div class="clear"></div>
<div id="bg-wrapper">
	<div class="breadcrumb">
		<div class="clear"></div>
			<a href="${pageContext.request.contextPath}" style="text-decoration: none;">Home</a> 
			> <a href="${pageContext.request.contextPath}/blog/blog.jsp" style="text-decoration: none;">Blogs</a> > <%=post.getPostTitle() %>
	<center><br>
	<h2 class="pageHeaderH2">Blogs</h2>
	</center>
	</div>

	<div class="blog-block-box">
		<h2><%=post.getPostTitle() %></h2>
<div class="clear"></div>
		<div class="divContent" align="right">
	        Submitted by <strong><%=post.getPostedBy() %></strong> on <%=post.getPostCreatedDate() %>
<div class="clear"></div><div class="clear"></div>
	    </div>
		<div class="divContent">
			<%=post.getPostContent() %>
		</div><br>
		<div class="clear"></div>
		<strong>Comments</strong>
		<div class="clear"></div>
		<div class="divContent">
			<% ArrayList<BlogCommentVO> comments = post.getPostComments();
			
				if(comments.size()>0)
				{
					for(int i=0 ;i<comments.size();i++)
					{
						BlogCommentVO comment = comments.get(i);
						%>
						<div class="vote_comment">
						<div class="divContent">
							<%=comment.getCommentTitle() %>
						</div>
						<div class="divContent">
							<%=comment.getCommentContent() %>
						</div>
<div class="clear"></div><div class="clear"></div>
						<table>
							<tr>
								<td><%=comment.getCreatedBy() %>|</td>
								<td><%= BribeUtils.getFriendlyTime(comment.getCreationDate()) %></td>
							</tr>
						</table>
						</div>
						<%
					}
				}else
				{
					%>
						<center><b>No Comments Found. Be <a href="${pageContext.request.contextPath}/blog/addBlogComments.jsp?p=<%=postId %>">First</a>one to Comment.</b></center>
					<%
				}
			
			%>
		</div>

	</div>

<%@include file="../footer.jsp" %>
</div>
</body>
</html>