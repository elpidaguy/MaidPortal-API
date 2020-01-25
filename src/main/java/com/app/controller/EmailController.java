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

import com.app.service.ICustomerService;
import com.app.service.IMaidService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/email")
public class EmailController {
	
	String otp;

	@Autowired
	JavaMailSender sender;

	@Autowired
	ICustomerService customerSrvice;

	@Autowired
	IMaidService maidService;

	@RequestMapping(value = "/sendMail", method = RequestMethod.POST)
	public ResponseEntity<String> sendMail(@RequestBody String email) {

		if (customerSrvice.getCustomerByEmail(email) != null
				|| maidService.getMaidByEmail(email) != null) {
			Random random = new Random();
			otp = ("OTP is " + random.nextInt(9999));
			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom("cdacmaidportal@gmail.com");
			message.setTo(email);
			message.setSubject("Maid portal otp");
			message.setText(otp);
			sender.send(message);
			return new ResponseEntity<String>("Email Sent", HttpStatus.OK);
		}
		return new ResponseEntity<String>("Invalid email", HttpStatus.OK);

	}

}
