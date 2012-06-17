/**
 * 
 */
package com.ipablive.core;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.ipablive.datasource.ConnectionFactory;
import com.ipablive.vo.BribeAnalysisVO;
import com.ipablive.vo.FaqVO;

/**
 * @author 
 *
 */
public class Faqs 
{

	Connection conn=null;
	
	 /* Here is the instance of the Singleton */
	  private static Faqs _faqInstance;

	  //Prevent direct access to the constructor
	  private Faqs() 
	  {
	    super();
	    if(conn == null)
	    {
	    	conn = ConnectionFactory.getConnection();
	    }
	  }
	  
	  public static Faqs getInstance() 
	  {

	    if (_faqInstance == null) 
	    {

	      synchronized(Faqs.class) 
	      {

	        if (_faqInstance == null) 
	        {
	        	_faqInstance = new Faqs();
	        }

	      }

	    }
	    
	    return _faqInstance;
	  }
	
	  
	  public ArrayList<FaqVO> getFaqs()
	  {
		  ArrayList<FaqVO> faqs = new ArrayList<FaqVO>();
		  
		  String query = "SELECT f.*, c.city_name, d.dept_name, t.trans_name FROM bd_faq f, bd_city c," +
		  		" bd_dept d, bd_transactions t WHERE c.Id = f.city_id AND d.id = f.dept_id;";
		  try
		  {
			  Statement stmt = conn.createStatement();
			  ResultSet rs = stmt.executeQuery(query);
			  while(rs.next())
			  {
				  FaqVO faq = new FaqVO();
				  
				  faq.setId(rs.getInt(1));
				  faq.setDeptId(rs.getInt(2));
				  faq.setTransactionId(rs.getInt(3));
				  faq.setCityId(rs.getInt(4));
				  faq.setQuestion(rs.getString(5));
				  faq.setAnswer(rs.getString(6));
				  faq.setPriority(rs.getInt(7));
				  faq.setCreatedAt(rs.getDate(8));
				  faq.setUpdatedAt(rs.getDate(9));
				  faq.setPublished(rs.getInt(10));
				  faq.setCityName(rs.getString(11));
				  faq.setDeptName(rs.getString(12));
				  faq.setTransName(rs.getString(13));
				  
				  faqs.add(faq);
			  }
		  }
		  catch(Exception e)
		  {
			  e.printStackTrace();
		  }
		  
		  return faqs;
	  }
}
