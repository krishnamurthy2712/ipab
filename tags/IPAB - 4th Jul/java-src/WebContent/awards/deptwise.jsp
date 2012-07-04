dept wise award<div id="listImg">
	<div class="teaser-list-Img floating-left">
		<a href='#'>nodeURL
		if img_source is not empty
         <img src="<?php echo base_path() ?>images/awards_dept/<?php echo $img_source; ?>" width="220" height="126"/></a>
		else
			default_smj_small.jpg
	</div>
	
	<div class="teaser-list-text floating-left">
			
			if(($voted==0)||(empty($voted))) 
			<div id="vote-img-nid" class="vote-icon floating-left">
				<a href="#">
				<img src="${pageContext.request.contextPath}/theme/images/thums-up.png" /></a>
			</div>
			else 
		
			<div id="vote-img-dull"  class="vote-icon floating-left">
				<img src="${pageContext.request.contextPath}/theme/images/thums-up-dis.png" />
			</div>
		<?php
			}
		?>
		<div id="vote-img-dull<?php echo $row->nid?>" style="display:none;"  class="vote-icon floating-left">
			<img src="${pageContext.request.contextPath}/theme/images/thums-up-dis.png" />
		</div>
		<div class="floating-right social-icons">
			<a href="http://www.facebook.com/share.php?u=nodeurl" target="_blank" class="facebook_share_view"></a>
			&nbsp;<a href="http://twitter.com/share?url=nodeurl" target="_blank" class="tweet_share_view"></a>
			<a href="${pageContext.request.contextPath}/theme//images/email.png" alt="Mail" title="Mail" align="absmiddle" class="mail-me"></a>
			<a class="addthis_button_more"><span><img src="${pageContext.request.contextPath}/theme/images/add_more.png" align="absmiddle" class="add-more"></span></a>
		</div>
	</div>
    <div class="clear"></div>
</div>

<?php } ?>
    <div class="viewall" ><a href="${pageContext.request.contextPath}/awards/deptAll.jsp"> View all</a> </div>s