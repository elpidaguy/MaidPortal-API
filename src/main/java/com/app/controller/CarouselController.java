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

import com.app.pojos.Carousel;
import com.app.service.ICarouselService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/carousel")
public class CarouselController {

	@Autowired
	ICarouselService carouselService;

	@RequestMapping(value = "/getAllCarousel", method = RequestMethod.GET)
	public ResponseEntity<List<Carousel>> getAllCarousel() {

		return new ResponseEntity<List<Carousel>>(carouselService.getAllCarousel(), HttpStatus.OK);
	}

	@RequestMapping(value = "/addCarousel", method = RequestMethod.POST)
	public ResponseEntity<String> addCarousel(@RequestBody Carousel carousel) {

		if (carouselService.addCarousel(carousel)) {
			return new ResponseEntity<String>("Carousel Added Successfully", HttpStatus.OK);
		}
		return new ResponseEntity<String>("Carousel Addition failed", HttpStatus.OK);
	}

	@RequestMapping(value = "/deleteCarousel", method = RequestMethod.POST)
	public ResponseEntity<String> deleteCarousel(@RequestBody Carousel carousel) {

		if (carouselService.deleteCarousel(carousel)) {
			return new ResponseEntity<String>("Carousel Deleted Successfully", HttpStatus.OK);
		}
		return new ResponseEntity<String>("Carousel deletion failed", HttpStatus.OK);
	}

}
