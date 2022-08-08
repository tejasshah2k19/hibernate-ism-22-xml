package com.bean;

import java.util.List;

public class UserBean {

	Integer userId;
	String firstName;
	String email;
	String password;
	RoleBean role; // roleid rolename --25
	List<VehicleBean> vehicles; 
	
	
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public RoleBean getRole() {
		return role;
	}

	public void setRole(RoleBean role) {
		this.role = role;
	}

	public List<VehicleBean> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<VehicleBean> vehicles) {
		this.vehicles = vehicles;
	}

	
}
