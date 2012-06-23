<%
String subject = request.getParameter("subject");
String type = request.getParameter("type");
int typeId = Integer.parseInt(request.getParameter("typeId"));

%>
<script type="text/javascript">
function validateCommentForm()
{
	
	return false;
}
</script>
<div>
<h1 class="c_head">Add comment</h1>

<form method="post" action="" onsubmit="return validateCommentForm();">
<table>
	<tr>
    	<td colspan="2">
        <label for="subject">Subject</label><br />
        <input type="text" name="subject" size="84" value="<%=subject %>" id="subject" /></td>
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
    <p><img src="${pageContext.request.contextPath}/getCaptcha.do?type=num" alt="captcha" /></p>
    <input type="text" name="security_code" id="security_code" value="" />    
    </td>
    </tr>
	<tr>    	
        <td colspan="2">
	        <input type="hidden" name="type" value="" />
	        <input type="hidden" name="type_id" value="<%=typeId %>" />
	        <input type="submit" name="submit" id="submit" value="Post"  />
        </td>
    </tr>  	  
</table>
</form>

</div>