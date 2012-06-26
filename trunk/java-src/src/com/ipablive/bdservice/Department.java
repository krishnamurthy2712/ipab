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
import com.ipablive.vo.CityVO;
import com.ipablive.vo.DepartmentVO;
import com.ipablive.vo.MostBribeCityVO;
import com.ipablive.vo.MostBribeDeptVO;

/**
 *
 *  This generated sample service contains functions that illustrate typical service operations.
 *  Use these functions as a starting point for creating your own service implementation. Modify the 
 *  function signatures, references to the database, and implementation according to your needs. 
 *  Delete the functions that you do not use.
 *
 *	@author 
**/
public class Department 
{

	Connection conn=null;
	
	 /* Here is the instance of the Singleton */
	  private static Department _deptInstance;

	  //Prevent direct access to the constructor
	  private Department() 
	  {
	    super();
	    if(conn == null)
	    {
	    	conn = ConnectionFactory.getConnection();
	    }
	  }


	  public static Department getInstance() 
	  {

	    if (_deptInstance == null) 
	    {

	      synchronized(Department.class) 
	      {

	        if (_deptInstance == null) 
	        {
	        	_deptInstance = new Department();
	        }

	      }

	    }
	    return _deptInstance;
	  }
	  
	  public ArrayList<DepartmentVO> getAllBdDept()
	  {
		  ArrayList<DepartmentVO> departments = new ArrayList<DepartmentVO>();
		  try
		  {
			  Statement stmt = conn.createStatement();
			  ResultSet rs = stmt.executeQuery(BribeConstants.GET_ALL_DEPTS);
			  while(rs.next())
			  {
				  DepartmentVO dept = new DepartmentVO();
				  dept.setDeptID(rs.getInt(1));
				  dept.setDeptName(rs.getString(2));
				  
				  departments.add(dept);
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
		  return departments;
	  }
	  
	  public DepartmentVO getBdDeptByID(int deptID)
	  {
		  DepartmentVO dept = new DepartmentVO();
		  try
		  {
			  Statement stmt = conn.createStatement();
			  ResultSet rs = stmt.executeQuery(BribeConstants.GET_DEPT_BY_ID + deptID);
			  if(rs.next())
			  {
				  dept.setDeptID(rs.getInt(1));
				  dept.setDeptName(rs.getString(2));
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
		  return dept;
		  
	  }
	  
	  public int getCount() 
	  {
		  int count = 0;
		  try
		  {
			  Statement stmt = conn.createStatement();
			  ResultSet rs = stmt.executeQuery(BribeConstants.GET_DEPT_COUNT);
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
	  
	  public ArrayList<DepartmentVO> getBdDeptPaged(int startIndex, int numItems)
	  {
		  ArrayList<DepartmentVO> departments = new ArrayList<DepartmentVO>();
		  try
		  {
			  Statement stmt = conn.createStatement();
			  String limit = startIndex +","+numItems; 
			  ResultSet rs = stmt.executeQuery(BribeConstants.GET_CITY_PAGED+limit);
			  while(rs.next())
			  {
				  DepartmentVO dept = new DepartmentVO();
				  dept.setDeptID(rs.getInt(1));
				  dept.setDeptName(rs.getString(2));
				  
				  departments.add(dept);
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
		  return departments;
	  }
	  
	  public ArrayList<MostBribeDeptVO> getMostBribed() 
	  {
		  ArrayList<MostBribeDeptVO> analysis = new ArrayList<MostBribeDeptVO>();
		  try
		  {
			  Statement stmt = conn.createStatement();
			  ResultSet rs = stmt.executeQuery(BribeConstants.GET_CITY_MOST_BRIBED);
			  while(rs.next())
			  {
				  MostBribeDeptVO mbVO = new MostBribeDeptVO();
				  mbVO.setId(rs.getInt(1));
				  mbVO.setDeptName(rs.getString(2));
				  mbVO.setBribedCount(rs.getInt(3));
				  mbVO.setBribedTotal(rs.getInt(4));
				  mbVO.setBribedAverage(rs.getInt(5));
				  mbVO.setNotBribed(rs.getInt(6));
				  mbVO.setNoBribe(rs.getInt(7));
				  
				  analysis.add(mbVO);
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
		  return analysis;
	  }
	  
	  public MostBribeDeptVO getBribedByCity(int cityId) 
	  {
		  MostBribeDeptVO mcVo = new MostBribeDeptVO();
		  try
		  {
			  String query = "SELECT id, dept_name as name, (SELECT COUNT(id) FROM bd_paid_bribe " +
			  		"where c_city = "+cityId+" and c_dept = bd_dept.id " +
			  		"AND approved = 1) AS BribedCount FROM bd_dept ORDER BY BribedCount DESC";
			  Statement stmt = conn.createStatement();
			  ResultSet rs = stmt.executeQuery(query);
			  while(rs.next())
			  {
				  mcVo.setId(rs.getInt(1));
				  mcVo.setDeptName(rs.getString(2));
				  mcVo.setBribedCount(rs.getInt(3));
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
		  
		  return mcVo;
	  }
	  
	  
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
