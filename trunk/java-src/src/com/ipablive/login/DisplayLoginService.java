package com.ipablive.login;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DisplayLoginService
 */
public class DisplayLoginService extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayLoginService() 
    {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String type = request.getParameter("cmd");
		
		String redirectUrl = "";
		String failureMessageUrl = "/errors/ErrorsDisplay.jsp";
		ServletContext ctx = getServletContext();
		HttpSession session = request.getSession(true);
		
		if(type!=null)
		{
			if(type.equalsIgnoreCase("login"))
			{
				redirectUrl = "/login/login.jsp";
				ctx.getRequestDispatcher(redirectUrl).forward(request, response);
			}else if(type.equalsIgnoreCase("register"))
			{
				redirectUrl = "/login/registration.jsp";
				ctx.getRequestDispatcher(redirectUrl).forward(request, response);
			}else if(type.equalsIgnoreCase("forgot"))
			{
				redirectUrl = "/login/forgotPassword.jsp";
				ctx.getRequestDispatcher(redirectUrl).forward(request, response);
			}
			else if(type.equalsIgnoreCase("activate"))
			{
				redirectUrl = "/login/activateRegistration.jsp";
				ctx.getRequestDispatcher(redirectUrl).forward(request, response);
			}
			else if(type.equalsIgnoreCase("change"))
			{
				redirectUrl = "/login/changePassword.jsp";
				ctx.getRequestDispatcher(redirectUrl).forward(request, response);
			}
			else if(type.equalsIgnoreCase("user"))
			{
				redirectUrl = "/users/user.jsp";
				ctx.getRequestDispatcher(redirectUrl).forward(request, response);
			}
			else if(type.equalsIgnoreCase("admin"))
			{
				redirectUrl = "/users/admin.jsp";
				ctx.getRequestDispatcher(redirectUrl).forward(request, response);
			}
			else if(type.equalsIgnoreCase("profile"))
			{
				redirectUrl = "/users/profile.jsp";
				ctx.getRequestDispatcher(redirectUrl).forward(request, response);
			}
			else if(type.equalsIgnoreCase("logout"))
			{
				redirectUrl = "/";
				session.invalidate();
				ctx.getRequestDispatcher(redirectUrl).forward(request, response);
			}
			else
			{
				session.setAttribute("ErrorMessage", "Unable to serve your request.");
				ctx.getRequestDispatcher(failureMessageUrl).forward(request, response);
			}
			
		}
		else
		{
			session.setAttribute("ErrorMessage", "Please choose your report type.");
			ctx.getRequestDispatcher(failureMessageUrl).forward(request, response);
		}
	}

}
