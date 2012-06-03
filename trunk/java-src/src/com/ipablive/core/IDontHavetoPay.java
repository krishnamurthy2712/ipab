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
public class IDontHavetoPay 
{
	Connection conn=null;
	
	 /* Here is the instance of the Singleton */
	  private static IDontHavetoPay _dontHavetoInstance;

	  //Prevent direct access to the constructor
	  private IDontHavetoPay() 
	  {
	    super();
	    if(conn == null)
	    {
	    	conn = ConnectionFactory.getConnection();
	    }
	  }
	  
	  public static IDontHavetoPay getInstance() 
	  {

	    if (_dontHavetoInstance == null) 
	    {

	      synchronized(IDontHavetoPay.class) 
	      {

	        if (_dontHavetoInstance == null) 
	        {
	        	_dontHavetoInstance = new IDontHavetoPay();
	        }

	      }

	    }
	    
	    return _dontHavetoInstance;
	  }
}
