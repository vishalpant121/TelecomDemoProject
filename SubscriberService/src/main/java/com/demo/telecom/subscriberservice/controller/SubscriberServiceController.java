package com.demo.telecom.subscriberservice.controller;

import com.demo.telecom.subscriberservice.dto.SubscriberRequest;
import com.demo.telecom.subscriberservice.dto.SubscriberResponse;
import com.demo.telecom.subscriberservice.service.SubsciberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.logging.Logger;

@RestController
@RequestMapping("/subs")
public class SubscriberServiceController {

    static private final Logger logger =  Logger.getLogger(SubscriberServiceController.class.getName());

    @Autowired
    private SubsciberService subsciberService;

    @GetMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public SubscriberResponse getSubscriber(@RequestParam("id") String id) {
        SubscriberResponse subscriberResponse = this.subsciberService.getSubscriber(id);
        logger.info(subscriberResponse.toString());
        return subscriberResponse;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    void createSubscriber(@RequestBody SubscriberRequest subscriberRequest) {
        try {
            this.subsciberService.createSubscriber(subscriberRequest);
        } catch (Exception exception){
            logger.severe("Exception Occurred during creation of Subscriber: " + exception);
        }
    }




    @PutMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.ACCEPTED)
    SubscriberResponse updateSubscriber(@RequestBody SubscriberRequest subscriberRequest) {
        try {
            return this.subsciberService.updateSubscriber(subscriberRequest);
        } catch (Exception exception){
            logger.severe("Exception Occurred during updating Subscriber: " + exception);
            return null;
        }
    }


    @DeleteMapping("/subs")
    @ResponseStatus(HttpStatus.OK)
    void deleteSubscriber(@RequestParam("id") String id) {
        try {
            int result = this.subsciberService.deleteSubscriber(id);
            logger.info("deletion result code" + result);
        } catch (Exception exception) {
            logger.severe("Exception Occurred during deletion of Subscriber: " + exception);
        }
    }
}
