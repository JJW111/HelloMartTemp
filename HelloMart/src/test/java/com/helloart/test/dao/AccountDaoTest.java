package com.helloart.test.dao;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hellomart.dao.AccountDAO;
import com.hellomart.dto.Account;
import com.hellomart.dto.Address;
import com.hellomart.dto.BirthDate;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={ "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class AccountDaoTest {
	
	private static final Logger logger = LoggerFactory.getLogger(AccountDaoTest.class);
	
	@Autowired
	private SqlSession sqlSession;
	
	private AccountDAO accountDao;
	
	@Before
	public void before() {
		accountDao = sqlSession.getMapper(AccountDAO.class);
		accountDao.truncate();
	}
	
	@After
	public  void after() {
//		accountDao.truncate();
	}
	
	@Test
	public void insertAccountTest() {
		Account account = new Account();
		
		account.setId("papayaza111");
		account.setPassword("practice123");
		account.setRole("MEMBER");
		account.setEMail("papayaza111@gmail.com");
		account.setAddress(new Address(
				"12345",
				"Road Address",
				"Jibun Address",
				"Detail Address"
				));
		account.setPhone("010-1234-5678");
		account.setName("jjw");
		account.setBirthDate(new BirthDate("2000", "03", "01"));
		account.setGender('F');
		
		
		/* 계정을 등록시킨다. */
		accountDao.insertAccount(account);
		
		/* 일치하는 아이디가 없는 계정 정보를 불러온다. */
		Account account2 = accountDao.get("papayaza222");
		
		/* null 값이라면 정상! */
		assertThat(account2, is(nullValue()));
		
		/* 일치하는 계정 정보를 불러온다. */
		Account account3 = accountDao.get("papayaza111");
		
		/* null 값이 아니라면 정상! */
		assertThat(account3, is(notNullValue()));
	}
	
}
