<div class="footer">
	<ul id="footer_links">
        <li><a href="${pageContext.request.contextPath}/aboutus.jsp" title="About Us">About Us</a></li>
        <li><a href="${pageContext.request.contextPath}/contactus.jsp" title="Contact Us">Contact Us</a></li>
        <li><a href="${pageContext.request.contextPath}/privacyPolicy.jsp" title="Privacy Policy">Privacy Policy</a></li>
        <li><a href="${pageContext.request.contextPath}/registerupdates.jsp" title="Register for Updates">Register for Updates</a></li>
       </ul>
       
       <div class="copyrights" >
		<a href="http://www.facebook.com/ipabkenya" target="_blank" title="Facebook"></a>
		<a class="twitter_bot" href="http://twitter.com/ipaidabribe_ke" target="_blank" title="Twitter"></a>
		<a class="youtube_bot" href="http://www.youtube.com/user/" target="_blank" title="You Tube"></a>
		<a class="orkut_bot" href="http://www.orkut.co.in/Main#Community?cmm=" target="_blank" title="Orkut"></a>
       
       	<p>&copy; 2011,  All rights Reserved<br />I Paid A Bribe</p>
		<p id="bookmarkIpab"></p><br>
	   </div>
</div>


<!-- Stack tool bar -->
   
<div class="stack addthis_toolbox">
    <img src="${pageContext.request.contextPath}/theme/images/stack/stack.png" alt="stack"/>
    <ul id="stack" class="custom_images">
        <li><a class="addthis_button_more"><span>More...</span>
        <img src="${pageContext.request.contextPath}/theme/images/stack/addthis.png" alt="More..." /></a></li>
        <li><a class="addthis_button_stumbleupon"><span>StumbleUpon</span>
        <img src="${pageContext.request.contextPath}/theme/images/stack/stumbleupon.png" alt="Stumble It" /></a></li>
        <li><a class="addthis_button_reddit"><span>Reddit</span>
        <img src="${pageContext.request.contextPath}/theme/images/stack/reddit.png" alt="Share to Reddit" /></a></li>
        <li><a class="addthis_button_digg"><span>Delicious</span>
        <img src="${pageContext.request.contextPath}/theme/images/stack/digg.png" alt="Share to Digg" /></a></li>
        <li><a class="addthis_button_twitter"><span>Twitter</span>
        <img src="${pageContext.request.contextPath}/theme/images/stack/twitter.png" alt="Share to Twitter" /></a></li>
        <li><a class="addthis_button_facebook"><span>Facebook</span>
        <img src="${pageContext.request.contextPath}/theme/images/stack/facebook.png" alt="Share to Facebook" /></a></li>
     </ul>
</div>    

<script type="text/javascript" src="http://s7.addthis.com/js/250/addthis_widget.js"></script>
<script type="text/javascript">
$(function () { 
	// Stack initialize
	var openspeed = 300;
	var closespeed = 300;
	$('.stack>img').toggle(function(){
		var vertical = 0;
		var horizontal = 0;
		var $el=$(this);
		$el.next().children().each(function(){
			$(this).animate({top: '-' + vertical + 'px', left: horizontal + 'px'}, openspeed);
			vertical = vertical + 55;
			horizontal = (horizontal+.75)*2;
		});
		$el.next().animate({top: '-50px', left: '10px'}, openspeed).addClass('openStack')
		   .find('li a>img').animate({width: '50px', marginLeft: '9px'}, openspeed);
		$el.animate({paddingTop: '0'});
	}, function(){
		//reverse above
		var $el=$(this);
		$el.next().removeClass('openStack').children('li').animate({top: '55px', left: '-10px'}, closespeed);
		$el.next().find('li a>img').animate({width: '79px', marginLeft: '0'}, closespeed);
		$el.animate({paddingTop: '35px'});
	});
	
	// Stacks additional animation
	$('.stack li a').hover(function(){
		$("img",this).animate({width: '56px'}, 100);
		$("span",this).animate({marginRight: '30px'});
	},function(){
		$("img",this).animate({width: '50px'}, 100);
		$("span",this).animate({marginRight: '0'});
	});
});

function bookmarkIpab() 
{ 
	title = "IpaidBribe"; 
	url = "http://localhost:8080/ipab";

	if (window.sidebar) 
	{ // Mozilla Firefox Bookmark
		window.sidebar.addPanel(title, url,"");
	} 
	else if( window.external ) 
	{ // IE Favorite
		window.external.AddFavorite( url, title); 
	}
	else if(window.opera && window.print) 
	{ // Opera Hotlist
		return true; 
	}
}

function addBookmarkLabel()
{
	var fav = document.getElementById("bookmarkIpab");
	if (window.external) 
	{
	  fav.innerHTML = '<a href = "javaScript: bookmarkIpab()">Add to Favourites.</a>'; 
	} 
	else  if (window.sidebar) 
	{
		fav.innerHTML = '<a href = "javaScript: bookmarkIpab()">Bookmark IpaidBribe.</a>'; 
    } 
    else if (window.opera && window.print) 
	{	
    	fav.innerHTML = '<a href = "javaScript: bookmarkIpab()">Bookmark IpaidBribe.</a>';
    } 
	
}

</script>