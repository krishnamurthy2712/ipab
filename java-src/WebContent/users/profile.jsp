
<script type="text/javascript">
function validateSubmission()
{
	$('#validationErrors').empty();
	alert();
	var _errorColor="#FF3300"; //red
	var _noErrorColor=""; //nocolor
			
	var pwdChk,oldPassword,password,confPassword,securityCode;
	oldPassword = $('#oldPass').val();
	pwdChk = $('#oldStoredPass').val();
	password = $('#newPassword').val();
	confPassword = $('#confNewPassword').val();
	securityCode = $('#security_code').val();
	var secVal = $('#secErr').val(); 

	if(myTrim(oldPassword).length<=0)
	{
		$('#validationErrors').html("<center>Please enter old password</center>");
		$('#oldPass').css('background',_errorColor);
		$('#errors').fadeIn();
		return false;
	}else
	{
		$('#oldPass').css('background',_noErrorColor);
		$('#errors').fadeOut();
	}

	if(myTrim(oldPassword) == myTrim(pwdChk))
	{
		$('#validationErrors').html("<center>Entered old password is incorrect</center>");
		$('#oldPass').css('background',_errorColor);
		$('#errors').fadeIn();
		return false;
	}else
	{
		$('#oldPass').css('background',_noErrorColor);
		$('#errors').fadeOut();
	}

	if(myTrim(password).length<=0)
	{
		$('#validationErrors').html("<center>Please enter new password</center>");
		$('#newPassword').css('background',_errorColor);
		$('#errors').fadeIn();
		return false;
	}else
	{
		$('#newPassword').css('background',_noErrorColor);
		$('#errors').fadeOut();
	}

	if(myTrim(confPassword).length<=0)
	{
		$('#validationErrors').html("<center>Please re-enter new password for confirmation</center>");
		$('#confNewPassword').css('background',_errorColor);
		$('#errors').fadeIn();
		return false;
	}else
	{
		$('#confNewPassword').css('background',_noErrorColor);
		$('#errors').fadeOut();
	}

	return true;
}

function myTrim (str) 
{
	return str.replace(/^\s\s*/, '').replace(/\s\s*$/, '');
}
</script>

<%@page import="com.ipablive.vo.UserVO"%><div>
<%
UserVO userVo = (UserVO) session.getAttribute("loggedInUser"); 
if(userVo == null)
{
	out.println("<center><font coor='red'> Unable to get profile. </font></center>");
}
else
{
	%>
	<div class="divContent">
		<label>User Name</label>
		<strong><%=userVo.getUserId() %></strong>
	</div>
	<div class="divContent">
		<label>Your Password</label>
		XXXXXXXX
	</div>
	<div class="divContent">
		<label>First Name</label>
		<strong><%=userVo.getFirstName() %></strong>
	</div>
	<div class="divContent">
		<label>Last Name</label>
		<strong><%=userVo.getLastName() %></strong>
	</div>
	<div class="divContent">
		<label>Email</label>
		<strong><%=userVo.getEmail() %></strong>
	</div>
	<div class="divContent">
		<label>Your Role</label>
		<strong><%=userVo.getUserRole() %></strong>
	</div>

	<div class="clear" style="height: 5px;"></div>
	<form action="changePwd" method="post" onsubmit="return validateSubmission()">
		<div class="change-pwd-block-box">
			<h3 align="center">Change Password</h3>
			<div class="clear"></div>
			<div id="errors">
				<div id="validationErrors"></div>
			</div>
			<input type="hidden" id="userName" name="userName" value="<%=userVo.getUserId() %>">
			<div class="clear" style="height: 20px;"></div>
			<div class="divContent" align="right">
				<label>Your Old Password</label>
				<input type="password" id="oldPass" name = "oldPass" >
				<input type="hidden" id="oldStoredPass" name = "oldStoredPass" >
			</div>
			<div class="divContent" align="right">
				<label>Your New Password</label>
				<input type="password" id="newPwd" name = "newPassword">
			</div>
			<div class="divContent" align="right">
				<label>Confirm New Password</label>
				<input type="password" id="newConfPwd" name = "confNewPassword">
			</div>
			<%
				String isDisabled = "";
				
				if(userVo.getUserRole().equalsIgnoreCase("admin"))
				{
					isDisabled = "disabled='disabled'";	
				}
			%>
			<div class="divContent" align="right">
				<input type="submit" value="Change Password" <%=isDisabled %>>
			</div>
		</div>
	</form>
<%
}
%>
</div>