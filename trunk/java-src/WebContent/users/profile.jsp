
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

	<div class="clear" style="height: 20px;"></div>
	<form action="" method="post">
		<div class="change-pwd-block-box">
			<div class="divContent">
				<label>Your Old Password</label>
				<input type="hidden" id="oldPwd" value="<%=userVo.getUserPassword() %>">
				XXXXXXXX
			</div>
			<div class="divContent">
				<label>Your New Password</label>
				<input type="password" id="newPwd" name = "newPassword">
			</div>
			<div class="divContent">
				<label>Confirm New Password</label>
				<input type="password" id="newConfPwd" name = "confNewPassword">
			</div>
			<div class="divContent">
				<input type="submit" value="Change Password">
			</div>
		</div>
	</form>
<%
}
%>
</div>