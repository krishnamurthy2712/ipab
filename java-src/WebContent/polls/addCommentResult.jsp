<%@page import="com.ipablive.core.Polls"%>
<%
	String poll = request.getParameter("p");
	int pollId = Integer.parseInt(poll);
	Polls pollObj = Polls.getInstance();
%>



<%@page import="java.util.ArrayList"%>
<%@page import="com.ipablive.vo.PollCommentsVO"%>

<div id="commentsArea">
					<strong>Comments:</strong>
					<div class="divContent">
						<%
								ArrayList<PollCommentsVO> comments = pollObj.getPollComments(pollId);
								if(comments.size()>0)
								{
									for(int j = 0; j<comments.size();j++)
									{
										PollCommentsVO comment = comments.get(j);
										%>
										 <div class="vote_comment" align="left">
									 		<%=comment.getComment() %>
										</div>
										<div class="clear"></div>
										<div id="more_link<%=pollId %>" align="right">
								            <a href="#" class="rad" onclick="show_more('<%=pollId %>'); return false;">Add Comment</a>
											&nbsp; &nbsp; &nbsp; &nbsp; <%=comments.size() %> Comments 
										</div>
										<div class="clear"></div><div class="clear"></div>
										<div id="more_d_<%=1 %>" style="display: none;">
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
									}
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
													<label for="userName">Name</label>
													<input type="text" id="userName"  name="userName">
												</div>
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