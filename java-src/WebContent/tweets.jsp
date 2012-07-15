<script src="${pageContext.request.contextPath}/theme/js/jScrollPane.js" type="text/javascript">
	</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/theme/js/jquery.mousewheel.js"></script>
<script src="${pageContext.request.contextPath}/theme/js/tweetsScript.js" type="text/javascript">
	</script>
<link type="text/css" href="${pageContext.request.contextPath}/theme/css/jScrollPane.css" rel="stylesheet" />

<div id="tweet-box-style">
	<div id="twitter-ticker">
	<!-- Twitter container, hidden by CSS and shown if JS is present -->
	
		<div id="top-bar">
		<!-- This contains the title and icon -->
	
		<div id="twitIcon"><img src="${pageContext.request.contextPath}/theme/images/twitter/twitter_64.png" width="64" height="64" alt="Twitter icon" /></div>
		<!-- The twitter icon -->
	
		<h2 class="tut">My tweets</h2>
		<!-- Title -->
	
		</div>
	
		<div id="tweet-container"><img id="loading" src="${pageContext.request.contextPath}/theme/images/twitter/loading.gif" width="16" height="11" alt="Loading.." /></div>
		<!-- The loading gif animation - hidden once the tweets are loaded -->
	
		<div id="scroll"></div>
		<!-- Container for the tweets -->
	
	</div>
<div class="clear" style="height: 5px"></div>
	<div id="tweets-bottom">
	<img src="${pageContext.request.contextPath}/theme/images/twitter/widget-bird.png">
	&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; 
	<a href="https://twitter.com/ipaidabribe" style="text-decoration: none; color: black;" target="_blank">Join the conversation</a>
	</div>
</div>

