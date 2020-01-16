package com.app.pojos;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
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
@Table(name = "tbl_maids")
public class Maid extends AbstractEntity {

	private String firstName, lastName, userName, email, phone, password, imgUrl, aadharCardNo;
	private double salary;
	private boolean _isActive;
	private LocalDate dateCreated;
	private MaritalStatus maritalStatus;
	private Gender gender;

	private List<Customer> custList; // added

	private List<Salary> salaryList; // HELPER METHOD
	private List<Subscription> subscriptionList; // HELPER METHOD
	private MaidFeedback maidFeedback;

	public Maid() {
	}

	// Para CTOR added.
	public Maid(String firstName, String lastName, String userName, String email, String phone, String password,
			String imgUrl, String aadharCardNo, double salary, boolean _isActive, LocalDate dateCreated,
			MaritalStatus maritalStatus, Gender gender, List<Salary> salaryList, List<Subscription> subscriptionList) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.imgUrl = imgUrl;
		this.aadharCardNo = aadharCardNo;
		this.salary = salary;
		this._isActive = _isActive;
		this.dateCreated = dateCreated;
		this.maritalStatus = maritalStatus;
		this.gender = gender;
		this.salaryList = salaryList;
		this.subscriptionList = subscriptionList;
	}

	@OneToOne(mappedBy = "maid", cascade = CascadeType.ALL, orphanRemoval = true)
	public MaidFeedback getMaidFeedback() {
		return maidFeedback;
	}

	public void setMaidFeedback(MaidFeedback maidFeedback) {
		this.maidFeedback = maidFeedback;
	}

	@OneToMany(mappedBy = "maid", cascade = CascadeType.ALL, orphanRemoval = true)
	public List<Subscription> getSubscriptionList() {
		return subscriptionList;
	}

	public void setSubscriptionList(List<Subscription> subscriptionList) {
		this.subscriptionList = subscriptionList;
	}

	@OneToMany(mappedBy = "maid", cascade = CascadeType.ALL, orphanRemoval = true)
	public List<Salary> getSalaryList() {
		return salaryList;
	}

	public void setSalaryList(List<Salary> salaryList) {
		this.salaryList = salaryList;
	}

	@OneToMany(mappedBy = "selectedMaid", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	public List<Customer> getCustList() {
		return custList;
	}

	public void setCustList(List<Customer> custList) {
		this.custList = custList;
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
	@Column(length = 30, name = "username", unique = true)
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@NotEmpty
	@Length(min = 5, max = 25)
	@Email(message = "Please Enter Valid Email Address!")
	@Column(length = 35, name = "email", unique = true)
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

	// toString Added
	@Override
	public String toString() {
		return "Maid [firstName=" + firstName + ", lastName=" + lastName + ", userName=" + userName + ", email=" + email
				+ ", phone=" + phone + ", imgUrl=" + imgUrl + ", aadharCardNo=" + aadharCardNo + ", salary=" + salary
				+ ", _isActive=" + _isActive + ", dateCreated=" + dateCreated + ", maritalStatus=" + maritalStatus
				+ ", gender=" + gender + ", salaryList=" + salaryList + ", subscriptionList=" + subscriptionList + "]";
	}

	public void addCustomer(Customer cust) {
		custList.add(cust);
		cust.setSelectedMaid(this);
	}

	public void removeStudent(Customer cust) {
		custList.remove(cust);
		cust.setSelectedMaid(null);
	}

	public void addSalary(Salary sal) {
		salaryList.add(sal);
		sal.setMaid(this);
	}

	public void removeSalary(Salary sal) {
		salaryList.remove(sal);
		sal.setMaid(null);

	}

	public void addSubscription(Subscription sub) {
		subscriptionList.add(sub);
		sub.setMaid(this);

	}

	public void removeSubscription(Subscription sub) {
		subscriptionList.remove(sub);
		sub.setMaid(null);

	}

}
