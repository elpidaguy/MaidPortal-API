/**
 * 
 */
package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.app.dao.ICustomerDao;
import com.app.pojos.Customer;

/**
 * @author Kaustubh
 *
 */

@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	ICustomerDao custDao;
	
	@Override
	public boolean Register(Customer customer) {
		
		Optional<Customer> optional = custDao.findById(customer.getId());
		
		if(optional.isPresent())
		{
			return false;
		}
		
		custDao.save(customer);
		return true;
	}

	@Override
	public Customer Login(Customer customer) {
		Customer cust = new Customer();
		
		cust.setUserName(customer.getUserName());
		cust.setPassword(customer.getPassword());
		
		Example<Customer> exampleuser = Example.of(cust);
		Optional<Customer> optional = custDao.findOne(exampleuser);
		//select * from Customer c where c.username = username and c.password = passweord
		
		if(optional.isPresent())
		{
			return optional.get();
		}
		
		return null;
	}

	@Override
	public Customer getCustomer(Integer id) {
		Optional<Customer> customer = custDao.findById(id);
		
		if(customer.isPresent())
		{
			return customer.get();
		}
		
		return null;
	}

	@Override
	public List<Customer> getAllCustomers() {
		return custDao.findAll();
	}

	//TODO : Please confirm the logic
	@Override
	public boolean updateCustomer(Customer customer) {
		Customer cust = new Customer();
		cust.setId(customer.getId());
		Example<Customer> exampleUser = Example.of(cust);
		Optional<Customer> optional = custDao.findOne(exampleUser);
		
		if(optional.isPresent())
		{
			custDao.save(customer);
			return true;
		}
		return false;
	}

}
