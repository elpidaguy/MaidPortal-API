package com.app.service;

import com.app.pojos.Feedback;

public interface IFeedbackService {

	public boolean giveFeedback(Feedback feedback,Object obj);
	public Feedback getFeedback(Integer id);
	
}
