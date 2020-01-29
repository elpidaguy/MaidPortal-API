package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.pojos.Carousel;

@Repository
public interface ICarouselDao extends JpaRepository<Carousel, Integer> {

}
