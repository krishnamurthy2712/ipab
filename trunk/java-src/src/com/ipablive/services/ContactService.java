package com.ipablive.services;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipablive.utils.BribeUtils;

/**
 * Servlet implementation class ContactService
 */
public class ContactService extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContactService() 
    {
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String name = request.getParameter("name");
		String mail = request.getParameter("mail");
		String subject = request.getParameter("subject");
		String message = request.getParameter("message");
		String ip = BribeUtils.getClientIpAddr(request);
		
		ServletContext context = getServletContext();
		context.getRequestDispatcher("/contactsuccess.jsp").forward(request, response);
	}

}
