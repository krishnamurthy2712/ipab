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
	private String cDept;
	private String cTransaction;
	private String otherTransaction;
	private int cAmountPaid;
	private Date cDatePaid;
	private String cBribeType;
	private int totalView;
	private String cAdditionalInfo;
	
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
	
	public String getCDept() 
	{
		return cDept;
	}
	public void setCDept(String dept) 
	{
		cDept = dept;
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
	
	public int getTotalView() 
	{
		return totalView;
	}
	public void setTotalView(int totalView) 
	{
		this.totalView = totalView;
	}
	
	public String getCAdditionalInfo() 
	{
		return cAdditionalInfo;
	}
	public void setCAdditionalInfo(String additionalInfo) 
	{
		cAdditionalInfo = additionalInfo;
	}
	
	
	
	
	

}
