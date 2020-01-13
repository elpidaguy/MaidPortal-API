package com.app.pojos;

import javax.persistence.*;

@Entity
@Table(name="tbl_Address")
public class Address extends AbstractEnitity{

	@Column(length = 30)
	public String name;
	
	@Column(length = 30)
	public String street;
	
	@Column(length = 30)
	public String buildingName;
	
	@Column(length = 30)
	public String landmark;
	
	@Column(length = 30)
	public String city;
	
	@Column(length = 30)
	public String pin;
	
	@Column(length = 30)
	public String email;
	
	@Column(length = 30)
	public String Contact;
	
	@Column(length = 30)
	public String latitude;
	
	@Column(length = 30)
	public String Longitude;
	
	@Column(length = 30)
	public boolean _isActive;
	
	@Column(length = 30)
	public int user_type_id;
}
