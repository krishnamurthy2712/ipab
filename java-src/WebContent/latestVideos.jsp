
<%@page import="com.ipablive.core.YouTubeManager"%>
<%@page import="com.ipablive.vo.YouTubeVideoVO"%>
<%@page import="java.util.List"%><script type="text/javascript" src="${pageContext.request.contextPath}/theme/js/jcarousellite.js"></script>
<script type="text/javascript">
$(document).ready(
		function()
		{
			$("#slider").jCarouselLite({
				vertical: true,
				hoverPause:true,
				auto:500,
				speed:500
			});
});
</script>
<div>
<h2 class="home_h2" align="center">Latest <span>Videos</span></h2>
        
 <div class="latest_videos" style="height: 200px; overflow: hidden;">
<div id="slider">
<ul>
<%
YouTubeManager ym = YouTubeManager.getInstance();

List<YouTubeVideoVO> videos = ym.retrieveVideos(2);

for (YouTubeVideoVO youtubeVideo : videos) 
{
	String myThumbnail = "";
    for (String thumbnail : youtubeVideo.getThumbnails()) 
    {
    	myThumbnail = thumbnail;
    }
    %>
    <li><a href="<%=youtubeVideo.getWebPlayerUrl() %>" target="_blank"><img src="<%=myThumbnail %>" alt="Bribe videos" /></a>
	<%=youtubeVideo.getVideoTitle() %>
	<div class="clear"></div>
	<%=youtubeVideo.getVideoComments().size() %> Comments.
	</li>
	<div class="clear" style="height: 2px;"></div>
    <%
}
%>
</ul>
</div>
</div> 
<div class="clear"></div> 
<div class="seeAll"><a href="${pageContext.request.contextPath}/getBlog?t=videos" title="View more">See all videos</a></div> 
 </div>    
