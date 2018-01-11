package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Base64;
import java.util.Base64.Encoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.codec.binary.StringUtils;

import com.revature.dao.DAOReimbursement;

@WebServlet("/getImage")
public class GetImageServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = req.getSession();
		
		DAOReimbursement daor = new DAOReimbursement();
		
		String param = req.getParameter("reb_id");
//		String t = (String) req.getAttribute("reb_id");
//		
//		String header = req.getHeader("reb_id");
		int len = req.getContentLength();
		
		System.out.println(len);
		
		// getting response writer
		PrintWriter pw = resp.getWriter();
		
		
		if(len > 0){
		
		int id = Integer.parseInt(param);
		
		// extract byte array from DataBase 
		byte[] arr = daor.getBLOBByReimbursementId(id);
		
			if(arr != null){
			//byte[] img = null;
			StringBuilder sb = new StringBuilder();
			
			// get encoder
			Encoder e = Base64.getEncoder();
			
			
			String test = StringUtils.newStringUtf8(e.encode(arr));
//			String test2 = e.encodeToString(arr);
			
			
			sb.append("<img src=\'data:image/jpeg;base64," + test + "\' />");
			//sb.append(test2);
			
			String img_resp = sb.toString();
			
			//System.out.println(img_resp);
			
			// writing response
			pw.println(img_resp);
			
			}else{
				pw.println("<p>No image exists</p>");
			}
		
		}else{
			
			pw.println("<p>No image exists</p>");
		}
		
		
		
		
		
		
	}// end of doPost()
	
	
	
	
	
	
}
