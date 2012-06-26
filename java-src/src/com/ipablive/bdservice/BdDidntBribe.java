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
public class BdDidntBribe 
{
	Connection conn=null;
	
	 /* Here is the instance of the Singleton */
	  private static BdDidntBribe _didntPaidBribeInstance;

	  //Prevent direct access to the constructor
	  private BdDidntBribe() 
	  {
	    super();
	    if(conn == null)
	    {
	    	conn = ConnectionFactory.getConnection();
	    }
	  }


	  public static BdDidntBribe getInstance() 
	  {

	    if (_didntPaidBribeInstance == null) 
	    {

	      synchronized(BdDidntBribe.class) 
	      {

	        if (_didntPaidBribeInstance == null) 
	        {
	        	_didntPaidBribeInstance = new BdDidntBribe();
	        }

	      }

	    }
	    return _didntPaidBribeInstance;
	  }
}
