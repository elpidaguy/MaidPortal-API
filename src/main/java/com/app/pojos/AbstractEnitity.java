package com.app.pojos;

import javax.persistence.GeneratedValue;
import javax.persistence.*;

@MappedSuperclass
public class AbstractEnitity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer id;
	
	
}
