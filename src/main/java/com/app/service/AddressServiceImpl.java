package com.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.app.dao.IAddressDao;
import com.app.pojos.Address;
import com.app.pojos.Customer;

@Service
public class AddressServiceImpl implements IAddressService {

	@Autowired
	IAddressDao addressDao;

	@Override
	public boolean addAddress(Address address, Customer customer) {

		Optional<Address> optional = addressDao.findById(address.getId());
		if (optional.isPresent()) {
			return false;
		}
		customer.setAddress(addressDao.save(address));
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
	public boolean updateAddress(Address address, Customer customer) {

		Address add = new Address();
		add.setId(address.getId());
		Example<Address> example = Example.of(add);
		Optional<Address> optional = addressDao.findOne(example);
		if (optional.isPresent()) {
			customer.setAddress(addressDao.save(address));
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteAddress(Address address, Customer customer) {

		Address add = new Address();
		add.setId(address.getId());
		Example<Address> example = Example.of(add);
		Optional<Address> optional = addressDao.findOne(example);
		if (optional.isPresent()) {
			address.set_isActive(false);
			customer.setAddress(addressDao.save(address));
			return true;
		}
		return false;
	}

}
