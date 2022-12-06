package com.demo.telecom.loadbalancerservice.controller;

import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

@RestController
@RequestMapping("/lb")
public class LoadBalancerServiceController {

    static private final Logger logger =  Logger.
            getLogger(LoadBalancerServiceController.class.getName());

    public static RestTemplate restTemplate = new RestTemplate();
    static String baseUrl = "http://localhost:8082/process";


    /* Do we need it here?
    @GetMapping

    public void checkSessionAvailability(@RequestParam("sessionID") String id) {

    }*/


    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String receiveTraffic(@RequestBody Object obj) {
        System.out.println("We received some traffic" + obj.toString());
        //now we want to send this traffic to processorservice
        // for now we are sending same data to processorservice i.e. no applying any loadbalance logic


        return useExchangeMethodsOfRestTemplate(obj);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String trygetLb(@RequestParam String string) {
        System.out.println("We received some traffic which we send to processor, T:" + string);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Object> requestEntity = new HttpEntity<>(headers);

        HttpEntity<?> entity = new HttpEntity<>(headers);

        String urlTemplate = UriComponentsBuilder.fromHttpUrl(baseUrl )
                .queryParam("string", string)
                .encode()
                .toUriString();

        Map<String, String> params = new HashMap<>();
        params.put("string", string);


   /*     HttpEntity<String> response = restOperations.exchange(
                urlTemplate,
                HttpMethod.GET,
                entity,
                String.class,
                params
        );*/

        ResponseEntity<String> responseEntity =
                restTemplate.exchange(urlTemplate, HttpMethod.GET, requestEntity, String.class);


        HttpStatus statusCode = responseEntity.getStatusCode();
        System.out.println("status code - " + statusCode);
        String userDetails = responseEntity.getBody();
        System.out.println("response body - " + userDetails);
        HttpHeaders responseHeaders = responseEntity.getHeaders();
        System.out.println("response Headers - " + responseHeaders);

        return responseEntity.getBody();
    }


    private static String useExchangeMethodsOfRestTemplate(Object obj) {


        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();

        body.add("object", obj);

// Note the body object as first parameter!
        HttpEntity<?> httpEntity = new HttpEntity<Object>(body, headers);

        ResponseEntity<String> responseEntity = restTemplate.exchange(baseUrl, HttpMethod.POST, httpEntity, String.class);


        HttpStatus statusCode = responseEntity.getStatusCode();
        System.out.println("status code - " + statusCode);
        String userDetails = responseEntity.getBody();
        System.out.println("response body - " + userDetails);
        HttpHeaders responseHeaders = responseEntity.getHeaders();
        System.out.println("response Headers - " + responseHeaders);

        return responseEntity.getBody();
    }

}