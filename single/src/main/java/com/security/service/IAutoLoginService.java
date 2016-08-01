package com.security.service;

@FunctionalInterface
public interface IAutoLoginService {

	void autologin(String username, String password);
}
