package com.sda.ams.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer clientId;
	private String name;
	private String address;
	private String cnp;
	private String phoneNo;
	private String email;

	public Client(Integer clientId, String name, String address, String cnp, String phoneNo, String email) {
		super();
		this.clientId = clientId;
		this.name = name;
		this.address = address;
		this.cnp = cnp;
		this.phoneNo = phoneNo;
		this.email = email;
	}

	public Client() {
	}

	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCnp() {
		return cnp;
	}

	public void setCnp(String cnp) {
		this.cnp = cnp;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Client [clientId=" + clientId + ", name=" + name + ", address=" + address + ", cnp=" + cnp
				+ ", phoneNo=" + phoneNo + ", email=" + email + "]";
	}

}
