/**
 * 
 */
package com.ipablive.vo;

/**
 * @author 
 *
 */
public class DidnotHaveToPayComplaintVO 
{
	private String cCity;
	private String cName;
	private String otherCity;
	private String cDept;
	private String otherDept;
	private String cTransaction;
	private String otherTransaction;
	private String cAddiInfo;
	private String ipAddress;
	private String cBribeResistedBy;
	private String cBribeType;
	
	public String getCCity() 
	{
		return cCity;
	}
	public void setCCity(String city) 
	{
		cCity = city;
	}
	
	public String getCName() 
	{
		return cName;
	}
	public void setCName(String name) 
	{
		cName = name;
	}
	
	public String getOtherCity() 
	{
		return otherCity;
	}
	public void setOtherCity(String otherCity)
	{
		this.otherCity = otherCity;
	}
	
	public String getCDept() 
	{
		return cDept;
	}
	public void setCDept(String dept) 
	{
		cDept = dept;
	}
	
	public String getOtherDept() 
	{
		return otherDept;
	}
	public void setOtherDept(String otherDept) 
	{
		this.otherDept = otherDept;
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
	
	public String getCAddiInfo() 
	{
		return cAddiInfo;
	}
	public void setCAddiInfo(String addiInfo) 
	{
		cAddiInfo = addiInfo;
	}
	
	public String getIpAddress() 
	{
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) 
	{
		this.ipAddress = ipAddress;
	}
	
	public String getCBribeResistedBy() 
	{
		return cBribeResistedBy;
	}
	public void setCBribeResistedBy(String bribeResistedBy) 
	{
		cBribeResistedBy = bribeResistedBy;
	}
	
	public String getCBribeType() 
	{
		return cBribeType;
	}
	public void setCBribeType(String bribeType) 
	{
		cBribeType = bribeType;
	}
}
