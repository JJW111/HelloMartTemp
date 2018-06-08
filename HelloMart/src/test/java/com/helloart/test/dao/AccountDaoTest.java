package com.helloart.test.dao;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.notNullValue;
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
	
	private AccountDAO dao;
	
	private String id = "papayaza111";
	private String password = "practice123";
	private String role = "MEMBER";
	private int points = 0;
	private int grade = 0;
	private String eMail = "papayaza111@gmail.com";
	private String postCode = "12345";
	private String roadAddress = "Road Address";
	private String jibunAddress = "Jibun Address";
	private String detailAddress = "Detail Address";
	private String phone = "010-1234-5678";
	private String name = "jjw";
	private String birthYear = "2000";
	private String birthMonth = "03";
	private String birthDay = "01";
	private char gender = 'F';
	
	@Before
	public void before() {
		dao = sqlSession.getMapper(AccountDAO.class);
		dao.truncate();
	}
	
	@After
	public  void after() {
		dao.truncate();
	}
	
	private Account getNewAccount() {
		Account account = new Account();
		
		account.setId(id);
		account.setPassword(password);
		account.setEMail(eMail);
		account.setPostCode(postCode);
		account.setRoadAddress(roadAddress);
		account.setJibunAddress(jibunAddress);
		account.setDetailAddress(detailAddress);
		account.setPhone(phone);
		account.setName(name);
		account.setBirthYear(birthYear);
		account.setBirthMonth(birthMonth);
		account.setBirthDay(birthDay);
		account.setGender(gender);
		
		return account;
	}
	
	private void equals(Account a1, Account a2) {
		assertEquals(a1.getId(), a2.getId());					
		assertEquals(a1.getPassword(), a2.getPassword());
		assertEquals(a2.getRole(), role);
		assertEquals(a2.getPoints(), points);
		assertEquals(a2.getGrade(), grade);
		assertEquals(a1.getEMail(), a2.getEMail());
		assertEquals(a1.getPostCode(), a2.getPostCode());
		assertEquals(a1.getRoadAddress(), a2.getRoadAddress());
		assertEquals(a1.getJibunAddress(), a2.getJibunAddress());
		assertEquals(a1.getDetailAddress(), a2.getDetailAddress());
		assertEquals(a1.getPhone(), a2.getPhone());
		assertEquals(a1.getName(), a2.getName());
		assertEquals(a1.getBirthYear(), a2.getBirthYear());
		assertEquals(a1.getBirthMonth(), a2.getBirthMonth());
		assertEquals(a1.getBirthDay(), a2.getBirthDay());
		assertEquals(a1.getGender(), a2.getGender());
		assertEquals(a2.getReliability(), 0);
		assertThat(a2.getJoinDate(), is(notNullValue()));
	}
	
	@Test
	public void insertAccountTest() {
		Account account = getNewAccount();
		
		/* 계정을 등록시킨다. */
		dao.insertAccount(account);
		
		/* 한 개의 행이 존재하는지 확인한다. */
		int count = dao.count();
		assertEquals(count, 1);
		
		/* 일치하는 아이디가 없는 계정 정보를 불러온다. */
		Account account2 = dao.get("papayaza222");
		
		/* null 값이라면 정상! */
		assertThat(account2, is(nullValue()));
		
		/* 일치하는 계정 정보를 불러온다. */
		Account account3 = dao.get(id);
		
		/* null 값이 아니라면 정상! */
		assertThat(account3, is(not(nullValue())));
		
		equals(account, account3);
	}
	
}
