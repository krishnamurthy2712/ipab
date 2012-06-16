/**
 * 
 */
package com.ipablive.vo;

import java.util.Date;

/**
 * @author 
 *
 */
public class FaqVO 
{

	private int id;
	private int deptId;
	private int transactionId;
	private int cityId;
	private String question;
	private String answer;
	private int priority;
	private Date createdAt;
	private Date updatedAt;
	private int published;
	private String cityName;
	private String deptName;
	private String transName;
	
	public int getId() 
	{
		return id;
	}
	public void setId(int id) 
	{
		this.id = id;
	}
	
	public int getDeptId() 
	{
		return deptId;
	}
	public void setDeptId(int deptId) 
	{
		this.deptId = deptId;
	}
	
	public int getTransactionId() 
	{
		return transactionId;
	}
	public void setTransactionId(int transactionId) 
	{
		this.transactionId = transactionId;
	}
	
	public int getCityId() 
	{
		return cityId;
	}
	public void setCityId(int cityId) 
	{
		this.cityId = cityId;
	}
	
	public String getQuestion() 
	{
		return question;
	}
	public void setQuestion(String question)
	{
		this.question = question;
	}
	
	public String getAnswer() 
	{
		return answer;
	}
	public void setAnswer(String answer) 
	{
		this.answer = answer;
	}
	
	public int getPriority() 
	{
		return priority;
	}
	public void setPriority(int priority) 
	{
		this.priority = priority;
	}
	
	public Date getCreatedAt() 
	{
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) 
	{
		this.createdAt = createdAt;
	}
	
	public Date getUpdatedAt() 
	{
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) 
	{
		this.updatedAt = updatedAt;
	}
	
	public int getPublished() 
	{
		return published;
	}
	public void setPublished(int published) 
	{
		this.published = published;
	}
	
	public String getCityName() 
	{
		return cityName;
	}
	public void setCityName(String cityName)
	{
		this.cityName = cityName;
	}
	
	public String getDeptName() 
	{
		return deptName;
	}
	public void setDeptName(String deptName) 
	{
		this.deptName = deptName;
	}
	
	public String getTransName() 
	{
		return transName;
	}
	public void setTransName(String transName) 
	{
		this.transName = transName;
	}
	
}
