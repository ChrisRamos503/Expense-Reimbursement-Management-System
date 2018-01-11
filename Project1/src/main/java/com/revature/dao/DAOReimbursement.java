package com.revature.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.revature.pojo.Reimbursement;
import com.revature.pojo.ReimbursementAug;

public class DAOReimbursement {
	
	
	private final static String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private final static String username = "ers_db";
	private final static String password = "p4ssw0rd";
	
	//public Reimbursement getReimbursementByUserId(){}
	
	//public List<Reimbursement> getAllPendingReimbursements(){}
	
	public List<Reimbursement> getAllEmployeePendingReimbursements(long id){
		
		ResultSet rs = null;
		List<Reimbursement> list = null;
		
		try(Connection con = DriverManager.getConnection(url, username, password))
		{
			con.setAutoCommit(false);
			
			String SQL = "SELECT * FROM ERS_REIMBURSEMENTS "
					+ " WHERE RT_STATUS = 1"
					+ " AND U_ID_AUTHOR = ? ";
			
			PreparedStatement ps = con.prepareStatement(SQL);
			
			//ps.setString(1,Long.toString(id) );
			ps.setLong(1, id);
			
			int i = ps.executeUpdate();
			
			rs = ps.getResultSet();
			
			
			list = new ArrayList<Reimbursement>();
			
			System.out.println("about to add stuff");
			while(rs.next()){
			System.out.println("adding a request");	
				Reimbursement r = new Reimbursement(rs.getInt(1),rs.getDouble(2),rs.getString(3)
						,rs.getTimestamp(5),rs.getTimestamp(6)
						,rs.getInt(7),rs.getInt(8),rs.getInt(9),rs.getInt(10));
				
				list.add(r);
			}
			
			System.out.println("Done retrieving EMPLOYEE PENDING requests");
			
			
		}catch(SQLException s){
			
			s.printStackTrace();
		}
		
		return list;
	}
	////////////////////////////////////////////////////////
	
public List<Reimbursement> getAllEmployeeResolvedReimbursements(long id){
		
		ResultSet rs = null;
		List<Reimbursement> list = null;
		
		try(Connection con = DriverManager.getConnection(url, username, password))
		{
			con.setAutoCommit(false);
			
			String SQL = "SELECT * FROM ERS_REIMBURSEMENTS "
					+ " WHERE RT_STATUS <> 1"
					+ " AND U_ID_AUTHOR = ? ";
			
			PreparedStatement ps = con.prepareStatement(SQL);
			
			//ps.setString(1,Long.toString(id) );
			ps.setLong(1, id);
			
			int i = ps.executeUpdate();
			
			rs = ps.getResultSet();
			
			
			list = new ArrayList<Reimbursement>();
			
			System.out.println("about to add stuff");
			while(rs.next()){
			System.out.println("adding a request");	
				Reimbursement r = new Reimbursement(rs.getInt(1),rs.getDouble(2),rs.getString(3)
						,rs.getTimestamp(5),rs.getTimestamp(6)
						,rs.getInt(7),rs.getInt(8),rs.getInt(9),rs.getInt(10));
				
				list.add(r);
			}
			
			//System.out.println("Done retrieving EMPLOYEE PENDING requests");
			
			
		}catch(SQLException s){
			
			s.printStackTrace();
		}
		
		return list;
	}
	//////////////////////////////////////////////////////////////
	
public List<Reimbursement> getAllEmployeeReimbursements(long id){
	
	ResultSet rs = null;
	List<Reimbursement> list = null;
	
	try(Connection con = DriverManager.getConnection(url, username, password))
	{
		con.setAutoCommit(false);
		
		String SQL = "SELECT * FROM ERS_REIMBURSEMENTS "
				+ " WHERE "
				+ " U_ID_AUTHOR = ? ";
		
		PreparedStatement ps = con.prepareStatement(SQL);
		
		//ps.setString(1,Long.toString(id) );
		ps.setLong(1, id);
		
		int i = ps.executeUpdate();
		
		rs = ps.getResultSet();
		
		
		list = new ArrayList<Reimbursement>();
		
		System.out.println("about to add stuff");
		while(rs.next()){
		System.out.println("adding a request");	
			Reimbursement r = new Reimbursement(rs.getInt(1),rs.getDouble(2),rs.getString(3)
					,rs.getTimestamp(5),rs.getTimestamp(6)
					,rs.getInt(7),rs.getInt(8),rs.getInt(9),rs.getInt(10));
			
			list.add(r);
		}
		
		//System.out.println("Done retrieving EMPLOYEE PENDING requests");
		
		
	}catch(SQLException s){
		
		s.printStackTrace();
	}
	
	return list;
}
	


	//////////////////////////////////////////////////////////////
	
	public void createReimbursementRequest(Reimbursement r, String fileID){
			
		FileInputStream in = null;
		  		
		// put into ReimbursementDAO
		File blob = new File(fileID);
		System.out.println("createReimbursementRequest: attempting to make a blob");
		try {
			in = new FileInputStream(blob);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
		
		
		try(Connection con = DriverManager.getConnection(url, username, password))
		{
			con.setAutoCommit(false);
			
			// used to extract time data in the form of a long
			Date d = new Date();
			
			// makes time stamp
			Timestamp ts = new Timestamp(d.getTime());
			
			System.out.println("createReimbursementRequest: about to compile SQL");
			String SQL = "INSERT INTO ERS_REIMBURSEMENTS "
					+ "(R_ID,R_AMOUNT,R_DESCRIPTION,R_RECEIPT,R_SUBMITTED, "
					+ "U_ID_AUTHOR,RT_TYPE,RT_STATUS)"
					+ " VALUES(ERS_REIMBURSEMENTS_SEQ.NEXTVAL ,"
					+ " ? , ? , ? ,  systimestamp , ? , ? ,1)";
			
			PreparedStatement ps = con.prepareStatement(SQL);
////////////////////////////////////////////////////////////////////////			
//			
//			FileInputStream in = null;
//			long len = 0;
//			
//			
//
//	    	    //create a temp file
//	    	    File temp = new File("tempfile.tmp");
//	    	    
//	    	    BufferedWriter bw = new BufferedWriter(new FileWriter(temp));
//	    	    bw.write(fileID);
//	    	    bw.close();
//	    	    
//	    	    //File b = new File("tempfile.tmp");
//	    	    
//	    	    in = new FileInputStream(temp);
//	    	    len = temp.length();
//	    	    System.out.println("len=" + len);
//
//	    	    //write raw string back to file
//	    	    
//
//	    	    System.out.println("Done");
////////////////////////////////////////////////////////////
//			
//			
////			Charset UTF_8 = Charset.forName("UTF-8");
////			byte[] arr = fileID.getBytes(UTF_8);
//			byte[] arr = fileID.getBytes();
//			
//			String again = new String(Base64.getEncoder().encode(arr));
//			byte[] again_arr = again.getBytes();
			
			
			ps.setDouble(1, r.getAmount());
			ps.setString(2, r.getDescription());
			
			
			/*
			
			Blob blob = con.createBlob();
			blob.setBytes(1L, arr);
			US-ASCII
			ps.setBlob(3, blob);
			
			*/
			
			// try this
			
			
//			Charset charset = new Charset("US-ASCII",)
//			fileID.getBytes(charset);
			
//			ps.setBinaryStream(3, new ByteArrayInputStream(again_arr), again_arr.length );
			
//			ps.setBinaryStream(3, new ByteArrayInputStream(arr), arr.length );
//			ps.setBytes(3, fileID.getBytes());
			// make a BLOB go here
			
			
			ps.setBinaryStream(3, in, (int) blob.length());
//			ps.setBytes(3), arg1);
			
//			ps.setBinaryStream(3, in, (int) len );
//			ps.setBinaryStream(3, in, (int) len );
			
			
//			ps.setBytes(parameterIndex, x);
			
			ps.setInt(4, r.getAuthor());
			ps.setInt(5, r.getType());
			
			ps.executeUpdate();
			
			System.out.println("createReimbursementRequest: finished adding reimbursement ");
			con.commit();
			
			System.out.println("Reimbursement created");
		}catch(SQLException s){
			
			s.printStackTrace();
		}
		
	}
	
	public void createReimbursementRequestBytes(Reimbursement r, byte[] fileID){
		
		try(Connection con = DriverManager.getConnection(url, username, password))
		{
			con.setAutoCommit(false);
			
			// used to extract time data in the form of a long
			Date d = new Date();
			
			// makes time stamp
			Timestamp ts = new Timestamp(d.getTime());
			
			System.out.println("createReimbursementRequest: about to compile SQL");
			String SQL = "INSERT INTO ERS_REIMBURSEMENTS "
					+ "(R_ID,R_AMOUNT,R_DESCRIPTION,R_RECEIPT,R_SUBMITTED, "
					+ "U_ID_AUTHOR,RT_TYPE,RT_STATUS)"
					+ " VALUES(ERS_REIMBURSEMENTS_SEQ.NEXTVAL ,"
					+ " ? , ? , ? ,  systimestamp , ? , ? ,1)";
			
			PreparedStatement ps = con.prepareStatement(SQL);
	
			ps.setDouble(1, r.getAmount());
			ps.setString(2, r.getDescription());
			ps.setBytes(3, fileID);
			
			
			ps.setInt(4, r.getAuthor());
			ps.setInt(5, r.getType());
			
			ps.executeUpdate();
			
			System.out.println("createReimbursementRequest: finished adding reimbursement ");
			con.commit();
			
			System.out.println("Reimbursement created");
		}catch(SQLException s){
			
			s.printStackTrace();
		}
		
	}
	
	
	
	
	
	
	
	public List<Reimbursement> AllPendingRequests(){
		ResultSet rs = null;
		List<Reimbursement> list = null;
		
		try(Connection con = DriverManager.getConnection(url, username, password))
		{
			con.setAutoCommit(false);
			
			String SQL = "SELECT * FROM ERS_REIMBURSEMENTS "
					+ " WHERE RT_STATUS = 1";
					
			PreparedStatement ps = con.prepareStatement(SQL);
			
			int i = ps.executeUpdate();
			
			rs = ps.getResultSet();
			
			
			list = new ArrayList<Reimbursement>();
			
			System.out.println("about to add stuff");
			while(rs.next()){
			System.out.println("getting all pending reimbursements");	
			
				Reimbursement r = new Reimbursement();
				
				r.setId(rs.getInt(1));
				r.setAmount(rs.getDouble(2));
				r.setDescription(rs.getString(3));
				r.setSubmitted(rs.getTimestamp(5));
				r.setAuthor(rs.getInt(7));
				r.setType(rs.getInt(9));
				r.setStatus(rs.getInt(10));
			
				list.add(r);
			}
			
		}catch(SQLException s){
			
			s.printStackTrace();
		}
		
		return list;
		
	}
	
	public List<ReimbursementAug> AllResolvedRequests(){
		ResultSet rs = null;
		List<ReimbursementAug> list = null;
		
		try(Connection con = DriverManager.getConnection(url, username, password))
		{
			con.setAutoCommit(false);
			
			String SQL = "SELECT * FROM ERS_REIMBURSEMENTS "
					+ " INNER JOIN ERS_USERS ON "
					+ " ERS_REIMBURSEMENTS.U_ID_RESOLVER = ERS_USERS.U_ID "
					+ " WHERE RT_STATUS <> 1 ";
					
			PreparedStatement ps = con.prepareStatement(SQL);
			
			int i = ps.executeUpdate();
			
			rs = ps.getResultSet();
			
			
			list = new ArrayList<ReimbursementAug>();
			
			System.out.println("about to add stuff");
			while(rs.next()){
			System.out.println("getting all pending reimbursements");	
			
				ReimbursementAug r = new ReimbursementAug();
				
				r.setId(rs.getInt(1));
				r.setAmount(rs.getDouble(2));
				r.setDescription(rs.getString(3));
				r.setSubmitted(rs.getTimestamp(5));
				r.setResolved(rs.getTimestamp(6));
				r.setAuthor(rs.getInt(7));
				r.setType(rs.getInt(9));
				r.setStatus(rs.getInt(10));
				
				r.setBoss_id(rs.getLong(11));
				r.setBoss(rs.getString(14) + " " + rs.getString(15));
				
				list.add(r);
			}
			
		}catch(SQLException s){
			
			s.printStackTrace();
		}
		
		return list;
		
	}
	
	
	public void updateReimbursementRequest(Reimbursement r, long resolver_id){
	
		try(Connection con = DriverManager.getConnection(url, username, password))
		{
			con.setAutoCommit(false);
			
			System.out.println("createReimbursementRequest: about to compile SQL");
			String SQL = " UPDATE ERS_REIMBURSEMENTS "
			+ " SET R_RESOLVED = SYSTIMESTAMP, U_ID_RESOLVER = ?, RT_STATUS = ? "
			+ " WHERE R_ID = ? ";
			
			PreparedStatement ps = con.prepareStatement(SQL);
		
			ps.setLong(1, resolver_id);
			ps.setInt(2, r.getStatus());
			ps.setInt(3, r.getId());
			
			ps.executeUpdate();
			
			System.out.println("updateReimbursementRequest: finished updating reimbursement ");
			con.commit();
			
			System.out.println("Reimbursement updated");
		}catch(SQLException s){
			
			s.printStackTrace();
		}
		
	}
	
	public byte[] getBLOBByReimbursementId(long r_id) {
		
		byte[] arr = null;
		
		try(Connection con = DriverManager.getConnection(url, username, password))
		{
			con.setAutoCommit(false);
			
			String SQL = "SELECT R_RECEIPT "
					+ " FROM ERS_REIMBURSEMENTS"
					+ " WHERE R_ID = ? ";
			
			PreparedStatement ps = con.prepareStatement(SQL);
		
//			r_id = 61;
			
			// set reimbursement id
			ps.setLong(1, r_id);
			
			// execute prepared statement
			ps.executeUpdate();
			
			ResultSet rs = ps.getResultSet();
			
			byte[] is = null;
			arr = new byte[100000];
			
			while(rs.next()){
				System.out.println("getting Input Stream from database");
				
				//is = rs.getBinaryStream("R_RECEIPT");
				is = rs.getBytes(1);
				
			}
			
			// length of bytes read from one file
			int len = 1000;
			// offset within the array
			int offset = 0;
			int read = 0;
			
			/*
			
			try{
			System.out.println("bytes available " + is.available());
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			
			
			try{
				while(is.available() > 0){
					
					System.out.println("reading from Input Stream");
					read += is.read(arr, offset, len);
					//is.read
					
					offset += len;
					System.out.println("total number of bytes read");
				}
			}catch(IOException i){
				
				i.printStackTrace();
				System.out.println("");
			}
				
			*/
			System.out.println("BLOB Retrieved");
			arr = is;
		}catch(SQLException s){
			s.printStackTrace();
		}
		
		return arr;
		
	}
	

}// end of class



/*
//String 
byte[] arr = fileID.getBytes();
byte[] arr_b = new byte[(arr.length * 8)];


System.out.println("arr length = " + arr.length);
System.out.println("arr_b length = " + arr_b.length);

int count = 0;


try{
for(int i = 0; i < arr.length ;i++){
	
	
	count = (i * 8) - 1;
	if(count <= 0)
		count = 0;
	
	
	System.out.println("count = " + i);
	int num = (int) arr[i];
	
	for(int j = 0; j < 8; j++){
		
		if(num != 0 && (num % 2 == 1)){
			
			arr_b[count++] = 1;
			// bitwise move one bit to the right
			num  >>= 1;
		}
		else{
			arr_b[count++] = 0;
			num  >>= 1;
		}
		
	}
}
}catch(ArrayIndexOutOfBoundsException e){
	e.printStackTrace();
}

*/
//Encoder e = Base64.getEncoder();
//byte[] arr_b_64 = e.encode(arr);


// use this?????????
//fileID.getBytes(charsetName);
