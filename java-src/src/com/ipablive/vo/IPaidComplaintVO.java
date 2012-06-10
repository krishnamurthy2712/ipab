/**
 * 
 */
package com.ipablive.vo;

import java.util.Date;

/**
 * @author 
 *
 */
public class IPaidComplaintVO 
{
	private String cCity;
	private String otherCity;
	private String cDept;
	private String otherDept;
	private String cTransaction;
	private String otherTransaction;
	private int cAmtPaid;
	private Date cDatePaid;
	private String officeLocation;
	private String cBribeType;
	private String cPaymentMethod;
	private String otherPaymentMethod;
	private String cName;
	private String cAddiInfo;
	private String ipAddress;
	
	public String getCCity() 
	{
		return cCity;
	}
	public void setCCity(String city) 
	{
		cCity = city;
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
	
	public int getCAmtPaid() 
	{
		return cAmtPaid;
	}
	public void setCAmtPaid(int amtPaid) 
	{
		cAmtPaid = amtPaid;
	}
	
	public Date getCDatePaid() 
	{
		return cDatePaid;
	}
	public void setCDatePaid(Date datePaid) 
	{
		cDatePaid = datePaid;
	}
	
	public String getOfficeLocation() 
	{
		return officeLocation;
	}
	public void setOfficeLocation(String officeLocation) 
	{
		this.officeLocation = officeLocation;
	}
	
	public String getCBribeType() 
	{
		return cBribeType;
	}
	public void setCBribeType(String bribeType) 
	{
		cBribeType = bribeType;
	}
	
	public String getCPaymentMethod()
	{
		return cPaymentMethod;
	}
	public void setCPaymentMethod(String paymentMethod) 
	{
		cPaymentMethod = paymentMethod;
	}
	
	public String getOtherPaymentMethod() 
	{
		return otherPaymentMethod;
	}
	public void setOtherPaymentMethod(String otherPaymentMethod) 
	{
		this.otherPaymentMethod = otherPaymentMethod;
	}
	
	public String getCName() 
	{
		return cName;
	}
	public void setCName(String name) 
	{
		cName = name;
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
	
}
