package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.pojos.Announcement;

@Repository
public interface IAnnouncementDao extends JpaRepository<Announcement, Integer> {

	@Query("select a from Announcement a where a.is_Deleted = false")
	List<Announcement> getAllAnnouncement();
	
}
