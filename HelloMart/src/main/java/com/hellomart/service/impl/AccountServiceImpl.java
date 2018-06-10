package com.hellomart.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hellomart.dao.AccountDAO;
import com.hellomart.dto.Account;
import com.hellomart.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	private static final Logger logger = LoggerFactory.getLogger(AccountService.class);
	
	@Autowired
	private AccountDAO dao;
	
	public AccountServiceImpl() {
	}
	
	@Override
	public Account findAccount(String id) {
		return dao.findAccount(id);
	}
	
	@Override
	public void insertAccount(Account account) {
		logger.debug(account.toString());
		dao.insertAccount(account);
	}

	@Override
	public void deleteAccount(String id) {
		dao.deleteAccount(id);
	}

	@Override
	public int count() {
		return dao.count();
	}

}
