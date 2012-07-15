
<%@page import="com.ipablive.core.Home"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ipablive.vo.NewsVO"%>
<%@page import="com.ipablive.vo.ExpertSpeakVo"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/theme/js/jcarousellite.js"></script>
<script type="text/javascript">
$(document).ready(
		function()
		{
			$(".news_box").jCarouselLite({
				vertical: true,
				hoverPause:true,
				auto:500,
				speed:1000
			});
});
</script>

<h2 class="home_h2"  style="width: 100%;" align="center">I Paid a Bribe in the <span>News!</span></h2>
<%
	Home myHome = Home.getInstance();
	ArrayList<NewsVO> news = myHome.getNews(2);
%>


<div class="news_box" style="overflow: hidden;">
                <ul>
					<%
		if(news.size()>0)
		{
			for (int i=0;i<news.size();i++)
			{
				
				NewsVO newsObj = news.get(i);
	%>
                    <li>
						<div class="divContent">
						<%
							if(newsObj.getNewsDst().startsWith("http"))
							{
								%>
								<a href="<%=newsObj.getNewsDst() %>"><%=newsObj.getNewsTitle() %> </a>
								<%
							}else
							{
								%>
								<%=newsObj.getNewsTitle() %> 
								<%
							}
						%>
						</div>
						<div class="clear"></div>
						<div class="divContent">
						<%=newsObj.getNewsBody() %>
						</div>
						<div class="clear"></div>
						<div class="divContent">
						By <%=newsObj.getNewsCreated() %> &nbsp;&nbsp;|&nbsp;&nbsp; <%=newsObj.getFriendlyDate() %>
						</div>
                    </li>
<%
							}
			
			}else
			{
				out.println("No News to share.");
			}%>
                </ul>
            </div>
<% if( news.size()>0 ) {%>
                	<div class="seeAll"><a href="${pageContext.request.contextPath}/getBlog?t=news" title="View more">See all</a></div>
				<%} %>

