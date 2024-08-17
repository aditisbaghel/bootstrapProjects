package com.cts.project.ExpenseTracker.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import com.cts.project.ExpenseTracker.dao.Expenses;

@Service
public class ExpensesServiceImpl implements ExpensesService {
	@Autowired
	JdbcTemplate jdbc;

	// have to work on sql to util date and vice a versa conversions
	@Override
	public boolean addExp(Expenses expenses) {
		expenses.setExpenseId(getNewExpId());
		int update = jdbc.update("insert into expence(pType,price,product,date,expenseId,userId) values(?,?,?,?,?,?);",
				expenses.getpType(), expenses.getPrice(), expenses.getProduct(), expenses.getDate(),
				expenses.getExpenseId(), expenses.getUserId());

		if (update == 1) {
			System.out.println("expense added succss" + expenses);
			return true;
		} else
			return false;
	}

	@Override
	public List<Expenses> getExpenses(String userId) {
		// select * from expence where userId=?,userId
		List<Expenses> fexpense = new ArrayList<>();
		SqlRowSet queryForRowSet = jdbc.queryForRowSet("select * from expence where userId=?", userId);
		while (queryForRowSet.next()) {
			fexpense.add(new Expenses(queryForRowSet.getInt("expenseId"), queryForRowSet.getString("userId"),
					queryForRowSet.getString("pType"), queryForRowSet.getDouble("price"),
					queryForRowSet.getString("product"), queryForRowSet.getDate("date")));
		}

		return fexpense;
	}

	@Override
	public void deleteExp(int expenseId) {

		jdbc.update("delete from expence where expenseId=?", expenseId);

	}

	@Override
	public Expenses retiveExp(int expenseId) {
		// select * from expence where expenceID=?,expenseId
		List<Expenses> fexpense = new ArrayList<>();
		SqlRowSet queryForRowSet = jdbc.queryForRowSet("select * from expence where expenseId=?", expenseId);
		while (queryForRowSet.next()) {
			fexpense.add(new Expenses(queryForRowSet.getInt("expenseId"), queryForRowSet.getString("userId"),
					queryForRowSet.getString("pType"), queryForRowSet.getDouble("price"),
					queryForRowSet.getString("product"), queryForRowSet.getDate("date")));
		}

		for (Expenses e : fexpense) {
			if (e.getExpenseId() == expenseId) {
				return e;
			}
		}
		return null;
	}

	@Override
	public int getNewExpId() {
		int total = jdbc.queryForObject("select max(expenseId) from expence", Integer.class);
		int max = total;
		max++;
		return max;
	}

	@Override
	public void updateExpense(Expenses expenses) {
		jdbc.update("update  expence set pType=?,price=?,product=?,date=? where expenseId=?", expenses.getpType(),
				expenses.getPrice(), expenses.getProduct(), expenses.getDate(), expenses.getExpenseId());

	}

	@Override
	public List<Expenses> getOneDayExpense(Date date) {

		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		List<Expenses> fexpense = new ArrayList<>();
		SqlRowSet queryForRowSet = jdbc.queryForRowSet("select * from expence where date=?", sqlDate);
		while (queryForRowSet.next()) {
			System.out.println("rowset query");
			fexpense.add(new Expenses(queryForRowSet.getInt("expenseId"), queryForRowSet.getString("userId"),
					queryForRowSet.getString("pType"), queryForRowSet.getDouble("price"),
					queryForRowSet.getString("product"), queryForRowSet.getDate("date")));
		}
		return fexpense;

	}

	@Override
	public List<Expenses> viewMonthlyExpense(Date date) {
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		List<Expenses> fexpense = new ArrayList<>();
		SqlRowSet queryForRowSet = jdbc.queryForRowSet("select * from expence where date<=? and date>=?", sqlDate,
				subtractDays(sqlDate, 30));
		while (queryForRowSet.next()) {
			fexpense.add(new Expenses(queryForRowSet.getInt("expenseId"), queryForRowSet.getString("userId"),
					queryForRowSet.getString("pType"), queryForRowSet.getDouble("price"),
					queryForRowSet.getString("product"), queryForRowSet.getDate("date")));
		}

		return fexpense;

	}

	@Override
	public List<Expenses> viewYearlyExpense(Date date) {
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		List<Expenses> fexpense = new ArrayList<>();
		SqlRowSet queryForRowSet = jdbc.queryForRowSet("select * from expence where date<=? and date>=?", sqlDate,
				subtractDays(sqlDate, 365));
		while (queryForRowSet.next()) {
			fexpense.add(new Expenses(queryForRowSet.getInt("expenseId"), queryForRowSet.getString("userId"),
					queryForRowSet.getString("pType"), queryForRowSet.getDouble("price"),
					queryForRowSet.getString("product"), queryForRowSet.getDate("date")));
		}

		return fexpense;

	}

	public static Date subtractDays(Date date, int days) {
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);
		cal.add(Calendar.DATE, -days);

		return cal.getTime();
	}

	@Override
	public List<Expenses> getExpensesBetweenDates(Date fromDate, Date toDate) {
		java.sql.Date sqlDateFrom = new java.sql.Date(fromDate.getTime());
		java.sql.Date sqlDateTo = new java.sql.Date(toDate.getTime());
		List<Expenses> fexpense = new ArrayList<>();
		SqlRowSet queryForRowSet = jdbc.queryForRowSet("select * from expence where date>=? and date<=?", sqlDateFrom,
				sqlDateTo);
		while (queryForRowSet.next()) {
			fexpense.add(new Expenses(queryForRowSet.getInt("expenseId"), queryForRowSet.getString("userId"),
					queryForRowSet.getString("pType"), queryForRowSet.getDouble("price"),
					queryForRowSet.getString("product"), queryForRowSet.getDate("date")));
		}
		System.out.println("admin day expense"+fexpense);

		return fexpense;
	}

}
