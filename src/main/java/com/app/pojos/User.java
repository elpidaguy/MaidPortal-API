package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "tbl_users")
public class User extends AbstractEntity {

	private String firstName, lastName, userName, email, phone, password, defaultAddressId, imgUrl;
	private String aadharCardNo;
	private boolean _isActive;
	private LocalDate dateCreated;
	private MaritalStatus maritalStatus;
	private Gender gender;

	public User() {
	}

	public User(String firstName, String lastName, String userName, String email, String phone, String password,
			String aadharCardNo, String defaultAddressId, boolean _isActive, LocalDate dateCreated,
			MaritalStatus maritalStatus, Gender gender, String imgUrl) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.aadharCardNo = aadharCardNo;
		this.defaultAddressId = defaultAddressId;
		this._isActive = _isActive;
		this.dateCreated = dateCreated;
		this.maritalStatus = maritalStatus;
		this.gender = gender;
		this.imgUrl = imgUrl;
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

	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", userName=" + userName + ", email=" + email
				+ ", phone=" + phone + ", password=" + password + ", aadharCardNo=" + aadharCardNo
				+ ", defaultAddressId=" + defaultAddressId + ", _isActive=" + _isActive + ", dateCreated=" + dateCreated
				+ ", maritalStatus=" + maritalStatus + ", gender=" + gender + ", imgUrl=" + imgUrl + "]";
	}
}
