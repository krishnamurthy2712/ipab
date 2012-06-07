package com.ipablive.core;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.ipablive.bdservice.City;
import com.ipablive.datasource.ConnectionFactory;
import com.ipablive.vo.PaidBribesVO;

public class IPaidBribe 
{
	 Connection conn=null;
		
	 /* Here is the instance of the Singleton */
	  private static IPaidBribe _bribeInstance;

	  //Prevent direct access to the constructor
	  private IPaidBribe() 
	  {
	    super();
	    if(conn == null)
	    {
	    	conn = ConnectionFactory.getConnection();
	    }
	  }
	  
	  public static IPaidBribe getInstance() 
	  {

	    if (_bribeInstance == null) 
	    {

	      synchronized(IPaidBribe.class) 
	      {

	        if (_bribeInstance == null) 
	        {
	        	_bribeInstance = new IPaidBribe();
	        }

	      }

	    }
	    
	    return _bribeInstance;
	  }
	  
	  public ArrayList<PaidBribesVO> viewPaidBribes(String criteria)
	  {
		  ArrayList<PaidBribesVO> paidBribes = new ArrayList<PaidBribesVO>();
		  String searchCriteria="";
		  if(criteria.equals("All"))
		  {
			  searchCriteria = "";
		  }
		  
		  String query = "SELECT bc.*, ct.city_name AS c_city, bd.dept_name, bt.trans_name FROM bd_paid_bribe bc, bd_dept bd, bd_transactions bt, bd_city ct WHERE bc.c_dept=bd.id AND bc.c_transaction=bt.id and bc.c_city=ct.Id"+ searchCriteria +"order by bc.id desc";
		  
		  try
		  {
			  Statement stmt = conn.createStatement();
			  ResultSet rs = stmt.executeQuery(query);
			  while(rs.next())
			  {
				  PaidBribesVO pbv = new PaidBribesVO();
				  pbv.setId(rs.getInt(1));
				  //2
				  pbv.setCDept(rs.getString(3));
				  //4
				  pbv.setOthersTransaction(rs.getString(5));
				  pbv.setCAmountPaid(rs.getInt(6));
				  pbv.setCPaidDate(rs.getDate(7));
				  pbv.setCBribeType(rs.getString(8));
				  pbv.setCValTran(rs.getString(9));
				  pbv.setCAdditionalInfo(rs.getString(10));
				  //11
				  pbv.setOtherDept(rs.getString(12));
				  //13
				  pbv.setOtherLocation(rs.getString(14));
				  //15,16,17
				  pbv.setCount(rs.getInt(18));
				  pbv.setCCity(rs.getString(19));
				  pbv.setDeptName(rs.getString(20));
				  pbv.setTransName(rs.getString(21));
				  
				  paidBribes.add(pbv);
			  }
		  }catch(Exception e)
		  {
			  e.printStackTrace();
		  }
		  
		  return paidBribes;
	  }
}
