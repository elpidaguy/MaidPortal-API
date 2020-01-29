package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.pojos.Announcement;

@Repository
public interface IAnnouncementDao extends JpaRepository<Announcement, Integer> {

}
