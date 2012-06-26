/**
 * 
 */
package com.ipablive.vo;

/**
 * @author 
 *
 */
public class StateVO 
{
	private int id;
	private String stateName;
	private Long latitude;
	private Long longitude;
	private int val;
	private int size;
	private int bribeTotal;
	private int bribeCount;
	
	public int getId() 
	{
		return id;
	}
	public void setId(int id) 
	{
		this.id = id;
	}
	
	public String getStateName() 
	{
		return stateName;
	}
	public void setStateName(String stateName) 
	{
		this.stateName = stateName;
	}
	
	public Long getLatitude() 
	{
		return latitude;
	}
	public void setLatitude(Long latitude) 
	{
		this.latitude = latitude;
	}
	
	public Long getLongitude() 
	{
		return longitude;
	}
	public void setLongitude(Long longitude) 
	{
		this.longitude = longitude;
	}
	
	public int getVal() 
	{
		return val;
	}
	public void setVal(int val)
	{
		this.val = val;
	}
	
	public int getSize() 
	{
		return size;
	}
	public void setSize(int size) 
	{
		this.size = size;
	}
	
	public int getBribeTotal() 
	{
		return bribeTotal;
	}
	public void setBribeTotal(int bribeTotal) 
	{
		this.bribeTotal = bribeTotal;
	}
	
	public int getBribeCount() 
	{
		return bribeCount;
	}
	public void setBribeCount(int bribeCount) 
	{
		this.bribeCount = bribeCount;
	}
	
}
