package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.pojos.Maid;

@Repository
public interface IMaidDao extends JpaRepository<Maid, Integer> {

	@Query("select m from Maid m where m.userName = ?1  and m.password = ?2")
	Maid loginMaid(String username, String password);
}
