package com.app.pojos;

import javax.persistence.GeneratedValue;
import javax.persistence.*;

@MappedSuperclass
public class AbstractEntity {
	
private Integer id;
	
	public AbstractEntity() {
		System.out.println("inside abstract entity");
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
}
