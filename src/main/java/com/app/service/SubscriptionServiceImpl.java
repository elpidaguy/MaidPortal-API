package com.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.app.dao.ISubscriptionDao;
import com.app.pojos.Subscription;

@Service
public class SubscriptionServiceImpl implements ISubscritionService {

	@Autowired
	ISubscriptionDao subscriptionDao;

	@Override
	public boolean changeSubscription(Subscription subscription) {

		Subscription s = new Subscription();
		s.setId(subscription.getId());
		Example<Subscription> example = Example.of(s);
		Optional<Subscription> optional = subscriptionDao.findOne(example);
		if (optional.isPresent()) {
			subscriptionDao.save(subscription);
			return true;
		}
		return false;
	}

}
