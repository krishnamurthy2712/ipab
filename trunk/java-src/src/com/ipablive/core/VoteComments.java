/**
 * 
 */
package com.ipablive.core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Date;

import com.ipablive.datasource.ConnectionFactory;
import com.ipablive.utils.BribeUtils;
import com.ipablive.vo.CommentVO;
import com.sun.org.apache.xpath.internal.operations.Bool;

/**
 * @author 
 *
 */
public class VoteComments 
{

	Connection conn=null;
		
	 /* Here is the instance of the Singleton */
	  private static VoteComments _commentsInstance;

	  //Prevent direct access to the constructor
	  private VoteComments() 
	  {
	    super();
	    if(conn == null)
	    {
	    	conn = ConnectionFactory.getConnection();
	    }
	  }
	  
	  public static VoteComments getInstance() 
	  {

	    if (_commentsInstance == null) 
	    {

	      synchronized(IPaidBribe.class) 
	      {

	        if (_commentsInstance == null) 
	        {
	        	_commentsInstance = new VoteComments();
	        }

	      }

	    }
	    
	    return _commentsInstance;
	  }
	  
	  
	  public Boolean storeVoteComments(CommentVO data,String type,int postId, String ip)
	  {
		  Boolean isStored = false;
		  try
		  {
			  String query = "";
			  PreparedStatement pstmt;
			  java.sql.Date sqlDate = new java.sql.Date(new Date().getTime());
			  
			  query = "insert into bd_vote_comments (type,subject,comment,date,published,type_id,ip) values (?,?,?,?,?,?,?)";
			  pstmt = conn.prepareStatement(query);
			  pstmt.setString(1, type);
			  pstmt.setString(2, data.getSubject());
			  pstmt.setString(3, data.getComment());
			  pstmt.setDate(4, sqlDate);
			  pstmt.setInt(5, 1);
			  pstmt.setInt(6, postId);
			  pstmt.setString(7,ip);
				  
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
}
