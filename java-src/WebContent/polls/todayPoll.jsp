<%@page import="com.ipablive.core.Polls"%>
<%@page import="com.ipablive.vo.PollVO"%>
<%@page import="java.util.StringTokenizer"%>
<script type="text/javascript">
function validateVoting()
{
	var pollAns = $('#pollAns').val();

	if(pollAns.length<1)
	{
		alert("Please select your option");
		
	}
	else
	{
		 // get the form values
	     var pollOption = $('#pollAns').val();
	     var pollId = $('#pollId').val();
	     var userName = $('#pollUser').val();
	     var optionsGiven = $('#optionsGiven').val();
	     
		 $.ajax({
			  type: 'GET',
			  url: 'pollResult',
			  data: "pollOption="+pollOption+"&pollId="+pollId+"&pollUser="+userName+"&optionsGiven="+optionsGiven,
			  beforeSend:function(){
			    // this is where we append a loading image
			    $('#resultsArea').html('<div class="loading"><img src="${pageContext.request.contextPath}/theme/images/loading.gif" alt="Loading..." /></div>');
			  },
			  success:function(response){
			    // successful request; do something with the data
			   $('#resultsArea').empty();
			    $('#resultsArea').html(response);
			  },
			  error:function(){
			    // failed request; give feedback to user
			    $('#resultsArea').html('<p align="center"><font color="red"><strong>unable to submit your poll.</strong></font></p>');
			  }
		 });
	}

}
</script>
<h3 align="center" style="width: 150px;">Todays poll</h3>
<div class="todayPoll" id="pollContent">
<%
Polls pollObj = Polls.getInstance();
PollVO pVo = pollObj.getTodaysPoll();
if(pVo!=null)
{
	
%>
	<input type="hidden" value="<%=pVo.getPollId() %>" name="pollId" id="pollId">
	<input type="hidden" value="<%=pVo.getPollOptions() %>" name="optionsGiven" id="optionsGiven">
	<div class="clear"></div>
	<div class="clear"></div>

	<div class="divContent">
		<%=pVo.getPollQuestion() %>
	</div>
	<div class="clear"></div>
	<div id="resultsArea">
<%
	StringTokenizer st = new StringTokenizer(pVo.getPollOptions(), "|");
	int i = 0;
	
	while(st.hasMoreTokens()) 
	{
		String option = st.nextToken() ;
		%>
		<input type="radio" id="pollAns" name="pollAns" value="<%=option %>"><%=option %><br>
		<div class="clear"></div>
		<%
		i++;
	}

}else
{
	out.println("No Polls displayed for today.");
}
%>
<div class="clear"></div>
<div class="divContent" align="right" >
	<input type="hidden" value="anonymous" name="pollUser">
	<input type="button" value="Vote" onclick="validateVoting()">
</div>
</div>
<div class="clear"></div>
<div class="divContent" align="right">
<ul style="list-style: none;margin: 5px;" >
<li><a href="" style="text-decoration: none;">View Poll Results</a></li>
<li><a href="" style="text-decoration: none;">View All Polls</a></li>
</ul>
</div>
</div>