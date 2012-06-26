package com.ipablive.bdservice;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.ipablive.vo.MostBribeCityVO;
import com.ipablive.datasource.ConnectionFactory;
import com.ipablive.utils.BribeConstants;
import com.ipablive.vo.CityVO;

/**
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
			  closeConnection();
		  }
		  return cities;
	  }
	  
	  public CityVO getBdCityByID(int itemID) 
	  {
		  CityVO cVo = new CityVO();
		  try
		  {
			  Statement stmt = conn.createStatement();
			  ResultSet rs = stmt.executeQuery(BribeConstants.GET_CITY_BY_ID + itemID);
			  if(rs.next())
			  {
				  cVo.setId(rs.getInt(1));
				  cVo.setState(rs.getInt(2));
				  cVo.setCityName(rs.getString(3));
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
		  return cVo;
	  }

	  public int getCount() 
	  {
		  int count = 0;
		  try
		  {
			  Statement stmt = conn.createStatement();
			  ResultSet rs = stmt.executeQuery(BribeConstants.GET_CITY_COUNT);
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
	  
	  public ArrayList<CityVO> getBdCityPaged(int startIndex, int numItems)
	  {
		  ArrayList<CityVO> cities = new ArrayList<CityVO>();
		  try
		  {
			  Statement stmt = conn.createStatement();
			  String limit = startIndex +","+numItems; 
			  ResultSet rs = stmt.executeQuery(BribeConstants.GET_CITY_PAGED+limit);
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
			  closeConnection();
		  }
		  return cities;
	  }
	  
	  public ArrayList<MostBribeCityVO> getMostBribed() 
	  {
		  ArrayList<MostBribeCityVO> analysis = new ArrayList<MostBribeCityVO>();
		  try
		  {
			  Statement stmt = conn.createStatement();
			  ResultSet rs = stmt.executeQuery(BribeConstants.GET_CITY_MOST_BRIBED);
			  while(rs.next())
			  {
				  MostBribeCityVO mbVO = new MostBribeCityVO();
				  mbVO.setId(rs.getInt(1));
				  mbVO.setCityName(rs.getString(2));
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
	  
	  public MostBribeCityVO getBribedByDept(int deptID) 
	  {
		  MostBribeCityVO mcVo = new MostBribeCityVO();
		  try
		  {
			  String query = "SELECT Id as id, city_name as name, " + 
						"(SELECT COUNT(id) FROM bd_paid_bribe where c_dept = "+deptID+" and c_city = bd_city.Id AND approved = 1) AS BribedCount" +
						"FROM bd_city ORDER BY BribedCount DESC";
			  Statement stmt = conn.createStatement();
			  ResultSet rs = stmt.executeQuery(query);
			  while(rs.next())
			  {
				  mcVo.setId(rs.getInt(1));
				  mcVo.setCityName(rs.getString(2));
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

	  // please comment main after testing. This is test Purpose ONLY.
	  public static void main(String[] args) 
	  {
		City s = City.getInstance();
		//ArrayList<CityVO> cities = s.getAllBdCities();
		//System.out.println(cities.size() + "  SIZE");
		//=====================================
		//CityVO cv = s.getBdCityByID(1);
		//System.out.println("City Name :: "+cv.getCityName());
		//=====================================
		ArrayList<MostBribeCityVO> count = s.getMostBribed();
		System.out.println(count.size() + "" );
	}
}
