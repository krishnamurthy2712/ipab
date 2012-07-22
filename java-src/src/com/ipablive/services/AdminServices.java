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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String cmd = request.getParameter("cmd");
		String redirectURL = "";
		ServletContext ctx = getServletContext();
		
		if(cmd.equalsIgnoreCase("blogs"))
		{
			redirectURL = "";
		}
		else if(cmd.equalsIgnoreCase("newPost"))
		{
			redirectURL = "";
		}
		else if(cmd.equalsIgnoreCase("news"))
		{
			redirectURL = "";
		}
		else if(cmd.equalsIgnoreCase("new"))
		{
			redirectURL = "";
		}
		else if(cmd.equalsIgnoreCase("polls"))
		{
			redirectURL = "";
		}
		else if(cmd.equalsIgnoreCase("newpoll"))
		{
			redirectURL = "";
		}
		else if(cmd.equalsIgnoreCase("videos"))
		{
			redirectURL = "";
		}
		else 
		{
			redirectURL = "/errors/ErrorsDisplay.jsp";
		}
		
		ctx.getRequestDispatcher(redirectURL).forward(request, response);
		
	}

}
