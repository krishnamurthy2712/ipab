/**
 * 
 */
package com.ipablive.vo;

import java.sql.Date;

/**
 * @author 
 *
 */
public class PollResultVO 
{
	private int resultId;
	private int pollId;
	private String pollOption;
	private String createdBy;
	private Date creationDate;
	private String ipAddress;
	
	public int getResultId() 
	{
		return resultId;
	}
	public void setResultId(int resultId) 
	{
		this.resultId = resultId;
	}
	
	public int getPollId() 
	{
		return pollId;
	}
	public void setPollId(int pollId) 
	{
		this.pollId = pollId;
	}
	
	public String getPollOption() 
	{
		return pollOption;
	}
	public void setPollOption(String pollOption) 
	{
		this.pollOption = pollOption;
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
	
	public String getIpAddress() 
	{
		return ipAddress;
	}
	public void setIpAddress(String ipAddress)
	{
		this.ipAddress = ipAddress;
	}
	
	
	

}
