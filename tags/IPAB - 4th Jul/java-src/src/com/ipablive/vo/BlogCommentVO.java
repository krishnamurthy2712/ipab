package com.ipablive.vo;

import java.util.Date;

public class BlogCommentVO 
{
	private int commentId;
	private int postId;
	private String commentTitle;
	private String commentContent;
	private String supportURL;
	private String ipAddress;
	private String createdBy;
	private Date creationDate;
	private int approval;
	private Date approvedDate;
	
	public int getCommentId() 
	{
		return commentId;
	}
	public void setCommentId(int commentId) 
	{
		this.commentId = commentId;
	}
	
	public int getPostId() 
	{
		return postId;
	}
	public void setPostId(int postId) 
	{
		this.postId = postId;
	}
	
	public String getCommentTitle() 
	{
		return commentTitle;
	}
	public void setCommentTitle(String commentTitle) 
	{
		this.commentTitle = commentTitle;
	}
	
	public String getCommentContent() 
	{
		return commentContent;
	}
	public void setCommentContent(String commentContent)
	{
		this.commentContent = commentContent;
	}
	
	public String getSupportURL() 
	{
		return supportURL;
	}
	public void setSupportURL(String supportURL) 
	{
		this.supportURL = supportURL;
	}
	
	public String getIpAddress() 
	{
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) 
	{
		this.ipAddress = ipAddress;
	}
	
	public String getCreatedBy() 
	{
		return createdBy;
	}
	public void setCreatedBy(String createdBy) 
	{
		this.createdBy = createdBy;
	}
	
	public Date getCreationDate() 
	{
		return creationDate;
	}
	public void setCreationDate(Date creationDate) 
	{
		this.creationDate = creationDate;
	}
	
	public int getApproval() 
	{
		return approval;
	}
	public void setApproval(int approval) 
	{
		this.approval = approval;
	}
	
	public Date getApprovedDate() 
	{
		return approvedDate;
	}
	public void setApprovedDate(Date approvedDate) 
	{
		this.approvedDate = approvedDate;
	}
	
}
