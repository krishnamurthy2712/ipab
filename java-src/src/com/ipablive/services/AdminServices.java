package com.ipablive.services;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminServices
 */
public class AdminServices extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServices() 
    {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String cmd = request.getParameter("cmd");
		String redirectURL = "";
		ServletContext ctx = getServletContext();
		
		if(cmd.equalsIgnoreCase("blogs"))
		{
			redirectURL = "/blog/admin/blogAdmin.jsp";
		}
		else if(cmd.equalsIgnoreCase("newPost"))
		{
			redirectURL = "/blog/admin/newPost.jsp";
		}
		else if(cmd.equalsIgnoreCase("news"))
		{
			redirectURL = "/news/admin/news.jsp";
		}
		else if(cmd.equalsIgnoreCase("new"))
		{
			redirectURL = "/news/admin/newPost.jsp";
		}
		else if(cmd.equalsIgnoreCase("polls"))
		{
			redirectURL = "/polls/admin/polls.jsp";
		}
		else if(cmd.equalsIgnoreCase("newpoll"))
		{
			redirectURL = "/polls/admin/AddPoll.jsp";
		}
		else if(cmd.equalsIgnoreCase("videos"))
		{
			redirectURL = "/videos/videos.jsp";
		}
		else 
		{
			redirectURL = "/errors/ErrorsDisplay.jsp";
		}
		
		ctx.getRequestDispatcher(redirectURL).forward(request, response);
		
	}

}
