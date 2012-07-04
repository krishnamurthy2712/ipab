/**
 * 
 */
package com.ipablive.vo;

import java.util.Date;

/**
 * @author 
 *
 */
public class BribeCityVO 
{
	private int totalPaid;
	private Date cDatePaid;
	private int totalBribes;
	private int deptCount;
	private int totalNoBribes;
	private int totalNotBribed;
	
	public int getTotalPaid() 
	{
		return totalPaid;
	}
	public void setTotalPaid(int totalPaid) 
	{
		this.totalPaid = totalPaid;
	}
	
	public Date getcDatePaid() 
	{
		return cDatePaid;
	}
	public void setcDatePaid(Date cDatePaid) 
	{
		this.cDatePaid = cDatePaid;
	}
	
	public int getTotalBribes() 
	{
		return totalBribes;
	}
	public void setTotalBribes(int totalBribes) 
	{
		this.totalBribes = totalBribes;
	}
	
	public int getDeptCount() 
	{
		return deptCount;
	}
	public void setDeptCount(int deptCount) 
	{
		this.deptCount = deptCount;
	}
	
	public int getTotalNoBribes() 
	{
		return totalNoBribes;
	}
	public void setTotalNoBribes(int totalNoBribes)
	{
		this.totalNoBribes = totalNoBribes;
	}
	
	public int getTotalNotBribed() 
	{
		return totalNotBribed;
	}
	public void setTotalNotBribed(int totalNotBribed)
	{
		this.totalNotBribed = totalNotBribed;
	}
	
}