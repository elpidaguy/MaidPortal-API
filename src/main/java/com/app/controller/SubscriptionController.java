package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Subscription;
import com.app.service.ISubscritionService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/subscription")
public class SubscriptionController {

	@Autowired
	ISubscritionService subscritionService;

	@RequestMapping(value = "/changeSubscription", method = RequestMethod.POST)
	public ResponseEntity<?> changeSubscription(@RequestBody Subscription subscription) {

		if (subscritionService.changeSubscription(subscription)) {
			return new ResponseEntity<Boolean>(true, HttpStatus.OK);
		}
		return new ResponseEntity<String>("Subscription cannot be changed", HttpStatus.OK);
	}

}
