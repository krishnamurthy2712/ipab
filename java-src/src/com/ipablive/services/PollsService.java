package com.ipablive.services;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipablive.core.Polls;
import com.ipablive.utils.BribeUtils;
import com.ipablive.vo.PollVO;

/**
 * Servlet implementation class PollsService
 */
public class PollsService extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PollsService() 
    {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String pollTitle = request.getParameter("pollTitle");
		String pollDescription = request.getParameter("pollDescription");
		String pollQuestion = request.getParameter("pollQuestion");
		String pollOptions = request.getParameter("pollOptions");
		String createdBy = request.getParameter("createdBy");
		String ip = BribeUtils.getClientIpAddr(request);
		
		Polls pol = Polls.getInstance();
		PollVO data = new PollVO();
		data.setPollTitle(pollTitle);
		data.setPollDescription(pollDescription);
		data.setPollQuestion(pollQuestion);
		data.setPollOptions(pollOptions);
		data.setPollCreationBy(createdBy);
		data.setIpAddress(ip);
		
		Boolean b = pol.insertPoll(data);
		ServletContext ctx = getServletContext();
		String redirectURL = "";
		
		if(b)
		{
			redirectURL = "/polls/admin/polls.jsp";
		}
		else
		{
			redirectURL = "/errors/ErrorsDisplay.jsp";
		}
		
		ctx.getRequestDispatcher(redirectURL).forward(request, response);
	}

}
