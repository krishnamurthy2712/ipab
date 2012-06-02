package com.ipablive.core;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.ipablive.bdservice.City;
import com.ipablive.datasource.ConnectionFactory;

public class IPaidBribe 
{
	 Connection conn=null;
		
	 /* Here is the instance of the Singleton */
	  private static IPaidBribe _bribeInstance;

	  //Prevent direct access to the constructor
	  private IPaidBribe() 
	  {
	    super();
	    if(conn == null)
	    {
	    	conn = ConnectionFactory.getConnection();
	    }
	  }
	  
	  public static IPaidBribe getInstance() 
	  {

	    if (_bribeInstance == null) 
	    {

	      synchronized(IPaidBribe.class) 
	      {

	        if (_bribeInstance == null) 
	        {
	        	_bribeInstance = new IPaidBribe();
	        }

	      }

	    }
	    
	    return _bribeInstance;
	  }
	
	public ArrayList<String> getCounties()
	{
		ArrayList<String> counties = new ArrayList<String>();
		try
		{
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT city_name FROM bd_city");
			while(rs.next())
			{
				counties.add(rs.getString(1));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return counties;
	}
	
	public ArrayList<String> getDepartments()
	{
		ArrayList<String> depts = new ArrayList<String>();
		try
		{
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select dept_name from bd_dept");
			while(rs.next())
			{
				depts.add(rs.getString(1));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return depts;
	}
	
	public ArrayList<String> getTransactions(int deptId)
	{
		ArrayList<String> transactions = new ArrayList<String>();
		try
		{
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select trans_name from bd_transactions where dept_id="+deptId);
			while(rs.next())
			{
				transactions.add(rs.getString(1));
			}
			transactions.add(0, "Select Transaction");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return transactions;
	}
}
