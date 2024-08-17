package com.cts.project.ExpenseTracker.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cts.project.ExpenseTracker.dao.Account;
import com.cts.project.ExpenseTracker.dao.User;

@Service
public interface AccountService {

	public Boolean addacc(Account account);

	public List<Account> retiveAccount(String userId);



}
