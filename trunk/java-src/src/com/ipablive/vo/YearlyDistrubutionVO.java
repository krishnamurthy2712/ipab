/**
 * 
 */
package com.ipablive.vo;

import java.util.Date;


/**
 * @author 
 *
 */
public class YearlyDistrubutionVO 
{
	private Date dateOrder;
	private Date dateOrder2;
	private int bribedCount;
	private int bribedAverage;
	private int bribedTotal;
	private Date dateName;
	
	public Date getDateOrder() 
	{
		return dateOrder;
	}
	public void setDateOrder(Date dateOrder) 
	{
		this.dateOrder = dateOrder;
	}
	
	public Date getDateOrder2()
	{
		return dateOrder2;
	}
	public void setDateOrder2(Date dateOrder2) 
	{
		this.dateOrder2 = dateOrder2;
	}
	
	public int getBribedCount() 
	{
		return bribedCount;
	}
	public void setBribedCount(int bribedCount) 
	{
		this.bribedCount = bribedCount;
	}
	
	public int getBribedAverage() 
	{
		return bribedAverage;
	}
	public void setBribedAverage(int bribedAverage) 
	{
		this.bribedAverage = bribedAverage;
	}
	
	public int getBribedTotal() 
	{
		return bribedTotal;
	}
	public void setBribedTotal(int bribedTotal) 
	{
		this.bribedTotal = bribedTotal;
	}
	
	public Date getDateName() 
	{
		return dateName;
	}
	public void setDateName(Date dateName) 
	{
		this.dateName = dateName;
	}
}
