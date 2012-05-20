package com.ipablive.bdservice;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ipablive.datasource.ConnectionFactory;
import com.ipablive.utils.BribeConstants;
import com.ipablive.vo.CityVO;

/**
 *  README for sample service
 *
 *  This generated sample service contains functions that illustrate typical service operations.
 *  Use these functions as a starting point for creating your own service implementation. Modify the 
 *  function signatures, references to the database, and implementation according to your needs. 
 *  Delete the functions that you do not use.
 *
 *	@author 
**/

public class City 
{
	 Connection conn=null;
	
	 /* Here is the instance of the Singleton */
	  private static City _cityInstance;

	  //Prevent direct access to the constructor
	  private City() 
	  {
	    super();
	    if(conn == null)
	    {
	    	conn = ConnectionFactory.getConnection();
	    }
	  }


	  public static City getInstance() 
	  {

	    if (_cityInstance == null) 
	    {

	      synchronized(City.class) 
	      {

	        if (_cityInstance == null) 
	        {
	        	_cityInstance = new City();
	        }

	      }

	    }
	    return _cityInstance;
	  }
	  
	  /**
		 * Returns all the rows from the table.
		 *
		 * Add authroization or any logical checks for secure access to your data 
		 *
		 * @return arraylist<cityVO>
		 */

	  public ArrayList<CityVO> getAllBdCities() 
	  {
		  ArrayList<CityVO> cities = new ArrayList<CityVO>();
		  try
		  {
			  Statement stmt = conn.createStatement();
			  ResultSet rs = stmt.executeQuery(BribeConstants.GET_ALL_CITIES);
			  while(rs.next())
			  {
				  CityVO cVO = new CityVO();
				  cVO.setId(rs.getInt(1));
				  cVO.setState(rs.getInt(2));
				  cVO.setCityName(rs.getString(3));
				  
				  cities.add(cVO);
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
			    try 
			    {
			    	ConnectionFactory.closeConnection(conn);
				} 
			    catch (SQLException e) 
				{
					e.printStackTrace();
				}
		  }
		  return cities;
	  }
	  
	  public void getBd_cityByID(String itemID) 
	  {
		  
	  }

	  // please comment main after testing. This is test Purpose ONLY.
	  public static void main(String[] args) 
	  {
		City s = City.getInstance();
		ArrayList<CityVO> cities = s.getAllBdCities();
		System.out.println(cities.size() + "  SIZE");
	}
}
