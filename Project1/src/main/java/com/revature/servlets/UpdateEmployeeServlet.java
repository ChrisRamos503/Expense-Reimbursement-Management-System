package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.DAOUser;
import com.revature.pojo.User;
import com.revature.util.BusinessUtil;

/*
  <servlet>
  	<servlet-name>updateEmployee</servlet-name>
  	<servlet-class>com.revature.servlets.UpdateEmployeeServlet</servlet-class>
  </servlet>
  
  <servlet-mapping>
  	<servlet-name>updateEmployee</servlet-name>
  	<url-pattern>"/updateEmployee"</url-pattern>
  </servlet-mapping>
  
  
 */


public class UpdateEmployeeServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		System.out.println("doPost was called");
		
		HttpSession session = req.getSession();
		
		String username = req.getParameter("username").trim();
		String password = req.getParameter("password").trim();
		String firstname = req.getParameter("firstname").trim();
		String lastname = req.getParameter("lastname").trim();
		String email = req.getParameter("email").trim();
		
		BusinessUtil bu = new BusinessUtil();
		
		
		if( !(bu.isEmail(email)) ){
			session.setAttribute("exception", "invalid email" );
			resp.sendRedirect("error.jsp");
		}
		else if(bu.fieldsEmpty(new String[]{username, password, firstname, lastname, email} )  ){
			session.setAttribute("exception", "empty fields" );
			resp.sendRedirect("error.jsp");
		}else{
			
			User user = (User) session.getAttribute("user");
			
			User tmp = new User();
			
			tmp.setId(user.getId());
			tmp.setFirstname(firstname);
			tmp.setLastname(lastname);
			tmp.setPassword(password);
			tmp.seteMail(email);
			tmp.setUsername(username);
			tmp.setUserRole(user.getUserRole());
			
			DAOUser daou = new DAOUser();
			
			if(daou.updateUser(tmp)){
				System.out.println("user updated");
				
				session.setAttribute("user", tmp);
				
				resp.sendRedirect("viewInformation.jsp");
				
			}else{
				System.out.println("SOMETHING WENT WRONG, SQL EXCEPTION");
				resp.sendRedirect("error.jsp");
			}
			
			
		}
		
		
		//session.getAttribute(arg0)
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		System.out.println("doGet was called");
		
		
	}
	
}
