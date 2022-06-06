package com.evehicleshowroom.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "dealer_table")
public class Dealer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "dealer_id")
	private int dealerId;
	@NotNull(message = "Dealer name is required")
	@Column(name = "dealer_name")
	private String dealerName;
	@NotNull(message = "Dealer phone number is required")
	@Column(name = "mobile")
	private String mobile;
	@NotNull(message = "Username is required")
	@Column(name = "username")
	private String userName;
	@NotNull(message = "Password name is required")
	@Column(name = "password")
	private String password;
	@NotNull(message = "Dealer email ID is required")
	@Column(name = "email", unique = true)
	private String email;

	@JsonIgnore
	@OneToMany(mappedBy = "dealer")
	private List<Customer> customer;

	public int getDealerId() {
		return dealerId;
	}

	public void setDealerId(int dealerId) {
		this.dealerId = dealerId;
	}

	public String getDealerName() {
		return dealerName;
	}

	public void setDealerName(String dealerName) {
		this.dealerName = dealerName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Customer> getCustomer() {
		return customer;
	}

	public void setCustomer(List<Customer> customer) {
		this.customer = customer;
	}

}
