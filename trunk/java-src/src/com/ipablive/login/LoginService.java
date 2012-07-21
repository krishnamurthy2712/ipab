package com.ipablive.login;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipablive.core.Login;
import com.ipablive.vo.UserVO;

/**
 * Servlet implementation class LoginService
 */
public class LoginService extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginService() 
    {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		Login login = Login.getInstance();
		
		String redirectUrl = "";
		String failureMessageUrl = "/errors/ErrorsDisplay.jsp";
		ServletContext ctx = getServletContext();
		HttpSession session = null;
		session = request.getSession(true);
		
		if(userName != null && password != null)
		{
			UserVO user = login.doLogin(userName, password);
			
			if(user==null)
			{
				session.setAttribute("ErrorMessage", "Incorrect username/password.");
				redirectUrl = failureMessageUrl;
			}
			else
			{
				session.setAttribute("loggedInUser", user);
				redirectUrl = "/";
			}
			
			ctx.getRequestDispatcher(redirectUrl).forward(request, response);
		}
		else
		{
			session.setAttribute("ErrorMessage", "Please choose your report-comment type.");
			ctx.getRequestDispatcher(failureMessageUrl).forward(request, response);
		}
		
	}

}
