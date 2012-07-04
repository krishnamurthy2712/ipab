<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.ArrayList"%>
<%@page import="com.ipablive.vo.CityVO"%>
<%@page import="com.ipablive.vo.DepartmentVO"%>
<%@page import="com.ipablive.commons.CommonOperations"%>
<%@page import="com.ipablive.core.IPaidBribe"%>
<%@page import="com.ipablive.vo.PaidBribesVO"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.ipablive.vo.CommentVO"%>
<%@page import="com.ipablive.core.IDontHavetoPay"%>
<%@page import="com.ipablive.vo.DontHavetoPayVO"%><html>
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
		href="${pageContext.request.contextPath}/theme/css/style.css"
		rel="stylesheet" />
<script type="text/javascript">
function addComment(typeId,type)
{
	//var url = "/addComment.jsp?typeId="+typeId+"&type="+type+"&subject="+subject;
	var url = "${pageContext.request.contextPath}/comments/addComment.jsp?p=1&t="+type;
	window.location.href = url;
	
}
</script>
</head>
<body>
<%@include file="../header.jsp" %> 
<div class="pageHeader">
<center><br>
<h2 class="pageHeaderH2">Bribes Registered</h2>
</center>
</div>
<div id="mainContent" class="mainContent">

<div id="blog">
<div class="blog_container">
           
<p><a href="${pageContext.request.contextPath}/readbribestory/donthavetopaid.jsp" class="yellow_box">&lt;&lt; Back To Reports</a></p>
<br />
<%
	String strId = request.getParameter("id");

	if(strId != null)
	{
		int id = Integer.parseInt(strId);
		IDontHavetoPay idontHavepay = IDontHavetoPay.getInstance();
		DontHavetoPayVO dbVO = idontHavepay.viewDetailDintHaveToPay(id);
		//SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy - hh:mm"); 
%>
<h3><%=dbVO.getCName() %></h3>
<div class="report_reg">
        Reported : <%=dbVO.getCreatedDate() %> 
        | City : <%=dbVO.getCCity() %>
        | <%=dbVO.getDeptName() %>
</div>
<br>
<div class="clear"></div>
<div class="report_reg">
<table class="details_table" width="100%" summary="this table has the details for a certain report.">
    <tr>
        <th width="20%"><span class="desc_lebel">Department:</span></th>
        <td><%=dbVO.getDeptName() %></td>
    </tr>
    <tr>
        <th><span class="desc_lebel">Transaction:</span></th>
        <td><%=dbVO.getTransName() %></td>
    </tr>    
    <tr>
		    	<th><span class="desc_lebel">Reason:</span></th>
		        <td>
<%
		if(dbVO.getCBribeResistedBy().equalsIgnoreCase("govt"))
		{
			out.println("Came accross an honest govt official");
		}
	    else
	    {
	           out.println("Resisted by "+dbVO.getCBribeResistedBy());
	    }
%>
                </td>
		    </tr>
    <tr>
        <th><span class="desc_lebel">Details:</span></th>
        <td><%=dbVO.getCAdditionalInfo() %></td>
    </tr>
<tr><td>   </td></tr>
<tr><td><div class="report_reg"><a href="javaScript: addComment('<%=dbVO.getId() %>','dinthvtopay')" class="yellow_box">Add a comment</a></div></td></tr>
</table>
<div class="clear"></div>
</div>
	<%
	ArrayList<CommentVO> comments = idontHavepay.viewVoteComments(id );
	if(comments.size()>0)
	{
		for(int j=0; j<comments.size();j++)
		{
			CommentVO comment = comments.get(j);
	%>
	<div class="vote_comment" <%=(comments.size()>0)? "style='border-top:1px solid #E8AD04;margin-top:10px;'":"" %>>
		<h2><%=comment.getSubject() %></h2>
		<p><%=comment.getComment() %></p>
	</div>
	<br><br>
	
	
		<%
		}
	}else
	{
		%>
			<center><b> No Comments found.</b>
			<br>Be the first person to <a href="javaScript: addComment('<%=dbVO.getId() %>','dinthvtopay')">Comment</a>.</center>
		<%
	}
	
	}
	else
	{
		%>
		asdf
		<%
	}
	%>


</div><!-- # eof blog -->
</div><!-- #eof blog_container -->
</div> <!-- #eof blog_container -->
<%@include file="../footer.jsp" %>
</body>
</html>