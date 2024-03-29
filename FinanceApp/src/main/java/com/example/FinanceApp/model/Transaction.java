package com.example.FinanceApp.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "transaction")
public class Transaction {
	@Id // make this field the PK of the table
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "createdAt")
	private LocalDate createdAt;
	
	@Column(name = "amount")
	private double amount;
	
	@Column(name = "category")
	private String category;
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "note")
	private String note;
	

//Changed this. There was 2. Not sure if name of the column would affect anything, changed to fetch to Eager as our database is small
//	@ManyToOne(fetch = FetchType.LAZY, optional = false) 
//	@JoinColumn(name = "userid", nullable = false) 
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false) 
	@JoinColumn(name = "userId", nullable = false) 
	@JsonIgnore
	private Customer customer;

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public Transaction() {}
	public Transaction(double amount, String category, String type, String note) {
		this.createdAt = LocalDate.now();
		this.amount = amount;
		this.category = category;
		this.type = type;
		this.note = note;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDate getCreatedAt() {
		return createdAt;
	}
//
//	public void setCreatedAt() {
//		LocalDateTime current = LocalDateTime.now();
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
//		String formattedDateTime = current.format(formatter);
//		this.createdAt = formattedDateTime;
//	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
}
