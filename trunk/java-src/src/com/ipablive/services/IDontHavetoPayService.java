package com.ipablive.services;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipablive.core.IDontHavetoPay;
import com.ipablive.vo.DidnotHaveToPayComplaintVO;

/**
 * Servlet implementation class IDontHavetoPayService
 */
public class IDontHavetoPayService extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IDontHavetoPayService() 
    {
        super();
        // TODO Auto-generated constructor stub
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
		String others_dept = request.getParameter("others_dept");
		String others_transaction = request.getParameter("others_transaction");
		
		IDontHavetoPay idP = IDontHavetoPay.getInstance();
		DidnotHaveToPayComplaintVO didntHaveToPay = new DidnotHaveToPayComplaintVO();
		
		didntHaveToPay.setCCity(cCity);
		didntHaveToPay.setCDept(cDept);
		didntHaveToPay.setCTransaction(cTransactions);
		didntHaveToPay.setCBribeType(c_bribe_type);
		didntHaveToPay.setCBribeResistedBy(c_bribe_resisted_by);
		didntHaveToPay.setCName(c_name);
		didntHaveToPay.setCAddiInfo(c_addi_info);
		didntHaveToPay.setOtherDept(others_dept);
		didntHaveToPay.setOtherTransaction(others_transaction);
		
		Boolean isSuccess = idP.storeDintHaveToPayBribeComplaint(didntHaveToPay);
		
		ServletContext context = getServletContext();
		
		if(isSuccess)
		{
			context.getRequestDispatcher("/readbribestory/donthavetopaid.jsp").forward(request, response);
		}else
		{
			context.getRequestDispatcher("/errors/ErrorsDisplay.jsp").forward(request, response);
		}
		
	}

}
