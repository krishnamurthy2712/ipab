/**
 * 
 */
package com.ipablive.vo;

import java.util.Date;

/**
 * @author 
 *
 */
public class MostPopularReportsVO 
{
	private int id;
	private String cName;
	private int cCity;
	private int cDept;
	private int cTrans;
	private String otherTrans;
	private int cAmtPaid;
	private Date cPaidDate;
	private String bribeType;
	private String addInfo;
	private Date created;
	private String otherLocation;
	private int totalViews;
	private String cityName;
	private String deptName;
	private String transName;
	private String friendlyTime;
	private int commentsCount; 
	
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
	
	public int getCCity() 
	{
		return cCity;
	}
	public void setCCity(int city) 
	{
		cCity = city;
	}
	
	public int getCDept() 
	{
		return cDept;
	}
	public void setCDept(int dept) 
	{
		cDept = dept;
	}
	
	public int getCTrans() 
	{
		return cTrans;
	}
	public void setCTrans(int trans)
	{
		cTrans = trans;
	}
	
	public String getOtherTrans() 
	{
		return otherTrans;
	}
	public void setOtherTrans(String otherTrans)
	{
		this.otherTrans = otherTrans;
	}
	
	public int getCAmtPaid() 
	{
		return cAmtPaid;
	}
	public void setCAmtPaid(int amtPaid) 
	{
		cAmtPaid = amtPaid;
	}
	
	public Date getCPaidDate() 
	{
		return cPaidDate;
	}
	public void setCPaidDate(Date paidDate) 
	{
		cPaidDate = paidDate;
	}
	
	public String getBribeType() 
	{
		return bribeType;
	}
	public void setBribeType(String bribeType) 
	{
		this.bribeType = bribeType;
	}
	
	public String getAddInfo() 
	{
		return addInfo;
	}
	public void setAddInfo(String addInfo) 
	{
		this.addInfo = addInfo;
	}
	
	public Date getCreated() 
	{
		return created;
	}
	public void setCreated(Date created)
	{
		this.created = created;
	}
	
	public String getOtherLocation() 
	{
		return otherLocation;
	}
	public void setOtherLocation(String otherLocation)
	{
		this.otherLocation = otherLocation;
	}
	
	public int getTotalViews()
	{
		return totalViews;
	}
	public void setTotalViews(int totalViews)
	{
		this.totalViews = totalViews;
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
	
	public String getFriendlyTime() 
	{
		return friendlyTime;
	}
	public void setFriendlyTime(String friendlyTime)
	{
		this.friendlyTime = friendlyTime;
	}
	
	public int getCommentsCount() 
	{
		return commentsCount;
	}
	public void setCommentsCount(int commentsCount) 
	{
		this.commentsCount = commentsCount;
	}
	
}
