package com.app.pojos;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "tbl_customers")
public class Customer extends AbstractEntity {

	private static final long serialVersionUID = 1L;
	private String firstName, lastName, email, phone, password, imgUrl;
	private String aadharCardNo;
	private boolean _isActive;
	private LocalDate dateCreated;
	private MaritalStatus maritalStatus;
	private Gender gender;
	private Address address;
	private List<Salary> salaryList; // HELPER METHOD
	private Subscription subscription;
	private Feedback feedback;
	// private List<UserAddress> UserAddressList;//address spell check required.

	public Customer() {
	}

	// @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval =
	// true)
	@OneToOne
	@JoinColumn(name = "feedback_id")
//	@JsonIgnore
	public Feedback getFeedback() {
		return feedback;
	}

	public void setFeedback(Feedback feedback) {
		this.feedback = feedback;
	}

	// @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval =
	// true)
	// @JsonIgnore
	@OneToOne
	@JoinColumn(name = "subscription_id")
	public Subscription getSubscription() {
		return subscription;
	}

	public void setSubscription(Subscription subscription) {
		this.subscription = subscription;
	}

	// @JsonIgnore
	/*
	 * <<<<<<< HEAD //@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL,
	 * orphanRemoval = true)
	 * 
	 * @OneToMany(mappedBy = "customer") =======
	 */
	@OneToMany(mappedBy = "customer") // , cascade = CascadeType.ALL, orphanRemoval = true)

	public List<Salary> getSalaryList() {
		return salaryList;
	}

	public void setSalaryList(List<Salary> salaryList) {
		this.salaryList = salaryList;
	}

	// TODO: confirm this if its working or not
	@OneToOne
	@JoinColumn(name = "address_id")
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
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

	/*
	 * @NotEmpty
	 * 
	 * @Column(length = 30, name = "username") public String getUserName() { return
	 * userName; }
	 * 
	 * public void setUserName(String userName) { this.userName = userName; }
	 */
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

	@Column(length = 15, name = "phone", unique = true)
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
	@Column(length = 15, name = "aadharCardNo", unique = true)
	@Length(min = 12, max = 12)
	public String getAadharCardNo() {
		return aadharCardNo;
	}

	public void setAadharCardNo(String aadharCardNo) {
		this.aadharCardNo = aadharCardNo;
	}

	public boolean is_isActive() {
		return _isActive;
	}

	public void set_isActive(boolean _isActive) {
		this._isActive = _isActive;
	}

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "created_date")
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
		return "Customer [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", phone=" + phone
				+ ", password=" + password + ", imgUrl=" + imgUrl + ", aadharCardNo=" + aadharCardNo + ", _isActive="
				+ _isActive + ", dateCreated=" + dateCreated + ", maritalStatus=" + maritalStatus + ", gender=" + gender
				+ ", address=" + address + ", salaryList=" + salaryList + ", subscription=" + subscription
				+ ", feedback=" + feedback + "]";
	}

	/*
	 * public void addSalary(Salary sal) { salaryList.add(sal);
	 * sal.setCustomer(this); }
	 * 
	 * public void removeSalary(Salary sal) { salaryList.remove(sal);
	 * sal.setCustomer(null);
	 * 
	 * }
	 */
	/*
	 * public void addAddress(Address add) { add.setUser(this); }
	 * 
	 * public void removeAddress(Address add) { add.setUser(null); }
	 */
}
