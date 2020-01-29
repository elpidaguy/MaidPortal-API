package com.app.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl implements IMailService {

	static String otp;

	@Autowired
	JavaMailSender mailSender;

	public boolean confirmOTP(String OTP) {
		System.out.println(otp);
		if (otp.equals(OTP)) {
			// System.out.println("equals is OK in MailService");
			return true;
		}
		// System.out.println(" NOT OK in MailService");
		return false;
	}

	public void sendMail(String email) {
		String otpMsg;
		Random random = new Random();
		Integer number = random.nextInt(9999);
		otp = number.toString();
		otpMsg = ("OTP is " + otp);
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(email);
		// mail.setTo("cdacmaidportal@gmail.com");
		mail.setFrom("maidportalgajanan@gmail.com");
		mail.setSubject("Maid Portal OTP");
		mail.setText(otpMsg);
		mailSender.send(mail);

	}

}
