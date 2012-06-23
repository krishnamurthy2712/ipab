/**
 * 
 */
package com.ipablive.commons;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipablive.datasource.ConnectionFactory;
import com.ipablive.vo.CityVO;
import com.ipablive.vo.DepartmentVO;
import com.ipablive.vo.TransactionVO;

/**
 * @author 
 *
 */
public class CommonOperations 
{
	Connection conn=null;
	
	 /* Here is the instance of the Singleton */
	  private static CommonOperations _commonOperationsInstance;

	  //Prevent direct access to the constructor
	  private CommonOperations() 
	  {
	    super();
	    if(conn == null)
	    {
	    	conn = ConnectionFactory.getConnection();
	    }
	  }
	  
	  public static CommonOperations getInstance() 
	  {

	    if (_commonOperationsInstance == null) 
	    {

	      synchronized(CommonOperations.class) 
	      {

	        if (_commonOperationsInstance == null) 
	        {
	        	_commonOperationsInstance = new CommonOperations();
	        }

	      }

	    }
	    
	    return _commonOperationsInstance;
	  }
	
	public ArrayList<CityVO> getCounties()
	{
		ArrayList<CityVO> counties = new ArrayList<CityVO>();
		try
		{
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT id,city_name FROM bd_city");
			while(rs.next())
			{
				CityVO cVo = new CityVO();
				cVo.setId(rs.getInt(1));
				cVo.setCityName(rs.getString(2));
				counties.add(cVo);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return counties;
	}
	
	public ArrayList<DepartmentVO> getDepartments()
	{
		ArrayList<DepartmentVO> depts = new ArrayList<DepartmentVO>();
		try
		{
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select id,dept_name from bd_dept");
			while(rs.next())
			{
				DepartmentVO deptVo = new DepartmentVO();
				deptVo.setDeptID(rs.getInt(1));
				deptVo.setDeptName(rs.getString(2));
				
				depts.add(deptVo);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return depts;
	}
	
	public ArrayList<TransactionVO> getTransactions(int deptId)
	{
		ArrayList<TransactionVO> transactions = new ArrayList<TransactionVO>();
		try
		{
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select id,trans_name from bd_transactions where dept_id="+deptId);
			while(rs.next())
			{
				TransactionVO tVo = new TransactionVO();
				tVo.setTransactionId(rs.getInt(1));
				tVo.setTransactioName(rs.getString(2));
				
				transactions.add(tVo);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return transactions;
	}
	
	public int getHits()
	{
		int pageVisists = 0;
		try 
        {
            String sql = "SELECT pagevisit FROM bd_analytics";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()) 
            {
            	pageVisists = rs.getInt(1);
            	updateHitCounter();
            }
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        } 
		
		return pageVisists;
	}
	
	private void updateHitCounter() 
	{
        Connection connection = ConnectionFactory.getConnection();
        try 
        {
            String sql = "UPDATE bd_analytics SET pagevisit = pagevisit + 1";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.executeUpdate();          
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        } 
    }
}
