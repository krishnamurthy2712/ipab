/**
 * 
 */
package com.ipablive.vo;

/**
 * @author 
 * This class is used to display top 5 cities data in Home page.
 */
public class TopCitiesVO 
{
	private String cityName;
	private int amountPaid;
	
	public String getCityName() 
	{
		return cityName;
	}
	public void setCityName(String cityName) 
	{
		this.cityName = cityName;
	}
	
	public int getAmountPaid() 
	{
		return amountPaid;
	}
	public void setAmountPaid(int amountPaid) 
	{
		this.amountPaid = amountPaid;
	}
	
}
