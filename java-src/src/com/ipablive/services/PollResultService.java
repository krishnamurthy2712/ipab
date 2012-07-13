package com.ipablive.services;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipablive.core.Polls;
import com.ipablive.utils.BribeUtils;
import com.ipablive.vo.PollResultVO;

/**
 * Servlet implementation class PollResultService
 */
public class PollResultService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PollResultService() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String selectedOption = request.getParameter("pollOption");
		String poll = request.getParameter("pollId");
		String pollCreatedBy = request.getParameter("pollUser");
		String ipAddress = BribeUtils.getClientIpAddr(request);
		
		PollResultVO prVo = new PollResultVO();
		
		prVo.setCreatedBy(pollCreatedBy);
		prVo.setPollOption(selectedOption);
		prVo.setPollId(Integer.parseInt(poll));
		prVo.setIpAddress(ipAddress);
		
		Polls pol = Polls.getInstance();
		
		String pollUrl = "";
		ServletContext ctx = getServletContext();
		
		Boolean polled = pol.isPolled(ipAddress); 
		
		if(polled)
		{
			pollUrl = "/polls/pollResult.jsp";
			ctx.getRequestDispatcher(pollUrl).forward(request, response);
		}else
		{
			Boolean b = pol.insertPollResults(prVo); 
			if(b)
			{
				pollUrl = "/polls/pollResult.jsp";
				ctx.getRequestDispatcher(pollUrl).forward(request, response);
			}else
			{
				PrintWriter pw = response.getWriter();
				pw.println("Unable to process your request.");
				
			}
		}
			
		
	}

}
