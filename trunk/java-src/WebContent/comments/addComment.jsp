<%
String subject = request.getParameter("subject");
String type = request.getParameter("type");
int typeId = Integer.parseInt(request.getParameter("typeId"));

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
	secCode = $('#secErr').val(); 

	if(myTrim(comment).length<=0)
	{
		$('#validationErrors').html("<center>Please enter valid security code</center>");
		$('#comment').css('background',_errorColor);
		return false;
	}else
	{
		validateSecurityCode();
		$('#comment').css('background',_noErrorColor);
	}
	
	if(myTrim(securityCode).length<=0)
	{
		$('#validationErrors').html("<center>Please enter valid security code</center>");
		$('#security_code').css('background',_errorColor);
		return false;
	}else
	{
		validateSecurityCode();
		$('#security_code').css('background',_noErrorColor);
	}
	
	return false;
}

function myTrim (str) 
{
	return str.replace(/^\s\s*/, '').replace(/\s\s*$/, '');
}

function validateSecurityCode()
{
	var enteredCode = $('#security_code').val();
	var generatedCode = $('#secErr').val();

	if(enteredCode == generatedCode)
	{
		$('#security_code').css('background',_noErrorColor);
	  return true;
  	}else
  	{
  		$('#validationErrors').html("<center>Please enter valid security code</center>");
  		$('#security_code').css('background',_errorColor);
  	}
  	return false;
}

</script>
<div>
<h1 class="c_head">Add comment</h1>
<div class="error">
<div id="validationErrors"></div>
</div>
<form method="post" action="" onsubmit="return validateCommentForm();">
<table>
	<tr>
    	<td colspan="2">
        <label for="subject">Subject</label><br />
        <input type="hidden" name="subject" size="84" value="<%=subject %>" id="subject" /><%=subject %></td>
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
    <input type="text" name="security_code" id="security_code" value="" onblur="validateSecurityCode()"/>   
	<input type="hidden" id="secErr" value="<%= (String) session.getAttribute("Code")%>"/> 
    </td>
    </tr>
	<tr>    	
        <td colspan="2">
	        <input type="hidden" name="type" value="<%=type %>" />
	        <input type="hidden" name="type_id" value="<%=typeId %>" />
	        <input type="submit" name="submit" id="submit" value="Post"  />
        </td>
    </tr>  	  
</table>
</form>

</div>