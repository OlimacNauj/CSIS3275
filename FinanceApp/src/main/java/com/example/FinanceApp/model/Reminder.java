package com.example.FinanceApp.model;

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
@Table(name="Reminder")
public class Reminder {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	//convention here is name = nameoftable_fieldname
	@JoinColumn(name = "userId", nullable = false) 
	@JsonIgnore
	private Customer customer;
	
	@Column
	private String name;
	
	@Column
	private String description;
	
	@Column 
	private String amount;
	
	@Column
	private String createdAt;
	
	@Column
	private String deadline;
	
	@Column
	private String frequency;
	
	@Column
	private String status;
	
	public Reminder() {
		
	}
	
	public Reminder(String name,String description,String amount,String createdAt,String deadline,String frequency,String status) {
		this.name=name;
		this.description=description;
		this.amount = amount;
		this.createdAt = createdAt;
		this.deadline = deadline;
		this.frequency = frequency;
		this.status = status;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getDeadline() {
		return deadline;
	}

	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}

	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}
	
	
	
}
