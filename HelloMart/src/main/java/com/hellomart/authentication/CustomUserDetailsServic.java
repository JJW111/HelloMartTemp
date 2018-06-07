package com.hellomart.authentication;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hellomart.dao.AccountDAO;
import com.hellomart.dto.Account;

@Service
public class CustomUserDetailsServic implements UserDetailsService {
	
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(CustomUserDetailsServic.class);
	
	@Autowired
	private SqlSession sqlSession;
	
	private AccountDAO dao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		dao = sqlSession.getMapper(AccountDAO.class);
		
		Account account = dao.getLoginInfo(username);
		
		if(account == null) {
			throw new UsernameNotFoundException("존재하지 않는 계정입니다.");
		}
		
		String role = account.getRole();
		
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		
		GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + role);
		
		authorities.add(authority);
		
        UserDetails userDetails = (UserDetails) new User(account.getId(), account.getPassword(), authorities);
        
		return userDetails;
	}
	
}
