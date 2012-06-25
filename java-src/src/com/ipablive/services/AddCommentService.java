package com.ipablive.services;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipablive.core.Blogs;
import com.ipablive.utils.BribeUtils;
import com.ipablive.vo.BlogCommentVO;

/**
 * Servlet implementation class AddCommentService
 */
public class AddCommentService extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCommentService() 
    {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws 
										ServletException, IOException 
	{
		String name = request.getParameter("name");
		String subject = request.getParameter("subject");
		String comment = request.getParameter("comment");
		String supportURL = request.getParameter("supportURL");
		String pid = request.getParameter("postId");
		
		int postId = Integer.parseInt(pid);
		
		BlogCommentVO commentVo = new BlogCommentVO();
		commentVo.setPostId(postId);
		commentVo.setCommentTitle(subject);
		commentVo.setCommentContent(comment);
		commentVo.setSupportURL(supportURL);
		String ip = BribeUtils.getClientIpAddr(request);
		commentVo.setIpAddress(ip);
		commentVo.setCreatedBy(name);
		commentVo.setApproval(0);
		
		Blogs blog = Blogs.getInstance();
		Boolean isStored = blog.storeBlogComment(commentVo);
		ServletContext ctx = getServletContext();
		
		if(isStored)
		{
			ctx.getRequestDispatcher("/blogPostDetails.jsp").forward(request, response);
		}else
		{
			ctx.getRequestDispatcher("./errors/ErrorsDisplay.jsp").forward(request, response);
		}
		
	}

}
