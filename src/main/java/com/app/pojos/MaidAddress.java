package com.app.pojos;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_maid_Address")
public class MaidAddress extends AbstractEntity {

	private String firstName, lastName, addressName, email, buildingName, street, city, state, pin, country, phone;
	private LocalDateTime dateCreated;
	private boolean _isActive;

	private Maid maid;

	public MaidAddress() {
	}

	public MaidAddress(String firstName, String lastName, String addressName, String email, String buildingName,
			String street, String city, String state, String pin, String country, String phone,
			LocalDateTime dateCreated, boolean _isActive, Maid maid) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.addressName = addressName;
		this.email = email;
		this.buildingName = buildingName;
		this.street = street;
		this.city = city;
		this.state = state;
		this.pin = pin;
		this.country = country;
		this.phone = phone;
		this.dateCreated = dateCreated;
		this._isActive = _isActive;
		this.maid = maid;
	}


	//TODO: confirm this if its working or not
	@ManyToOne
	@JoinColumn(name="maid_id")
	public Maid getMaid() {
		return maid;
	}

	public void setMaid(Maid maid) {
		this.maid = maid;
	}

	@Column(name = "first_name")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "last_name")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "address_name")
	public String getAddressName() {
		return addressName;
	}

	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "building_name")
	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public LocalDateTime getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(LocalDateTime dateCreated) {
		this.dateCreated = dateCreated;
	}

	public boolean is_isActive() {
		return _isActive;
	}

	public void set_isActive(boolean _isActive) {
		this._isActive = _isActive;
	}

	@Override
	public String toString() {
		return "Address [firstName=" + firstName + ", lastName=" + lastName + ", addressName=" + addressName
				+ ", email=" + email + ", buildingName=" + buildingName + ", street=" + street + ", city=" + city
				+ ", state=" + state + ", pin=" + pin + ", country=" + country + ", phone=" + phone + ", dateCreated="
				+ dateCreated + ", _isActive=" + _isActive + "]";
	}
}
