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
	
	public boolean Register(Customer customer);
	public Customer Login(Customer customer);
	public Customer getCustomer(Integer id);
	public List<Customer> getAllCustomers();
	public boolean updateCustomer(Customer customer);
	public boolean deleteCustomer(Customer customer);
//	public Customer Login(String username, String password); //with string username pass

}
