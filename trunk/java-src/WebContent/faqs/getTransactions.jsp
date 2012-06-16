
<%@page import="com.ipablive.vo.TransactionVO"%>
<%@page import="com.ipablive.commons.CommonOperations"%>
<%@page import="java.util.ArrayList"%>

<%
	String dept = request.getParameter("dept");
	int dept_id = Integer.parseInt(dept);
	CommonOperations ipb = CommonOperations.getInstance();
	ArrayList<TransactionVO> trans = ipb.getTransactions(dept_id);
	
	for(int i=0; i<trans.size();i++)
	{
		TransactionVO tVo = trans.get(i);
		if(tVo.getTransactioName().equals("Others"))
		{
			out.write("<option value='0'>"+tVo.getTransactioName()+"</option>");
		}else
		{
			out.write("<option value="+tVo.getTransactionId()+">"+tVo.getTransactioName()+"</option>");
		}
		
		
	}
%>