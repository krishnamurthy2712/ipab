/**
 * 
 */
package com.ipablive.vo;

import java.util.Date;

/**
 * @author 
 *
 */
public class BribeVO 
{
	private int id;
	private String cName;
	private int cCity;
	private int cDept;
	private int cTransaction;
	private String othersTransaction;
	private int cAmtPaid;
	private Date cDatePaid;
	private String cBribeType;
	private int cValTran;
	private String cAddiInfo;
	private int approved;
	private String othersDept;
	private Date created;
	private String otherLocation;
	private String IP;
	private String filtered;
	private String filteredKeys;
	private int count;
	
	public int getId() 
	{
		return id;
	}
	public void setId(int id) 
	{
		this.id = id;
	}
	
	public String getcName() 
	{
		return cName;
	}
	public void setcName(String cName) 
	{
		this.cName = cName;
	}
	
	public int getcCity() 
	{
		return cCity;
	}
	public void setcCity(int cCity)
	{
		this.cCity = cCity;
	}
	
	public int getcDept() 
	{
		return cDept;
	}
	public void setcDept(int cDept) 
	{
		this.cDept = cDept;
	}
	
	public int getcTransaction()
	{
		return cTransaction;
	}
	public void setcTransaction(int cTransaction) 
	{
		this.cTransaction = cTransaction;
	}
	
	public String getOthersTransaction() 
	{
		return othersTransaction;
	}
	public void setOthersTransaction(String othersTransaction) 
	{
		this.othersTransaction = othersTransaction;
	}
	
	public int getcAmtPaid() 
	{
		return cAmtPaid;
	}
	public void setcAmtPaid(int cAmtPaid) 
	{
		this.cAmtPaid = cAmtPaid;
	}
	
	public Date getcDatePaid() 
	{
		return cDatePaid;
	}
	public void setcDatePaid(Date cDatePaid) 
	{
		this.cDatePaid = cDatePaid;
	}
	
	public String getcBribeType() 
	{
		return cBribeType;
	}
	public void setcBribeType(String cBribeType) 
	{
		this.cBribeType = cBribeType;
	}
	
	public int getcValTran() 
	{
		return cValTran;
	}
	public void setcValTran(int cValTran) 
	{
		this.cValTran = cValTran;
	}
	
	public String getcAddiInfo() 
	{
		return cAddiInfo;
	}
	public void setcAddiInfo(String cAddiInfo)
	{
		this.cAddiInfo = cAddiInfo;
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
	
	public String getOtherLocation() 
	{
		return otherLocation;
	}
	public void setOtherLocation(String otherLocation) 
	{
		this.otherLocation = otherLocation;
	}
	
	public String getIP() 
	{
		return IP;
	}
	public void setIP(String iP) 
	{
		IP = iP;
	}
	
	public String getFiltered() 
	{
		return filtered;
	}
	public void setFiltered(String filtered)
	{
		this.filtered = filtered;
	}
	
	public String getFilteredKeys() 
	{
		return filteredKeys;
	}
	public void setFilteredKeys(String filteredKeys) 
	{
		this.filteredKeys = filteredKeys;
	}
	
	public int getCount() 
	{
		return count;
	}
	public void setCount(int count) 
	{
		this.count = count;
	}
}
