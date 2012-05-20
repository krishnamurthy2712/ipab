package com.ipablive.datasource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 * @author 
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
	
	   /**
     * Close a <code>Connection</code>, avoid closing if null.
     *
     * @param conn Connection to close.
     * @throws SQLException if a database access error occurs
     */
    public static void closeConnection(Connection conn) throws SQLException 
    {
        if (conn != null) 
        {
            conn.close();
        }
    }

    /**
     * Close a <code>ResultSet</code>, avoid closing if null.
     *
     * @param rs ResultSet to close.
     * @throws SQLException if a database access error occurs
     */
    public static void closeResultSet(ResultSet rs) throws SQLException 
    {
        if (rs != null) 
        {
            rs.close();
        }
    }

    /**
     * Close a <code>Statement</code>, avoid closing if null.
     *
     * @param stmt Statement to close.
     * @throws SQLException if a database access error occurs
     */
    public static void closeStatement(Statement stmt) throws SQLException 
    {
        if (stmt != null) 
        {
            stmt.close();
        }
    }
	
	public static void main(String[] args) 
	{
		getConnection();
	}
}
