package com.app.pojos;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class AbstractEntity implements Serializable {
	
private Integer id;
	
	public AbstractEntity() {
		System.out.println("inside abstract entity");
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(updatable = false, nullable = false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
}
