/**
 * 
 */
package com.ipablive.vo;

/**
 * @author 
 *
 */
public class MostBribeDeptVO 
{
	private int id;
	private String deptName;
	private int bribedCount;
	private int bribedTotal;
	private int bribedAverage;
	private int notBribed;
	private int noBribe;
	
	public int getId() 
	{
		return id;
	}
	public void setId(int id) 
	{
		this.id = id;
	}
	
	public String getDeptName() 
	{
		return deptName;
	}
	public void setDeptName(String deptName) 
	{
		this.deptName = deptName;
	}
	
	public int getBribedCount() 
	{
		return bribedCount;
	}
	public void setBribedCount(int bribedCount) 
	{
		this.bribedCount = bribedCount;
	}
	
	public int getBribedTotal() 
	{
		return bribedTotal;
	}
	public void setBribedTotal(int bribedTotal) 
	{
		this.bribedTotal = bribedTotal;
	}
	
	public int getBribedAverage() 
	{
		return bribedAverage;
	}
	public void setBribedAverage(int bribedAverage) 
	{
		this.bribedAverage = bribedAverage;
	}
	
	public int getNotBribed() 
	{
		return notBribed;
	}
	public void setNotBribed(int notBribed) 
	{
		this.notBribed = notBribed;
	}
	
	public int getNoBribe() 
	{
		return noBribe;
	}
	public void setNoBribe(int noBribe) 
	{
		this.noBribe = noBribe;
	}
}
