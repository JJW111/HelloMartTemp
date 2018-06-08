package com.helloart.test.dao;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
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
		String username = "papayaza111";
		String postCode = "12345";
		String birthYear = "2000";
		
		Account account = new Account();
		
		account.setId(username);
		account.setPassword("practice123");
		account.setEMail("papayaza111@gmail.com");
		account.setPostCode(postCode);
		account.setRoadAddress("Road Address");
		account.setJibunAddress("Jibun Address");
		account.setDetailAddress("Detail Address");
		account.setPhone("010-1234-5678");
		account.setName("jjw");
		account.setBirthYear(birthYear);
		account.setBirthMonth("03");
		account.setBirthDay("01");
		account.setGender('F');
		
		
		/* 계정을 등록시킨다. */
		accountDao.insertAccount(account);
		
		/* 일치하는 아이디가 없는 계정 정보를 불러온다. */
		Account account2 = accountDao.get("papayaza222");
		
		/* null 값이라면 정상! */
		assertThat(account2, is(nullValue()));
		
		/* 일치하는 계정 정보를 불러온다. */
		Account account3 = accountDao.get(username);
		
		/* null 값이 아니라면 정상! */
		assertThat(account3, is(not(nullValue())));
		
		assertEquals(account3.getPostCode(), postCode);
		assertEquals(account3.getBirthYear(), birthYear);
		
		Account account4 = accountDao.findAccount(username);
		
		assertEquals(account4.getRole(), "MEMBER");
	}
	
}
