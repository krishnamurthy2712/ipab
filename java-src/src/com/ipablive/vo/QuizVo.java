package com.ipablive.vo;

import java.util.ArrayList;

public class QuizVo 
{
	private int qId;
	private String qDescription;
	private ArrayList<OptionsVO> options;
	
	
	public int getqId()
	{
		return qId;
	}
	public void setqId(int qId) 
	{
		this.qId = qId;
	}
	
	public String getqDescription() 
	{
		return qDescription;
	}
	public void setqDescription(String qDescription) 
	{
		this.qDescription = qDescription;
	}
	
	public ArrayList<OptionsVO> getOptions() 
	{
		return options;
	}
	public void setOptions(ArrayList<OptionsVO> options) 
	{
		this.options = options;
	}
	
	
	
	
}
