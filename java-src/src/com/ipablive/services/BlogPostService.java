package com.ipablive.services;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipablive.core.Blogs;
import com.ipablive.utils.BribeUtils;
import com.ipablive.vo.BlogPostVO;

/**
 * Servlet implementation class BlogPostService
 */
public class BlogPostService extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BlogPostService() 
    {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
												throws ServletException, IOException 
	{
		String name = request.getParameter("name");
		String subject = request.getParameter("subject");
		String postContent = request.getParameter("postContent");
		String supportURL = request.getParameter("supportURL");
		
		BlogPostVO bpVo = new BlogPostVO();
		bpVo.setPostTitle(subject);
		bpVo.setPostContent(postContent);
		bpVo.setDestURL(supportURL);
		bpVo.setPostedBy(name);
		String ip = BribeUtils.getClientIpAddr(request);
		bpVo.setIpAddress(ip);
		bpVo.setPostApproval(0); //as of now its approved(0). admin has to approve it in future.
		
		Blogs blog = Blogs.getInstance();
		
		Boolean isStored = blog.storeBlogPost(bpVo);
		ServletContext ctx = getServletContext();
		String contextRoot = request.getContextPath();
		
		String successURL = contextRoot+"/blog/blog.jsp";
		String failureURL = contextRoot+"/errors/ErrorsDisplay.jsp";
		
		if(isStored)
		{
			ctx.getRequestDispatcher(successURL).forward(request, response);
		}else
		{
			ctx.getRequestDispatcher(failureURL).forward(request, response);
		}
		
	}

}
