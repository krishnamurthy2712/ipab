/**
 * 
 */
package com.ipablive.vo;

/**
 * @author 
 *
 */
public class TopFiveDeptsVO 
{
	private int totalRecs;
	private int totalAmount;
	private String deptName;
	private int deptId;
	
	public int getTotalRecs() 
	{
		return totalRecs;
	}
	public void setTotalRecs(int totalRecs) 
	{
		this.totalRecs = totalRecs;
	}
	
	public int getTotalAmount()
	{
		return totalAmount;
	}
	public void setTotalAmount(int totalAmount) 
	{
		this.totalAmount = totalAmount;
	}
	
	public String getDeptName() 
	{
		return deptName;
	}
	public void setDeptName(String deptName) 
	{
		this.deptName = deptName;
	}
	
	public int getDeptId()
	{
		return deptId;
	}
	public void setDeptId(int deptId) 
	{
		this.deptId = deptId;
	}
}
