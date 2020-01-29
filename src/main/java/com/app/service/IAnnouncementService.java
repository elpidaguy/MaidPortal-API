package com.app.service;

import java.util.List;

import com.app.pojos.Announcement;

public interface IAnnouncementService {

	public List<Announcement> getAllAnnouncement();

	public boolean addAnnouncement(Announcement announcement);

	public boolean deleteAnnouncement(Announcement announcement);

}
