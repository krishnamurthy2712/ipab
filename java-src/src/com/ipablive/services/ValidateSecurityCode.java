package com.ipablive.services;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipablive.core.CaptchaServlet;

/**
 * Servlet implementation class ValidateSecurityCode
 */
public class ValidateSecurityCode extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidateSecurityCode() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String code = request.getParameter("code");
		String generatedCode = (String) request.getAttribute(CaptchaServlet.CAPTCHA_KEY);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		if(code.equals(generatedCode))
		{
			out.println("");
			System.out.println("Security code validated.");
		}
		else
		{
			out.println("Please enter valid code.");
			System.out.println("Error in validating security code.");
		}
	}

}
