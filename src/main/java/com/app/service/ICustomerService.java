package com.app.service;

import java.util.List;

import com.app.pojos.Customer;

public interface ICustomerService {

	public boolean register(Customer customer);

	public Customer login(String email, String password);

	public Customer getCustomer(Integer id);

	public Customer getCustomerByEmail(String email);

	// public List<Customer> getAllCustomers();

	public List<Customer> getAllCustomers(Integer pageNo, Integer pageSize, String sortBy, String searchBy);

	public boolean updateCustomer(Customer customer);

	public boolean deleteCustomer(Customer customer);

	public int getNumberOfRows();

	public boolean resetPassword(String email, String newPassword);

//	public Customer Login(String username, String password); //with string username pass

}
