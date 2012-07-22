/**
 * 
 */
package com.ipablive.core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.ipablive.datasource.ConnectionFactory;
import com.ipablive.login.RandamNumberGeneration;
import com.ipablive.utils.BribeUtils;
import com.ipablive.vo.UserVO;

/**
 * @author 
 *
 */
public class Login 
{

	Connection conn=null;
	
	 /* Here is the instance of the Singleton */
	  private static Login _loginInstance;

	  //Prevent direct access to the constructor
	  private Login() 
	  {
	    super();
	    if(conn == null)
	    {
	    	conn = ConnectionFactory.getConnection();
	    }
	  }
	  
	  public static Login getInstance() 
	  {

	    if (_loginInstance == null) 
	    {

	      synchronized(Login.class) 
	      {

	        if (_loginInstance == null) 
	        {
	        	_loginInstance = new Login();
	        }

	      }

	    }
	    
	    return _loginInstance;
	  }
	  
	  public UserVO doLogin(String userName, String password)
	  {
		  UserVO uvo = null;
		  String query = "select * from bd_users where userName='"+userName+"' AND password='"+password+"' AND activeStatus=0";
		  
		  try
		  {
			  Statement stmt = conn.createStatement();
			  ResultSet rs = stmt.executeQuery(query);
			  if(rs.next())
			  {
				  uvo = new UserVO();
				  uvo.setUserId(rs.getString(2));
				  uvo.setUserPassword(rs.getString(3));
				  uvo.setFirstName(rs.getString(4));
				  uvo.setLastName(rs.getString(5));
				  uvo.setEmail(rs.getString(6));
				  uvo.setUserRole(rs.getString(7));
				  String friendlyTime = BribeUtils.getFriendlyTime(rs.getDate(11));
				  uvo.setLastLogin(friendlyTime);
			  }
			  
		  }
		  catch(Exception e)
		  {
			  e.printStackTrace();
		  }finally
		  {
			  if( uvo != null )
			  {
				 Boolean b = updateLastLogin(userName);
			  }
		  }
		  
		  return uvo;
		  
	  }
	  
	  public Boolean doRegistration(UserVO data)
	  {
		  Boolean isInserted = false;
		  String query = "insert into bd_users (userName,password, FirstName, LastName, Email, userRole," +
		  		"ActiveStatus,createDate,RandomNumber,securityQuestion,SecurityAnswer) values (?,?,?,?,?,?,?,?,?,?,?)";
		  java.sql.Date sqlDate = new java.sql.Date(new Date().getTime());
		  
		  try
		  {
			  PreparedStatement pstmt = conn.prepareStatement(query);
			  pstmt.setString(1, data.getUserId());
			  pstmt.setString(2, data.getUserPassword());
			  pstmt.setString(3, data.getFirstName());
			  pstmt.setString(4, data.getLastName());
			  pstmt.setString(5, data.getEmail());
			  pstmt.setString(6, data.getUserRole());
			  pstmt.setInt(7, 0);
			  pstmt.setDate(8, sqlDate);
			  String randomNum = RandamNumberGeneration.randomstring(15, 20);
			  pstmt.setString(9, randomNum);
			  pstmt.setString(11, data.getSecQuestion());
			  pstmt.setString(12, data.getSecAns());
			  
			  int k = pstmt.executeUpdate();
			  if(k>0)
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
	  
	  public Boolean blockUnblockUser(String userName, int blockUnblock)
	  {
		  Boolean isBlockUnblocked = false;
		  try
		  {
			  PreparedStatement pstmt = conn.prepareStatement("update bd_users set activeStatus=? where userName=?");
			  pstmt.setInt(1, blockUnblock); // 1 - block, 0 - for unblock
			  pstmt.setString(2, userName);
			  int i = pstmt.executeUpdate();
				
			  if(i==0)
			  {
			  	  isBlockUnblocked = true;
		      }
			
		  }
		catch(Exception e)
		{
			e.printStackTrace();
		}
			
		  return isBlockUnblocked;
	  }
	  
	  
	  public Boolean updateLastLogin(String userId)
	  {
			Boolean isUpdated = false;
			java.sql.Date sqlDate = new java.sql.Date(new Date().getTime());
			
			try
			{
				PreparedStatement pstmt = conn.prepareStatement("update bd_users set lastLogin=? where userName=?");
				pstmt.setDate(1, sqlDate);
				pstmt.setString(2, userId);
				int i = pstmt.executeUpdate();
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return isUpdated;
	  }
	  
	  public Boolean changePassword(String userName, String newPassword)
	  {
			Boolean isChanged = false;
			try
			{
				PreparedStatement pstmt = conn.prepareStatement("update bd_users set password=? where userName=?");
				pstmt.setString(1, newPassword);
				pstmt.setString(2, userName);
				int i = pstmt.executeUpdate();
				
				if(i>0)
				{
					isChanged = true;
				}
				
			}
			catch(Exception e)
			{
				
				e.printStackTrace();
			}
			return isChanged;
	  }
	  
	  public String getSecurityQuestion(String userId)
	  {
		  String securityQuestion = "";
		  try
		  {
			  Statement stmt = conn.createStatement();
			  ResultSet rs = stmt.executeQuery("select SecurityQuestion from bd_users where userName='"+userId+"'");
			  if(rs.next())
			  {
				  securityQuestion = rs.getString(1);;
			  }
		  }
		  catch(Exception e)
		  {
			  e.printStackTrace();
		  }
		  
		  return securityQuestion;
	  }
	  
	  public String forgotPassword(String userId, String ans)
	  {
		  String password = null;
		  try
		  {
			  Statement stmt = conn.createStatement();
			  ResultSet rs = stmt.executeQuery("select password from bd_users where userName='"+userId+"' AND securityAns='"+ans+"'");
			  if(rs.next())
			  {
				  password = rs.getString(1);
			  }
		  }
		  catch(Exception e)
		  {
			  e.printStackTrace();
		  }
		  
		  return password;
	  }
		
	  
	  public Boolean checkUserIdExists(String userId)
		{
			Boolean isExists = true;
			try
			{
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("select userName from bd_users where userName='"+userId+"'");
				if(rs.next())
				{
					isExists = true;
				}
				else
				{
					isExists = false;
				}
			}catch(Exception e)
			{
				isExists = true;
				e.printStackTrace();
			}
			return isExists;
		}
		
		public Boolean checkEmailExists(String email)
		{
			Boolean isExists = true;

			try
			{
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("select email from bd_users where email='"+email+"'");
				if(rs.next())
				{
					isExists = true;
				}
				else
				{
					isExists = false;
				}
			}catch(Exception e)
			{
				isExists = true;
				e.printStackTrace();
			}
			return isExists;
		}
		
		public String doActivation(String userName,String email, String activeCode)
		{
			String isActivated = null;
			
			try
			{
				String random = "";
				Statement stmt = conn.createStatement();
				PreparedStatement pstmt;
				String query = "select activationdate,activestatus,email,userName from bd_users where randomnumber='"
					+ activeCode.trim()+ "' AND email='"+email+"'";

				ResultSet rs = stmt.executeQuery(query);
				Calendar now1 = Calendar.getInstance();
				Calendar now = Calendar.getInstance();
				SimpleDateFormat dayformat = new SimpleDateFormat("dd/mm/yyyy");
				java.util.Date d = new java.util.Date();

				String date = null;
				java.util.Date d1 = null;
				
				if (rs.next()) {
					java.util.Date d2 = (java.util.Date)rs.getDate(1);
					if(d2==null) d2 = new java.util.Date();
					date = dayformat.format(d2);
					email = rs.getString(3);
					d1 = new java.util.Date(date + " " + rs.getTime(1));
					now1.setTime(d1);
					pstmt = conn.prepareStatement("update bd_users set activeStatus=?,activationdate=? where randomnumber=?");
					pstmt.setString(1,"0");
					pstmt.setString(2, getCurrentDate());
					pstmt.setString(3, activeCode.trim());

					long h = (now.getTime().getTime()) - (now1.getTime().getTime());
					long t = h / (60 * 1000);
					if (t <= 1440) {
						System.out.println(rs.getString(2) + "  ");
						if (rs.getString(2).equals("0")) 
						{
							//User Already activated.
							isActivated = "User Already activated";
						} else 
						{
							int i = pstmt.executeUpdate();
							if (i == 1) 
							{
								//activated
								isActivated = "activated";
							}
						}
					} else {

						if (rs.getBoolean(2)) {
							isActivated = "This user is already active";
						} else {
							pstmt = conn.prepareStatement("delete from bd_users where randomnumber=?");
							pstmt.setString(1, activeCode.trim());
							int i = pstmt.executeUpdate();
							//Activation has expired and user details deleted.
							isActivated = "Activation has expired and user details deleted.";
						}
					}
				}else
				{
					//The activation you entered is wrong. Please check and try again."
					System.out.println("The activation you entered is wrong. Please check and try again.");
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			return isActivated;
		}
		
		private static String getCurrentDate() 
		{
			// TODO Auto-generated method stub
			java.util.Date currentDate = new java.util.Date();

			java.sql.Date sqlDate = new java.sql.Date(currentDate.getTime());
			// System.out.println("date"+sqlDate);

			return sqlDate + " " + currentDate.getHours() + ":"
					+ currentDate.getMinutes() + ":" + currentDate.getSeconds()
					+ ".0";
		}
		
	
}
