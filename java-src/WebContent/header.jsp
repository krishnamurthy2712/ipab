<style type="text/css">
* { margin:0;
    padding:0;
}
body { background:rgb(74,81,85); }
div#menu { margin:5px auto; }
div#copyright {
    font:11px 'Trebuchet MS';
    color:#222;
    text-indent:30px;
    padding:40px 0 0 0;
}
div#copyright a { color:#000; }
div#copyright a:hover { color:#222; }
</style>
<br>
&nbsp;&nbsp;&nbsp;&nbsp;
<%
	String logo = "/theme/images/logo.png";
%>
<img src="${pageContext.request.contextPath}<%=logo %>" height="50">

<div id="menu">
    <ul class="menu">
        <li><a href="../index.jsp"><span>Home</span></a></li>
        <li><a class="parent"><span>Tell Us Your Bribe Story</span></a>
            <ul>
                 <li><a href="${pageContext.request.contextPath}/tellbribestory/ipaid.jsp"><span>I paid a bribe</span></a></li>
                <li><a href="${pageContext.request.contextPath}/tellbribestory/ididnotpaid.jsp"><span>I didn't pay a bribe</span></a></li>
                <li><a href="${pageContext.request.contextPath}/tellbribestory/donthavetopaid.jsp"><span>I didn't have to pay a bribe</span></a></li>
				<li><a href="${pageContext.request.contextPath}/tellbribestory/privatesector.jsp"><span>Private Sector Complaints</span></a></li>
            </ul>
        </li>
		<li><a class="parent"><span>Read Bribe Stories</span></a>
            <ul>
                <li><a href="${pageContext.request.contextPath}/readbribestory/ipaid.jsp"><span>I paid a bribe</span></a></li>
                <li><a href="${pageContext.request.contextPath}/readbribestory/ididnotpaid.jsp"><span>I didn't pay a bribe</span></a></li>
                <li><a href="${pageContext.request.contextPath}/readbribestory/donthavetopaid.jsp"><span>I didn't have to pay a bribe</span></a></li>
				<li><a href="${pageContext.request.contextPath}/readbribestory/privatesector.jsp"><span>Private Sector Complaints</span></a></li>
				<li><a href="${pageContext.request.contextPath}/readbribestory/sms.jsp"><span>SMS Complaints</span></a></li>
            </ul>
        </li>
		<li><a href="${pageContext.request.contextPath}/blog/blog.jsp"><span>Blog</span></a></li>
		<li><a href="${pageContext.request.contextPath}/faqs/forum.jsp"><span>FAQs</span></a></li>
        <li><a href="${pageContext.request.contextPath}/awards/awards.jsp"><span>Awards</span></a></li>
    </ul>
</div>
