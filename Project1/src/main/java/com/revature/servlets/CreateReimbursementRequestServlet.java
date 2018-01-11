package com.revature.servlets;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.revature.dao.DAOReimbursement;
import com.revature.pojo.Reimbursement;
import com.revature.pojo.User;
import com.revature.util.BusinessUtil;



@WebServlet("/submitRequest")
public class CreateReimbursementRequestServlet extends HttpServlet{
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		BusinessUtil bu = new BusinessUtil();
		HttpSession session = req.getSession();
		
		//String fileID =  req.getParameter("fileID");
		//String description =  req.getParameter("description");
		//String type =  req.getParameter("type");
		//String amount =  req.getParameter("amount");
		
		//painfulFunction(req);
		
		
		
//		for(String s: new String[]{fileID, description, type, amount}){
//			System.out.println("value = " + s);
//		}
		
		boolean form_good = ProcessFormData(req);
		
		System.out.println("form_good = " + form_good);
		
		System.out.println("doPost: retrieving user");
		
		User user = (User) session.getAttribute("user");
		//String fileID = (String) session.getAttribute("fileID");
		
		System.out.println("doPost: checking user");
		if(user == null || !form_good){
			resp.sendRedirect("error.jsp");
		}
		else{
			System.out.println("doPost: user exists");
			
//			String fileID = (String) session.getAttribute("fileID");
			
			byte[] fileID = (byte[]) session.getAttribute("fileID");
			String description = (String) session.getAttribute("description");
			Integer type_w = (Integer)  session.getAttribute("type");
			Double amount_w =  (Double) session.getAttribute("amount");
			
			System.out.println("doPost: session attributes retrieved");
			
			System.out.println("fileID = " + fileID );
			System.out.println("description = " + description );
			System.out.println("type_w = " + type_w );
			System.out.println("amount_w = " + amount_w );

			int type = type_w.intValue();
			double amount = amount_w.doubleValue();
					
			System.out.println("doPost: session attributes assigned");

		DAOReimbursement daor = new DAOReimbursement();
		
		System.out.println("doPost: Reimbursement object created");
		
		Reimbursement r = new Reimbursement(amount, description, 
				(int) user.getId() , type);
		
		daor.createReimbursementRequestBytes(r, fileID);
		
		session.removeAttribute("fileID");
		session.removeAttribute("description");
		session.removeAttribute("type");
		session.removeAttribute("amount");
		
		resp.sendRedirect("employeeHompage.jsp");
		}
	}
	
	public void painfulFunction(HttpServletRequest request){
		
		String UPLOAD_DIRECTORY = "C:\\Users\\Chris\\Pictures\\reciepts";
		
		//process only if its multipart content
        if(ServletFileUpload.isMultipartContent(request)){
        	
        	System.out.println("painfulFunction() --- isMultipartContent(request) == true");
        	
            try {
                List<FileItem> multiparts = new ServletFileUpload(
                                         new DiskFileItemFactory()).parseRequest(request);
              
                for(FileItem item : multiparts){
                    if(!item.isFormField()){
                        String name = new File(item.getName()).getName();
                        System.out.println("file name: " + name);
                        item.write( new File(UPLOAD_DIRECTORY + File.separator + name));
                    }
                }
                System.out.println("file upload successful");
               //File uploaded successfully
           //    request.setAttribute("message", "File Uploaded Successfully");
            } catch (Exception ex) {
         //      request.setAttribute("message", "File Upload Failed due to " + ex);
            	System.out.println("file upload failed; did not work");
            }          
         
        }else{
           // //request.setAttribute("message",
          //                       "Sorry this Servlet only handles file upload request");
        }
    
        //request.getRequestDispatcher("/result.jsp").forward(request, response);
     
	}
	
	public boolean ProcessFormData(HttpServletRequest request){

		// code from commons.apache.org
		
		// factory that spits out different types of files
		DiskFileItemFactory factory = new DiskFileItemFactory();
		
		// Create a new file upload handler
		ServletFileUpload upload = new ServletFileUpload(factory);

		boolean good = true;
		
		try{
		// Parse the request
		List<FileItem> items = upload.parseRequest(request);
		
		Iterator<FileItem> iter = items.iterator();
		
		String[] arr = new String[3];
		int count = 0;
		
		while (good && iter.hasNext()) {
		    FileItem item = iter.next();
		    
		    System.out.println("item name is: " + item.getName());
		    
		    // if it is a regular input do this
		    if (item.isFormField()) {
		    	System.out.println("is Field");
		    	System.out.println(item.getString() + "\n");
		    	
		    	// if regular input is empty or null then return false
		    	if(item.getString() == null || 
		    			item.getString().isEmpty()){
		    		
		    		good = false;
		    		break;
		    		
		    	}else{
		    		// extract regular input from form
		    		arr[count] = item.getString();
		    		count++;
		    	}
		    	
		    } else {
		       // process a file instead of regular input
		    	System.out.println("is File");
		    	
		    	//item.getString();
//		    	item.get();
		    	// use this to convert into a byte array
//		    	item.getString().getBytes();
		    	System.out.println(item.getName());	
//		    	request.getSession().setAttribute("fileID", item.getName());
		    	request.getSession().setAttribute("fileID", item.get());
		    }
		}// end of while
		
			// check if fields are valid
			if(good){
				String amount = arr[0];
				String description = arr[1];
				String type = arr[2];
				
				for(String s : arr){
					System.out.println(s);	
				}
				
				good = new BusinessUtil().isReimbursement(request, description, type, amount);
			}
			
		}catch(FileUploadException fue){
			good = false;
			fue.printStackTrace();
		}
		
		return good;
	}// end of function

}
