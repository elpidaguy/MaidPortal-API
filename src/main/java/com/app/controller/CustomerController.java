/**
 * 
 */
package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Customer;
import com.app.service.ICustomerService;

/**
 * @author Kaustubh
 *
 */

@RestController
public class CustomerController {

	@Autowired
	ICustomerService service;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<?> login(@RequestBody Customer customer)
	{
		Customer temp = service.Login(customer);
		
		if(temp != null)
		{
			return new ResponseEntity<Customer>(temp, HttpStatus.OK);
		}
		
		return new ResponseEntity<String>("Authentication Failed", HttpStatus.OK);
	}
}
