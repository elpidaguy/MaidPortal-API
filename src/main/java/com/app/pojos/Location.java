package com.app.pojos;

//@Entity
//@Table(name="location")
public class Location extends AbstractEntity{
	
public Location() {
		super();
	}

public Location(String longitude, String lattitude) {
		super();
		this.longitude = longitude;
		this.lattitude = lattitude;
	}

//	@Column(length = 40)
	public String longitude;
	
//	@Column(length = 40)
	public String lattitude;
	
}
