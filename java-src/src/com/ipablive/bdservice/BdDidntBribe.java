/**
 * 
 */
package com.ipablive.bdservice;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.ipablive.datasource.ConnectionFactory;
import com.ipablive.vo.BribeCityVO;
import com.ipablive.vo.BribeVO;
import com.ipablive.vo.DidntBribeVO;
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
public class BdDidntBribe 
{
	Connection conn=null;
	
	 /* Here is the instance of the Singleton */
	  private static BdDidntBribe _didntPaidBribeInstance;

	  //Prevent direct access to the constructor
	  public BdDidntBribe() 
	  {
	    super();
	    if(conn == null)
	    {
	    	conn = ConnectionFactory.getConnection();
	    }
	  }


	 /* public static BdDidntBribe getInstance() 
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
	  }*/
	  
	  public ArrayList<DidntBribeVO> getAllBdDintBribe() 
	  {
		  ArrayList<DidntBribeVO> bribes = new ArrayList<DidntBribeVO>();
		  
		  String query = "SELECT * FROM bd_dint_bribe";
		  
		  try
		  {
			  Statement stmt = conn.createStatement();
			  ResultSet rs = stmt.executeQuery(query);
			  
			  while(rs.next())
			  {
				  DidntBribeVO b = new DidntBribeVO();
				  b.setId(rs.getInt(1));
				  b.setcName(rs.getString(2));
				  b.setcCity(rs.getInt(3));
				  b.setcDept(rs.getInt(4));
				  b.setcTransaction(rs.getInt(5));
				  b.setOthersTransaction(rs.getString(6));
				  b.setcBribeType(rs.getString(7));
				  b.setcAddiInfo(rs.getString(8));
				  b.setCreated(rs.getDate(9));
				  b.setOthersDept(rs.getString(10));
				  b.setApproved(rs.getInt(11));
				  b.setIP(rs.getString(12));
				  b.setFiltered(rs.getString(13));
				  b.setCount(rs.getInt(14));
				  
				  bribes.add(b);
			  }
		  }catch(Exception e)
		  {
			  e.printStackTrace();
		  }
		  
		  return bribes;
	  }
	  
	  public DidntBribeVO getBDintBribeByID(int id) 
	  {
		  DidntBribeVO b = new DidntBribeVO();
		  
		  String query = "SELECT * FROM bd_dint_bribe where id="+id;
		  
		  try
		  {
			  Statement stmt = conn.createStatement();
			  ResultSet rs = stmt.executeQuery(query);
			  
			  if(rs.next())
			  {
				  b.setId(rs.getInt(1));
				  b.setcName(rs.getString(2));
				  b.setcCity(rs.getInt(3));
				  b.setcDept(rs.getInt(4));
				  b.setcTransaction(rs.getInt(5));
				  b.setOthersTransaction(rs.getString(6));
				  b.setcBribeType(rs.getString(7));
				  b.setcAddiInfo(rs.getString(8));
				  b.setCreated(rs.getDate(9));
				  b.setOthersDept(rs.getString(10));
				  b.setApproved(rs.getInt(11));
				  b.setIP(rs.getString(12));
				  b.setFiltered(rs.getString(13));
				  b.setCount(rs.getInt(14));
				  
			  }
		  }catch(Exception e)
		  {
			  e.printStackTrace();
		  }
		  
		  return b;
	  }
	  
	  public DidntBribeVO getBdDintBribePaged(int startIndex, int numItemsNeeded)
	  {
		  DidntBribeVO b = new DidntBribeVO();
		  String limit = startIndex+","+numItemsNeeded;
		  String query = "SELECT * FROM bd_dint_bribe LIMIT "+limit;
		  
		  try
		  {
			  Statement stmt = conn.createStatement();
			  ResultSet rs = stmt.executeQuery(query);
			  
			  if(rs.next())
			  {
				  b.setId(rs.getInt(1));
				  b.setcName(rs.getString(2));
				  b.setcCity(rs.getInt(3));
				  b.setcDept(rs.getInt(4));
				  b.setcTransaction(rs.getInt(5));
				  b.setOthersTransaction(rs.getString(6));
				  b.setcBribeType(rs.getString(7));
				  b.setcAddiInfo(rs.getString(8));
				  b.setCreated(rs.getDate(9));
				  b.setOthersDept(rs.getString(10));
				  b.setApproved(rs.getInt(11));
				  b.setIP(rs.getString(12));
				  b.setFiltered(rs.getString(13));
				  b.setCount(rs.getInt(14));
				  
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
		  
		  String query = "SELECT COUNT(*) AS COUNT FROM bd_dint_bribe";
		  
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
			  		"FROM bd_dint_bribe WHERE c_city ="+cCity+" AND c_date_paid " +
			  		"IS NOT NULL AND approved =1 GROUP BY dateOrder, dateOrder2 " +
			  		"ORDER BY dateOrder2 DESC , dateOrder DESC LIMIT 10";
		  }
		  else
		  {
			  query = "SELECT DISTINCT EXTRACT( WEEK FROM c_date_paid ) AS dateOrder," +
			  		" EXTRACT( YEAR FROM c_date_paid ) AS dateOrder2," +
			  		" COUNT( id ) AS BribedCount, AVG( c_amt_paid ) AS BribedAverage, " +
			  		"SUM( c_amt_paid ) AS BribedTotal, DATE_FORMAT( c_date_paid,  '%e %b, %y' ) AS dateName " +
			  		"FROM bd_dint_bribe WHERE c_dept = "+cDept+" AND c_date_paid " +
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
