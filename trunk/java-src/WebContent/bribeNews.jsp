
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
		speed:2000
	});
});
</script>
<div class="grid">
<h2 class="home_h2 news_box_title">I Paid a Bribe in the <span>News!</span></h2>
<%
	Home myHome = Home.getInstance();
	ArrayList<NewsVO> news = myHome.getNews();
%>


<div class="news_box">
                <ul>
					<%
		if(news.size()>0)
		{
			for (int i=0;i<news.size();i++)
			{
				
				NewsVO newsObj = news.get(i);
	%>
                    <li>
                        <div class="newsSub"><span>
						<%=newsObj.getNewsSourceValue() %></a></span> | <%=newsObj.getNewsCreated() %></a></div>
				
                        <div class="newsTitle">
                        		<a href="<%=newsObj.getNewsDst() %>"  >
							<%=newsObj.getNewsTitle() %>
                            </a>
                        </div>

                    </li>
<%
							}
			
			}else
			{
				out.println("No News to share.");
			}%>
                </ul>
				<% if( news.size()>0 ) {%>
                	<div class="seeAll"><a href="<?php echo url('sforms/ipab_in_the_press');?>" title="View more">See all</a></div>
				<%} %>
            </div>
<!----- Break ----->

 <h2 class="home_h2">Expert <span>Speak</span></h2>
            <div class="news_box">
                <ul >
                
					<%
					ArrayList<ExpertSpeakVo> experts = myHome.getExpertSpeak();
					
		if(experts.size()>0)
		{
			for (int i=0;i<experts.size();i++)
			{
				
				ExpertSpeakVo esObj = experts.get(i);
	%>
                    <li>
                        <div class="newsSub" onclick="aptesting('<?php echo base64_encode('homepage2'); ?>','<?php echo  base64_encode('2'); ?>')"><span><%=esObj.getAuthorName() %> | <%=esObj.getCreated() %></a></div>
                       <?php /*?> <div class="newsTitle"><?php echo $row->body ?></div><?php */?>
                         <div  onclick="#"><p><a href="<%=esObj.getFieldTitleURL() %>" target="_blank" class="newsTitleb" ><%=esObj.getTitle() %></a></p></div>
                        <div class="clear"></div>      
                    </li>
					<%=esObj.getAuthorName() %>             
                
                 </ul>
            </div>
				<%
							}
			
			}else
			{
				out.println("No data to display now.");
			}%>
                </ul>
				<% if( experts.size()>0 ) {%>
                	<div class="seeAll"><a href="<?php echo url('sforms/ipab_in_the_press');?>" title="View more">See all</a></div>
				<%} %>   
                 <br />        
            <div class="clear"></div>
</div>
<!--#End Gird 3-->
