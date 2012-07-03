
<%@page import="com.ipablive.vo.TopFiveDeptsVO"%>
<%@page import="com.ipablive.vo.TopFiveCitiesVO"%><div class="grid">
<h2 class="home_h2">Bribe <span>Reports: Top 5</span></h2>
        <div style="float:left">
            <div class="tabcontent">
                    
                <ul class="tabs">
                    <li class="active"><a href="#tab1" title="Departments">Departments</a></li>
                    <li class="last"><a href="#tab2" title="Counties">Counties</a></li>
                </ul>
        
                <div style="display: block;" id="tab1" class="tab_container">
                
        			<div class="headerLables">
                        <div class="departments">&nbsp;</div>
                        <div class="reports"><strong>Reports | </strong></div>
                        <div class="amount"><strong>Amount</strong><br /><font size="1">(in GHC)</font></div>
                    </div>
                    <div class="clear"></div><br />
                    
<%
 	Home homeObj = Home.getInstance();
	ArrayList<TopFiveDeptsVO> topDepts = homeObj.getTopFiveDepartments();

%>

                <div style="display: block;" id="tab1" class="tab_content">
                	<div class="bribeReports">
			  
                      	<%
                      	if(topDepts.size()>0)
                      	{
                      		for(int i=0; i<topDepts.size();i++)
                      		{
                      			TopFiveDeptsVO topDep = topDepts.get(i);
                      			%>
                      			<div class='bribeItems'>
	                               <div class='popularCity'>
	                                   <div class="contentLables">
										<div class="departments">
											<a href='/sforms/view_reports_paid?c_dept=14'><%=topDep.getDeptName() %></a>
	                                       </div> 
	                                       <div class="reports"><span><%=topDep.getTotalRecs() %></span></div>
	                                       <div class="amount"><%=topDep.getTotalAmount() %></div>
	                                   </div>
	                                   <div class="clear"></div>
	                               </div>
	                           </div>
                      			<%
                      		}
                      	}
                      	%>
                </div>
                   </div>


                    <div style="display: block;" id="tab2" class="tab_content">
                       	<div class="bribeReports">

<%
ArrayList<TopFiveCitiesVO> topCities = homeObj.getTopFiveCities();
if(topCities.size()>0)
	{
		for(int i=0; i<topCities.size();i++)
		{
			TopFiveCitiesVO topCity = topCities.get(i);
%>
                   <div class='bribeItems'>
                      <div class='popularCity'>
                          <div class="contentLables">
							<div class="departments">
								<a href='/sforms/view_reports_paid?c_dept=14'><%=topCity.getCityName() %></a>
	                            </div> 
	                            <div class="reports"><span><%=topCity.getTotalRecs() %></span></div>
	                            <div class="amount"><%=topCity.getTotalAmount() %></div>
	                        </div>
	                        <div class="clear"></div>
	                    </div>
	                </div>
            			<%
	}
}
%>
					</div>
</div>
                   <div class="moreAnalysis"><a href="/bribepatterns/index.jsp">Complete Analysis of Bribe Reports</a></div>                       
                
           </div>
                    
     </div>
     
     <div class="clear"></div>

	<%@include file="../../bribeFighters.jsp" %>
	<div class="clear"></div>
	<%@include file="../../bribeNews.jsp" %>

</div>





	
    