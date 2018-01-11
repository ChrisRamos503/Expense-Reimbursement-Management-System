package com.revature.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.DAOReimbursement;
import com.revature.pojo.Reimbursement;
import com.revature.pojo.ReimbursementAug;
import com.revature.pojo.User;

@WebServlet("/ResolvedRequests")
public class ResolvedRequestsServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println();
		
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		DAOReimbursement daor = new DAOReimbursement();
		
		if(user == null){
			System.out.println("user is NULL");
			resp.sendRedirect("error.jsp");
			
		}
		
		System.out.println("whooo hoooo user is NOT NULL");
		// if user is employee
		if(user.getUserRole() == 2L){
			
			//will be put into pending jsp
			
			//while(rs.next()){
			//temp_val = rs.getDouble(1);
			System.out.println("retrieving employee RESOLVED requests");
			
			List<Reimbursement> list =  daor.getAllEmployeeResolvedReimbursements(user.getId());
			System.out.println("Ladies and gentlemen, we have a list of RESOLVED requests");
			
			if(list == null){
				resp.sendRedirect("error.jsp");
				System.out.println("list is NULL");
			}else{
				
				System.out.println("employee resolved requests not null");
				session.setAttribute("list", list);
				resp.sendRedirect("EmployeeResolvedRequests.jsp");
			}
		}else{ // user is boss
			
			List<ReimbursementAug> resolved_list = daor.AllResolvedRequests();
			
			session.setAttribute("resolved_list", resolved_list);
			resp.sendRedirect("allResolvedRequests.jsp");
			
		}
		
		
		
	}
	
}
