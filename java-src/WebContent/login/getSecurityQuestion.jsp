
<%@page import="com.ipablive.core.Login"%><%
String userId = request.getParameter("user");
Login login = Login.getInstance();
String secQues = login.getSecurityQuestion(userId);
if(secQues.length()>0)
{
	out.println(secQues);
}
else
{
	out.println("<font color='red'>Unable to get security question.</font>");
}

%>