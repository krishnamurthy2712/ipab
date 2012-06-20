<%@page import="com.ipablive.vo.BribeFighterVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ipablive.core.Home"%>
<div class="grid">
        <div class="bribeFighters">
        <h2 class="home_bribeFighters_h2"><img src="${pageContext.request.contextPath}/theme/images/bribe.png" align="middle">ribe <span>Fighters</span></h2>
        	<div class="bribeFightersContent">
            	<div class="bribeReports">
					                            
            <%
           	Home home1 = Home.getInstance();	
		 	ArrayList<BribeFighterVO> fighters = home1.getBribeFighters();
		 
		 	if(fighters.size()>0)
		 	{
		 		for(int i=0;i<fighters.size();i++)
		 		{
		 			BribeFighterVO fighter = fighters.get(i);
            %>                
                                    <div class="bribeItems">
                                        <div class="popularCity">From Winneba | About <a href="http://www.ipaidabribe.or.ke/sforms/view_reports_didnt_pay?c_dept=27&amp;CSRF_TOKEN=">Judiciary</a></div>
                                        <div class="popularDate"><span>1 hour ago  </span></div>
                                        <div class="popularTitle">
                                            <a href="http://www.ipaidabribe.or.ke/sforms/view_comments_didnt_pay?id=1770&amp;CSRF_TOKEN=">
                                                A close relative has had
 an issue in court. Everytime the matter is about to come up for 
mention, the file disappears. B                                        
    </a>
                                        </div>
                                    </div>
                                                        
      <% 
      		
		 			
		 		}
		 	}
		 	else
		 	{
		 		%>
		 		
		 		<%
		 	}
		 
      %>                      
                                   
</div>
                        <div class="seeAllList">
                        	<ul>
                            	<li><a title="View more" href="http://www.ipaidabribe.or.ke/sforms/view_reports_didnt_pay?CSRF_TOKEN=">See all</a></li>
                                <li><a title="View more" href="http://www.ipaidabribe.or.ke/sforms/view_reports_didnt_pay?c_dept=2&amp;CSRF_TOKEN=">Department-wise</a></li>
                            </ul>
                        </div>
                        <div class="clear"></div>                                  
                    <div class="all_categories">
                    <div class="categoryHead">
                    Have you resisted a bribe?</div>
                        <div class="categoryList">
                            <a href="http://www.ipaidabribe.or.ke/sforms/register/i_didnt_pay_a_bribe?CSRF_TOKEN=">
                            <img src="I%20PAID%20A%20BRIBE_files/tellUsHow.png" alt="REPORT YOUR BRIBE">
                            </a>
                        </div>
                    </div>                    
               </div>
          </div>
       <div class="clear"></div>
          <!----- Break ----->   
        
        <h2 class="home_h2">Latest <span>Videos</span></h2>
        
        <div class="latest_videos">
        	<div style="position:relative;">
					<div id="video-container">                
					                      
                        <div style="display: none;" id="div1">
                            <div class="update-thumbnail-img">
                                <a href="http://www.ipaidabribe.or.ke/content/corruption-still-high-kenya?CSRF_TOKEN=" id="lcwm4yaom4w"><img src="I%20PAID%20A%20BRIBE_files/default_vid.png" class="youtube" align="absmiddle"></a>
								<div id="video-title"><a href="http://www.ipaidabribe.or.ke/content/corruption-still-high-kenya?CSRF_TOKEN=" id="lcwm4yaom4w">Corruption Still High in Kenya</a></div>
                            </div>
                            <!--<div class="update-img-title"><a href="/content/corruption-still-high-kenya">Corruption Still High in Kenya</a></div>-->
                        </div>

											<ul>
							<li><a href="javascript:updatesSlider(1,'img1','/sites/all/themes/ipab_client/images/circle_selected.png','/sites/all/themes/ipab_client/images/circle_over.png')?CSRF_TOKEN="><img src="I%20PAID%20A%20BRIBE_files/circle_selected.png" id="img1"></a></li>
							<li><a href="javascript:updatesSlider(2,'img2','/sites/all/themes/ipab_client/images/circle_selected.png','/sites/all/themes/ipab_client/images/circle_over.png')?CSRF_TOKEN="><img src="I%20PAID%20A%20BRIBE_files/circle_over.png" id="img2"></a></li>
							<li><a href="javascript:updatesSlider(3,'img3','/sites/all/themes/ipab_client/images/circle_selected.png','/sites/all/themes/ipab_client/images/circle_over.png')?CSRF_TOKEN="><img src="I%20PAID%20A%20BRIBE_files/circle_over.png" id="img3"></a></li>							
						</ul>			<div class="seeAll"><a href="http://www.ipaidabribe.or.ke/sforms/on_air?CSRF_TOKEN=" title="View more">View more</a></div>
</div></div>
      </div>
		<div id="videowrapper"></div>
        <div class="clear"></div>
                    <script type="text/javascript">
						updatesSlider();
					</script>
        <!---- Break ---->

        	<h2 class="home_h2">What is your <span>CQ?</span></h2>
        <div class="cq_box">
        	<div class="cq_box_content">"You pay 2,000/- to get a driving license without taking a driving test. Would you consider this a bribe?"
				<a href="http://www.ipaidabribe.or.ke/sforms/corruption_quiz?CSRF_TOKEN=">Take the quiz, check your Corruption Quotient</a>
            </div>
        </div>
                
    </div><!--#End Gird 2--> 