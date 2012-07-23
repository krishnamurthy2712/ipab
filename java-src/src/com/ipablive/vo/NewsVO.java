/**
 * 
 */
package com.ipablive.vo;

import java.util.Date;

/**
 * @author 
 *
 */
public class NewsVO 
{
	private int newsId;
	private String newsCreated;
	private String newsTitle;
	private String newsBody;
	private String newsDst;
	private String newsSourceValue;
	private Date newsCreatedDate;
	private String friendlyDate;
	private String ipAddress;
	
	public int getNewsId() 
	{
		return newsId;
	}
	public void setNewsId(int newsId) 
	{
		this.newsId = newsId;
	}
	
	public String getNewsCreated() 
	{
		return newsCreated;
	}
	public void setNewsCreated(String newsCreated) 
	{
		this.newsCreated = newsCreated;
	}
	
	public String getNewsTitle() 
	{
		return newsTitle;
	}
	public void setNewsTitle(String newsTitle) 
	{
		this.newsTitle = newsTitle;
	}
	
	public String getNewsBody() 
	{
		return newsBody;
	}
	public void setNewsBody(String newsBody) 
	{
		this.newsBody = newsBody;
	}
	
	public String getNewsDst() 
	{
		return newsDst;
	}
	public void setNewsDst(String newsDst) 
	{
		this.newsDst = newsDst;
	}
	
	public String getNewsSourceValue() 
	{
		return newsSourceValue;
	}
	public void setNewsSourceValue(String newsSourceValue) 
	{
		this.newsSourceValue = newsSourceValue;
	}
	
	public Date getNewsCreatedDate() 
	{
		return newsCreatedDate;
	}
	public void setNewsCreatedDate(Date newsCreatedDate) 
	{
		this.newsCreatedDate = newsCreatedDate;
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
	
}
