package com.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IAddressDao;
import com.app.pojos.Address;

@Service
public class AddressServiceImpl implements IAddressService {

	@Autowired
	IAddressDao addressDao;

	@Override
	public boolean addAddress(Address address) {

		Optional<Address> optional = addressDao.findById(address.getId());
		if (optional.isPresent()) {
			return false;
		}
		addressDao.save(address);
		return true;
	}

	@Override
	public Address getAddress(Integer id) {

		Optional<Address> optional = addressDao.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public boolean updateAddress(Address address) {

		Optional<Address> optional = addressDao.findById(address.getId());
		if (optional.isPresent()) {
			addressDao.save(address);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteAddress(Address address) {

		/*
		 * Address add = new Address(); add.setId(address.getId());
		 * add.set_isActive(true); Example<Address> example = Example.of(add);
		 * Optional<Address> optional = addressDao.findOne(example);
		 */
		Optional<Address> optional = addressDao.findById(address.getId());
		if (optional.isPresent()) {
			optional.get().set_isActive(false);
			addressDao.save(optional.get());
			return true;
		}
		return false;
	}

}
