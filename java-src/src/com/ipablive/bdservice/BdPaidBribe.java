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
public class BdPaidBribe 
{
	Connection conn=null;
	
	 /* Here is the instance of the Singleton */
	  private static BdPaidBribe _paidBribeInstance;

	  //Prevent direct access to the constructor
	  public BdPaidBribe() 
	  {
	    super();
	    if(conn == null)
	    {
	    	conn = ConnectionFactory.getConnection();
	    }
	  }


	  /*public static BdPaidBribe getInstance() 
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
	  }*/
	  
	  public ArrayList<BribeVO> getAllBdPaidBribe() 
	  {
		  ArrayList<BribeVO> bribes = new ArrayList<BribeVO>();
		  
		  String query = "SELECT * FROM bd_paid_bribe";
		  
		  try
		  {
			  Statement stmt = conn.createStatement();
			  ResultSet rs = stmt.executeQuery(query);
			  
			  while(rs.next())
			  {
				  BribeVO b = new BribeVO();
				  b.setId(rs.getInt(1));
				  b.setcName(rs.getString(2));
				  b.setcCity(rs.getInt(3));
				  b.setcDept(rs.getInt(4));
				  b.setcTransaction(rs.getInt(5));
				  b.setOthersTransaction(rs.getString(6));
				  b.setcAmtPaid(rs.getInt(7));
				  b.setcDatePaid(rs.getDate(8));
				  b.setcBribeType(rs.getString(9));
				  b.setcValTran(rs.getInt(10));
				  b.setcAddiInfo(rs.getString(11));
				  b.setApproved(rs.getInt(12));
				  b.setOthersDept(rs.getString(13));
				  b.setCreated(rs.getDate(14));
				  b.setOtherLocation(rs.getString(15));
				  b.setIP(rs.getString(16));
				  b.setFiltered(rs.getString(17));
				  b.setFilteredKeys(rs.getString(18));
				  b.setCount(rs.getInt(19));
				  
				  bribes.add(b);
			  }
		  }catch(Exception e)
		  {
			  e.printStackTrace();
		  }
		  
		  return bribes;
	  }
	  
	  public BribeVO getBdPaidBribeByID(int id) 
	  {
		  BribeVO b = new BribeVO();
		  
		  String query = "SELECT * FROM bd_paid_bribe where id="+id;
		  
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
				  b.setcAmtPaid(rs.getInt(7));
				  b.setcDatePaid(rs.getDate(8));
				  b.setcBribeType(rs.getString(9));
				  b.setcValTran(rs.getInt(10));
				  b.setcAddiInfo(rs.getString(11));
				  b.setApproved(rs.getInt(12));
				  b.setOthersDept(rs.getString(13));
				  b.setCreated(rs.getDate(14));
				  b.setOtherLocation(rs.getString(15));
				  b.setIP(rs.getString(16));
				  b.setFiltered(rs.getString(17));
				  b.setFilteredKeys(rs.getString(18));
				  b.setCount(rs.getInt(19));
				  
			  }
		  }catch(Exception e)
		  {
			  e.printStackTrace();
		  }
		  
		  return b;
	  }
	  
	  public BribeVO getBdPaidBribePaged(int startIndex, int numItemsNeeded)
	  {
		  BribeVO b = new BribeVO();
		  String limit = startIndex+","+numItemsNeeded;
		  String query = "SELECT * FROM bd_paid_bribe LIMIT "+limit;
		  
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
				  b.setcAmtPaid(rs.getInt(7));
				  b.setcDatePaid(rs.getDate(8));
				  b.setcBribeType(rs.getString(9));
				  b.setcValTran(rs.getInt(10));
				  b.setcAddiInfo(rs.getString(11));
				  b.setApproved(rs.getInt(12));
				  b.setOthersDept(rs.getString(13));
				  b.setCreated(rs.getDate(14));
				  b.setOtherLocation(rs.getString(15));
				  b.setIP(rs.getString(16));
				  b.setFiltered(rs.getString(17));
				  b.setFilteredKeys(rs.getString(18));
				  b.setCount(rs.getInt(19));
				  
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
		  
		  String query = "SELECT COUNT(*) AS COUNT FROM bd_paid_bribe";
		  
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
	  
	  public int getTotalPaid()
	  {
		  int count = 0;
		  
		  String query = "SELECT SUM(c_amt_paid) AS TOTAL FROM bd_paid_bribe where approved = 1";
		  
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
			  		"FROM bd_paid_bribe WHERE c_city ="+cCity+" AND c_date_paid " +
			  		"IS NOT NULL AND approved =1 GROUP BY dateOrder, dateOrder2 " +
			  		"ORDER BY dateOrder2 DESC , dateOrder DESC LIMIT 10";
		  }
		  else
		  {
			  query = "SELECT DISTINCT EXTRACT( WEEK FROM c_date_paid ) AS dateOrder," +
			  		" EXTRACT( YEAR FROM c_date_paid ) AS dateOrder2," +
			  		" COUNT( id ) AS BribedCount, AVG( c_amt_paid ) AS BribedAverage, " +
			  		"SUM( c_amt_paid ) AS BribedTotal, DATE_FORMAT( c_date_paid,  '%e %b, %y' ) AS dateName " +
			  		"FROM bd_paid_bribe WHERE c_dept = "+cDept+" AND c_date_paid " +
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
	  
	  public ArrayList<BribeCityVO> getCityDetails(int cityId)
	  {
		  ArrayList<BribeCityVO> cities = new ArrayList<BribeCityVO>();
		  String query = "SELECT Sum(c_amt_paid) as TotalPaid, c_date_paid, " +
		  		"count(*) as TotalBribes, COUNT( DISTINCT c_dept ) as DeptCount, " +
		  		"(select count(*) from bd_dint_bribe where c_city = "+cityId+" AND approved = 1) as TotalNoBribes, " +
		  		"(select count(*) from bd_dint_have_to_bribe where c_city = "+cityId+" and approved = 1) as TotalNotBribed " +
		  		"FROM bd_paid_bribe WHERE c_city = "+cityId+" and approved = 1 " +
		  		"group by TotalNoBribes order by c_date_paid asc";
		  
		  try
		  {
			  Statement stmt = conn.createStatement();
			  ResultSet rs = stmt.executeQuery(query);
			  
			  while(rs.next())
			  {
				  BribeCityVO v = new BribeCityVO();
				  v.setTotalPaid(rs.getInt(1));
				  v.setcDatePaid(rs.getDate(2));
				  v.setTotalBribes(rs.getInt(3));
				  v.setDeptCount(rs.getInt(4));
				  v.setTotalNoBribes(rs.getInt(5));
				  v.setTotalNotBribed(rs.getInt(6));
				  
				  cities.add(v);
				  
			  }
		  }catch(Exception e)
		  {
			  e.printStackTrace();
		  }
		  
		  return cities;
	  }
}
