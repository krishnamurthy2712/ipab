package com.ipablive.core;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.ipablive.datasource.ConnectionFactory;
import com.ipablive.vo.BlogPostVO;
import com.ipablive.vo.PollVO;

public class Polls 
{

	Connection conn=null;
	
	 /* Here is the instance of the Singleton */
	  private static Polls _pollsInstance;

	  //Prevent direct access to the constructor
	  private Polls() 
	  {
	    super();
	    if(conn == null)
	    {
	    	conn = ConnectionFactory.getConnection();
	    }
	  }
	  
	  public static Polls getInstance() 
	  {

	    if (_pollsInstance == null) 
	    {

	      synchronized(Polls.class) 
	      {

	        if (_pollsInstance == null) 
	        {
	        	_pollsInstance = new Polls();
	        }

	      }

	    }
	    
	    return _pollsInstance;
	  }
	  
	  public Boolean insertPolls()
		{
			Boolean isInserted = false;
			return isInserted;
		}
		
		public Boolean updatePolls()
		{
			Boolean isUpdated = false;
			return isUpdated;
		}
		
		public Boolean updateIsDisplayPoll()
		{
			Boolean isUpdated = false;
			return isUpdated;
		}
		
		public Boolean updatePollApproval()
		{
			Boolean isUpdated = false;
			return isUpdated;
		}
		
		public PollVO getTodaysPoll()
		{
			PollVO pVo = null;
			String query = "SELECT * from bd_polls where approval=0 AND isDisplay=0";
			
			try
			  {
				  Statement stmt = conn.createStatement();
				  ResultSet rs = stmt.executeQuery(query);
				  if(rs.next())
				  {
					  pVo = new PollVO();
					  pVo.setPollId(rs.getInt(1));
					  pVo.setPollTitle(rs.getString(2));
					  pVo.setPollDescription(rs.getString(3));
					  pVo.setPollQuestion(rs.getString(4));
					  pVo.setPollOptions(rs.getString(5));
					  pVo.setPollCreationBy(rs.getString(6));
					  pVo.setPollCreationDate(rs.getDate(7));
					  pVo.setIsDisplayed(rs.getInt(8));
					  pVo.setApproval(rs.getInt(9));
				  }
			  }
			  catch(Exception e)
			  {
				  e.printStackTrace();
			  }
			
			return pVo;
		}
		
		public ArrayList<PollVO> getAllPolls()
		{
			ArrayList<PollVO> polls = new ArrayList<PollVO>();
			
			 String query = "SELECT * from bd_polls";
			  try
			  {
				  Statement stmt = conn.createStatement();
				  ResultSet rs = stmt.executeQuery(query);
				  while(rs.next())
				  {
					  PollVO pVo = new PollVO();
					  pVo.setPollId(rs.getInt(1));
					  pVo.setPollTitle(rs.getString(2));
					  pVo.setPollDescription(rs.getString(3));
					  pVo.setPollQuestion(rs.getString(4));
					  pVo.setPollOptions(rs.getString(5));
					  pVo.setPollCreationBy(rs.getString(6));
					  pVo.setPollCreationDate(rs.getDate(7));
					  pVo.setIsDisplayed(rs.getInt(8));
					  pVo.setApproval(rs.getInt(9));
					  
					  polls.add(pVo);
				  }
			  }
			  catch(Exception e)
			  {
				  e.printStackTrace();
			  }
			
			return polls;
		}
	  
	  
}
