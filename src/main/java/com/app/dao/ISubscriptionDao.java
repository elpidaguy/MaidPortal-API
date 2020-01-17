package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.pojos.Subscription;

@Repository
public interface ISubscriptionDao extends JpaRepository<Subscription, Integer> {

}
