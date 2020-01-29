package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.ICarouselDao;
import com.app.pojos.Carousel;

@Service
public class CarouselServiceImpl implements ICarouselService {

	@Autowired
	ICarouselDao carouselDao;

	@Override
	public List<Carousel> getAllCarousel() {

		return carouselDao.findAll();
	}

	@Override
	public boolean addCarousel(Carousel carousel) {

		Optional<Carousel> optional = carouselDao.findById(carousel.getId());
		if (optional.isPresent()) {
			return false;
		}
		carouselDao.save(carousel);
		return true;
	}

	@Override
	public boolean deleteCarousel(Carousel carousel) {

		Optional<Carousel> optional = carouselDao.findById(carousel.getId());
		if (optional.isPresent()) {
			optional.get().setIs_Deleted(true);
			carouselDao.save(optional.get());
			return true;
		}
		return false;
	}

}
