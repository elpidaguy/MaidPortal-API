package com.app.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.service.ICustomerService;
import com.app.service.IMaidService;

@RestController
@RequestMapping("/email")
public class EmailController {

	@Autowired
	JavaMailSender sender;

	@Autowired
	ICustomerService customerSrvice;

	@Autowired
	IMaidService maidService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<String> sendMail(@RequestBody String email) {

		if (customerSrvice.getCustomerByEmail(email) == null) {
			return new ResponseEntity<String>("Invalid email", HttpStatus.OK);
		}
		if (maidService.getMaidByEmail(email) == null) {
			return new ResponseEntity<String>("Invalid email", HttpStatus.OK);
		}
		Random random = new Random();
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(email);
		message.setSubject("OTP");
		message.setText("OTP is " + random.nextInt(9999));
		sender.send(message);
		return new ResponseEntity<String>("Email Sent", HttpStatus.OK);
	}

}
