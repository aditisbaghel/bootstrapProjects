package com.cts.project.ExpenseTracker.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cts.project.ExpenseTracker.dao.Expenses;

@Service
public interface ExpensesService {

	public boolean addExp(Expenses expenses);

	public List<Expenses> getExpenses(String userId);

	public void deleteExp(int expenseId);

	public Expenses retiveExp(int expenseId);

	public int getNewExpId();

	public void updateExpense(Expenses expenses);

	public List<Expenses> getOneDayExpense(Date date);
	
	public List<Expenses> viewMonthlyExpense(Date date);
	
	public List<Expenses> viewYearlyExpense(Date date);

	public Object getExpensesBetweenDates(Date fromDate, Date toDate);

}
