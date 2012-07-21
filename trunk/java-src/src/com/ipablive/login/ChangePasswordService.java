package com.ipablive.login;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipablive.core.Login;

/**
 * Servlet implementation class ChangePasswordService
 */
public class ChangePasswordService extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePasswordService() 
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
		String newPassword = request.getParameter("newPassword");
		Login login = Login.getInstance();
		String redirectUrl = "";
		Boolean isChanged = login.changePassword(userName, newPassword);
		
		ServletContext ctx = getServletContext();
		HttpSession session = request.getSession(true);
		
		if(isChanged)
		{
			redirectUrl = "/user/profile.jsp";
		}
		else
		{
			session.setAttribute("ErrorMessage", "Unable to change your password.");
			redirectUrl = "/errors/ErrorsDisplay.jsp";
		}
		
		ctx.getRequestDispatcher(redirectUrl).forward(request, response);
		
	}

}
