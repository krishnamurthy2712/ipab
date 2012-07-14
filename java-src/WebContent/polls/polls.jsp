<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.ArrayList"%>
<%@page import="com.ipablive.vo.CityVO"%>
<%@page import="com.ipablive.vo.DepartmentVO"%>
<%@page import="com.ipablive.commons.CommonOperations"%>
<%@page import="com.ipablive.core.Polls"%>
<%@page import="com.ipablive.vo.PollVO"%>
<%@page import="java.util.StringTokenizer"%>
<%@page import="com.ipablive.utils.BribeUtils"%>
<%@page import="com.ipablive.vo.PollCommentsVO"%><html>
<head>
    <meta http-equiv="content-type" content="text/html;charset=utf-8" />
    <title>Polls</title>
	<script src="${pageContext.request.contextPath}/theme/js/jquery.js"
		type="text/javascript">
		</script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/theme/js/menu.js"></script>
	
	<script
		src="${pageContext.request.contextPath}/theme/js/jquery.ui.core.js"></script>
	<script
		src="${pageContext.request.contextPath}/theme/js/jquery.ui.widget.js"></script>
	<script
		src="${pageContext.request.contextPath}/theme/js/jquery.ui.datepicker.js"></script>
	
	<link type="text/css"
		href="${pageContext.request.contextPath}/theme/css/menu.css"
		rel="stylesheet" />
	<link type="text/css"
		href="${pageContext.request.contextPath}/theme/css/newstyles.css"
		rel="stylesheet" />

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

	function show_less(num)
	{
		$('#more_link'+num).css('display','block');
		$('#less_link'+num).css('display','none');		
		$('#more_d_'+num).css('display','none');
		$('#less_d_'+num).fadeIn();
	}

	function show_more(num)
	{
		$('#less_link'+num).css('display','block');
		$('#more_link'+num).css('display','none');			
		$('#less_d_'+num).css('display','none');
		$('#more_d_'+num).fadeIn();
	}

	function addComment(num)
	{
		var user = $('#userName'+num).val();
		var comment = $('#commentContent'+num).val();
		var myUrl = '${pageContext.request.contextPath}/pollComment'
		if(user.length==0)
		{
			alert("Please enter user name");
		}else if(comment.length==0)
		{
			alert("Please enter user name");
		}
		else
		{
			 $.ajax({
				  type: 'GET',
				  url: myUrl ,
				  data: "p="+num+"&u="+user+"&c="+comment,
				  beforeSend:function(){
				    // this is where we append a loading image
				    $('#commentsArea').html('<div class="loading"><img src="${pageContext.request.contextPath}/theme/images/loading.gif" alt="Loading..." /></div>');
				  },
				  success:function(response){
				    // successful request; do something with the data
				   /*$('#commentsArea').empty();
				    $('#commentsArea').html(response);*/
				  },
				  error:function(){
				    // failed request; give feedback to user
				    $('#commentsArea').html('<p align="center"><font color="red"><strong>unable to submit your Comment.</strong></font></p>');
				  }
			 });
		}
	}
	</script>

</head>
<body>
<%@include file="../header.jsp" %>
<div class="clear"></div>
<div id="bg-wrapper">
	<div class="breadcrumb">
		<div class="clear"></div>
			<a href="${pageContext.request.contextPath}" style="text-decoration: none;">Home</a> > Polls
	<center><br>
	<h2 class="pageHeaderH2">I Paid a Bribe</h2>
	</center>
	</div>

<%
	Polls pollObj = Polls.getInstance();
	String poll = request.getParameter("p");
	String type = request.getParameter("t");
	String ipAddress = BribeUtils.getClientIpAddr(request);
	
	if(type!=null && type.equalsIgnoreCase("all"))
	{
		ArrayList<PollVO> allPolls = pollObj.getAllApprovedPolls();
		if(allPolls.size()>0)
		{
			for(int i=0;i<allPolls.size();i++)
			{
				PollVO pol = allPolls.get(i);
				%>
				<div class="polls-block-box">
					<div class="divContent">
					<%=pol.getPollId() %>) <strong><%=pol.getPollTitle() %></strong>
					</div>
					<div class="clear"></div>
					<div class="divContent">
					<strong>Description</strong>	<%=pol.getPollDescription() %>
					</div>
					<div class="clear"></div>
				
					<div class="divContent">
						<%=pol.getPollQuestion() %>
					</div>
					<div class="clear"></div>
					<%
					StringTokenizer st = new StringTokenizer(pol.getPollOptions(), "|");
					
					while(st.hasMoreTokens()) 
					{
						String option = st.nextToken() ;
						%>
						<input type="radio" id="pollAns" name="pollAns" value="<%=option %>"><%=option %><br>
						<div class="clear"></div>
						<%
					}
					
					%>
					<div class="divContent" align="right" >
						<input type="hidden" value="anonymous" name="pollUser">
						<%
							Boolean isPolled = pollObj.isPolled(pol.getPollId(),ipAddress);
							if(isPolled)
							{
						%>
							<div class="clear"></div>
							<strong>You have already participated</strong>
							<div class="clear"></div>
						<%
							}else
							{
						%>
						<input type="button" value="Vote" onclick="validateVoting()">
						<%
							}
						%>
					</div>
					<br><br>
					<div id="commentsArea">
					<strong>Comments:</strong>
					<div class="divContent">
						<%
								ArrayList<PollCommentsVO> comments = pollObj.getPollComments(pol.getPollId());
								if(comments.size()>0)
								{
									for(int j = 0; j<comments.size();j++)
									{
										PollCommentsVO comm = comments.get(j);
										%>
										 <div class="vote_comment" align="left">
									 		<%=comm.getComment() %>
										</div>
										<div class="clear"></div><div class="clear"></div>
										<%
									}
									%>
									<div class="clear"></div>
										<div id="more_link<%=pol.getPollId() %>" align="right">
								            <a href="#" class="rad" onclick="show_more('<%=pol.getPollId() %>'); return false;">Add Comment</a>
											&nbsp; &nbsp; &nbsp; &nbsp; <%=comments.size() %> Comments 
										</div>
										<div class="clear"></div><div class="clear"></div>
										<div id="more_d_<%=pol.getPollId() %>" style="display: none;">
											<form action="">
												<h3>Add Comment</h3>
												<div class="divContent">
													<label for="userName">Name</label>
													<input type="text" id="userName<%=pol.getPollId() %>"  name="userName">
												</div>
												<div class="divContent">
													<label for="commentContent">Comment</label>
													<textarea id="commentContent<%=pol.getPollId() %>" class="big" name="commentContent"></textarea>
												</div>
												<div id="less_link<%=pol.getPollId() %>">
													<div align="right">
														<a href="#" class="rad" onclick="addComment('<%=pol.getPollId() %>'); return false;">Reply</a>&nbsp; &nbsp; &nbsp; &nbsp; 
														<a href="#" class="rad" onclick="show_less('<%=pol.getPollId() %>'); return false;">Cancel</a> 
													</div>
												</div>
											</form>
											</div>
									<%
								}else
								{
									%>
									 	<div class="vote_comment" align="left">
									 		<strong>No Comments</strong>
										</div>
										<div class="clear"></div>
										<div id="more_link<%=pol.getPollId() %>" align="right">
								            <a href="#" class="rad" onclick="show_more('<%=pol.getPollId() %>'); return false;">Add Comment</a>
											&nbsp; &nbsp; &nbsp; &nbsp; <%=comments.size() %> Comments 
										</div>
										<div class="clear"></div><div class="clear"></div>
										<div id="more_d_<%=pol.getPollId() %>" style="display: none;">
											<form action="">
												<h3>Add Comment</h3>
												<div class="divContent">
													<label for="userName">Name</label>
													<input type="text" id="userName"  name="userName">
												</div>
												<div class="divContent">
													<label for="commentContent">Comment</label>
													<textarea id="commentContent" class="big" name="commentContent"></textarea>
												</div>
												<div id="less_link<%=pol.getPollId() %>">
													<div align="right">
														<a href="#" class="rad" onclick="addComment('<%=pol.getPollId() %>'); return false;">Reply</a> &nbsp; &nbsp; &nbsp; &nbsp; 
														<a href="#" class="rad" onclick="show_less('<%=pol.getPollId() %>'); return false;">Cancel</a> 
													</div>
												</div>
											</form>
											</div>
									<%
								}
						%>
						</div>
						</div>
					</div>
					<%
					
				}
		}
		else
		{
			out.println("No Polls to display.");
		}
	}
	else
	{
		int pollId = Integer.parseInt(poll);
		PollVO pVo = pollObj.getTodaysPoll();
	
		if(pVo!=null)
		{
			
		%>
			<div class="polls-block-box">
				<div class="clear"></div>
			
				<div class="divContent">
					<%=pVo.getPollQuestion() %>
				</div>
				<div class="clear"></div>
				
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
				%>
				<div class="divContent" align="right" >
						<input type="hidden" value="anonymous" name="pollUser">
						<%
							Boolean isPolled = pollObj.isPolled(pollId,ipAddress);
							if(isPolled)
							{
						%>
							<div class="clear"></div>
							<strong>You have already participated</strong>
							<div class="clear"></div>
						<%
							}else
							{
						%>
						<input type="button" value="Vote" onclick="validateVoting()">
						<%
							}
						%>
					</div>
					<br><br>
					<div id="commentsArea">
					<strong>Comments:</strong>
					<div class="divContent">
						<%
								ArrayList<PollCommentsVO> comments = pollObj.getPollComments(pollId);
								if(comments.size()>0)
								{
									for(int j = 0; j<comments.size();j++)
									{
										PollCommentsVO comm = comments.get(j);
										%>
										 <div class="vote_comment" align="left">
									 		<%=comm.getComment() %>
										</div>
										
										<%
									}
									%>
										<div class="clear"></div>
										<div id="more_link<%=pollId %>" align="right">
								            <a href="#" class="rad" onclick="show_more('<%=pollId %>'); return false;">Add Comment</a>
											&nbsp; &nbsp; &nbsp; &nbsp; <%=comments.size() %> Comments 
										</div>
										<div class="clear"></div><div class="clear"></div>
										<div id="more_d_<%=pollId %>" style="display: none;">
											<form action="">
												<h3>Add Comment</h3>
												<div class="divContent">
													<label for="userName">Name</label>
													<input type="text" id="userName"  name="userName">
												</div>
												<div class="divContent">
													<label for="commentContent">Comment</label>
													<textarea id="commentContent" class="big" name="commentContent"></textarea>
												</div>
												<div id="less_link<%=pollId %>">
													<div align="right">
														<a href="#" class="rad" onclick="addComment('<%=pollId %>'); return false;">Reply</a>&nbsp; &nbsp; &nbsp; &nbsp; 
														<a href="#" class="rad" onclick="show_less('<%=pollId %>'); return false;">Cancel</a> 
													</div>
												</div>
											</form>
											</div>
									
									<%
								}else
								{
									%>
										
									 	<div class="vote_comment" align="left">
									 		<strong>No Comments</strong>
										</div>
										<div class="clear"></div>
										<div id="more_link<%=pollId %>" align="right">
								            <a href="#" class="rad" onclick="show_more('<%=pollId %>'); return false;">Add Comment</a>
											&nbsp; &nbsp; &nbsp; &nbsp; <%=comments.size() %> Comments 
										</div>
										<div class="clear"></div><div class="clear"></div>
										<div id="more_d_<%=pollId %>" style="display: none;">
											<form action="">
												<h3>Add Comment</h3>
												<div class="divContent">
													<label for="commentContent">Comment</label>
													<textarea id="commentContent" class="big" name="commentContent"></textarea>
												</div>
												<div id="less_link<%=pollId %>">
													<div align="right">
														<a href="#" class="rad" onclick="addComment('<%=pollId %>'); return false;">Reply</a> &nbsp; &nbsp; &nbsp; &nbsp; 
														<a href="#" class="rad" onclick="show_less('<%=pollId %>'); return false;">Cancel</a> 
													</div>
												</div>
											</form>
											</div>
									<%
								}
						%>
						</div>
					</div>
				</div>
				<%
			
			}else
			{
				out.println("No Polls displayed for today.");
			}
	}
%>

<%@include file="../footer.jsp" %>
</div>
</body>
</html>