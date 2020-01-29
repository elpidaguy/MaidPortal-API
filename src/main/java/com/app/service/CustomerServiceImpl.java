package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.app.dao.ICustomerDao;
import com.app.pojos.Customer;

@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	ICustomerDao custDao;

	@Override
	public boolean register(Customer customer) {

		Optional<Customer> optional = custDao.findById(customer.getId());

		if (optional.isPresent()) {
			return false;
		}

		custDao.save(customer);
		return true;
	}

	@Override
	public Customer login(String email, String password) {
		/*
		 * Customer cust = new Customer();
		 * 
		 * cust.setUserName(customer.getUserName());
		 * cust.setPassword(customer.getPassword()); cust.set_isActive(true);
		 * 
		 * Example<Customer> exampleuser = Example.of(cust); Optional<Customer> optional
		 * = custDao.findOne(exampleuser);
		 */
		// select * from Customer c where c.username = username and c.password =
		// passweord

		Customer customer = custDao.login(email, password);
		if (customer != null) {
			return customer;
		}

		return null;
	}

	@Override
	public Customer getCustomer(Integer id) {
		Optional<Customer> customer = custDao.findById(id);

		if (customer.isPresent()) {
			return customer.get();
		}

		return null;
	}

	/*
	 * @Override public List<Customer> getAllCustomers() { return custDao.findAll();
	 * }
	 */

	// TODO : Please confirm the logic
	@Override
	public boolean updateCustomer(Customer customer) {
		/*
		 * Customer cust = new Customer(); cust.setId(customer.getId());
		 * Example<Customer> exampleUser = Example.of(cust);
		 */

		// If we have id then use findById method
		Optional<Customer> optional = custDao.findById(customer.getId());

		if (optional.isPresent()) {
			custDao.save(customer);
			return true;
		}
		return false;
	}

	@Override
	public boolean resetPassword(String email, String newPassword) {

		Customer customer = custDao.getCustomerByEmail(email);
		// System.out.println("customer tracked :\n"+customer.toString());
		Optional<Customer> optional = custDao.findById(customer.getId());
		if (optional.isPresent()) {
			optional.get().setPassword(newPassword);
			System.out.println("Optional Reset" + optional.get());
			custDao.save(optional.get());
			return true;
		}
		return false;
	}

	// TODO : Please confirm the logic
	@Override
	public boolean deleteCustomer(Customer customer) {
		/*
		 * Customer cust = new Customer(); cust.setId(customer.getId());
		 * Example<Customer> exampleUser = Example.of(cust);
		 */
		Optional<Customer> optional = custDao.findById(customer.getId());
		if (optional.isPresent()) {
			optional.get().set_isActive(false);
			custDao.save(optional.get());
			return true;
		}
		return false;
	}

	@Override
	public Customer getCustomerByEmail(String email) {
		Customer customer = new Customer();
		customer.setEmail(email);
		customer.set_isActive(true);
		Example<Customer> example = Example.of(customer);
		Optional<Customer> optional = custDao.findOne(example);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public List<Customer> getAllCustomers(Integer pageNo, Integer pageSize, String sortBy, String searchBy) {

		Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
		Page<Customer> pagedResult = custDao.findAll(paging);
		if (pagedResult.hasContent()) {
			return pagedResult.getContent();
		}
		return null;
	}

	@Override
	public int getNumberOfRows() {

		return custDao.getNumberOfRows();
	}

}
