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
 * Servlet implementation class ForgotPasswordService
 */
public class ForgotPasswordService extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgotPasswordService() 
    {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String userName = request.getParameter("");
		String securityAns = request.getParameter("");
		Login login = Login.getInstance();
		String pass = login.forgotPassword(userName, securityAns);
		String redirectUrl = "/";
		ServletContext ctx = getServletContext();
		HttpSession session = null;
		session = request.getSession(true);
		
		if(pass==null)
		{
			session.setAttribute("ErrorMessage", "Incorrect Security Answer entered.");
			redirectUrl = "/errors/ErrorsDisplay.jsp";
		}
		else
		{
			redirectUrl = "/";
		}
		
		ctx.getRequestDispatcher(redirectUrl).forward(request, response);
	}

}
