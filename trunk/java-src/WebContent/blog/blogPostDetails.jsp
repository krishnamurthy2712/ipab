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
		href="${pageContext.request.contextPath}/theme/css/style.css"
		rel="stylesheet" />
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
					for(int i=0;i<comments.size();i++);
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
						<center><b>No Comments Found. Be <a href="${pageContext.request.contextPath}/blog/addBlogComments.jsp?p=<%=postId %>">First</a>one to Comment.</b></center>
					<%
				}
			
			%>
		</div>

	</div>

</div>
<%@include file="../footer.jsp" %>
</body>
</html>