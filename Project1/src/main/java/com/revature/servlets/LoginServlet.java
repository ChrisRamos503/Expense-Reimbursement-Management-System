package com.revature.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.DAOUser;
import com.revature.pojo.User;
import com.revature.util.BusinessUtil;

public class LoginServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		DAOUser daou = new DAOUser();
		BusinessUtil bu = new BusinessUtil();
		
		User user = daou.getUserByUsernameAndPass(username, password);
				
		if (user == null || bu.fieldsEmpty(new String[]{username, password}) ){
			resp.sendRedirect("login.jsp");
		}else{
			
			HttpSession session = req.getSession();
			session.setAttribute("user", user);
			session.setAttribute("bu", bu);
			
			if(user.getUserRole() == 1L){
				System.out.println("Boss here");
				RequestDispatcher rd = req.getRequestDispatcher("managerHomepage.jsp");
				
				rd.forward(req, resp);
				
			}else{
				System.out.println("Employee right here (he says meekly)");
				RequestDispatcher rd = req.getRequestDispatcher("employeeHompage.jsp");
				
				rd.forward(req, resp);
			}
			
		}
		
		
		
	}

}
