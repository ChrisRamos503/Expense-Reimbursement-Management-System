package com.revature.main;

import com.revature.dao.DAOReimbursement;
import com.revature.dao.DAOUser;
import com.revature.pojo.Reimbursement;


public class Main {

	public static void main(String[] args){
		
		//OracleDriver n = new OracleDriver();
		//n.connect("", );
		/*
		DAOUser daou = new DAOUser();
		
		User user = new User(1,"chris","chris"
				,"chris","chris","chris",2);
		
		
		daou.updateUser(user);
		*/
		
		// login story
		
		/*
		DAOUser daou = new DAOUser();
		
		String uname = "chris";
		String upass = "chris";
		
		User user = daou.getUserByUsernameAndPass(uname, upass);
		
		System.out.println("Done");
		*/
		
//		DAOUser daou = new DAOUser();
//		DAOReimbursement daor = new DAOReimbursement();
//		Reimbursement r = new Reimbursement();
		
		/*
		r.setId(82);
		r.setStatus(2);
		
		daor.updateReimbursementRequest(r, 3L);
		*/
		
		//List<User> list = daou.getAllEmployees();
		//List<Reimbursement> listr = daor.AllPendingRequests();
		//List<ReimbursementAug> lista = daor.AllResolvedRequests();
		
		//User u = daou.getUserById(1);
		
		//System.out.println("user:\n" + u);
		
		
		
		
		/*
		for(User u: list){

			System.out.println(u);
		}*/
		
		
		/*
		for(Reimbursement r : listr ){
			
			System.out.println(r);
			
		}
		*/
		/*
		for(ReimbursementAug r : lista ){
			
			System.out.println(r);
			
		}
		
		*/
		
		DAOReimbursement daor = new DAOReimbursement();
		
		byte[] array = daor.getBLOBByReimbursementId(61);
		System.out.println("begin: ");
		for(byte b : array){

			System.out.println(b);
		}
		
		
		System.out.println(array[0]);
		System.out.println(array[1]);
		System.out.println(array);
//		System.out.println(array[0]);
		
	}
}
