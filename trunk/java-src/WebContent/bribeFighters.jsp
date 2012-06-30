<%@page import="com.ipablive.vo.BribeFighterVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ipablive.core.Home"%>
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
                                        <div class="popularCity">From <%=fighter.getCCity() %> | About <a href="#"><%=fighter.getCDeptName() %></a></div>
                                        <div class="popularDate"><span><%=fighter.getFriendlyTime() %>  </span></div>
                                        <%
				String complaintName = "";
			
				if(fighter.getCAdditionalInfo().equals(""))
				{
					if(fighter.getCName().length()>120)
					{
						complaintName = fighter.getCName().substring(0, 116) + " ...";
					}
					else
					{
						complaintName = fighter.getCName();
					}
				}
				else
				{
					if(fighter.getCAdditionalInfo().length()>120)
					{
						complaintName = fighter.getCAdditionalInfo().substring(0, 116)+" ...";
					}
					else
					{
						complaintName = fighter.getCAdditionalInfo();
					}
				}
			%>
										<div class="popularTitle">
                                            <a href="#"><%=complaintName %>                                   
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
        
        
