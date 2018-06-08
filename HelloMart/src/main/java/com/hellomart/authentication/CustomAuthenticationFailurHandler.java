package com.hellomart.authentication;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;


public class CustomAuthenticationFailurHandler implements AuthenticationFailureHandler {

	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(CustomAuthenticationFailurHandler.class);
	
	/* 이동할 URL */
	private String defaultFailUrl = "login";
	
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception)
			throws IOException, ServletException {
		String url = createUrl(exception);
		
		response.sendRedirect(url);
	}

	private String createUrl(AuthenticationException exception) {
		StringBuilder sb = new StringBuilder(defaultFailUrl);
		
		int result = getExceptionResult(exception);
		
		sb
			.append("?fail=").append("true")
			.append("&")
			.append("result=").append(result);
		
		return sb.toString();
	}
	
	private int getExceptionResult(AuthenticationException exception) {
		if (
				exception.getClass().isAssignableFrom(UsernameNotFoundException.class) ||
				exception.getClass().isAssignableFrom(BadCredentialsException.class)) {
			return 1;
		} else {
			return 0;
		}
		
	}
	
}
