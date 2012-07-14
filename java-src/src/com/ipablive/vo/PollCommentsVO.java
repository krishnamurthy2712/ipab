/**
 * 
 */
package com.ipablive.vo;

import java.util.Date;

/**
 * @author 
 *
 */
public class PollCommentsVO 
{
	private int commentId;
	private int pollId;
	private String comment;
	private Date createdDate;
	private String friendlyDate;
	private String ipAddress;
	private String commentedBy;
	
	public int getCommentId() 
	{
		return commentId;
	}
	public void setCommentId(int commentId) 
	{
		this.commentId = commentId;
	}
	
	public int getPollId() 
	{
		return pollId;
	}
	public void setPollId(int pollId) 
	{
		this.pollId = pollId;
	}
	
	public String getComment() 
	{
		return comment;
	}
	public void setComment(String comment) 
	{
		this.comment = comment;
	}
	
	public Date getCreatedDate() 
	{
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) 
	{
		this.createdDate = createdDate;
	}
	
	public String getFriendlyDate() 
	{
		return friendlyDate;
	}
	public void setFriendlyDate(String friendlyDate) 
	{
		this.friendlyDate = friendlyDate;
	}
	
	public String getIpAddress() 
	{
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) 
	{
		this.ipAddress = ipAddress;
	}
	
	public String getCommentedBy() 
	{
		return commentedBy;
	}
	public void setCommentedBy(String commentedBy) 
	{
		this.commentedBy = commentedBy;
	}
}
