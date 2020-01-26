package com.app.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl implements IMailService{
	
	String otp;
	
	@Autowired
	JavaMailSender mailSender;

//	public MailServiceImpl(JavaMailSender mailSender) {
//		this.mailSender = mailSender;
//	}
	
	public void sendMail(String email) {
		
			Random random = new Random();
			otp = ("OTP is " + random.nextInt(9999));
			SimpleMailMessage mail= new SimpleMailMessage();
			mail.setTo(email);
			//mail.setTo("cdacmaidportal@gmail.com");
			mail.setFrom("maidportalgajanan@gmail.com");
			mail.setSubject("Maid Portal OTP");
			mail.setText(otp);
			mailSender.send(mail);
	
	}

}
