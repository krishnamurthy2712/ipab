package com.ipablive.core;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import com.ipablive.datasource.ConnectionFactory;
import com.ipablive.utils.BribeUtils;
import com.ipablive.vo.BribeAnalysisVO;
import com.ipablive.vo.BribeCategoriesVO;
import com.ipablive.vo.BribeFighterVO;
import com.ipablive.vo.BribeReportsVO;
import com.ipablive.vo.NewsVO;
import com.ipablive.vo.TopCitiesVO;

public class Home 
{
	Connection conn=null;
	
	 /* Here is the instance of the Singleton */
	  private static Home _homeInstance;

	  //Prevent direct access to the constructor
	  private Home() 
	  {
	    super();
	    if(conn == null)
	    {
	    	conn = ConnectionFactory.getConnection();
	    }
	  }
	  
	  public static Home getInstance() 
	  {

	    if (_homeInstance == null) 
	    {

	      synchronized(Home.class) 
	      {

	        if (_homeInstance == null) 
	        {
	        	_homeInstance = new Home();
	        }

	      }

	    }
	    
	    return _homeInstance;
	  }
	  
	  public ArrayList<BribeAnalysisVO> getBribeAnalysis()
	  {
		  ArrayList<BribeAnalysisVO> analysis = new ArrayList<BribeAnalysisVO>();
		  
		  try
		  {
			  Statement stmt = conn.createStatement();
			  ResultSet rs = stmt.executeQuery("SELECT  count(1) as BribeReportsCount, COUNT(DISTINCT bd.c_city)" +
			  		" AS total_city, SUM(bd.c_amt_paid) AS total_amount FROM bd_paid_bribe bd WHERE bd.approved = 1");
			  while(rs.next())
			  {
				  BribeAnalysisVO bav = new BribeAnalysisVO();
				  bav.setBribeReportsCount(rs.getInt(1));
				  bav.setTotalCity(rs.getInt(2));
				  bav.setTotalAmount(rs.getInt(3));
				  
				  analysis.add(bav);
			  }
		  }
		  catch(Exception e)
		  {
			  e.printStackTrace();
		  }
		  
		  return analysis;
	  }
	  
	  public ArrayList<TopCitiesVO> getTopCities()
	  {
		  ArrayList<TopCitiesVO> topFive = new ArrayList<TopCitiesVO>();
		  
		  try
		  {
			  Statement stmt = conn.createStatement();
			  ResultSet rs = stmt.executeQuery("SELECT SUM(bp.c_amt_paid) AS amount_paid, " +
			  		"c.city_name FROM bd_paid_bribe bp, bd_city c WHERE bp.c_city = c.Id AND " +
			  		"bp.approved = 1 GROUP BY c.city_name ORDER BY amount_paid DESC LIMIT 5");
			  while(rs.next())
			  {
				  TopCitiesVO tcv = new TopCitiesVO();
				  tcv.setAmountPaid(rs.getInt(1));
				  tcv.setCityName(rs.getString(2));
				  
				  topFive.add(tcv);
			  }
		  }
		  catch(Exception e)
		  {
			  e.printStackTrace();
		  }
		  
		  return topFive;
	  }
	  
	  public ArrayList<BribeReportsVO> getBribeReports()
	  {
		  ArrayList<BribeReportsVO> bribeReports = new ArrayList<BribeReportsVO>();
		  
		  try
		  {
			  Statement stmt = conn.createStatement();
			  Statement stmt1 = conn.createStatement();
			  ResultSet rs = stmt.executeQuery("SELECT bc.*,bc.count as tot_view, ct.city_name AS c_city, bd.dept_name, bt.trans_name " +
			  		"FROM bd_paid_bribe bc, bd_dept bd, bd_transactions bt, bd_city ct" +
			  		" WHERE bc.c_dept=bd.id AND bc.c_transaction=bt.id AND bc.approved=1 AND " +
			  		"bc.c_city=ct.Id ORDER BY bc.id DESC LIMIT 4");
			  
			  while(rs.next())
			  {
				  BribeReportsVO brv = new BribeReportsVO();
				  brv.setId(rs.getInt(1));
				  brv.setCName(rs.getString(2));
				  brv.setCAmountPaid(rs.getInt(7));
				  brv.setCAdditionalInfo(rs.getString(11));
				  brv.setTotalViews(rs.getInt(20));
				  brv.setCCity(rs.getString(21));
				  brv.setCDeptName(rs.getString(22));
				  brv.setCTransaction(rs.getString(23));
				  //store "created"
				  brv.setCreated(rs.getDate(14));
				  //store "friendlyTime" - friendlyTime = BribeUtils.getFriendlyTime(create);
				  Date timeDisp = (Date) rs.getDate(14);
				  brv.setFriendlyTime(BribeUtils.getFriendlyTime(timeDisp));
				  /*comments count*/
				  ResultSet rs2 = stmt1.executeQuery("SELECT COUNT(1) AS cnt FROM bd_vote_comments WHERE TYPE='paid' AND type_id="+rs.getInt(1)+" AND published=1");
				  if(rs2.next())
				  {
					  brv.setCommentsCount(rs2.getInt(1));
				  }
				  else
				  {
					  brv.setCommentsCount(0);
				  }
				  
				  bribeReports.add(brv);
			  }
		  }
		  catch(Exception e)
		  {
			  e.printStackTrace();
		  }
		  
		  return bribeReports;
	  }
	  
	  public ArrayList<BribeCategoriesVO> getTopBribeCategories()
	  {
		  ArrayList<BribeCategoriesVO> bribeCategories = new ArrayList<BribeCategoriesVO>();
		  
		  try
		  {
			  Statement stmt = conn.createStatement();
			  ResultSet rs = stmt.executeQuery("SELECT sum( bp.count ) AS totalviews, " +
			  		"bd.dept_name, bp.c_dept FROM bd_paid_bribe bp , bd_dept as bd " +
			  		"WHERE bd.id = bp.c_dept and bp.c_dept > 0 GROUP BY bp.c_dept ORDER BY " +
			  		"totalviews DESC LIMIT 5;");
			  
			  while(rs.next())
			  {
				  BribeCategoriesVO bcv = new BribeCategoriesVO();
				  bcv.setTotalviews(rs.getInt(1));
				  bcv.setDeptName(rs.getString(2));
				  bcv.setCDept(rs.getInt(3));
				  
				  bribeCategories.add(bcv);
			  }
		  }
		  catch(Exception e)
		  {
			  e.printStackTrace();
		  }
		  
		  return bribeCategories;
	  }
	  
	  public ArrayList<NewsVO> getNews()
	  {
		  ArrayList<NewsVO> news = new ArrayList<NewsVO>();
		  
		  try
		  {
			  Statement stmt = conn.createStatement();
			  ResultSet rs = stmt.executeQuery("SELECT n.nid, n.title,nv.body, " +
			  		"ua.dst FROM node n, node_revisions nv, url_alias ua WHERE n.type = 'on_air' " +
			  		"AND n.status = 1 AND n.nid=nv.nid and ua.src= concat('node/',n.nid) " +
			  		"ORDER BY n.sticky DESC, n.created DESC LIMIT 3");
			  
			  while(rs.next())
			  {
				  NewsVO nVo = new NewsVO();
				  nVo.setNewsId(rs.getInt(1));
				  nVo.setNewsTitle(rs.getString(2));
				  nVo.setNewsBody(rs.getString(3));
				  nVo.setNewsDst(rs.getString(4));
				  
				  news.add(nVo);
			  }
		  }
		  catch(Exception e)
		  {
			  e.printStackTrace();
		  }
		  
		  return news;
	  }
	  
	  public ArrayList<NewsVO> getExpertSpeak()
	  {
		  ArrayList<NewsVO> news = new ArrayList<NewsVO>();
		  
		  try
		  {
			  Statement stmt = conn.createStatement();
			  ResultSet rs = stmt.executeQuery("SELECT n.nid, DATE(FROM_UNIXTIME( n.created))as created," +
			  		" n.title, fu.field_news_source_value, ua.dst  FROM node n,  content_type_press  " +
			  		"fu, url_alias ua WHERE n.type = 'press' AND n.status = 1 and fu.nid = n.nid and " +
			  		"ua.src= concat('node/',n.nid) ORDER BY n.sticky DESC, n.created DESC limit 3");
			  
			  while(rs.next())
			  {
				  NewsVO nVo = new NewsVO();
				  nVo.setNewsId(rs.getInt(1));
				  nVo.setNewsTitle(rs.getString(2));
				  nVo.setNewsBody(rs.getString(3));
				  nVo.setNewsDst(rs.getString(4));
				  
				  news.add(nVo);
			  }
		  }
		  catch(Exception e)
		  {
			  e.printStackTrace();
		  }
		  
		  return news;
	  }
	  
	  public ArrayList<BribeFighterVO> getBribeFighters()
	  {
		  ArrayList<BribeFighterVO> fighters = new ArrayList<BribeFighterVO>();
		  
		  String query = "SELECT bc.*, bc.count as tot_view, ct.city_name AS c_city, bd.dept_name, " +
		  		"bt.trans_name FROM bd_dint_bribe bc, bd_dept bd, bd_transactions bt, bd_city ct " +
		  		"WHERE bc.c_dept=bd.id AND bc.c_transaction=bt.id AND bc.approved=1 AND bc.c_city=ct.Id AND " +
		  		"bc.created >= DATE_SUB(NOW(),INTERVAL 50 DAY) ORDER BY bc.count DESC LIMIT 8";
		  
		  try
		  {
			  Statement stmt = conn.createStatement();
			  Statement stmt1 = conn.createStatement();
			  ResultSet rs = stmt.executeQuery(query);
			  
			  while(rs.next())
			  {
				  BribeFighterVO bfVo = new BribeFighterVO();
				  
				  
				  ResultSet rs2 = stmt1.executeQuery("SELECT COUNT(1) AS cnt FROM bd_vote_comments WHERE TYPE='notpaid' AND type_id="+0+" AND published=1");
				  if(rs2.next())
				  {
				  }
				  else
				  {
					 // bfVo.setCommentsCount(0);
				  }
				  fighters.add(bfVo);
			  }
		  }
		  catch(Exception e)
		  {
			  e.printStackTrace();
		  }
		  
		  return fighters;
	  }
	  
}
