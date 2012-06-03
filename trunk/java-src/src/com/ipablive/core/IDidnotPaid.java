/**
 * 
 */
package com.ipablive.core;

import java.sql.Connection;

import com.ipablive.datasource.ConnectionFactory;

/**
 * @author 
 *
 */
public class IDidnotPaid 
{
	Connection conn=null;
	
	 /* Here is the instance of the Singleton */
	  private static IDidnotPaid _didntBribeInstance;

	  //Prevent direct access to the constructor
	  private IDidnotPaid() 
	  {
	    super();
	    if(conn == null)
	    {
	    	conn = ConnectionFactory.getConnection();
	    }
	  }
	  
	  public static IDidnotPaid getInstance() 
	  {

	    if (_didntBribeInstance == null) 
	    {

	      synchronized(IDidnotPaid.class) 
	      {

	        if (_didntBribeInstance == null) 
	        {
	        	_didntBribeInstance = new IDidnotPaid();
	        }

	      }

	    }
	    
	    return _didntBribeInstance;
	  }
	  
	  
}
