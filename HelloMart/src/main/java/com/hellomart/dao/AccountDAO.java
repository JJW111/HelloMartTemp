package com.hellomart.dao;

import com.hellomart.dto.Account;

public interface AccountDAO {
	/**
	 * <p>로그인 정보를 가져온다.
	 * 
	 * <ul>로그인 정보
	 * 	<li>ID
	 * 	<li>PASSWORD
	 * 	<li>Authority
	 * </ul>
	 * 
	 * @return 로그인 정보를 담은 Account 객체
	 */
	Account getLoginInfo(String id);
	
	void insertAccount(Account account);
	
	void deleteAccount(String id);
	
	void deleteAll();
}
