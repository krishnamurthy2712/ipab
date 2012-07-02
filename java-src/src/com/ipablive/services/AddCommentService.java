package com.ipablive.services;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipablive.core.VoteComments;
import com.ipablive.utils.BribeUtils;
import com.ipablive.vo.CommentVO;

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

    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String type = request.getParameter("type");
		String type_id = request.getParameter("type_id");
		String subject = request.getParameter("subject");
		String comment = request.getParameter("comment");
		String ip = BribeUtils.getClientIpAddr(request);
		
		int postId = Integer.parseInt(type_id);
		CommentVO data = new CommentVO();
		data.setSubject(subject);
		data.setComment(comment);
		
		VoteComments vComments = VoteComments.getInstance();
		Boolean isStored = vComments.storeVoteComments(data, type , postId, ip);
		
		ServletContext ctx = getServletContext();
		String contextRoot = request.getContextPath();
		String successURL = contextRoot;
		String failureURL = contextRoot+"/errors/ErrorsDisplay.jsp";
		
		if(isStored)
		{
			if(type.equalsIgnoreCase("paid"))
			{
				successURL = contextRoot+"/readbribestory/ipaid.jsp";
			}
			else if(type.equalsIgnoreCase("notpaid"))
			{
				successURL = contextRoot+"/readbribestory/ididnotpaid.jsp";
			}
			else if(type.equalsIgnoreCase("dinthvtopay"))
			{
				successURL = contextRoot+"/readbribestory/donthavetopaid.jsp";
			}
			
			ctx.getRequestDispatcher(successURL).forward(request, response);
		}
		else
		{
			ctx.getRequestDispatcher(failureURL).forward(request, response);
		}
		
	}

}
