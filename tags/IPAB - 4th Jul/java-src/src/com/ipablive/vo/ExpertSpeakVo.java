/**
 * 
 */
package com.ipablive.vo;

import java.util.Date;

/**
 * @author 
 *
 */
public class ExpertSpeakVo 
{
	private String authorName;
	private Date created;
	private String title;
	private int epId;
	private String fieldTitleURL;
	private String body;
	private String dst;
	
	public String getAuthorName() 
	{
		return authorName;
	}
	public void setAuthorName(String authorName) 
	{
		this.authorName = authorName;
	}
	
	public Date getCreated() 
	{
		return created;
	}
	public void setCreated(Date created) 
	{
		this.created = created;
	}
	
	public String getTitle() 
	{
		return title;
	}
	public void setTitle(String title) 
	{
		this.title = title;
	}
	
	public int getEpId() 
	{
		return epId;
	}
	public void setEpId(int epId) 
	{
		this.epId = epId;
	}
	
	public String getFieldTitleURL() 
	{
		return fieldTitleURL;
	}
	public void setFieldTitleURL(String fieldTitleURL) 
	{
		this.fieldTitleURL = fieldTitleURL;
	}
	
	public String getBody() 
	{
		return body;
	}
	public void setBody(String body) 
	{
		this.body = body;
	}
	
	public String getDst() 
	{
		return dst;
	}
	public void setDst(String dst) 
	{
		this.dst = dst;
	}

}
