package com.revature.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.revature.dao.DAOUser;
import com.revature.pojo.Reimbursement;


public class BusinessUtil {
	
	
	public String returnType(int type){
		
		String s;
		
		switch(type){

		case 1:
			s = "Travel";
			break;
		case 2:
			s = "Food";
			break;
		case 3:
			s = "Lodging";
			break;
			
		default:
			s = "Misc";
			break;
		}
		
		return s;
	}
	
	public String returnStatus(int type){
		
		String s;
		
		switch(type){

		case 1:
			s = "Pending";
			break;
		case 2:
			s = "Approved";
			break;
		case 3:
			s = "Denied";
			break;
			
		default:
			s = "undefined";
			break;
		}
		
		return s;
		
	}
	
	
	
	
	// assuming that User object is in session once logged in
	public void ViewEmployeeInfo(){
		
		DAOUser daou = new DAOUser();
		
	}
	
	
	
	public void EditEmployeeInfo(){}
	
	
	public void ViewAllPendingRequests(){}
	public void ViewAllResolvedRequests(){}
	
	public void ViewEmployeePendingRequests(){}
	public void ViewEmployeeResolvedRequests(){}
	
	
	public boolean isReimbursement( HttpServletRequest req,
	    String description, String type, String amount){
		
		boolean success = true;
		/*
		// checks if fields are empty
		if( fieldsEmpty(new String[]{description, type, amount}) )
		{
			System.out.println("isReimbursement() fields are empty???");
			
			System.out.println("Here are some strings:");
			// print out list for debugging
			for(String s: new String[]{description, type, amount} ){
				System.out.println(s);
				
			}
			
			return false;
		}
		*/
		
		// storing in session
		req.getSession().setAttribute("description", description);
		
		// try to parse type for int
		try{
			System.out.println("type is: " + type);
			int t = Integer.parseInt(type);
			
			// only 4 types of reimbursements
			if(t <= 0 || t > 4){
				return false;
				
			}
			
			// storing in session
			req.getSession().setAttribute("type", new Integer(t));
		}catch (Exception e){
		
			// change to false if int is improperly parsed
			e.printStackTrace();
			success = false;
		}
		
		// if success == false the return false
		if(!success){
			return false;
		}
		
		// try to parse ammount for a double
		try{
			double amt = Double.parseDouble(amount);
			//parse_d_succ = true;
			
			// check if double is <= 0
			if( !(validAmount(amt)) ){
				return false;
			}
			
			// storing in session
			req.getSession().setAttribute("amount", new Double(amt));
			
		}catch(Exception e){
			e.printStackTrace();
			success = false;
		}
		
		return success;
	}
	
	// if amount is successfully parsed, check if the 
	// amount is valid
	public boolean validAmount(double amt){
		
		if(amt <= 0){
			return false;
		}
		
		return true;
	}
	
	public boolean isEmail(String email){
		
		int AtIn = email.indexOf(".com");
		int comIn = email.indexOf("@");
		
		if(AtIn == -1 || comIn == -1){
			System.out.println("THIS IS NOT A VALID EMAIL!!!!");
			return false;
		}else{
			return true;
		}
	}
	
	public boolean fieldsEmpty(String[] fields){
		
		for(String s: fields){
			
			if(s == null || s.isEmpty()){
				System.out.println("PLEASE FILL OUT EMPTY FIELDS");
				return true;
			}
		}
		System.out.println("Your fields are not empty.\ngood for you");
		return false;
	}
	
	public void login(){}
	
	public List<Reimbursement> getList(ResultSet rs){
		
		if(rs == null){
			return null;
		}
		else{
			List<Reimbursement> list = new ArrayList<Reimbursement>();
			
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String username = "ers_db";
			String password = "p4ssw0rd";
			
			try//(Connection con = DriverManager.getConnection(url, username, password)){
			{
				System.out.println("attempting to add reimbursements");
				
				while(rs.next()){
					
					//int id, double amount, String description, Timestamp submitted, Timestamp resolved, int author,
					//int resolver, int type, int status
					Reimbursement r = new Reimbursement(rs.getInt(1),rs.getDouble(2),rs.getString(2)
							,rs.getTimestamp(3),rs.getTimestamp(4)
							,rs.getInt(1),rs.getInt(1),rs.getInt(1),rs.getInt(1));
					
					list.add(r);
				}
				
				System.out.println("attempting to add reimbursements");
				
			}catch (SQLException s){
				s.printStackTrace();
			}
			
			return list;
		}
	}
	

}
