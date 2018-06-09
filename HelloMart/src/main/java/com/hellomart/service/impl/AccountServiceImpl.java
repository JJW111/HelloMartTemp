package com.hellomart.service.impl;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hellomart.dao.AccountDAO;
import com.hellomart.dto.Account;
import com.hellomart.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(AccountService.class);
	
	@Autowired
	private SqlSession sqlSession;
	
	public AccountServiceImpl() {
	}
	
	@Override
	public Account findAccount(String id) {
		AccountDAO dao = sqlSession.getMapper(AccountDAO.class);
		return dao.findAccount(id);
	}
	
	@Override
	public void insertAccount(Account account) {
		AccountDAO dao = sqlSession.getMapper(AccountDAO.class);
		dao.insertAccount(account);
	}

	@Override
	public void deleteAccount(String id) {
		AccountDAO dao = sqlSession.getMapper(AccountDAO.class);
		dao.deleteAccount(id);
	}

	@Override
	public int count() {
		AccountDAO dao = sqlSession.getMapper(AccountDAO.class);
		return dao.count();
	}

}
