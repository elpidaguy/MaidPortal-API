package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "tbl_admins")
public class Admin extends AbstractEntity {

	private static final long serialVersionUID = 1L;
	private String email, password;
	private LocalDate createdDate;

	public Admin() {
	}

	public Admin(String email, String password, LocalDate createdDate) {
		super();
		this.email = email;
		this.password = password;
		this.createdDate = createdDate;
	}

	@NotEmpty
	@Length(min = 5, max = 55)
	@Email(message = "Please Enter Valid Email Address!")
	@Column(length = 55, name = "email", unique = true)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@NotEmpty
	@Pattern(regexp = "((?=.*\\d)(?=.*[a-z])(?=.*[#@$*]).{5,20})", message = "Password should be between length 5 to 20 and contain atleast 1 digit and 1 special characters.")
	@Column(name = "password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "created_date")
	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	@Override
	public String toString() {
		return "Admin [email=" + email + ", password=" + password + ", createdDate=" + createdDate + "]";
	}

}
