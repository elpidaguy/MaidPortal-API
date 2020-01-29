package com.app.service;

import java.util.List;

import com.app.pojos.Carousel;

public interface ICarouselService {

	public List<Carousel> getAllCarousel();

	public boolean addCarousel(Carousel carousel);

	public boolean deleteCarousel(Carousel carousel);

}
