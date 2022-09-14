package com.demo.telecom.subscriberservice.repository;

import com.demo.telecom.subscriberservice.model.Subscriber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// @Repository
public interface SubscriberRepository extends JpaRepository<Subscriber, String> {
}
