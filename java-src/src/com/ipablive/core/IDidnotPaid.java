/**
 * 
 */
package com.ipablive.core;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.ipablive.datasource.ConnectionFactory;
import com.ipablive.vo.DidNotPaidBribesVO;
import com.ipablive.vo.PaidBribesVO;

/**
 * @author 
 *
 */
public class IDidnotPaid 
{
	Connection conn=null;
	
	 /* Here is the instance of the Singleton */
	  private static IDidnotPaid _didntBribeInstance;

	  //Prevent direct access to the constructor
	  private IDidnotPaid() 
	  {
	    super();
	    if(conn == null)
	    {
	    	conn = ConnectionFactory.getConnection();
	    }
	  }
	  
	  public static IDidnotPaid getInstance() 
	  {

	    if (_didntBribeInstance == null) 
	    {

	      synchronized(IDidnotPaid.class) 
	      {

	        if (_didntBribeInstance == null) 
	        {
	        	_didntBribeInstance = new IDidnotPaid();
	        }

	      }

	    }
	    
	    return _didntBribeInstance;
	  }
	  
	  public ArrayList<DidNotPaidBribesVO> viewDintPay(String criteria)
	  {
		  ArrayList<DidNotPaidBribesVO> didnotPayBribes = new ArrayList<DidNotPaidBribesVO>();
		  String searchCriteria="";
		  if(criteria.equals("All"))
		  {
			  searchCriteria = "";
		  }
		  
		  String query = "SELECT bc.*, ct.city_name AS c_city, bd.dept_name, bt.trans_name FROM bd_dint_bribe bc, bd_dept bd, bd_transactions bt, bd_city ct WHERE bc.c_dept=bd.id AND bc.c_transaction=bt.id "+ searchCriteria+ "and bc.approved=1 and bc.c_city=ct.Id order by bc.id desc";
		  
		  try
		  {
			  Statement stmt = conn.createStatement();
			  ResultSet rs = stmt.executeQuery(query);
			  while(rs.next())
			  {
				  DidNotPaidBribesVO dpbv = new DidNotPaidBribesVO();
				  dpbv.setId(rs.getInt(1));
				  dpbv.setCName(rs.getString(2));
				  dpbv.setCCity(rs.getString(3));
				  dpbv.setCDept(rs.getString(4));
				  dpbv.setCTransaction(rs.getString(5));
				  dpbv.setOthersTransaction(rs.getString(6));
				  dpbv.setCBribeResistedBy(rs.getString(7));
				  dpbv.setCAdditionalInfo(rs.getString(8));
				  //9
				  dpbv.setOtherDept(rs.getString(10));
				  //11,12,13
				  dpbv.setCount(rs.getInt(14));
				  dpbv.setCCity(rs.getString(15));
				  dpbv.setDeptName(rs.getString(16));
				  dpbv.setTransName(rs.getString(17));
				  
				  didnotPayBribes.add(dpbv);
			  }
		  }catch(Exception e)
		  {
			  
		  }
		  return didnotPayBribes;
	  }
	  
}
