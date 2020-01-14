package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.*;
 
import javax.validation.constraints.*;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="tbl_maids")
public class Maid extends AbstractEntity {
	
	private String firstName, lastName, userName, email, phone, password, defaultAddressId, imgUrl, aadharCardNo;
	private double salary;
	private boolean _isActive;
	private LocalDate dateCreated;
	private MaritalStatus maritalStatus;
	private Gender gender;
	
	
	public Maid()
	{}
	
	
	public Maid(String firstName, String lastName, String userName, String email, String phone, String password,
			String defaultAddressId, String imgUrl, String aadharCardNo, boolean _isActive, LocalDate dateCreated,
			MaritalStatus maritalStatus, Gender gender, double salary) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.defaultAddressId = defaultAddressId;
		this.imgUrl = imgUrl;
		this.aadharCardNo = aadharCardNo;
		this._isActive = _isActive;
		this.dateCreated = dateCreated;
		this.maritalStatus = maritalStatus;
		this.gender = gender;
		this.salary = salary;
	}

	@NotEmpty
	@Column(length = 30, name = "first_name")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@NotEmpty
	@Column(length = 30, name = "last_name")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@NotEmpty
	@Column(length = 30, name = "username")
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@NotEmpty
	@Length(min = 5, max = 25)
	@Email(message = "Please Enter Valid Email Address!")
	@Column(length = 35, name = "email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(length = 15, name = "phone")
	@NotEmpty
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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

	@NotEmpty
	@NotNull
	@NotBlank
	@Column(length = 15, name = "aadharCardNo")
	@Length(min = 12, max = 12)
	public String getAadharCardNo() {
		return aadharCardNo;
	}

	public void setAadharCardNo(String aadharCardNo) {
		this.aadharCardNo = aadharCardNo;
	}

	@Column(name = "defaultAddressId")
	public String getDefaultAddressId() {
		return defaultAddressId;
	}

	public void setDefaultAddressId(String defaultAddressId) {
		this.defaultAddressId = defaultAddressId;
	}

	@Column(name = "_isActive")
	public boolean is_isActive() {
		return _isActive;
	}

	public void set_isActive(boolean _isActive) {
		this._isActive = _isActive;
	}

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "dateCreated")
	public LocalDate getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(LocalDate dateCreated) {
		this.dateCreated = dateCreated;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "marital_status")
	public MaritalStatus getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(MaritalStatus maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "gender")
	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	@Column(name = "img_url")
	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	
	@Column(name = "salary")
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	
	@Override
	public String toString() {
		return "Maid [firstName=" + firstName + ", lastName=" + lastName + ", userName=" + userName + ", email=" + email
				+ ", phone=" + phone + ", password=" + password + ", defaultAddressId=" + defaultAddressId + ", imgUrl="
				+ imgUrl + ", aadharCardNo=" + aadharCardNo + ", _isActive=" + _isActive + ", dateCreated="
				+ dateCreated + ", maritalStatus=" + maritalStatus + ", gender=" + gender + ", salary=" + salary + "]";
	}
}
