<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
<html>
<head>
    <meta http-equiv="content-type" content="text/html;charset=utf-8" />
    <title>I Paid a Bribe</title>
    <link type="text/css" href="${pageContext.request.contextPath}/theme/css/menu.css" rel="stylesheet" />
    <script type="text/javascript" src="${pageContext.request.contextPath}/theme/js/jquery.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/theme/js/menu.js"></script>
</head>
<body>
<%@include file="../header.jsp" %>
<div id="mainContent">
	
 <html:form action="/iPaid.do" >
        <table>
            <tr>
                <td>
                    <label for="cCity">County  </label>
                </td>
                <td>
                    <html:select property="cCity" >
					<html:option value="" >Select County</html:option><html:option value="1">Baringo</html:option><html:option value="2">Bomet</html:option><html:option value="3">Bungoma</html:option><html:option value="4">Busia</html:option><html:option value="5">Elgeyo Marakwet</html:option><html:option value="6">Embu</html:option><html:option value="7">Garissa</html:option><html:option value="8">Homa Bay</html:option><html:option value="9">Isiolo</html:option><html:option value="46">Kajiado</html:option><html:option value="10">Kakamega</html:option><html:option value="11">Kericho</html:option><html:option value="12">Kiambu</html:option><html:option value="13">Kilifi</html:option><html:option value="14">Kirinyaga</html:option><html:option value="15">Kisii</html:option><html:option value="16">Kisumu</html:option><html:option value="45">Kitui</html:option><html:option value="17">Kwale</html:option><html:option value="18">Laikipia</html:option><html:option value="19">Lamu</html:option><html:option value="20">Machakos</html:option><html:option value="21">Makueni</html:option><html:option value="22">Mandera</html:option><html:option value="23">Marsabit</html:option><html:option value="24">Meru</html:option><html:option value="25">Migori</html:option><html:option value="26">Mombasa</html:option><html:option value="27">Muranga</html:option><html:option value="28">Nairobi</html:option><html:option value="29">Nakuru</html:option><html:option value="30">Nandi</html:option><html:option value="31">Narok</html:option><html:option value="32">Nyamira</html:option><html:option value="33">Nyandarua</html:option><html:option value="34">Nyeri</html:option><html:option value="35">Samburu</html:option><html:option value="36">Siaya</html:option><html:option value="37">Taita Taveta</html:option><html:option value="38">Tana River</html:option><html:option value="39">Tharaka Nithi</html:option><html:option value="40">Trans Nzoia</html:option><html:option value="41">Turkana</html:option><html:option value="42">Uasin Gishu</html:option><html:option value="43">Vihiga</html:option><html:option value="44">Wajir</html:option><html:option value="47">West Pokot</html:option>
					</html:select>
                </td>
				<td>
                    <html:select property="cDept" >
					<html:option value="" >Select Department</html:option><html:option value="1">Baringo</html:option><html:option value="2">Bomet</html:option><html:option value="3">Bungoma</html:option><html:option value="4">Busia</html:option><html:option value="5">Elgeyo Marakwet</html:option><html:option value="6">Embu</html:option><html:option value="7">Garissa</html:option><html:option value="8">Homa Bay</html:option><html:option value="9">Isiolo</html:option><html:option value="46">Kajiado</html:option><html:option value="10">Kakamega</html:option><html:option value="11">Kericho</html:option><html:option value="12">Kiambu</html:option><html:option value="13">Kilifi</html:option><html:option value="14">Kirinyaga</html:option><html:option value="15">Kisii</html:option><html:option value="16">Kisumu</html:option><html:option value="45">Kitui</html:option><html:option value="17">Kwale</html:option><html:option value="18">Laikipia</html:option><html:option value="19">Lamu</html:option><html:option value="20">Machakos</html:option><html:option value="21">Makueni</html:option><html:option value="22">Mandera</html:option><html:option value="23">Marsabit</html:option><html:option value="24">Meru</html:option><html:option value="25">Migori</html:option><html:option value="26">Mombasa</html:option><html:option value="27">Muranga</html:option><html:option value="28">Nairobi</html:option><html:option value="29">Nakuru</html:option><html:option value="30">Nandi</html:option><html:option value="31">Narok</html:option><html:option value="32">Nyamira</html:option><html:option value="33">Nyandarua</html:option><html:option value="34">Nyeri</html:option><html:option value="35">Samburu</html:option><html:option value="36">Siaya</html:option><html:option value="37">Taita Taveta</html:option><html:option value="38">Tana River</html:option><html:option value="39">Tharaka Nithi</html:option><html:option value="40">Trans Nzoia</html:option><html:option value="41">Turkana</html:option><html:option value="42">Uasin Gishu</html:option><html:option value="43">Vihiga</html:option><html:option value="44">Wajir</html:option><html:option value="47">West Pokot</html:option>
					</html:select>
                </td>
            </tr>
        </table>
        </html:form>
</div>
<%@include file="../footer.jsp" %>
</body>
</html>