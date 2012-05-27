<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>

<%@page import="com.ipablive.core.IPaidBribe"%>
<%@page import="java.util.ArrayList"%><html>
<head>
    <meta http-equiv="content-type" content="text/html;charset=utf-8" />
    <title>I Paid a Bribe</title>
    <link type="text/css" href="${pageContext.request.contextPath}/theme/css/menu.css" rel="stylesheet" />
	<link type="text/css" href="${pageContext.request.contextPath}/theme/css/style.css" rel="stylesheet" />
    <script type="text/javascript" src="${pageContext.request.contextPath}/theme/js/jquery.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/theme/js/menu.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/theme/js/jquery.ui.datepicker.js"></script>

	<script type="text/javascript">
	$(function() {
		$("#c_date_paid").datepicker({
			changeMonth: true,
			changeYear: true,
			yearRange: '2000:2012'
		});
	});
	
	function getTransactions()
	{
         // get the form values
         var dept = document.getElementById("department").value;
		$.ajax({
			  type: 'GET',
			  url: 'getTransactions.jsp',
			  data: "dept=" + dept,
			  beforeSend:function(){
			    // this is where we append a loading image
			    $('#transactionsDisplay').html('<div class="loading"><img src="/images/loading.gif" alt="Loading..." /></div>');
			  },
			  success:function(response){
			    // successful request; do something with the data
			    $('#transactionsDisplay').empty();
			    $('#transactionsDisplay').append(response);
			  },
			  error:function(){
			    // failed request; give feedback to user
			    $('#transactionsDisplay').html('<p><font color="red"><strong>Oops!</strong> Unable to load transactions.</font></p>');
			  }
			});
	}
	
	</script>
</head>
<body>
<%@include file="../header.jsp" %>
<div id="mainContent" class="mainContent">
<% IPaidBribe ipb = IPaidBribe.getInstance(); %>	
 <html:form action="/iPaid.do" >
        <table>
            <tr>
                <td class="tabl-width">
                    <label for="cCity">County  </label>
                </td>
                <td class="tabl-width">
                    <html:select property="cCity" styleClass="sleft">
					<html:option value="" >Select County</html:option>
				<%

 ArrayList<String> counties = ipb.getCounties();
 for(int i=0 ;i<counties.size();i++)
 {	 
	 String s = (i+1) + "";
%>
					<html:option value="<%=s %>" ><%=counties.get(i)%></html:option>
<%
 }
%>
					</html:select>
                </td>
</tr><tr>
<td class="tabl-width">
                    <label for="cDept">Department  </label>
                </td>
				<td class="tabl-width">
                    <select onchange="getTransactions()" id="department" class="sleft">
					<option value="" >Select Department</option>
<%
 ArrayList<String> depts = ipb.getDepartments();
 for(int i=0 ;i<depts.size();i++)
 {	 
	 String s = (i+1) + "";
%>
					<option value="<%=s %>" ><%=depts.get(i)%></option>
<%
 }
%>
					</select>
                </td>
            </tr>
<tr>
<td class="tabl-width">
                    <label for="cTransaction">Transactions  </label>
                </td>
				<td class="tabl-width">
					<div id="transactionsDisplay"></div>
                </td>
            </tr>

<tr>
<td class="tabl-width"><label for="c_amt_paid">Amount Paid</label></td>
<td class="tabl-width"></td>
</tr>

<tr>
<td class="tabl-width"><label for="c_date_paid">Date Paid</label></td>
<td class="tabl-width"><input type="text" name="c_date_paid" id="c_date_paid" value="" class="sleft"/></td>
</tr>

<tr>
<td class="tabl-width"><label for="other_location">Office Location</label></td>
<td class="tabl-width"></td>
</tr>

<tr>
<td class="tabl-width"><label for="c_bribe_type">Bribe Type</label></td>
<td class="tabl-width">
	<select class="sleft" name="c_bribe_type" id="c_bribe_type">
    	<option value="personal">Personal</option>
        <option value="corporate">Corporate</option>
    </select>
</td class="tabl-width">
</tr>

<tr>
<td class="tabl-width"><label for="c_payment_method">Payment Method</label></td>
<td class="tabl-width">
	<select class="sleft" name="c_payment_method" id="c_payment_method">
		<option value="" selected="selected">Select Option</option>
        <option value="cash">Cash</option>
        <option value="mpesa">M-Pesa</option>
        <option value="airtelmoney">Airtel Money</option>
        <option value="yucash">Yu Cash</option>
        <option value="cards">Credit/Debit Card</option>
        <option value="bykind">By Kind</option>
        <option value="other">Other</option>
	</select>
</td>
</tr>

<tr>
<td class="tabl-width"> <label for="c_name">Title your story</label></td>
</tr>
<tr><td colspan="4" ><textarea class="big" name="c_name" id="c_name"  rows="2" style="height:20px;" cols="4" ></textarea></td></tr>
<tr>
<td class="tabl-width"> <label for="c_addi_info">Tell us your story</label>
           </td>
</tr>
<tr><td colspan="2">"Please do NOT report names." We aim to change processes not target individuals</td></tr>
<tr><td colspan="4"><textarea class="big" name="c_addi_info" id="c_addi_info"  rows="10" cols="4"></textarea></td></tr>
<tr>
<td><label for="security_code">Please enter the security code</label></td>
<td></td>
</tr>
<tr><td class="tabl-width"><input name="t_and_c" id="t_and_c" type="checkbox" value="1" class="no" />&nbsp;&nbsp;&nbsp;&nbsp;I agree to the <a href="/privacy-policy" target="_blank"> terms and conditions</a> </td></tr>

        </table>

        </html:form>
</div>
<div>
</div>
<%@include file="../footer.jsp" %>
</body>
</html>