
<%@page import="com.ipablive.core.Polls"%>
<%@page import="java.util.StringTokenizer"%>
<div class="todayPoll pollResults">
<h3 align="center">Poll Results</h3>
<%
Polls pollObj = Polls.getInstance();
String optionsGiven = request.getParameter("optionsGiven");

String poll = request.getParameter("pollId");
int pollId = Integer.parseInt(poll);

StringTokenizer st = new StringTokenizer(optionsGiven, "|");
int total = 0;
total = pollObj.getCount(pollId,"");
%>
<table align="center" style="margin: 5px; width: 100%">
<tr>
	<td>Option</td>
	<td>total</td>
	<td>%</td>
</tr>
<%
while(st.hasMoreTokens()) 
{
	String option = st.nextToken() ;
	
	int polls = pollObj.getCount(pollId,option);
	%>
<tr>
	<td><%=option %></td>
	<td> <%=polls %></td>
	<td> <%=polls!=0?((polls/total)*100):0 %>%</td>
</tr>
	<%
}
%>
</table>
</div>