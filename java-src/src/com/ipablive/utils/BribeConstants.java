package com.ipablive.utils;

public class BribeConstants 
{
	// list of queries/constants
	public static String asdf = "";
	
	/**
	 * Queries constants for the following:
	 *  1) City Service
	 *  
	 **/
	// Table Name: bd_city
	public static String GET_ALL_CITIES = "SELECT * FROM bd_city";
	public static String GET_CITY_BY_ID = "SELECT * FROM bd_city where Id=";
	public static String GET_CITY_COUNT = "SELECT COUNT( * ) FROM bd_city WHERE (SELECT COUNT( * ) FROM bd_paid_bribe"+
										  "WHERE c_city = bd_city.Id	AND approved =1 ) >0";
	public static String GET_CITY_PAGED = "SELECT * FROM bd_city LIMIT ";
	public static String GET_CITY_MOST_BRIBED = "SELECT Id as id, city_name as name,"+ 
		"(SELECT COUNT(id) FROM bd_paid_bribe where c_city = bd_city.Id AND approved = 1) AS BribedCount,"+ 
		"(SELECT SUM(c_amt_paid) FROM bd_paid_bribe where c_city = bd_city.Id AND approved = 1) AS BribedTotal," +
		"(SELECT AVG(c_amt_paid) FROM bd_paid_bribe where c_city = bd_city.Id AND approved = 1) AS BribedAverage," +
		"(SELECT COUNT(id) FROM bd_dint_bribe where c_city = bd_city.Id AND approved = 1) AS NotBribed, "+
		"(SELECT COUNT(id) FROM bd_dint_have_to_bribe where c_city = bd_city.Id AND approved = 1) AS NoBribe "+
		"FROM bd_city ORDER BY BribedCount DESC LIMIT 30";
	/*public static String GET_CITY_COUNT_BY_DEPT = "SELECT Id as id, city_name as name, " + 
		"(SELECT COUNT(id) FROM bd_paid_bribe where c_dept = $deptID and c_city = bd_city.Id AND approved = 1) AS BribedCount" +
		"FROM bd_city ORDER BY BribedCount DESC";*/

	// Table Name: bd_dept
	public static String GET_ALL_DEPTS = "SELECT * FROM bd_dept";
	public static String GET_DEPT_BY_ID = "SELECT * FROM bd_dept where Id=";
	public static String GET_DEPT_COUNT = "SELECT COUNT( * ) FROM " +
			"bd_dept WHERE ( SELECT COUNT( * )FROM bd_paid_bribe " +
			"WHERE c_dept = bd_dept.id AND approved =1) >0";
	public static String GET_DEPT_PAGED = "SELECT * FROM bd_dept LIMIT ";
	public static String GET_DEPT_MOST_BRIBED = "SELECT id, " +
			"abbr_dept_name as name,(SELECT COUNT(id) FROM bd_paid_bribe where " +
			"c_dept = bd_dept.id AND approved = 1) AS BribedCount, " +
			"(SELECT SUM(c_amt_paid) FROM bd_paid_bribe " +
			"where c_dept = bd_dept.id AND approved = 1) AS BribedTotal, " +
			"SELECT AVG(c_amt_paid) FROM bd_paid_bribe " +
			"where c_dept = bd_dept.id AND approved = 1) AS BribedAverage, " +
			"(SELECT COUNT(id) FROM bd_dint_bribe where c_dept = bd_dept.id AND approved = 1) AS NotBribed, " +
			"SELECT COUNT(id) FROM bd_dint_have_to_bribe where " +
			"c_dept = bd_dept.id AND approved = 1) AS NoBribe FROM bd_dept ORDER BY BribedCount " +
			"DESC LIMIT 30";
	
	// Table Name: bd_state
	public static String GET_ALL_STATES = "SELECT * FROM bd_state";
	public static String GET_STATE_BY_ID = "SELECT * FROM bd_state where Id=";
	public static String GET_STATE_COUNT = "SELECT COUNT( * ) FROM " +
			"bd_state WHERE ( SELECT COUNT( * )FROM bd_paid_bribe " +
			"WHERE c_dept = bd_state.id AND approved =1) >0";
	public static String GET_STATE_PAGED = "SELECT * FROM bd_state LIMIT ";
	
	
	
}