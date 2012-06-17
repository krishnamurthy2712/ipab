package com.ipablive.services;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipablive.core.RegisterForUpdates;
import com.ipablive.utils.BribeUtils;

/**
 * Servlet implementation class RegisterUpdatesServices
 */
public class RegisterUpdatesServices extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterUpdatesServices() 
    {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String email = request.getParameter("email");
		String ip = BribeUtils.getClientIpAddr(request);
		
		RegisterForUpdates reg = RegisterForUpdates.getInstance();
		
		Boolean isBoolean = reg.registerForUpdates(email, ip);
		ServletContext context = getServletContext();
		
		if(isBoolean)
		{
			context.getRequestDispatcher("/registerupdatessuccess.jsp").forward(request, response);
		}else
		{
			context.getRequestDispatcher("/errors/ErrorDisplay.jsp").forward(request, response);
		}
		
	}

}
