<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.ArrayList"%>
<%@page import="com.ipablive.vo.CityVO"%>
<%@page import="com.ipablive.vo.DepartmentVO"%>
<%@page import="com.ipablive.commons.CommonOperations"%>
<%@page import="com.ipablive.core.Home"%>
<%@page import="com.ipablive.vo.NewsVO"%><html>
<head>
    <meta http-equiv="content-type" content="text/html;charset=utf-8" />
    <title>About Us</title>
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
<div id="bg-wrapper" class="bg-wrapper">
	<div class="breadcrumb">
			<div class="clear"></div>
				<a href="${pageContext.request.contextPath}" style="text-decoration: none;">Home</a> > News
		<center><br>
		<h2 class="pageHeaderH2">News</h2>
		</center>
		</div>
<%
	Home myHome = Home.getInstance();
	ArrayList<NewsVO> news = myHome.getNews(0);
	if(news.size()>0)
	{
		for(int i=0;i<news.size();i++)
		{
			NewsVO nVo = news.get(i);
			%>
			<div class="news-block-box1">
			<div class="divContent">
				<%
					if(nVo.getNewsDst().startsWith("http"))
					{
						%>
						<a href="<%=nVo.getNewsDst() %>"><%=nVo.getNewsTitle() %> </a>
						<%
					}else
					{
						%>
						<%=nVo.getNewsTitle() %> 
						<%
					}
				%>
				</div>
				<div class="clear"></div>
				<div class="divContent">
				<%=nVo.getNewsBody() %>
				</div>
				<div class="clear"></div>
				<div class="divContent">
				By <%=nVo.getNewsCreated() %> &nbsp;&nbsp;|&nbsp;&nbsp; <%=nVo.getFriendlyDate() %>
				</div>
			</div>
			
			<%
		}
	}
%>

<%@include file="../footer.jsp" %>
</div>
</body>
</html>