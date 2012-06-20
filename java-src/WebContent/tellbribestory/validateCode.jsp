
<%
	String code = request.getParameter("code");
	
	String generatedCode = (String) session.getAttribute("Code");
	System.out.println("Security code. " +generatedCode);
	
	response.setContentType("text/html");
	
	if(code.equals(generatedCode))
	{
		out.println("");
		System.out.println("Security code validated.");
	}
	else
	{
		out.println("Please enter valid code.");
		System.out.println("Error in validating security code. "+code + "  << >>"+generatedCode);
	}
%>
