package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Address;
import com.app.service.IAddressService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/address")
public class AddressController {

	@Autowired
	IAddressService addressService;

	@RequestMapping(value = "/addAddress", method = RequestMethod.POST)
	public ResponseEntity<String> addAddress(@RequestBody Address address) {
		if (addressService.addAddress(address)) {
			return new ResponseEntity<String>("Address added successfully", HttpStatus.OK);
		}
		return new ResponseEntity<String>("Address addition failed", HttpStatus.OK);
	}

	@RequestMapping(value = "/getAddress/{id}")
	public ResponseEntity<?> getAddress(@PathVariable Integer id) {

		Address address = addressService.getAddress(id);
		if (address != null) {
			return new ResponseEntity<Address>(address, HttpStatus.OK);
		}
		return new ResponseEntity<String>("Something went wrong", HttpStatus.OK);
	}

	@RequestMapping(value = "/updateAddress", method = RequestMethod.POST)
	public ResponseEntity<String> updateAddress(@RequestBody Address address) {

		if (addressService.updateAddress(address)) {
			return new ResponseEntity<String>("Address Updated successfully", HttpStatus.OK);
		}
		return new ResponseEntity<String>("Address updation Failed", HttpStatus.OK);
	}

	@RequestMapping(value = "/deleteAddress", method = RequestMethod.POST)
	public ResponseEntity<String> deleteAddress(@RequestBody Address address) {

		if (addressService.deleteAddress(address)) {
			return new ResponseEntity<String>("Address Deleted", HttpStatus.OK);
		}
		return new ResponseEntity<String>("Address deletion failed", HttpStatus.OK);
	}

}
