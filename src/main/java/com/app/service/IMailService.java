package com.app.service;

public interface IMailService {

	public boolean confirmOTP(String OTP);
	public void sendMail(String email);
}
