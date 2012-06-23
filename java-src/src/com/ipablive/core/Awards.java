package com.ipablive.core;

import java.sql.Connection;

import com.ipablive.datasource.ConnectionFactory;

public class Awards 
{
	Connection conn=null;
	
	 /* Here is the instance of the Singleton */
	  private static Awards _awardsInstance;

	  //Prevent direct access to the constructor
	  private Awards() 
	  {
	    super();
	    if(conn == null)
	    {
	    	conn = ConnectionFactory.getConnection();
	    }
	  }
	  
	  public static Awards getInstance() 
	  {

	    if (_awardsInstance == null) 
	    {

	      synchronized(Awards.class) 
	      {

	        if (_awardsInstance == null) 
	        {
	        	_awardsInstance = new Awards();
	        }

	      }

	    }
	    
	    return _awardsInstance;
	  }
}
