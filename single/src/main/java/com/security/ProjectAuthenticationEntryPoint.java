package com.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Service;

@Service
public class ProjectAuthenticationEntryPoint implements AuthenticationEntryPoint {
	public static final Logger logger = LoggerFactory.getLogger(ProjectAuthenticationEntryPoint.class);

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		if (SecurityContextHolder.getContext().getAuthentication() != null) {
			if (SecurityContextHolder.getContext().getAuthentication().isAuthenticated()) {
				logger.info(
						"======================USER IS AUTHENTICATED============================ REDIRECTING TO MAIN PAGE =======");
			} else {
				logger.info(
						"======================USER IS NOT AUTHENTICATED============================  REDIRECTING TO LOGIN PAGE =======");
			}

		} else {
			logger.info(
					"======================USER IS NOT AUTHENTICATED============================  REDIRECTING TO LOGIN PAGE =======");
		}

	}

}
