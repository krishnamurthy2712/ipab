package com.ipablive.core;

import java.sql.Connection;

import com.ipablive.datasource.ConnectionFactory;

public class Blogs 
{
	Connection conn=null;
	
	 /* Here is the instance of the Singleton */
	  private static Blogs _blogsInstance;

	  //Prevent direct access to the constructor
	  private Blogs() 
	  {
	    super();
	    if(conn == null)
	    {
	    	conn = ConnectionFactory.getConnection();
	    }
	  }
	  
	  public static Blogs getInstance() 
	  {

	    if (_blogsInstance == null) 
	    {

	      synchronized(Blogs.class) 
	      {

	        if (_blogsInstance == null) 
	        {
	        	_blogsInstance = new Blogs();
	        }

	      }

	    }
	    
	    return _blogsInstance;
	  }
}
