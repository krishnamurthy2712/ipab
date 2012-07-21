/**
 * 
 */
package com.ipablive.vo;

/**
 * @author 
 *
 */
public class UserVO 
{
	private String userId;
	private String userPassword;
	private String firstName;
	private String lastName;
	private String userRole;
	private String email;
	private String lastLogin;
	private String secQuestion;
	private String secAns;
	
	public String getUserId() 
	{
		return userId;
	}
	public void setUserId(String userId)
	{
		this.userId = userId;
	}
	
	public String getUserPassword() 
	{
		return userPassword;
	}
	public void setUserPassword(String userPassword) 
	{
		this.userPassword = userPassword;
	}
	
	public String getFirstName() 
	{
		return firstName;
	}
	public void setFirstName(String firstName) 
	{
		this.firstName = firstName;
	}
	
	public String getLastName() 
	{
		return lastName;
	}
	public void setLastName(String lastName) 
	{
		this.lastName = lastName;
	}
	
	public String getUserRole() 
	{
		return userRole;
	}
	public void setUserRole(String userRole) 
	{
		this.userRole = userRole;
	}
	
	public String getEmail() 
	{
		return email;
	}
	public void setEmail(String email) 
	{
		this.email = email;
	}
	
	public String getLastLogin() 
	{
		return lastLogin;
	}
	public void setLastLogin(String lastLogin)
	{
		this.lastLogin = lastLogin;
	}
	
	public String getSecQuestion() 
	{
		return secQuestion;
	}
	public void setSecQuestion(String secQuestion) 
	{
		this.secQuestion = secQuestion;
	}
	
	public String getSecAns() 
	{
		return secAns;
	}
	public void setSecAns(String secAns) 
	{
		this.secAns = secAns;
	}
	
}
