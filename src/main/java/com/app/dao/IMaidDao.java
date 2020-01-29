package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.app.pojos.Maid;

@Repository
public interface IMaidDao extends JpaRepository<Maid, Integer>, PagingAndSortingRepository<Maid, Integer> {

	@Query("select m from Maid m where m.email = ?1  and m.password = ?2")
	Maid login(String email, String password);

	@Query("select m from Maid m where m.email = ?1")
	Maid getMaidByEmail(String email);

	// public Maid findMaidByEmail(String email);

	/*
	 * @Query(value = "select * from tbl_maids m limit :start , :numberOfRecords",
	 * nativeQuery = true) List<Maid> getMaids(@Param("start") int
	 * start, @Param("numberOfRecords") int numberOfRecords);
	 */
	@Query("select count(m.id) from Maid m")
	int getNumberOfRows();
}
