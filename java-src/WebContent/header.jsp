
<%@page import="com.ipablive.commons.CommonOperations"%>
<%
	String logo = "/theme/images/logo.png";
	String flag = "/theme/images/Ghana_Flag.png";
%>
<div class="clear"></div>
<div style="margin: 10px;"><img
	src="${pageContext.request.contextPath}<%=logo %>" height="50">
<div id="counter"><input type="hidden" name="counter-value"
	value="2" /></div>
</div>
<div class="clear"></div>

<div>
<ul id="menu_new">
	<li><a href="${pageContext.request.contextPath}">
	<div class="ghana"><img src="${pageContext.request.contextPath}<%=flag %>" alt="ipaidabribe ghana" />&nbsp;<strong>Ghana</strong></div>
	</a></li>

	<li style="margin-left: 5px !important;"><a
		href="#">
	<div class="ipaidabribe"><strong>I Paid A</strong> Bribe</div>
	</a>
	<ul style="width: 110px !important;">
		<li><a href="${pageContext.request.contextPath}/complaint?t=paid">Post Report</a></li>
		<li><a href="${pageContext.request.contextPath}/reports?t=paid">Read
		Report</a></li>
	</ul>
	</li>

	<li style="margin-left: 5px !important;"><a
		href="#">
	<div class="iddintpayabribe"><span
		style="display: block; line-height: 12px !important; padding-top: 4px;"><strong>I
	Didn't</strong> </span><span><strong> Pay A</strong> Bribe</span></div>
	</a>
	<ul style="width: 100px !important;">
		<li><a href="${pageContext.request.contextPath}/complaint?t=notpaid">Post Report</a></li>
		<li><a href="${pageContext.request.contextPath}/reports?t=notpaid">Read
		Report</a></li>
	</ul>
	</li>

	<!--  <li style="margin-left: 5px !important;">
	<div class="idontwanttopayabribe "><span style="line-height: 12px !important; display:  block; padding-top:  4px"><strong>I
	Don't Want To</strong> </span><span><strong>Pay A</strong> Bribe</span></div>
	</a>
	<ul style="width:  120px !important">
		<li><a href="#">Post Report</a></li>
		<li><a href="#">Read Reports</a></li>
	</ul>
	</li>-->

	<li style="margin-left: 5px !important;"><a
		href="#">
	<div class="ididnthavetopaybribe"><span
		style="display: block; line-height: 12px !important; padding-top: 4px;"><strong>I
	Didn't Have To</strong> </span><span><strong> Pay A</strong> Bribe</span></div>
	</a>
	<ul style="width: 120px !important;">
		<li><a href="${pageContext.request.contextPath}/complaint?t=notasked">Post Report</a></li>
		<li><a href="${pageContext.request.contextPath}/reports?t=notasked">Read
		Report</a></li>
	</ul>
	</li>


	<li style="margin-left: 5px !important;"><a href="#">
	<div class="allreports">All Reports</div>
	</a></li>
	<li style="margin-left: 5px !important;"><a href="#">
	<div class="indthenewstoday ">In The News Today</div>
	</a>
	<ul style="width: 146px !important;">
		<li><a href="${pageContext.request.contextPath}/blog/blog.jsp">Blogs</a></li>
		<!--<li><a href="#">Corruption Quiz</a></li>-->
		<li><a href="${pageContext.request.contextPath}/polls/polls.jsp?t=all">Polls</a></li>
		<li><a href="${pageContext.request.contextPath}/videos/videos.jsp">Videos</a></li>


	</ul>
	</li>

</ul>
<br>
</div>
