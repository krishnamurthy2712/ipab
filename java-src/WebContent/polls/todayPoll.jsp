<%@page import="com.ipablive.core.Polls"%>
<%@page import="com.ipablive.vo.PollVO"%>
<%@page import="java.util.StringTokenizer"%>
<script type="text/javascript">
function validateVoting()
{
	var pollAns = document.getElementById("pollAns").value;
	alert(pollAns);

	if(pollAns.length<1)
	{
		alert("Please select your option");
		return false;
	}
	
	return true;
}
</script>

<div class="todayPoll">
<%
Polls pollObj = Polls.getInstance();
PollVO pVo = pollObj.getTodaysPoll();
if(pVo!=null)
{
	
%>
	<div class="divContent">
		<%=pVo.getPollQuestion() %>
	</div>
<%
	StringTokenizer st = new StringTokenizer(pVo.getPollOptions(), "|");
	while(st.hasMoreTokens()) 
	{
		String option = st.nextToken() ;
		
		%>
		<input type="radio" id="pollAns" name="pollAns" value="<%=option %>"><%=option %><br>
		<%	
	}

}else
{
	out.println("No Polls displayed for today.");
}
%>
<div class="divContent" align="right">
	<input type="button" value="Vote" onclick="return validateVoting()">
</div>

<div class="divContent" align="right">
</div>
</div>