package com.ipablive.services;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipablive.core.Home;
import com.ipablive.utils.BribeUtils;
import com.ipablive.vo.NewsVO;

/**
 * Servlet implementation class NewsService
 */
public class NewsService extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewsService() 
    {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String newsTitle = request.getParameter("newsTitle");
		String newsBody = request.getParameter("newsBody");
		String newsUrl = request.getParameter("newsURL");
		String ip = BribeUtils.getClientIpAddr(request);
		
		Home home = Home.getInstance();
		NewsVO data = new NewsVO();
		data.setNewsTitle(newsTitle);
		data.setNewsBody(newsBody);
		data.setNewsDst(newsUrl);
		data.setIpAddress(ip);
		data.setNewsCreated("admin");
		
		Boolean b = home.insertNews(data);
		ServletContext ctx = getServletContext();
		String redirectURL = "";
		
		if(b)
		{
			redirectURL = "/news/admin/news.jsp";
		}
		else
		{
			redirectURL = "/errors/ErrorsDisplay.jsp";
		}
		
		ctx.getRequestDispatcher(redirectURL).forward(request, response);
		
	}

}
