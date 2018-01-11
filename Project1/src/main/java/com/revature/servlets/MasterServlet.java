package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MasterServlet extends HttpServlet {

//@WebServlet("/myServlet/*")
	
static{
		
		try{Class.forName("oracle.jdbc.OracleDriver");}
		catch(ClassNotFoundException e){
			System.out.println("Static block did not work");
			e.printStackTrace();
		}
	}
/*
 * 
 * 
 * (non-Javadoc)
 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
 *
 * <servlet>
  	<servlet-name>master</servlet-name>
  	<servlet-class>com.revature.servlets.MasterServlet</servlet-class>
  </servlet>
  
  <servlet-mapping>
  	<servlet-name>master</servlet-name>
  	<url-pattern>/*</url-pattern>
  </servlet-mapping>
  
 *
 */

	
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			// TODO Auto-generated method stub
			//super.doGet(req, resp);
		
			resp.sendRedirect("login.jsp");
		
		}

}
