package com.security.endpoint.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserModel {

	@JsonProperty(value = "username")
	private String username;
	@JsonProperty(value = "password")
	private String password;

	public UserModel() {

	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
