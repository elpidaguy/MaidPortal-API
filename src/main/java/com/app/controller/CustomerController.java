/**
 * 
 */
package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	ICustomerService service;
	
	@RequestMapping(value = "/getAllCustomers", method = RequestMethod.GET)
	public ResponseEntity<?> getAllCustomers()
	{
		return new ResponseEntity<List<Customer>>(service.getAllCustomers(),HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getCustomer", method = RequestMethod.POST)
	public ResponseEntity<?> getCustomer(@RequestBody Integer id)
	{
		Customer temp = service.getCustomer(id);
		
		if(temp != null)
		{
			return new ResponseEntity<Customer>(temp, HttpStatus.OK);
		}	
		
		return new ResponseEntity<String>("Customer Not Found",HttpStatus.OK);
	}
	
	@RequestMapping(value = "/updateCustomer", method = RequestMethod.POST)
	public ResponseEntity<?> updateCustomer(@RequestBody Customer cust)
	{
		boolean _isUpdate = service.updateCustomer(cust);
		
		if(_isUpdate)
		{
			return new ResponseEntity<Boolean>(true, HttpStatus.OK);
		}	
		
		return new ResponseEntity<String>("Customer Not Found",HttpStatus.OK);
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<?> login(@RequestBody Customer customer)
	{
		Customer temp = service.Login(customer);
		
		if(temp != null)
		{
			return new ResponseEntity<Customer>(temp, HttpStatus.OK);
		}
		
		return new ResponseEntity<String>("Incorrect Username/Password!", HttpStatus.OK);
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<?> register(@RequestBody Customer customer)
	{
		
		if(service.Register(customer))
		{
			return new ResponseEntity<String>("Register Successfully", HttpStatus.OK);
		}
		
		return new ResponseEntity<String>("Something went wrong!!", HttpStatus.OK);
	}
}
