package com.app.controller;

import javax.mail.internet.AddressException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.service.ICustomerService;
import com.app.service.IMaidService;
import com.app.service.IMailService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/email")
public class EmailController {
	
	//String otp;

	@Autowired
	JavaMailSender sender;

	@Autowired
	ICustomerService customerSrvice;
	
	@Autowired
	IMailService mailService;

	@Autowired
	IMaidService maidService;

	@RequestMapping(value="/confirmOTP",method= RequestMethod.POST)
	public ResponseEntity<String> confirmOTP(@RequestParam String OTP){
		if(mailService.confirmOTP(OTP)) {
			return new ResponseEntity<String>("OTP Confirmed",HttpStatus.OK);
		}
		return new ResponseEntity<String>("Invalid OTP", HttpStatus.OK);
	}
	
	@RequestMapping(value = "/sendMail", method = RequestMethod.POST)
	public ResponseEntity<String> sendMail(@RequestParam String email) throws AddressException {
		
	if (customerSrvice.getCustomerByEmail(email) != null || maidService.getMaidByEmail(email) != null) {
		mailService.sendMail(email);
			return new ResponseEntity<String>("Email Sent", HttpStatus.OK);
		}
		return new ResponseEntity<String>("Invalid email", HttpStatus.OK);

	}
}
	
	






	
	
	//String replyTO=new InternetAddress(email);
//	if (customerSrvice.getCustomerByEmail(email) != null
//			|| maidService.getMaidByEmail(email) != null) {
	
//		Random random = new Random();
//		otp = ("OTP is " + random.nextInt(9999));
//		SimpleMailMessage message = new SimpleMailMessage();
//		message.setFrom("maidportalgajanan@gmail.com");	
//		
//		//message.setTo("cdacmaidportal@gmail.com");
//	
//		message.setTo(email);
//		message.setSubject("Maid portal otp");
//		message.setText(otp);
//		sender.send(message);
		

