package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IAnnouncementDao;
import com.app.pojos.Announcement;

@Service
public class AnnouncementServiceImpl implements IAnnouncementService {

	@Autowired
	IAnnouncementDao announcementDao;

	@Override
	public List<Announcement> getAllAnnouncement() {

		return announcementDao.findAll();
	}

	@Override
	public boolean addAnnouncement(Announcement announcement) {

		Optional<Announcement> optional = announcementDao.findById(announcement.getId());
		if (optional.isPresent()) {
			return false;
		}
		announcementDao.save(announcement);
		return true;
	}

	@Override
	public boolean deleteAnnouncement(Announcement announcement) {

		Optional<Announcement> optional = announcementDao.findById(announcement.getId());
		if (optional.isPresent()) {
			optional.get().setIs_Deleted(true);
			announcementDao.save(optional.get());
			return true;
		}
		return false;
	}

}
