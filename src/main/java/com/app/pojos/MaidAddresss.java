package com.app.pojos;

import javax.persistence.*;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class MaidAddresss extends AbstractEntity{

	private Maid maid;	//should we have user here too..
	private String street,apartment,landmark,city,state,email,contact;
	//private String country;	//Being Optimistic
	private int pin;
	private boolean _isActive;
	
	
	public MaidAddresss() {
		super();
	}


	public MaidAddresss(Maid maid, String street, String apartment, String landmark, String city, String state,
			String email, String contact, int pin, boolean _isActive) {
		super();
		this.maid  = maid;
		this.street = street;
		this.apartment = apartment;
		this.landmark = landmark;
		this.city = city;
		this.state = state;
		this.email = email;
		this.contact = contact;
		this.pin = pin;
		this._isActive = _isActive;
	}

	@ManyToOne
	@JoinColumn(name="maid_id")
	public Maid getMaid() {
		return maid;
	}


	public void setMaid(Maid maid) {
		this.maid = maid;
	}

	@NotNull
	public String getStreet() {
		return street;
	}


	public void setStreet(String street) {
		this.street = street;
	}

	@NotNull
	public String getApartment() {
		return apartment;
	}


	public void setApartment(String apartment) {
		this.apartment = apartment;
	}

	@NotNull
	public String getLandmark() {
		return landmark;
	}


	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	@NotNull
	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}

	@NotNull
	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}

	@NotEmpty
	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	
	public String getContact() {
		return contact;
	}


	public void setContact(String contact) {
		this.contact = contact;
	}

	@NotNull
	public int getPin() {
		return pin;
	}


	public void setPin(int pin) {
		this.pin = pin;
	}


	public boolean is_isActive() {
		return _isActive;
	}


	public void set_isActive(boolean _isActive) {
		this._isActive = _isActive;
	}


	@Override
	public String toString() {
		return "MaidAddresss [user=" + maid.toString() + ", street=" + street + ", apartment=" + apartment + ", landmark="
				+ landmark + ", city=" + city + ", state=" + state + ", email=" + email + ", contact=" + contact
				+ ", pin=" + pin + ", _isActive=" + _isActive + "]";
	}
	
	
	
	
	

}
