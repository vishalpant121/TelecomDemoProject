package com.demo.telecom.subscriberservice.service;

import com.demo.telecom.subscriberservice.controller.SubscriberServiceController;
import com.demo.telecom.subscriberservice.dto.SubscriberRequest;
import com.demo.telecom.subscriberservice.dto.SubscriberResponse;
import com.demo.telecom.subscriberservice.model.Subscriber;
import com.demo.telecom.subscriberservice.repository.SubscriberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.logging.Logger;

@Service
public class SubscriberServiceImpl implements SubsciberService{

    static private final Logger logger =  Logger.getLogger(SubscriberServiceImpl.class.getName());

    @Autowired
    private SubscriberRepository subscriberRepository;

    @Override
    public void createSubscriber(SubscriberRequest subscriberRequest) {
        Subscriber subscriber = new Subscriber(
                subscriberRequest.getUserName(),
                subscriberRequest.getAvailableData(),
                subscriberRequest.getValidityFrom(),
                subscriberRequest.getValidityTo(),
                subscriberRequest.getCallBalance(),
                subscriberRequest.getRegion()
        );

        try {
            this.subscriberRepository.save(subscriber);
        } catch (Exception exception) {
            logger.severe("Creation error: "+ exception);
        }
    }

    @Override
    public SubscriberResponse getSubscriber(String id) {
        Subscriber subscriber = this.subscriberRepository.findById(id).get();


        return mapEntityToDto(subscriber);
    }

    @Override
    public SubscriberResponse updateSubscriber(SubscriberRequest subscriberRequest) {
        SubscriberResponse subscriberResponse = getSubscriber(subscriberRequest.getSubId());
        if(subscriberResponse == null) {
            // no existing, create new
            createSubscriber(subscriberRequest);
        } else {
            subscriberResponse = new SubscriberResponse(
                    subscriberRequest.getSubId(),
                    subscriberRequest.getUserName(),
                    subscriberRequest.getAvailableData(),
                    subscriberRequest.getValidityFrom(),
                    subscriberRequest.getValidityTo(),
                    subscriberRequest.getCallBalance(),
                    subscriberRequest.getRegion());
        }

        return subscriberResponse;
    }

    @Override
    public int deleteSubscriber(String id) {
        Subscriber subscriber = this.subscriberRepository.findById(id).get();
        this.subscriberRepository.delete(subscriber);
        return 0;
    }

    public SubscriberResponse mapEntityToDto(Subscriber subscriber) {
        return new SubscriberResponse(
                subscriber.getSubId(),
                subscriber.getUserName(),
                subscriber.getAvailableData(),
                subscriber.getValidityFrom(),
                subscriber.getValidityTo(),
                subscriber.getCallBalance(),
                subscriber.getRegion());
    }


}
