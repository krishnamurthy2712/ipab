package com.ipablive.vo;

import java.util.Date;

public class PollVO 
{
	private int pollId;
	private String pollTitle;
	private String pollDescription;
	private String pollQuestion;
	private String pollOptions;
	private String pollCreationBy;
	private Date pollCreationDate;
	private int isDisplayed;
	private int approval;
	private String friendlyTime;
	private String ipAddress;
	
	public int getPollId() 
	{
		return pollId;
	}
	public void setPollId(int pollId)
	{
		this.pollId = pollId;
	}
	
	public String getPollTitle() 
	{
		return pollTitle;
	}
	public void setPollTitle(String pollTitle) 
	{
		this.pollTitle = pollTitle;
	}
	
	public String getPollDescription() 
	{
		return pollDescription;
	}
	public void setPollDescription(String pollDescription) 
	{
		this.pollDescription = pollDescription;
	}
	
	public String getPollQuestion() 
	{
		return pollQuestion;
	}
	public void setPollQuestion(String pollQuestion)
	{
		this.pollQuestion = pollQuestion;
	}
	
	public String getPollOptions() 
	{
		return pollOptions;
	}
	public void setPollOptions(String pollOptions) 
	{
		this.pollOptions = pollOptions;
	}
	
	public String getPollCreationBy()
	{
		return pollCreationBy;
	}
	public void setPollCreationBy(String pollCreationBy)
	{
		this.pollCreationBy = pollCreationBy;
	}
	
	public Date getPollCreationDate() {
		return pollCreationDate;
	}
	public void setPollCreationDate(Date pollCreationDate)
	{
		this.pollCreationDate = pollCreationDate;
	}
	
	public int getIsDisplayed() 
	{
		return isDisplayed;
	}
	public void setIsDisplayed(int isDisplayed)
	{
		this.isDisplayed = isDisplayed;
	}
	
	public int getApproval() 
	{
		return approval;
	}
	public void setApproval(int approval) 
	{
		this.approval = approval;
	}
	
	public String getFriendlyTime() 
	{
		return friendlyTime;
	}
	public void setFriendlyTime(String friendlyTime) 
	{
		this.friendlyTime = friendlyTime;
	}
	
	public String getIpAddress() 
	{
		return ipAddress;
	}
	public void setIpAddress(String ipAddress)
	{
		this.ipAddress = ipAddress;
	}
	
}
