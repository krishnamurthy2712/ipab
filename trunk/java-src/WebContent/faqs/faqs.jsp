<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.ArrayList"%>
<%@page import="com.ipablive.vo.CityVO"%>
<%@page import="com.ipablive.vo.DepartmentVO"%>
<%@page import="com.ipablive.commons.CommonOperations"%>
<%@page import="com.ipablive.vo.FaqVO"%>
<%@page import="com.ipablive.core.Faqs"%><html>
<head>
    <meta http-equiv="content-type" content="text/html;charset=utf-8" />
    <title>FAQs</title>
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
		href="${pageContext.request.contextPath}/theme/css/newstyles.css"
		rel="stylesheet" />

	<script type="text/javascript">
	function getTransactions()
	{
         // get the form values
        var dept = $('#depts').find('option:selected').attr('id'); //$('#cDept').val();

        $.ajax({
			  type: 'GET',
			  url: 'getTransactions.jsp',
			  data: "dept=" + dept,
			  beforeSend:function(){
			    // this is where we append a loading image
			   
			  },
			  success:function(response){
			    // successful request; do something with the data
			    //$('#transactionsDisplay').empty();
			   
			    $('#idSubCategory').html(response);
			  },
			  error:function(){
			    // failed request; give feedback to user
			    $('#idSubCategory').html('<p><font color="red"><strong>Oops!</strong> Unable to load transactions.</font></p>');
			  }
		 });
	}
	</script>	

</head>
<body>
<%@include file="../header.jsp" %>
<% CommonOperations commonOps = CommonOperations.getInstance(); %>
<div class="pageHeader">
<center><br>
<h2 class="pageHeaderH2">FAQ's - Answers to <b>All</b> Your Questions.</h2>
</center>
</div>
<div id="mainContent" class="mainContent">
<h3 style="font-size:13px;">These FAQs  are for XXX only currently. We will be developing these for other cities. If you want to help get in touch with us.</h3>
<form action="#" method="get" name="faqFilter" id="faqFilter">		   
    
           
           		
           <div class="bigback">
           <label>Didn't find what you were looking for? 
			<a href="${pageContext.request.contextPath}contactus.jsp" style="text-decoration: none;"><span class="faq_contact_txt">CONTACT US</span></a></label>
           </div>
           <fieldset>
           <div>
                <select class="selecttext" name="depts" id="depts" onchange="getTransactions()">
                  <option value="">Select Department</option>
					<%
						ArrayList<DepartmentVO> depts = commonOps.getDepartments();
						 for(int i=0 ;i<depts.size();i++)
						 {	 
							 DepartmentVO dVo = depts.get(i);
						%>
							<option value="<%=dVo.getDeptID() %>" id="<%=dVo.getDeptID() %>" ><%=dVo.getDeptName() %></option>
							<%
						 }
					%>
                </select>	
						
                <select class="selecttext" name="sub_category" id="idSubCategory">
                  <option value="">Select Transaction</option>
                </select>
           </div>
           
           </fieldset>
    </form> 

<% 
Faqs objFaq = Faqs.getInstance();
ArrayList<FaqVO> faqs = objFaq.getFaqs();
if(faqs.size()>0){
for(int i=0;i<faqs.size();i++)
{
	FaqVO faq = faqs.get(i);
%>
     <div class="question_answer_tube">
       <span class="question">
         <h2 style="cursor:pointer;">Q. <%=faq.getQuestion() %></h2>
       </span>
       <span class="answer">
          <p class="faq_answer"  id="id-faq-ans" ><span class="faq_body"><b>A. </b><%=faq.getAnswer() %></span> </p>
          
       </span>
     </div>
   <?php } ?>
     
</div><!-- #eof askr_ques -->
               
<%
}
}else
{
%>
<div class="display_info" align="center">No FAQs Found</div>
 <%} %>
</div>
<%@include file="../footer.jsp" %>
</body>
</html>