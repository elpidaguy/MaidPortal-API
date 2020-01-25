/**
 * 
 */
package com.app.service;

import java.util.List;

import com.app.pojos.Customer;

/**
 * @author Kaustubh
 *
 */
public interface ICustomerService {

	public boolean register(Customer customer);

	public Customer login(Customer customer);

	public Customer getCustomer(Integer id);

	public Customer getCustomerByEmail(String email);

	// public List<Customer> getAllCustomers();
	
	public List<Customer> getAllCustomers(Integer pageNo, Integer pageSize, String sortBy, String searchBy);

	public boolean updateCustomer(Customer customer);

	public boolean deleteCustomer(Customer customer);
	
	public int getNumberOfRows();
	
//	public Customer Login(String username, String password); //with string username pass

}
