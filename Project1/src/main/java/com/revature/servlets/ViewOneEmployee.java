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
import com.revature.dao.DAOUser;
import com.revature.pojo.Reimbursement;
import com.revature.pojo.User;


@WebServlet("/viewOneEmployee")
public class ViewOneEmployee extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("ViewOneEmployeeServlet: one employee's reimbursements coming up");
		
		// need to get this with id of input tag, not name
		
		String s = (String) req.getParameter("h_id_text");
		System.out.println(s);
		
		String s2 = (String) req.getParameter("h_id");
		System.out.println(s2);
		
		Long h_id = (Long) Long.parseLong( (String) req.getParameter("h_id"));
		System.out.println(h_id);
		
		DAOUser daou = new DAOUser();
		DAOReimbursement daor = new DAOReimbursement();
		
		User u = daou.getUserById(h_id);
		List<Reimbursement> list = daor.getAllEmployeeReimbursements(h_id);
		
		
		HttpSession session = req.getSession();
		
		session.setAttribute("emp_req_list", list);
		session.setAttribute("emp_user", u);
		
		System.out.println("ViewOneEmployee Servlet: about to redirect");
		
		// make a page for viewing employees
		resp.sendRedirect("viewOneEmployeesRequests.jsp");
		
		
	}

}
