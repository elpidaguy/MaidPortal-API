package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Admin;
import com.app.pojos.Customer;
import com.app.pojos.Maid;
import com.app.pojos.UserType;
import com.app.service.IAdminService;
import com.app.service.ICustomerService;
import com.app.service.IMaidService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	IAdminService adminService;

	@Autowired
	ICustomerService customerService;

	@Autowired
	IMaidService maidService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<?> login(@RequestParam String email, @RequestParam String password,

			@RequestParam String userType) {

		if (userType.equalsIgnoreCase(UserType.ADMIN.toString())) {
			Admin admin = adminService.login(email, password);
			if (admin != null) {
				return new ResponseEntity<Admin>(admin, HttpStatus.OK);
			}
		}

		if (userType.equalsIgnoreCase(UserType.CUSTOMER.toString())) {
			Customer customer = customerService.login(email, password);
			if (customer != null) {
				return new ResponseEntity<Customer>(customer, HttpStatus.OK);
			}
		}

		if (userType.equalsIgnoreCase(UserType.MAID.toString())) {
			Maid maid = maidService.login(email, password);
			if (maid != null) {
				return new ResponseEntity<Maid>(maid, HttpStatus.OK);
			}
		}

		return new ResponseEntity<String>("Invalid Email and password", HttpStatus.OK);
	}

	// TODO: Need to ask sir

	/*
	 * @RequestMapping(value = "/login", method = RequestMethod.POST) public
	 * ResponseEntity<?> login(@RequestBody Object obj, @RequestParam String
	 * userType) {
	 * 
	 * if (userType.equalsIgnoreCase(UserType.ADMIN.toString())) { Admin temp =
	 * (Admin) obj; Admin admin = adminService.login(temp.getEmail(),
	 * temp.getPassword()); if (admin != null) { return new
	 * ResponseEntity<Admin>(admin, HttpStatus.OK); } }
	 * 
	 * if (userType.equalsIgnoreCase(UserType.CUSTOMER.toString())) { //Customer
	 * temp = Customer.class.cast(obj); Customer temp1 =(Customer) obj; Customer
	 * customer = customerService.login(temp1.getEmail(), temp1.getPassword()); if
	 * (customer != null) { return new ResponseEntity<Customer>(customer,
	 * HttpStatus.OK); } }
	 * 
	 * if (userType.equalsIgnoreCase(UserType.MAID.toString())) { Maid temp = (Maid)
	 * obj; Maid maid = maidService.login(temp.getEmail(), temp.getPassword()); if
	 * (maid != null) { return new ResponseEntity<Maid>(maid, HttpStatus.OK); } }
	 * 
	 * return new ResponseEntity<String>("Invalid Email and password",
	 * HttpStatus.OK); }
	 */
}
