<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="com.ipablive.vo.OptionsVO"%>
<%@page import="com.ipablive.vo.QuizVo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ipablive.core.Home"%>
<html>
<head>
    <meta http-equiv="content-type" content="text/html;charset=utf-8" />
    <title>Quiz </title>
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
		href="${pageContext.request.contextPath}/theme/css/style.css"
		rel="stylesheet" />
</head>
<body>
<%@include file="../header.jsp" %>
<div class="pageHeader">
<center><br>
<h2 class="pageHeaderH2">Quiz</h2>
</center>
</div>
<div id="mainContent" class="mainContent">

<form class="quiz" action="#" method="post">
<p class="quiz_top_text">What's your Corruption Quotient (CQ) ?</p>

<%
	Home homeObj = Home.getInstance();
	ArrayList<QuizVo> quizQuestions = homeObj.getQuizQuestions();
	if(quizQuestions.size()>0)
	{
		for(int i=0;i<quizQuestions.size();i++)
		{
			QuizVo question = quizQuestions.get(i);
			ArrayList<OptionsVO> options = question.getOptions(); 
%>
            <div class="quiz_div">
                <p class="quiz_div_q"><%=question.getqId() %>. <%=question.getqDescription() %></p>
                <p class="quiz_div_ans">
                      <% 
                      	if(options.size()>0)
                      	{
	                      	for(int j=0; j<options.size(); j++)
	                      	{
	                      		OptionsVO option = options.get(j);
	                      %>  
	                        <input type="radio" name="q<%=i %>" id="q<%=i %>" value="<%=option.getAnsValue() %>" checked /><span><%=option.getAnsDescription() %></span>
	                      <% }
                      }else
                      {
                      %>
                      	Options Not Available.
                      <%} %>
                </p>
                </div>
        <%}
	}
	else
	{
	%>
	Questions Not Available.
	
	<%} %>
<div class="quiz_div_sub"><input type="submit" name="submit" value="Submit" /></div>
</form>


</div>
<%@include file="../footer.jsp" %>
</body>
</html>