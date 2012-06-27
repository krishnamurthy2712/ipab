/**
 * 
 */
package com.ipablive.vo;

import java.util.Date;

/**
 * @author 
 *
 */
public class DintHaveToBribeVO 
{
	private int id;
	private String cName;
	private int cCity;
	private int cDept;
	private int cTransaction;
	private String othersTransaction;
	private String cBribeType;
	private String cBribeResistedBy;
	private String cAddiInfo;
	private int approved;
	private String othersDept;
	private Date created;
	private String IP;
	private String filtered;
	
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
	
	public int getCTransaction() 
	{
		return cTransaction;
	}
	public void setCTransaction(int transaction) 
	{
		cTransaction = transaction;
	}
	
	public String getOthersTransaction() 
	{
		return othersTransaction;
	}
	public void setOthersTransaction(String othersTransaction) 
	{
		this.othersTransaction = othersTransaction;
	}
	
	public String getCBribeType() 
	{
		return cBribeType;
	}
	public void setCBribeType(String bribeType) 
	{
		cBribeType = bribeType;
	}
	
	public String getCBribeResistedBy()
	{
		return cBribeResistedBy;
	}
	public void setCBribeResistedBy(String bribeResistedBy) 
	{
		cBribeResistedBy = bribeResistedBy;
	}
	
	public String getCAddiInfo() 
	{
		return cAddiInfo;
	}
	public void setCAddiInfo(String addiInfo) 
	{
		cAddiInfo = addiInfo;
	}
	
	public int getApproved() 
	{
		return approved;
	}
	public void setApproved(int approved) 
	{
		this.approved = approved;
	}
	
	public String getOthersDept() 
	{
		return othersDept;
	}
	public void setOthersDept(String othersDept) 
	{
		this.othersDept = othersDept;
	}
	
	public Date getCreated()
	{
		return created;
	}
	public void setCreated(Date created) 
	{
		this.created = created;
	}
	
	public String getIP() 
	{
		return IP;
	}
	public void setIP(String ip) 
	{
		IP = ip;
	}
	
	public String getFiltered() 
	{
		return filtered;
	}
	public void setFiltered(String filtered) 
	{
		this.filtered = filtered;
	}
	
}
