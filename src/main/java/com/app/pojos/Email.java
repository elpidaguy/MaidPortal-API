package com.app.pojos;

public class Email {

	private String destEmail;
	private String message;
	private String subject;

	public Email() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Email(String destEmail, String message, String subject) {
		super();
		this.destEmail = destEmail;
		this.message = message;
		this.subject = subject;
	}

	public String getDestEmail() {
		return destEmail;
	}

	public void setDestEmail(String destEmail) {
		this.destEmail = destEmail;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

}
