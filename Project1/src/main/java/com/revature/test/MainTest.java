package com.revature.test;

//import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.revature.dao.DAOReimbursement;
import com.revature.dao.DAOUser;
import com.revature.pojo.Reimbursement;
import com.revature.pojo.ReimbursementAug;
import com.revature.pojo.User;
import com.revature.util.BusinessUtil;

public class MainTest {

	@Test
	public void test() {
		//fail("Not yet implemented");
		
		/*
		DAOUser daou = new DAOUser();
		
		String uname = "chris";
		String upass = "chris";
		
		User user = daou.getUserByUsernameAndPass(uname, upass);
		
		*/
		assertTrue(true);
	}
	
	@Test
	public void test2() {
		
		DAOUser daou = new DAOUser();
		List<User> list = daou.getAllEmployees();
	
		assertFalse(list == null);	
	}
	
	@Test
	public void test3(){
		
		DAOReimbursement daor = new DAOReimbursement();
		
		List<Reimbursement> listr = daor.AllPendingRequests();
		
		assertFalse(listr == null);
		
	}
	
	@Test
	public void test4(){
		
		DAOReimbursement daor = new DAOReimbursement();
		
		List<ReimbursementAug> lista = daor.AllResolvedRequests();
		
		assertFalse(lista == null);
		
	}
	
	@Test
	public void test5(){
		
		BusinessUtil bu = new BusinessUtil();
		
		String s = bu.returnStatus(1);
		
		assertTrue(s.equals("Pending") );
	}
	
	@Test
	public void test6(){
		
		BusinessUtil bu = new BusinessUtil();
		
		String s = bu.returnType(1);
		
		assertTrue(s.equals("Travel") );
	}
	
}// end of class
	
	
