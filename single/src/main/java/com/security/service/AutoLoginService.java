package com.security.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class AutoLoginService implements IAutoLoginService {
	private static final Logger logger = LoggerFactory.getLogger(AutoLoginService.class);
	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Override
	public void autologin(String username, String password) {
		UserDetails userDetails = userDetailsService.loadUserByUsername(username);
		UsernamePasswordAuthenticationToken usernamePassAuthToken = new UsernamePasswordAuthenticationToken(userDetails,
				password, userDetails.getAuthorities());
		usernamePassAuthToken = (UsernamePasswordAuthenticationToken) authenticationManager
				.authenticate(usernamePassAuthToken);
		if (usernamePassAuthToken.isAuthenticated()) {
			SecurityContextHolder.getContext().setAuthentication(usernamePassAuthToken);
			logger.info(String.format("Auto login %s successfully!", username));

		}
	}

}
