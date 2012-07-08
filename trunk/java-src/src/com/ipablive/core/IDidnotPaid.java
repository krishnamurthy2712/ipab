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
import com.ipablive.vo.CommentVO;
import com.ipablive.vo.DidNotPaidBribesVO;
import com.ipablive.vo.IDidnotPaidComplaintVO;
import com.ipablive.vo.PaidBribesVO;
import com.ipablive.vo.ReportsCountVO;

/**
 * @author 
 *
 */
public class IDidnotPaid 
{
	Connection conn=null;
	private static final String TYPE = "notpaid";
	
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
				  dpbv.setCreatedDate(rs.getDate(9));
				  dpbv.setOtherDept(rs.getString(10));
				  //11,12,13
				  dpbv.setCount(rs.getInt(14));
				  dpbv.setCCity(rs.getString(15));
				  dpbv.setDeptName(rs.getString(16));
				  dpbv.setTransName(rs.getString(17));
				  int numComments = getNumComments(rs.getInt(1));
				  dpbv.setNumComments(numComments);
				  
				  didnotPayBribes.add(dpbv);
			  }
		  }catch(Exception e)
		  {
			  
		  }
		  return didnotPayBribes;
	  }
	  
	  public Boolean storeDidNotPaidComplaint(IDidnotPaidComplaintVO data)
	  {
		Boolean isStored = false;
		try
		  {
			  String query = "";
			  PreparedStatement pstmt;
			  
			  query = "insert into bd_dint_bribe (c_name,c_city,c_dept,others_dept,c_transaction," +
		  		"others_transaction,c_bribe_resisted_by,c_addi_info,IP) values (?,?,?,?,?,?,?,?,?)";
			  pstmt = conn.prepareStatement(query);
			  pstmt.setString(1, data.getCName());
			  pstmt.setString(2, data.getCCity());
			  pstmt.setString(3, data.getCDept());
			  pstmt.setString(4, data.getOtherDept());
			  pstmt.setString(5, data.getCTransaction());
			  pstmt.setString(6, data.getOtherTransaction());
			  pstmt.setString(7, data.getCBribeResistedBy());
			  pstmt.setString(8, data.getCAddiInfo());
			  pstmt.setString(9, data.getIpAddress());
			  
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
	  
	  public DidNotPaidBribesVO viewDetailPaidBribes(int id)
	  {
		  String query = "SELECT bc.*,ct.city_name AS c_city,  bd.dept_name, bt.trans_name FROM bd_dint_bribe bc, bd_dept bd, bd_transactions bt, bd_city ct WHERE bc.c_dept=bd.id AND bc.c_transaction=bt.id and bc.id='"+id+"' AND bc.c_city=ct.Id";
	
		  DidNotPaidBribesVO pbVo = new DidNotPaidBribesVO();
		  
		  try
		  {
			  Statement stmt = conn.createStatement();
			  ResultSet rs = stmt.executeQuery(query);
			  if(rs.next())
			  {
				  pbVo.setId(rs.getInt(1));
				  pbVo.setCName(rs.getString(2));
				  //pbVo.setCCity(rs.getString(3));
				  pbVo.setCDept(rs.getString(4));
				  //5
				  pbVo.setOthersTransaction(rs.getString(6));
				  pbVo.setCBribeResistedBy(rs.getString(7));
				  pbVo.setCAdditionalInfo(rs.getString(8));
				  pbVo.setCreatedDate(rs.getDate(9));
				  pbVo.setOtherDept(rs.getString(10));
				  //11,12.13
				  pbVo.setOtherLocation(rs.getString(14));
				  pbVo.setCount(rs.getInt(14));
				  pbVo.setCCity(rs.getString(15));
				  pbVo.setDeptName(rs.getString(16));
				  pbVo.setTransName(rs.getString(17));
				  int numComments = getNumComments(rs.getInt(1));
				  pbVo.setNumComments(numComments);
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
		  
		  String query = "SELECT  count(1) as BribeReportsCount, COUNT(DISTINCT bd.c_city) AS total_city FROM bd_dint_bribe bd WHERE bd.approved = 1;";
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
	  
	  public int getNumComments( int id)
	  {
		  int count = 0;
		  
		  try
		  {
			  Statement stmt = conn.createStatement();
			  ResultSet rs = stmt.executeQuery("SELECT count(1) as cnt from bd_vote_comments where type='"+TYPE+"' and type_id='"+id+"' and published=1");
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
	  
	  public ArrayList<CommentVO> viewVoteComments(int id)
	  {
		  ArrayList<CommentVO> comments = new ArrayList<CommentVO>();
		 
		  try
		  {
			  Statement stmt = conn.createStatement();
			  ResultSet rs = stmt.executeQuery("SELECT * from bd_vote_comments where type='"+TYPE+"' and type_id='"+id+"' and published=1");
			  while(rs.next())
			  {
				  CommentVO comment = new CommentVO();
				  comment.setId(rs.getInt(1));
				  comment.setSubject(rs.getString(3));
				  comment.setComment(rs.getString(4));
				 
				  comments.add(comment);
			  }
		  }catch(Exception e)
		  {
			  e.printStackTrace();
		  }
		  
		  return comments;
	  }
}
