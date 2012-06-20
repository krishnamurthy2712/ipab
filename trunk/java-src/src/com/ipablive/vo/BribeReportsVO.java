/**
 * 
 */
package com.ipablive.vo;

import java.util.Date;

/**
 * @author 
 *
 */
public class BribeReportsVO 
{
	private int id;
	private String cName;
	private String cCity;
	private String cDeptName;
	private String cTransaction;
	private String otherTransaction;
	private int cAmountPaid;
	private Date cDatePaid;
	private String cBribeType;
	private int totalViews;
	private String cAdditionalInfo;
	private int deptId;
	private int commentsCount;
	private String friendlyTime;
	private Date created;
	
	public int getId() 
	{
		return id;
	}
	public void setId(int id) 
	{
		this.id = id;
	}
	
	public String getCName() 
	{
		return cName;
	}
	public void setCName(String name) 
	{
		cName = name;
	}
	
	public String getCCity() 
	{
		return cCity;
	}
	public void setCCity(String city) 
	{
		cCity = city;
	}
	
	public String getCDeptName() 
	{
		return cDeptName;
	}
	public void setCDeptName(String dept) 
	{
		cDeptName = dept;
	}
	
	public String getCTransaction() 
	{
		return cTransaction;
	}
	public void setCTransaction(String transaction) 
	{
		cTransaction = transaction;
	}
	
	public String getOtherTransaction() 
	{
		return otherTransaction;
	}
	public void setOtherTransaction(String otherTransaction) 
	{
		this.otherTransaction = otherTransaction;
	}
	
	public int getCAmountPaid() 
	{
		return cAmountPaid;
	}
	public void setCAmountPaid(int amountPaid) 
	{
		cAmountPaid = amountPaid;
	}
	
	public Date getCDatePaid() 
	{
		return cDatePaid;
	}
	public void setCDatePaid(Date datePaid) 
	{
		cDatePaid = datePaid;
	}
	
	public String getCBribeType() 
	{
		return cBribeType;
	}
	public void setCBribeType(String bribeType) 
	{
		cBribeType = bribeType;
	}
	
	public int getTotalViews() 
	{
		return totalViews;
	}
	public void setTotalViews(int totalViews) 
	{
		this.totalViews = totalViews;
	}
	
	public String getCAdditionalInfo() 
	{
		return cAdditionalInfo;
	}
	public void setCAdditionalInfo(String additionalInfo) 
	{
		cAdditionalInfo = additionalInfo;
	}
	
	public int getDeptId() 
	{
		return deptId;
	}
	public void setDeptId(int deptId) 
	{
		this.deptId = deptId;
	}
	
	public int getCommentsCount() 
	{
		return commentsCount;
	}
	public void setCommentsCount(int commentsCount) 
	{
		this.commentsCount = commentsCount;
	}
	
	public String getFriendlyTime() 
	{
		return friendlyTime;
	}
	public void setFriendlyTime(String friendlyTime) 
	{
		this.friendlyTime = friendlyTime;
	}
	
	public Date getCreated() 
	{
		return created;
	}
	public void setCreated(Date created) 
	{
		this.created = created;
	}

}
