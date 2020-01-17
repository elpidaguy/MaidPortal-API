package com.app.service;

import com.app.pojos.Address;

public interface IAddressService {

	public boolean addAddress(Address address);
	public Address getAddress(Integer id);
	public boolean updateAddress(Address address);
	public boolean deleteAddress(Address address);
}
