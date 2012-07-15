package com.ipablive.services;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class FilterService
 */
public class FilterService extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FilterService() 
    {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String bribeType = request.getParameter("t");
		String bribeTypeUrl = "";
		String failureMessageUrl = "/errors/ErrorsDisplay.jsp";
		
		ServletContext ctx = getServletContext();
		HttpSession session = request.getSession(true);
		
		if(bribeType!=null)
		{
			if(bribeType.equalsIgnoreCase("paid"))
			{
				bribeTypeUrl = "/readbribestory/ipaidFiltered.jsp";
				ctx.getRequestDispatcher(bribeTypeUrl).forward(request, response);
			}else if(bribeType.equalsIgnoreCase("notpaid"))
			{
				bribeTypeUrl = "/readbribestory/ididnotpaidFiltered.jsp";
				ctx.getRequestDispatcher(bribeTypeUrl).forward(request, response);
			}else if(bribeType.equalsIgnoreCase("notasked"))
			{
				bribeTypeUrl = "/readbribestory/donthavetopaidFiltered.jsp";
				ctx.getRequestDispatcher(bribeTypeUrl).forward(request, response);
			}else
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
