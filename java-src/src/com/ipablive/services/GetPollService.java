package com.ipablive.services;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class GetPollService
 */
public class GetPollService extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetPollService() 
    {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String cmd = request.getParameter("cmd");
		String pollUrl = "";
		String failureMessageUrl = "/errors/ErrorsDisplay.jsp";
		ServletContext ctx = getServletContext();
		HttpSession session = request.getSession(true);
		
		if(cmd.equalsIgnoreCase("today"))
		{
			pollUrl = "/polls/todayPoll.jsp";
			ctx.getRequestDispatcher(pollUrl).forward(request, response);
		}else
		{
			session.setAttribute("ErrorMessage", "Please choose your request type.");
			ctx.getRequestDispatcher(failureMessageUrl).forward(request, response);
		}
		
	}

}
