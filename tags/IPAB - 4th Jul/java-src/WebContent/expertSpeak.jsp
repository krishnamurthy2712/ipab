
<%@page import="com.ipablive.core.Home"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ipablive.vo.ExpertSpeakVo"%>
<div class="grid">
 <h2 class="home_h2">Expert <span>Speak</span></h2>
            <div class="news_box">
                <ul >
                
					<%
					Home myHome1 = Home.getInstance();
					ArrayList<ExpertSpeakVo> experts = myHome1.getExpertSpeak();
					
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
</div>