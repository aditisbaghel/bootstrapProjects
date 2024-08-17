package com.cts.project.ExpenseTracker.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cts.project.ExpenseTracker.service.ExpensesService;

@Controller
public class AdminController {

	@Autowired
	private ExpensesService service;

	// SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");

	@RequestMapping("/viewOneDayExpense")
	public String viewOneDayExpense(@RequestParam("viewOneDayExpense") @DateTimeFormat(iso = ISO.DATE) Date date,
			ModelMap map) throws ParseException {
		map.put("expense", service.getOneDayExpense(date));
		map.put("time", new Date());
		return "ViewAdminExpense";
	}

	@RequestMapping("/viewMonthlyExpense")
	public String viewMonthlyExpense(@RequestParam("viewMonthlyExpense") @DateTimeFormat(iso = ISO.DATE) Date date, ModelMap map) {
		System.out.println();
		map.put("expense", service.viewMonthlyExpense(date));
		map.put("time", new Date());
		return "ViewAdminExpense";
	}

	@RequestMapping("/viewYearlyExpense")
	public String viewYearlyExpense(@RequestParam("viewYearlyExpense") @DateTimeFormat(iso = ISO.DATE) Date date, ModelMap map) {

		map.put("expense", service.viewYearlyExpense(date));
		map.put("time", new Date());
		return "ViewAdminExpense";
	}
	
	@RequestMapping("/viewDayExpense")
	public String viewDayExpense(@RequestParam("fromDate") @DateTimeFormat(iso = ISO.DATE) Date fromDate,@RequestParam("toDate") @DateTimeFormat(iso = ISO.DATE) Date toDate, ModelMap map){
		map.put("expense", service.getExpensesBetweenDates(fromDate,toDate));
		map.put("time", new Date());
		return "ViewAdminExpense";
	}
	
	@RequestMapping(value="/backToAdminHome")
	public String backToAdminHome(){
		return "AdminHome";
	}

}
