package com.ipablive.services;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipablive.core.IPaidBribe;
import com.ipablive.utils.BribeUtils;
import com.ipablive.vo.IPaidComplaintVO;

/**
 * Servlet implementation class IPaidService
 */
public class IPaidService extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IPaidService() 
    {
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("deprecation")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String cCity = request.getParameter("cCity");
		String cDept = request.getParameter("cDept");
		String cTransactions = request.getParameter("cTransactions");
		String c_amt_paid = request.getParameter("c_amt_paid");
		String c_date_paid = request.getParameter("c_date_paid");
		String office_location = request.getParameter("office_location");
		String c_bribe_type = request.getParameter("c_bribe_type");
		String c_payment_method = request.getParameter("c_payment_method");
		String c_name = request.getParameter("c_name");
		String c_addi_info = request.getParameter("c_addi_info");
		String others_dept = request.getParameter("otherDept");
		String others_transaction = request.getParameter("othersTransaction");
		String ip = BribeUtils.getClientIpAddr(request);
		
		Date result = new Date();
		SimpleDateFormat formatter;
		try 
		{
			formatter = new SimpleDateFormat("dd-mm-yyyy");
			result = (Date) formatter.parse(c_date_paid);
			
		} catch (ParseException e) 
		{
			e.printStackTrace();
		}

		IPaidBribe iPaid = IPaidBribe.getInstance();
		IPaidComplaintVO ipVO = new IPaidComplaintVO();
		ipVO.setCCity(cCity);
		ipVO.setCName(c_name);
		ipVO.setCDept(cDept);
		ipVO.setOtherDept(others_dept);
		ipVO.setCTransaction(cTransactions);
		ipVO.setOtherTransaction(others_transaction);
		ipVO.setCAmtPaid(Integer.parseInt(c_amt_paid));
		ipVO.setCPaymentMethod(c_payment_method);
		ipVO.setCBribeType(c_bribe_type);
		ipVO.setCDatePaid(result);
		ipVO.setOfficeLocation(office_location);
		ipVO.setCAddiInfo(c_addi_info);
		ipVO.setIpAddress(ip);
		
		Boolean isSuccess = iPaid.storePaidBribeComplaint(ipVO);
		ServletContext context = getServletContext();
		
		if(isSuccess)
		{
			context.getRequestDispatcher("/tellbribestory/ComplaintRegistred.jsp").forward(request, response);
		}else
		{
			context.getRequestDispatcher("/errors/ErrorsDisplay.jsp").forward(request, response);
		}
	}
	
	private java.sql.Date modifyDateLayout(String inputDate){
        try {
            //inputDate = "2010-01-04 01:32:27 UTC";
        	SimpleDateFormat ts= new SimpleDateFormat("yyyy-MM-dd");
        	java.sql.Date sqlToday = new java.sql.Date(ts.parse(inputDate).getTime());
            return sqlToday;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }


}
