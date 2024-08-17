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
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cts.project.ExpenseTracker.dao.Account;
import com.cts.project.ExpenseTracker.service.AccountService;

@Controller
@SessionAttributes("userId")
public class AccountController {
	@Autowired
	AccountService service;

	@RequestMapping(value = "/addAccount", method = RequestMethod.GET)
	public String vaddacc(@ModelAttribute("account") Account account) {
		account = new Account();
		return "AddAccount";
	}

	@RequestMapping(value = "/addAccount", method = RequestMethod.POST)
	public String addacc(@ModelAttribute("account") @Valid Account account, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "AddAccount";
		} else {
			//
			if (service.addacc(account)) {
				model.put("accountmsg", "Account has been added successfullly");
				return "UserHome";
			} else {
				model.put("accountmsg", "Error in adding the account");
				return "UserHome";// unable to addd the account
			}
		}

	}

	@RequestMapping(value = "/viewIncome", method = RequestMethod.GET)
	public String viewIncome(ModelMap model) {
		// view curry +data
		String userId = (String) model.get("userId");
		// String userId = "123456";
		model.put("account", service.retiveAccount(userId));
		return "ViewIncome";

	}

	@RequestMapping(value = "/viewAccount", method = RequestMethod.GET)
	public String viewacc(ModelMap model) {
		// view data
		String userId = (String) model.get("userId");
		// String userId = "123456";
		model.put("account", service.retiveAccount(userId));

		return "ViewAccount";

	}
	
	
	@RequestMapping(value="/backToUserHome")
	public String backToUserHome(){
		return "UserHome";
	}

	@ModelAttribute("accountType")
	public List<String> listAccountType() {
		// auto populate the data from the account type
		ArrayList<String> atype = new ArrayList<>();
		atype.add("Current");
		atype.add("Saving");
		return atype;
	}


	@ModelAttribute("currency")
	public List<String> listCurrency() {
		// auto populate the data from the currency
		ArrayList<String> ctype = new ArrayList<>();
		ctype.add("USD");
		ctype.add("INR");
		// ctype.add("");
		return ctype;
	}
}
