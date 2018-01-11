package com.revature.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.DAOUser;
import com.revature.pojo.User;


@WebServlet("/getEmployees")
public class GetEmployeesServlet extends HttpServlet{

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	super.doPost(req, resp);
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		
		
		if(user != null && user.getUserRole() == 1){
			
			DAOUser daou = new DAOUser();
			
			List<User> emp_list = daou.getAllEmployees();
			
			session.setAttribute("emp_list",emp_list);
			
			
			resp.sendRedirect("viewEmployees.jsp");
			
		}else{
			
			resp.sendRedirect("error.jsp");
		}
		
		
	}
	
	
	
}
