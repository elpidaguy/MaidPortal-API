/**
 * 
 */
package com.app.service;

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
		// TODO : Need to wrire register code
		return false;
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

}
