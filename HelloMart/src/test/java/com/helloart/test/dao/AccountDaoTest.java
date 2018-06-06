package com.helloart.test.dao;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hellomart.dao.AccountDAO;
import com.hellomart.dto.Account;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={ "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class AccountDaoTest {
	
	@Autowired
	private SqlSession sqlSession;
	
	private AccountDAO accountDao;
	
	@Before
	public void init() {
		accountDao = sqlSession.getMapper(AccountDAO.class);
	}
	
	@Test
	public void selectLoginInfo() {
		Account account = new Account();
		
		account.setId("papayaza111");
		account.setPassword("practice123");
		account.setRole("MEMBER");
		account.setEMail("papayaza111@gmail.com");
		account.setAddress("address");
		account.setPhone("010-1234-5678");
		account.setName("jjw");
		account.setBirthDate("20000301");
		account.setGender('F');
		
		
		/* 작업 실행 전 데이터를 전부 삭제한다.*/
		accountDao.deleteAll();

		/* 계정을 등록시킨다. */
		accountDao.insertAccount(account);
		
		/* 일치하는 아이디가 없는 계정 정보를 불러온다. */
		Account account2 = accountDao.getLoginInfo("papayaza222");
		
		/* null 값이라면 정상! */
		assertThat(account2, is(nullValue()));
		
		/* 작업 실행 후 데이터를 전부 삭제한다. */
		accountDao.deleteAll();
	}
	
}
