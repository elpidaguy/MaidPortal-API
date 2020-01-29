package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.pojos.Admin;

@Repository
public interface IAdminDao extends JpaRepository<Admin, Integer> {

	@Query("select a from Admin a where a.email = ?1 and a.password = ?2")
	Admin loginAdmin(String email, String password);

}
