/**
 * 
 */
package com.ipablive.commons;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
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

}
