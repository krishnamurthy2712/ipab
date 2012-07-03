package com.ipablive.core;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.ipablive.datasource.ConnectionFactory;

public class Awards 
{
	Connection conn=null;
	
	 /* Here is the instance of the Singleton */
	  private static Awards _awardsInstance;

	  //Prevent direct access to the constructor
	  private Awards() 
	  {
	    super();
	    if(conn == null)
	    {
	    	conn = ConnectionFactory.getConnection();
	    }
	  }
	  
	  public static Awards getInstance() 
	  {

	    if (_awardsInstance == null) 
	    {

	      synchronized(Awards.class) 
	      {

	        if (_awardsInstance == null) 
	        {
	        	_awardsInstance = new Awards();
	        }

	      }

	    }
	    
	    return _awardsInstance;
	  }
	  
	  public int getAwardsCount()
	  {
		  int count = 0;
		  String query = "select count(*) as ncnt from node WHERE node.type = 'awards' AND node.status =1";
		  
		  try
		  {
			  Statement stmt = conn.createStatement();
			  ResultSet rs = stmt.executeQuery(query);
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
	  
	  public void getLatestAwards()
	  {
		  String query = "select NodeInfo.*,texts.field_department_value, content_field_award_photo.field_award_photo_fid,files.filepath as imgPath from (SELECT node.nid AS nid, node.title AS node_title, node_revisions.body as teasetTxt, url_alias.dst as nodeURL FROM node node, node_revisions node_revisions, url_alias url_alias WHERE node.type = 'awards' and node_revisions.nid = node.nid and url_alias.src= concat('node/',node.nid) and node.status = 1 ORDER BY nid DESC) as NodeInfo  left join content_field_award_photo on (content_field_award_photo.nid = NodeInfo.nid) left join files on (files.fid = content_field_award_photo.field_award_photo_fid ) left join content_type_awards as texts on texts.nid=NodeInfo.nid";
		  
		  try
		  {
			  Statement stmt = conn.createStatement();
			  ResultSet rs = stmt.executeQuery(query);
			  while(rs.next())
			  {
			  }
		  }catch(Exception e)
		  {
			  e.printStackTrace();
		  }
		  
		  
	  }
}
