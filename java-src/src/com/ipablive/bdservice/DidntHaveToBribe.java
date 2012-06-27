/**
 * 
 */
package com.ipablive.bdservice;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.ipablive.datasource.ConnectionFactory;
import com.ipablive.vo.DidntBribeVO;
import com.ipablive.vo.DintHaveToBribeVO;
import com.ipablive.vo.YearlyDistrubutionVO;

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
	  public DidntHaveToBribe() 
	  {
	    super();
	    if(conn == null)
	    {
	    	conn = ConnectionFactory.getConnection();
	    }
	  }


	  /*public static DidntHaveToBribe getInstance() 
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
	  }*/
	  
	  public ArrayList<DintHaveToBribeVO> getAllBdDintHaveToBribe() 
	  {
		  ArrayList<DintHaveToBribeVO> bribes = new ArrayList<DintHaveToBribeVO>();
		  
		  String query = "SELECT * FROM bd_dint_have_to_bribe";
		  
		  try
		  {
			  Statement stmt = conn.createStatement();
			  ResultSet rs = stmt.executeQuery(query);
			  
			  while(rs.next())
			  {
				  DintHaveToBribeVO b = new DintHaveToBribeVO();
				  b.setId(rs.getInt(1));
				  b.setCName(rs.getString(2));
				  b.setCCity(rs.getInt(3));
				  b.setCDept(rs.getInt(4));
				  b.setCTransaction(rs.getInt(5));
				  b.setCBribeType(rs.getString(6));
				  b.setCBribeResistedBy(rs.getString(7));
				  b.setCAddiInfo(rs.getString(8));
				  b.setCreated(rs.getDate(9));
				  b.setApproved(rs.getInt(10));
				  b.setIP(rs.getString(11));
				  b.setFiltered(rs.getString(12));
				  b.setOthersTransaction(rs.getString(13));
				  b.setOthersDept(rs.getString(14));
				  
				  bribes.add(b);
			  }
		  }catch(Exception e)
		  {
			  e.printStackTrace();
		  }
		  
		  return bribes;
	  }
	  
	  public DintHaveToBribeVO getBdDintHaveToBribeByID(int id) 
	  {
		  DintHaveToBribeVO b = new DintHaveToBribeVO();
		  
		  String query = "SELECT * FROM bd_dint_have_to_bribe where id="+id;
		  
		  try
		  {
			  Statement stmt = conn.createStatement();
			  ResultSet rs = stmt.executeQuery(query);
			  
			  if(rs.next())
			  {
				  b.setId(rs.getInt(1));
				  b.setCName(rs.getString(2));
				  b.setCCity(rs.getInt(3));
				  b.setCDept(rs.getInt(4));
				  b.setCTransaction(rs.getInt(5));
				  b.setCBribeType(rs.getString(6));
				  b.setCBribeResistedBy(rs.getString(7));
				  b.setCAddiInfo(rs.getString(8));
				  b.setCreated(rs.getDate(9));
				  b.setApproved(rs.getInt(10));
				  b.setIP(rs.getString(11));
				  b.setFiltered(rs.getString(12));
				  b.setOthersTransaction(rs.getString(13));
				  b.setOthersDept(rs.getString(14));
				  
			  }
		  }catch(Exception e)
		  {
			  e.printStackTrace();
		  }
		  
		  return b;
	  }
	  
	  public DintHaveToBribeVO getBdDintHaveToBribePaged(int startIndex, int numItemsNeeded)
	  {
		  DintHaveToBribeVO b = new DintHaveToBribeVO();
		  String limit = startIndex+","+numItemsNeeded;
		  String query = "SELECT * FROM bd_dint_have_to_bribe LIMIT "+limit;
		  
		  try
		  {
			  Statement stmt = conn.createStatement();
			  ResultSet rs = stmt.executeQuery(query);
			  
			  if(rs.next())
			  {
				  b.setId(rs.getInt(1));
				  b.setCName(rs.getString(2));
				  b.setCCity(rs.getInt(3));
				  b.setCDept(rs.getInt(4));
				  b.setCTransaction(rs.getInt(5));
				  b.setCBribeType(rs.getString(6));
				  b.setCBribeResistedBy(rs.getString(7));
				  b.setCAddiInfo(rs.getString(8));
				  b.setCreated(rs.getDate(9));
				  b.setApproved(rs.getInt(10));
				  b.setIP(rs.getString(11));
				  b.setFiltered(rs.getString(12));
				  b.setOthersTransaction(rs.getString(13));
				  b.setOthersDept(rs.getString(14));
				  
			  }
		  }catch(Exception e)
		  {
			  e.printStackTrace();
		  }
		  
		  return b;
		  
	  }
	  //create, update, delete
	  
	  public int getCount()
	  {
		  int count = 0;
		  
		  String query = "SELECT COUNT(*) AS COUNT FROM bd_dint_have_to_bribe";
		  
		  try
		  {
			  Statement stmt = conn.createStatement();
			  ResultSet rs = stmt.executeQuery(query);
			  
			  if(rs.next())
			  {
				  count = rs.getInt(1);
			  }
		  }catch(Exception e)
		  {
			  e.printStackTrace();
		  }
		  
		  return count;
	  }
	  
	  public ArrayList<YearlyDistrubutionVO> getYearlyDistribution(Boolean type, int cCity,int cDept)
	  {
		  ArrayList<YearlyDistrubutionVO> distrubution = new ArrayList<YearlyDistrubutionVO>();
		  
		  String query = "";
		  if(type)
		  {
			  query = "SELECT DISTINCT EXTRACT( WEEK FROM c_date_paid ) AS dateOrder, " +
			  		"EXTRACT( YEAR FROM c_date_paid ) AS dateOrder2, " +
			  		"COUNT( id ) AS BribedCount, AVG( c_amt_paid ) AS BribedAverage, " +
			  		"SUM( c_amt_paid ) AS BribedTotal, DATE_FORMAT( c_date_paid,  '%e %b, %y' ) AS dateName " +
			  		"FROM bd_dint_have_to_bribe WHERE c_city ="+cCity+" AND c_date_paid " +
			  		"IS NOT NULL AND approved =1 GROUP BY dateOrder, dateOrder2 " +
			  		"ORDER BY dateOrder2 DESC , dateOrder DESC LIMIT 10";
		  }
		  else
		  {
			  query = "SELECT DISTINCT EXTRACT( WEEK FROM c_date_paid ) AS dateOrder," +
			  		" EXTRACT( YEAR FROM c_date_paid ) AS dateOrder2," +
			  		" COUNT( id ) AS BribedCount, AVG( c_amt_paid ) AS BribedAverage, " +
			  		"SUM( c_amt_paid ) AS BribedTotal, DATE_FORMAT( c_date_paid,  '%e %b, %y' ) AS dateName " +
			  		"FROM bd_dint_have_to_bribe WHERE c_dept = "+cDept+" AND c_date_paid " +
			  		"IS NOT NULL AND approved =1 GROUP BY dateOrder, dateOrder2 " +
			  		"ORDER BY dateOrder2 DESC , dateOrder DESC LIMIT 10";
		  }
		  
		  try
		  {
			  Statement stmt = conn.createStatement();
			  ResultSet rs = stmt.executeQuery(query);
			  
			  while(rs.next())
			  {
				  YearlyDistrubutionVO ytd = new YearlyDistrubutionVO();
				  ytd.setDateOrder(rs.getDate(1));
				  ytd.setDateOrder2(rs.getDate(2));
				  ytd.setBribedCount(rs.getInt(3));
				  ytd.setBribedAverage(rs.getInt(4));
				  ytd.setBribedTotal(rs.getInt(5));
				  ytd.setDateName(rs.getDate(6));
				  
				  distrubution.add(ytd);
				  
			  }
			  
		  }catch(Exception e)
		  {
			  e.printStackTrace();
		  }
		  
		  return distrubution;
	  }
}
