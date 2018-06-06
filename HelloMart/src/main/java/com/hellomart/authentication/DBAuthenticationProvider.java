package com.hellomart.authentication;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

@Component
public class DBAuthenticationProvider implements AuthenticationProvider {
	
	private static final Logger logger = LoggerFactory.getLogger(AuthenticationProvider.class);
	
	@Autowired
	private DBAuthenticationService authService;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
		String password = (String) authentication.getCredentials();
		
		logger.info("username : " + username);
		logger.info("password : " + password);
		
		User user = null;
		List<GrantedAuthority> authorities = null;
		
		user = (User)authService.loadUserByUsername(username);
		
		if(password.equals(user.getPassword())) {
			throw new BadCredentialsException("비밀번호가 일치하지 않습니다.");
		};
		
		return new UsernamePasswordAuthenticationToken(username, password, authorities);
	}
	
	@Override
	public boolean supports(Class<?> authentication) {
		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
	}
	
}
