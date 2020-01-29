/**
 * 
 */
package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.app.pojos.Customer;

//public interface IUserDao extends JpaRepository<User, Integer>{
//
//	@Query("select c.name from Service c")
//	public List<String> getServiceNames();
//	
//}

@Repository
public interface ICustomerDao extends JpaRepository<Customer, Integer>, PagingAndSortingRepository<Customer, Integer> {

	@Query("select c from Customer c where c.email = ?1  and c.password = ?2")
	Customer login(String email, String password);

	@Query("select count(c.id) from Customer c")
	int getNumberOfRows();

	@Query("select c from Customer c where c.email = ?1")
	Customer getCustomerByEmail(String email);

}