package com.app.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Email;
import com.app.service.ICustomerService;
import com.app.service.IMaidService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
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
	public ResponseEntity<String> sendMail(@RequestBody Email email) {

		if (customerSrvice.getCustomerByEmail(email.getDestEmail()) == null) {
			return new ResponseEntity<String>("Invalid email", HttpStatus.OK);
		}
		if (maidService.getMaidByEmail(email.getDestEmail()) == null) {
			return new ResponseEntity<String>("Invalid email", HttpStatus.OK);
		}
		Random random = new Random();
		email.setMessage("OTP is " + random.nextInt(9999));
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(email.getDestEmail());
		message.setSubject(email.getSubject());
		message.setText(email.getMessage());
		sender.send(message);
		return new ResponseEntity<String>("Email Sent", HttpStatus.OK);
	}

}
