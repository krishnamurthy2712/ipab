/**
 * 
 */
package com.ipablive.vo;

/**
 * @author 
 *
 */
public class TopFiveCitiesVO 
{
	private int totalRecs;
	private int totalAmount;
	private String cityName;
	private int cityId;
	
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
	
	public String getCityName()
	{
		return cityName;
	}
	public void setCityName(String cityName) 
	{
		this.cityName = cityName;
	}
	
	public int getCityId() 
	{
		return cityId;
	}
	public void setCityId(int cityId) 
	{
		this.cityId = cityId;
	}

}
