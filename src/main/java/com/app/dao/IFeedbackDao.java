package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.pojos.Feedback;

@Repository
public interface IFeedbackDao extends JpaRepository<Feedback, Integer> {

}
