
<%@page import="java.util.ArrayList"%>
<%@page import="com.ipablive.core.IPaidBribe"%><%
	String dept = request.getParameter("dept");
	int dept_id = Integer.parseInt(dept);
	IPaidBribe ipb = IPaidBribe.getInstance();
	ArrayList<String> trans = ipb.getTransactions(dept_id);
	out.write("<select class='sleft' id='cTransactions'>");
	for(int i=0; i<trans.size();i++)
	{
		out.write("<option value="+i+">"+trans.get(i)+"</option>");
		
	}
	out.write("</select>");
%>