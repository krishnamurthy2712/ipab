package com.ipablive.core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import com.ipablive.datasource.ConnectionFactory;
import com.ipablive.vo.BlogCommentVO;
import com.ipablive.vo.BlogPostDetailsVO;
import com.ipablive.vo.BlogPostVO;
import com.ipablive.vo.FaqVO;

public class Blogs 
{
	Connection conn=null;
	
	 /* Here is the instance of the Singleton */
	  private static Blogs _blogsInstance;

	  //Prevent direct access to the constructor
	  private Blogs() 
	  {
	    super();
	    if(conn == null)
	    {
	    	conn = ConnectionFactory.getConnection();
	    }
	  }
	  
	  public static Blogs getInstance() 
	  {

	    if (_blogsInstance == null) 
	    {

	      synchronized(Blogs.class) 
	      {

	        if (_blogsInstance == null) 
	        {
	        	_blogsInstance = new Blogs();
	        }

	      }

	    }
	    
	    return _blogsInstance;
	  }
	  
	  public ArrayList<BlogPostVO> getBlogPosts()
	  {
		  ArrayList<BlogPostVO> posts = new ArrayList<BlogPostVO>();
		  
		  String query = "SELECT * from bd_blog_post where approval=0";
		  try
		  {
			  Statement stmt = conn.createStatement();
			  ResultSet rs = stmt.executeQuery(query);
			  while(rs.next())
			  {
				  BlogPostVO post = new BlogPostVO();
				  post.setPostId(rs.getInt(1));
				  post.setPostTitle(rs.getString(2));
				  post.setPostContent(rs.getString(3));
				  post.setDestURL(rs.getString(4));
				  post.setIpAddress(rs.getString(5));
				  post.setPostedBy(rs.getString(6));
				  post.setPostCreatedDate(rs.getDate(7));
				  post.setPostApproval(rs.getInt(8));
				  post.setApprovedDate(rs.getDate(9));
				  post.setTotalViews(rs.getInt(10));
				  
				  int commentCount = getBlogCommentCount(rs.getInt(1));
				  post.setCommentCount(commentCount);
				  
				  posts.add(post);
			  }
		  }
		  catch(Exception e)
		  {
			  e.printStackTrace();
		  }
		  
		  return posts;
	  }
	  
	  public ArrayList<BlogPostVO> getBlogPostsByUser(String userName)
	  {
		  ArrayList<BlogPostVO> posts = new ArrayList<BlogPostVO>();
		  
		  String query = "SELECT * from bd_blog_post where approval=0 AND postedBy='"+userName+"'";
		  try
		  {
			  Statement stmt = conn.createStatement();
			  ResultSet rs = stmt.executeQuery(query);
			  while(rs.next())
			  {
				  BlogPostVO post = new BlogPostVO();
				  post.setPostId(rs.getInt(1));
				  post.setPostTitle(rs.getString(2));
				  post.setPostContent(rs.getString(3));
				  post.setDestURL(rs.getString(4));
				  post.setIpAddress(rs.getString(5));
				  post.setPostedBy(rs.getString(6));
				  post.setPostCreatedDate(rs.getDate(7));
				  post.setPostApproval(rs.getInt(8));
				  post.setApprovedDate(rs.getDate(9));
				  post.setTotalViews(rs.getInt(10));
				  
				  int commentCount = getBlogCommentCount(rs.getInt(1));
				  post.setCommentCount(commentCount);
				  
				  posts.add(post);
			  }
		  }
		  catch(Exception e)
		  {
			  e.printStackTrace();
		  }
		  
		  return posts;
	  }
	  
	  public BlogPostDetailsVO getBlogPostDetails(int postId)
	  {
		  BlogPostDetailsVO post = null ;
		  String query = "SELECT * from bd_blog_post where postId="+postId+" AND approval=0";
		  
		  try
		  {
			  Statement stmt = conn.createStatement();
			  ResultSet rs = stmt.executeQuery(query);
			  if(rs.next())
			  {
				  post = new BlogPostDetailsVO();
				  post.setPostId(rs.getInt(1));
				  post.setPostTitle(rs.getString(2));
				  post.setPostContent(rs.getString(3));
				  post.setDestURL(rs.getString(4));
				  post.setIpAddress(rs.getString(5));
				  post.setPostedBy(rs.getString(6));
				  post.setPostCreatedDate(rs.getDate(7));
				  post.setPostApproval(rs.getInt(8));
				  post.setApprovedDate(rs.getDate(9));
				  post.setTotalViews(rs.getInt(10));
				  
				  ArrayList<BlogCommentVO> comments = getBlogComments(rs.getInt(1));
				  post.setPostComments(comments);
				  
			  }
		  }
		  catch(Exception e)
		  {
			  e.printStackTrace();
		  }
		  
		  return post;
	  }
	  
	  public int getBlogCommentCount(int postId)
	  {
		  int count = 0;
		  String query = "SELECT COUNT(1) AS cnt FROM bd_blog_comment WHERE postId="+postId+" AND approval=0";
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
	  
	  public ArrayList<BlogCommentVO> getBlogComments(int postId)
	  {
		  ArrayList<BlogCommentVO> comments = new ArrayList<BlogCommentVO>();
		  String query = "SELECT * FROM bd_blog_comment WHERE postId="+postId+" AND approval=0";
		  try
		  {
			  Statement stmt = conn.createStatement();
			  ResultSet rs = stmt.executeQuery(query);
			  if(rs.next())
			  {
				  BlogCommentVO comment = new BlogCommentVO();
				  comment.setCommentId(rs.getInt(1));
				  comment.setPostId(rs.getInt(2));
				  comment.setCommentTitle(rs.getString(3));
				  comment.setCommentContent(rs.getString(4));
				  comment.setSupportURL(rs.getString(5));
				  comment.setIpAddress(rs.getString(6));
				  comment.setCreatedBy(rs.getString(7));
				  comment.setApproval(rs.getInt(8));
				  comment.setCreationDate(rs.getDate(9));
				  comment.setApprovedDate(rs.getDate(10));
				  
				  comments.add(comment);
			  }
		  }
		  catch(Exception e)
		  {
			  e.printStackTrace();
		  }
		  
		  return comments;
	  }
	  
	  public Boolean storeBlogPost(BlogPostVO data)
	  {
		  Boolean isStored = false;
		  
		  String query = "insert into bd_blog_post (postTitle,postContent,destURL," +
		  		"IP,postedBy,postedDate,approval,approvalDate,totalViews) values " +
		  		"(?,?,?,?,?,?,?,?,?)";
		  try
		  {
			  PreparedStatement pstmt = conn.prepareStatement(query);
			  pstmt.setString(1, data.getPostTitle());
			  pstmt.setString(2, data.getPostContent());
			  pstmt.setString(3, data.getDestURL());
			  pstmt.setString(4, data.getIpAddress());
			  pstmt.setString(5, "admin");
			  Calendar cal = Calendar.getInstance();
			  java.sql.Date dd = new java.sql.Date(cal.getTimeInMillis());
			  pstmt.setDate(6, dd);
			  pstmt.setInt(7, 0);//by default approved 0 - approved
			  pstmt.setDate(8, dd);
			  pstmt.setInt(9, 0);
			  
			  int i = pstmt.executeUpdate();
			  if(i>1)
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
	  
	  public Boolean storeBlogComment(BlogCommentVO data)
	  {
		  Boolean isStored = false;
		  
		  String query = "insert into bd_blog_comment (postID,commentTitle," +
		  		"commentContent,supportURL,ip,created,approval,creationDate,approvedDate) values " +
		  		"(?,?,?,?,?,?,?,?,?)";
		  try
		  {
			  PreparedStatement pstmt = conn.prepareStatement(query);
			  pstmt.setInt(1, data.getPostId());
			  pstmt.setString(2, data.getCommentTitle());
			  pstmt.setString(3, data.getCommentContent());
			  pstmt.setString(4, data.getSupportURL());
			  pstmt.setString(5, data.getIpAddress());
			  pstmt.setString(6, data.getCreatedBy());
			  pstmt.setInt(7, data.getApproval());
			  Calendar cal = Calendar.getInstance();
			  java.sql.Date dd = new java.sql.Date(cal.getTimeInMillis());
			  pstmt.setDate(8, dd);
			  pstmt.setDate(9, dd);
			  
			  int i = pstmt.executeUpdate();
			  if(i>1)
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
	  
	  public Boolean updateTotalViews(int postId)
	  {
		  Boolean isUpdated = false;
		  String query = "UPDATE bd_blog_post SET totalViews = totalViews + 1 where postId="+postId+" AND approval=0";
		  try
		  {
			  PreparedStatement pstmt = conn.prepareStatement(query);
			  
			  int i = pstmt.executeUpdate();
			  if(i>1)
			  {
				  isUpdated = true;
			  }
		  }
		  catch(Exception e)
		  {
			  e.printStackTrace();
		  }
		  
		  return isUpdated;
	  }
	   
}
