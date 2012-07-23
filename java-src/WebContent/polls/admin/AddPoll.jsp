<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.ArrayList"%>
<%@page import="com.ipablive.vo.CityVO"%>
<%@page import="com.ipablive.vo.DepartmentVO"%>
<%@page import="com.ipablive.commons.CommonOperations"%><html>
<head>
    <meta http-equiv="content-type" content="text/html;charset=utf-8" />
    <title>Add Poll</title>
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
<script language="javascript">
	function addRow(tableID) 
	{
		var table = document.getElementById(tableID);
		var rowCount = table.rows.length;
		
		//as of now only 3 options allowed.
		if(rowCount<3)
		{
			var row = table.insertRow(rowCount);
 
			var cell1 = row.insertCell(0);
			var element1 = document.createElement("input");
			element1.type = "checkbox";
			cell1.appendChild(element1);
 
			var cell3 = row.insertCell(1);
			var element2 = document.createElement("input");
			element2.type = "text";
			element2.name = "pollOption";
			element2.id = "pollOption";
			cell3.appendChild(element2);
		}
		else
		{
			alert("More than 3 options are not allowed.");
		}
	}

	function deleteRow(tableID) 
	{
		try 
		{
			var table = document.getElementById(tableID);
			var rowCount = table.rows.length;
 
			if(rowCount>2)
			{
				for(var i=0; i<rowCount; i++) 
				{
					var row = table.rows[i];
					var chkbox = row.cells[0].childNodes[0];
					if(null != chkbox && true == chkbox.checked) 
					{
						table.deleteRow(i);
						rowCount--;
						i--;
					}
	 
				}
			}else
			{
				alert("Minimum 2 poll options are necessary.");	
			}
		}
		catch(e) 
		{
			alert(e);
		}
	}
	
	function validateForm()
	{
		var values = [];
		var cbs = document.forms['fm'].elements['pollOption'];
		for(var i=0;i<cbs.length;i++)
		{
			if(cbs[i].value=="")
			{
				var optionNo = i+1;
				alert("Please enter the value for option"+optionNo);
				return false;
			}
			else
			{
				values.push(cbs[i].value);
			}
		    
		}
		
		document.getElementById("pollOptions").value = values.join(" | ");

		
		return true;
	}

</script>

</head>
<body>
<%@include file="../../header.jsp" %>
<div class="clear"></div>
<div id="bg-wrapper" class="bg-wrapper">
<div class="breadcrumb">
			<div class="clear"></div>
				<a href="${pageContext.request.contextPath}" style="text-decoration: none;">Home</a> > Add poll
		<center><br>
		<h2 class="pageHeaderH2"> Add Poll </h2>
		</center>
		</div>
<div class="polls-block-box">
	<form id="fm" onsubmit="return validateForm()" action="insertPolls">
	<div class="clear"></div>
	<div class="divContent">
	<label for="pollTitle" style="width: 150px;"> Poll Title </label>
	<input type="text" id="pollTitle" name="pollTitle">
	</div>
	<div class="clear"></div><div class="clear"></div>
	<div class="divContent">
	<label for="pollDescription" style="width: 150px;"> Poll Description </label>
	<input type="text" id="pollDescription" name="pollDescription">
	</div>
	<div class="clear"></div><div class="clear"></div>
	<div class="divContent">
	<label for="pollQuestion" style="width: 150px;"> Poll Question </label>
	<input type="text" id="pollQuestion" name="pollQuestion" >
	</div>
	<div class="clear"></div><div class="clear"></div>
	<div class="divContent">
	<label for="pollOption" style="width: 150px;"> Poll Options</label>
	
	<img src="${pageContext.request.contextPath}/theme/images/add.png" alt="Add Option" onclick="addRow('optionsTable')" title="Add Option"/>
	<img src="${pageContext.request.contextPath}/theme/images/remove.png" alt="Delete Option" onclick="deleteRow('optionsTable')" title="Delete Option" />
	
	<table id="optionsTable" width="100%" style="margin-left: 50px;">
		<tr>
			<td style="width: 20px;"><INPUT type="checkbox" name="chk"/></td>
			<td> <INPUT type="text" name="pollOption" id="pollOption"/> </td>
		</tr>
		<tr>
			<td style="width: 20px;"><INPUT type="checkbox" name="chk"/></td>
			<td> <INPUT type="text" name="pollOption" id="pollOption"/> </td>
		</tr>
	</table>
	</div>
	
	<div class="divContent">
	<INPUT type="hidden" name="pollOptions" id="pollOptions"/> 
	<input type="hidden" id="createdBy" value="admin">
	<input type="submit" value="Add">
	</div>
	
	</form>
</div>

<%@include file="../../footer.jsp" %>
</div>
</body>
</html>