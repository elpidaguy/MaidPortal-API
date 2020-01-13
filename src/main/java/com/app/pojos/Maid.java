package com.app.pojos;

import javax.persistence.*;
 
import javax.validation.constraints.*;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name="tbl_users")
public class Maid extends AbstractEnitity {

	@Column(length = 30,unique = true)
	public String name;
	
	@NotEmpty
	@Length(min = 5, max = 20)
	@Email(message = "Invalid Email format")
	@Column(length = 30)
	public String email;
	
	@Column(length = 30)
	public String phoneNo;
	
	@Pattern(regexp = "((?=.*\\d)(?=.*[a-z])(?=.*[#@$*]).{5,20})", message = "Invalid Password")
	@Column(length = 30)
	public String password;
	
	@Column(length = 30)
	public int adharCardNo;
	
	///Look upon This
	@Column(length = 30)
	public int address_id;
	
	@Column
	public Location location;
	
	@Column(length = 30)
	public String maritalStatus;
	//public MaritalStatus maritalStatus;	//ENum 

	@Lob
	public byte[] image;
	
	@Column
	public Gender gender;
	
	@Column(length = 40)
	public double salary;
	
	@Column
	public boolean _isActive;
	
}
