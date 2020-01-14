package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="location")
public class Location extends AbstractEntity{
	
	@Column(length = 40)
	public String longitude;
	
	@Column(length = 40)
	public String lattitude;
	
}
