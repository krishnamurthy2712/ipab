/**
 * 
 */
package com.ipablive.bdservice;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ipablive.datasource.ConnectionFactory;
import com.ipablive.utils.BribeConstants;
import com.ipablive.vo.DepartmentVO;
import com.ipablive.vo.MostBribeDeptVO;
import com.ipablive.vo.StateVO;

/**
 *
 *  This generated sample service contains functions that illustrate typical service operations.
 *  Use these functions as a starting point for creating your own service implementation. Modify the 
 *  function signatures, references to the database, and implementation according to your needs. 
 *  Delete the functions that you do not use.
 *
 *	@author 
**/
public class State 
{

	Connection conn=null;
	
	 /* Here is the instance of the Singleton */
	  private static State _stateInstance;

	  //Prevent direct access to the constructor
	  public State() 
	  {
	    super();
	    if(conn == null)
	    {
	    	conn = ConnectionFactory.getConnection();
	    }
	  }


	 /* public static State getInstance() 
	  {

	    if (_stateInstance == null) 
	    {

	      synchronized(State.class) 
	      {

	        if (_stateInstance == null) 
	        {
	        	_stateInstance = new State();
	        }

	      }

	    }
	    return _stateInstance;
	  }*/
	  
	  public ArrayList<StateVO> getAllBdStates()
	  {
		  ArrayList<StateVO> states = new ArrayList<StateVO>();
		  try
		  {
			  Statement stmt = conn.createStatement();
			  ResultSet rs = stmt.executeQuery(BribeConstants.GET_ALL_STATES);
			  while(rs.next())
			  {
				  StateVO state = new StateVO();
				  state.setStateName(rs.getString(1));
				  state.setId(rs.getInt(2));
				  state.setBribeTotal(rs.getInt(3));
				  state.setBribeCount(rs.getInt(4));
				  
				  states.add(state);
			  }
		  }
		  catch(SQLException e)
		  {
			e.printStackTrace();  
		  }
		  catch(Exception ex)
		  {
			  ex.printStackTrace();
		  }
		  finally
		  {
			  closeConnection();
		  }
		  return states;
	  }
	  
	  public StateVO getBdStateByID(int stateId)
	  {
		  StateVO state = new StateVO();
		  
		  try
		  {
			  Statement stmt = conn.createStatement();
			  ResultSet rs = stmt.executeQuery(BribeConstants.GET_STATE_BY_ID + stateId);
			  if(rs.next())
			  {
				  state.setStateName(rs.getString(1));
				  state.setId(rs.getInt(2));
				  state.setBribeTotal(rs.getInt(3));
				  state.setBribeCount(rs.getInt(4));
			  }
		  }
		  catch(SQLException e)
		  {
			e.printStackTrace();  
		  }
		  catch(Exception ex)
		  {
			  ex.printStackTrace();
		  }
		  finally
		  {
			  closeConnection();
		  }
		  return state;
		  
	  }
	  
	  public int getCount() 
	  {
		  int count = 0;
		  try
		  {
			  Statement stmt = conn.createStatement();
			  ResultSet rs = stmt.executeQuery(BribeConstants.GET_STATE_COUNT);
			  while(rs.next())
			  {
				  count = rs.getInt(1);
			  }
		  }
		  catch(SQLException e)
		  {
			e.printStackTrace();  
		  }
		  catch(Exception ex)
		  {
			  ex.printStackTrace();
		  }
		  finally
		  {
			  closeConnection();
		  }
		  
		  return count;
	  }
	  
	  public ArrayList<StateVO> getBdDeptPaged(int startIndex, int numItems)
	  {
		  ArrayList<StateVO> states = new ArrayList<StateVO>();
		  try
		  {
			  Statement stmt = conn.createStatement();
			  String limit = startIndex +","+numItems; 
			  ResultSet rs = stmt.executeQuery(BribeConstants.GET_STATE_PAGED+limit);
			  while(rs.next())
			  {
				  StateVO state = new StateVO();
				  state.setId(rs.getInt(1));
				  state.setStateName(rs.getString(2));
				  
				  states.add(state);
			  }
		  }
		  catch(SQLException e)
		  {
			e.printStackTrace();  
		  }
		  catch(Exception ex)
		  {
			  ex.printStackTrace();
		  }
		  finally
		  {
			  closeConnection();
		  }
		  
		  return states;
	  }
	  
	  //create State
	  //update State
	  //delete state
	  
	  private void closeConnection()
	  {
		  try 
		    {
		    	ConnectionFactory.closeConnection(conn);
			} 
		    catch (SQLException e) 
			{
				e.printStackTrace();
			}
	  }
	
}
