<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.ArrayList"%>
<%@page import="com.ipablive.vo.CityVO"%>
<%@page import="com.ipablive.vo.DepartmentVO"%>
<%@page import="com.ipablive.commons.CommonOperations"%>
<%@page import="com.ipablive.core.YouTubeManager"%>
<%@page import="com.ipablive.vo.YouTubeVideoVO"%>
<%@page import="java.util.List"%><html>
<head>
    <meta http-equiv="content-type" content="text/html;charset=utf-8" />
    <title>Videos</title>
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
function show_less(num)
{
	$('#more_link'+num).css('display','block');
	$('#less_link'+num).css('display','none');		
	$('#more_d_'+num).css('display','none');
	$('#less_d_'+num).fadeIn();
}

function show_more(num)
{
	$('#less_link'+num).css('display','block');
	$('#more_link'+num).css('display','none');			
	$('#less_d_'+num).css('display','none');
	$('#more_d_'+num).fadeIn();
}	
</script>

</head>
<body>
<%@include file="../header.jsp" %>
<div class="clear"></div>
<div id="bg-wrapper" class="bg-wrapper">
	<div class="breadcrumb">
			<div class="clear"></div>
				<a href="${pageContext.request.contextPath}" style="text-decoration: none;">Home</a> > Videos
		<center><br>
		<h2 class="pageHeaderH2">Watch videos</h2>
		</center>
		</div>

<%
YouTubeManager ym = YouTubeManager.getInstance();
List<YouTubeVideoVO> videos = ym.retrieveVideos(0);
String display = "style='display:none;'";
String readMore = "style='display:block;'";
int count = 1;

for (YouTubeVideoVO youtubeVideo : videos) 
{
%>
<div class="video-block-box">
<h3><%=youtubeVideo.getVideoTitle() %></h3>
<p><object height="480" width="640">
<param name="movie" value="<%=youtubeVideo.getEmbeddedWebPlayerUrl() %>" />
<param name="allowFullScreen" value="true" /><param name="allowscriptaccess" value="always" />
<embed height="480" src="<%=youtubeVideo.getEmbeddedWebPlayerUrl() %>" type="application/x-shockwave-flash" width="640"></embed>
</object></p>

<div class="clear"></div>
				<div id="more_link<%=count %>" <%=readMore %> align="right">
					<div class="report_reg_more">
			            <a href="#" class="rad" onclick="show_more('<%=count %>'); return false;">Read More</a> 
		            </div>
				</div>
				<div class="clear"></div>
				<div id="more_d_<%=count %>" <%=display %>>
				<%
					ArrayList<String> comments = youtubeVideo.getVideoComments();
					if(comments.size()>0)
					{
						for(int i=0; i<comments.size();i++)
						{
							%>
							<div class="clear"></div>
							<div class="vote_comment" align="left">
								<%=comments.get(i) %>
							</div>
							<div class="clear"></div>
							<%
						}
					}
					else
					{
						%>
						<div class="vote_comment" align="left">
							<strong>No Comments to display.</strong>
						</div>
						<%
					}
				
				%>
				<div class="clear"></div><div class="clear"></div>
				<div class="share_tool_d" align="right">
					<div id="less_link<%=count %>">
						<div class="report_reg_more">
							<a href="#" class="rad" onclick="show_less('<%=count %>'); return false;">Read less...</a> 
						</div>
					</div>
				</div>
		</div>

</div>
<%
count++;
} %>
<%@include file="../footer.jsp" %>
</div>
</body>
</html>