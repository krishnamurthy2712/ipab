package com.ipablive.services;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipablive.core.IDidnotPaid;
import com.ipablive.utils.BribeUtils;
import com.ipablive.vo.DidNotPaidBribesVO;
import com.ipablive.vo.IDidnotPaidComplaintVO;

/**
 * Servlet implementation class IDidnotPaidService
 */
public class IDidnotPaidService extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IDidnotPaidService() 
    {
        
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String cCity = request.getParameter("cCity");
		String cDept = request.getParameter("cDept");
		String cTransactions = request.getParameter("cTransactions");
		String c_bribe_resisted_by = request.getParameter("c_bribe_resisted_by");
		String c_bribe_type = request.getParameter("c_bribe_type");
		String c_name = request.getParameter("c_name");
		String c_addi_info = request.getParameter("c_addi_info");
		String others_dept = request.getParameter("otherDept");
		String others_transaction = request.getParameter("otherTransaction");
		String ip = BribeUtils.getClientIpAddr(request);
		
		IDidnotPaid iDidNtPaid = IDidnotPaid.getInstance();
		
		IDidnotPaidComplaintVO dpbVO = new IDidnotPaidComplaintVO();
		dpbVO.setCCity(cCity);
		dpbVO.setCDept(cDept);
		dpbVO.setCTransaction(cTransactions);
		dpbVO.setCBribeResistedBy(c_bribe_type);
		dpbVO.setCBribeResistedBy(c_bribe_resisted_by);
		dpbVO.setOtherDept(others_dept);
		dpbVO.setOtherTransaction(others_transaction);
		dpbVO.setCName(c_name);
		dpbVO.setCAddiInfo(c_addi_info);
		dpbVO.setIpAddress(ip);
		
		Boolean isSuccess = iDidNtPaid.storeDidNotPaidComplaint(dpbVO);
		
		ServletContext context = getServletContext();
		
		if(isSuccess)
		{
			context.getRequestDispatcher("/tellbribestory/ComplaintRegistred.jsp").forward(request, response);
		}else
		{
			context.getRequestDispatcher("/errors/ErrorsDisplay.jsp").forward(request, response);
		}
		
	}

}
