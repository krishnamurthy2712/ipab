package com.ipablive.core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import com.ipablive.datasource.ConnectionFactory;
import com.ipablive.utils.BribeUtils;
import com.ipablive.vo.BribeAnalysisVO;
import com.ipablive.vo.BribeCategoriesVO;
import com.ipablive.vo.BribeFighterVO;
import com.ipablive.vo.BribeReportsVO;
import com.ipablive.vo.ExpertSpeakVo;
import com.ipablive.vo.MostPopularReportsVO;
import com.ipablive.vo.NewsVO;
import com.ipablive.vo.OptionsVO;
import com.ipablive.vo.QuizVo;
import com.ipablive.vo.TopCitiesVO;
import com.ipablive.vo.TopFiveCitiesVO;
import com.ipablive.vo.TopFiveDeptsVO;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

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
				  brv.setDeptId(rs.getInt(4));
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
	  
	  public ArrayList<NewsVO> getNews(int limit)
	  {
		  ArrayList<NewsVO> news = new ArrayList<NewsVO>();
		  String searchCriteria = "";
		  if(limit==0)
		  {
			  searchCriteria = " where approval=0";
		  }else
		  {
			  searchCriteria = " where approval=0 limit "+limit;
		  }
		  
		  try
		  {
			  Statement stmt = conn.createStatement();
			  ResultSet rs = stmt.executeQuery("SELECT * from bd_news"+searchCriteria);
			  
			  while(rs.next())
			  {
				  NewsVO nVo = new NewsVO();
				  nVo.setNewsId(rs.getInt(1));
				  nVo.setNewsTitle(rs.getString(2));
				  nVo.setNewsBody(rs.getString(3));
				  nVo.setNewsDst(rs.getString(4));
				  nVo.setNewsCreated(rs.getString(7));
				  nVo.setNewsCreatedDate(rs.getDate(8));
				  String fridlyTime = BribeUtils.getFriendlyTime(rs.getDate(8));
				  nVo.setFriendlyDate(fridlyTime);
				  
				  news.add(nVo);
			  }
		  }
		  catch(Exception e)
		  {
			  e.printStackTrace();
		  }
		  
		  return news;
	  }
	  
	  public ArrayList<ExpertSpeakVo> getExpertSpeak()
	  {
		  ArrayList<ExpertSpeakVo> news = new ArrayList<ExpertSpeakVo>();
		  
		  try
		  {
			  Statement stmt = conn.createStatement();
			  ResultSet rs = stmt.executeQuery("SELECT n.nid, DATE(FROM_UNIXTIME( n.created))as created," +
			  		" n.title, fu.field_news_source_value, ua.dst  FROM node n,  content_type_press  " +
			  		"fu, url_alias ua WHERE n.type = 'press' AND n.status = 1 and fu.nid = n.nid and " +
			  		"ua.src= concat('node/',n.nid) ORDER BY n.sticky DESC, n.created DESC limit 3");
			  
			  while(rs.next())
			  {
				  ExpertSpeakVo nVo = new ExpertSpeakVo();
				  nVo.setAuthorName(rs.getString(1));
				  nVo.setEpId(rs.getInt(2));
				  nVo.setTitle(rs.getString(3));
				  nVo.setFieldTitleURL(rs.getString(4));
				  nVo.setCreated(rs.getDate(5));
				  nVo.setBody(rs.getString(6));
				  nVo.setDst(rs.getString(7));
				  
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
				  
				  bfVo.setId(rs.getInt(1));
				  bfVo.setCName(rs.getString(2));
				  //3,4,5
				  bfVo.setOtherTransaction(rs.getString(6));
				  bfVo.setCBribeResistedBy(rs.getString(7));
				  bfVo.setCAdditionalInfo(rs.getString(8));
				  //store "created"
				  bfVo.setCreated(rs.getDate(9));
				  //10,11,12,13,14
				  bfVo.setTotalViews(rs.getInt(15));
				  bfVo.setCCity(rs.getString(16));
				  bfVo.setCDeptName(rs.getString(17));
				  bfVo.setCTransaction(rs.getString(18));
				 
				  //store "friendlyTime" - friendlyTime = BribeUtils.getFriendlyTime(create);
				  Date timeDisp = (Date) rs.getDate(9);
				  bfVo.setFriendlyTime(BribeUtils.getFriendlyTime(timeDisp));
				  /*comments count*/
				  ResultSet rs2 = stmt1.executeQuery("SELECT COUNT(1) AS cnt FROM bd_vote_comments WHERE TYPE='notpaid' AND type_id="+rs.getInt(1)+" AND published=1");
				  if(rs2.next())
				  {
					  bfVo.setCommentsCount(rs2.getInt(1));
				  }
				  else
				  {
					  bfVo.setCommentsCount(0);
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
	  
	  public ArrayList<QuizVo> getQuizQuestions()
	  {
		  ArrayList<QuizVo> quiz = new ArrayList<QuizVo>();
		  
		  try
		  {
			  Statement stmt = conn.createStatement();
			  Statement stmt1 = conn.createStatement();
			  ResultSet rs = stmt.executeQuery("select q_id, q_description from bd_quiz_questions");
			  
			  while(rs.next())
			  {
				  QuizVo questions = new QuizVo();
				  questions.setqId(rs.getInt(1));
				  questions.setqDescription(rs.getString(2));
				  
				  ArrayList<OptionsVO> options = new ArrayList<OptionsVO>();
				  
				  ResultSet rs2 = stmt1.executeQuery("select ans_id,q_id,ans_value,ans_description from bd_quiz_answers where q_id = "+ rs.getInt(1));
				  while(rs2.next())
				  {
					  OptionsVO option = new OptionsVO();
					  option.setAnsId(rs2.getInt(1));
					  option.setAnsValue(rs2.getString(2));
					  option.setAnsDescription(rs2.getString(3));
					  
					  options.add(option);
				  }
				  
				  quiz.add(questions);
			  }
		  }
		  catch(Exception e)
		  {
			  e.printStackTrace();
		  }
		  
		  return quiz;
	  }
	  
	  public ArrayList<MostPopularReportsVO> getMostPopularReports()
	  {
		  ArrayList<MostPopularReportsVO> popular = new ArrayList<MostPopularReportsVO>();
		  String query = "SELECT bc.*, bc.count as tot_view, ct.city_name AS c_city, " +
		  		"bd.dept_name, bt.trans_name FROM bd_paid_bribe bc, bd_dept bd, bd_transactions bt," +
		  		" bd_city ct WHERE bc.c_dept=bd.id AND bc.c_transaction=bt.id AND bc.approved=1 " +
		  		"AND bc.c_city=ct.Id AND bc.created >= DATE_SUB(NOW(),INTERVAL 5 DAY) " +
		  		"ORDER BY bc.count DESC LIMIT 4";
		  try
		  {
			  Statement stmt = conn.createStatement();
			  ResultSet rs = stmt.executeQuery(query);
			  while(rs.next())
			  {
				  MostPopularReportsVO pVo = new MostPopularReportsVO();
				  pVo.setId(rs.getInt(1));
				  pVo.setCName(rs.getString(2));
				  pVo.setCCity(rs.getInt(3));
				  pVo.setCDept(rs.getInt(4));
				  //5
				  pVo.setOtherTrans(rs.getString(6));
				  pVo.setCAmtPaid(rs.getInt(7));
				  //8
				  pVo.setBribeType(rs.getString(9));
				  //10
				  pVo.setAddInfo(rs.getString(11));
				  //12,13
				  pVo.setCreated(rs.getDate(14));
				  pVo.setOtherLocation(rs.getString(15));
				  //16,17,18,19
				  pVo.setTotalViews(rs.getInt(20));
				  pVo.setCityName(rs.getString(21));
				  pVo.setDeptName(rs.getString(22));
				  pVo.setTransName(rs.getString(23));
				 
				  //store "friendlyTime" - friendlyTime = BribeUtils.getFriendlyTime(create);
				  Date timeDisp = (Date) rs.getDate(14);
				  pVo.setFriendlyTime(BribeUtils.getFriendlyTime(timeDisp));
				  
				  int comments = getNumComments(rs.getInt(1),"paid");
				  pVo.setCommentsCount(comments);
				  
				  popular.add(pVo);
				  
			  }
		  }catch(Exception e)
		  {
			  e.printStackTrace();
		  }
		  
		  return popular;
	  }
	  
	  public ArrayList<TopFiveCitiesVO> getTopFiveCities()
	  {
		  ArrayList<TopFiveCitiesVO> cities = new ArrayList<TopFiveCitiesVO>();
		  
		  String query = "SELECT count(1) AS totalRec, SUM(bc.c_amt_paid) AS total_amount, bc.c_city, ct.city_name FROM bd_paid_bribe bc, bd_dept bd, bd_transactions bt, bd_city ct WHERE bc.c_dept = bd.id AND bc.c_transaction = bt.id AND bc.approved =1 AND bc.c_city = ct.Id AND c_dept = bd.id group by c_city ORDER BY Totalrec DESC limit 5";
		  try
		  {
			  Statement stmt = conn.createStatement();
			  ResultSet rs = stmt.executeQuery(query);
			  while(rs.next())
			  {
				  TopFiveCitiesVO city = new TopFiveCitiesVO();
				  city.setTotalRecs(rs.getInt(1));
				  city.setTotalAmount(rs.getInt(2));
				  city.setCityId(rs.getInt(3));
				  city.setCityName(rs.getString(4));
				  
				  cities.add(city);
				  
			  }
		  }catch(Exception e)
		  {
			  e.printStackTrace();
		  }
		  return cities;
	  }
	  
	  public ArrayList<TopFiveDeptsVO> getTopFiveDepartments()
	  {
		  ArrayList<TopFiveDeptsVO> depts = new ArrayList<TopFiveDeptsVO>();
		  String query = "SELECT count(1) AS totalRec, SUM(bc.c_amt_paid) AS total_amount, bd.dept_name, bc.c_dept FROM bd_paid_bribe bc, bd_dept bd, bd_transactions bt, bd_city ct WHERE bc.c_dept = bd.id AND bc.c_transaction = bt.id AND bc.approved =1 AND bc.c_city = ct.Id AND c_dept = bd.id group by c_dept ORDER BY Totalrec DESC limit 5";
		  try
		  {
			  Statement stmt = conn.createStatement();
			  ResultSet rs = stmt.executeQuery(query);
			  while(rs.next())
			  {
				  TopFiveDeptsVO dept = new TopFiveDeptsVO();
				  dept.setTotalRecs(rs.getInt(1));
				  dept.setTotalAmount(rs.getInt(2));
				  dept.setDeptName(rs.getString(3));
				  dept.setDeptId(rs.getInt(4));
				  
				  depts.add(dept);
			  }
		  }catch(Exception e)
		  {
			  e.printStackTrace();
		  }
		  return depts;
	  }
	  
	  public int getNumComments(int id, String type)
	  {
		  int count = 0;
		  
		  try
		  {
			  Statement stmt = conn.createStatement();
			  ResultSet rs = stmt.executeQuery("SELECT count(1) as cnt from bd_vote_comments where type='"+type+"' and type_id='"+id+"' and published=1");
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
	  
	  public Boolean insertNews(NewsVO data)
	  {
		  Boolean isInserted = false;
		  String query = "insert into bd_news " +
		  		"(newsTitle,newsContent,URL,ip,approval,createdBy,creationDate,approvalDate) " +
		  		"values (?,?,?,?,?,?,?,?)";
		  
		  
		  try
		  {
			  PreparedStatement pstmt = conn.prepareStatement(query);
			  pstmt.setString(1, data.getNewsTitle());
			  pstmt.setString(2, data.getNewsBody());
			  pstmt.setString(3, data.getNewsDst());
			  pstmt.setString(4, data.getIpAddress());
			  pstmt.setInt(5, 0);
			  Calendar cal = Calendar.getInstance();
			  java.sql.Date dd = new java.sql.Date(cal.getTimeInMillis());
			  pstmt.setString(6, data.getNewsCreated());
			  pstmt.setDate(7, dd);
			  pstmt.setDate(8, dd);
			  int k = pstmt.executeUpdate();
			  
			  if(k>0)
			  {
				  isInserted = true;
			  }
			  
		  }
		  catch(Exception e)
		  {
			  
		  }
		  
		  return isInserted;
	  }
	  
	  public Boolean deleteNews(int newsId)
	  {
		  Boolean isDeleted = false;
		  try
			{
				String query = "delete from bd_news where newsId=?";
				PreparedStatement pstmt = conn.prepareStatement(query);
				pstmt.setInt(1,newsId);
				
				int i = pstmt.executeUpdate();
				if(i==1)
				{
					isDeleted = true;
				}
				else
				{
					isDeleted = false;
				}
				
				
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		  return isDeleted;
	  }
	  
}
