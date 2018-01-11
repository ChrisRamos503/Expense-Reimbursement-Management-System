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


@WebServlet("/pendingRequests")
public class PendingRequestsServlet extends HttpServlet{

	/*
	<c:forEach>
		<c:out value="<TR>" escapeXml="false"/>
			<c:out value="<td> ${rs.getLong(1)}  </td>" escapeXml="false"/>
			<c:out value="<td> ${rs.getLong(2)}  </td>" escapeXml="false"/>
			<c:out value="<td> ${rs.getString(3)}  </td>" escapeXml="false"/>
			<c:out value="<td> ${rs.getTimestamp(5)}  </td>" escapeXml="false"/>
			<c:out value="<td> ${rs.getTimestamp(6)}  </td>" escapeXml="false"/>
			<c:out value="<td> ${rs.getLong(7)}  </td>" escapeXml="false"/>
			<c:out value="<td> ${rs.getLong(8)}  </td>" escapeXml="false"/>
			<c:out value="<td> ${rs.getLong(9)}  </td>" escapeXml="false"/>
			<c:out value="<td> ${rs.getLong(10)}  </td>" escapeXml="false"/>
		<c:out value="</TR>" escapeXml="false"/>
	</c:forEach>
	
	
	 */
	
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
			System.out.println("retrieving employee PENDING requests");
			
			List<Reimbursement> list =  daor.getAllEmployeePendingReimbursements(user.getId());
			System.out.println("Ladies and gentlemen, we have a list of PENDING requests");
			
			if(list == null){
				resp.sendRedirect("error.jsp");
				System.out.println("list is NULL");
			}else{
				
				System.out.println("employee pending requests not null");
				session.setAttribute("list", list);
				resp.sendRedirect("EmployeePendingRequests.jsp");
			}
		}else{ // user is boss
			
			List<Reimbursement> pend_list = daor.AllPendingRequests();
			
			session.setAttribute("size", pend_list.size());
			session.setAttribute("pend_list", pend_list);
			resp.sendRedirect("allPendingRequests.jsp");
			
		}
		
		
		
		
	}
	
}
