/**
 * 
 */
package com.ipablive.vo;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author 
 *
 */
public class BlogPostDetailsVO 
{
	private int postId;
	private String postTitle;
	private String postContent;
	private String destURL;
	private String ipAddress;
	private String postedBy;
	private Date postCreatedDate;
	private int postApproval;
	private Date approvedDate;
	private ArrayList<BlogCommentVO> postComments;
	private int totalViews;
	
	public int getPostId() 
	{
		return postId;
	}
	public void setPostId(int postId) 
	{
		this.postId = postId;
	}
	
	public String getPostTitle() 
	{
		return postTitle;
	}
	public void setPostTitle(String postTitle) 
	{
		this.postTitle = postTitle;
	}
	
	public String getPostContent() 
	{
		return postContent;
	}
	public void setPostContent(String postContent) 
	{
		this.postContent = postContent;
	}
	
	public String getDestURL() 
	{
		return destURL;
	}
	public void setDestURL(String destURL) 
	{
		this.destURL = destURL;
	}
	
	public String getIpAddress() 
	{
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) 
	{
		this.ipAddress = ipAddress;
	}
	
	public String getPostedBy() 
	{
		return postedBy;
	}
	public void setPostedBy(String postedBy) 
	{
		this.postedBy = postedBy;
	}
	
	public Date getPostCreatedDate() 
	{
		return postCreatedDate;
	}
	public void setPostCreatedDate(Date postCreatedDate) 
	{
		this.postCreatedDate = postCreatedDate;
	}
	
	public int getPostApproval() 
	{
		return postApproval;
	}
	public void setPostApproval(int postApproval) 
	{
		this.postApproval = postApproval;
	}
	
	public Date getApprovedDate() 
	{
		return approvedDate;
	}
	public void setApprovedDate(Date approvedDate) 
	{
		this.approvedDate = approvedDate;
	}
	
	public ArrayList<BlogCommentVO> getPostComments() 
	{
		return postComments;
	}
	public void setPostComments(ArrayList<BlogCommentVO> postComments) 
	{
		this.postComments = postComments;
	}
	
	public int getTotalViews() 
	{
		return totalViews;
	}
	public void setTotalViews(int totalViews) 
	{
		this.totalViews = totalViews;
	}
	
}
