//<<<<<<< HEAD:Source Code/ExpenseTracker/src/main/java/com/cts/project/ExpenseTracker/controller/ExpensesController.java
//package com.cts.project.ExpenseTracker.controller;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.validation.Valid;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.SessionAttributes;
//
//import com.cts.project.ExpenseTracker.dao.Expenses;
//import com.cts.project.ExpenseTracker.service.ExpensesService;
//
//@Controller
//@SessionAttributes("userId")
//public class ExpensesController {
//	@Autowired
//	ExpensesService service;
//
//	@RequestMapping(value = "/addExp", method = RequestMethod.GET)
//	public String vaddExp(@ModelAttribute("expenses") Expenses expenses) {
//		expenses = new Expenses();
//		return "AddExpenses";
//	}
//
//	@RequestMapping(value = "/addExp", method = RequestMethod.POST)
//	public String addExp(@ModelAttribute("expenses") @Valid Expenses expenses, BindingResult result, ModelMap model) {
//		if (result.hasErrors()) {
//			return "AddExpenses";
//		}
//		String userId = (String) model.get("userId");
//		if (service.addExp(expenses)) {
//			model.put("expensemsg", "Added Successfully");
//			return "UserHome";
//		} else {
//			model.put("expensemsg", "Error in adding the Expense");
//			return "UserHome";// unable to addd the account
//		}
//	}
//
//	@RequestMapping(value = "/viewExp", method = RequestMethod.GET)
//	public String viewExp(ModelMap map) {
//		String userId = (String) map.get("userId");
//		// String userId = "123456";
//		List<Expenses> expense = service.getExpenses(userId);
//		map.put("expense", expense);
//		return "ViewExpenses";
//	}
//
//	@RequestMapping(value = "/update-exp", method = RequestMethod.GET)
//	public String showUpdateExpense(@RequestParam int expid, ModelMap map,
//			@ModelAttribute("expenses") Expenses expenses) {
//		Expenses e = service.retiveExp(expid);
//		map.put("expense", e);
//		return "UpdateExpense";
//
//	}
//
//	@RequestMapping(value = "/update-exp", method = RequestMethod.POST)
//	public String updateExpenses(@ModelAttribute("expenses") @Valid Expenses expenses, BindingResult result,
//			ModelMap model) {
//
//		if (result.hasErrors()) {
//			return "AddExpenses";
//		}
//
//		expenses.setUserId((String) model.get("userId"));
//		// expenses.setUserId("123456");
//		service.updateExpense(expenses);
//
//		return "redirect:/viewExp";
//
//	}
//
//	@RequestMapping(value = "/delete-exp", method = RequestMethod.GET)
//	public String deleteExpense(@RequestParam int expid) {
//
//		service.deleteExp(expid);
//		return "redirect:/viewExp";
//	}
//
//	// auto populate productType;
//	@ModelAttribute("productType")
//	public List<String> getProductType() {
//		List<String> l = new ArrayList<String>();
//		l.add("Grocery");
//		l.add("Stationary");
//		l.add("Travel");
//		return l;
//	}
//}
//=======
package com.cts.project.ExpenseTracker.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cts.project.ExpenseTracker.dao.Expenses;
import com.cts.project.ExpenseTracker.service.ExpensesService;

@Controller
@SessionAttributes("userId")
public class ExpensesController {
	@Autowired
	ExpensesService service;

	@RequestMapping(value = "/addExp", method = RequestMethod.GET)
	public String vaddExp(@ModelAttribute("expenses") Expenses expenses) {
		expenses = new Expenses();
		return "AddExpenses";
	}

	@RequestMapping(value = "/addExp", method = RequestMethod.POST)
	public String addExp(@ModelAttribute("expenses") @Valid Expenses expenses, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "AddExpenses";
		}
		String userId = (String) model.get("userId");
		if (service.addExp(expenses)) {
			model.put("expensemsg", "Expense Added Successfully");
			return "UserHome";
		} else {
			model.put("expensemsg", "Error in adding the Expense");
			return "UserHome";// unable to addd the account
		}
	}

	@RequestMapping(value = "/viewExp", method = RequestMethod.GET)
	public String viewExp(ModelMap map) {
		String userId = (String) map.get("userId");
		// String userId = "123456";
		List<Expenses> expense = service.getExpenses(userId);
		map.put("expense", expense);
		return "ViewExpenses";
	}

	@RequestMapping(value = "/update-exp", method = RequestMethod.GET)
	public String showUpdateExpense(@RequestParam int expid, ModelMap map,
			@ModelAttribute("expenses") Expenses expenses) {
		Expenses e = service.retiveExp(expid);
		map.put("expense", e);
		return "UpdateExpense";

	}

	@RequestMapping(value = "/update-exp", method = RequestMethod.POST)
	public String updateExpenses(@ModelAttribute("expenses") @Valid Expenses expenses, BindingResult result,
			ModelMap model) {

		if (result.hasErrors()) {
			return "AddExpenses";
		}

		expenses.setUserId((String) model.get("userId"));
		// expenses.setUserId("123456");
		service.updateExpense(expenses);

		return "redirect:/viewExp";

	}

	@RequestMapping(value = "/delete-exp", method = RequestMethod.GET)
	public String deleteExpense(@RequestParam int expid) {

		service.deleteExp(expid);
		return "redirect:/viewExp";
	}

	// auto populate productType;
	@ModelAttribute("productType")
	public List<String> getProductType() {
		List<String> l = new ArrayList<String>();
		l.add("Grocery");
		l.add("Stationary");
		l.add("Travel");
		return l;
	}
}
//>>>>>>> b587a1f4d3f79b5373db6c047da677e374f2f2ab:ExpenseTracker/src/main/java/com/cts/project/ExpenseTracker/controller/ExpensesController.java
