<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.ArrayList"%>
<%@page import="com.ipablive.vo.CityVO"%>
<%@page import="com.ipablive.vo.DepartmentVO"%>
<%@page import="com.ipablive.commons.CommonOperations"%>
<%@page import="com.ipablive.core.Awards"%><html>
<head>
    <meta http-equiv="content-type" content="text/html;charset=utf-8" />
    <title>Awards</title>
	<script src="${pageContext.request.contextPath}/theme/js/jquery.js"
		type="text/javascript">
		</script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/theme/js/menu.js"></script>
	
	<script
		src="${pageContext.request.contextPath}/theme/js/jquery.ui.core.js"></script>
	<script
		src="${pageContext.request.contextPath}/theme/js/jquery.ui.widget.js"></script>
	
	<link type="text/css"
		href="${pageContext.request.contextPath}/theme/css/menu.css"
		rel="stylesheet" />
	<link type="text/css"
		href="${pageContext.request.contextPath}/theme/css/style.css"
		rel="stylesheet" />

	 <script src="${pageContext.request.contextPath}/theme/js/SpryTabbedPanels.js" type="text/javascript"></script>
	<link href="${pageContext.request.contextPath}/theme/css/SpryTabbedPanels.css" rel="stylesheet" type="text/css">

<script type="text/javascript">

function titles()
{
	if(document.searchs.title.value == "Search Title......." )
	{
		document.searchs.title.value="";
	}
}

function titles1()
{
		if(document.searchs.title.value == "")
		{
			document.searchs.title.value="Search Title.......";
		}

}
</script>
<style>
.inputbox 
{
	background-color: #f8e7ba;
	border: 1px solid #f4ae00;
}

</style>

</head>
<body class="awards">
<%@include file="../header.jsp" %>
<div class="pageHeader">
<center><br>
<h2 class="pageHeaderH2">Awards</h2>
</center>
</div>
<%
	Awards awardPage = Awards.getInstance();
	int cnt = awardPage.getAwardsCount();
%>
<div id="awards-section">
<div class="clear" style="height: 20px;"></div>
<div id="main-header-container">
<div id="brand-container">
			<h1 class="brand-container-title">How can YOU reduce corruption?</h1>
            <div class="title-caption">We believe that as citizens of this country, the best ideas come from us!</div>
            <p>If you have an idea to reduce or end corruption, share it
 with us here. We will take the winning ideas to various government 
departments and work to get them implemented.</p>
            <div style="background-color:#991e20; text-align:center; margin-top:5px; color:white;">Interview with the innovator of the most voted entry each week. Watch this space!</div>
		</div>
		
        <div id="button-table-container">
            <div id="submit-entry" class="interactions floating-left">
                <a href="#"><div class="floating-left icon"><img alt="Vote" title="Vote" src="${pageContext.request.contextPath}/theme/images/voteicon.png"></div>
                <div class="floating-left text"><p><strong style="font-size: 15px;">SUBMIT</strong><br>
                  your ideas!</p></div></a>
                <div class="clear"></div>
            </div>
            
            <div id="submit-vote" class="interactions floating-left">
                <a href="#"><div class="floating-left icon"><img alt="Ballot" title="Ballot" src="${pageContext.request.contextPath}/theme/images/balloticon.png"></div>
                <div class="floating-left text"><p><strong style="font-size: 15px;">VOTE FOR</strong><br> your favourite <br>
                  idea.</p></div></a>
                <div class="clear"></div>
            </div>
            
            <div id="submit-feature" class="interactions floating-left last">
                <div class="floating-left icon"><img alt="Satyameva Jayate" title="Satyameva Jayate" src="${pageContext.request.contextPath}/theme/images/smjlogo.png"></div>
                <div class="floating-left text"><p><strong>WATCH OUT</strong><br>
                  for the winners!!</p></div>
                <div class="clear"></div>
            </div>
            
        </div>
        
        <div class="intro-nor center "><p>All ideas are open for public voting. The top ten ideas will be judged by a panel of renowned experts in the field<br>of transparency and accountability in governance. </p><p>
    The winning idea will be recommended to the relevant government department.</p></div>
        
        <div class="with-border-intro-nor center">Look out for the winners soon!</div>
		
	</div>
	
	<div class="clear" style="height: 20px;"></div>
    <div class="award main-page">
    
		                 <div class="footer-lable">
<form method="post" action="#" name="searchs" id="searchs"><table border="0" cellpadding="0" cellspacing="0" width="746">
  <tbody><tr>
    <td width="500">Entries <span>till date: <%=cnt %> and counting...</span></td>
    <td width="146">
      <input name="title" id="title" class="inputbox" value="Search Title......." onfocus="titles()" onblur="titles1()" onclick="titles()" type="text"></td>
    <td align="center" width="4">&nbsp;</td>
   
    <td align="center" width="56"><input name="button" id="button" value="Search" type="submit" style="color: black;"></td>

  </tr>
            </tbody></table>
</form></div>

  <%@include file="design.jsp" %> 


</div> 
<!-- awards-section ends here -->
              
</div>

<br>
<%@include file="../footer.jsp" %>
</body>
</html>