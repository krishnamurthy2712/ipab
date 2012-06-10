
<%@page import="com.ipablive.vo.TransactionVO"%>
<%@page import="com.ipablive.commons.CommonOperations"%>
<%@page import="java.util.ArrayList"%>

<%
	String dept = request.getParameter("dept");
	int dept_id = Integer.parseInt(dept);
	CommonOperations ipb = CommonOperations.getInstance();
	ArrayList<TransactionVO> trans = ipb.getTransactions(dept_id);
	out.write("<select class='sleft' id='cTransactions'>");
	out.write("<option value=\'\'>Select Transaction</option>");
	System.out.println("trans.size() "+ trans.size());
	
	for(int i=0; i<trans.size();i++)
	{
		TransactionVO tVo = trans.get(i);
		out.write("<option value="+(i+1)+">"+tVo.getTransactioName()+"</option>");
		
	}
	out.write("</select>");
%>