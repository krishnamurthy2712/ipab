/**
 * 
 */
package com.ipablive.bdservice;

import java.sql.Connection;

import com.ipablive.datasource.ConnectionFactory;

/**
 *
 *  This generated sample service contains functions that illustrate typical service operations.
 *  Use these functions as a starting point for creating your own service implementation. Modify the 
 *  function signatures, references to the database, and implementation according to your needs. 
 *  Delete the functions that you do not use.
 *
 *	@author 
**/
public class DidntHaveToBribe 
{
	Connection conn=null;
	
	 /* Here is the instance of the Singleton */
	  private static DidntHaveToBribe _didntHaveToBribeInstance;

	  //Prevent direct access to the constructor
	  private DidntHaveToBribe() 
	  {
	    super();
	    if(conn == null)
	    {
	    	conn = ConnectionFactory.getConnection();
	    }
	  }


	  public static DidntHaveToBribe getInstance() 
	  {

	    if (_didntHaveToBribeInstance == null) 
	    {

	      synchronized(DidntHaveToBribe.class) 
	      {

	        if (_didntHaveToBribeInstance == null) 
	        {
	        	_didntHaveToBribeInstance = new DidntHaveToBribe();
	        }

	      }

	    }
	    return _didntHaveToBribeInstance;
	  }
}
