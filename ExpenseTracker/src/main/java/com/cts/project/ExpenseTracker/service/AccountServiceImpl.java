package com.cts.project.ExpenseTracker.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import com.cts.project.ExpenseTracker.dao.Account;
import com.cts.project.ExpenseTracker.dao.User;

@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	JdbcTemplate jdbc;

	@Override
	public List<Account> retiveAccount(String userId) {
		List<Account> filteredAccount = new ArrayList<Account>();

		SqlRowSet queryForRowSet = jdbc.queryForRowSet("select * from account where userId=?", userId);
		while (queryForRowSet.next()) {
			filteredAccount.add(new Account(queryForRowSet.getString("userId"), queryForRowSet.getString("accountNo"),
					queryForRowSet.getString("name"), queryForRowSet.getString("accType"),
					queryForRowSet.getString("IFSC"), queryForRowSet.getString("currencyType")));
		}

		return filteredAccount;

	}

	@Override
	public Boolean addacc(Account account) {

		int update = jdbc.update(
				"insert into account(accountNo,name,accType,IFSC,currencyType,userId)  values (?,?,?,?,?,?) ;",
				account.getAccountNo(), account.getName(), account.getAccType(), account.getIFSC(),
				account.getCurrType(), account.getUserId());

		if (update == 1) {
			System.out.println("account added" + account);
			return true;
		} else
			return false;
	}

	
}
