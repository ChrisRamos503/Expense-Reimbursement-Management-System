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
import com.revature.pojo.User;

@WebServlet("/UpdateReimbursement")
public class UpdateReimbursementServlet extends HttpServlet{
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = req.getSession();
		
		List<Reimbursement> list = (List<Reimbursement>) session.getAttribute("pend_list");
		User user = (User) session.getAttribute("user");
		DAOReimbursement daor = new DAOReimbursement();
		
		long res_id = user.getId();
		//Integer size_c = (Integer) session.getAttribute("size");
		int size = list.size();    //size_c.intValue();
		
		System.out.println("user_id = " + res_id);
		System.out.println("user_id = " + res_id);
		
		for(int i = 0; i < size; i++){
			
			
			//System.out.println("user_id = " + res_id);
			//System.out.println("in for loop");
			// retrieve choice from select tags 
			
			String s = req.getParameter(Integer.toString(i));
			//System.out.println("String s = " + s);
			//System.out.println("String parameter retrieved");
			
			// for parsing names to get index of list
			
			int status;
			try{
				status = Integer.parseInt(s);
			}catch(NumberFormatException n){
				n.printStackTrace();
				status = 1;
			}
			//System.out.println("successfully parsed");
			System.out.println("status = " + status);
			
			Reimbursement r = list.get(i);
			
//			System.out.println("status = " + status);
			
			r.setStatus(status);
			
			System.out.println(r);
			if(r.getStatus() != 1){
				r.setResolver((int) user.getId());
				System.out.println(r);
				daor.updateReimbursementRequest(r, res_id);
			}
			System.out.println();
		}
		
		System.out.println("all pending requests have been updated");
		
		
		session.removeAttribute("pend_list");
		resp.sendRedirect("managerHomepage.jsp");
		
	}
	

}
