package com.hellomart.dao;

import com.hellomart.dto.Account;

public interface AccountDAO {
	/**
	 * <p>로그인 정보를 가져온다.
	 * 
	 * <ul>로그인 정보
	 * 	<li>PASSWORD
	 * 	<li>Authority
	 * </ul>
	 * 
	 * @return 로그인 정보를 담은 Account 객체
	 */
	Account findAccount(String id);
	
	/**
	 * 새로운 유저를 등록시킨다.
	 * 
	 * @param account 계정 정보를 담고있는 객체
	 */
	void insertAccount(Account account);
	
	/**
	 * id와 일치하는 계정을 삭제한다.
	 * 
	 * @param id 삭제할 계정의 아이디
	 */
	void deleteAccount(String id);

	/**
	 * 계정 테이블의 총 행의 수를 반환한다.
	 * 
	 * @return 계정 테이블의 총 행의 수
	 */
	int count();
	
	/**
	 * id와 일치하는 계정의 모든 정보를 가져온다. 테스트용으로 사용된다.
	 * 
	 * @param id 계정의 아이디
	 * @return 계정 정보를 담고 있는 Account 객체
	 */
	Account get(String id);
	
	/**
	 * 테이블을 초기화한다. 테스트용으로 사용된다.
	 */
	void truncate();
}
