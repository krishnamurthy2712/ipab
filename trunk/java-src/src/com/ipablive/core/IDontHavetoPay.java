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
import com.ipablive.vo.DontHavetoPayVO;

/**
 * @author 
 *
 */
public class IDontHavetoPay 
{
	Connection conn=null;
	
	 /* Here is the instance of the Singleton */
	  private static IDontHavetoPay _dontHavetoInstance;

	  //Prevent direct access to the constructor
	  private IDontHavetoPay() 
	  {
	    super();
	    if(conn == null)
	    {
	    	conn = ConnectionFactory.getConnection();
	    }
	  }
	  
	  public static IDontHavetoPay getInstance() 
	  {

	    if (_dontHavetoInstance == null) 
	    {

	      synchronized(IDontHavetoPay.class) 
	      {

	        if (_dontHavetoInstance == null) 
	        {
	        	_dontHavetoInstance = new IDontHavetoPay();
	        }

	      }

	    }
	    
	    return _dontHavetoInstance;
	  }
	  
	  public ArrayList<DontHavetoPayVO> viewDintHaveToPay(String criteria)
	  {
		  ArrayList<DontHavetoPayVO> dontHavetoPayBribes = new ArrayList<DontHavetoPayVO>();
		  String searchCriteria="";
		  if(criteria.equals("All"))
		  {
			  searchCriteria = "";
		  }
		  
		  String query = "SELECT bc.*, ct.city_name AS c_city, bd.dept_name, bt.trans_name FROM bd_dint_have_to_bribe bc, bd_dept bd, bd_transactions bt,bd_city ct WHERE bc.c_dept=bd.id AND bc.c_transaction=bt.id "+searchCriteria+" and bc.approved=1 and bc.c_city=ct.Id order by bc.id desc";
		  
		  try
		  {
			  Statement stmt = conn.createStatement();
			  ResultSet rs = stmt.executeQuery(query);
			  while(rs.next())
			  {
				  DontHavetoPayVO dhpbv = new DontHavetoPayVO();
				  dhpbv.setId(rs.getInt(1));
				  dhpbv.setCName(rs.getString(2));
				  dhpbv.setCCity(rs.getString(3));
				  dhpbv.setCDept(rs.getString(4));
				  dhpbv.setCTransaction(rs.getString(5));
				  dhpbv.setCBribeType(rs.getString(6));
				  dhpbv.setCBribeResistedBy(rs.getString(7));
				  dhpbv.setCAdditionalInfo(rs.getString(8));
				  //9,10,11,12
				  dhpbv.setOthersTransaction(rs.getString(13));
				  dhpbv.setOtherDept(rs.getString(14));
				  dhpbv.setCount(rs.getInt(15));
				  dhpbv.setCCity(rs.getString(16));
				  dhpbv.setDeptName(rs.getString(17));
				  dhpbv.setTransName(rs.getString(18));
				  
				  dontHavetoPayBribes.add(dhpbv);
			  }
		  }catch(Exception e)
		  {
			  e.printStackTrace();
		  }
		  
		  return dontHavetoPayBribes;
	  }
}
