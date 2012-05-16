package com.ipablive.datasource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 * @author Deepthi
 *
 */

public class ConnectionFactory 
{
	public static Connection getConnection()
	{
		Connection conn = null;
		String userName = "root";
        String password = "root";
        String url = "jdbc:mysql://localhost:3306/ipablive";
        try 
        {
			Class.forName ("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, userName, password);
			System.out.println ("Connection Created Successfully.");
		} catch (ClassNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println ("Unable to create connection.");
		} catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println ("Unable to create connection.");
		}
        
        return conn;
	}
	
	public static void main(String[] args) 
	{
		getConnection();
	}
}
