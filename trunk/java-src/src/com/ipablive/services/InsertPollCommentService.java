package com.ipablive.services;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipablive.core.Polls;
import com.ipablive.utils.BribeUtils;
import com.ipablive.vo.PollCommentsVO;

/**
 * Servlet implementation class InsertPollCommentService
 */
public class InsertPollCommentService extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertPollCommentService() 
    {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String poll = request.getParameter("p");
		String user = request.getParameter("u");
		String comment = request.getParameter("c");
		
		int pollId = Integer.parseInt(poll);
		String ipAddress = BribeUtils.getClientIpAddr(request);
		
		Polls pollObj = Polls.getInstance();
		PollCommentsVO pvo = new PollCommentsVO();
		
		pvo.setComment(comment);
		pvo.setCommentedBy(user);
		pvo.setIpAddress(ipAddress);
		pvo.setPollId(pollId);
		
		Boolean isInserted = pollObj.insertPollComment(pvo);
		ServletContext ctx = getServletContext();
		String contextRoot = request.getContextPath();
		String successURL = contextRoot;
		
		if(isInserted)
		{
			ctx.getRequestDispatcher(successURL).forward(request, response);
		}else
		{
			PrintWriter pw = response.getWriter();
			pw.write("Unable to insert comment");
		}
		
		
	}

}
