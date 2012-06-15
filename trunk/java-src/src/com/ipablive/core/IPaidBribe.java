package com.ipablive.core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.ipablive.bdservice.City;
import com.ipablive.datasource.ConnectionFactory;
import com.ipablive.vo.IPaidComplaintVO;
import com.ipablive.vo.PaidBribesVO;
import com.ipablive.vo.ReportsCountVO;

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
		  if(criteria.equalsIgnoreCase("All"))
		  {
			  searchCriteria = "";
		  }
		  
		  String query = "SELECT bc.*, ct.city_name AS c_city, bd.dept_name, bt.trans_name FROM bd_paid_bribe bc, bd_dept bd, bd_transactions bt, bd_city ct WHERE bc.c_dept=bd.id AND bc.c_transaction=bt.id and bc.c_city=ct.Id "+ searchCriteria +" order by bc.id desc";
		  
		  try
		  {
			  Statement stmt = conn.createStatement();
			  ResultSet rs = stmt.executeQuery(query);
			  while(rs.next())
			  {
				  PaidBribesVO pbv = new PaidBribesVO();
				  pbv.setId(rs.getInt(1));
				  pbv.setCName(rs.getString(2));
				  //3
				  pbv.setCDept(rs.getString(4));
				  //4
				  //5
				  pbv.setOthersTransaction(rs.getString(6));
				  pbv.setCAmountPaid(rs.getInt(7));
				  pbv.setCPaidDate(rs.getDate(8));
				  pbv.setCBribeType(rs.getString(9));
				  //pbv.setCValTran(rs.getString(10));
				  pbv.setCAdditionalInfo(rs.getString(11));
				  //12
				  pbv.setOtherDept(rs.getString(13));
				  //14
				  pbv.setOtherLocation(rs.getString(15));
				  //16,17,18
				  pbv.setCount(rs.getInt(19));
				  pbv.setCCity(rs.getString(20));
				  pbv.setDeptName(rs.getString(21));
				  pbv.setTransName(rs.getString(22));
				  
				  paidBribes.add(pbv);
			  }
		  }catch(Exception e)
		  {
			  e.printStackTrace();
		  }
		  
		  return paidBribes;
	  }
	  
	  public Boolean storePaidBribeComplaint(IPaidComplaintVO data)
	  {
		  Boolean isStored = false;
		  try
		  {
			  String query = "";
			  PreparedStatement pstmt;
			  java.sql.Date sqlDate = new java.sql.Date(data.getCDatePaid().getTime());
			  
			  if(data.getCAmtPaid()>1000000)
			  {
				  query = "insert into bd_paid_bribe (c_name,c_city,c_dept,others_dept,c_transaction," +
			  		"others_transaction,c_amt_paid,c_date_paid,c_bribe_type," +
			  		"c_addi_info,other_location,IP,filtered) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
				  pstmt = conn.prepareStatement(query);
				  pstmt.setString(1, data.getCName());
				  pstmt.setString(2, data.getCCity());
				  pstmt.setString(3, data.getCDept());
				  pstmt.setString(4, data.getOtherDept());
				  pstmt.setString(5, data.getCTransaction());
				  pstmt.setString(6, data.getOtherTransaction());
				  pstmt.setInt(7, data.getCAmtPaid());
				  pstmt.setDate(8, sqlDate); //set it later
				  pstmt.setString(9, data.getCBribeType());
				  pstmt.setString(10, data.getCAddiInfo());
				  pstmt.setString(11, data.getOfficeLocation());
				  pstmt.setString(12, data.getIpAddress());
				  pstmt.setInt(13, 1);
				  
			  }else
			  {
				  query = "insert into bd_paid_bribe (c_name,c_city,c_dept,others_dept,c_transaction," +
				  		"others_transaction,c_amt_paid,c_date_paid,c_bribe_type,c_addi_info," +
				  		"other_location,IP,filtered,approved) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				  pstmt = conn.prepareStatement(query);
				  pstmt.setString(1, data.getCName());
				  pstmt.setString(2, data.getCCity());
				  pstmt.setString(3, data.getCDept());
				  pstmt.setString(4, data.getOtherDept());
				  pstmt.setString(5, data.getCTransaction());
				  pstmt.setString(6, data.getOtherTransaction());
				  pstmt.setInt(7, data.getCAmtPaid());
				  pstmt.setDate(8, sqlDate); //set it later
				  pstmt.setString(9, data.getCBribeType());
				  pstmt.setString(10, data.getCAddiInfo());
				  pstmt.setString(11, data.getOfficeLocation());
				  pstmt.setString(12, data.getIpAddress());
				  pstmt.setInt(13, 1);
				  pstmt.setInt(14, 1);
				  
			  }
			  
			  int i = pstmt.executeUpdate();
			  if(i>0)
			  {
				  isStored = true;
				  backUpStore(pstmt,data);
			  }
			  
		  }
		  catch(Exception e)
		  {
			  e.printStackTrace();
			  isStored = false;
		  }
		  return isStored;
	  }
	  
	  private void backUpStore(PreparedStatement pstmt,IPaidComplaintVO data )
	  {
		  String query = "insert into bd_paid_bribe_bkp (c_name,c_city,c_dept,others_dept,c_transaction," +
	  		"others_transaction,c_amt_paid,c_date_paid,c_bribe_type,c_addi_info," +
	  		"other_location,IP,filtered,approved) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		  try
		  {
			  pstmt = conn.prepareStatement(query);
			  pstmt.setString(1, data.getCName());
			  pstmt.setString(2, data.getCCity());
			  pstmt.setString(3, data.getCDept());
			  pstmt.setString(4, data.getOtherDept());
			  pstmt.setString(5, data.getCTransaction());
			  pstmt.setString(6, data.getOtherTransaction());
			  pstmt.setInt(7, data.getCAmtPaid());
			  pstmt.setDate(8, null); //set it later
			  pstmt.setString(9, data.getCBribeType());
			  pstmt.setString(10, data.getCAddiInfo());
			  pstmt.setString(11, data.getOfficeLocation());
			  pstmt.setString(12, data.getIpAddress());
			  pstmt.setInt(13, 1);
			  pstmt.setInt(14, 1);
		  }
		  catch (Exception e) 
		  {
			  e.printStackTrace();
			  System.out.println("There is an error storing data in :: bd_paid_bribe_bkp table ");
		  }
	  }
	  
	  public PaidBribesVO viewDetailPaidBribes(int id)
	  {
		  String query = "SELECT bc.*, ct.city_name AS c_city, bd.dept_name, bt.trans_name FROM bd_paid_bribe bc, bd_dept bd, bd_transactions bt, bd_city ct WHERE bc.c_dept=bd.id AND bc.c_transaction=bt.id and bc.id='"+id+"' AND bc.c_city=ct.Id";
		  PaidBribesVO pbVo = new PaidBribesVO();
		  
		  try
		  {
			  Statement stmt = conn.createStatement();
			  ResultSet rs = stmt.executeQuery(query);
			  while(rs.next())
			  {
				  pbVo.setId(rs.getInt(1));
				  //2
				  pbVo.setCDept(rs.getString(3));
				  //4
				  pbVo.setOthersTransaction(rs.getString(5));
				  pbVo.setCAmountPaid(rs.getInt(6));
				  pbVo.setCPaidDate(rs.getDate(7));
				  pbVo.setCBribeType(rs.getString(8));
				  pbVo.setCValTran(rs.getString(9));
				  pbVo.setCAdditionalInfo(rs.getString(10));
				  //11
				  pbVo.setOtherDept(rs.getString(12));
				  //13
				  pbVo.setOtherLocation(rs.getString(14));
				  //15,16,17
				  pbVo.setCount(rs.getInt(18));
				  pbVo.setCCity(rs.getString(19));
				  pbVo.setDeptName(rs.getString(20));
				  pbVo.setTransName(rs.getString(21));
			  }
		  }catch(Exception e)
		  {
			  e.printStackTrace();
		  }
		  
		  
		  return pbVo;
	  }
	  
	  public ReportsCountVO getReportsCount()
	  {
		  ReportsCountVO count = new ReportsCountVO();
		  
		  String query = "SELECT  count(1) as BribeReportsCount, COUNT(DISTINCT bd.c_city) AS total_city, SUM(bd.c_amt_paid) AS total_amount FROM bd_paid_bribe bd WHERE bd.approved = 1";
		  try
		  {
			  Statement stmt = conn.createStatement();
			  ResultSet rs = stmt.executeQuery(query);
			  while(rs.next())
			  {
				  count.setBribeReportsCount(rs.getInt(1));
				  count.setTotalCity(rs.getInt(2));
				  count.setTotalAmount(rs.getInt(3));
			  }
		  }catch(Exception e)
		  {
			  e.printStackTrace();
		  }
		  
		  return count;
	  }
}
