/**
 * 
 */
package com.ipablive.core;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.ipablive.datasource.ConnectionFactory;

/**
 * @author 
 *
 */
public class RegisterForUpdates 
{
	Connection conn=null;
	
	 /* Here is the instance of the Singleton */
	  private static RegisterForUpdates _registerUpdatesInstance;

	  //Prevent direct access to the constructor
	  private RegisterForUpdates() 
	  {
	    super();
	    if(conn == null)
	    {
	    	conn = ConnectionFactory.getConnection();
	    }
	  }
	  
	  public static RegisterForUpdates getInstance() 
	  {

	    if (_registerUpdatesInstance == null) 
	    {

	      synchronized(RegisterForUpdates.class) 
	      {

	        if (_registerUpdatesInstance == null) 
	        {
	        	_registerUpdatesInstance = new RegisterForUpdates();
	        }

	      }

	    }
	    
	    return _registerUpdatesInstance;
	  }
	  
	  public Boolean registerForUpdates(String email, String IP)
	  {
		  Boolean isStored = false;
		  
		  String query = "insert into bd_register_for_updates (email,IP) values (?,?)";
		  try
		  {
			  PreparedStatement pstmt = conn.prepareStatement(query);
			  pstmt.setString(1, email);
			  pstmt.setString(2, IP);
			  
			  int i = pstmt.executeUpdate();
			  
			  if(i>0)
			  {
				  isStored = true;
			  }
			  
		  }
		  catch (Exception e) 
		  {
			  
		  }  
		  
		  return isStored;
	  }
}
