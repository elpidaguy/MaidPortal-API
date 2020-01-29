package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Announcement;
import com.app.service.IAnnouncementService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/announcement")
public class AnnouncementController {

	@Autowired
	IAnnouncementService announcementService;

	@RequestMapping(value = "/getAllAnnouncement", method = RequestMethod.GET)
	public ResponseEntity<List<Announcement>> getAllAnnouncement() {

		return new ResponseEntity<List<Announcement>>(announcementService.getAllAnnouncement(), HttpStatus.OK);
	}

	@RequestMapping(value = "/addAnnouncement", method = RequestMethod.POST)
	public ResponseEntity<String> addAnnouncement(@RequestBody Announcement announcement) {

		if (announcementService.addAnnouncement(announcement)) {
			return new ResponseEntity<String>("Announcement added successfully", HttpStatus.OK);
		}
		return new ResponseEntity<String>("Announcement addition failed", HttpStatus.OK);
	}

	@RequestMapping(value = "/deleteAnnouncement", method = RequestMethod.POST)
	public ResponseEntity<String> deleteAnnouncement(@RequestBody Announcement announcement) {

		if (announcementService.deleteAnnouncement(announcement)) {
			return new ResponseEntity<String>("Announcement deleted", HttpStatus.OK);
		}
		return new ResponseEntity<String>("Announcement deletion failed", HttpStatus.OK);
	}

}
