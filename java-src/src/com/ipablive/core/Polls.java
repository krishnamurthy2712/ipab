package com.ipablive.core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import com.ipablive.datasource.ConnectionFactory;
import com.ipablive.utils.BribeUtils;
import com.ipablive.vo.BlogPostVO;
import com.ipablive.vo.PollCommentsVO;
import com.ipablive.vo.PollResultVO;
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
	  
	  public Boolean insertPollResults(PollResultVO poll)
	  {
		  Boolean isInserted = false;
		  String query = "insert into bd_poll_results (pollId,pollOption,creationDate, createdBy,ip) values (?,?,?,?,?)";
			
			try
			  {
				java.sql.Date sqlDate = new java.sql.Date(new Date().getTime());
				PreparedStatement pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, poll.getPollId());
				pstmt.setString(2, poll.getPollOption());
				pstmt.setDate(3, sqlDate);
				pstmt.setString(4, poll.getCreatedBy());
				pstmt.setString(5, poll.getIpAddress());
				
				int i = pstmt.executeUpdate();
				
				if(i>1)
				{
					isInserted = true;
				}
				
			  }
			  catch(Exception e)
			  {
				  e.printStackTrace();
			  }
			
		  return isInserted;
	  }
	  
	  public Boolean insertPollComment(PollCommentsVO comments)
	  {
		  Boolean isInserted = false;
		  String query = "insert into bd_poll_comments (pollId,comment,creationDate, createdBy,ip) values (?,?,?,?,?)";
			
			try
			  {
				java.sql.Date sqlDate = new java.sql.Date(new Date().getTime());
				PreparedStatement pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, comments.getPollId());
				pstmt.setString(2, comments.getComment());
				pstmt.setDate(3, sqlDate);
				pstmt.setString(4, comments.getCommentedBy());
				pstmt.setString(5, comments.getIpAddress());
				
				int i = pstmt.executeUpdate();
				
				if(i>1)
				{
					isInserted = true;
				}
				
			  }
			  catch(Exception e)
			  {
				  e.printStackTrace();
			  }
			
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
		
		//This method is for admin activity purpose
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
		
		public ArrayList<PollVO> getAllApprovedPolls()
		{
			ArrayList<PollVO> polls = new ArrayList<PollVO>();
			
			 String query = "SELECT * from bd_polls where approval=0";
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
		
		public ArrayList<PollCommentsVO> getPollComments(int pollId)
		{
			ArrayList<PollCommentsVO> comments = new ArrayList<PollCommentsVO>();
			
			 String query = "SELECT * FROM bd_poll_comments b where b.pollId="+pollId;
			  try
			  {
				  Statement stmt = conn.createStatement();
				  ResultSet rs = stmt.executeQuery(query);
				  while(rs.next())
				  {
					  PollCommentsVO pcVo = new PollCommentsVO();
					  pcVo.setCommentId(rs.getInt(1));
					  pcVo.setPollId(rs.getInt(2));
					  pcVo.setComment(rs.getString(3));
					  pcVo.setCommentedBy(rs.getString(4));
					  pcVo.setCreatedDate(rs.getDate(5));
					  String friendlyTime = BribeUtils.getFriendlyTime(rs.getDate(5));
					  pcVo.setFriendlyDate(friendlyTime);
					  pcVo.setIpAddress(rs.getString(6));
					  
					  comments.add(pcVo);
				  }
			  }
			  catch(Exception e)
			  {
				  e.printStackTrace();
			  }
			
			return comments;
		}
		
		public Boolean isPolled(int pollId, String ipAddress)
		{
			Boolean ispolled = false;
			String query = "SELECT count(ip) from bd_poll_results where pollid="+pollId+" AND ip='"+ipAddress+"'";
			
			try
			  {
				  Statement stmt = conn.createStatement();
				  ResultSet rs = stmt.executeQuery(query);
				  int count = 0;
				  if(rs.next()) count = rs.getInt(1);
				  
				  if(count>1)
				  {
					  ispolled = true;
				  }
				  else
				  {
					  ispolled = false;
				  }
			  }
			  catch(Exception e)
			  {
				  e.printStackTrace();
			  }
			return ispolled;
		}
		
		public int getCount(int pollId, String pollOption)
		{
			int count = 0;
			String criteria = "";
			if(pollOption!="")
			{
				criteria =  " AND pollOption='"+pollOption+"'";
			}
			
			String query = "SELECT count(pollOption) from bd_poll_results where pollId="+pollId+ criteria;
			
			try
			  {
				  Statement stmt = conn.createStatement();
				  ResultSet rs = stmt.executeQuery(query);
				  if(rs.next())
				  {
					  count = rs.getInt(1);
				  }
			  }
			  catch(Exception e)
			  {
				  e.printStackTrace();
			  }
			return count;
		}
		
		public Boolean insertPoll(PollVO data)
		{
			Boolean isInserted = false;
			  String query = "insert into bd_polls " +
			  		"(PollTitle,pollDescription,pollQuestion, pollOptions,createdBy,creationDate,isDisplay,approval) " +
			  		"values (?,?,?,?,?,?,?,?)";
				
				try
				  {
					java.sql.Date sqlDate = new java.sql.Date(new Date().getTime());
					PreparedStatement pstmt = conn.prepareStatement(query);
					pstmt.setString(1, data.getPollTitle());
					pstmt.setString(2, data.getPollDescription());
					pstmt.setString(3, data.getPollQuestion());
					pstmt.setString(4, data.getPollOptions());
					pstmt.setString(5, data.getPollCreationBy());
					pstmt.setDate(6, sqlDate);
					pstmt.setInt(7, 1);
					pstmt.setInt(8, 0);
					
					
					int i = pstmt.executeUpdate();
					
					if(i>1)
					{
						isInserted = true;
					}
					
				  }
				  catch(Exception e)
				  {
					  e.printStackTrace();
				  }
				
			  return isInserted;
			  
		}
	  
	  
}
