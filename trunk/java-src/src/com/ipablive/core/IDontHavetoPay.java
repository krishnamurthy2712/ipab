/**
 * 
 */
package com.ipablive.core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.ipablive.datasource.ConnectionFactory;
import com.ipablive.vo.DidNotPaidBribesVO;
import com.ipablive.vo.DidnotHaveToPayComplaintVO;
import com.ipablive.vo.DontHavetoPayVO;
import com.ipablive.vo.ReportsCountVO;

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
	  
	  public Boolean storeDintHaveToPayBribeComplaint(DidnotHaveToPayComplaintVO data)
	  {
		  Boolean isStored = false;
		  try
		  {
			  String query = "";
			  PreparedStatement pstmt;
			  
			  query = "insert into bd_dint_have_to_bribe (c_name,c_city,c_dept,others_dept,c_bribe_type,c_transaction," +
		  		"others_transaction,c_bribe_resisted_by,c_addi_info,IP) values (?,?,?,?,?,?,?,?,?,?)";
			  pstmt = conn.prepareStatement(query);
			  pstmt.setString(1, data.getCName());
			  pstmt.setString(2, data.getCCity());
			  pstmt.setString(3, data.getCDept());
			  pstmt.setString(4, data.getOtherDept());
			  pstmt.setString(5, data.getCBribeType());
			  pstmt.setString(6, data.getCTransaction());
			  pstmt.setString(7, data.getOtherTransaction());
			  pstmt.setString(8, data.getCBribeResistedBy());
			  pstmt.setString(9, data.getCAddiInfo());
			  pstmt.setString(10, data.getIpAddress());
			  
			  int i = pstmt.executeUpdate();
			  if(i>0)
			  {
				  isStored = true;
			  }
			  
		  }
		  catch(Exception e)
		  {
			  e.printStackTrace();
		  }
		  return isStored;
	  }
	  
	  public DontHavetoPayVO viewDetailPaidBribes(int id)
	  {
		  String query = "SELECT bc.*,ct.city_name AS c_city,  bd.dept_name, bt.trans_name FROM bd_dint_bribe bc, bd_dept bd, bd_transactions bt, bd_city ct WHERE bc.c_dept=bd.id AND bc.c_transaction=bt.id and bc.id='"+id+"' AND bc.c_city=ct.Id";
	
		  DontHavetoPayVO dhpbv = new DontHavetoPayVO();
		  
		  try
		  {
			  Statement stmt = conn.createStatement();
			  ResultSet rs = stmt.executeQuery(query);
			  while(rs.next())
			  {
				  dhpbv.setId(rs.getInt(1));
				  dhpbv.setCName(rs.getString(2));
				  dhpbv.setCCity(rs.getString(3));
				  dhpbv.setCDept(rs.getString(4));
				  dhpbv.setCTransaction(rs.getString(5));
				  dhpbv.setCBribeType(rs.getString(6));
				  dhpbv.setCBribeResistedBy(rs.getString(7));
				  dhpbv.setCAdditionalInfo(rs.getString(8));
				  dhpbv.setOthersTransaction(rs.getString(13));
				  dhpbv.setOtherDept(rs.getString(14));
				  dhpbv.setCount(rs.getInt(15));
				  dhpbv.setCCity(rs.getString(16));
				  dhpbv.setDeptName(rs.getString(17));
				  dhpbv.setTransName(rs.getString(18));
			  }
		  }catch(Exception e)
		  {
			  e.printStackTrace();
		  }
		  
		  
		  return dhpbv;
	  }
	  
	  public ReportsCountVO getReportsCount()
	  {
		  ReportsCountVO count = new ReportsCountVO();
		  
		  String query = "SELECT  count(1) as BribeReportsCount, COUNT(DISTINCT bd.c_city) AS total_city FROM bd_dint_have_to_bribe bd WHERE bd.approved = 1";
		  try
		  {
			  Statement stmt = conn.createStatement();
			  ResultSet rs = stmt.executeQuery(query);
			  while(rs.next())
			  {
				  count.setBribeReportsCount(rs.getInt(1));
				  count.setTotalCity(rs.getInt(2));
				  //count.setTotalAmount(rs.getInt(3));
			  }
		  }catch(Exception e)
		  {
			  e.printStackTrace();
		  }
		  
		  return count;
	  }
	  
}
