/**
 * 
 */
package com.app.service;

import com.app.pojos.Customer;

/**
 * @author Kaustubh
 *
 */
public interface ICustomerService {
	
	public boolean Register(Customer customer);
	public Customer Login(Customer customer);
//	public Customer Login(String username, String password); //with string username pass

}
