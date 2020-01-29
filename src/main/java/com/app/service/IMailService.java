package com.app.service;

public interface IMailService {

	public boolean confirmOTP(String otp);

	public void sendMail(String email);
}
