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
public class BdPaidBribe 
{
	Connection conn=null;
	
	 /* Here is the instance of the Singleton */
	  private static BdPaidBribe _paidBribeInstance;

	  //Prevent direct access to the constructor
	  private BdPaidBribe() 
	  {
	    super();
	    if(conn == null)
	    {
	    	conn = ConnectionFactory.getConnection();
	    }
	  }


	  public static BdPaidBribe getInstance() 
	  {

	    if (_paidBribeInstance == null) 
	    {

	      synchronized(BdPaidBribe.class) 
	      {

	        if (_paidBribeInstance == null) 
	        {
	        	_paidBribeInstance = new BdPaidBribe();
	        }

	      }

	    }
	    return _paidBribeInstance;
	  }
}
