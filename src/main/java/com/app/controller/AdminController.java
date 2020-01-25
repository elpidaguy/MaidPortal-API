/**
 * 
 */
package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Customer;
import com.app.pojos.Maid;
import com.app.service.ICustomerService;
import com.app.service.IMaidService;

/**
 * @author Kaustubh
 *
 */

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	ICustomerService customerService;
	
	@Autowired
	IMaidService maidService;
	
	//Customer services
	
	@RequestMapping(value = "/deleteCustomer", method = RequestMethod.POST)
	public ResponseEntity<?> deleteCustomer(@RequestBody Customer cust)
	{
		boolean _isDeleted = customerService.deleteCustomer(cust);
		
		if(_isDeleted)
		{
			return new ResponseEntity<Boolean>(true, HttpStatus.OK);
		}	
		
		return new ResponseEntity<String>("Customer Not Found",HttpStatus.OK);
	}
	
	
	
	//Maid services
	@RequestMapping(value = "/deleteMaid", method = RequestMethod.POST)
	public ResponseEntity<?> deleteMaid(@RequestBody Maid maid) {
		boolean _isDeleted = maidService.deleteMaid(maid);
		if (_isDeleted) {
			return new ResponseEntity<Boolean>(true, HttpStatus.OK);
		}

		return new ResponseEntity<String>("Maid Not Found", HttpStatus.OK);
	}
	
}
