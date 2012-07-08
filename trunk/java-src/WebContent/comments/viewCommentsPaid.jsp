<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.ArrayList"%>
<%@page import="com.ipablive.vo.CityVO"%>
<%@page import="com.ipablive.vo.DepartmentVO"%>
<%@page import="com.ipablive.commons.CommonOperations"%>
<%@page import="com.ipablive.core.IPaidBribe"%>
<%@page import="com.ipablive.vo.PaidBribesVO"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.ipablive.vo.CommentVO"%><html>
<head>
    <meta http-equiv="content-type" content="text/html;charset=utf-8" />
    <title>Bribes Registered</title>
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
function addComment(typeId,type)
{
	//var url = "/addComment.jsp?typeId="+typeId+"&type="+type+"&subject="+subject;
	var url = "${pageContext.request.contextPath}/comments/addComment.jsp?p="+typeId+"&t="+type;
	window.location.href = url;
	
}
</script>
</head>
<body>
<%@include file="../header.jsp" %> 
<%
	String strId = request.getParameter("id");

	if(strId != null)
	{
		int id = Integer.parseInt(strId);
		IPaidBribe ipab = IPaidBribe.getInstance();
		PaidBribesVO pbVO = ipab.viewDetailPaidBribes(id);
		SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy - hh:mm"); 
%>
<div class="clear"></div>
<div id="bg-wrapper">
<div class="breadcrumb">
	<div class="clear"></div>
		<a href="${pageContext.request.contextPath}" style="text-decoration: none;">Home</a> > 
	<a href="${pageContext.request.contextPath}/reports?t=paid" style="text-decoration: none;">Bribe Report</a> > <%=pbVO.getCName() %>
<center><br>
<h2 class="pageHeaderH2">Bribes Registered</h2>
</center>
</div>
<div class="comments-block-box">

<h3><%=pbVO.getCName() %></h3>
<div class="report_reg">
        Reported : <%=sdf.format(pbVO.getCreatedDate()) %> 
        | City : <%=pbVO.getCCity() %>
        | Paid On : <%=sdf.format(pbVO.getCPaidDate()) %> 
        | <%=pbVO.getDeptName() %>
</div>
<br>

<table width="100%" summary="this table has the details for a certain report.">
    <tr>
        <th align="left" style="width: 100px;"><span>Department:</span></th>
        <td align="left"><%=pbVO.getDeptName() %></td>
    </tr>
    <tr>
        <th align="left" style="width: 100px;"><span>Transaction:</span></th>
        <td align="left"><%=pbVO.getTransName() %></td>
    </tr>    
    <tr>
        <th align="left" style="width: 100px;"><span>Bribe Type:</span></th>
        <td align="left"><%=pbVO.getCBribeType() %></td>
    </tr>
    <tr>
        <th align="left" style="width: 100px;"><span>Details:</span></th>
        <td align="left"><%=pbVO.getCAdditionalInfo() %></td>
    </tr>
</table>
<div align="right"><a href="javaScript: addComment('<%=pbVO.getId() %>','paid')" class="yellow_box">Add a comment</a></div>
<div class="clear"></div>

<br>
<%
			ArrayList<CommentVO> comments = ipab.viewVoteComments(id );
			if(comments.size()>0)
			{
				for(int j=0; j<comments.size();j++)
				{
					CommentVO comment = comments.get(j);
			%>
			<div class="vote_comment">
				<h2><%=comment.getSubject() %></h2>
				<p><%=comment.getComment() %></p>
			</div>
			
				<%
				}
			}else
			{
				%>
					<div class="vote_comment">
					<center><b> No Comments found.</b>
					<br>Be the first person to <a href="javaScript: addComment('<%=pbVO.getId() %>','paid')">Comment</a>.</center>
					</div>
				<%
			}
	
	}
	%>

</div>

<%@include file="../footer.jsp" %>
</div>
</body>
</html>