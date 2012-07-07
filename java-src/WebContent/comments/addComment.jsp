<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.ArrayList"%>
<%@page import="com.ipablive.vo.CityVO"%>
<%@page import="com.ipablive.vo.DepartmentVO"%>
<%@page import="com.ipablive.commons.CommonOperations"%>
<%@page import="com.ipablive.core.IPaidBribe"%>
<%@page import="com.ipablive.vo.PaidBribesVO"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="com.ipablive.vo.CommentVO"%>
<%@page import="com.ipablive.core.IDidnotPaid"%>
<%@page import="com.ipablive.vo.DidNotPaidBribesVO"%>
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
		href="${pageContext.request.contextPath}/theme/css/newstyles.css"
		rel="stylesheet" />
<%
String postId = request.getParameter("p");
String type = request.getParameter("t");;
String redurl = "";
String subj = " -NA- ";

String sec = (String) session.getAttribute("Code");
out.println("Code "+ sec);

if(type.equals("paid"))
{
	redurl = request.getContextPath() + "/readbribestory/ipaid.jsp";
  //  $head_img = 'reg.png';
}
else if(type.equals("notpaid"))
{
	redurl = request.getContextPath() + "/readbribestory/ididnotpaid.jsp";
    //$head_img = 'reg.png';
}
else if(type.equals("dinthvtopay"))
{
	redurl = request.getContextPath() + "/readbribestory/donthavetopaid.jsp";
   // $head_img = 'reg.png';
}
else if(type.equals("govt_promises"))
{
	redurl = "";
   // $head_img = 'govt_promises.png';
}

%>
  

<script type="text/javascript">
function validateCommentForm()
{
	var comment,securityCode,secCode;
	$('#validationErrors').empty();
	var _errorColor="#FF3300"; //red
	var _noErrorColor=""; //nocolor

	comment = $('#comment').val();
	securityCode = $('#security_code').val();
	secCode = $('#secCode').val(); 
	alert(securityCode.length);
	
	if(myTrim(comment).length==0)
	{
		$('#validationErrors').html("<center>Please enter comment</center>");
		$('#comment').css('background',_errorColor);
		return false;
	}else
	{
		$('#comment').css('background',_noErrorColor);
	}
	
	if(securityCode.length == 0)
	{
		$('#validationErrors').html("<center>Please enter valid security code</center>");
		$('#security_code').css('background',_errorColor);
		return false;
	}else
	{
		$('#security_code').css('background',_noErrorColor);
	}
	
	return true;
}

function myTrim (str) 
{
	return str.replace(/^\s\s*/, '').replace(/\s\s*$/, '');
}

function validateSecurityCode()
{
	var enteredCode = $('#security_code').val();
	var generatedCode = $('#secCode').val();

	if(enteredCode == generatedCode)
	{
		alert(generatedCode +"  " +enteredCode);
		$('#security_code').css('background',_noErrorColor);
		disableSubmit("NO");
	  	return true;
  	}else
  	{
  		alert(generatedCode +"  " +enteredCode);
  		$('#validationErrors').html("<center>Please enter valid security code</center>");
  		disableSubmit("YES");
  		$('#security_code').css('background',_errorColor);
  	}
  	return false;
}

function disableSubmit(val)
{
	alert(val);
	  if(val=="NO")
	  {
		  document.forms['fm'].elements['submit'].disabled = false;
	  }
	  else
	  {
	      document.forms['fm'].elements['submit'].disabled = true;
	  }
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
<div class="blog_container divtab">
<p><a href="<%=redurl %>" class="yellow_box">&lt;&lt; Back To </a></p>
<br />
<%
int id = Integer.parseInt(postId);
SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy - hh:mm"); 

if(type.equals("paid"))
{
	IPaidBribe ipab = IPaidBribe.getInstance();
	PaidBribesVO pbVO = ipab.viewDetailPaidBribes(id);
	subj = pbVO.getCName();
	%>
    <h3><%=pbVO.getCName() %></h3>
    <div class="report_reg">
            Reported : <%=sdf.format(pbVO.getCreatedDate()) %>
            | City : <%=pbVO.getCCity() %>
	        | Paid On : <%=sdf.format(pbVO.getCPaidDate()) %> 
	        | <%=pbVO.getDeptName() %>
    </div>
    <div class="report_reg">
    <table class="details_table" width="100%" summary="this table has the details for a certain report.">
        <tr>
	        <th width="20%"><span class="desc_lebel">Department:</span></th>
	        <td><%=pbVO.getDeptName() %></td>
	    </tr>
	    <tr>
	        <th><span class="desc_lebel">Transaction:</span></th>
	        <td><%=pbVO.getTransName() %></td>
	    </tr>    
	    <tr>
	        <th><span class="desc_lebel">Bribe Type:</span></th>
	        <td><%=pbVO.getCBribeType() %></td>
	    </tr>
	    <tr>
	        <th><span class="desc_lebel">Details:</span></th>
	        <td><%=pbVO.getCAdditionalInfo() %></td>
	    </tr>
    </table>
<div class="clear"></div>
    </div>
<br>
<%
			ArrayList<CommentVO> comments = ipab.viewVoteComments(id );
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
					<center><b> No Comments found.</b></center>
					
				<%
			}
}
else if(type.equals("notpaid"))
{
	IDidnotPaid ipab = IDidnotPaid.getInstance();
	DidNotPaidBribesVO dpbVO = ipab.viewDetailPaidBribes(id);
	 %>
	<h3><%=dpbVO.getCName() %></h3>
    
    <div class="report_reg">
Reported : <%=sdf.format(dpbVO.getCreatedDate()) %> | City : <%=dpbVO.getCCity() %> | <%=dpbVO.getDeptName() %>

		<table class="details_table">
			<tr>
		    	<th width="20%"><span class="desc_lebel">Department:</span></th>
		        <td><%=dpbVO.getDeptName() %></td>
		    </tr>
			<tr>
		    	<th><span class="desc_lebel">Transaction:</span></th>
		        <td><%=dpbVO.getTransName() %></td>
		    </tr>    
			<tr>
		    	<th><span class="desc_lebel">Reason:</span></th>
		        <td>
<%
		if(dpbVO.getCBribeResistedBy().equalsIgnoreCase("govt"))
		{
			out.println("Came accross an honest govt official");
		}
	    else
	    {
	           out.println("Resisted by "+dpbVO.getCBribeResistedBy());
	    }
%>
                </td>
		    </tr>
			<tr>
		    	<th><span class="desc_lebel">Details:</span></th>
		        <td><%=dpbVO.getCAdditionalInfo()%>
		</td>
		    </tr>
		</table>
    </div>    
 
    <%
    
    ArrayList<CommentVO> comments = ipab.viewVoteComments(id);
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
		<%
	}
    
    
}
else if(type.equals("dinthvtopay"))
{
	IDontHavetoPay idontHavepay = IDontHavetoPay.getInstance();
	DontHavetoPayVO dbVO = idontHavepay.viewDetailDintHaveToPay(id);
	 %>
	<h3><%=dbVO.getCName() %></h3>
    
    <div class="report_reg">
Reported : <%=sdf.format(dbVO.getCreatedDate()) %> 
        | City : <%=dbVO.getCCity() %>
        | <%=dbVO.getDeptName() %>

    
    <table class="details_table">
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
		</table>
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
			<br>Be the first person to <a href="javaScript: addComment('<%=dbVO.getId() %>','paid')">Comment</a>.</center>
		<%
	}
    
}
else if(type.equals("govt_promises"))
{
	 %>
    <div class="report_reg">
        <p class="question"><h2> title</h2></a></p>
        <div id="ans_1" style="display:block; margin:15px 0px 0px 0px;">
           description
        </div>
        <br />
        <div><strong>Department: </strong><span style="padding-left: 10px;">deptname</span></div>
        <div><strong>City: </strong><span style="padding-left: 68px;">cityname</span></div>
    </div>     
    <%
}
 %>
<div class="clear"></div>
<div class="clear"></div>
<div id="validation_errors">
</div>

<h1>Add comment</h1>
<div class="error">
<div id="validationErrors"></div>
</div>
<form method="post" action="comment" onsubmit="return validateCommentForm()" id="fm">
<table>
	<tr>
    	<td colspan="2">
        <label for="subject">Subject</label><br />
        <input type="hidden" name="subject" size="84" value="" id="subject" /><%=subj %></td>
    </tr>
	<tr>
    	<td colspan="2">
        <br />
        <label for="comment">Comment</label><br />
        <textarea rows="5" cols="40" name="comment" id="comment"></textarea>
        </td>
    </tr>    
	<tr>
    <td colspan="2">
    <label for="security_code">Please enter the security code</label>
    <p><img src="${pageContext.request.contextPath}/getCaptcha.do?type=num&time=<%=new Date().getTime() %>" alt="captcha" /></p>
    <input type="text" name="security_code" id="security_code" value="" onblur="validateSecurityCode()"/>   
	<input type="hidden" id="secCode" value="<%= (String) session.getAttribute("Code")%>"/> 
    </td>
    </tr>
	<tr>    	
        <td colspan="2">
	        <input type="hidden" name="type" value="<%=type %>" />
	        <input type="hidden" name="type_id" value="<%=postId %>" />
	        <input type="submit" name="submit" id="submit" value="Post"  />
        </td>
    </tr>  	  
</table>
</form>
</div>
</div>
<%@include file="../footer.jsp" %>
</body>
</html>