package com.demo.telecom.subscriberservice.service;

import com.demo.telecom.subscriberservice.dto.SubscriberRequest;
import com.demo.telecom.subscriberservice.dto.SubscriberResponse;
import com.demo.telecom.subscriberservice.model.Subscriber;
import org.springframework.stereotype.Service;


public interface SubsciberService {

    void createSubscriber(SubscriberRequest subscriberRequest);

    SubscriberResponse getSubscriber(String id);

    SubscriberResponse updateSubscriber(SubscriberRequest subscriberRequest);

    int deleteSubscriber(String id);

}
