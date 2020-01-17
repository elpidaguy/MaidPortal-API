package com.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IFeedbackDao;
import com.app.pojos.Customer;
import com.app.pojos.Feedback;
import com.app.pojos.Maid;

@Service
public class FeedbackServiceImpl implements IFeedbackService {

	@Autowired
	IFeedbackDao feedbackDao;

	@Override
	public boolean giveFeedback(Feedback feedback, Object obj) {

		if (obj instanceof Customer) {
			((Customer) obj).setFeedback(feedbackDao.save(feedback));
			return true;
		}
		if (obj instanceof Maid) {
			((Maid) obj).setFeedback(feedbackDao.save(feedback));
			return true;
		}
		return false;
	}

	@Override
	public Feedback getFeedback(Integer id) {

		Optional<Feedback> optional = feedbackDao.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

}
