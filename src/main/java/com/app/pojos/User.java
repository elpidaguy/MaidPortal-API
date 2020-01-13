package com.app.pojos;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;


@Entity
@Table(name="tbl_users")
public class User {

	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 public Integer id;
	 
	 @NotEmpty
	 @Column(length = 30)
	 public String name;
	 
	@NotEmpty
	@Length(min = 5, max = 20)
	@Email(message = "Invalid Email format")
	@Column(length = 30)
	 public String email;
	 
	 @Column(length=40)
	 @NotEmpty
	 public String phoneNo;

	 @Column
	 @NotEmpty
	 @Pattern(regexp = "((?=.*\\d)(?=.*[a-z])(?=.*[#@$*]).{5,20})", message = "Invalid Password")
	 public String password;
	 
	 @Column
	 @NotEmpty
	 public int adharCardNo;
	 
	 //@Column
	 //public String address;
	 //CHECK Address Entry To It using int Id of address table
	 
	 @Column
	 @NotEmpty
	public Address address;
	 
	@Column(length = 40)
	@NotEmpty
	public String maritalStatus;
	
	@Column
	@NotEmpty
	public Gender gender;
	
	@Column
	public boolean isActive;
	
	
/*	@Column
	public Enum Role;*/
}
