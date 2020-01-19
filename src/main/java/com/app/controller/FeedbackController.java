package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Customer;
import com.app.pojos.Feedback;
import com.app.service.IFeedbackService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/feedback")
public class FeedbackController {

	@Autowired
	IFeedbackService feedbackService;

	@RequestMapping(value = "customerFeedback", method = RequestMethod.POST)
	public ResponseEntity<?> giveCustomerFeedback(@RequestBody Feedback feedback, @RequestBody Customer customer) {

		if (feedbackService.giveFeedback(feedback, customer)) {
			return new ResponseEntity<Boolean>(true, HttpStatus.OK);
		}
		return new ResponseEntity<String>("Feedback not submitted", HttpStatus.OK);
	}

	@RequestMapping(value = "maidFeedback", method = RequestMethod.POST)
	public ResponseEntity<?> giveMaidFeedback(@RequestBody Feedback feedback, @RequestBody Customer customer) {

		if (feedbackService.giveFeedback(feedback, customer)) {
			return new ResponseEntity<Boolean>(true, HttpStatus.OK);
		}
		return new ResponseEntity<String>("Feedback not submitted", HttpStatus.OK);
	}

	@RequestMapping(value = "getFeedback", method = RequestMethod.GET)
	public ResponseEntity<?> getFeedback(@RequestBody Integer id) {

		Feedback feedback = feedbackService.getFeedback(id);
		if (feedback != null) {
			return new ResponseEntity<Feedback>(feedback, HttpStatus.OK);
		}
		return new ResponseEntity<String>("There is no feedback available", HttpStatus.OK);
	}
}
