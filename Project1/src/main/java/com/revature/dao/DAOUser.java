package com.revature.dao;

import com.revature.pojo.Reimbursement;
import com.revature.pojo.User;

//import oracle.jdbc.OracleDriver;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import java.sql.Date;
//import java.util.Date;

// PUT ORACLE JAR FILE IN PROJECT.
import oracle.jdbc.OracleTypes;

public class DAOUser {

	private static String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String username = "ers_db";
	private static String password = "p4ssw0rd";
	
	//private static Connection con;
	
	// put in master servlet
	
	static{
		
		try{Class.forName("oracle.jdbc.OracleDriver");}
		catch(ClassNotFoundException e){
			System.out.println("Static block did not work");
			e.printStackTrace();
		}
	}
	
	public void CreateUser(){}
	
	public User getUserById(long id){
		
		User user = null;
		
		try(Connection con = DriverManager.getConnection(url, username, password)){
			//Connection con = DriverManager.getConnection(url, username, password);
			con.setAutoCommit(false);
			String SQL = "{call GET_ERS_USER_BY_USER_ID(?,?,?,?,?,?,?)}";
			
			CallableStatement cs = con.prepareCall(SQL);
			
			cs.registerOutParameter(2, OracleTypes.VARCHAR);
			cs.registerOutParameter(3, OracleTypes.VARCHAR);
			cs.registerOutParameter(4, OracleTypes.VARCHAR);
			cs.registerOutParameter(5, OracleTypes.VARCHAR);
			cs.registerOutParameter(6, OracleTypes.VARCHAR);
			cs.registerOutParameter(7, OracleTypes.NUMBER);
			
			cs.setLong(1,id);
			
			cs.executeUpdate();
			
			System.out.println("retrieving user");
			
			String uname = cs.getString(2);
			String upass = cs.getString(3);
			String fname = cs.getString(4);
			String lname = cs.getString(5);
			String e_mail = cs.getString(6);
			long urid = cs.getLong(7);
			
			user = new User(id, uname, upass, fname, lname, e_mail, urid);
			System.out.println(user);
			
			con.commit();

		}catch(SQLException s){
			
			s.printStackTrace();
		}
		
		return user;
		
	}
	
	public User getUserByUsernameAndPass(String uname, String upass){
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "ers_db";
		String password = "p4ssw0rd";
		
		User user = null;
		
		try(Connection con = DriverManager.getConnection(url, username, password)){
			//Connection con = DriverManager.getConnection(url, username, password);
			con.setAutoCommit(false);
			String SQL = "{call GET_ERS_USER_BY_UAP(?,?,?,?,?,?,?)}";
			
			CallableStatement cs = con.prepareCall(SQL);
			
			//cs.registerOutParameter(1, );
			cs.registerOutParameter(1, OracleTypes.NUMBER);
			cs.registerOutParameter(4, OracleTypes.VARCHAR);
			cs.registerOutParameter(5, OracleTypes.VARCHAR);
			cs.registerOutParameter(6, OracleTypes.VARCHAR);
			cs.registerOutParameter(7, OracleTypes.NUMBER);
			//cs.registerOutParameter(4, OracleTypes.VARCHAR);
			
			
			cs.setString(2, uname);
			cs.setString(3, upass);
			
			System.out.println("about to retrieve user");
			
			cs.executeUpdate();
			
			System.out.println("retrieving user");
			
			long id = cs.getLong(1);
			String fname = cs.getString(4);
			String lname = cs.getString(5);
			String e_mail = cs.getString(6);
			long urid = cs.getLong(7);
			
			System.out.println("Setting user");
			
			user = new User(id, uname, upass, fname, lname, e_mail, urid);
			System.out.println("whoooooo user is here:");
			System.out.println(user);
			
			con.commit();
			//con.close();
			
		}catch(SQLException s){
			
			s.printStackTrace();
		}
		
		return user;
	}
	
	public boolean updateUser(User user){
		
		boolean good = false;
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "ers_db";
		String password = "p4ssw0rd";
		
		System.out.println("Connection about to be established");
		try(Connection con = DriverManager.getConnection(url, username, password)){
			//Connection con = DriverManager.getConnection(url, username, password);
			con.setAutoCommit(false);
			
			System.out.println("Connection established");
			
			String SQL = "{call UPDATE_EMPLOYEE_PROC(?,?,?,?,?,?,?)}";
			
			CallableStatement cs = con.prepareCall(SQL);
			
			// binding IN Parameters
			cs.setLong(1, user.getId());
			cs.setString(2, user.getUsername());
			cs.setString(3, user.getPassword());
			cs.setString(4, user.getFirstname());
			cs.setString(5, user.getLastname());
			cs.setString(6, user.geteMail());
			cs.setLong(7, user.getUserRole());
			
			
			System.out.println("about to excute update");
			
			cs.executeUpdate();
			
			good = true;
			System.out.println("done updating");
			
			con.commit();
			//con.close();
		}catch(SQLException s){
			s.printStackTrace();
			
		}
		
		return good;
	}
	
	public List<User> getAllEmployees(){
		
		ResultSet rs = null;
		List<User> list = null;
		
		try(Connection con = DriverManager.getConnection(url, username, password))
		{
			con.setAutoCommit(false);
			
			String SQL = "SELECT * FROM ERS_USERS "
					+ "WHERE UR_ID = 2 ";
			
			PreparedStatement ps = con.prepareStatement(SQL);
			
			//ps.setString(1,Long.toString(id) );
			//ps.setLong(1, id);
			
			int i = ps.executeUpdate();
			
			rs = ps.getResultSet();
			
			
			list = new ArrayList<User>();
			
			System.out.println("about to add stuff");
			while(rs.next()){
				User user = new User(rs.getLong(1), rs.getString(2), rs.getString(3)
						,rs.getString(4),rs.getString(5),rs.getString(6)
						,rs.getLong(7));
				
				list.add(user);
			}
			
			System.out.println("EMPLOYEEs retrieved");
			
			
		}catch(SQLException s){
			
			s.printStackTrace();
		}
		
		return list;
		
	}
	
	
	
	
}
