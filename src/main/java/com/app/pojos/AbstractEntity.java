package com.app.pojos;

import javax.persistence.*;

import org.springframework.data.annotation.Id;

public class AbstractEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int id;
}
//LATEST COMMIT