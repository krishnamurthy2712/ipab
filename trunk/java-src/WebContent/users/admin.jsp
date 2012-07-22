<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
 UserVO user = (UserVO) session.getAttribute("loggedInUser");
if(user==null)
{
	response.sendRedirect("http://localhost:8080/ipab-java/entry?cmd=login");
}
%>
<head>
    <meta http-equiv="content-type" content="text/html;charset=utf-8" />
    <title><%=user.getLastName() %>'s Profile</title>
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
<div class="clear"></div>
<div id="bg-wrapper">
<div class="breadcrumb">
	<div class="clear"></div>
		<a href="${pageContext.request.contextPath}" style="text-decoration: none;">Home</a> > <%=user.getLastName() %>'s Profile
<center><br>
<h2 class="pageHeaderH2"><%=user.getLastName() %>'s Profile</h2>
</center>
</div>

<div class="admin-block-box-left">
<h3>My Profile</h3>
<div class="clear"></div>
<%@include file="profile.jsp" %>
</div>

<div class="admin-block-box-right">
<h3>My Activities</h3>
<div class="admin-activities">
<h3>Blogs</h3>
<ul style="list-style: none;">
<li>Click <a href="${pageContext.request.contextPath}/admin?cmd=blogs">here</a> to see all blogs</li>
<li>Click <a href="${pageContext.request.contextPath}/admin?cmd=newPost">here</a> to add new post</li>
</ul>
</div>
<div class="admin-activities">
<h3>News</h3>
<ul style="list-style: none;">
<li>Click <a href="${pageContext.request.contextPath}/admin?cmd=news">here</a> to see News</li>
<li>Click <a href="${pageContext.request.contextPath}/admin?cmd=new">here</a> to add news</li>
</ul>
</div>
<div class="admin-activities">
<h3>Polls</h3>
<ul style="list-style: none;">
<li>Click <a href="${pageContext.request.contextPath}/admin?cmd=polls">here</a> to see all polls</li>
<li>Click <a href="${pageContext.request.contextPath}/admin?cmd=newpoll">here</a> to add new poll</li>
</ul>
</div>
<div class="admin-activities">
<h3>Videos</h3>
<ul style="list-style: none;">
<li>Click <a href="${pageContext.request.contextPath}/admin?cmd=videos">here</a> to see all videos</li>
<!--<li>Click <a href="">here</a> to add new video</li>-->
</ul>
</div>

</div>


<%@include file="../footer.jsp" %>
</div>
</body>
</html>