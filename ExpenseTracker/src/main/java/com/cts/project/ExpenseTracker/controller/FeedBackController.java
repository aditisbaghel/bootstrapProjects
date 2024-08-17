package com.cts.project.ExpenseTracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cts.project.ExpenseTracker.dao.Feedback;
import com.cts.project.ExpenseTracker.dao.FeedbackQuestion;
import com.cts.project.ExpenseTracker.dao.GetFeedback;
import com.cts.project.ExpenseTracker.dao.userid;
import com.cts.project.ExpenseTracker.service.FeedbackProcess;
import com.cts.project.ExpenseTracker.service.FeedbackService;


@Controller
public class FeedBackController {

	@Autowired
	FeedbackService service;

	@RequestMapping("/feedback")
	public String feedbackForUser(@ModelAttribute("feedback") Feedback feedbacks ,@ModelAttribute("userId")String userId) {
		System.out.println(userId);
		return "feedback";
	}
	
	@RequestMapping(value="/submitFeedback", method=RequestMethod.POST)
	public String submitFeedback(@ModelAttribute Feedback feedback,ModelMap model){
		
		model.addAttribute("feed", "Thank you for your feedback!");
		
		return "UserHome";
	}

	@ModelAttribute("questionList")
	public List question() {
		List<FeedbackQuestion> list = service.getAllQuestion();

		return list;
	}

	@Autowired
	private FeedbackProcess feedbackProcess;
	
	@RequestMapping(value = "/AddFeedback", method = RequestMethod.GET)
	public String addfeedback() {
		return "AddFeedback";
	}
	

	@RequestMapping(value = "/FinalAddFeedback", method = RequestMethod.POST)
	public String submitAddfeedback(@ModelAttribute("add") FeedbackQuestion feebbackQuestion ,@RequestParam String question,ModelMap model) {
		feedbackProcess.addQuestion(question);
		model.addAttribute("addmess","Question added successfully");
		return "AddFeedback";
	}
	
}
