package com.ipablive.services;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class BlogServices
 */
public class BlogServices extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BlogServices() 
    {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String type = request.getParameter("t");
		
		String typeUrl = "";
		String failureMessageUrl = "/errors/ErrorsDisplay.jsp";
		ServletContext ctx = getServletContext();
		HttpSession session = request.getSession(true);
		
		if(type!=null)
		{
			if(type.equalsIgnoreCase("news"))
			{
				typeUrl = "/news/news.jsp";
				ctx.getRequestDispatcher(typeUrl).forward(request, response);
			}else if(type.equalsIgnoreCase("blogs"))
			{
				typeUrl = "/blog/blog.jsp";
				ctx.getRequestDispatcher(typeUrl).forward(request, response);
			}else if(type.equalsIgnoreCase("videos"))
			{
				typeUrl = "/videos/videos.jsp";
				ctx.getRequestDispatcher(typeUrl).forward(request, response);
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
