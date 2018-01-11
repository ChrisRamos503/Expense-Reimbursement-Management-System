package com.revature.pojo;

import java.sql.DriverManager;
import java.sql.Timestamp;


public class Reimbursement {
	
	private int id;
	private double amount;
	private String description;
	// for the blob
	private Timestamp submitted;
	private Timestamp resolved;
	private int author;
	private int resolver;
	private int type;
	private int status;
	
	public Reimbursement(){}

	public Reimbursement(int id, double amount, String description, Timestamp submitted, Timestamp resolved, int author,
			int resolver, int type, int status) {
		super();
		this.id = id;
		this.amount = amount;
		this.description = description;
		this.submitted = submitted;
		this.resolved = resolved;
		this.author = author;
		this.resolver = resolver;
		this.type = type;
		this.status = status;
	}
	
	public Reimbursement(double amount, String description,
			int author, int type){
		
		super();
		//this.id = id;
		this.amount = amount;
		this.description = description;
		//this.submitted = submitted;
		//this.resolved = resolved;
		this.author = author;
		//this.resolver = resolver;
		this.type = type;
		//this.status = status;
		
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Timestamp getSubmitted() {
		return submitted;
	}

	public void setSubmitted(Timestamp submitted) {
		this.submitted = submitted;
	}

	public Timestamp getResolved() {
		return resolved;
	}

	public void setResolved(Timestamp resolved) {
		this.resolved = resolved;
	}

	public int getAuthor() {
		return author;
	}

	public void setAuthor(int author) {
		this.author = author;
	}

	public int getResolver() {
		return resolver;
	}

	public void setResolver(int resolver) {
		this.resolver = resolver;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Reimbursement [id=" + id + ", amount=" + amount + ", description=" + description + ", submitted="
				+ submitted + ", resolved=" + resolved + ", author=" + author + ", resolver=" + resolver + ", type="
				+ type + ", status=" + status + "]";
	}
	
	
}
