/**
 * 
 */
package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Customer;

/**
 * @author Kaustubh
 *
 */
//public interface IUserDao extends JpaRepository<User, Integer>{
//
//	@Query("select c.name from Service c")
//	public List<String> getServiceNames();
//	
//}

public interface ICustomerDao extends JpaRepository<Customer, Integer> {
	
}