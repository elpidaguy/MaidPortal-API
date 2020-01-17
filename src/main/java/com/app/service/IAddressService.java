package com.app.service;

import com.app.pojos.Address;
import com.app.pojos.Customer;

public interface IAddressService {

	public boolean addAddress(Address address,Customer customer);
	public Address getAddress(Integer id);
	public boolean updateAddress(Address address,Customer customer);
	public boolean deleteAddress(Address address,Customer customer);
}
