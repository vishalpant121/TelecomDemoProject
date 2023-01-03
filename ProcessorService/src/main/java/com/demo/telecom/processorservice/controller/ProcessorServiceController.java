package com.demo.telecom.processorservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@RequestMapping("/process")
public class ProcessorServiceController {

    static private final Logger logger =  Logger.
            getLogger(ProcessorServiceController.class.getName());


    /* Do we need it here?
    @GetMapping

    public void checkSessionAvailability(@RequestParam("sessionID") String id) {

    }*/


    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String tryget(@RequestParam String string) {
        System.out.println("We received some traffic" + string);

        return string + "Whoa";
        //eventually we want to respond success if received proper input
        // and then process the input (like data change)
        // and store the change in storage db
        // if we want to inform of the change to user, call api of loadbalancer
    }

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String receiveTraffic(@RequestBody Object obj) {
        System.out.println("We received some traffic" + obj.toString());

        return "acknowledged";
        //eventually we want to respond success if received proper input
        // and then process the input (like data change)
        // and store the change in storage db
        // if we want to inform of the change to user, call api of loadbalancer
    }
}
