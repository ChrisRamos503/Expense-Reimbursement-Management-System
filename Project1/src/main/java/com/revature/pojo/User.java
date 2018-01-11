package com.revature.pojo;

public class User {
	
	private long id;
	private String Username;
	private String password;
	private String firstname;
	private String lastname;
	private String eMail;
	private long userRole;
	
	public User(){}
	
	public User(User user){
		this.id = user.getId();
		Username = user.getUsername();
		this.password = user.getPassword();
		this.firstname = user.getFirstname();
		this.lastname = user.getLastname();
		this.eMail = user.geteMail();
		this.userRole = user.getUserRole();
	}

	public User(long id, String username, String password, String firstname, String lastname, String eMail,
			long userRole) {
		super();
		this.id = id;
		Username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.eMail = eMail;
		this.userRole = userRole;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public long getUserRole() {
		return userRole;
	}

	public void setUserRole(long userRole) {
		this.userRole = userRole;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", Username=" + Username + ", password=" + password + ", firstname=" + firstname
				+ ", lastname=" + lastname + ", eMail=" + eMail + ", userRole=" + userRole + "]";
	}
	
	
	
	
	
}
